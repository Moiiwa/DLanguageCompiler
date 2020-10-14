
import CodeGenerator.CodeGenerator;
import bison.YYParser;
import lexer.*;
import java.io.PrintStream;

public class Compiler {

    public static void main(String[] args) {
        Lexer lexer = new Lexer();
        try {
            //"/Users/mihailgudkov/IdeaProjects/DLanguageCompiler/test_cases/t1.d"
            lexer.ParseFile(args [0]);
            YYParser parser = new YYParser(lexer);
            lexer.setIterator(lexer.tokenList.iterator());
            parser.parse();
            CodeGenerator codeGenerator = new CodeGenerator(parser.programTree);

        } catch (Exception e) {
            e.printStackTrace();
        }
//        System.out.println("" + new IntToken(123));
//        System.out.println("" + new RealToken(1.23));
//        System.out.println("" + new StrToken("hello"));
//        System.out.println("" + new Token(Tag.ASSIGN));
//        System.out.println("" + new IdentifierToken("my_array"));
    }
}
