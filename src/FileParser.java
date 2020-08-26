import java.io.*;
import java.util.LinkedList;
import java.util.List;
import lexer.*;

class FileParser {
    public List<String> parsed = new LinkedList<String>();

    private int lineNumber = 1;

    private String line = "";

    public List<Token> tokenList = new LinkedList<>();

    private static BufferedReader ReadFile(String path) throws FileNotFoundException {
        File file = new File(path);
            return new BufferedReader(new FileReader(file));
    }

    public void ParseFile(String path) throws Exception {
        BufferedReader br = ReadFile(path);
        System.out.println(br.read());
        line = br.readLine();
        scan(line);
    }

    public void scan(String line) throws Exception {
        char peek = ' ';
        boolean dotInString = false;
        boolean isReal = false;
        StringBuilder stringBuilder = null;
        for (int i = 0; i < line.length(); ++i) {
            peek = line.charAt(i);
            if (peek == ' ' || peek == '\t') {
                if (stringBuilder != null)
                    scan(stringBuilder.toString());
            }
            if (Character.isDigit(peek)) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(peek);
                do {
                    if (i + 1 < line.length()) {
                        i = i + 1;
                        peek = line.charAt(i);
                        if (Character.isDigit(peek)) {
                            stringBuilder.append(peek);
                        } else if (peek == '.') {
                            if (!dotInString) {
                                dotInString = true;
                                stringBuilder.append(peek);
                                isReal = true;
                            } else {
                                throw new ArithmeticException();
                            }
                        } else if (peek == ' ' || peek == '\t') {
                            if (isReal) {
                                tokenList.add(new RealToken(Float.parseFloat(stringBuilder.toString())));
                                stringBuilder = null;
                                isReal = false;
                                dotInString = false;
                                break;
                            } else {
                                tokenList.add(new IntToken(Integer.parseInt(stringBuilder.toString())));
                                stringBuilder = null;
                                isReal = false;
                                dotInString = false;
                                break;
                            }
                        } else if (dotInString) throw new TypeNotPresentException("the one, you wrote is", null);
                    } else {
                        if (isReal) {
                            tokenList.add(new RealToken(Float.parseFloat(stringBuilder.toString())));
                            stringBuilder = null;
                            isReal = false;
                            dotInString = false;
                            break;
                        } else {
                            tokenList.add(new IntToken(Integer.parseInt(stringBuilder.toString())));
                            stringBuilder = null;
                            isReal = false;
                            dotInString = false;
                            break;
                        }
                    }
                } while (Character.isDigit(peek) || peek == '.');
            }
            if(Character.isLetter(peek) || peek == '_'){
                if (stringBuilder == null){
                    stringBuilder = new StringBuilder();
                }
                stringBuilder.append(peek);
                do {
                    if (i + 1 < line.length()) {
                        i = i + 1;
                        peek = line.charAt(i);
                        if (Character.isDigit(peek) || Character.isLetter(peek) || peek == '_') {
                            stringBuilder.append(peek);
                        }
                        else if (peek != ' ' && peek != '\t'){          //TODO: also check if it's not symbols like /=, =, := and so on
                            throw new TypeNotPresentException("the one, you wrote is", null);
                        }
                    } else {
                        tokenList.add( new StrToken(stringBuilder.toString()));
                        stringBuilder = null;
                        break;
                    }
                } while (Character.isLetter(peek) || Character.isDigit(peek) || peek == '_');
                if(stringBuilder!=null)
                    tokenList.add(new StrToken(stringBuilder.toString()));
            }
        }
    }
}
/*
        for (int i = 0; i< ; peek = file_text.charAt(local_index)){
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

     }*/
