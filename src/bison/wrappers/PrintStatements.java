package bison.wrappers;

import java.util.ArrayList;

public class PrintStatements implements Print{

    ArrayList<Expression> expressions;

    public PrintStatements(ArrayList<Expression> expressions){
        this.expressions = expressions;
    }
}