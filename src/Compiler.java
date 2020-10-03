
import bison.YYParser;
import lexer.*;

public class Compiler {

    public static void main(String[] args) {
        Lexer lexer = new Lexer();
        try {
            lexer.ParseFile("/Users/mihailgudkov/IdeaProjects/DLanguageCompiler/test_cases/test08.d");
            System.out.println(lexer.tokenList.size());
            YYParser parser = new YYParser(lexer);
            lexer.setIterator(lexer.tokenList.iterator());
            System.out.println(parser.parse());
            System.out.println(2);

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
