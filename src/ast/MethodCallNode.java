/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ast;

import java.util.ArrayList;
import util.Environment;
import util.SemanticError;
import parser.FoolParser.*;

/**
 *
 * @author carlo
 */
public class MethodCallNode extends CallNode {
    
    
    private int objectOffset;
    private int objectNestingLevel;
    private int methodOffset;
    private int nestinglevel;

    private String objectID;
    private String methodID;
    private Node methodType;

    public MethodCallNode( MethodCallContext ctx, String objectID, String methodID, ArgumentsNode args) {
        super(ctx.funcall(), methodID, args);
        this.objectID = objectID;
        this.methodID = methodID;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> res = new ArrayList<>();

        this.nestinglevel = env.getNestingLevel();
        try {
            ClassTypeNode classType = null;
            // Calcolo gli offset per recuperare l'oggetto
            if (objectID.equals("this")) {
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
            } else {
                STentry objectSEntry = env.getLatestEntryOf(objectID);
                Node objectType = objectSEntry.getNode();
                this.objectOffset = objectSEntry.getOffset();
                this.objectNestingLevel = objectSEntry.getNestinglevel();
                env.getLatestEntryOf("this");
                this.nestinglevel--;
                // Controllo che il metodo sia stato chiamato su un oggetto
                if (objectType instanceof InstanceTypeNode) {
                    classType = ((InstanceTypeNode) objectType).getClassType();
                } else {
                    res.add(new SemanticError("Method " + methodID + " called on a non-object type"));
                    return res;
                }
            }

            // Se il metodo viene chiamato su this, vuol dire che stiamo facendo la semantic analysis
            // della classe, quindi prendo l'ultima entry aggiunta alla symbol table
            STentry classEntry = objectID.equals("this")
                    ? env.getLatestClassEntry()
                    : env.getLatestEntryOf(classType.getId());

            ClassTypeNode objectClass = (ClassTypeNode) classEntry.getNode();
            this.methodOffset = objectClass.getOffsetOfMethod(methodID);
            this.methodType = objectClass.getTypeOfMethod(methodID);
            // Controllo che il metodo esista all'interno della classe
            if (this.methodType == null) {
                res.add(new SemanticError("Object " + objectID + " doesn't have a " + methodID + " method."));
            }

            FunNode t = (FunNode) this.methodType;
            ArrayList<Node> p = t.getParams();
            if (!(p.size() == args.size())) {
                res.add(new SemanticError("Wrong number of parameters in the invocation of " + id));
            }

            res.addAll(args.checkSemantics(env));

        } catch (UndeclaredVarException | UndeclaredMethodException e) {
            res.add(new SemanticError(e.getMessage()));
        }

        return res;
    }

    @Override
    public Node typeCheck() {
        FunNode t = (FunNode) this.methodType;
        ArrayList<Node> p = t.getParams();

        for (int i = 0; i < args.size(); i++)
            if (!args.get(i).type().isSubTypeOf(p.get(i)))
                throw new TypeException("Wrong type for " + (i + 1) + "-th parameter in the invocation of " + id, ctx);

        return t.getType();
    }

    @Override
    public String codeGeneration() {
        StringBuilder parCode = new StringBuilder();
        for (int i = args.size() - 1; i >= 0; i--)
            parCode.append(args.get(i).codeGeneration());

        StringBuilder getAR = new StringBuilder();

        for (int i = 0; i < nestinglevel - objectNestingLevel; i++)
            getAR.append("lw\n");

        return "lfp\n"                                  // carico il frame pointer
                + parCode                               // carico i parametri
                + "push " + objectOffset + "\n"         // carico l'offset dell'oggetto nello scope di definizione
                + "lfp\n"                               // carico il frame pointer
                + getAR                                 // faccio gli lw necessari fino a trovarmi sullo stack l'indirizzo in memoria del frame dove e' definito l'oggetto
                + "add\n"                               // faccio $fp + offset per ottenere l'indirizzo in memoria dell'oggetto
                + "lw\n"                                // carico il valore dell'oggetto sullo stack
                + "copy\n"                              // copio il valore sopra (l'indirizzo di memoria nel quale si trova l'indirizzo della dispatch table)
                + "lw\n"                                // carico l'indirizzo della dispatch table sullo stack
                + "push " + (methodOffset - 1) + "\n"   // carico l'offset del metodo rispetto all'inizio della dispatch table
                + "add" + "\n"                          // carico sullo stack dispatch_table_start + offset
                + "lc\n"                                // trovo l'indirizzo del metodo
                + "js\n";                               // salto all'istruzione dove e' definito il metodo e salvo $ra
    }

    
    public String toString() {
        return objectID + "." + methodID + "()";
    }

    @Override
    public boolean isSubTypeOf(Node m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toPrint(String indent) {
        return indent + this.toString();
    }

    
}
