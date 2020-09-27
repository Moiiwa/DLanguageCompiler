package bison.wrappers;

public class ArrayReference extends Node{
    Reference reference;
    Expression expression;

    public ArrayReference(Reference reference, Expression expression){
        this.reference = reference;
        leftChild = reference;
        this.expression = expression;
        rightChild = expression;
    }
}
