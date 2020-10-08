package bison.wrappers;

public class Primary extends Node{

    public Literal literal = null;
    public Token token = null;
    public Function function = null;
    public Expression expression = null;

    public Primary(Literal literal){
        this.literal = literal;
    }

    public Primary(Token token){
        this.token = token;
    }

    public Primary(Function function){
        this.function = function;
    }

    public Primary(Expression expression){
        this.expression = expression;
    }
}
