package bison.wrappers;

public class Assignment extends Node{
    Reference reference;
    Expression expression;
    public Assignment(Reference reference, Expression expression){
        this.reference = reference;
        leftChild = reference;
        this.expression = expression;
        rightChild = expression;
    }
}
