package bison.wrappers;

import java.util.function.UnaryOperator;

public class Unary extends Node{
    public Reference reference;
    public Primary primary;
    Token unaryOperator;
    public IsStatement isStatement;
    public Unary(Reference reference){
        this.reference = reference;
    }
    public Unary(IsStatement isStatement){
        this.isStatement = isStatement;
    }
    public Unary(Primary primary){
        this.primary = primary;
    }

    public Unary(Primary primary, Token unaryOperator){
        this.primary = primary;
        this.unaryOperator = unaryOperator;
    }
}
