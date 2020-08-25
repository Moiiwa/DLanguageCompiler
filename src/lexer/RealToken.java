package lexer;

/**
 * Class representing real numbers as tokens.
 */
public class RealToken extends Token {
    public final float value;

    public RealToken(float value) {
        super(Tag.REAL_TOKEN);
        this.value = value;
    }

    @Override
    public String toString() {
        return "" + value;
    }
}
