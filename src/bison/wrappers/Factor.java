package bison.wrappers;

import java.util.ArrayList;

public class Factor extends Node{
    ArrayList<Object> terms = new ArrayList<>();
    public Factor(Term term){
        terms.add(term);
    }

    public void add(Term term, FactorOperator operator){
        terms.add(term);
        terms.add(operator);
    }


}
