import java.io.*;
import java.util.LinkedList;
import java.util.List;

class FileParser {
    public List<String> parsed = new LinkedList<String>();
    private int line = 1;
    private String file_text = "";
    private static BufferedReader ReadFile(String path) throws FileNotFoundException {
        File file = new File(path);
            return new BufferedReader(new FileReader(file));
    }

    List<lexer.Token> ParseFile(String path) throws Exception {
        BufferedReader br = ReadFile(path);
        List<lexer.Token> words = new LinkedList<>();
        System.out.println(br.read());
        file_text = br.toString();
        int index = 0;
        while (index < file_text.length()) {
            words.add(scan(index));
        }
        return words;
    }

    private lexer.Token scan(Integer local_index) throws Exception{
        char peek = ' ';
        for ( ; ; peek = file_text.charAt(local_index)){
            local_index += 1;
            if (peek == '\n')
                line += 1;
            else if (peek == ' ' || peek == '\t')
                continue;
            else
                break;
        }
        if (Character.isDigit(peek)){
            int v = 0;
            do {
                if (peek != '.') v = 10*v + Character.digit(peek, 10);
                local_index += 1;
            } while (Character.isDigit(peek) || peek == '.'); //Questionable
            return new lexer.Token(lexer.Tag.NUM);
        }
        else if (Character.isLetter(peek)){
            StringBuilder sb = new StringBuilder();
            do {
                sb.append(peek);
                peek = file_text.charAt(local_index);
                local_index += 1;
            } while( Character.isLetterOrDigit(peek) || peek == '_');
            String s = sb.toString();
            parsed.add(sb.toString());
            if (Tokens.allTokens.contains(s))
                return new lexer.Token(AssignTag(s));
            else
                return new lexer.Token(lexer.Tag.ID);
        }
        else if (!Character.isLetterOrDigit(peek)){
            StringBuilder sb = new StringBuilder();
            do {
                sb.append(peek);
                peek = file_text.charAt(local_index);
                local_index += 1;
            } while (!Character.isLetterOrDigit(peek) && peek != ' ' && peek != '\t' && peek != '\n');
            String s = sb.toString();
            if (Tokens.allTokens.contains(s)){
                return new lexer.Token(AssignTag(s));
            }
            else throw new Exception("Incorrect Input");
        }
        else return new lexer.Token(lexer.Tag.EMPTY);
    }
     private int AssignTag(String s){
        s = s.toLowerCase();
        switch (s){
            case "true": return lexer.Tag.TRUE;
            case "false": return lexer.Tag.FALSE;
            case "int": return lexer.Tag.INT;
            case "real": return lexer.Tag.REAL;
            case "bool": return lexer.Tag.BOOL;
            case "string": return lexer.Tag.STRING;
            case "empty": return lexer.Tag.EMPTY;
            case "func": return lexer.Tag.FUNC;
            case "and": return lexer.Tag.AND;
            case "or": return lexer.Tag.OR;
            case "xor": return lexer.Tag.XOR;
            case "<": return lexer.Tag.LT;
            case "<=": return lexer.Tag.LE;
            case ">": return lexer.Tag.GT;
            case ">=": return lexer.Tag.GE;
            case "/=": return lexer.Tag.NE;
            case "not": return lexer.Tag.NOT;
            case "is": return lexer.Tag.IS;
            case "in": return lexer.Tag.IN;
            case "=": return lexer.Tag.EQ;
            case "return": return lexer.Tag.RETURN;
            case "print": return lexer.Tag.PRINT;
            case "if": return lexer.Tag.IF;
            case "then": return lexer.Tag.THEN;
            case "else": return lexer.Tag.ELSE;
            case "end": return lexer.Tag.END;
            case "while": return lexer.Tag.WHILE;
            case "for": return lexer.Tag.FOR;
            case "loop": return lexer.Tag.LOOP;
            case "lambda": return lexer.Tag.LAMBDA;
            case "var": return lexer.Tag.VAR;
            case ":=": return lexer.Tag.ASSIGN;
            case "begin": return lexer.Tag.BEGIN;
            case "{": return lexer.Tag.OPFIGBR;
            case "}": return lexer.Tag.CLFIGBR;
            case "(": return lexer.Tag.OPBR;
            case ")": return lexer.Tag.CLBR;
            case "[": return lexer.Tag.OPSQBR;
            case "]": return lexer.Tag.CLSQBR;
            case ",": return lexer.Tag.COMMA;
            case "+": return lexer.Tag.PLUS;
            case "-": return lexer.Tag.MINUS;
            case "*": return lexer.Tag.MULT;
            case "/": return lexer.Tag.DIV;
            default: return lexer.Tag.ID;


        }

     }
}
