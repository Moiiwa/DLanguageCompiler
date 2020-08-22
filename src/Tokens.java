import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Tokens {

    // Sets of tokens divided into groups
    public static Set<String> relationTokens;

    public static Set<String> logicTokens;

    public static Set<String> mathTokens;

    public static Set<String> loopTokens;

    public static Set<String> typeTokens;

    public static Set<String> parameterTokens;

    public static Set<String> unsortedTokens;

    public static Set<String> booleanTokens;

    //Set of tokens that includes all the tokens
    public static Set<String> allTokens;

    //Iterators for all the sets
    public static Iterator relationTokensIterator;

    public static Iterator logicTokensIterator;

    public static Iterator mathTokensIterator;

    public static Iterator loopTokensIterator;

    public static Iterator typeTokensIterator;

    public static Iterator parameterTokensIterator;

    public static Iterator unsortedTokensIterator;

    public static Iterator booleanTokensIterator;

    //static block of initialization
    static {
        initializeRelationsTokens();
        initializeLogicTokens();
        initializeMathTokens();
        initializeLoopTokens();
        initializeTypeTokens();
        initializeParameterTokens();
        initializeUnsortedTokens();
        initializeBooleanTokens();
        initializeIterators();
        initializeAllTokens();
    }

    //walk through all sets and add all tokens
    private static void initializeAllTokens(){
        allTokens = new HashSet<>();
        while (relationTokensIterator.hasNext()){
            allTokens.add((String) relationTokensIterator.next());
        }
        while (logicTokensIterator.hasNext()){
            allTokens.add((String) logicTokensIterator.next());
        }
        while (mathTokensIterator.hasNext()){
            allTokens.add((String) mathTokensIterator.next());
        }
        while (loopTokensIterator.hasNext()){
            allTokens.add((String) loopTokensIterator.next());
        }
        while (typeTokensIterator.hasNext()){
            allTokens.add((String) typeTokensIterator.next());
        }
        while (parameterTokensIterator.hasNext()){
            allTokens.add((String) parameterTokensIterator.next());
        }
        while (unsortedTokensIterator.hasNext()){
            allTokens.add((String) unsortedTokensIterator.next());
        }
        while (booleanTokensIterator.hasNext()){
            allTokens.add((String) booleanTokensIterator.next());
        }
    }

    private static void initializeIterators(){
        relationTokensIterator = relationTokens.iterator();
        logicTokensIterator = logicTokens.iterator();
        mathTokensIterator = mathTokens.iterator();
        loopTokensIterator = loopTokens.iterator();
        typeTokensIterator = typeTokens.iterator();
        parameterTokensIterator = parameterTokens.iterator();
        unsortedTokensIterator = unsortedTokens.iterator();
        booleanTokensIterator = booleanTokens.iterator();
    }

    private static void initializeBooleanTokens(){
        booleanTokens = new HashSet<>();
        booleanTokens.add("true");
        booleanTokens.add("false");
    }

    private static void initializeUnsortedTokens(){
        unsortedTokens = new HashSet<>();
        unsortedTokens.add("var");
        unsortedTokens.add("return");
        unsortedTokens.add("print");
        unsortedTokens.add(";");
        unsortedTokens.add("\n");
        unsortedTokens.add(":=");
    }

    private static void initializeParameterTokens(){
        parameterTokens = new HashSet<>();
        parameterTokens.add("(");
        parameterTokens.add(")");
        parameterTokens.add(",");
    }

    private static void initializeTypeTokens(){
        typeTokens = new HashSet<>();
        typeTokens.add("int");
        typeTokens.add("real");
        typeTokens.add("bool");
        typeTokens.add("string");
        typeTokens.add("empty");
        typeTokens.add("[");
        typeTokens.add("]");
        typeTokens.add("{");
        typeTokens.add("}");
        typeTokens.add("func");
    }

    private static void initializeLoopTokens(){
        loopTokens = new HashSet<>();
        loopTokens.add("loop");
        loopTokens.add("end");
        loopTokens.add("for");
        loopTokens.add("while");
        loopTokens.add("in");
    }

    private static void initializeMathTokens(){
        mathTokens = new HashSet<>();
        mathTokens.add("+");
        mathTokens.add("-");
        mathTokens.add("*");
        mathTokens.add("/");
    }

    private static void initializeLogicTokens(){
        logicTokens = new HashSet<>();
        logicTokens.add("and");
        logicTokens.add("or");
        logicTokens.add("xor");
        logicTokens.add("not");
        logicTokens.add("is");
    }

    private static void initializeRelationsTokens(){
        relationTokens = new HashSet<>();
        relationTokens.add("<");
        relationTokens.add("<=");
        relationTokens.add(">");
        relationTokens.add(">=");
        relationTokens.add("=");
        relationTokens.add("/=");
    }

}
