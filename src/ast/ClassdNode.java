/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ast;

import util.Environment;
import util.SemanticError;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author carlo
 */
public class ClassdNode implements Node {

    private String classID;
    private String superClassID;
    private ArrayList<VarNode> attrDecList;
    private ArrayList<FunNode> funDecList;

    private HashMap<String, Node> fields = new HashMap<>();
    private HashMap<String, FunNode> functions = new HashMap<>();

    private ClassTypeNode type;

    public ClassdNode(String classID, String superClassID, ArrayList<VarNode> attrDecList, ArrayList<FunNode> funDecList) {
        this.classID = classID;
        this.superClassID = superClassID;
        this.attrDecList = attrDecList;
        this.funDecList = funDecList;
    }

    @Override
    public String toPrint(String indent) {
        return indent + classID;
    }

    public ArrayList<VarNode> getVardeclist() {
        return this.attrDecList;
    }

    public ArrayList<FunNode> getFunDecList() {
        return funDecList;
    }

    public String getClassID() {
        return classID;
    }

    public String getSuperClassID() {
        return superClassID;
    }

    @Override
    public Node typeCheck() {
        for (VarNode vardec : attrDecList) {
            vardec.typeCheck();
        }

        for (FunNode fundec : funDecList) {
            fundec.typeCheck();
        }

        return this.type;
    }

    @Override
    public String codeGeneration() {
          /*StringBuilder declCode = new StringBuilder();
        if (declarations != null)
            for (INode dec : declarations)
                declCode.append(dec.codeGeneration());

        StringBuilder popDecl = new StringBuilder();
        if (declarations != null)
            for (INode dec : declarations)
                popDecl.append("pop\n");

        StringBuilder popParl = new StringBuilder();
        for (INode dec : params)
            popParl.append("pop\n");

        String funl = CodegenUtils.freshFunLabel();
        CodegenUtils.insertFunctionsCode(funl + ":\n" +
                "cfp\n" + //setta $fp a $sp
                "lra\n" + //inserimento return address
                declCode + //inserimento dichiarazioni locali
                body.codeGeneration() +
                "srv\n" + //pop del return value
                popDecl +
                "sra\n" + // pop del return address
                "pop\n" + // pop di AL
                popParl +
                "sfp\n" +  // setto $fp a valore del CL
                "lrv\n" + // risultato della funzione sullo stack
                "lra\n" + "js\n" // salta a $ra
        );

        return "push " + funl + "\n";*/ return null;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {return null;}
    /*    
        ArrayList<SemanticError> res = new ArrayList<>();

        // Usati per creare la entry della classe nella symbol table
        ArrayList<VarNode> fieldsList = new ArrayList<>();
        ArrayList<FunNode> methodsList = new ArrayList<>();

        for (VarNode var : this.attrDecList) {
            fieldsList.add(new VarNode(var.getID(), var.getType()));
            fields.put(var.getId(), var.getType());
        }

        for (FunNode fun : funDecList) { // Per ogni metodo
            ArrayList<Node> paramsType = new ArrayList<>();
            for (Node params : fun.getParams()) { // Controllo i parametri
                VarNode param= (VarNode)params;
                if (param.getType() instanceof InstanceType) { // Se si tratta di oggetti
                    InstanceType paramType = (InstanceType) param.getType();
                    String declaredClass = paramType.getClassType().getClassID();
                    try {
                        ClassTypeNode paramClassType = (ClassTypeNode) env.getLatestEntryOf(declaredClass).getNode();
                        paramsType.add(new InstanceType(paramClassType));
                    } catch (UndeclaredVarException e) {
                        res.add(new SemanticError("Class '" + declaredClass + "' does not exist"));
                    }
                } else { // Se si tratta di valori base
                    paramsType.add(param.getType());
                }
            }

            methodsList.add(new FunNode(fun.getId(), new ArrowTypeNode(paramsType, fun.getDeclaredReturnType())));
            methods.put(fun.getId(), new ArrowTypeNode(paramsType, fun.getDeclaredReturnType()));
        }


        ClassTypeNode superclassType = null;
        try {
            superclassType = (ClassTypeNode) env.getLatestEntryOf(superClassID).getType();
        } catch (UndeclaredVarException e) {
            superclassType = null;
        }

        // Creo una entry per la classe nella Symbol Table
        try {
            this.type = new ClassTypeNode(classID, superclassType, fieldsList, methodsList);
            env.setEntryType(classID, this.type, 0);
        } catch ( UndeclaredClassException e) {
            res.add(new SemanticError(e.getMessage()));
        }

        env.pushHashMap(); // Aggiungo i parametri ad una nuova Symbol Table
        for (VarNode var : attrDecList) {
            if (var.getType() instanceof InstanceType) {
                ClassTypeNode paramClass = ((InstanceType) var.getType()).getClassType();
                //Controllo che i parametri non siano sottotipo della classe in cui sono
                if (paramClass.isSubTypeOf(this.type))
                    res.add(new SemanticError("can't use a subclass in superclass' constructor"));
            }
            res.addAll(var.checkSemantics(env));
        }

        env.pushHashMap(); // Aggiungo i metodi ad una nuova Symbol Table
        for (FunNode fun : metDecList) {
            res.addAll(fun.checkSemantics(env));
        }
        env.popHashMap().popHashMap();

        // Se estende una classe
        if (!superClassID.isEmpty()) {
            try {
                if (!(env.getTypeOf(superClassID) instanceof ClassTypeNode))
                    res.add(new SemanticError("ID of super class " + superClassID + " is not related to a class type"));
            } catch (UndeclaredVarException exp) {
                res.add(new SemanticError("Super class " + superClassID + " not defined"));
            }

            try {
                ClassType superClassType = (ClassType) env.getLatestEntryOf(superClassID).getType();

                // Se ho almeno tanti attributi quanti ne ha la classe padre
                if (attrDecList.size() >= superClassType.getFields().size()) {
                    for (int i = 0; i < superClassType.getFields().size(); i++) { // per ogni attributo del padre
                        VarNode localField = attrDecList.get(i);
                        VarNode superField = superClassType.getFields().get(i);
                        if (!superField.getID().equals(localField.getID()) // se non hanno lo stesso nome
                            || !localField.getType().isSubTypeOf(superField.getType()) ) {  // o non hanno lo stesso tipo
                            res.add(new SemanticError("Field '" + localField.getID() + "' of class '"+ classID+"' overrided from super class with different type"));
                        }
                    }
                } else {
                    res.add(new SemanticError("Subclass has not the superclass parameters."));
                }
            } catch (UndeclaredVarException e) {
                res.add(new SemanticError("Super class " + superClassID + " not defined " + e.getMessage()));
            }

            try {
                STEntry superClassEntry = env.getLatestEntryOf(superClassID);
                ClassTypeNode superClassType = (ClassTypeNode) superClassEntry.getType();

                HashMap<String, ArrowTypeNode> superClassMethods = superClassType.getMethodsMap();
                for (String localMethod : methods.keySet()) {
                    if (superClassMethods.containsKey(localMethod)) {
                        if (!methods.get(localMethod).isSubTypeOf(superClassMethods.get(localMethod))) {
                            res.add(new SemanticError("Method '" + localMethod + "' of class '" + classID + "' overrided with incompatible type"));
                        }
                    }
                }

            } catch (UndeclaredVarException e) {
                res.add(new SemanticError("Super class " + superClassID + " not defined " + e.getMessage()));
            }
        }

        return res;
    }*/

}
