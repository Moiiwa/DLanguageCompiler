package CodeGenerator;

import bison.wrappers.*;
import lexer.IdentifierToken;
import lexer.IntToken;

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
        writer.write("\t.limit locals 200\n");
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
        writer.write("    return\n" +"    True:\n" +
                        "        ldc 1\n" +
                        "        return\n" +
                        "    False:\n" +
                        "        ldc 0\n" +
                        "        return\n" +
                ".end method\n");

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
                varsNum+=2;
            }else throw new Exception("A variable with such name is already declared");
        }
    }

    public void assignVariables(List<VariableDefinition> variableDefinitions) throws Exception {
        for (VariableDefinition variableDefinition: variableDefinitions){
            if (variableDefinition.expression != null) {
                int localVarNum = estimateExpression(variableDefinition.expression);
                IdentifierToken identifierToken = (IdentifierToken) variableDefinition.identifier;
                int localnum = identifiersToNumbers.get(identifierToken.lexeme);
                writer.write("\tiload " + localVarNum + "\n");
                writer.write("\tistore " + localnum + "\n");
            }
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

    private Integer estimateExpression(Expression expression) throws IOException {
        ArrayList relations = expression.relations;
        int value = estimateFactor((Factor) ((Relation)relations.get(0)).list.get(0));
        if (((Relation)relations.get(0)).list.size()==1){
            writer.write("\tiload "+value+"\n");          //change to iload
            writer.write("\tistore "+varsNum+"\n");
            writer.write("\tldc 0\n");
        }else {
            writer.write("\tldc 1\n");
            writer.write("\tistore "+varsNum+"\n");
            for (int i=1; i<((Relation)relations.get(0)).list.size();i++){
                if (i % 2 == 0){
                    Token token = (Token) ((Relation)relations.get(0)).list.get(i-1);
                    int val1 = estimateFactor((Factor) ((Relation)relations.get(0)).list.get(i-2));
                    int val2 = estimateFactor((Factor) ((Relation)relations.get(0)).list.get(i));
                    identifyRelation(val1, val2, token);
                }
            }
            writer.write("\tldc 1\n");
        }
        writer.write("\tistore "+(varsNum+1)+"\n");
        int numOfVar = varsNum;
        varsNum+=2;
        return numOfVar;
    }

    private Integer estimateFactor(Factor factor) throws IOException {
        int numOfVar = 0;
        if (factor.terms.size()==1){
            numOfVar = estimateTerm((Term)factor.terms.get(0));
        }else{

        }
        varsNum+=2;
        return numOfVar;
    }

    private Integer estimateTerm(Term term) throws IOException {
        int numOfVar = 0;
        if (term.list.size()==1){
            numOfVar = estimateUnary((Unary)term.list.get(0));
        }else{

        }
        varsNum+=2;
        return 0;
    }

    private Integer estimateUnary(Unary unary) throws IOException {
        int numOfVar = 0;
        if(unary.primary!=null){
            numOfVar = estimatePrimary(unary.primary);
        }
        if(unary.reference!=null){
            numOfVar = identifiersToNumbers.get(((IdentifierToken)unary.reference.token).lexeme);
        }
        if(unary.isStatement!=null){

        }
        varsNum+=2;
        return numOfVar;
    }

    private Integer estimatePrimary(Primary primary) throws IOException {
        int numOfVar = 0;
        if (primary.literal != null){
            Literal literal = primary.literal;
            Token token = literal.token;
            if (token instanceof IntToken){
                writer.write("\t ldc "+ ((IntToken)token).value+'\n');
                writer.write("\t istore "+ varsNum+ "\n");
                numOfVar = varsNum;
                varsNum+=2;
            }
        }
        if (primary.token != null){

        }
        if (primary.function != null){

        }
        return numOfVar;
    }

    private void identifyRelation(int val1, int val2, Token token) throws IOException {
        writer.write("\tldc "+val1+"\n");
        writer.write("\tldc "+val2+"\n");
        writer.write("\tisub\n");
        switch (((lexer.Token)token).getTag()){
            case LT:{
                writer.write("\tiflt True\n");
                writer.write("\tldc "+val1+"\n");
                writer.write("\tldc "+val2+"\n");
                writer.write("\tisub\n");
                writer.write("\tifge False\n");
                break;
            }
            case LE:{
                writer.write("\tifle True\n");
                writer.write("\tldc "+val1+"\n");
                writer.write("\tldc "+val2+"\n");
                writer.write("\tisub\n");
                writer.write("\tifgt False\n");
                break;
            }
            case GT:{
                writer.write("\tifgt True\n");
                writer.write("\tldc "+val1+"\n");
                writer.write("\tldc "+val2+"\n");
                writer.write("\tisub\n");
                writer.write("\tifle False\n");
                break;
            }
            case GE:{
                writer.write("\tifge True\n");
                writer.write("\tldc "+val1+"\n");
                writer.write("\tldc "+val2+"\n");
                writer.write("\tisub\n");
                writer.write("\tiflt False\n");
                break;
            }
            case EQ:{
                writer.write("\tifeq True\n");
                writer.write("\tldc "+val1+"\n");
                writer.write("\tldc "+val2+"\n");
                writer.write("\tisub\n");
                writer.write("\tifne False\n");
                break;
            }
            default:{
                writer.write("\tifne True\n");
                writer.write("\tldc "+val1+"\n");
                writer.write("\tldc "+val2+"\n");
                writer.write("\tisub\n");
                writer.write("\tifeq False\n");
            }
        }
        writer.write("\tiload "+varsNum+"\n");
        writer.write("\timul\n");
        writer.write("\tistore "+varsNum+"\n");
    }
}