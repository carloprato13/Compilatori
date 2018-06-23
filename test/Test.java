
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.ArrayList;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

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
import lib.FOOLlib;
import org.antlr.v4.runtime.BaseErrorListener;

public class Test {
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
                    System.out.println("ERROR! Unknown SVM instruction '" + instruction +"' found in computing VM memory.");
                    break;
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        
        //String fileName = "/home/francesco/Documenti/JavaApplication1/test/prova.fool";
        String fileName = "/home/carlo/NetBeansProjects/Compilatori/test/prova.fool";
      
        FileInputStream is = new FileInputStream(fileName);
        ANTLRInputStream input = new ANTLRInputStream(is);
        FoolLexer lexer = new FoolLexer(input);
        
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        FoolParser parser = new FoolParser(tokens);
        
        FoolVisitorTypeChecker visitor = new FoolVisitorTypeChecker();

        Node ast = visitor.visit(parser.prog()); //generazione AST 

        Environment env = new Environment();
        ArrayList<SemanticError> err = ast.checkSemantics(env);

        if(err.size()>0){
                System.out.println("You had: " +err.size()+" semantic errors:");
                for(SemanticError e : err)
                        System.out.println("\t" + e);
        }else{	
            System.out.println("Visualizing AST...");
            System.out.println(ast.toPrint(""));

            try{
                Node type = ast.typeCheck(); //type-checking bottom-up 
                System.out.println(type.toPrint("Type checking ok! Type of the program is: "));
            }catch(TypeException e){
                System.out.println("You had a type checking error!");
                System.out.println(e.getMessage());
                System.exit(0);
                    }
            // CODE GENERATION  prova.fool.asm
            String code=ast.codeGeneration();
            code += FOOLlib.generateDispatchTablesCode();
            BufferedWriter out = new BufferedWriter(new FileWriter(fileName+".asm")); 
            out.write(code);
            out.close(); 
            System.out.println("Code generated! Assembling and running generated code.");
            
            FileInputStream isASM = new FileInputStream(fileName+".asm");
            ANTLRInputStream inputASM = new ANTLRInputStream(isASM);
            SVMLexer lexerASM = new SVMLexer(inputASM);
            CommonTokenStream tokensASM = new CommonTokenStream(lexerASM);
            SVMParser parserASM = new SVMParser(tokensASM);

            parserASM.assembly();

            System.out.println("You had: "+lexerASM.errors.size()+" lexical errors and "+parserASM.getNumberOfSyntaxErrors()+" syntax errors.");
            if (lexerASM.errors.size()>0 || parserASM.getNumberOfSyntaxErrors()>0) System.exit(1);
            FOOLlib.reset();
            System.out.println("Starting VM (allocated dimensions: bytecode " + code.length() + ", memory " + maxMemsizeWithoutRecursion + ")");
            ExecuteVM vm = new ExecuteVM(parserASM.getBytecode(), false);
            ArrayList<String> result= vm.cpu();
            if(result.size() >0)
                for(String s: result)
                    System.out.println("RESULT: "+s);
            System.out.println("EXITING PROCESS, ALL DONE");
	    }
    }
       
}