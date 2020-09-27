package bison.wrappers;

import java.util.ArrayList;

public class Body extends Node{

    ArrayList<Statement> statements;

    public Body(ArrayList<Statement> statements){
        this.statements = statements;
    }
}
