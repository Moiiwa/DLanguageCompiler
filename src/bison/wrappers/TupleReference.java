package bison.wrappers;

public class TupleReference {

    Reference reference;
    lexer.Token token;

    public TupleReference(Reference reference, lexer.Token token){
        this.reference = reference;
        this.token = token;
    }
}
