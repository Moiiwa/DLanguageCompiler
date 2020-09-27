package bison.wrappers;

import java.util.List;

public class VariableDefinitions extends Node{

    public VariableDefinitions(List<VariableDefinition> variableDefinitions){
        if (variableDefinitions.size() == 2){
            leftChild = variableDefinitions.get(1);
            rightChild = variableDefinitions.get(0);
        }
        if (variableDefinitions.size() > 2){
            leftChild = variableDefinitions.get(variableDefinitions.size()-1);
            List<VariableDefinition> newVD = variableDefinitions;
            newVD.remove(variableDefinitions.size()-1);
            rightChild = new VariableDefinitions(newVD);
        }
    }

    public VariableDefinitions(){}
}
