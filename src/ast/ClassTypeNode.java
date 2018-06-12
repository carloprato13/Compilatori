package ast;

import java.util.ArrayList;
import java.util.HashMap;

import util.Environment;
import util.SemanticError;
import lib.FOOLlib;

public class ClassTypeNode implements Node {
  
  private String classId = "";
  private ClassTypeNode superType = null;
  
  private ArrayList<VarNode> fields = new ArrayList<>();
  private ArrayList<FunNode> methods = new ArrayList<>();

  public ClassTypeNode(String classID, ClassTypeNode superType, ArrayList<VarNode> fields, ArrayList<FunNode> methods) {
        this.classId = classID;
        this.superType = superType;
        this.fields = fields;
        this.methods = methods;
  }

  
  public ClassTypeNode (String i) {
    classId=i;
    fields=null;
    methods=null;
  }  

    public String getId() {
        return classId;
    }
  
  @Override
	public ArrayList<SemanticError> checkSemantics(Environment env) {
           /*
//create result list
  	  ArrayList<SemanticError> res = new ArrayList<SemanticError>();
  	  
  	  //env.offset = -2;
  	  HashMap<String,STentry> hm = env.getHashMap(env.getNestingLevel());
        STentry entry = new STentry(env.getNestingLevel(),type, env.offset--); //separo introducendo "entry"
        
        if ( hm.put(id,entry) != null )
          res.add(new SemanticError("Var id "+id+" already declared"));
        
        res.addAll(exp.checkSemantics(env));
        
        return res;*/
           return null;
	}
  
  public String toPrint(String s) {
	/*return s+"Var:" + id +"\n"
	  	   +type.toPrint(s+"  ")  
           +exp.toPrint(s+"  "); */
        return "";
  }
  
  //valore di ritorno non utilizzato
  public Node typeCheck () {
    /*if (! (FOOLlib.isSubtype(exp.typeCheck(),type)) ){      //isSubtype in realtà è un'uguaglianza
      System.out.println("incompatible value for variable "+id);
      System.exit(0);
    }     */
    return null;
  }
  
  public String codeGeneration() {
		return "";//return exp.codeGeneration();
  }  
    
  public ArrayList<VarNode> getFields() {
        return fields;
    }

    public HashMap<String, Node> getFieldsMap() {
        HashMap<String, Node> fieldsMap = new HashMap<>();
        for (VarNode f : fields) {
            fieldsMap.put(f.getId(), f.getType());
        }
        return fieldsMap;
    }

    public ArrayList<FunNode> getMethods() {
        return methods;
    }

    /*
        Returns an HashMap of all methods defined in this class or any subclass
     */
    public HashMap<String, ArrowTypeNode> getMethodsMap() {
        HashMap<String, ArrowTypeNode> methodsMap = new HashMap<>();
        if(superType != null) {
            HashMap<String, ArrowTypeNode> superMethodsMap = superType.getMethodsMap();
            for (String m : superMethodsMap.keySet())
                methodsMap.put(m, superMethodsMap.get(m));
        }
        for (FunNode m : methods) {
            methodsMap.put(m.getId(), m.getType());
        }
        return methodsMap;
    }

    public int getOffsetOfMethod(String methodID) throws UndeclaredMethodException {
        HashMap<String, Integer> methodsMap = methodsMapFromSuper();
        Integer offset = methodsMap.get(methodID);
        if (offset != null) {
            return offset + 1;
        } else {
            throw new UndeclaredMethodException(methodID);
        }
    }

    public HashMap<String, Integer> methodsMapFromSuper() {
        if (superType == null) {
            HashMap<String, Integer> methodsMap = new HashMap<>();
            for (FunNode method : methods) {
                methodsMap.put(method.getId(), methodsMap.size());
            }
            return methodsMap;
        } else {
            HashMap<String, Integer> superMethodsMap = superType.methodsMapFromSuper();
            for (FunNode method : methods) {
                if (!superMethodsMap.containsKey(method.getId())) {
                    superMethodsMap.put(method.getId(), superMethodsMap.size());
                }
            }
            return superMethodsMap;
        }
    }

    public Type getTypeOfMethod(String id) {
        FunNode method = this.methods
                .stream()
                .filter(m -> m.getId().equals(id))
                .reduce(null, (prev, curr) -> curr);
        if (method != null) {
            return method.getType();
        } else if (superType != null) {
            return superType.getTypeOfMethod(id);
        } else {
            return new VoidType();
        }
    }

    /*
    public String getID() {
        return TypeID.CLASSDEC;
    }

    
    public boolean isSubTypeOf(Type t2) {
        // Procedo solo se l'altro tipo e' una classe
        if (t2 instanceof ClassType) {
            ClassType ct2 = (ClassType) t2;
            // Se e' della stessa classe
            if (this.getClassID().equals(ct2.getClassID())) {
                return true;
            }
            // Procedo solo se la mia classe ha un supertipo
            if (superType != null) {
                return this.getSuperclassID().equals(ct2.getClassID()) || superType.isSubTypeOf(t2);
            }
        }
        return false;
    }*/

    @Override
    public String toString() {
        return "class " + classId;
    }

  
}  