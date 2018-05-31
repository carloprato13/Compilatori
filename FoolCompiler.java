
import java.util.*;
import java.io.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class FoolCompiler extends FoolBaseListener{

	private Hashtable<String, String> sym;

	public FoolCompiler() {
		sym = new Hashtable<String, String>();
	} 

	@Override public void enterSingleExp(FoolParser.SingleExpContext ctx) {}
	
	@Override public void exitSingleExp(FoolParser.SingleExpContext ctx) { }
	
	@Override public void enterLetInExp(FoolParser.LetInExpContext ctx) { }
	
	@Override public void exitLetInExp(FoolParser.LetInExpContext ctx) { }
	
	@Override public void enterLet(FoolParser.LetContext ctx) {

	 }
	
	@Override public void exitLet(FoolParser.LetContext ctx) { }
	
	@Override public void enterVardec(FoolParser.VardecContext ctx) {
		
	 }
	
	@Override public void exitVardec(FoolParser.VardecContext ctx) {
		System.out.println("exitVardec: "+ctx.t.getText()+" "+ctx.name.getText()+"\n");
		sym.put(ctx.t.getText(), ctx.name.getText());
	 }
	
	@Override public void enterVarasm(FoolParser.VarasmContext ctx) { }
	
	@Override public void exitVarasm(FoolParser.VarasmContext ctx) { }
	
	@Override public void enterFun(FoolParser.FunContext ctx) { }
	
	@Override public void exitFun(FoolParser.FunContext ctx) { }
	
	@Override public void enterVarAssignment(FoolParser.VarAssignmentContext ctx) { }
	
	@Override public void exitVarAssignment(FoolParser.VarAssignmentContext ctx) { }
	
	@Override public void enterFunDeclaration(FoolParser.FunDeclarationContext ctx) { }
	
	@Override public void exitFunDeclaration(FoolParser.FunDeclarationContext ctx) { }
	
	@Override public void enterClassDeclaration(FoolParser.ClassDeclarationContext ctx) { }
	
	@Override public void exitClassDeclaration(FoolParser.ClassDeclarationContext ctx) { }
	
	@Override public void enterType(FoolParser.TypeContext ctx) { }
	
	@Override public void exitType(FoolParser.TypeContext ctx) { }
	
	@Override public void enterBracketedExp(FoolParser.BracketedExpContext ctx) { }

	@Override public void exitBracketedExp(FoolParser.BracketedExpContext ctx) { }
	
	@Override public void enterIntExp(FoolParser.IntExpContext ctx) { }
	
	@Override public void exitIntExp(FoolParser.IntExpContext ctx) { }
	
	@Override public void enterBoolExp(FoolParser.BoolExpContext ctx) { }
	
	@Override public void exitBoolExp(FoolParser.BoolExpContext ctx) { }
	
	@Override public void enterCompExp(FoolParser.CompExpContext ctx) { }
	
	@Override public void exitCompExp(FoolParser.CompExpContext ctx) { }
	
	@Override public void enterFunctionCall(FoolParser.FunctionCallContext ctx) { }
	
	@Override public void exitFunctionCall(FoolParser.FunctionCallContext ctx) { }
	
	@Override public void enterMethodCall(FoolParser.MethodCallContext ctx) { }
	
	@Override public void exitMethodCall(FoolParser.MethodCallContext ctx) { }
	
	@Override public void enterFieldReference(FoolParser.FieldReferenceContext ctx) { }
	
	@Override public void exitFieldReference(FoolParser.FieldReferenceContext ctx) { }
	
	@Override public void enterClassInstantiation(FoolParser.ClassInstantiationContext ctx) { }
	
	@Override public void exitClassInstantiation(FoolParser.ClassInstantiationContext ctx) { }
	
	@Override public void enterNullValue(FoolParser.NullValueContext ctx) { }
	
	@Override public void exitNullValue(FoolParser.NullValueContext ctx) { }
	
	@Override public void enterStatement(FoolParser.StatementContext ctx) { }
	
	@Override public void exitStatement(FoolParser.StatementContext ctx) { }
	
	@Override public void enterIntTerm(FoolParser.IntTermContext ctx) { }
	
	@Override public void exitIntTerm(FoolParser.IntTermContext ctx) { }
	
	@Override public void enterStms(FoolParser.StmsContext ctx) { }
	
	@Override public void exitStms(FoolParser.StmsContext ctx) { }
	
	@Override public void enterStm(FoolParser.StmContext ctx) { }
	
	@Override public void exitStm(FoolParser.StmContext ctx) { }
	
	@Override public void enterFactor(FoolParser.FactorContext ctx) { }
	
	@Override public void exitFactor(FoolParser.FactorContext ctx) { }
	
	@Override public void enterIntVal(FoolParser.IntValContext ctx) { }
	
	@Override public void exitIntVal(FoolParser.IntValContext ctx) { }
	
	@Override public void enterBoolVal(FoolParser.BoolValContext ctx) { }

	@Override public void exitBoolVal(FoolParser.BoolValContext ctx) { }
	
	@Override public void enterBaseExp(FoolParser.BaseExpContext ctx) { }
	
	@Override public void exitBaseExp(FoolParser.BaseExpContext ctx) { }
	
	@Override public void enterIfExp(FoolParser.IfExpContext ctx) { }
	
	@Override public void exitIfExp(FoolParser.IfExpContext ctx) { }
	
	@Override public void enterVarExp(FoolParser.VarExpContext ctx) { }
	
	@Override public void exitVarExp(FoolParser.VarExpContext ctx) { }
	
	@Override public void enterFunExp(FoolParser.FunExpContext ctx) { }
	
	@Override public void exitFunExp(FoolParser.FunExpContext ctx) { }

	@Override public void enterEveryRule(ParserRuleContext ctx) { }
	
	@Override public void exitEveryRule(ParserRuleContext ctx) { }
	

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
		System.out.println("Inserire path del programma da compilare:");
		Scanner sc = new Scanner(System.in);
		String path=sc.next();
		File f=new File(path);
		if(!f.exists() || f.isDirectory()) { 
		        	System.out.println("Non esiste il file!");
		        	System.exit(0);
				}
		CharStream input = new ANTLRInputStream(FoolCompiler.getFileText(f));
		FoolLexer lexer = new FoolLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		FoolParser parser = new FoolParser(tokens);
		FoolParser.ProgContext tree = parser.prog();
		ParseTreeWalker walker = new ParseTreeWalker();
		FoolCompiler extractor = new FoolCompiler();
		walker.walk(extractor, tree);
	}
}