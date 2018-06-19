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
public class IfNodeStm implements Node {
    
  private Node cond;
  private Node th;
  private Node el;
  
  public IfNodeStm (Node c, Node t, Node e) {
    cond=c;
    th=t;
    el=e;
  }
  
  public String toPrint(String s) {
    return s+"IfStm\n" + cond.toPrint(s+"  ") 
                    + th.toPrint(s+"  ")   
                    + el.toPrint(s+"  "); 
  }
  
  
	public ArrayList<SemanticError> checkSemantics(Environment env) {
	  //create the result
	  ArrayList<SemanticError> res = new ArrayList<SemanticError>();
	  
	  //check semantics in the condition
	  res.addAll(cond.checkSemantics(env));
	 	  
	  //check semantics in the then and in the else exp
	  res.addAll(th.checkSemantics(env));
	  res.addAll(el.checkSemantics(env));
	  
	  return res;
	}
  
  
  public Node typeCheck() throws TypeException {
    if (!(FOOLlib.isSubtype(cond.typeCheck(),new BoolTypeNode()))) {
      throw new TypeException("Non boolean condition in if");
    }
    Node t = th.typeCheck();
    Node e = el.typeCheck();
    if (FOOLlib.isSubtype(t,e)) 
      return e;
    if (FOOLlib.isSubtype(e,t))
      return t;
    throw new TypeException("Incompatible types in then else branches");
    }
  
  public String codeGeneration() {
	  String l1 = FOOLlib.freshLabel(); 
	  String l2 = FOOLlib.freshLabel();
	  return cond.codeGeneration()+//mette sulla pila il risultato dell'espressiione
			 "push 1\n"+
			 "beq "+ l1 +"\n"+			  
			 el.codeGeneration()+
			 "b " + l2 + "\n" +
			 l1 + ":\n"+
			 th.codeGeneration()+
	         l2 + ":\n"; 
  }
  
  //teoricamente tipando void dovrebbe restituire sempre true...
  public boolean isSubTypeOf(Node m){
    if (cond instanceof BoolTypeNode == false) return false;
    if(th.isSubTypeOf(m) && el.isSubTypeOf(m))
        return true;
    else
        return false;
    }
}
