package bison.wrappers;

public class IsStatement {
    Reference reference;
    Token token;
    public IsStatement(Reference reference, Token token){
        this.reference = reference;
        this.token = token;
    }
}
