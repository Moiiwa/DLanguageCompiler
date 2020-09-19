package bison.wrappers;

public class ArrayReference {

    Reference reference;
    Expression expression;

    public ArrayReference(Reference reference, Expression expression){
        this.reference = reference;
        this.expression = expression;
    }
}
