package ast;

//import exception.RedeclaredVarException;
import util.SemanticError;
import org.antlr.v4.runtime.ParserRuleContext;
import util.Environment;
//import type.ClassType;
//import type.FunType;
//import type.Type;
//import exception.TypeException;
//import util.Field;
//import util.Method;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;

public class ProgClassExpNode implements Node {

    private ArrayList<ClassdNode> classDeclarations;
    private ProgLetInNode p;

    public ProgClassExpNode(ParserRuleContext ctx, ArrayList<ClassdNode> classDeclaration, ProgLetInNode ps) {
        this.classDeclarations = classDeclaration;
        this.p=ps;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> res = new ArrayList<SemanticError>();

        env.pushHashMap();

        // preliminary class inserting in symbol table for order independent references

        /*for (ClassdNode classNode : classDeclarations) {
            //try {
                ArrayList<Field> fields = new ArrayList<Field>();
                for (VarNode field : classNode.getVardeclist()) {
                    fields.add(new Field(field.getID(), field.getType()));
                }
                ArrayList<Method> methods = new ArrayList<Method>();
                for (MethodNode method : classNode.getMetDecList()) {
                    ArrayList<Type> paramsType = new ArrayList<>();
                    for (VarNode parameter : method.getParams()) {
                        paramsType.add(parameter.getType());
                    }
                    methods.add(new Method(method.getId(), new ArrowTypeNode(paramsType, method.getDeclaredReturnType())));
                }
                ClassTypeNode classType = new ClassTypeNode(classNode.getClassID(), new ClassTypeNode(classNode.getSuperClassID()), fields, methods);
                env.addEntry(classNode.getClassID(), classType, 0);
            /*} catch (RedeclaredVarException e) {
                res.add(new SemanticError("Class '" + classNode.getClassID() + "' declared multiple times"));
            }
        }

        for (ClassdNode classNode : classDeclarations) {
            res.addAll(classNode.checkSemantics(env));
        }

        p.checkSemantics(env);

        env.popHashMap();

        return res; DA TERMINARE CON FIELD E METHOD*/
        return null;
    }

    
    public Node typeCheck() /*throws TypeException*/ {
        for (ClassdNode classdec : classDeclarations) {
            classdec.typeCheck();
        }
        return p.typeCheck();
    }

    
    public String codeGeneration() {
        String declaration = "";
        ArrayList<ClassdNode> orderClassDeclarations = new ArrayList<ClassdNode>();
        HashMap<String, ClassdNode> classesAddedMap = new HashMap<String, ClassdNode>();

        // this two loops are for order class declaration in top-down order to generate correct code and dispatch tables
        ListIterator iterator = classDeclarations.listIterator();
        while(iterator.hasNext()){
            ClassdNode classDec = (ClassdNode) iterator.next();
            if (classDec.getSuperClassID() == null || classDec.getSuperClassID().isEmpty()){
                orderClassDeclarations.add(classDec);
                classesAddedMap.put(classDec.getClassID(), classDec);
                iterator.remove();
            }
        }

        while (classDeclarations.size() != 0) {
            iterator = classDeclarations.listIterator();
            while(iterator.hasNext()){
                ClassdNode childClassDec = (ClassdNode) iterator.next();
                String fatherClassName = childClassDec.getSuperClassID();
                ClassdNode fatherClassDec = classesAddedMap.get(fatherClassName);
                if (fatherClassDec != null){
                    orderClassDeclarations.add(childClassDec);
                    classesAddedMap.put(childClassDec.getClassID(), childClassDec);
                    iterator.remove();
                }
            }
        }

        for (ClassdNode cl : orderClassDeclarations) {
            declaration += cl.codeGeneration();
        }

        return declaration + p.codeGeneration();
    }

    public ArrayList<Node> getChilds() {
        ArrayList<Node> childs = new ArrayList<>();
        childs.addAll(classDeclarations);

        childs.add(p);
        return childs;
    }

    public String toPrint(String s) {
        return s+"class declarations";
    }

}
