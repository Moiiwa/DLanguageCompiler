%language "Java"

%token IDENTIFIER SEPARATOR
%token INT_LITERAL REAL_LITERAL STR_LITERAL
%token INT_TYPE REAL_TYPE BOOL_TYPE STR_TYPE EMPTY_TYPE FUNC_TYPE
%token TRUE FALSE
%token OR AND XOR LT LE GT GE EQ NE NOT
%token IS IN
%token READ_INT READ_REAL READ_STR PRINT
%token RETURN IF THEN ELSE END WHILE FOR LOOP LAMBDA TWO_DOTS
%token VAR ASSIGN
%token PLUS MINUS MULT DIV
%token LPAREN RPAREN LBRACE RBRACE LBRACKET RBRACKET
%token COMMA DOT

// need to replace Token class with the actual token class
%type <Program> Program
%type <ArrayList<Statement>> Statements
%type <Statement> Statement
%type <Declaration> Declaration
%type <List<VariableDefinition>> VariableDefinitions
%type <VariableDefinition> VariableDefinition
%type <Expression> VariableDefinitionTail
%type <Assignment> Assignment
%type <IfStatement> If
%type <Body> IfTail
%type <Loop> Loop
%type <Range> Range
%type <Body> Body
%type <ReturnStatement> Return
%type <PrintStatement> Print
%type <List<Expression>> Expressions
%type <Expression> Expression
%type <Token> ExpressionOperator
%type <Relation> Relation
%type <Token> RelationOperator
%type <Factor> Factor
%type <Token> FactorOperator
%type <Term> Term
%type <Token> TermOperator


%%

Program
    : Statements { $$ = new ProgramTree($1); }
    ;


Statements
    : { $$ = new ArrayList<Statement>(); }
    | Statement  
        { 
            $$ = new ArrayList<Statement>(); 
            $$.add($1);
        }
    | Statements SEPARATOR  {}
    | Statements SEPARATOR Statement { $1.add($3); }
    ;

Statement
    : Declaration { $$ = $1; }
    | Assignment  { $$ = $1; }
    | If  { $$ = $1; }
    | Loop  { $$ = $1; }
    | Return  { $$ = $1; }
    | Print  { $$ = $1; }
    ;

Declaration
    : VAR VariableDefinitions  { $$ = new Declaration($1); }
    ;

VariableDefinitions
    : VariableDefinition  { $$ = new ArrayList<VariableDefinition>(); }
    | VariableDefinitions COMMA VariableDefinition { $1.add($3); }
    ;

VariableDefinition
    : IDENTIFIER   { $$ = new VariableDefinition($1); }
    | IDENTIFIER VariableDefinitionTail  {$$ = new VariableDefinition($1, $2); }
    ;

VariableDefinitionTail
    : ASSIGN Expression  { $$ = $2; }
    ;

Assignment
    : Reference ASSIGN Expression  { $$ = new Assignment($1, $3); }
    ;

If
    : IF Expression THEN Body IfTail  
        {
            if ($5 instanceof Body) {  // there is an else body
                $$ = new IfStatement($2, $4, $5);
            } else {
                $$ = new IfStatement($2, $4);
            }
        }
    ;

IfTail
    : END  { $$ = null; }
    | ELSE Body END  { $$ = $2; }
    ;

Loop
    : WHILE Expression LOOP Body END  { $$ = new WhileLoop($2, $4); }
    | FOR IDENTIFIER IN Range LOOP Body END
        {
            $$ = new ForLoop($2, $4, $6);
        }
    ;

Range
    : Expression TWO_DOTS Expression  { $$ = new Range($1, $3); }
    ;

Body
    : Statements  { $$ = new Body($1); }
    ;

Return
    : RETURN  { $$ = new ReturnStatement(); }
    | RETURN Expression { $$ = new ReturnStatement($2); }
    ;

Print
    : PRINT  { $$ = new PrintStatement(new ArrayList<Expression>()); }
    | PRINT Expressions { $$ = new PrintStatements($2); }
    ;

Expressions
    : Expression
        {
            $$ = new ArrayList<Expression>();
            $$.add($1);
        }
    | Expressions COMMA Expression  { $$.add($3); }
    ;

Expression
    : Relation  { $$ = new Expression($1); }
    | Expression ExpressionOperator Relation  { $$.add($3, $2); }
    ;

ExpressionOperator
    : OR  { $$ = $1; }
    | AND  { $$ = $1; }
    | XOR  { $$ = $1; }
    ;

Relation
    : Factor  { $$ = new Relation($1); }
    | Relation RelationOperator Factor  { $$.add($3, $2); }
    ;

RelationOperator
    : LT  { $$ = $1; }
    | LE  { $$ = $1; }
    | GT  { $$ = $1; }
    | GE  { $$ = $1; }
    | EQ  { $$ = $1; }
    | NE  { $$ = $1; }
    ;

Factor
    : Term  { $$ = new Factor($1); }
    | Factor FactorOperator Term  { $$.add($3, $2); }
    ;

FactorOperator
    : PLUS  { $$ = $1; }
    | MINUS  { $$ = $1; }
    ;

Term
    : Unary  { $$ = new Term($1); }
    | Term TermOperator Unary  { $$.add($3, $2); }
    ;

TermOperator
    : MULT  { $$ = $1; }
    | DIV  { $$ = $1; }
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

