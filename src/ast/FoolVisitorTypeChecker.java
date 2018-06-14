package ast;

import java.util.ArrayList;

import parser.*;
import parser.FoolParser.*;
import parser.FoolParser.BaseValContext;
import parser.FoolParser.BoolValContext;
import parser.FoolParser.DecContext;
import parser.FoolParser.ExpContext;
import parser.FoolParser.FunContext;
import parser.FoolParser.FuncallContext;
import parser.FoolParser.IntValContext;
import parser.FoolParser.LetInExpContext;
import parser.FoolParser.SingleExpContext;
import parser.FoolParser.TermContext;
import parser.FoolParser.TypeContext;
import parser.FoolParser.VarValContext;
import parser.FoolParser.VardecContext;

public class FoolVisitorTypeChecker extends FoolBaseVisitor<Node> {
	
	@Override
	public Node visitLetInExp(LetInExpContext ctx) {
		
		//resulting node of the right type
		ProgLetInNode res;
		
		//list of declarations in @res
		ArrayList<Node> declarations = new ArrayList<>();
		
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
	
        public Node visitClassExp(FoolParser.ClassExpContext ctx) {
        ProgClassExpNode res;

        //try {
            ArrayList<ClassdNode> classDeclarations = new ArrayList<ClassdNode>();
            for (FoolParser.ClassdContext dc : ctx.classd()) {
                ArrayList<VarNode> vars = new ArrayList<VarNode>();
                for (int i = 0; i < dc.vardec().size(); i++) {
                    VardecContext varctx = dc.vardec().get(i);
                    vars.add(new VarNode(varctx.ID().getText(), visit(varctx.type()).typeCheck(),null));
                }
                ArrayList<FunNode> mets = new ArrayList<FunNode>();
                for (FunContext functx : dc.fun()) {
                    FunNode method = (FunNode) visit(functx);
                    method.setClassID(dc.ID(0).getText());
                    mets.add(method);
                }

                ClassdNode classNode;
                if (dc.ID(1) == null) {
                    classNode = new ClassdNode(dc.ID(0).getText(), null ,  vars, mets);
                } else {
                    classNode = new ClassdNode( dc.ID(0).getText(), dc.ID().get(1).getText(), vars, mets);
                }
                classDeclarations.add(classNode);
            }

            if (ctx.let() != null) {
                ArrayList<Node> letDeclarations = new ArrayList<Node>();
                for (DecContext dc : ctx.let().dec()) {
                    letDeclarations.add(visit(dc));
                }

                Node exp = visit(ctx.exp());

                res = new ProgClassExpNode(ctx, classDeclarations, new ProgLetInNode( letDeclarations, exp));
            } else {
                Node exp = visit(ctx.exp());

                res = new ProgClassExpNode(ctx, classDeclarations, new ProgNode( visit(ctx.exp())));
            }
       /*} catch (TypeException e) {
            return new ErrorNode(e);
        }*/
        return res;
    }        
        
	@Override
	public Node visitSingleExp(SingleExpContext ctx) {
		
		//simply return the result of the visit to the inner exp
		return new ProgNode(visit(ctx.exp()));
		
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
		return new AsmNode(ctx.ID().getText(), idNode, expNode);
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
		//return null;
	}


	@Override
	public Node visitIntExp(IntExpContext ctx) {
		
		//check whether this is a simple or binary expression
		//notice here the necessity of having named elements in the grammar
		if(ctx.right == null){
			//it is a simple expression
			return visit( ctx.left );
		}else{
                        //it is a binary expression, you should visit left and right
			return new OpExpNode(visit(ctx.left), visit(ctx.right), ctx.op.getText()); //sarebbe furbo fare una classe OpNode da far estendere da PlusNode, TimesNode ecc..
		}
		
	}
	
	@Override public Node visitIfThenElse(FoolParser.IfThenElseContext ctx) { 
			
			//create the resulting node
			IfNode res;
			
			//visit the conditional, then the then branch, and then the else branch
			//notice once again the need of named terminals in the rule, this is because
			//we need to point to the right expression among the 3 possible ones in the rule
			
			Node condExp = visit(ctx.cond);
			
			Node thenExp = visit(ctx.thenBranch);
			
			Node elseExp = visit(ctx.elseBranch);
			
			//build the @res properly and return it
			res = new IfNode(condExp, thenExp, elseExp);
			
			return res;
		}

//SERVONO METODI PER ClassInstatiation
        
        public Node visitstmAsm(FoolParser.StmContext ctx) { 
            return visitChildren(ctx);
        }
        
        public IfNodeStm visitBranchStm(FoolParser.BranchStmContext ctx) { 
            Node bool = visit(ctx.e);
            Node b1 = visit(ctx.b1);
            Node b2 = visit(ctx.b2);
            IfNodeStm res = new IfNodeStm(bool,b1,b2);
            return res;
        }
        
        public Node visitBoolExp(FoolParser.BoolExpContext ctx){
            if(ctx.right == null){
			if(ctx.op.getText().equals("not"))
                                return new OpBExpNode(visit(ctx.left), null, "not");
                        else
                            return visit( ctx.left );
		}else{
			//it is a binary expression, you should visit left and right
			return new OpBExpNode(visit(ctx.left),  visit(ctx.right), ctx.op.getText()); 
		}
        }

	@Override
	public Node visitTerm(TermContext ctx) {
		if(ctx.right == null){
			//it is a simple expression
			return visit( ctx.left );
		}else{
			//it is a binary expression, you should visit left and right
			return new OpTermNode(visit(ctx.left),  visit(ctx.right), ctx.op.getText()); 
		}
	}
	
@Override public Node visitStms(FoolParser.StmsContext ctx) { 
    return visitChildren(ctx); 
}


	@Override
	public Node visitValFactor(ValFactorContext ctx) {
		//check whether this is a simple or binary expression
		//notice here the necessity of having named elements in the grammar
		return visit( ctx.left );       
	}
        
        @Override
	public Node visitBoolFactor(BoolFactorContext ctx) {
		//it is a binary expression, you should visit left and right
                return new EqualNode(visit(ctx.left), visit(ctx.right)); 
	}
        
        @Override
	public Node visitIntBoolFactor(IntBoolFactorContext ctx) {
            return new ConfNode(visit(ctx.left), visit(ctx.right), ctx.op.getText()); 
	}
	
	
	@Override
	public Node visitIntVal(IntValContext ctx) {
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
		
		res = new CallNode(ctx.ID().getText(), args);
		
		return res;
	}
       
        
        
        public Node visitNullVal(NullValContext ctx) {
            return new NullNode();
        }
        
        public Node visitBaseVal(BaseValContext ctx) {
            return visit(ctx.exp());
        }
        
        public Node visitPrint(PrintContext ctx){
            Node n=visit(ctx.exp());
            return new PrintNode(n);
        }
        
        @Override public Node visitMethodCall(FoolParser.MethodCallContext ctx) { 
        
            ArrayList<Node> args = new ArrayList<>();
            for (ExpContext exp : ctx.exp()) {
                args.add(visit(exp));
            }

            String methodId = ctx.ID(1).getText();
            //String objectId = ctx.THIS() != null ? PER GESTIRE IL THIS
            //        ctx.THIS().getText()
            //        :
            String objectId = ctx.ID(0).getText();
            return new MethodCallNode(objectId, methodId, args);
        
        }
        
        
/*
Vanno aggiunti del value il  'fieldVal' e considerare nel 'boolVal' il 'not'oppure cambiargli nome 
*/	
}
