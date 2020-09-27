package bison.wrappers;

import java.util.ArrayList;

public class Relation extends Node{

    ArrayList list = new ArrayList();
    public Relation(Factor factor){
        list.add(factor);
    }

    public void add(Factor factor, RelationOperator relationOperator){
        list.add(factor);
        list.add(relationOperator);
    }
}
