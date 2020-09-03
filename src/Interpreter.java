import java.util.Iterator;

public class Interpreter {

    public static void main(String[] args) {
        FileParser parser = new FileParser();
        try {
            parser.ParseFile("/Users/mihailgudkov/IdeaProjects/DLanguageInterpreter/test_cases/2.d");
            System.out.println(parser.tokenList.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
