package bison.wrappers;

public class Range extends Node{

    public Expression expression1;
    public Expression expression2;

    public Range(Expression expression1, Expression expression2){
        this.expression1 = expression1;
        this.expression2 = expression2;
    }
}
