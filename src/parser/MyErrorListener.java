/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import java.util.ArrayList;
import java.util.BitSet;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;

/**
 *
 * @author carlo
 */
public class MyErrorListener extends BaseErrorListener {
    
    private ArrayList<String> errors ;
    
    public MyErrorListener(){
        super();
        errors= new ArrayList<>();
    }
    
    
    //public void reportAmbiguity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, boolean exact, BitSet ambigAlts, ATNConfigSet configs){}
    
    //public void reportAttemptingFullContext(Parser recognizer, DFA dfa, int startIndex, int stopIndex, BitSet conflictingAlts, ATNConfigSet configs){}
    
    //public void reportContextSensitivity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, int prediction, ATNConfigSet configs){}
    
    public void syntaxError(Recognizer<?,?> r, Object o, int l, int c, String msg, RecognitionException e){
    errors.add("Error at Line "+l+" Column "+c+" for "+msg/*+" exception "+e.getMessage()*/); 
    }
    
    public ArrayList<String> getErrors() {return errors;}
    
}
