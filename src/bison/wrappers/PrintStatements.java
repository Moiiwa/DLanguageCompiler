package bison.wrappers;

import java.util.ArrayList;

public class PrintStatements extends Node implements Print{

    ArrayList<Expression> expressions;

    public PrintStatements(ArrayList<Expression> expressions){
        this.expressions = expressions;
    }
}
