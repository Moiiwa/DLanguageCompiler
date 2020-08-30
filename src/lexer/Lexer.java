package lexer;

import java.util.Set;

public class Lexer {
    // blank characters ignored by scanner
    public final static Set<Character> blankCharacters = Set.of(' ', '\t');
    // characters that separate statements
    public final static Set<Character> separatorCharacters = Set.of('\n', ';');

}
