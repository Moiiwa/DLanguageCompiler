package bison.wrappers;

import java.util.ArrayList;

public class ProgramTree {
    public ArrayList<Statement> list = new ArrayList();

    public ProgramTree(ArrayList<Statement> list){
        this.list = list;
    }
}
