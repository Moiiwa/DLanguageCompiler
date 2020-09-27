package bison.wrappers;

import java.util.List;

public class Tuple extends Node{
    List list;

    public Tuple(List<TupleElement> list){
        this.list = list;
    }
}
