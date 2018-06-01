package ast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import parser.*;
import parser.FoolParser.BaseExpContext;
import parser.FoolParser.BoolValContext;
import parser.FoolParser.DecContext;
import parser.FoolParser.ExpContext;
import parser.FoolParser.FactorContext;
import parser.FoolParser.FunContext;
import parser.FoolParser.FunExpContext;
import parser.FoolParser.IfExpContext;
import parser.FoolParser.IntValContext;
import parser.FoolParser.LetInExpContext;
import parser.FoolParser.SingleExpContext;
import parser.FoolParser.TermContext;
import parser.FoolParser.TypeContext;
import parser.FoolParser.VarExpContext;
import parser.FoolParser.VarasmContext;
import parser.FoolParser.VardecContext;
import util.SemanticError;

public class FoolVisitorTypeChecker extends FoolBaseVisitor<Node> {
	
	
	@Override
	public Node visitLetInExp(LetInExpContext ctx) {
		
		//resulting node of the right type
		ProgLetInNode res;
		
		//list of declarations in @res
		ArrayList<Node> declarations = new ArrayList<Node>();
		
		//visit all nodes corresponding to declarations inside the let context and store them in @declarations
		//notice that the ctx.let().dec() method returns a list, this is because of the use of * or + in the grammar
		//antlr detects this is a group and therefore returns a list
		for(DecContext dc : ctx.let().dec()){
			declarations.add( visit(dc) );
		}
		
		//visit exp context
		Node exp = visit( ctx.exp() );
		
		//build @res accordingly with the result of the visits to its content
		res = new ProgLetInNode(declarations,  exp);
		
		return res;
	}
	
	@Override
	public Node visitSingleExp(SingleExpContext ctx) {
		
		//simply return the result of the visit to the inner exp
		return visit(ctx.exp());
		
	}
	
	
	@Override
	public Node visitDecAsm(DecAsmContext ctx) {
		
		//declare the result node
		VarNode result;
		
		//visit the type
		Node typeNode = visit(ctx.vardec().type());
		
		//visit the exp
		Node expNode = visit(ctx.exp());
		
		//build the varNode
		return new VarNode(ctx.vardec().ID().getText(), typeNode, expNode);
	}

	//Vedere se è corretto
	public Node visitAsm(AsmContext ctx) {

		//declare the result node
		VarNode result;
		
		//visit the type
		IdNode idNode = new IdNode(ctx.ID().getText());

		//visit the exp
		Node expNode = visit(ctx.exp());

		//build the varNode
		return new AsmNode(ctx.ID().getText(), null, expNode);
	}

	//Da modificare la parte iniziale 'id dot id'
	/*public Node visitFieldAsm(FieldAsmContext ctx) {

		//declare the result node
		VarNode result;
		
		//Ci interessa che il secondo id possa essere chiamato a partire dal primo
		//visit the type
		Node typeNode = visit(ctx.ID()); //Prendo nome della variabile, ne costruisco il nodo ClassNode

		//visit the type
		Node typeNode = visit(ctx.ID(); //dal CLassNode estrarre VarNode del campo

		//visit the exp
		Node expNode = visit(ctx.exp()); //Estrarre il tipo della espressione

		//Va modificato
		//build the varNode //ritorno FieldNode 
		return new VarNode(ctx.ID().getText(), typeNode, expNode);

	}*/

	@Override
	public Node visitFun(FunContext ctx) {
		
		//initialize @res with the visits to the type and its ID
		FunNode res = new FunNode(ctx.ID().getText(), visit(ctx.type()));
		
		//add argument declarations
		//we are getting a shortcut here by constructing directly the ParNode
		//this could be done differently by visiting instead the VardecContext
		for(VardecContext vc : ctx.vardec())
			res.addPar( new ParNode(vc.ID().getText(), visit( vc.type() )) );
		
		//add body
		//create a list for the nested declarations
		ArrayList<Node> innerDec = new ArrayList<Node>();
		
		//check whether there are actually nested decs
		if(ctx.let() != null){
			//if there are visit each dec and add it to the @innerDec list
			for(DecContext dc : ctx.let().dec())
				innerDec.add(visit(dc));
		}
		
		//get the exp body
		Node exp = visit(ctx.exp());
		
		//add the body and the inner declarations to the function
		res.addDecBody(innerDec, exp);
		
		return res;		
		
	}

//Va dichiarato da qualche parte il VoidTypeNode
	@Override
	public Node visitType(TypeContext ctx) {
		if(ctx.getText().equals("int"))
			return new IntTypeNode();
		else if(ctx.getText().equals("bool"))
			return new BoolTypeNode();
		else if (ctx.getText().equals("void"))
			return new VoidTypeNode();
		else return new ClassTypeNode(ctx.getText());//Vedere comer implementare ClassTypeNode
		//this will never happen thanks to the parser
		return null;

	}


	@Override
	public Node visitIntExp(ExpContext ctx) {
		
		//check whether this is a simple or binary expression
		//notice here the necessity of having named elements in the grammar
		if(ctx.right == null){
			//it is a simple expression
			return visit( ctx.left );
		}else{
			//it is a binary expression, you should visit left and right
			return new PlusNode(visit(ctx.left), visit(ctx.right)); //sarebbe furbo fare una classe OpNode da far estendere da PlusNode, TimesNode ecc..
		}
		
	}
	
	@Override public T visitIfThenElse(FoolParser.IfThenElseContext ctx) { 
			
			//create the resulting node
			IfNode res;
			
			//visit the conditional, then the then branch, and then the else branch
			//notice once again the need of named terminals in the rule, this is because
			//we need to point to the right expression among the 3 possible ones in the rule
			
			Node condExp = visit (ctx.cond);
			
			Node thenExp = visit (ctx.thenBranch);
			
			Node elseExp = visit (ctx.elseBranch);
			
			//build the @res properly and return it
			res = new IfNode(condExp, thenExp, elseExp);
			
			return res;
		}

//SERVONO METODI PER BoolExp ClassInstatiation statement

	@Override
	public Node visitTerm(TermContext ctx) {
		//check whether this is a simple or binary expression
		//notice here the necessity of having named elements in the grammar
		if(ctx.right == null){
			//it is a simple expression
			return visit( ctx.left );
		}else{
			//it is a binary expression, you should visit left and right
			return new MultNode(visit(ctx.left), visit(ctx.right)); //Aggiungere il caso del FracNode
		}
	}
	
@Override public T visitStms(FoolParser.StmsContext ctx) { return visitChildren(ctx); }
	
@Override public T visitStm(FoolParser.StmContext ctx) { return visitChildren(ctx); }

//factor deve prevedere anche gli altri casi
	@Override
	public Node visitFactor(FactorContext ctx) {
		//check whether this is a simple or binary expression
		//notice here the necessity of having named elements in the grammar
		if(ctx.right == null){
			//it is a simple expression
			return visit( ctx.left );
		}else{
			//it is a binary expression, you should visit left and right
			return new EqualNode(visit(ctx.left), visit(ctx.right)); //Stessa cosa di PlusNode
		}
	}
	
	
	@Override
	public Node visitIntVal(IntValContext ctx) {
		// notice that this method is not actually a rule but a named production #intVal
		
		//there is no need to perform a check here, the lexer ensures this text is an int
		return new IntNode(Integer.parseInt(ctx.INTEGER().getText()));
	}
	
	@Override
	public Node visitBoolVal(BoolValContext ctx) {
		
		//there is no need to perform a check here, the lexer ensures this text is a boolean
		return new BoolNode(Boolean.parseBoolean(ctx.getText())); 
	}
	
	@Override
	public Node visitVarVal(VarValContext ctx) {
		
		//this corresponds to a variable access
		return new IdNode(ctx.ID().getText());

	}
	
	@Override
	public Node visitFuncall(FuncallContext ctx) {
		//this corresponds to a function invocation
		
		//declare the result
		Node res;
		
		//get the invocation arguments
		ArrayList<Node> args = new ArrayList<Node>();
		
		for(ExpContext exp : ctx.exp())
			args.add(visit(exp));
		
		//especial check for stdlib func
		//this is WRONG, THIS SHOULD BE DONE IN A DIFFERENT WAY
		//JUST IMAGINE THERE ARE 800 stdlib functions...
		if(ctx.ID().getText().equals("print"))
			res = new PrintNode(args.get(0));
		
		else
			//instantiate the invocation
			res = new CallNode(ctx.ID().getText(), args);
		
		return res;
	}
/*
Vanno aggiunti del value il 'nullVal', 'fieldVal' e considerare nel 'boolVal'
il 'not'oppure cambiargli nome e 'methodCall'
*/	
}
