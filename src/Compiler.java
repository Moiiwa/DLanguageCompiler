
import lexer.Lexer;

public class Compiler {

    public static void main(String[] args) {
        Lexer lexer = new Lexer();
        try {
            lexer.ParseFile("/Users/mihailgudkov/IdeaProjects/DLanguageCompiler/test_cases/3.d");
            System.out.println(lexer.tokenList.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
