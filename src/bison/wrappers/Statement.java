package bison.wrappers;

public class Statement {

    Declaration declaration;
    IfStatement ifStatement;
    Loop loop;
    ReturnStatement returnStatement;
    Print print;
    Assignment assignment;
    public Statement(Declaration declaration){
        this.declaration = declaration;
    }
    public Statement(IfStatement ifStatement){
        this.ifStatement = ifStatement;
    }

    public Statement(Loop loop){
        this.loop = loop;
    }

    public Statement(ReturnStatement returnStatement){
        this.returnStatement = returnStatement;
    }

    public Statement(Print print){
        this.print = print;
    }

    public Statement(Assignment assignment){
        this.assignment = assignment;
    }

    public Statement(PrintStatements statements){

    }

}
