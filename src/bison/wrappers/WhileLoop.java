package bison.wrappers;

public class WhileLoop extends Node implements Loop{
    Expression expression;
    Body body;
    public WhileLoop(Expression expression, Body body){
        this.expression = expression;
        this.body = body;
    }
}
