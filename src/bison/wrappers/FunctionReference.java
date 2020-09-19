package bison.wrappers;

public class FunctionReference {

    Reference reference;
    Expression expression;

    public FunctionReference(Reference reference, Expression expression){
        this.reference = reference;
        this.expression = expression;
    }
}
