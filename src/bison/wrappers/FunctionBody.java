package bison.wrappers;

public class FunctionBody extends Node{

    Body body;
    Expression expression;
    public FunctionBody(Body body){
        this.body = body;
    }

    public FunctionBody(Expression expression){
        this.expression = expression;
    }
}
