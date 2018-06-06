package ast;

import java.util.ArrayList;
import java.util.HashMap;

import util.Environment;
import util.SemanticError;
import lib.FOOLlib;

public class ClassTypeNode implements Node {

  private String id;
  private Node type;
  private Node exp;
  
  public ClassTypeNode (String i, Node t, Node v) {
    id=i;
    type=t;
    exp=v;
  }
  
  public ClassTypeNode (String i) {
    id=i;
    type=null;
    exp=null;
  }  
  
  @Override
	public ArrayList<SemanticError> checkSemantics(Environment env) {
  	//create result list
  	  ArrayList<SemanticError> res = new ArrayList<SemanticError>();
  	  
  	  //env.offset = -2;
  	  HashMap<String,STentry> hm = env.getHashMap(env.getNestingLevel());
        STentry entry = new STentry(env.getNestingLevel(),type, env.offset--); //separo introducendo "entry"
        
        if ( hm.put(id,entry) != null )
          res.add(new SemanticError("Var id "+id+" already declared"));
        
        res.addAll(exp.checkSemantics(env));
        
        return res;
	}
  
  public String toPrint(String s) {
	return s+"Var:" + id +"\n"
	  	   +type.toPrint(s+"  ")  
           +exp.toPrint(s+"  "); 
  }
  
  //valore di ritorno non utilizzato
  public Node typeCheck () {
    if (! (FOOLlib.isSubtype(exp.typeCheck(),type)) ){      //isSubtype in realtà è un'uguaglianza
      System.out.println("incompatible value for variable "+id);
      System.exit(0);
    }     
    return null;
  }
  
  public String codeGeneration() {
		return exp.codeGeneration();
  }  
    
}  