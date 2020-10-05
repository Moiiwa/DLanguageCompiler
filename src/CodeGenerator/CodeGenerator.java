package CodeGenerator;

import bison.wrappers.ProgramTree;
import bison.wrappers.Statement;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CodeGenerator {

    FileWriter writer;
    ProgramTree programTree;

    public CodeGenerator(ProgramTree programTree) throws IOException {
        this.programTree = programTree;
        File file = new File("file.j");
        file.createNewFile();
        System.out.println("File is created");
        writer = new FileWriter("file.j");
        writer.write(".class public GeneratedProgram\n");
        writer.write(".super java/lang/Object\n");
        writer.write(".method public static main([Ljava/lang/String;)V\n");
        goThroughStatements();
    }

    public void goThroughStatements() throws IOException {
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

    public void generateDeclaration(Statement statement){

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
}
