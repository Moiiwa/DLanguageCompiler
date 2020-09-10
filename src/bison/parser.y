%language "Java"
%token IDENTIFIER SEPARATOR
%token INT_LITERAL REAL_LITERAL STR_LITERAL
%token INT_TYPE REAL_TYPE BOOL_TYPE STR_TYPE EMPTY_TYPE FUNC_TYPE
%token TRUE FALSE
%token OR AND XOR LT LE GT GE EQ NE NOT
%token IS IN
%token READ_INT READ_REAL READ_STR PRINT
%token RETURN IF THEN ELSE END WHILE FOR LOOP LAMBDA RANGE
%token VAR ASSIGN
%token PLUS MINUS MULT DIVgit st
%token LPAREN RPAREN LBRACE RBRACE LBRACKET RBRACKET
%token COMMA DOT

%%

Program
    : Statements
    ;

Statements
    : // empty
    | StatementList
    ;

StatementList
    : Statement
    | StatementList SEPARATOR Statement
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
    : IDENTIFIER 
    | IDENTIFIER VariableDefinitionTail
    ;

VariableDefinitionTail
    : ASSIGN Expression
    ;

Assignment
    : Reference ASSIGN Expression
    ;

If
    : IF Expression THEN Body IfTail
    ;

IfTail
    : END
    | ELSE Body END
    ;

Loop
    : WHILE Expression LOOP Body END
    | FOR IDENTIFIER IN Expression RANGE Expression LOOP Body END
    ;

Body
    : Statements
    ;

Return
    : RETURN
    | RETURN Expression
    ;

Print
    : PRINT
    | PRINT Expressions
    ;

Expressions
    : Expression
    | Expressions COMMA Expression
    ;

Expression
    : Relation
    | Expression ExpressionOperator Relation
    ;

ExpressionOperator
    : OR
    | AND
    | XOR
    ;

Relation
    : Factor
    | Relation RelationOperator Factor
    ;

RelationOperator
    : LT
    | LE
    | GT
    | GE
    | EQ
    | NE
    ;

Factor
    : Term
    | Factor FactorOperator Term
    ;

FactorOperator
    : PLUS
    | MINUS
    ;

Term
    : Unary
    | Term TermOperator Unary
    ;

TermOperator
    : MULT
    | DIV
    ;

Unary
    : Reference
    | Reference IS TypeIndicator
    | UnaryOperator Primary
    | Primary
    ;

UnaryOperator
    : PLUS
    | MINUS
    | NOT
    ;

TypeIndicator
    : INT_TYPE
    | REAL_TYPE
    | BOOL_TYPE
    | STR_TYPE
    | EMPTY_TYPE
    | LBRACKET RBRACKET // Vector type
    | LBRACE RBRACE // Tuple type
    | FUNC_TYPE
    ;

Primary
    : Literal
    | READ_INT
    | READ_REAL
    | READ_STR
    | FunctionLiteral
    | LPAREN Expression RPAREN
    ;

FunctionLiteral
    : FUNC_TYPE LPAREN Parameters RPAREN FunBody
    ;

Parameters
    : // empty
    | Identifiers;
    ;

Identifiers
    : IDENTIFIER
    | Identifiers COMMA Identifiers;

FunBody
    : IS Body END LAMBDA Expression
    ;

Reference
    : IDENTIFIER
    | Reference LBRACKET Expression RBRACKET
    | Reference LBRACE Expression RBRACE
    | Reference DOT IDENTIFIER
    ;

Literal
    : INT_LITERAL
    | REAL_LITERAL
    | STR_LITERAL
    | Boolean
    | Tuple
    | Array
    | EMPTY_TYPE
    ;

Boolean
    : TRUE
    | FALSE
    ;

Array
    : LBRACKET Expressions RBRACKET
    ;


Tuple
    : LBRACE TupleElements RBRACE
    ;

TupleElements
    : TupleElement
    | TupleElements COMMA TupleElement
    ;

TupleElement
    : Expression
    | IDENTIFIER ASSIGN Expression
    ;

