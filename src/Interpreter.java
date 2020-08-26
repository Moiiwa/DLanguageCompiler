import java.util.Iterator;

public class Interpreter {

    public static void main(String[] args) {
        FileParser parser = new FileParser();
        try {
            parser.ParseFile("test1.d");
            parser.scan("if ye=ars:= < 18 a =nd y:=\"e = a;rs:= > 3\" :=then\n");
            System.out.println(parser.tokenList.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
