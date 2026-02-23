package lecture18.visitor;
public class CountVisitor implements Visitor {
    private int count = 0;
    public int getCount() {
        return count;
    }
    @Override
    public void visit(Constant constant) {
        count++;
    }
}