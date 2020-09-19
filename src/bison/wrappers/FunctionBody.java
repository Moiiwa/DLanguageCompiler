package bison.wrappers;

public class FunctionBody {

    Body body;
    Expression expression;
    public FunctionBody(Body body){
        this.body = body;
    }

    public FunctionBody(Expression expression){
        this.expression = expression;
    }
}
