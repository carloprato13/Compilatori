package ast;

import exception.UndeclaredVarException;
import java.util.ArrayList;
import util.Environment;
import util.SemanticError;

public class IdNode implements Node {

    private final String id;
    private STentry entry;
    private int nestinglevel;
    private int thisNestLevel;
    private int fieldOffset;

    public IdNode(String i) {
        id = i;
    }

    public STentry getSTentry() {
        return entry;
    }

    @Override
    public String toPrint(String s) {
        return s + "Id:" + id + "\n";
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> res = new ArrayList<>();
        int j = env.getNestingLevel();
        STentry tmp = null;

        while (j >= 0 && tmp == null) {
            tmp = (env.getHashMap(j--)).get(id);
        }
        if (tmp == null) {
            res.add(new SemanticError("Id " + id + " not declared"));
            return res;
        } else {
            entry = tmp;
            nestinglevel = env.getNestingLevel();
        }

        try {
            if (entry.isAttribute()) {
                STentry thisPointer = env.getLatestEntryOfNotFun("this");
                thisNestLevel = thisPointer.getNestinglevel();
                fieldOffset = ((InstanceTypeNode) thisPointer.getNode()).getClassType().getOffsetOfField(id);
            }
            this.nestinglevel = env.getNestingLevel();

            if (this.entry.getNode() instanceof InstanceTypeNode) {
                InstanceTypeNode decType = (InstanceTypeNode) this.entry.getNode();
                res.addAll(decType.updateClassType(env));
            }

        } catch (UndeclaredVarException e) {
            res.add(new SemanticError("undeclared variable  " + id + " e:" + e.getMessage()));
        }

        return res;
    }

    @Override
    public Node typeCheck() {
        if (!(entry.getNode() instanceof ArrowTypeNode || entry.getNode() instanceof BoolTypeNode || entry.getNode() instanceof ClassTypeNode)) {
            System.out.println("Wrong usage of function identifier");
        }
        return entry.getNode();
    }

    @Override
    public String codeGeneration() {
        StringBuilder getARs = new StringBuilder();
        if (this.entry.isAttribute()) {
            for (int i = 0; i < nestinglevel - thisNestLevel; i++) {
                getARs.append("lw\n");
            }
            return "push " + (fieldOffset) + "\n"
                    + // metto l'offset (logico) sullo stack
                    "push " + MethodCallNode.getCaller() + "\n"
                    + "lfp\n" + getARs
                    + "add\n"
                    + "lw\n"
                    + "add\n"
                    + "lw\n"; //carico sullo stack il valore all'indirizzo ottenuto
        } else {
            String getAR = "";
            for (int i = 0; i < nestinglevel - entry.getNestinglevel(); i++) {
                getAR += "lw\n";
            }
            return "push " + entry.getOffset() + "\n"
                    + //metto offset sullo stack
                    "lfp\n" + getAR
                    + //risalgo la catena statica
                    "add\n"
                    + "lw\n"; //carico sullo stack il valore all'indirizzo ottenuto
        }
    }

    @Override
    public boolean isSubTypeOf(Node m) {
        return entry.getNode().isSubTypeOf(m);
    }

}

