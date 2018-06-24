package ast;

import exception.TypeException;
import java.util.ArrayList;
import java.util.HashMap;
import exception.*;
import util.Environment;
import util.SemanticError;
import lib.FOOLlib;

public class VarNode implements Node {

  private String id;
  private Node type;
  private Node exp;
  private boolean inClass=false;
  
  public VarNode (String i, Node t, Node v) {
    id=i;
    type=t;
    exp=v;
  }
  
  public VarNode (String i, Node t, Node v, boolean n) {
    id=i;
    type=t;
    exp=v;
    inClass=n;
  }
         

    public String getId() {
        return id;
    }

    public Node getType() {
        return type;
    }
  
  	@Override
	public ArrayList<SemanticError> checkSemantics(Environment env) {
  	//create result list
  	 /* ArrayList<SemanticError> res = new ArrayList<SemanticError>();
  	  
  	  //env.offset = -2;
          System.out.println("PORCAMADONNA!: "+env.getNestingLevel());
  	  HashMap<String,STentry> hm = env.getHashMap(env.getNestingLevel());
        
          try{
          if(type instanceof ClassTypeNode){
             type = (ClassTypeNode) env.getNodeOf(((ClassTypeNode)type).getId());
          }   
          }catch(UndeclaredVarException e){
              res.add(new SemanticError(e.getMessage()));
          }
          
        STentry entry = new STentry(env.getNestingLevel(),type, env.offset--); //separo introducendo "entry"
        
        if ( hm.put(id,entry) != null )
          res.add(new SemanticError("Var id "+id+" already declared"));
        
        if(exp != null)
            res.addAll(exp.checkSemantics(env));
        
        return res;*/
          //create result list
        ArrayList<SemanticError> res = new ArrayList<SemanticError>();

        //Se sto istanziando un nuovo oggetto, aggiorno bene le informazioni di ClassType :=D
        if (type instanceof InstanceTypeNode) {
            InstanceTypeNode decType = (InstanceTypeNode) type;
            res.addAll(decType.updateClassType(env));
        }
        
        if(exp!=null)
         res.addAll(exp.checkSemantics(env));

        //env.offset = -2;
        try {
            env.addEntry(id, this.type, env.offset--, inClass);
        } catch (RedeclaredVarException e) {
            res.add(new SemanticError(e.getMessage()));
        }

        return res;
	}
  
  public String toPrint(String s) {
      String res="";
      if(exp!=null)
          res=exp.toPrint(s+"  ");
	return s+"Var:" + id +"\n"
	  	   +type.toPrint(s+"  ")  
           +res; 
  }

  public Node typeCheck () throws TypeException {
    if(exp != null){
        if(exp.typeCheck() instanceof VoidTypeNode && !(type instanceof ClassTypeNode) )
            throw new TypeException("incompatible value for variable "+id+" cannot assign void to a variable ");

        if(exp.typeCheck() instanceof InstanceTypeNode ){
           if (!(exp.typeCheck().typeCheck().isSubTypeOf(type)) && !(type.isSubTypeOf(exp.typeCheck().typeCheck())) )
               throw new TypeException("incompatible value for variable "+id+" not subclass of");
           }
           else if (! (exp.typeCheck().isSubTypeOf(type))){
            throw new TypeException("incompatible value for variable "+id);
        }
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