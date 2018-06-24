
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.*;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;

import codegen.ExecuteVM;
import parser.FoolLexer;
import parser.FoolParser;
import svm.SVMLexer;
import svm.SVMParser;
import util.Environment;
import util.SemanticError;
import ast.FoolVisitorTypeChecker;
import ast.Node;
import exception.TypeException;
import java.io.IOException;
import lib.FOOLlib;

public class Test extends BaseErrorListener{
   
    public void syntaxError(Recognizer<?, ?> recognizer,
        Object offendingSymbol,
        int line, int charPositionInLine,
        String msg,
        RecognitionException e)
    {
        List<String> stack = ((Parser)recognizer).getRuleInvocationStack();
        Collections.reverse(stack);
        System.err.println("rule stack: "+stack);
        System.err.println("line "+line+":"+charPositionInLine+" at "+
        offendingSymbol+": "+msg);
    }

    private static int maxMemsizeWithoutRecursion;
     //    version with memory counter incrementing by push()
    private static void computeMemoryCapacity(String SVMcode) {
        String[] instructions = SVMcode.split("\n");
        maxMemsizeWithoutRecursion = 0;
        for (String instruction1 : instructions) {
            String instruction = instruction1.split(" ")[0];
            // System.out.println("Instruction " + i + " is " + instruction);
            switch (instruction) {
                case "print":
                case "halt":
                case "cfp":
                case "bleq":
                case "beq":
                case "b":
                case "sw":
                case "pop":
                case "js":
                case "sra":
                case "srv":
                case "sfp":
                case "shp":   // no increment
                    break;
                case "new":
                case "lc":
                case "copy":
                case "lra":
                case "lhp":
                case "lrv":
                case "lfp":
                case "lw":
                case "div":
                case "sub":
                case "mult":
                case "add":
                case "push":   // 1 increment
                    maxMemsizeWithoutRecursion++;
                    break;
                default:   // reached for labels and blank lines
                    break;
            }
        }
    }
    
    public static Node lexerParser(String fileName){
        try{
        FileInputStream is = new FileInputStream(fileName);
        ANTLRInputStream input = new ANTLRInputStream(is);
        
        FoolLexer lexer = new FoolLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        FoolParser parser = new FoolParser(tokens);
        parser.removeErrorListeners(); // remove ConsoleErrorListener
        parser.addErrorListener(new Test());
        if(parser.getNumberOfSyntaxErrors()>0){
            System.out.println("Syntax error found! Exiting process..");
            return null;
        }
        System.out.println("Lexing and parsing process ok.\n Start semantic check..");
        return typeChecking(parser);
        }catch(IOException e){
            System.out.println("File not found!");
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public static Node typeChecking(FoolParser parser){
        FoolVisitorTypeChecker visitor = new FoolVisitorTypeChecker();

        Node ast = visitor.visit(parser.prog()); //generazione AST 

        Environment env = new Environment();
        ArrayList<SemanticError> err = ast.checkSemantics(env);

        if(err.size()>0){
                System.out.println("You had: " +err.size()+" semantic errors:");
                for(SemanticError e : err)
                        System.out.println("\t" + e);
                ast=null;
        }else{	
            System.out.println("Semantic check ok!\n Visualizing AST...");
            System.out.println(ast.toPrint(""));
            System.out.println("Start type checking..");
            try{
                
                Node type = ast.typeCheck(); //type-checking bottom-up 
                System.out.println(type.toPrint("Type checking ok! Type of the program is: "));
            }catch(TypeException e){
                System.out.println("You had a type checking error!");
                System.out.println(e.getMessage());
                ast=null;
                }
        }
     return ast;
    }
    
    public static boolean codeGenRun(Node ast, String fileName) {
        try{
            System.out.println("Start code generation and writing in "+fileName+".asm...");
            String code=ast.codeGeneration();
            //System.out.println("CODICE\n "+code+"FINE CODICE");
            code += FOOLlib.generateDispatchTablesCode();
            computeMemoryCapacity(code);
            //System.out.println("CODICE DOPO \n "+code+"FINE CODICE DOPO");
            BufferedWriter out = new BufferedWriter(new FileWriter(fileName+".asm")); 
            out.write(code);
            out.close(); 
            System.out.println("Code generated! Assembling and running generated code...");
            FileInputStream isASM = new FileInputStream(fileName+".asm");
            ANTLRInputStream inputASM = new ANTLRInputStream(isASM);
            SVMLexer lexerASM = new SVMLexer(inputASM);
            CommonTokenStream tokensASM = new CommonTokenStream(lexerASM);
            SVMParser parserASM = new SVMParser(tokensASM);
            parserASM.assembly();
            System.out.println("Code assembled!\nYou had: "+lexerASM.errors.size()+" lexical errors and "+parserASM.getNumberOfSyntaxErrors()+" syntax errors in assembled code.");
            if (lexerASM.errors.size()>0 || parserASM.getNumberOfSyntaxErrors()>0) System.exit(1);
            
            /*System.out.println("BYTECODE PRINTING");
            for(int t : parserASM.getBytecode())
                System.out.println(t);
            System.out.println("BYTECODE PRINTING END");*/
            
            System.out.println("Starting VM (allocated dimensions: bytecode length " + code.length() + ", occupied memory " + maxMemsizeWithoutRecursion + ")");
            ExecuteVM vm = new ExecuteVM(parserASM.getBytecode(), true);
            ArrayList<String> result= vm.cpu();
            boolean res=true;
            if(result.size() >0)
                for(String s: result){
                    System.out.println("CODE OUTPUT:\n"+s);
                    if(s.contains("Error:"))
                        res=false;
                }
            return res;
        }catch(IOException e){
            System.out.println("IOException occurred!\n"+e.getMessage());
            return false;
        }
    }

    public static void main(String[] args){

        //String fileName = "/home/francesco/Documenti/JavaApplication1/test/prova.fool";
        String fileName = "test/prova.fool";

        System.out.println("Lexing and parsing of input code...");
        FOOLlib.reset();
        Node ast=lexerParser(fileName);
        if(ast==null)
            System.exit(0);
        else{
            if(codeGenRun(ast, fileName))
                System.out.println("EXITING PROCESS, ALL DONE CORRECTLY");
            else
                System.out.println("EXITING PROCESS WITH ERRORS");
            }
        
        }
    
       
}