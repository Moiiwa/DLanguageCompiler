
import lexer.Lexer;

public class Interpreter {

    public static void main(String[] args) {
        Lexer lexer = new Lexer();
        try {
            lexer.ParseFile("/Users/mihailgudkov/IdeaProjects/DLanguageInterpreter/test_cases/1.d");
            System.out.println(lexer.tokenList.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
