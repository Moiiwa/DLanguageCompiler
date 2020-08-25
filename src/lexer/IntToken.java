package lexer;

/**
 * Class representing integer numbers as tokens.
 */
public class IntToken extends Token {
    public final int value;

    public IntToken(int value) {
        super(Tag.INT_TOKEN);
        this.value = value;
    }

    @Override
    public String toString() {
        return "" + value;
    }
}
