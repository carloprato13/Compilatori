package ast;

import java.util.ArrayList;
import java.util.HashMap;

import util.Environment;
import util.SemanticError;
import lib.FOOLlib;

public class AsmNode implements Node {

  private String id;
  private Node type;
  private Node exp;
  
  public AsmNode (String i, Node t, Node v) {
    id=i;
    type=t;
    exp=v;
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
  
  
  public Node typeCheck () {
    if (! (exp.typeCheck().isSubTypeOf(type)) ){      
      System.out.println("incompatible value for variable "+id);
      System.exit(0);
    }     
    return type;
  }
  
  public String codeGeneration() {
        return exp.codeGeneration();
  }  
  
  public boolean isSubTypeOf(Node m){
      return type.isSubTypeOf(m);
  }
    
}  