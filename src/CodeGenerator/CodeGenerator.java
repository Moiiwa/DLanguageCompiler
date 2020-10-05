package CodeGenerator;

import bison.wrappers.*;
import lexer.IdentifierToken;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CodeGenerator {

    FileWriter writer;
    ProgramTree programTree;
    HashMap<String,Integer> identifiersToNumbers = new HashMap();
    Integer varsNum = 0;

    public CodeGenerator(ProgramTree programTree) throws Exception {
        this.programTree = programTree;
        File file = new File("file.j");
        file.createNewFile();
        System.out.println("File is created");
        writer = new FileWriter("file.j");
        writer.write(".class public GeneratedProgram\n");
        writer.write(".super java/lang/Object\n");
        writer.write(".method public static main([Ljava/lang/String;)V\n");
        writer.write("\t.limit stack 10\n");
        writer.write("\t.limit locals 100\n");
        goThroughStatements();
    }

    public void goThroughStatements() throws Exception {
        for (Statement statement: programTree.list){
            int type = identifyStatementType(statement);
            switch (type){
                case 0:{
                    generateDeclaration(statement);
                    break;
                }
                case 1:{
                    generateAssignment(statement);
                    break;
                }
                case 2:{
                    generateIf(statement);
                    break;
                }
                case 3:{
                    generateLoop(statement);
                    break;
                }
                case 4:{
                    generatePrint(statement);
                    break;
                }
                default:{
                    generateReturn(statement);
                }
            }
        }
        writer.write("    return\n" +
                ".end method");
        writer.close();
    }

    public int identifyStatementType(Statement statement){
        if (statement.declaration!=null)
            return 0;
        if (statement.assignment != null)
            return 1;
        if (statement.ifStatement != null)
            return 2;
        if (statement.loop != null)
            return 3;
        if (statement.print != null)
            return 4;
        return 5;
    }

    public void generateDeclaration(Statement statement) throws Exception {
        Declaration declaration = statement.declaration;
        List<VariableDefinition> variableDefinitions = declaration.variableDefinitions;
        declareVariables(variableDefinitions);
        assignVariables(variableDefinitions);
    }

    public void declareVariables(List<VariableDefinition> variableDefinitions) throws Exception {

        for (VariableDefinition variableDefinition: variableDefinitions){
            IdentifierToken identifier = (IdentifierToken)variableDefinition.identifier;
            if (!identifiersToNumbers.containsKey(identifier.lexeme)) {
                identifiersToNumbers.put(identifier.lexeme, varsNum);
                StringBuilder command = new StringBuilder();
                writer.write(command.toString());
                varsNum+=1;
            }else throw new Exception("A variable with such name is already declared");
        }
    }

    public void assignVariables(List<VariableDefinition> variableDefinitions) throws Exception {
        for (VariableDefinition variableDefinition: variableDefinitions){
            float value = estimateExpression(variableDefinition.expression);
            IdentifierToken identifierToken = (IdentifierToken)variableDefinition.identifier;
            int localnum = identifiersToNumbers.get(identifierToken.lexeme);
            writer.write("\t ldc "+value+"\n");
            writer.write("\t fstore "+localnum+"\n");
        }
    }

    public void generateAssignment(Statement statement){

    }

    public void generateIf(Statement statement){

    }

    public void generateLoop(Statement statement){

    }

    public void generatePrint(Statement statement){

    }

    public void generateReturn(Statement statement){

    }

    private Float estimateExpression(Expression expression){
        float value = 0;

        return value;
    }
}
