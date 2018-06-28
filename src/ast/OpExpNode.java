package ast;

import exception.TypeException;
import java.util.ArrayList;
import util.Environment;
import util.SemanticError;

public class OpExpNode implements Node {

    private Node left;
    private Node right;
    private String op;

    public OpExpNode(Node l, Node r, String ops) {
        left = l;
        right = r;
        op = ops;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> res = new ArrayList<>();
        res.addAll(left.checkSemantics(env));
        res.addAll(right.checkSemantics(env));

        return res;
    }

    @Override
    public String toPrint(String s) {
        switch (op) {

            case "+":
                return s + "Addition of: \n" + left.toPrint(s + "  ")
                        + right.toPrint(s + "  ");

            case "-":
                return s + "Subtraction of: \n" + left.toPrint(s + "  ")
                        + right.toPrint(s + "  ");
            default:
                return "Operazione sbagliata";
        }
    }

    @Override
    public Node typeCheck() throws TypeException {
        if (!(left.typeCheck() instanceof IntTypeNode || left.typeCheck() instanceof IntNode)
                && (right.typeCheck() instanceof IntTypeNode || right.typeCheck() instanceof IntNode)) {
            throw new TypeException("Non integers in integer Operation");
        }
        return new IntTypeNode();
    }

    @Override
    public String codeGeneration() {
        String operation = "";
        switch (op) {
            case "-":
                operation = "sub\n";
            case "+":
                operation = "add\n";
        }
        return left.codeGeneration()
                + operation + right.codeGeneration();
    }

    @Override
    public boolean isSubTypeOf(Node m) {
        return left.isSubTypeOf(m) && right.isSubTypeOf(m);
    }

}
