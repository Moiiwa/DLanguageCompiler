import java.io.*;
import java.util.LinkedList;
import java.util.List;
import lexer.*;

class FileParser {
    public List<String> parsed = new LinkedList<String>();
    private int line = 1;
    private String file_text = "";
    private static BufferedReader ReadFile(String path) throws FileNotFoundException {
        File file = new File(path);
            return new BufferedReader(new FileReader(file));
    }

    List<Token> ParseFile(String path) throws Exception {
        BufferedReader br = ReadFile(path);
        List<Token> words = new LinkedList<>();
        System.out.println(br.read());
        file_text = br.toString();
        int index = 0;
        while (index < file_text.length()) {
            words.add(scan(index));
        }
        return words;
    }

    private Token scan(Integer local_index) throws Exception{
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
            return new Token(Tag.NUM);
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
                return new Token(AssignTag(s));
            else
                return new Token(Tag.ID);
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
                return new Token(AssignTag(s));
            }
            else throw new Exception("Incorrect Input");
        }
        else return new Token(Tag.EMPTY);
    }
     private int AssignTag(String s){
        s = s.toLowerCase();
        switch (s){
            case "true": return Tag.TRUE;
            case "false": return Tag.FALSE;
            case "int": return Tag.INT;
            case "real": return Tag.REAL;
            case "bool": return Tag.BOOL;
            case "string": return Tag.STRING;
            case "empty": return Tag.EMPTY;
            case "func": return Tag.FUNC;
            case "and": return Tag.AND;
            case "or": return Tag.OR;
            case "xor": return Tag.XOR;
            case "<": return Tag.LT;
            case "<=": return Tag.LE;
            case ">": return Tag.GT;
            case ">=": return Tag.GE;
            case "/=": return Tag.NE;
            case "not": return Tag.NOT;
            case "is": return Tag.IS;
            case "in": return Tag.IN;
            case "=": return Tag.EQ;
            case "return": return Tag.RETURN;
            case "print": return Tag.PRINT;
            case "if": return Tag.IF;
            case "then": return Tag.THEN;
            case "else": return Tag.ELSE;
            case "end": return Tag.END;
            case "while": return Tag.WHILE;
            case "for": return Tag.FOR;
            case "loop": return Tag.LOOP;
            case "lambda": return Tag.LAMBDA;
            case "var": return Tag.VAR;
            case ":=": return Tag.ASSIGN;
            case "begin": return Tag.BEGIN;
            case "{": return Tag.OPFIGBR;
            case "}": return Tag.CLFIGBR;
            case "(": return Tag.OPBR;
            case ")": return Tag.CLBR;
            case "[": return Tag.OPSQBR;
            case "]": return Tag.CLSQBR;
            case ",": return Tag.COMMA;
            case "+": return Tag.PLUS;
            case "-": return Tag.MINUS;
            case "*": return Tag.MULT;
            case "/": return Tag.DIV;
            default: return Tag.ID;


        }

     }
}
