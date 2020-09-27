package bison.wrappers;

import java.util.List;

public class Array extends Node{

    List list;
    public Array(List<Expression> list){
        this.list = list;
    }
}
