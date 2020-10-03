package CodeGenerator;

import bison.wrappers.ProgramTree;
import bison.wrappers.Statement;

public class CodeGenerator {

    ProgramTree programTree;
    public CodeGenerator(ProgramTree programTree){
        this.programTree = programTree;
    }

    public void goThroughStatements(){
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
