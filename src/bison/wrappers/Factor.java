package bison.wrappers;

import java.util.ArrayList;

public class Factor extends Node{
    public ArrayList<Object> terms = new ArrayList<>();
    public Factor(Term term){
        terms.add(term);
    }

    public void add(Term term, FactorOperator operator){
        terms.add(operator);
        terms.add(term);
    }


}
