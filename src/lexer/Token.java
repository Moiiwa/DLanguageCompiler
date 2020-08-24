package lexer;

/**
 * Class representing terminal (token).
 * This base class is used for one-character tokens (i.e. ; = < >).
 */
public class Token {
    public final int tag;

    public Token(int tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "" + (char) tag;
    }


}
