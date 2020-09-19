package bison.wrappers;

public class Assignment {
    Reference reference;
    Expression expression;
    public Assignment(Reference reference, Expression expression){
        this.reference = reference;
        this.expression = expression;
    }
}
