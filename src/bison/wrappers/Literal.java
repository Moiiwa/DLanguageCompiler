package bison.wrappers;

public class Literal {

    lexer.Token token;
    Tuple tuple;
    Array array;
    public Literal(lexer.Token token){
        this.token = token;
    }

    public Literal(Tuple tuple){
        this.tuple = tuple;
    }

    public Literal(Array array){
        this.array = array;
    }
}
