/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ast;

import util.Environment;
import util.SemanticError;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author carlo
 */
public class ClassdNode implements Node {

    private String classID;
    private String superClassID;
    private ArrayList<VarNode> attrDecList;
    private ArrayList<FunNode> funDecList;

    private HashMap<String, Node> fields = new HashMap<>();
    private HashMap<String, FunNode> functions = new HashMap<>();

    private ClassTypeNode type;

    public ClassdNode(String classID, String superClassID, ArrayList<VarNode> attrDecList, ArrayList<FunNode> funDecList) {
        this.classID = classID;
        this.superClassID = superClassID;
        this.attrDecList = attrDecList;
        this.funDecList = funDecList;
    }

    @Override
    public String toPrint(String indent) {
        return indent + classID;
    }

    public ArrayList<VarNode> getVardeclist() {
        return this.attrDecList;
    }

    public ArrayList<FunNode> getFunDecList() {
        return funDecList;
    }

    public String getClassID() {
        return classID;
    }

    public String getSuperClassID() {
        return superClassID;
    }

    @Override
    public Node typeCheck() {
        for (VarNode vardec : attrDecList) {
            vardec.typeCheck();
        }

        for (FunNode fundec : funDecList) {
            fundec.typeCheck();
        }

        return this.type;
    }

    @Override
    public String codeGeneration() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
