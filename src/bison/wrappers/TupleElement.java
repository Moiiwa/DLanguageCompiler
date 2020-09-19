package bison.wrappers;

public class TupleElement {

    Token token;
    Expression expression;
    public TupleElement(Expression expression){
        this.expression = expression;
    }

    public TupleElement(Token token, Expression expression){
        this.token = token;
        this.expression = expression;
    }
}
