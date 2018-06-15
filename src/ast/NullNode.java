package ast;

import java.util.ArrayList;
import util.Environment;
import util.SemanticError;

/**
 *
 * @author carlo
 */
public class NullNode implements Node {

    @Override
    public String toPrint(String indent) {
         //To change body of generated methods, choose Tools | Templates.
         return "NullNode";
    }

    @Override
    public Node typeCheck() {
         //To change body of generated methods, choose Tools | Templates.
         return this;
    }

    @Override
    public String codeGeneration() {
         return "null";
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
          
	  return new ArrayList<SemanticError>();
    }
    
      public boolean isSubTypeOf(Node m){
        return m instanceof NullNode;
        } 
    
}
