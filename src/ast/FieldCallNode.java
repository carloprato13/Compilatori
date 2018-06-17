/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ast;

import exception.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Environment;
import util.SemanticError;
import parser.FoolParser.*;
/**
 *
 * @author francesco
 */
public class FieldCallNode implements Node{
    
    private int objectOffset;
    private int objectNestingLevel;
    private int fieldOffset;
    private int nestinglevel;
    
    private String objectID;
    private String fieldID;
    private Node fieldType;
    
    public FieldCallNode(String callId, String field) {
        this.objectID = callId;
        this.fieldID = field;
    }

    @Override
    public String toPrint(String indent) {
        return indent + this.toString();
    }
    
    public String toString() {
        return objectID + "." + fieldID + "()";
    }

    @Override
    public Node typeCheck() {
        //ArrowTypeNode t = (ArrowTypeNode) this.fieldType;
        
        //Da modificare, deve essere fatto simile ad Idnode
        return this;
    }   

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> res = new ArrayList<>();

        this.nestinglevel = env.getNestingLevel();
        ClassTypeNode classType = null;
        if (objectID.equals("this")) {
            try{
            Node objectType = env.getLatestClassEntry().getNode();
            // Se il metodo e' chiamato su this, l'offset rispetto a $fp e' sempre 0
            this.objectOffset = 0;
            if (objectType instanceof ClassTypeNode) {
                classType = (ClassTypeNode) objectType;
                // L'oggetto e' sempre al livello dei parametri di metodo, ovvero 3
                this.objectNestingLevel = 3;
            } else {
                res.add(new SemanticError("Can't call this outside a class"));
            }
            }catch(UndeclaredVarException e){
                res.add(new SemanticError("variable not declared riga 71 fieldcall"));
            }
        } else {
            try{
            STentry objectSEntry = env.getLatestEntryOf(objectID);
            Node objectType = objectSEntry.getNode();
            this.objectOffset = objectSEntry.getOffset();
            this.objectNestingLevel = objectSEntry.getNestinglevel();
            //env.getLatestEntryOf("this");
            this.nestinglevel--;
            // Controllo che il metodo sia stato chiamato su un oggetto
            if (objectType instanceof ClassTypeNode) {
                classType = (ClassTypeNode) objectType;//((ClassTypeNode) objectType).getClassType();
            } else {
                res.add(new SemanticError("Attribute " + fieldID + " called on a non-object type"));
                return res;
            }
            }catch(UndeclaredVarException e){
                res.add(new SemanticError("variable not declared riga 89 fieldcall"));
            }
        }
        try {
        STentry classEntry = objectID.equals("this")
                ? env.getLatestClassEntry()
                : env.getLatestEntryOf(classType.getId());
        ClassTypeNode objectClass = (ClassTypeNode) classEntry.getNode();
        //serve getTypeOfField in ClassTypeNode
        this.fieldType = objectClass.getTypeOfMethod(fieldID);
        //L'offset degli attributi è diversa da quella dei metodi
            this.fieldOffset = objectClass.getOffsetOfMethod(fieldID);
        } catch (UndeclaredMethodException ex) {
            Logger.getLogger(MethodCallNode.class.getName()).log(Level.SEVERE, null, ex);
        }catch(UndeclaredVarException e){
                res.add(new SemanticError("variable not declared riga 104 fieldcall"));
            }
 
        if (this.fieldType == null) {
            res.add(new SemanticError("Object " + objectID + " doesn't have a " + fieldID + " attribute."));
        }

        return res;
    }

    @Override
    public String codeGeneration() {
        
        StringBuilder getAR = new StringBuilder();

        for (int i = 0; i < nestinglevel - objectNestingLevel; i++)
            getAR.append("lw\n");

        return "lfp\n"                                  // carico il frame pointer
                //+ parCode                               // carico i parametri
                + "push " + objectOffset + "\n"         // carico l'offset dell'oggetto nello scope di definizione
                + "lfp\n"                               // carico il frame pointer
                + getAR                                 // faccio gli lw necessari fino a trovarmi sullo stack l'indirizzo in memoria del frame dove e' definito l'oggetto
                + "add\n"                               // faccio $fp + offset per ottenere l'indirizzo in memoria dell'oggetto
                + "lw\n"                                // carico il valore dell'oggetto sullo stack
                + "copy\n"                              // copio il valore sopra (l'indirizzo di memoria nel quale si trova l'indirizzo della dispatch table)
                + "lw\n"                                // carico l'indirizzo della dispatch table sullo stack
                + "push " + (fieldOffset - 1) + "\n"   // carico l'offset del metodo rispetto all'inizio della dispatch table
                + "add" + "\n"                          // carico sullo stack dispatch_table_start + offset
                + "lc\n"                                // trovo l'indirizzo del metodo
                + "js\n";                               // salto all'istruzione dove e' definito il metodo e salvo $ra
    
    }

    @Override
    public boolean isSubTypeOf(Node m) {
        return fieldType.isSubTypeOf (m);
    }
    
}
