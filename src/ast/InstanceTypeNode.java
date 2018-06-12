/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ast;

/**
 *
 * @author carlo
 */
import util.*;

import java.util.ArrayList;

public class InstanceTypeNode implements Node {

    private ClassTypeNode classT;

    public InstanceTypeNode( ClassTypeNode classT ) {
        this.classT = classT;
    }

    public ClassTypeNode getClassType() {
        return this.classT;
    }

    // This is used to update the classType filling superType when needed
    public ArrayList<SemanticError> updateClassType(Environment env) {
        ArrayList<SemanticError> res = new ArrayList<SemanticError>();
        //try {
            //try {
                this.classT = (ClassTypeNode) env.getNodeOf(classT.getId());
            //} catch (UndeclaredVarException e) {
              //  throw new UndeclaredClassException(classT.getClassID());
            //}
        //} catch (UndeclaredClassException e) {
            //res.add(new SemanticError(e.getMessage()));
        //}
        return res;
    }

    /*@Override
    public boolean isSubTypeOf(Type type) {
        if (type instanceof InstanceType) {
            InstanceType it2 = (InstanceType) type;
            return classT.isSubTypeOf(it2.getClassType());
        } else {
            return false;
        }
    }*/

    @Override
    public String toString() {
        return "instance: " + classT.getId();
    }

    @Override
    public String toPrint(String indent) {
        return "Instance of "+ classT.getId();
    }

    @Override
    public Node typeCheck() {
       return classT;
    }

    @Override
    public String codeGeneration() {
        return "";
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        return null;
    }
}
