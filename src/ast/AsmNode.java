package ast;

import exception.TypeException;
import java.util.ArrayList;
import java.util.HashMap;

import util.Environment;
import util.SemanticError;
import lib.FOOLlib;

public class AsmNode implements Node {

  private String id;
  private Node IdNode;
  private Node exp;
  
  public AsmNode (String i, Node t, Node v) {
    id=i;
    IdNode=t;
    exp=v;
  }
  
  	@Override
	public ArrayList<SemanticError> checkSemantics(Environment env) {
  	//create result list
  	  ArrayList<SemanticError> res = new ArrayList<>();
  	  
  	  //env.offset = -2;
  	  HashMap<String,STentry> hm = env.getHashMap(env.getNestingLevel());
        //STentry entry = new STentry(env.getNestingLevel(),IdNode, env.offset--); //separo introducendo "entry"
        
        STentry entry=((IdNode)IdNode).getSTentry();
        IdNode.checkSemantics(env);
        
        if(hm.put(id,entry) == null){
             res.add(new SemanticError("Var id "+id+" never declared"));
        }
        
        res.addAll(exp.checkSemantics(env));
        
        return res;
	}
  
  public String toPrint(String s) {
	return s+"Var:" + id +"\n"
	  	   +IdNode.toPrint(s+"  ")  
           +exp.toPrint(s+"  "); 
  }
  
  
  public Node typeCheck () throws TypeException{
    if (! (exp.typeCheck().isSubTypeOf(IdNode.typeCheck())) ){
      throw new TypeException("incompatible value for variable "+id);
    }     
    return ((IdNode)IdNode).getSTentry().getNode();
  }
  
  public String codeGeneration() {
        return exp.codeGeneration();
  }  
  
  public boolean isSubTypeOf(Node m){
      /*if(m instanceof ArrowTypeNode && (((ArrowTypeNode)m).getRet()) instanceof VoidTypeNode)
           return false;
      else*/
           return IdNode.isSubTypeOf(m);
  }
    
}  