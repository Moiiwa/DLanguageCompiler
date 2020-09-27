package bison.wrappers;

public class FunctionReference extends Node{

    Reference reference;
    Expression expression;

    public FunctionReference(Reference reference, Expression expression){
        this.reference = reference;
        this.expression = expression;
    }
}
