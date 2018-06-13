/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
         return "ciao";
    }

    @Override
    public Node typeCheck() {
         //To change body of generated methods, choose Tools | Templates.
         return null;
    }

    @Override
    public String codeGeneration() {
         return "null";
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
          
	  return null;
    }
    
      public boolean isSubTypeOf(Node m){
        return true;
        } 
    
}
