package ast;

import java.util.ArrayList;

import util.Environment;
import util.SemanticError;

public class IntTypeNode implements Node {
  
  public IntTypeNode () {
  }
  
  public String toPrint(String s) {
	return s+"IntType\n";  
  }
  
  //non utilizzato
  public Node typeCheck() {
    return this;
  }

  //non utilizzato
  public String codeGeneration() {
		return "";
  }
  
  @Override
	public ArrayList<SemanticError> checkSemantics(Environment env) {

	  return new ArrayList<SemanticError>();
	}
  
  public boolean isSubTypeOf(Node m){
        if(m instanceof IntNode)
            return true;
        else
            return false;
    }      
        
}  