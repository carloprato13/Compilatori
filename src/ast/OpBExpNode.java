/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ast;

import exception.TypeException;
import java.util.ArrayList;
import lib.FOOLlib;
import util.Environment;
import util.SemanticError;

/**
 *
 * @author carlo
 */
public class OpBExpNode implements Node {
    
  private Node left;
  private Node right;
  private String op;
  
  public OpBExpNode (Node l, Node r, String ops) {
    left=l;
    right=r;
    op=ops;
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
  
  public String toPrint(String s) {
    return s+"OpBExp\n" + left.toPrint(s+"  ") + op 
                      + right.toPrint(s+"  ") ; 
  }
  
  public Node typeCheck() throws TypeException {
    if (! ( left.typeCheck() instanceof IntTypeNode ||left.typeCheck() instanceof IntNode) &&
            ( right.typeCheck() instanceof IntTypeNode ||right.typeCheck() instanceof IntNode)) {
        throw new TypeException("Non integers in Boolean Operation");
    }
    return new IntTypeNode();
  }
  
  public String codeGeneration() {
		return left.codeGeneration()+
			   right.codeGeneration()+
			   "add\n";
  }
    
  public boolean isSubTypeOf(Node m){
          return left.isSubTypeOf(m) && right.isSubTypeOf(m);
    }
  
}
