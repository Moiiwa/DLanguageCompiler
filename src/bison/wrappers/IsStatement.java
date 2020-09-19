package bison.wrappers;

public class IsStatement {
    Reference reference;
    lexer.Token token;
    public IsStatement(Reference reference, lexer.Token token){
        this.reference = reference;
        this.token = token;
    }
}
