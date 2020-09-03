package lexer;

/**
 * Class representing identifiers (my_var, i, my_arr ...);
 */
public class IdentifierToken extends Token {
    public final String lexeme;

    public IdentifierToken(String lexeme) {
        super(Tag.IDENTIFIER);
        this.lexeme = lexeme;
    }

    @Override
    public String toString() {
        return "IdentifierToken(" + lexeme + ")";
    }
}
