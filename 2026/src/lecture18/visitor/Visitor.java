package lecture18.visitor;
public interface Visitor {
    default void visit(Binary binary) {
        if (binary.left != null) {
            binary.left.accept(this);
        }
        if (binary.right != null) {
            binary.right.accept(this);
        }
    }
    default void visit(Constant constant) {
    }
}