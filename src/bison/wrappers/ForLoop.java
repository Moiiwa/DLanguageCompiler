package bison.wrappers;

public class ForLoop extends Node implements Loop{

    public Identifier identifier;
    public Range range;
    public Body body;

    public ForLoop(Identifier identifier, Range range, Body body){
        this.identifier = identifier;
        this.range = range;
        this.body = body;
    }
}
