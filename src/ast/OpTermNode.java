package ast;

import exception.TypeException;
import java.util.ArrayList;
import util.Environment;
import util.SemanticError;
public class OpTermNode implements Node {

    private Node left;
    private Node right;
    private String op;

    public OpTermNode(Node l, Node r, String ops) {
        left = l;
        right = r;
        op = ops;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        //create the result
        ArrayList<SemanticError> res = new ArrayList<SemanticError>();

        //check semantics in the left and in the right exp
        res.addAll(left.checkSemantics(env));
        res.addAll(right.checkSemantics(env));

        return res;
    }

    @Override
    public String toPrint(String s) {
        switch (op) {

            case "/":
                return s + "Division of: \n" + left.toPrint(s + "  ")
                        + right.toPrint(s + "  ");

            case "*":
                return s + "Multiplication of: \n" + left.toPrint(s + "  ")
                        + right.toPrint(s + "  ");
                
            default: return "Operazione sbagliata";
        }
    }

    @Override
    public Node typeCheck() throws TypeException {
        if (! ( left.typeCheck() instanceof IntTypeNode ||left.typeCheck() instanceof IntNode) &&
            ( right.typeCheck() instanceof IntTypeNode ||right.typeCheck() instanceof IntNode)) {
            throw new TypeException("Non integers term operations");
        }
        return new IntTypeNode();
    }

    @Override
    public String codeGeneration() {
        String operation = "";
        switch (op) {
            case "/":
                operation = "div\n";
            case "*":
                operation = "mult\n";
        }
        return left.codeGeneration()
                + right.codeGeneration()
                + operation;
    }

    @Override
    public boolean isSubTypeOf(Node m) {
        return m instanceof IntTypeNode;
    }

}
