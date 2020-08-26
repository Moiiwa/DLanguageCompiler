import java.util.Iterator;

public class Interpreter {

    public static void main(String[] args) {
        FileParser parser = new FileParser();
        try {
            parser.scan("1234.5 befo13_R2e 123 355.3 asd var read_Int");
            System.out.println(parser.tokenList.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
