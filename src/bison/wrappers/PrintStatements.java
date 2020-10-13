package bison.wrappers;

import java.util.ArrayList;

public class PrintStatements extends Node implements Print{

    public ArrayList<Expression> expressions;

    public PrintStatements(ArrayList<Expression> expressions){
        this.expressions = expressions;
    }
}
