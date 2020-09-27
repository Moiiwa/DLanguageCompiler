package bison.wrappers;

public class ReturnStatement extends Node{

    Expression expression = null;
    public ReturnStatement(Expression expression){
        this.expression = expression;
    }

    public ReturnStatement(){

    }
}
