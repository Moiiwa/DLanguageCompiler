package bison.wrappers;

import java.util.ArrayList;

public class Function extends Node{

    ArrayList<Identifier> identifiers;
    FunctionBody functionBody;

    public Function(ArrayList<Identifier> identifiers, FunctionBody functionBody){
        this.identifiers = identifiers;
        this.functionBody = functionBody;
    }
}
