/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ast;

import java.util.ArrayList;
import lib.FOOLlib;
import util.Environment;
import util.SemanticError;

/**
 *
 * @author carlo
 */
public class ConfNode implements Node {
  
  private String op;
  private Node left;
  private Node right;
  
  public ConfNode (Node l, Node r, String s) {
    op=s;
    left=l;
    right=r;
  }
  
 public String toPrint(String s) {
    return s+"Conf \n" + left.toPrint(s+"  ") + op   
                       + right.toPrint(s+"  ") ; 
 }
  
public ArrayList<SemanticError> checkSemantics(Environment env) {
	  //create the result
	  ArrayList<SemanticError> res = new ArrayList<SemanticError>();
	  
	  //check semantics in the left and in the right exp
	  
	  res.addAll(left.checkSemantics(env));
	  res.addAll(right.checkSemantics(env));
	  
	  return res;
	}
  
  public Node typeCheck() {
    Node l = left.typeCheck();
    Node r = right.typeCheck();
    if (! ( FOOLlib.isSubtype(l,r) || FOOLlib.isSubtype(r,l) ) ) {
      System.out.println("Incompatible types in Confrontation");
      System.exit(0);
    }
    return new BoolTypeNode();
  }  
  
  public String codeGeneration() {
        String op2= "";
          switch(op){
              case ">=":
                op2= "bge ";
                break;
               case ">":
                op2="bgt ";
                break;
               case "<=":
                op2="blt ";
                break;
               case "<":
                op2="ble ";
                break;
                     
          }
	  String l1 = FOOLlib.freshLabel(); 
	  String l2 = FOOLlib.freshLabel();
	  return left.codeGeneration()+
			   right.codeGeneration()+
			   op2+ l1 +"\n"+
			   "push 0\n"+
			   "b " + l2 + "\n" +
			   l1 + ":\n"+
			   "push 1\n" +
			   l2 + ":\n";
		       
  }
 
  public boolean isSubTypeOf(Node m){
      if(m instanceof BoolTypeNode)
          return true;
      else
          return false;
  }
  
}
