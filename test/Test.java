
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.ArrayList;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

//import parser.ExecuteVM;
import parser.FoolLexer;
import parser.FoolParser;
//import parser.SVMLexer;
//import parser.SVMParser;
import util.Environment;
import util.SemanticError;
import ast.FoolVisitorTypeChecker;
import ast.Node;
import exception.TypeException;
import org.antlr.v4.runtime.BaseErrorListener;
import parser.MyErrorListener;

public class Test {
    
    public static void main(String[] args) throws Exception {
        
        //String fileName = "/home/francesco/Documenti/JavaApplication1/test/prova.fool";
        String fileName = "/home/carlo/NetBeansProjects/Compilatori/test/prova.fool";
      
        FileInputStream is = new FileInputStream(fileName);
        ANTLRInputStream input = new ANTLRInputStream(is);
        FoolLexer lexer = new FoolLexer(input);
        
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        FoolParser parser = new FoolParser(tokens);
        MyErrorListener m=new MyErrorListener();
        parser.addErrorListener(m);
        if(m.getErrors().size()>0){
            System.out.println("Lexical errors detected!");
            for(String s : m.getErrors())
                System.out.println(s);
            System.exit(0);
            }
        FoolVisitorTypeChecker visitor = new FoolVisitorTypeChecker();

        Node ast = visitor.visit(parser.prog()); //generazione AST 

        Environment env = new Environment();
        ArrayList<SemanticError> err = ast.checkSemantics(env);

        if(err.size()>0){
                System.out.println("You had: " +err.size()+" errors:");
                for(SemanticError e : err)
                        System.out.println("\t" + e);
        }else{	
            System.out.println("Visualizing AST...");
            System.out.println(ast.toPrint(""));

            try{
                Node type = ast.typeCheck(); //type-checking bottom-up 
                System.out.println(type.toPrint("Type checking ok! Type of the program is: "));
            }catch(TypeException e){
                System.out.println(e.getMessage());
                System.exit(0);
                    }
            // CODE GENERATION  prova.fool.asm
            String code=ast.codeGeneration(); 
            BufferedWriter out = new BufferedWriter(new FileWriter(fileName+".asm")); 
            out.write(code);
            out.close(); 
            System.out.println("Code generated! Assembling and running generated code.");
            /*
            FileInputStream isASM = new FileInputStream(fileName+".asm");
            ANTLRInputStream inputASM = new ANTLRInputStream(isASM);
            SVMLexer lexerASM = new SVMLexer(inputASM);
            CommonTokenStream tokensASM = new CommonTokenStream(lexerASM);
            SVMParser parserASM = new SVMParser(tokensASM);

            parserASM.assembly();

            System.out.println("You had: "+lexerASM.lexicalErrors+" lexical errors and "+parserASM.getNumberOfSyntaxErrors()+" syntax errors.");
            if (lexerASM.lexicalErrors>0 || parserASM.getNumberOfSyntaxErrors()>0) System.exit(1);

            System.out.println("Starting Virtual Machine...");
            ExecuteVM vm = new ExecuteVM(parserASM.code);
            vm.cpu();*/
	    }
    }
       
}