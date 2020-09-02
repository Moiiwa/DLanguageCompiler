package lexer;

/**
 * Class representing real numbers as tokens.
 */
public class RealToken extends Token {
    public final double value;

    public RealToken(double value) {
        super(Tag.REAL_TOKEN);
        this.value = value;
    }

    @Override
    public String toString() {
        return "RealToken(" + value + ")";
    }
}
