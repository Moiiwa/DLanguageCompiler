%token IDENT SEPARATOR
%token INT_TOKEN REAL_TOKEN STR_TOKEN
%token INT_TYPE REAL_TYPE BOOL_TYPE STR_TYPE EMPTY_TYPE FUNC_TYPE
%token TRUE FALSE
%token OR AND XOR LT LE GT GE EQ NE NOT
%token IS IN
%token READ_INT READ_REAL READ_STR PRINT
%token RETURN IF THEN ELSE END WHILE FOR LOOP LAMBDA BEGIN RANGE
%token VAR ASSIGN
%token PLUS MINUS MULT DIV
%token LPAREN RPAREN LBRACE RBRACE LBRACKET RBRACKET
%token COMMA COLON

%%

Program
    : Statements
    ;

Statements
    : Statement
    | Statements Statement
    ;

Statement
    : Declaration
    | Assignment
    | If
    | Loop
    | Return
    | Print
    ;

Declaration
    : VAR VariableDefinitions
    ;

VariableDefinitions
    : VariableDefinition
    | VariableDefinitions VariableDefinition
    ;

VariableDefinition
    : IDENT 
    | IDENT VariableDefinitionTail
    ;

VariableDefinitionTail
    : ASSIGN Expression