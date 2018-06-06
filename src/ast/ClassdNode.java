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
public class ClassdNode implements Node{
    
    private String classID;
    private String superClassID;
    private ArrayList<VarNode> attrDecList;
    private ArrayList<FunNode> metDecList;

    private HashMap<String, Node> fields = new HashMap<>();
    private HashMap<String, FunNode> methods = new HashMap<>();

    private ClassTypeNode type;

    @Override
    public String toPrint(String indent) {
        return indent + classID;
    }
    
     public ArrayList<VarNode> getVardeclist() {
        return this.attrDecList;
    }

    public ArrayList<FunNode> getMetDecList() {
        return metDecList;
    }
    
    public String getClassID() {
        return classID;
    }
    
    public String getSuperClassID() {
        return superClassID;
    }

    @Override
    public Node typeCheck() {
        for (VarNode vardec : attrDecList){
            vardec.typeCheck();
        }

        for (FunNode fundec : metDecList) {
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
