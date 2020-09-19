package bison.wrappers;

public class TupleElement {

    lexer.Token token;
    Expression expression;
    public TupleElement(Expression expression){
        this.expression = expression;
    }

    public TupleElement(lexer.Token token, Expression expression){
        this.token = token;
    }
}
