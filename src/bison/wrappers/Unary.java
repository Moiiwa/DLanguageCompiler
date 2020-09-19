package bison.wrappers;

import java.util.function.UnaryOperator;

public class Unary {
    Reference reference;
    Primary primary;
    lexer.Token unaryOperator;
    IsStatement isStatement;
    public Unary(Reference reference){
        this.reference = reference;
    }
    public Unary(IsStatement isStatement){
        this.isStatement = isStatement;
    }
    public Unary(Primary primary){
        this.primary = primary;
    }

    public Unary(Primary primary, lexer.Token unaryOperator){
        this.primary = primary;
        this.unaryOperator = unaryOperator;
    }
}
