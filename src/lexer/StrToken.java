package lexer;

/**
 * Class representing string literals as tokens.
 */
public class StrToken extends Token {
    public final String str;
    public int tag;
    public StrToken(String str) {
        super(Tag.STR_TOKEN);
        this.str = str;
    }

    @Override
    public String toString() {
        return "" + str;
    }
}
