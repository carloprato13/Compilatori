package ast;
import java.util.ArrayList;
import java.util.HashMap;

import lib.FOOLlib;
import util.Environment;
import util.SemanticError;

public class FunNode implements Node {

  private String id;
  private Node type; 
  private ArrayList<Node> parlist = new ArrayList<Node>(); 
  private ArrayList<Node> declist; 
  private Node body;
  private String classID;
  
  public FunNode (String i, Node t) {
    id=i;
    type=t;
  }
  
  public FunNode (String i, Node t, ArrayList<Node> params){
    id=i;
    type=t;
    parlist=params;
  }
  
  public void addDecBody (ArrayList<Node> d, Node b) {
    declist=d;
    body=b;
  }
  
  @Override
          
        public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> res = new ArrayList<SemanticError>();
        ArrayList<Node> parTypes = new ArrayList<>();

        for (Node param : parlist) {
            ParNode params=(ParNode) param;
            parTypes.add(params.getType());
        }

        //env.offset = -2;

        //try {
            // Se restituisco un oggetto, aggiorno le informazione sul ClassType
            if ( this.type instanceof InstanceTypeNode ) {
                InstanceTypeNode returnType = (InstanceTypeNode) this.type;
                res.addAll(returnType.updateClassType(env));
            }
            env.addEntry(this.id, new ArrowTypeNode(parTypes, type), env.offset--);
        //} catch (RedeclaredVarException e) {
        //    res.add(new SemanticError("function " + id + " already declared"));
        //}
        env.pushHashMap();

        //check args
        for (Node param : parlist) {
            res.addAll(param.checkSemantics(env));
        }

        //check semantics in the dec list
        if (declist.size() > 0) {
            env.offset = -2;
            //if there are children then check semantics for every child and save the results
            for (Node n : declist)
                res.addAll(n.checkSemantics(env));
        }

        //check body
        res.addAll(body.checkSemantics(env));

        //close scope
        env.popHashMap();


        return res;
	}
  
  public void addPar (Node p) {
    parlist.add(p);
  }  
  
  public String toPrint(String s) {
	String parlstr="";
	for (Node par:parlist)
	  parlstr+=par.toPrint(s+"  ");
	String declstr="";
	if (declist!=null) 
	  for (Node dec:declist)
	    declstr+=dec.toPrint(s+"  ");
    return s+"Fun:" + id +"\n"
		   +type.toPrint(s+"  ")
		   +parlstr
	   	   +declstr
           +body.toPrint(s+"  ") ; 
  }
  
  public Node typeCheck () {
	if (declist!=null) 
	  for (Node dec:declist)
		dec.typeCheck();
    if ( !(body.typeCheck().isSubTypeOf(type)) ){
      System.out.println("Wrong return type for function "+id);
      System.exit(0);
    }  
    return new ArrowTypeNode(parlist, type);
  }
  
  public String codeGeneration() {
	  
	    String declCode="";
	    if (declist!=null) for (Node dec:declist)
		    declCode+=dec.codeGeneration();
	    
	    String popDecl="";
	    if (declist!=null) for (Node dec:declist)
	    	popDecl+="pop\n";
	    
	    String popParl="";
	    for (Node dec:parlist)
	    	popParl+="pop\n";
	    
	    String funl=FOOLlib.freshFunLabel(); 
	    FOOLlib.putCode(funl+":\n"+
	            "cfp\n"+ //setta $fp a $sp				
				"lra\n"+ //inserimento return address
	    		declCode+ //inserimento dichiarazioni locali
	    		body.codeGeneration()+
	    		"srv\n"+ //pop del return value
	    		popDecl+
	    		"sra\n"+ // pop del return address
	    		"pop\n"+ // pop di AL
	    		popParl+
	    		"sfp\n"+  // setto $fp a valore del CL
	    		"lrv\n"+ // risultato della funzione sullo stack
	    		"lra\n"+"js\n" // salta a $ra
	    		);
	    
		return "push "+ funl +"\n";
  }

    public ArrayList<Node> getParams() {
        return parlist;
    }

    public String getId() {
        return id;
    }

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    public Node getType() {
        return type;
    }
  
    public boolean isSubTypeOf(Node m){
        return type.isSubTypeOf(m);
    }
  
}  