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
        switch (str.toLowerCase()){
            case "true": {tag =Tag.TRUE; break;}
            case "false": {tag = Tag.FALSE; break;}
            case "int": {tag = Tag.INT; break;}
            case "real": {tag = Tag.REAL; break;}
            case "bool": {tag =Tag.BOOL; break;}
            case "string": {tag = Tag.STRING; break;}
            case "empty": {tag = Tag.EMPTY; break;}
            case "func": {tag = Tag.FUNC; break;}
            case "and": {tag = Tag.AND; break;}
            case "or": {tag = Tag.OR; break;}
            case "xor": {tag = Tag.XOR; break;}
            case "not": {tag = Tag.NOT; break;}
            case "is": {tag = Tag.IS; break;}
            case "in": {tag = Tag.IN; break;}
            case "return": {tag = Tag.RETURN; break;}
            case "print": {tag = Tag.PRINT; break;}
            case "if": {tag = Tag.IF; break;}
            case "then": {tag = Tag.THEN; break;}
            case "else": {tag =Tag.ELSE; break;}
            case "end": {tag =Tag.END; break;}
            case "while": {tag = Tag.WHILE; break;}
            case "for": {tag = Tag.FOR; break;}
            case "loop": {tag = Tag.LOOP; break;}
            case "lambda": {tag = Tag.LAMBDA; break;}
            case "var": {tag = Tag.VAR; break;}
            case "begin": {tag = Tag.BEGIN; break;}
            case "assign": {tag = Tag.ASSIGN; break;}
            case "read_int": {tag = Tag.READ_INT; break;}
            case "read_real": {tag = Tag.READ_REAL; break;}
            case "read_string": {tag = Tag.READ_STRING; break;}
            default: {tag = Tag.ID; break;}
        }
        super.setTag(tag);
    }

    @Override
    public String toString() {
        return "" + str;
    }
}
