package CodeGenerator;

import bison.wrappers.*;
import lexer.IdentifierToken;
import lexer.IntToken;
import lexer.StrToken;

import javax.swing.plaf.nimbus.State;
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
    HashMap<String,Character> identifiersToTypes = new HashMap<>();
    Integer varsNum = 0;
    String currentIdentifier = "";
    Integer loopNum = 0;

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
        writer.write("\t.limit locals 1000\n");
        writer.write("\tgetstatic java/lang/System/out Ljava/io/PrintStream;\n");
        writer.write("\tastore 999\n");
        goThroughStatements(programTree.list);
        writer.write("    return\n" +"    True:\n" +
                "        ldc 1\n" +
                "        return\n" +
                "    False:\n" +
                "        ldc 0\n" +
                "        return\n" +
                ".end method\n");

        writer.close();
    }

    public void goThroughStatements(List<Statement> list) throws Exception {
        for (Statement statement: list){
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
                currentIdentifier = identifier.lexeme;
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
                IdentifierToken identifierToken = (IdentifierToken) variableDefinition.identifier;
                int localnum = identifiersToNumbers.get(identifierToken.lexeme);
                currentIdentifier = identifierToken.lexeme;
                identifiersToTypes.put(currentIdentifier,'i');
                int localVarNum = estimateExpression(variableDefinition.expression);
                if (identifiersToTypes.get(identifierToken.lexeme)=='i') {
                    writer.write("\tiload " + localVarNum + "\n");
                    writer.write("\tistore " + localnum + "\n");
                }
                if (identifiersToTypes.get(identifierToken.lexeme)=='s') {
                    writer.write("\taload " + localVarNum + "\n");
                    writer.write("\tastore " + localnum + "\n");
                }
            }
        }
    }

    public void generateAssignment(Statement statement) throws IOException {
        Assignment assignment = statement.assignment;
        String lexeme = ((IdentifierToken)assignment.reference.token).lexeme;
        Integer numOfVar = identifiersToNumbers.get(lexeme);
        currentIdentifier = lexeme;
        int expIdent = estimateExpression(assignment.expression);
        if (identifiersToTypes.get(lexeme)=='i') {
            writer.write("\tiload " + expIdent + "\n");
            writer.write("\tistore " + numOfVar + "\n");
        }
        if (identifiersToTypes.get(lexeme)=='s') {
            writer.write("\taload " + expIdent + "\n");
            writer.write("\tastore " + numOfVar + "\n");
        }

    }

    public void generateIf(Statement statement){

    }

    public void generateLoop(Statement statement) throws Exception {
        Loop loop = statement.loop;
        if (loop instanceof WhileLoop){

        }
        if (loop instanceof ForLoop){
            int expr1 = estimateExpression(((ForLoop) loop).range.expression1);
            int expr2 = estimateExpression(((ForLoop) loop).range.expression2);
            writer.write("\tiload "+expr1+'\n');
            writer.write("\tldc 1\n");
            writer.write("\tisub\n");
            writer.write("\tistore "+ varsNum+"\n");
            writer.write("\tiload "+expr2+"\n");
            writer.write("\tldc 1\n");
            writer.write("\tisub\n");
            writer.write("\tistore "+expr2+"\n");
            int iterator = varsNum;
            identifiersToNumbers.put(((IdentifierToken)((ForLoop) loop).identifier).lexeme,iterator);
            identifiersToTypes.put(((IdentifierToken)((ForLoop) loop).identifier).lexeme,'i');
            int currentLoop = loopNum;
            writer.write("   L"+currentLoop+":\n");
            loopNum+=1;
            varsNum+=2;
            writer.write("\tiload "+iterator+"\n");
            writer.write("ldc 1\n" +
                    "\tiadd\n" +
                    "\tistore "+iterator+"\n");
            Body body = ((ForLoop) loop).body;
            goThroughStatements(body.statements);
            writer.write("\tiload "+expr2+"\n");
            writer.write("\tiload "+iterator+"\n");
            writer.write("\tisub\n");
            writer.write("\tifge L"+currentLoop+'\n');
        }
    }

    public void generatePrint(Statement statement) throws IOException {
        PrintStatements statements = (PrintStatements)statement.print;
        if (statements.expressions.size()==1){
            Term term = (Term)((Factor)((Relation)statements.expressions.get(0).relations.get(0)).list.get(0)).terms.get(0);
            Primary primary = ((Unary)term.list.get(0)).primary;
            Reference reference = ((Unary)term.list.get(0)).reference;
            if (reference!=null)
                currentIdentifier = ((IdentifierToken)reference.token).lexeme;
            int val = estimateExpression(statements.expressions.get(0));
            writer.write("\taload 999\n");
            if ( primary != null ) {
                if (primary.literal.token instanceof IntToken) {
                    writer.write("\tiload " + val + "\n");
                    writer.write("\tinvokevirtual java/io/PrintStream/println(I)V\n");
                }
                if (primary.literal.token instanceof StrToken) {
                    writer.write("\tldc " + ((StrToken) primary.literal.token).str + "\n");
                    writer.write("\tinvokevirtual java/io/PrintStream/println(Ljava/lang/String;)V\n");
                }
            }
            if ( reference != null) {
                if (identifiersToTypes.get(((IdentifierToken)reference.token).lexeme)=='i') {
                    writer.write("\tiload " + val + "\n");
                    writer.write("\tinvokevirtual java/io/PrintStream/println(I)V\n");
                }
                if (identifiersToTypes.get(((IdentifierToken)reference.token).lexeme)=='s') {
                    writer.write("\taload " + val + "\n");
                    writer.write("\tinvokevirtual java/io/PrintStream/println(Ljava/lang/String;)V\n");
                }
            }
        }
        else{
            for (int i=0;i<statements.expressions.size();i++){
                Term term = (Term)((Factor)((Relation)statements.expressions.get(i).relations.get(0)).list.get(0)).terms.get(0);
                Primary primary = ((Unary)term.list.get(0)).primary;
                Reference reference = ((Unary)term.list.get(0)).reference;
                if (reference!=null)
                    currentIdentifier = ((IdentifierToken)reference.token).lexeme;
                int val = estimateExpression(statements.expressions.get(i));
                writer.write("\taload 999\n");
                if ( primary != null ) {
                    if (primary.literal.token instanceof IntToken) {
                        writer.write("\tiload " + val + "\n");
                        writer.write("\tinvokevirtual java/io/PrintStream/println(I)V\n");
                    }
                    if (primary.literal.token instanceof StrToken) {
                        writer.write("\tldc " + ((StrToken) primary.literal.token).str + "\n");
                        writer.write("\tinvokevirtual java/io/PrintStream/println(Ljava/lang/String;)V\n");
                    }
                }
                if ( reference != null) {
                    if (identifiersToTypes.get(((IdentifierToken)reference.token).lexeme)=='i') {
                        writer.write("\tiload " + val + "\n");
                        writer.write("\tinvokevirtual java/io/PrintStream/println(I)V\n");
                    }
                    if (identifiersToTypes.get(((IdentifierToken)reference.token).lexeme)=='s') {
                        writer.write("\taload " + val + "\n");
                        writer.write("\tinvokevirtual java/io/PrintStream/println(Ljava/lang/String;)V\n");
                    }
                }
            }
        }
    }

    public void generateReturn(Statement statement){

    }

    private Integer estimateExpression(Expression expression) throws IOException {
        ArrayList relations = expression.relations;
        int value = estimateFactor((Factor) ((Relation)relations.get(0)).list.get(0));
        if (((Relation)relations.get(0)).list.size()==1){
            if (identifiersToTypes.get(currentIdentifier)=='i') {
                writer.write("\tiload " + value + "\n");          //change to iload
                writer.write("\tistore " + varsNum + "\n");
                writer.write("\tldc 0\n");
            }
            if (identifiersToTypes.get(currentIdentifier)=='s') {
                writer.write("\taload " + value + "\n");          //change to iload
                writer.write("\tastore " + varsNum + "\n");
                writer.write("\tldc 0\n");
            }
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
            varsNum+=2;
        }else{
            int prevVal = varsNum;
            varsNum+=2;
            for (int i = 2; i < factor.terms.size();i++){
                if(i==2) {
                    numOfVar = estimateTerm((Term) factor.terms.get(i - 2));
                }else {
                    numOfVar = prevVal;
                }
                writer.write("\tiload "+numOfVar+"\n");
                numOfVar = estimateTerm((Term)factor.terms.get(i));
                writer.write("\tiload "+numOfVar+"\n");
                switch (((lexer.Token)factor.terms.get(i-1)).getTag()){
                    case PLUS: {
                        writer.write("\tiadd\n");
                        break;
                    }
                    case MINUS: {
                        writer.write("\tisub\n");
                        break;
                    }
                    case MULT: {
                        writer.write("\timul\n");
                        break;
                    }
                    default: {
                        writer.write("\tidiv\n");
                    }
                }
                writer.write("\tistore "+prevVal+"\n");
            }
            return prevVal;
        }

        return numOfVar;
    }

    private Integer estimateTerm(Term term) throws IOException {
        int numOfVar = 0;
        if (term.list.size()==1){
            numOfVar = estimateUnary((Unary)term.list.get(0));
            varsNum+=2;
        }else {
            for (int i = 2; i < term.list.size(); i++) {
                if (i == 2) {
                    numOfVar = estimateUnary((Unary)term.list.get(i - 2 ));
                }
                writer.write("\tiload " + numOfVar + "\n");
                numOfVar = estimateUnary((Unary)term.list.get(i));
                writer.write("\tiload " + numOfVar + "\n");
                switch (((lexer.Token) term.list.get(i-1)).getTag()) {
                    case PLUS: {
                        writer.write("\tiadd\n");
                        break;
                    }
                    case MINUS: {
                        writer.write("\tisub\n");
                        break;
                    }
                    case MULT: {
                        writer.write("\timul\n");
                        break;
                    }
                    default: {
                        writer.write("\tidiv\n");
                    }
                }
                writer.write("\tistore " + numOfVar + "\n");
            }
        varsNum+=2;

        }

        return numOfVar;
    }

    private Integer estimateUnary(Unary unary) throws IOException {
        int numOfVar = 0;
        if(unary.primary!=null){
            numOfVar = estimatePrimary(unary.primary);
            varsNum+=2;
        }
        if(unary.reference!=null){
            numOfVar = identifiersToNumbers.get(((IdentifierToken)unary.reference.token).lexeme);
            varsNum+=2;
        }
        if(unary.isStatement!=null){

        }

        return numOfVar;
    }

    private Integer estimatePrimary(Primary primary) throws IOException {
        int numOfVar = 0;
        if (primary.literal != null){
            Literal literal = primary.literal;
            Token token = literal.token;
            if (token instanceof IntToken){
                identifiersToTypes.put(currentIdentifier,'i');
                writer.write("\t ldc "+ ((IntToken)token).value+'\n');
                writer.write("\t istore "+ varsNum+ "\n");
                numOfVar = varsNum;
                varsNum+=2;
            }

            if (token instanceof StrToken){
                identifiersToTypes.put(currentIdentifier,'s');
                writer.write("\t ldc "+ ((StrToken)token).str+'\n');
                writer.write("\t astore "+ varsNum+ "\n");
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