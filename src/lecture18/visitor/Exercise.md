## The Visitor Pattern
If you truly want to understand dynamic dispatch then learn teh Visitor Pattern.
### Problem
You are given a small programming language for expressions
```
x + 5 + 3
```
represented as an abstract Syntax Tree (AST).
You can print the AST and look at it.
Suppose you want to print the AST like I did above.
We could add a print function
```java
class Node {
    @override
    public print() {
    }
}
```
And then for each of your constructs you will implement
this function
```java
class Binary extends Node{
    Node lhs, rhs;
    BinaryOp op;
    public print() {
        lhs.print();
        op.print();
        rhs.print();
    }
}
```
We first traverse/visit the lhs (using dynamic Dispatch), then print the operator (static binding) and
then the rhs.
We need to do the same for constants and variables as well
```java
class Constant extends Node{
    int num;
    public void print() {
        System.out.print(num);
    }
}
```
There is no more traversing since a Constant is a Leaf in our AST.
Now suppose you want to write a second function that counts the number of constants
```java
class Binary extends Node {
    Node lhs, rhs;
    BinaryOp op;
    public int count() {
        lhs.count() +
        rhs.count();
    }
}
```
Notice that again here we visit the left and right nodes and then do something
with the result.
So the traversing stays the same, however we always need to write it here and we could make more mistakes.
lso suppose we have way more constructs in our language, we would need to overrwrite each of them
Furthermore, in the case of counting we also still need to overwrite the Var case even though we do not do anyhting there
The Visitor Pattern lets us abstract away the visits and lets us focus on the specific thing we want to implement.
For tihs we develop and abstract visitor and then show how we can implement the above in this pattern.