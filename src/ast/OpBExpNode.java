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
          if(right!=null)
            res.addAll(right.checkSemantics(env));
	  
 	  return res;
 	}
  
  public String toPrint(String s) {
      String ss="";
      if(right!=null){ss=right.toPrint(s+"  "); }
    return s+"OpBExp\n" + left.toPrint(s+"  ") + op 
                      + ss; 
  }
  
  public Node typeCheck() throws TypeException {
    if(right!=null){
    if ( ( left.typeCheck() instanceof IntTypeNode ||left.typeCheck() instanceof IntNode) &&
            ( right.typeCheck() instanceof IntTypeNode ||right.typeCheck() instanceof IntNode)) {
        throw new TypeException("Integers in Boolean Operation");
    }}else{ if(left.typeCheck() instanceof IntTypeNode ||left.typeCheck() instanceof IntNode)
           throw new TypeException("Integers in Boolean Operation"); }
    return new IntTypeNode();
  }
  
  public String codeGeneration() {
      String l=left.codeGeneration();
      String r=right.codeGeneration();
      String operation = "";
      String l1 = FOOLlib.freshLabel();
      String l2 = FOOLlib.freshLabel();
      switch(this.op){
      case "&&":
          String l3 = FOOLlib.freshLabel();
          operation= ""
                + "beq " + l1 + "\n"
                + "push 0\n"
                + "b " + l2 + "\n"
                + l1 + ":\n"
                + l
                + "push 1\n"
                + "beq " + l3 + "\n"
                + "push 0\n"
                + "b " + l2 + "\n"
                + l3 + ":\n"
                + "push 1\n"
                + l2 + ":\n";
            break;
      case "||":
            operation=l+
                "push 1\n" +
                "beq " + l1 + "\n" +
                r +
                "push 1\n" +
                "beq " + l1 + "\n" +
                "push 0\n" +
                "b " + l2 + "\n" +
                l1 + ":\n" +
                "push 1\n" +
                l2 + ":\n";
            break;
      case "not":
          operation=
             l + "push 1\n" +
                "beq " + l1 + "\n" +
                "push 1\n" +
                "b " + l2 + "\n" +
                l1 + ":\n" +
                "push 0\n" + l2 +":\n";  
        }
      return operation;
  }
    
  public boolean isSubTypeOf(Node m){
      if(right!=null)
          return left.isSubTypeOf(m) && right.isSubTypeOf(m);
      else
          return left.isSubTypeOf(m);
    }
  
}
