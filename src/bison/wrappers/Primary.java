package bison.wrappers;

public class Primary {

    Literal literal = null;
    lexer.Token token = null;
    Function function = null;
    Expression expression = null;
    public Primary(Literal literal){
        this.literal = literal;
    }

    public Primary(lexer.Token token){
        this.token = token;
    }

    public Primary(Function function){
        this.function = function;
    }

    public Primary(Expression expression){
        this.expression = expression;
    }
}
