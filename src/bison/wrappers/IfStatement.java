package bison.wrappers;

public class IfStatement extends Node{
    Expression expression;
    Body thenBody;
    Body elseBody;
    public IfStatement(Expression expression, Body ifBody, Body elseBody){
        this.expression = expression;
        this.thenBody = ifBody;
        this.elseBody = elseBody;
    }

    public IfStatement(Expression expression, Body body){
        this.expression = expression;
        this.thenBody = body;
    }
}
