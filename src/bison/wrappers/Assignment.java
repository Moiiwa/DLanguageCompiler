package bison.wrappers;

public class Assignment extends Node{
    public Reference reference;
    public Expression expression;
    public Assignment(Reference reference, Expression expression){
        this.reference = reference;
        leftChild = reference;
        this.expression = expression;
        rightChild = expression;
    }
}
