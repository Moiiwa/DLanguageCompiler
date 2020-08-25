package com.company.lexer;

/**
 * Class representing the following types of tokens:
 * - reserved words (return, if, else, while ...);
 * - identifiers (my_var, i, my_arr ...);
 * - other tokens which don't fit in one character ( <= => true false ...)
 */
public class Word extends Token {
    public final String lexeme;

    public Word(int tag, String lexeme) {
        super(tag);
        this.lexeme = new String(lexeme);
    }

    @Override
    public String toString() {
        return "" + lexeme;
    }
}
