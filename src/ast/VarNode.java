package ast;

import exception.TypeException;
import java.util.ArrayList;
import exception.*;
import util.Environment;
import util.SemanticError;

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
 
        ArrayList<SemanticError> res = new ArrayList<>();

        //Se sto istanziando un nuovo oggetto, aggiorno bene le informazioni di ClassType 
        if (type instanceof InstanceTypeNode) {
            InstanceTypeNode decType = (InstanceTypeNode) type;
            res.addAll(decType.updateClassType(env));
        }
        
        if(exp!=null)
         res.addAll(exp.checkSemantics(env));
        try {
            env.addEntry(id, this.type, env.offset--, inClass);
        } catch (RedeclaredVarException e) {
            res.add(new SemanticError(e.getMessage()));
        }

        return res;
	}
  
  @Override
  public String toPrint(String s) {
      String res="";
      if(exp!=null)
          res=exp.toPrint(s+"  ");
	return s+"Var: " + id +" of type: \n"
	  	   +type.toPrint(s+"  ")  
           +res; 
  }

  @Override
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
  
  @Override
  public String codeGeneration() {
	return exp.codeGeneration();
  }  
  
  @Override
      public boolean isSubTypeOf(Node m){
       return type.isSubTypeOf(m);
    }
      
}  