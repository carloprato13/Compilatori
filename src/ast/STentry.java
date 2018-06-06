package ast;

public class STentry {

    private int nestingLevel;
    private Node Node;
    private int offset;
    private boolean isAttribute;

    public STentry(int nestingLevel, Node Node, int offset) {
        this.nestingLevel = nestingLevel;
        this.Node = Node;
        this.offset = offset;
        this.isAttribute = false;
    }

    public STentry(int nestingLevel, Node Node, int offset, boolean isAttribute) {
        this.nestingLevel = nestingLevel;
        this.Node = Node;
        this.offset = offset;
        this.isAttribute = isAttribute;
    }

    public Node getNode() {
        return Node;
    }

    public int getOffset() {
        return offset;
    }

    public int getNestinglevel() {
        return nestingLevel;
    }

    // Used only for class attributes
    public boolean isAttribute() { return isAttribute; }

    public String toString(String s) { //
        return "STentry: nestlev " + Integer.toString(nestingLevel) + "\n" +
                "STentry: Node " + Node + "\n" +
                "STentry: offset " + Integer.toString(offset) + "\n";
    }
}