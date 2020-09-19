package bison.wrappers;

public class WhileLoop {
    Expression expression;
    Body body;
    public WhileLoop(Expression expression, Body body){
        this.expression = expression;
        this.body = body;
    }
}
