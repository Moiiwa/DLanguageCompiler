package lexer;

public class Tag {
    public final static int
        NUM = 256, // number
        ID = 257, // identifier

        // Boolean literals
        TRUE = 258,
        FALSE = 259,

        // Types
        INT = 260,
        REAL = 261,
        BOOL = 262,
        STRING = 263,
        EMPTY = 264,
        FUNC = 265,

        // Logical operators
        AND = 270,
        OR = 271,
        XOR = 272,
        LT = 273,
        LE = 274,
        GT = 275,
        GE = 276,
        NE = 277,
        NOT = 278,

        // Is, In operator
        IS = 290,
        IN = 291,

        // Input/Output
        READ_INT = 300,
        READ_REAL = 301,
        READ_STRING = 302,
        PRINT = 303,

        // Control flow
        RETURN = 310,
        IF = 311,
        THEN = 312,
        ELSE = 313,
        END = 314,
        WHILE = 315,
        FOR = 316,
        LOOP = 317,
        LAMBDA = 318,

        // Basic
        VAR = 320,
        ASSIGN = 321;

}
