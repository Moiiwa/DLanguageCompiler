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
%type <Unary> Unary
%type <IsStatement> Is
%type <Token> UnaryOperator
%type <Token> TypeIndicator
%type <Primary> Primary
%type <Function> FunctionLiteral
%type <ArrayList<Identifier>> Parameters
%type <ArrayList<Identifier>> Identifiers
%type <FunctionBody> FunBody
%type <Reference> Reference
%type <Literal> Literal
%type <Token> Boolean
%type <Array> Array
%type <Tuple> Tuple
%type <List<TupleElement>> TupleElements
%type <TupleElement> TupleElement


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
    : Reference  { $$ = new Unary($1); }
    | Is  { $$ = new Unary($1); }
    | Primary  { $$ = new Unary($1); }
    | UnaryOperator Primary  { $$ = new Unary($2, $1); }
    ;

Is
    : Reference IS TypeIndicator  { $$ = new IsStatement($1, $3); }
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
    : Literal  { $$ = new Primary($1); }
    | READ_INT  { $$ = new Primary($1); }
    | READ_REAL  { $$ = new Primary($1); }
    | READ_STR  { $$ = new Primary($1); }
    | FunctionLiteral  { $$ = new Primary($1); }
    | LPAREN Expression RPAREN  { $$ = new Primary($2); }
    ;

FunctionLiteral
    : FUNC_TYPE LPAREN Parameters RPAREN FunBody
        {
            $$ = new Function($3, $5);
        }
    ;

Parameters
    :   { $$ = new ArrayList<Identifier>(); }
    | Identifiers;  { $$ = $1; }
    ;

Identifiers
    : IDENTIFIER
        {
            $$ = new ArrayList<Identifier>();
            $$.add($1);
        }
    | Identifiers COMMA Identifiers;  { $1.add($3); }

FunBody
    : IS Body END { $$ = new FunctionBody($2); }
    | LAMBDA Expression  { $$ = new FunctionBody($2); }
    ;

Reference
    : IDENTIFIER  { $$ = new Reference($1); }
    | Reference LBRACKET Expression RBRACKET  { $$ = new ArrayReference($1, $3); }
    | Reference LPAREN Expression RPAREN  {$$ = new FunctionReference($1, $3); }
    | Reference DOT IDENTIFIER  { $$ = new TupleReference($1, $3); }
    ;

Literal
    : INT_LITERAL  { $$ = new Literal($$1); }
    | REAL_LITERAL  { $$ = new Literal($$1); }
    | STR_LITERAL  { $$ = new Literal($$1); }
    | Boolean  { $$ = new Literal($$1); }
    | Tuple  { $$ = new Literal($$1); }
    | Array  { $$ = new Literal($$1); }
    | EMPTY_TYPE  { $$ = new Literal($$1); }
    ;

Boolean
    : TRUE  { $$ = $1; }
    | FALSE  { $$ = $1; }
    ;

Array
    : LBRACKET Expressions RBRACKET  { $$ = new Array($2); }
    ;


Tuple
    : LBRACE TupleElements RBRACE  { $$ = new Tuple($2); }
    ;

TupleElements
    : TupleElement  
        { 
            $$ = new ArrayList<TupleElement>();
            $$.add($1);
        }
    | TupleElements COMMA TupleElement  { $1.add($3); }
    ;

TupleElement
    : Expression  { $$ = new TupleElement(Expression); }
    | IDENTIFIER ASSIGN Expression  { $$ = new TupleElement($1, $3); }
    ;

