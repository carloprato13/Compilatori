package ast;
import java.util.ArrayList;
import java.util.HashMap;

import lib.FOOLlib;
import util.Environment;
import util.SemanticError;

public class ProgLetInNode implements Node {

  private ArrayList<Node> declist;
  private Node exp;
  
  public ProgLetInNode (ArrayList<Node> d, Node e) {
    declist=d;
    exp=e;
  }
  
  public String toPrint(String s) {
	String declstr="";
    for (Node dec:declist)
      declstr+=dec.toPrint(s+"  ");
	return s+"ProgLetIn\n" + declstr + exp.toPrint(s+"  ") ; 
  }
  
  @Override
    
  public ArrayList<SemanticError> checkSemantics(Environment env) {
      
      ArrayList<SemanticError> res = new ArrayList<SemanticError>();

        env.pushHashMap();

        //check semantics in the exp body
        //check semantics in the dec list
        if (declist.size() > 0) {
            env.offset = -2;
            //if there are children then check semantics for every child and save the results
            for (Node n : declist)
                res.addAll(n.checkSemantics(env));
        }
        
        res.addAll(exp.checkSemantics(env));

        //clean the scope, we are leaving a let scope
        env.popHashMap();
        
      //return the result
      return res;
	}
  
  public Node typeCheck () {
    for (Node dec:declist)
      dec.typeCheck();
    return exp.typeCheck();
  }
  
  public String codeGeneration() {
	  String declCode="";
	  for (Node dec:declist)
		    declCode+=dec.codeGeneration();
	  return  "push 0\n"+
			  declCode+
			  exp.codeGeneration()+"halt\n"+
			  FOOLlib.getCode();
  } 
 
    public boolean isSubTypeOf(Node m){
        return exp.isSubTypeOf(m);
    } 
  
    
}  