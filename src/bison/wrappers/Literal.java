package bison.wrappers;

public class Literal extends Node{

    Token token;
    Tuple tuple;
    Array array;
    public Literal(Token token){
        this.token = token;
    }

    public Literal(Tuple tuple){
        this.tuple = tuple;
    }

    public Literal(Array array){
        this.array = array;
    }
}
