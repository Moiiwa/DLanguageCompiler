package bison.wrappers;

import java.util.ArrayList;

public class Expression extends Node{
    public ArrayList<Object> relations = new ArrayList<>();
    public Expression(Relation relation){
        relations.add(relation);
    }

    public void add(Relation relation, ExpressionOperator expressionOperator){
        relations.add(relation);
        relations.add(expressionOperator);
    }
}
