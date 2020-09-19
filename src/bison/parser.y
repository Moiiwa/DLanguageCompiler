%language "Java"

%token IDENTIFIER SEPARATOR
%token INT_LITERAL REAL_LITERAL STR_LITERAL
%token INT_TYPE REAL_TYPE BOOL_TYPE STR_TYPE EMPTY_TYPE FUNC_TYPE
%token TRUE FALSE
%token OR AND XOR LT LE GT GE EQ NE NOT
%token IS IN
%token READ_INT READ_REAL READ_STR PRINT
%token RETURN IF THEN ELSE END WHILE FOR LOOP LAMBDA TWO_DOTS RANGE
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
%type <Declaration> VAR
%type <VariableDefinition> IDENTIFIER
%type <ExpressionOperator> OR AND XOR
%type <RelationOperator> LT LE GT GE EQ NE
%type <FactorOperator> PLUS MINUS MULT DIV
%type <Primary> READ_INT READ_REAL READ_STR
%type <Boolean> TRUE FALSE
%type <Token> INT_LITERAL REAL_LITERAL STR_LITERAL EMPTY_TYPE

%%

Program
    : Statements { $$ = new ProgramTree($1); }
    ;


Statements
    : { $$ = new ArrayList<Statement>(); }
    | Statement  
        { 
            $$ = new ArrayList<Statement>();
            ((List<Statement>)$$).add($1);
        }
    | Statements SEPARATOR  {}
    | Statements SEPARATOR Statement { ((List<Statement>)$1).add($3); }
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
    | VariableDefinitions COMMA VariableDefinition { ((List<VariableDefinition>)$1).add($3); }
    ;

VariableDefinition
    : IDENTIFIER   { $$ = new VariableDefinition((Identifier)$1); }
    | IDENTIFIER VariableDefinitionTail  {$$ = new VariableDefinition((Identifier)$1, (Expression)$2); }
    ;

VariableDefinitionTail
    : ASSIGN Expression  { $$ = $2; }
    ;

Assignment
    : Reference ASSIGN Expression  { $$ = new Assignment((Reference)$1, (Expression)$3); }
    ;

If
    : IF Expression THEN Body IfTail  
        {
            if ($5 instanceof Body) {  // there is an else body
                $$ = new IfStatement((Expression)$2, (Body)$4, (Body)$5);
            } else {
                $$ = new IfStatement((Expression)$2, (Body)$4);
            }
        }
    ;

IfTail
    : END  { $$ = null; }
    | ELSE Body END  { $$ = $2; }
    ;

Loop
    : WHILE Expression LOOP Body END  { $$ = new WhileLoop((Expression)$2, (Body)$4); }
    | FOR IDENTIFIER IN Range LOOP Body END
        {
            $$ = new ForLoop((Identifier)$2, (Range)$4, (Body)$6);
        }
    ;

Range
    : Expression TWO_DOTS Expression  { $$ = new Range((Expression)$1, (Expression)$3); }
    ;

Body
    : Statements  { $$ = new Body((ArrayList<Statement>)$1); }
    ;

Return
    : RETURN  { $$ = new ReturnStatement(); }
    | RETURN Expression { $$ = new ReturnStatement((Expression)$2); }
    ;

Print
    : PRINT  { $$ = new PrintStatement(new ArrayList<Expression>()); }
    | PRINT Expressions { $$ = new PrintStatements((ArrayList<Expression>)$2); }
    ;

Expressions
    : Expression
        {
            $$ = new ArrayList<Expression>();
            ((List<Expression>)$$).add($1);
        }
    | Expressions COMMA Expression  { ((List<Expression>)$$).add((Expression)$3); }
    ;

Expression
    : Relation  { $$ = new Expression((Relation)$1); }
    | Expression ExpressionOperator Relation  { ((Expression)$$).add((Relation)$3, (ExpressionOperator)$2); }
    ;

ExpressionOperator
    : OR  { $$ = $1; }
    | AND  { $$ = $1; }
    | XOR  { $$ = $1; }
    ;

Relation
    : Factor  { $$ = new Relation((Factor)$1); }
    | Relation RelationOperator Factor  { ((Factor)$$).add((Factor)$3, (RelationOperator)$2); }
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
    : Term  { $$ = new Factor((Term)$1); }
    | Factor FactorOperator Term  { ((Factor)$$).add((Term)$3, (FactorOperator)$2); }
    ;

FactorOperator
    : PLUS  { $$ = $1; }
    | MINUS  { $$ = $1; }
    ;

Term
    : Unary  { $$ = new Term((Unary)$1); }
    | Term TermOperator Unary  { ((Term)$$).add((Unary)$3, (Token)$2); }
    ;

TermOperator
    : MULT  { $$ = $1; }
    | DIV  { $$ = $1; }
    ;

Unary
    : Reference  { $$ = new Unary((Reference)$1); }
    | Is  { $$ = new Unary((IsStatement)$1); }
    | Primary  { $$ = new Unary((Primary)$1); }
    | UnaryOperator Primary  { $$ = new Unary((Primary)$2, (Token)$1); }
    ;

Is
    : Reference IS TypeIndicator  { $$ = new IsStatement((Reference)$1, (TypeIndicator)$3); }
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
    : Literal  { $$ = new Primary((Literal)$1); }
    | READ_INT  { $$ = new Primary((Token)$1); }
    | READ_REAL  { $$ = new Primary((Token)$1); }
    | READ_STR  { $$ = new Primary((Token)$1); }
    | FunctionLiteral  { $$ = new Primary((Function)$1); }
    | LPAREN Expression RPAREN  { $$ = new Primary((Expression)$2); }
    ;

FunctionLiteral
    : FUNC_TYPE LPAREN Parameters RPAREN FunBody
        {
            $$ = new Function((ArrayList<Identifier>)$3, (FunctionBody)$5);
        }
    ;

Parameters
    :   { $$ = new ArrayList<Identifier>(); }
    | Identifiers  { $$ = $1; }
    ;

Identifiers
    : IDENTIFIER
        {
            $$ = new ArrayList<Identifier>();
            ((List<Identifier>)$$).add($1);
        }
    | Identifiers COMMA Identifiers  { ((List<Identifier>)$1).add((List<Identifier>)$3); }
    ;
FunBody
    : IS Body END { $$ = new FunctionBody((Body)$2); }
    | LAMBDA Expression  { $$ = new FunctionBody((Expression)$2); }
    ;

Reference
    : IDENTIFIER  { $$ = new Reference((Token)$1); }
    | Reference LBRACKET Expression RBRACKET  { $$ = new ArrayReference((Reference)$1, (Expression)$3); }
    | Reference LPAREN Expression RPAREN  {$$ = new FunctionReference((Reference)$1, (Expression)$3); }
    | Reference DOT IDENTIFIER  { $$ = new TupleReference((Reference)$1, (Token)$3); }
    ;

Literal
    : INT_LITERAL  { $$ = new Literal((Token)$1); }
    | REAL_LITERAL  { $$ = new Literal((Token)$1); }
    | STR_LITERAL  { $$ = new Literal((Token)$1); }
    | Boolean  { $$ = new Literal((Token)$1); }
    | Tuple  { $$ = new Literal((Tuple)$1); }
    | Array  { $$ = new Literal((Array)$1); }
    | EMPTY_TYPE  { $$ = new Literal((Token)$1); }
    ;

Boolean
    : TRUE  { $$ = $1; }
    | FALSE  { $$ = $1; }
    ;

Array
    : LBRACKET Expressions RBRACKET  { $$ = new Array((List<Expression>)$2); }
    ;


Tuple
    : LBRACE TupleElements RBRACE  { $$ = new Tuple((List<TupleElement>)$2); }
    ;

TupleElements
    : TupleElement  
        { 
            $$ = new ArrayList<TupleElement>();
            ((List<TupleElement>)$$).add($1);
        }
    | TupleElements COMMA TupleElement  { ((List<TupleElement>)$1).add((TupleElement)$3); }
    ;

TupleElement
    : Expression  { $$ = new TupleElement((Expression)$1); }
    | IDENTIFIER ASSIGN Expression  { $$ = new TupleElement((Token)$1, (Expression)$3); }
    ;

