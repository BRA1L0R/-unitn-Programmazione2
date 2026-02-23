package lecture18.visitor;
public class Binary extends Node {
    public Node left;
    public Node right;
    public Binary(Node left, Node right) {
        this.left = left;
        this.right = right;
    }
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}