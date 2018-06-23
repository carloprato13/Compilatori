package ast;

import java.util.ArrayList;
import lib.FOOLlib;
import util.Environment;
import util.SemanticError;
import exception.*;
import org.antlr.v4.runtime.ParserRuleContext;

/**
 *
 * @author lucavvoltoio
 */
public class ClassInstantiationNode implements Node {

    private ParserRuleContext ctx;
    private String classID;
    private ClassTypeNode classType;
    private ArrayList<Node> args;

    public ClassInstantiationNode(String classID, ClassTypeNode classType, ArrayList<Node> args, ParserRuleContext c) {
        this.classID = classID;
        this.classType = classType;
        this.args = args;
        this.ctx=c;
    }
    
    public ClassInstantiationNode(String classID, ArrayList<Node> args, ParserRuleContext c) {
        this.classID = classID;
        //this.classType = classType;
        this.args = args;
        this.ctx=c;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        //create the result
        ArrayList<SemanticError> res = new ArrayList<SemanticError>();

        try {
            try {
                //Catturo la classe all'interno dell'env poichè potrebbe usare classi non ancora dichiarate e quindi non presenti nella ST
                //Rigenero l'errore giusto poichè se non esiste la classe, il getTypeOf genera un UndeclaredVarException e non una UndeclaredClassException
                classType = (ClassTypeNode) env.getNodeOf(classID);
            } catch (Exception e) {
                throw new UndeclaredClassException(classID);
            }
            
            if (classType.getFields().size() != args.size()) {
                res.add(new SemanticError("Instantiation of new " + classID + " with the wrong number of parameters."));
            }

            //if there are children then check semantics for every child and save the results
            if (args.size() > 0) {
                for (Node n : args) {
                    res.addAll(n.checkSemantics(env));
                }
            }

            env.getLatestEntryOf(this.classID);
        } catch (UndeclaredClassException | UndeclaredVarException e) {
            res.add(new SemanticError(e.getMessage()));
        }
        return res;
    }

    @Override
    public String toPrint(String s) {
        return s + "instantiation of " + classType.toPrint(s + "  ");
    }

    @Override
    public Node typeCheck() throws TypeException {
        ArrayList<VarNode> classFields = classType.getFields();
        for (int i = 0; i < args.size(); i++) {
            Node currentArgType = args.get(i).typeCheck();
            Node requestedType = classFields.get(i).getType();
            if (!currentArgType.isSubTypeOf(requestedType)) {
                throw new TypeException("Wrong type for " + (i + 1) + "-th parameter in the invocation of " + classID + " constructor", ctx);
            }
        }
        return new InstanceTypeNode(classType);
    }

    @Override
    public String codeGeneration() {
        StringBuilder argsCode = new StringBuilder();
        for (Node arg : args) {
            argsCode.append(arg.codeGeneration());
        }
       
        return argsCode
                + "push " + args.size() + "\n"
                + FOOLlib.getDispatchTablePointer(classID) + "\n"
                + "new\n";
    }

    @Override
    public boolean isSubTypeOf(Node m) {
        return classType.isSubTypeOf(m);
    }
}
