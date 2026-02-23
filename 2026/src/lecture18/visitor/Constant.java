package lecture18.visitor;
public class Constant extends Node {
    public int value;
    public Constant(int value) {
        this.value = value;
    }
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}