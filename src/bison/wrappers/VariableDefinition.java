package bison.wrappers;

public class VariableDefinition extends Node{

    Identifier identifier;
    Expression expression;
    public VariableDefinition(Identifier identifier){
        this.identifier = identifier;
    }

    public VariableDefinition(Identifier identifier, Expression expression){
        this.identifier = identifier;
        this.expression = expression;
    }
}
