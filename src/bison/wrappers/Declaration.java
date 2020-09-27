package bison.wrappers;

import java.util.List;

public class Declaration extends Node{
    Object value;
    List<VariableDefinition> variableDefinitions;
    public Declaration(Token token, List<VariableDefinition> variableDefinitions){
        value = token;
        leftChild = token;
        this.variableDefinitions = variableDefinitions;
        switch (variableDefinitions.size()){
            case 1: {
                rightChild = variableDefinitions.get(0);
                break;
            }
            case 2: {
                VariableDefinitions vd = new VariableDefinitions();
                rightChild = vd;
                List<VariableDefinition> newVd = variableDefinitions;
                vd.leftChild = newVd.get(1);
                vd.rightChild = variableDefinitions.get(0);
                break;
            }
            default: {
                VariableDefinitions vd = new VariableDefinitions();
                rightChild = vd;
                List<VariableDefinition> newVd = variableDefinitions;
                vd.leftChild = newVd.get(newVd.size()-1);
                newVd.remove(newVd.size()-1);
                vd.rightChild = new VariableDefinitions(newVd);
            }
        }
    }
}
