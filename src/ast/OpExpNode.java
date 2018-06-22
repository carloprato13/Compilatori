package ast;

import exception.TypeException;
import java.util.ArrayList;

import util.Environment;
import util.SemanticError;
import lib.FOOLlib;

public class OpExpNode implements Node {

  private Node left;
  private Node right;
  private String op;
  
  public OpExpNode (Node l, Node r, String ops) {
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
    return s+"OpExp\n" + left.toPrint(s+"  ") + op 
                      + right.toPrint(s+"  ") ; 
  }
  
  public Node typeCheck() throws TypeException {
    if (! ( left.typeCheck() instanceof IntTypeNode ||left.typeCheck() instanceof IntNode) &&
            ( right.typeCheck() instanceof IntTypeNode ||right.typeCheck() instanceof IntNode)) {
      throw new TypeException("Non integers in integer Operation");
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