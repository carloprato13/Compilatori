
import java.util.*;
import java.io.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class FoolTypeChecker extends FoolBaseListener{

	private Stack<Hashtable<String, String>> sym;
	private Stack<Hashtable<ArrayList<String>, String>> fun;
	private Stack<String, Hashtable<ArrayList<String>, String>, Hashtable<String, String>> class;

	public FoolTypeChecker() {
		sym = new Stack<Hashtable<String, String>>();
	} 
	
	@Override public void exitLetInExp(FoolParser.LetInExpContext ctx) { 
		System.out.println("exitLetIn: eseguo pop \n");
		sym.pop();
	}
	
	@Override public void enterLet(FoolParser.LetContext ctx) {
		System.out.println("enterLet: eseguo push \n");
		sym.push(new Hashtable<String, String>());
	 }
	
	@Override public void enterVardec(FoolParser.VardecContext ctx) {
		System.out.println("enterVardec: "+ctx.t.getText()+" "+ctx.name.getText()+"\n");
		if(sym.peek().get(ctx.t.getText()) != null){
			System.out.println("Semantic Error!");
			System.exit(0);
		}
	}
	
	@Override public void exitVardec(FoolParser.VardecContext ctx) {
		System.out.println("exitVardec: "+ctx.t.getText()+" "+ctx.name.getText()+"\n");
		sym.peek().put(ctx.t.getText(), ctx.name.getText());
	 }
	
	@Override public void exitDecAsm(FoolParser.DecAsmContext ctx) { 
		System.out.println("exitDecAsm:\n");
		String tmp="";
	    switch(ctx.e.getRuleContext().toString()){
	      case "IntExp": 
	        tmp = "int";

	      case "BoolExp": 
	        tmp="bool";

	      default:
	        ;
	      }
		if(ctx.t.t.getText().equals(tmp)){
		    System.out.println("Semantic Error!");
		    System.exit(0);
	        }
	}
	
	
	@Override public void exitBoolFactor(FoolParser.BoolFactorContext ctx) {
		switch(ctx.left.getRuleContext().toString())
		case "intVal":
	        ;
	 }
	
	
	@Override public void exitValFactor(FoolParser.ValFactorContext ctx) {
	 }

	@Override public void exitFun(FoolParser.FunContext ctx) { 
		System.out.println("exitFun: eseguo pop \n");
		sym.pop();
	}

	

	public static String getFileText(File f) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader(f.toString()));
		StringBuilder sb = new StringBuilder();
		String line = br.readLine();
		while (line != null) {
		    sb.append(line);
		    sb.append(System.lineSeparator());
		    line = br.readLine();
			}
		String everything = sb.toString();
		br.close();
		return everything;
	}

	public static void main(String[] args) throws Exception{
		System.out.println("Inserire path del programma su cui effettuare il typechecking:");
		Scanner sc = new Scanner(System.in);
		String path=sc.next();
		File f=new File(path);
		if(!f.exists() || f.isDirectory()) { 
		        	System.out.println("Non esiste il file!");
		        	System.exit(0);
				}
		CharStream input = new ANTLRInputStream(FoolTypeChecker.getFileText(f));
		FoolLexer lexer = new FoolLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		FoolParser parser = new FoolParser(tokens);
		FoolParser.ProgContext tree = parser.prog();
		ParseTreeWalker walker = new ParseTreeWalker();
		FoolTypeChecker extractor = new FoolTypeChecker();
		walker.walk(extractor, tree);
	}
}




	/*@Override public void exitAsm(FoolParser.AsmContext ctx) { 
		if(sym.peek().get(ctx.t.getText()) != e.){
			System.out.println("Semantic Error!");
			System.exit(0);
		}

	}
	
	@Override public void exitFieldAsm(FoolParser.FieldAsmContext ctx) { 
		if(sym.peek().get(ctx.t.getText()) != e.){
			System.out.println("Semantic Error!");
			System.exit(0);
		}
	}

	@Override public void exitIntExp(FoolParser.IntExpContext ctx) { 

	}

	@Override public void exitBoolExp(FoolParser.BoolExpContext ctx) { 

	}

	@Override public void enterMethodCall(FoolParser.MethodCallContext ctx) { }
	
	@Override public void exitMethodCall(FoolParser.MethodCallContext ctx) { }
	
	@Override public void enterClassInstantiation(FoolParser.ClassInstantiationContext ctx) { }
	
	@Override public void exitClassInstantiation(FoolParser.ClassInstantiationContext ctx) { }
	
	@Override public void enterStatement(FoolParser.StatementContext ctx) { }
	
	@Override public void exitStatement(FoolParser.StatementContext ctx) { } */