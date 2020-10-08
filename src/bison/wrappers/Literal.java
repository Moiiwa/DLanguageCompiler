package bison.wrappers;

public class Literal extends Node{

    public Token token;
    public Tuple tuple;
    public Array array;
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
