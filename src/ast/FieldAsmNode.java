/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ast;

import exception.TypeException;
import java.util.ArrayList;
import java.util.HashMap;
import util.Environment;
import util.SemanticError;

/**
 *
 * @author carlo
 */
public class FieldAsmNode implements Node {
    
  private FieldCallNode field;
  private Node exp;
  
  public FieldAsmNode (FieldCallNode t, Node v) {
    field=t;
    exp=v;
  }
  
@Override
public ArrayList<SemanticError> checkSemantics(Environment env) {
    //create result list
    ArrayList<SemanticError> res = new ArrayList<SemanticError>();

    res.addAll(field.checkSemantics(env));
    
    res.addAll(exp.checkSemantics(env));

    return res;
}
  
  public String toPrint(String s) {
	return s+"FieldAsm:" + field.toPrint(s+"  ") +"\n"  
           +exp.toPrint(s+"  "); 
  }
  
  
  public Node typeCheck () throws TypeException{
    //System.out.println(field.typeCheck().toPrint(" ")+" gesooo "+exp.typeCheck().toPrint(" "));
    if (! (exp.typeCheck().isSubTypeOf(field.typeCheck())) ){
      throw new TypeException("incompatible value for field "+field.toPrint(" "));
    }     
    return field.typeCheck();
  }
  
  public String codeGeneration() {
        return exp.codeGeneration();
  }  
  
  public boolean isSubTypeOf(Node m){
      return field.isSubTypeOf(m);
  }
    
}  
