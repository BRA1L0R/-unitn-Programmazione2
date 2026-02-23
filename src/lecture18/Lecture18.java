package lecture18;
import lecture18.visitor.*;
public class Lecture18 {
    public static void main(String[] args) {
        System.out.println("=== THE VISITOR PATTERN ===");
        Node expression = new Binary(
                new Constant(5),
                new Binary(
                        new Constant(3),
                        new Constant(2)
                )
        );
        PrintVisitor printer = new PrintVisitor();
        System.out.print("Output: ");
        expression.accept(printer);
        System.out.println();
        CountVisitor counter = new CountVisitor();
        expression.accept(counter);
        System.out.println("Constant Count: " + counter.getCount());
        ExecuteVisitor eval = new ExecuteVisitor();
        expression.accept(eval);
        System.out.println("Result " + eval.getResult());
    }
}