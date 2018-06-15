/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ast;


import exception.*;
import util.Environment;
import util.SemanticError;
import java.util.ArrayList;
import java.util.HashMap;
import lib.*;
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
    public Node typeCheck() throws TypeException {
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
        // Creo una nuova dispatch table
        ArrayList<DispatchTableEntry> dispatchTable;
        if(superClassID==null)
            dispatchTable= new ArrayList<DispatchTableEntry>();
        else
            dispatchTable= FOOLlib.getDispatchTable(superClassID);

        HashMap<String, String> fatherMethods = new HashMap<>();
        for (DispatchTableEntry d : dispatchTable) fatherMethods.put(d.getMethodID(), d.getMethodLabel());
        HashMap<String, String> childMethods = new HashMap<>();
        for (FunNode m : funDecList) childMethods.put(m.getId(), m.codeGeneration());

        for (int i = 0; i < dispatchTable.size(); i++) {
            DispatchTableEntry curr = dispatchTable.get(i);
            String currMethodID = curr.getMethodID();
            String redefinedMethodCode = childMethods.get(currMethodID);
            if (redefinedMethodCode != null) {
                dispatchTable.set(i, new DispatchTableEntry(currMethodID, redefinedMethodCode));
            }
        }
        
        
        for (FunNode m : funDecList) {
            String currMethodID = m.getId();
            if (fatherMethods.get(currMethodID) == null) {
                dispatchTable.add(new DispatchTableEntry(currMethodID, childMethods.get(currMethodID)));
            }
        }

        //Aggiungo sempre la DT anche se è vuota, perchè può capitare di implementare una classe che non ha metodi!
        FOOLlib.addDispatchTable(classID, dispatchTable);

        return "";
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
     
        ArrayList<SemanticError> res = new ArrayList<>();

        // Usati per creare la entry della classe nella symbol table
        ArrayList<VarNode> fieldsList = new ArrayList<>();
        ArrayList<FunNode> methodsList = new ArrayList<>();

        for(VarNode var : this.attrDecList) {
            fieldsList.add(new VarNode(var.getId(), var.getType(), null));
            fields.put(var.getId(), var.getType());
        }

        for (FunNode fun : funDecList) { // Per ogni metodo
            ArrayList<Node> paramsType = new ArrayList<>();
            for (Node params : fun.getParams()) { // Controllo i parametri
                ParNode param= (ParNode)params;
                try{
                if (param.getType() instanceof InstanceTypeNode) { // Se si tratta di oggetti
                    InstanceTypeNode paramType = (InstanceTypeNode) param.getType();
                    String declaredClass = paramType.getClassType().getId();
                   
                    ClassTypeNode paramClassType = (ClassTypeNode) env.getLatestEntryOf(declaredClass).getNode();
                    
                   
                    
                    paramsType.add(new InstanceTypeNode(paramClassType));
                } else { // Se si tratta di valori base
                    paramsType.add(param.getType());
                }
                }catch(UndeclaredVarException e){
                        res.add(new SemanticError("variable " + superClassID + " not defined riga 145"));
                    }
            }
            methodsList.add(new FunNode(fun.getId(), new ArrowTypeNode(paramsType, fun.getType())));
            functions.put(fun.getId(), new FunNode(fun.getId(), fun.getType(), paramsType));
        }

        try{
        ClassTypeNode superclassType = null;
        if (superClassID != null)
            superclassType = (ClassTypeNode) env.getLatestEntryOf(superClassID).getNode();
        
        this.type = new ClassTypeNode(classID, superclassType, fieldsList, methodsList);
        env.setEntryNode(classID, this.type, 0);
        
        }catch(UndeclaredClassException e){
            res.add(new SemanticError("class " + superClassID + " not defined"));
        }catch(UndeclaredVarException e){
            res.add(new SemanticError("variable " + superClassID + " not defined riga 145"));
        }

        env.pushHashMap(); // Aggiungo i parametri ad una nuova Symbol Table
        for (VarNode var : attrDecList) {
            if (var.getType() instanceof InstanceTypeNode) {
                ClassTypeNode paramClass = ((InstanceTypeNode) var.getType()).getClassType();
                //Controllo che i parametri non siano sottotipo della classe in cui sono
                if (paramClass.isSubTypeOf(this.type))
                    res.add(new SemanticError("can't use a subclass in superclass' constructor"));
            }
            res.addAll(var.checkSemantics(env));
        }

        env.pushHashMap(); // Aggiungo i metodi ad una nuova Symbol Table
        for (FunNode fun : funDecList) {
            res.addAll(fun.checkSemantics(env));
        }
        env.popHashMap().popHashMap();

        // Se estende una classe
        if (superClassID!= null) {
            try {
                if (!(env.getNodeOf(superClassID) instanceof ClassTypeNode))
                    res.add(new SemanticError("ID of super class " + superClassID + " is not related to a class type"));
            } catch (UndeclaredVarException exp) {
                res.add(new SemanticError("Super class " + superClassID + " not defined"));
            }
            try {
            ClassTypeNode superClassType = (ClassTypeNode) env.getLatestEntryOf(superClassID).getNode();
            if (attrDecList.size() >= superClassType.getFields().size()) {
                for (int i = 0; i < superClassType.getFields().size(); i++) { // per ogni attributo del padre
                    VarNode localField = attrDecList.get(i);
                    VarNode superField = superClassType.getFields().get(i);
                    if (!superField.getId().equals(localField.getId()) // se non hanno lo stesso nome
                            || !localField.getType().isSubTypeOf(superField.getType()) ) {  // o non hanno lo stesso tipo
                        res.add(new SemanticError("Field '" + localField.getId() + "' of class '"+ classID+"' overrided from super class with different type"));
                    }
                }
            } else {
                res.add(new SemanticError("Subclass has not the superclass parameters."));
            }

            STentry superClassEntry = env.getLatestEntryOf(superClassID);
            superClassType = (ClassTypeNode) superClassEntry.getNode();
            HashMap<String, ArrowTypeNode> superClassMethods = superClassType.getMethodsMap();
            for (String localMethod : functions.keySet()) {
                if (superClassMethods.containsKey(localMethod)) {
                    if (!functions.get(localMethod).isSubTypeOf(superClassMethods.get(localMethod))) {
                        res.add(new SemanticError("Method '" + localMethod + "' of class '" + classID + "' overrided with incompatible type"));
                    }
                }
            }
             } catch (UndeclaredVarException exp) {
                 res.add(new SemanticError("Super class " + superClassID + " not defined"));
             }
            
        }

        return res;
    }
    
    public boolean isSubTypeOf(Node m){
        return type.isSubTypeOf(m);
    }
    
}
