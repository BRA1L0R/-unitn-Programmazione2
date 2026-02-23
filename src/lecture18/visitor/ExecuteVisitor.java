package lecture18.visitor;
public class ExecuteVisitor implements Visitor{
    private int result = 0;
    public int getResult() {
        return result;
    }
    @Override
    public void visit(Constant constant) {
        this.result = constant.value;
    }
    @Override
    public void visit(Binary binary) {
        binary.left.accept(this);
        int leftSide = this.result;
        binary.right.accept(this);
        int rightSide = this.result;
        this.result = leftSide + rightSide;
    }
}