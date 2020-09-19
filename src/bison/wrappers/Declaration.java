package bison.wrappers;

import java.util.List;

public class Declaration {
    Object value;
    List<VariableDefinition> variableDefinitions;
    public Declaration(Token token, List<VariableDefinition> variableDefinitions){
        value = token;
        this.variableDefinitions = variableDefinitions;
    }
}
