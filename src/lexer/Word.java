package lexer;

/**
 * Class representing the following types of tokens:
 * - reserved words (return, if, else, while ...);
 * - identifiers (my_var, i, my_arr ...);
 * - other tokens which don't fit in one character ( <= => true false ...)
 */
public class Word extends Token {
    public final String lexeme;

    public Word( String lexeme) {
        super(0);
        int tag;
        this.lexeme = lexeme;
        switch (lexeme.toLowerCase()){
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
            case "readint": {tag = Tag.READ_INT; break;}
            case "readreal": {tag = Tag.READ_REAL; break;}
            case "readstring": {tag = Tag.READ_STRING; break;}
            case ",": {tag = Tag.COMMA; break;}
            case ";": {tag = Tag.SMCLN; break;}
            case ":":  {tag = Tag.CLN; break;}
            case "=": {tag = Tag.EQ; break;}
            case ":=": {tag = Tag.ASSIGN; break;}
            case "<=": {tag = Tag.LE; break;}
            case ">=": {tag = Tag.GE; break;}
            case "/=": {tag = Tag.NE; break;}
            case "/": {tag = Tag.DIV; break;}
            case "+": {tag = Tag.PLUS; break;}
            case "-": {tag = Tag.MINUS; break;}
            case "*": {tag = Tag.MULT; break;}
            case "(": {tag = Tag.OPBR; break;}
            case ")": {tag = Tag.CLBR; break;}
            case "[": {tag = Tag.OPSQBR; break;}
            case "]": {tag = Tag.CLSQBR; break;}
            case "{": {tag = Tag.OPFIGBR; break;}
            case "}": {tag = Tag.CLFIGBR; break;}
            default: {tag = Tag.ID; break;}
        }
        super.setTag(tag);
    }

    @Override
    public String toString() {
        return "" + lexeme;
    }
}
