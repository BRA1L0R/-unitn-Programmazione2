package lecture18.visitor;
public class PrintVisitor implements Visitor {
    @Override
    public void visit(Constant constant) {
        System.out.print(constant.value);
    }
    @Override
    public void visit(Binary binary) {
        System.out.print("(");
        binary.left.accept(this);
        System.out.print(" + ");
        binary.right.accept(this);
        System.out.print(")");
    }
}