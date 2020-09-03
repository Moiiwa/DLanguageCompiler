package lexer;

enum Tag {
    // Token types
    IDENTIFIER,
    SEPARATOR, // statement separator (semicolon or new line)
    INT_TOKEN,
    REAL_TOKEN,
    STR_TOKEN,

    // Type indicators
    INT,
    REAL,
    BOOL,
    STRING,
    EMPTY,
    FUNC,

    // Boolean literals
    TRUE,
    FALSE,

    // Logical operators
    OR,
    AND,
    XOR,
    LT,
    LE,
    GT,
    GE,
    EQ,
    NE,
    NOT,

    // Is, In operator
    IS,
    IN,

    // Input/Output
    READ_INT,
    READ_REAL,
    READ_STRING,
    PRINT,

    // Control flow
    RETURN,
    IF,
    THEN,
    ELSE,
    END,
    WHILE,
    FOR,
    LOOP,
    LAMBDA,
    BEGIN,

    // Basic
    VAR,
    ASSIGN,

    // Arithmetic operators
    PLUS,
    MINUS,
    MULT,
    DIV,

    // Brackets
    OPEN_RND_BR, // round brackets (parentheses)
    CLOS_RND_BR,
    OPEN_CRL_BR, // curly brackets (braces)
    CLOS_CRL_BR,
    OPEN_SQR_BR, // square brackets (brackets)
    CLOS_SQR_BR,

    // Other
    COMMA,
    COLON,
    DOUBLE_DOT
}
