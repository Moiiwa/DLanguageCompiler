/* A Bison parser, made by GNU Bison 3.0.4.  */

/* Skeleton implementation for Bison LALR(1) parsers in Java

   Copyright (C) 2007-2015 Free Software Foundation, Inc.

   This program is free software: you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation, either version 3 of the License, or
   (at your option) any later version.

   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.

   You should have received a copy of the GNU General Public License
   along with this program.  If not, see <http://www.gnu.org/licenses/>.  */

/* As a special exception, you may create a larger work that contains
   part or all of the Bison parser skeleton and distribute that work
   under terms of your choice, so long as that work isn't itself a
   parser generator using the skeleton or a modified version thereof
   as a parser skeleton.  Alternatively, if you modify or redistribute
   the parser skeleton itself, you may (at your option) remove this
   special exception, which will cause the skeleton and the resulting
   Bison output files to be licensed under the GNU General Public
   License without this special exception.

   This special exception was added by the Free Software Foundation in
   version 2.2 of Bison.  */

/* First part of user declarations.  */

/* "YYParser.java":36  */ /* lalr1.java:91  */

/* "YYParser.java":38  */ /* lalr1.java:92  */
package bison;
import bison.wrappers.*;
import bison.wrappers.Boolean;

import java.util.ArrayList;
import java.util.List;
/**
 * A Bison parser, automatically generated from <tt>parser.y</tt>.
 *
 * @author LALR (1) parser skeleton written by Paolo Bonzini.
 */
public class YYParser
{
    /** Version number for the Bison executable that generated this parser.  */
  public static final String bisonVersion = "3.0.4";

  /** Name of the skeleton that generated this parser.  */
  public static final String bisonSkeleton = "lalr1.java";

  public ProgramTree programTree;



  

  /**
   * Communication interface between the scanner and the Bison-generated
   * parser <tt>YYParser</tt>.
   */
  public interface Lexer {
    /** Token returned by the scanner to signal the end of its input.  */
    public static final int EOF = 0;

/* Tokens.  */
    /** Token number,to be returned by the scanner.  */
    static final int IDENTIFIER = 258;
    /** Token number,to be returned by the scanner.  */
    static final int SEPARATOR = 259;
    /** Token number,to be returned by the scanner.  */
    static final int INT_LITERAL = 260;
    /** Token number,to be returned by the scanner.  */
    static final int REAL_LITERAL = 261;
    /** Token number,to be returned by the scanner.  */
    static final int STR_LITERAL = 262;
    /** Token number,to be returned by the scanner.  */
    static final int INT_TYPE = 263;
    /** Token number,to be returned by the scanner.  */
    static final int REAL_TYPE = 264;
    /** Token number,to be returned by the scanner.  */
    static final int BOOL_TYPE = 265;
    /** Token number,to be returned by the scanner.  */
    static final int STR_TYPE = 266;
    /** Token number,to be returned by the scanner.  */
    static final int EMPTY_TYPE = 267;
    /** Token number,to be returned by the scanner.  */
    static final int FUNC_TYPE = 268;
    /** Token number,to be returned by the scanner.  */
    static final int TRUE = 269;
    /** Token number,to be returned by the scanner.  */
    static final int FALSE = 270;
    /** Token number,to be returned by the scanner.  */
    static final int OR = 271;
    /** Token number,to be returned by the scanner.  */
    static final int AND = 272;
    /** Token number,to be returned by the scanner.  */
    static final int XOR = 273;
    /** Token number,to be returned by the scanner.  */
    static final int LT = 274;
    /** Token number,to be returned by the scanner.  */
    static final int LE = 275;
    /** Token number,to be returned by the scanner.  */
    static final int GT = 276;
    /** Token number,to be returned by the scanner.  */
    static final int GE = 277;
    /** Token number,to be returned by the scanner.  */
    static final int EQ = 278;
    /** Token number,to be returned by the scanner.  */
    static final int NE = 279;
    /** Token number,to be returned by the scanner.  */
    static final int NOT = 280;
    /** Token number,to be returned by the scanner.  */
    static final int IS = 281;
    /** Token number,to be returned by the scanner.  */
    static final int IN = 282;
    /** Token number,to be returned by the scanner.  */
    static final int READ_INT = 283;
    /** Token number,to be returned by the scanner.  */
    static final int READ_REAL = 284;
    /** Token number,to be returned by the scanner.  */
    static final int READ_STR = 285;
    /** Token number,to be returned by the scanner.  */
    static final int PRINT = 286;
    /** Token number,to be returned by the scanner.  */
    static final int RETURN = 287;
    /** Token number,to be returned by the scanner.  */
    static final int IF = 288;
    /** Token number,to be returned by the scanner.  */
    static final int THEN = 289;
    /** Token number,to be returned by the scanner.  */
    static final int ELSE = 290;
    /** Token number,to be returned by the scanner.  */
    static final int END = 291;
    /** Token number,to be returned by the scanner.  */
    static final int WHILE = 292;
    /** Token number,to be returned by the scanner.  */
    static final int FOR = 293;
    /** Token number,to be returned by the scanner.  */
    static final int LOOP = 294;
    /** Token number,to be returned by the scanner.  */
    static final int LAMBDA = 295;
    /** Token number,to be returned by the scanner.  */
    static final int TWO_DOTS = 296;
    /** Token number,to be returned by the scanner.  */
    static final int VAR = 297;
    /** Token number,to be returned by the scanner.  */
    static final int ASSIGN = 298;
    /** Token number,to be returned by the scanner.  */
    static final int PLUS = 299;
    /** Token number,to be returned by the scanner.  */
    static final int MINUS = 300;
    /** Token number,to be returned by the scanner.  */
    static final int MULT = 301;
    /** Token number,to be returned by the scanner.  */
    static final int DIV = 302;
    /** Token number,to be returned by the scanner.  */
    static final int LPAREN = 303;
    /** Token number,to be returned by the scanner.  */
    static final int RPAREN = 304;
    /** Token number,to be returned by the scanner.  */
    static final int LBRACE = 305;
    /** Token number,to be returned by the scanner.  */
    static final int RBRACE = 306;
    /** Token number,to be returned by the scanner.  */
    static final int LBRACKET = 307;
    /** Token number,to be returned by the scanner.  */
    static final int RBRACKET = 308;
    /** Token number,to be returned by the scanner.  */
    static final int COMMA = 309;
    /** Token number,to be returned by the scanner.  */
    static final int DOT = 310;


    

    /**
     * Method to retrieve the semantic value of the last scanned token.
     * @return the semantic value of the last scanned token.
     */
    Object getLVal ();

    /**
     * Entry point for the scanner.  Returns the token identifier corresponding
     * to the next token and prepares to return the semantic value
     * of the token.
     * @return the token identifier corresponding to the next token.
     */
    int yylex () throws java.io.IOException;

    /**
     * Entry point for error reporting.  Emits an error
     * in a user-defined way.
     *
     * 
     * @param msg The string for the error message.
     */
     void yyerror (String msg);
  }

  /**
   * The object doing lexical analysis for us.
   */
  private Lexer yylexer;
  
  



  /**
   * Instantiates the Bison-generated parser.
   * @param yylexer The scanner that will supply tokens to the parser.
   */
  public YYParser (Lexer yylexer) 
  {
    
    this.yylexer = yylexer;
    
  }

  private java.io.PrintStream yyDebugStream = System.err;

  /**
   * Return the <tt>PrintStream</tt> on which the debugging output is
   * printed.
   */
  public final java.io.PrintStream getDebugStream () { return yyDebugStream; }

  /**
   * Set the <tt>PrintStream</tt> on which the debug output is printed.
   * @param s The stream that is used for debugging output.
   */
  public final void setDebugStream(java.io.PrintStream s) { yyDebugStream = s; }

  private int yydebug = 0;

  /**
   * Answer the verbosity of the debugging output; 0 means that all kinds of
   * output from the parser are suppressed.
   */
  public final int getDebugLevel() { return yydebug; }

  /**
   * Set the verbosity of the debugging output; 0 means that all kinds of
   * output from the parser are suppressed.
   * @param level The verbosity level for debugging output.
   */
  public final void setDebugLevel(int level) { yydebug = level; }

  /**
   * Print an error message via the lexer.
   *
   * @param msg The error message.
   */
  public final void yyerror (String msg)
  {
    yylexer.yyerror (msg);
  }


  protected final void yycdebug (String s) {
    if (yydebug > 0)
      yyDebugStream.println (s);
  }

  private final class YYStack {
    private int[] stateStack = new int[16];
    
    private Object[] valueStack = new Object[16];

    public int size = 16;
    public int height = -1;

    public final void push (int state, Object value                            ) {
      height++;
      if (size == height)
        {
          int[] newStateStack = new int[size * 2];
          System.arraycopy (stateStack, 0, newStateStack, 0, height);
          stateStack = newStateStack;
          

          Object[] newValueStack = new Object[size * 2];
          System.arraycopy (valueStack, 0, newValueStack, 0, height);
          valueStack = newValueStack;

          size *= 2;
        }

      stateStack[height] = state;
      
      valueStack[height] = value;
    }

    public final void pop () {
      pop (1);
    }

    public final void pop (int num) {
      // Avoid memory leaks... garbage collection is a white lie!
      if (num > 0) {
        java.util.Arrays.fill (valueStack, height - num + 1, height + 1, null);
        
      }
      height -= num;
    }

    public final int stateAt (int i) {
      return stateStack[height - i];
    }

    public final Object valueAt (int i) {
      return valueStack[height - i];
    }

    // Print the state stack on the debug stream.
    public void print (java.io.PrintStream out)
    {
      out.print ("Stack now");

      for (int i = 0; i <= height; i++)
        {
          out.print (' ');
          out.print (stateStack[i]);
        }
      out.println ();
    }
  }

  /**
   * Returned by a Bison action in order to stop the parsing process and
   * return success (<tt>true</tt>).
   */
  public static final int YYACCEPT = 0;

  /**
   * Returned by a Bison action in order to stop the parsing process and
   * return failure (<tt>false</tt>).
   */
  public static final int YYABORT = 1;



  /**
   * Returned by a Bison action in order to start error recovery without
   * printing an error message.
   */
  public static final int YYERROR = 2;

  /**
   * Internal return codes that are not supported for user semantic
   * actions.
   */
  private static final int YYERRLAB = 3;
  private static final int YYNEWSTATE = 4;
  private static final int YYDEFAULT = 5;
  private static final int YYREDUCE = 6;
  private static final int YYERRLAB1 = 7;
  private static final int YYRETURN = 8;


  private int yyerrstatus_ = 0;


  /**
   * Return whether error recovery is being done.  In this state, the parser
   * reads token until it reaches a known state, and then restarts normal
   * operation.
   */
  public final boolean recovering ()
  {
    return yyerrstatus_ == 0;
  }

  /** Compute post-reduction state.
   * @param yystate   the current state
   * @param yysym     the nonterminal to push on the stack
   */
  private int yy_lr_goto_state_ (int yystate, int yysym)
  {
    int yyr = yypgoto_[yysym - yyntokens_] + yystate;
    if (0 <= yyr && yyr <= yylast_ && yycheck_[yyr] == yystate)
      return yytable_[yyr];
    else
      return yydefgoto_[yysym - yyntokens_];
  }

  private int yyaction (int yyn, YYStack yystack, int yylen) 
  {
    Object yyval;
    

    /* If YYLEN is nonzero, implement the default value of the action:
       '$$ = $1'.  Otherwise, use the top of the stack.

       Otherwise, the following line sets YYVAL to garbage.
       This behavior is undocumented and Bison
       users should not rely upon it.  */
    if (yylen > 0)
      yyval = yystack.valueAt (yylen - 1);
    else
      yyval = yystack.valueAt (0);

    yy_reduce_print (yyn, yystack);

    switch (yyn)
      {
          case 2:
  if (yyn == 2)
    /* "parser.y":69  */ /* lalr1.java:489  */
    {
        yyval = new ProgramTree(((ArrayList<Statement>)(yystack.valueAt (1-(1)))));
        programTree = (ProgramTree)yyval;
    };
  break;
    

  case 3:
  if (yyn == 3)
    /* "parser.y":74  */ /* lalr1.java:489  */
    { yyval = new ArrayList<Statement>(); };
  break;
    

  case 4:
  if (yyn == 4)
    /* "parser.y":76  */ /* lalr1.java:489  */
    { 
            yyval = new ArrayList<Statement>();
            ((ArrayList<Statement>)yyval).add(((Statement)(yystack.valueAt (1-(1)))));
        };
  break;
    

  case 5:
  if (yyn == 5)
    /* "parser.y":80  */ /* lalr1.java:489  */
    {};
  break;
    

  case 6:
  if (yyn == 6)
    /* "parser.y":81  */ /* lalr1.java:489  */
    { ((ArrayList<Statement>)(yystack.valueAt (3-(1)))).add(((Statement)(yystack.valueAt (3-(3))))); };
  break;
    

  case 7:
  if (yyn == 7)
    /* "parser.y":85  */ /* lalr1.java:489  */
    { yyval = new Statement(((Declaration)(yystack.valueAt (1-(1))))); };
  break;
    

  case 8:
  if (yyn == 8)
    /* "parser.y":86  */ /* lalr1.java:489  */
    { yyval = new Statement(((Assignment)(yystack.valueAt (1-(1))))); };
  break;
    

  case 9:
  if (yyn == 9)
    /* "parser.y":87  */ /* lalr1.java:489  */
    { yyval = new Statement(((IfStatement)(yystack.valueAt (1-(1))))); };
  break;
    

  case 10:
  if (yyn == 10)
    /* "parser.y":88  */ /* lalr1.java:489  */
    { yyval = new Statement(((Loop)(yystack.valueAt (1-(1))))); };
  break;
    

  case 11:
  if (yyn == 11)
    /* "parser.y":89  */ /* lalr1.java:489  */
    { yyval = new Statement(((ReturnStatement)(yystack.valueAt (1-(1))))); };
  break;
    

  case 12:
  if (yyn == 12)
    /* "parser.y":90  */ /* lalr1.java:489  */
    { yyval = new Statement(((Print)(yystack.valueAt (1-(1))))); };
  break;
    

  case 13:
  if (yyn == 13)
    /* "parser.y":94  */ /* lalr1.java:489  */
    { yyval = new Declaration(((Token)(yystack.valueAt (2-(1)))), ((List<VariableDefinition>)(yystack.valueAt (2-(2))))); };
  break;
    

  case 14:
  if (yyn == 14)
    /* "parser.y":98  */ /* lalr1.java:489  */
    { yyval = new ArrayList<VariableDefinition>(); ((ArrayList<VariableDefinition>)yyval).add(((VariableDefinition)(yystack.valueAt (1-(1)))));};
  break;
    

  case 15:
  if (yyn == 15)
    /* "parser.y":99  */ /* lalr1.java:489  */
    { ((ArrayList<VariableDefinition>)((List<VariableDefinition>)(yystack.valueAt (3-(1))))).add(((VariableDefinition)(yystack.valueAt (3-(3))))); };
  break;
    

  case 16:
  if (yyn == 16)
    /* "parser.y":103  */ /* lalr1.java:489  */
    { yyval = new VariableDefinition(((Identifier)(yystack.valueAt (1-(1))))); };
  break;
    

  case 17:
  if (yyn == 17)
    /* "parser.y":104  */ /* lalr1.java:489  */
    {yyval = new VariableDefinition(((Identifier)(yystack.valueAt (2-(1)))), ((Expression)(yystack.valueAt (2-(2))))); };
  break;
    

  case 18:
  if (yyn == 18)
    /* "parser.y":108  */ /* lalr1.java:489  */
    { yyval = ((Expression)(yystack.valueAt (2-(2)))); };
  break;
    

  case 19:
  if (yyn == 19)
    /* "parser.y":112  */ /* lalr1.java:489  */
    { yyval = new Assignment(((Reference)(yystack.valueAt (3-(1)))), ((Expression)(yystack.valueAt (3-(3))))); };
  break;
    

  case 20:
  if (yyn == 20)
    /* "parser.y":117  */ /* lalr1.java:489  */
    {
            if (((Body)(yystack.valueAt (5-(5)))) instanceof Body) {  // there is an else body
                yyval = new IfStatement(((Expression)(yystack.valueAt (5-(2)))), ((Body)(yystack.valueAt (5-(4)))), ((Body)(yystack.valueAt (5-(5)))));
            } else {
                yyval = new IfStatement(((Expression)(yystack.valueAt (5-(2)))), ((Body)(yystack.valueAt (5-(4)))));
            }
        };
  break;
    

  case 21:
  if (yyn == 21)
    /* "parser.y":127  */ /* lalr1.java:489  */
    { yyval = null; };
  break;
    

  case 22:
  if (yyn == 22)
    /* "parser.y":128  */ /* lalr1.java:489  */
    { yyval = ((Body)(yystack.valueAt (3-(2)))); };
  break;
    

  case 23:
  if (yyn == 23)
    /* "parser.y":132  */ /* lalr1.java:489  */
    { yyval = new WhileLoop(((Expression)(yystack.valueAt (5-(2)))), ((Body)(yystack.valueAt (5-(4))))); };
  break;
    

  case 24:
  if (yyn == 24)
    /* "parser.y":134  */ /* lalr1.java:489  */
    {
            yyval = new ForLoop(((Identifier)(yystack.valueAt (7-(2)))), ((Range)(yystack.valueAt (7-(4)))), ((Body)(yystack.valueAt (7-(6)))));
        };
  break;
    

  case 25:
  if (yyn == 25)
    /* "parser.y":140  */ /* lalr1.java:489  */
    { yyval = new Range(((Expression)(yystack.valueAt (3-(1)))), ((Expression)(yystack.valueAt (3-(3))))); };
  break;
    

  case 26:
  if (yyn == 26)
    /* "parser.y":144  */ /* lalr1.java:489  */
    { yyval = new Body(((ArrayList<Statement>)(yystack.valueAt (1-(1))))); };
  break;
    

  case 27:
  if (yyn == 27)
    /* "parser.y":148  */ /* lalr1.java:489  */
    { yyval = new ReturnStatement(); };
  break;
    

  case 28:
  if (yyn == 28)
    /* "parser.y":149  */ /* lalr1.java:489  */
    { yyval = new ReturnStatement(((Expression)(yystack.valueAt (2-(2))))); };
  break;
    

  case 29:
  if (yyn == 29)
    /* "parser.y":153  */ /* lalr1.java:489  */
    { yyval = new PrintStatement(new ArrayList<Expression>()); };
  break;
    

  case 30:
  if (yyn == 30)
    /* "parser.y":154  */ /* lalr1.java:489  */
    { yyval = new PrintStatements(((ArrayList<Expression>)(yystack.valueAt (2-(2))))); };
  break;
    

  case 31:
  if (yyn == 31)
    /* "parser.y":159  */ /* lalr1.java:489  */
    {
            yyval = new ArrayList<Expression>();
            ((List<Expression>)yyval).add(((Expression)(yystack.valueAt (1-(1)))));
        };
  break;
    

  case 32:
  if (yyn == 32)
    /* "parser.y":163  */ /* lalr1.java:489  */
    { ((ArrayList<Expression>)yyval).add(((Expression)(yystack.valueAt (3-(3))))); };
  break;
    

  case 33:
  if (yyn == 33)
    /* "parser.y":167  */ /* lalr1.java:489  */
    { yyval = new Expression(((Relation)(yystack.valueAt (1-(1))))); };
  break;
    

  case 34:
  if (yyn == 34)
    /* "parser.y":168  */ /* lalr1.java:489  */
    { ((Expression)yyval).add(((Relation)(yystack.valueAt (3-(3)))), ((Token)(yystack.valueAt (3-(2))))); };
  break;
    

  case 35:
  if (yyn == 35)
    /* "parser.y":172  */ /* lalr1.java:489  */
    { yyval = ((ExpressionOperator)(yystack.valueAt (1-(1)))); };
  break;
    

  case 36:
  if (yyn == 36)
    /* "parser.y":173  */ /* lalr1.java:489  */
    { yyval = ((ExpressionOperator)(yystack.valueAt (1-(1)))); };
  break;
    

  case 37:
  if (yyn == 37)
    /* "parser.y":174  */ /* lalr1.java:489  */
    { yyval = ((ExpressionOperator)(yystack.valueAt (1-(1)))); };
  break;
    

  case 38:
  if (yyn == 38)
    /* "parser.y":178  */ /* lalr1.java:489  */
    { yyval = new Relation(((Factor)(yystack.valueAt (1-(1))))); };
  break;
    

  case 39:
  if (yyn == 39)
    /* "parser.y":179  */ /* lalr1.java:489  */
    { ((Relation)yyval).add(((Factor)(yystack.valueAt (3-(3)))), ((Token)(yystack.valueAt (3-(2))))); };
  break;
    

  case 40:
  if (yyn == 40)
    /* "parser.y":183  */ /* lalr1.java:489  */
    { yyval = ((RelationOperator)(yystack.valueAt (1-(1)))); };
  break;
    

  case 41:
  if (yyn == 41)
    /* "parser.y":184  */ /* lalr1.java:489  */
    { yyval = ((RelationOperator)(yystack.valueAt (1-(1)))); };
  break;
    

  case 42:
  if (yyn == 42)
    /* "parser.y":185  */ /* lalr1.java:489  */
    { yyval = ((RelationOperator)(yystack.valueAt (1-(1)))); };
  break;
    

  case 43:
  if (yyn == 43)
    /* "parser.y":186  */ /* lalr1.java:489  */
    { yyval = ((RelationOperator)(yystack.valueAt (1-(1)))); };
  break;
    

  case 44:
  if (yyn == 44)
    /* "parser.y":187  */ /* lalr1.java:489  */
    { yyval = ((RelationOperator)(yystack.valueAt (1-(1)))); };
  break;
    

  case 45:
  if (yyn == 45)
    /* "parser.y":188  */ /* lalr1.java:489  */
    { yyval = ((RelationOperator)(yystack.valueAt (1-(1)))); };
  break;
    

  case 46:
  if (yyn == 46)
    /* "parser.y":192  */ /* lalr1.java:489  */
    { yyval = new Factor(((Term)(yystack.valueAt (1-(1))))); };
  break;
    

  case 47:
  if (yyn == 47)
    /* "parser.y":193  */ /* lalr1.java:489  */
    { ((Factor)yyval).add(((Term)(yystack.valueAt (3-(3)))), ((Token)(yystack.valueAt (3-(2))))); };
  break;
    

  case 48:
  if (yyn == 48)
    /* "parser.y":197  */ /* lalr1.java:489  */
    { yyval = ((FactorOperator)(yystack.valueAt (1-(1)))); };
  break;
    

  case 49:
  if (yyn == 49)
    /* "parser.y":198  */ /* lalr1.java:489  */
    { yyval = ((FactorOperator)(yystack.valueAt (1-(1)))); };
  break;
    

  case 50:
  if (yyn == 50)
    /* "parser.y":202  */ /* lalr1.java:489  */
    { yyval = new Term(((Unary)(yystack.valueAt (1-(1))))); };
  break;
    

  case 51:
  if (yyn == 51)
    /* "parser.y":203  */ /* lalr1.java:489  */
    { ((Term)yyval).add(((Unary)(yystack.valueAt (3-(3)))), ((Token)(yystack.valueAt (3-(2))))); };
  break;
    

  case 52:
  if (yyn == 52)
    /* "parser.y":207  */ /* lalr1.java:489  */
    { yyval = ((FactorOperator)(yystack.valueAt (1-(1)))); };
  break;
    

  case 53:
  if (yyn == 53)
    /* "parser.y":208  */ /* lalr1.java:489  */
    { yyval = ((FactorOperator)(yystack.valueAt (1-(1)))); };
  break;
    

  case 54:
  if (yyn == 54)
    /* "parser.y":212  */ /* lalr1.java:489  */
    { yyval = new Unary(((Reference)(yystack.valueAt (1-(1))))); };
  break;
    

  case 55:
  if (yyn == 55)
    /* "parser.y":213  */ /* lalr1.java:489  */
    { yyval = new Unary(((IsStatement)(yystack.valueAt (1-(1))))); };
  break;
    

  case 56:
  if (yyn == 56)
    /* "parser.y":214  */ /* lalr1.java:489  */
    { yyval = new Unary(((Primary)(yystack.valueAt (1-(1))))); };
  break;
    

  case 57:
  if (yyn == 57)
    /* "parser.y":215  */ /* lalr1.java:489  */
    { yyval = new Unary(((Primary)(yystack.valueAt (2-(2)))), ((Token)(yystack.valueAt (2-(1))))); };
  break;
    

  case 58:
  if (yyn == 58)
    /* "parser.y":219  */ /* lalr1.java:489  */
    { yyval = new IsStatement(((Reference)(yystack.valueAt (3-(1)))), ((Token)(yystack.valueAt (3-(3))))); };
  break;
    

  case 70:
  if (yyn == 70)
    /* "parser.y":241  */ /* lalr1.java:489  */
    { yyval = new Primary(((Literal)(yystack.valueAt (1-(1))))); };
  break;
    

  case 71:
  if (yyn == 71)
    /* "parser.y":242  */ /* lalr1.java:489  */
    { yyval = new Primary(((Token)(yystack.valueAt (1-(1))))); };
  break;
    

  case 72:
  if (yyn == 72)
    /* "parser.y":243  */ /* lalr1.java:489  */
    { yyval = new Primary(((Token)(yystack.valueAt (1-(1))))); };
  break;
    

  case 73:
  if (yyn == 73)
    /* "parser.y":244  */ /* lalr1.java:489  */
    { yyval = new Primary(((Token)(yystack.valueAt (1-(1))))); };
  break;
    

  case 74:
  if (yyn == 74)
    /* "parser.y":245  */ /* lalr1.java:489  */
    { yyval = new Primary(((Function)(yystack.valueAt (1-(1))))); };
  break;
    

  case 75:
  if (yyn == 75)
    /* "parser.y":246  */ /* lalr1.java:489  */
    { yyval = new Primary(((Expression)(yystack.valueAt (3-(2))))); };
  break;
    

  case 76:
  if (yyn == 76)
    /* "parser.y":251  */ /* lalr1.java:489  */
    {
            yyval = new Function(((ArrayList<Identifier>)(yystack.valueAt (5-(3)))), ((FunctionBody)(yystack.valueAt (5-(5)))));
        };
  break;
    

  case 77:
  if (yyn == 77)
    /* "parser.y":257  */ /* lalr1.java:489  */
    { yyval = new ArrayList<Identifier>(); };
  break;
    

  case 78:
  if (yyn == 78)
    /* "parser.y":258  */ /* lalr1.java:489  */
    { yyval = ((ArrayList<Identifier>)(yystack.valueAt (1-(1)))); };
  break;
    

  case 79:
  if (yyn == 79)
    /* "parser.y":263  */ /* lalr1.java:489  */
    {
            yyval = new ArrayList<Identifier>();
            ((ArrayList<Identifier>)yyval).add(((Identifier)(yystack.valueAt (1-(1)))));
        };
  break;
    

  case 80:
  if (yyn == 80)
    /* "parser.y":267  */ /* lalr1.java:489  */
    {
        ArrayList<Identifier> list = ((ArrayList<Identifier>)(yystack.valueAt (3-(3))));
        for (Identifier identifier: list){
            ((ArrayList<Identifier>)(yystack.valueAt (3-(1)))).add(identifier);
        }
    };
  break;
    

  case 81:
  if (yyn == 81)
    /* "parser.y":275  */ /* lalr1.java:489  */
    { yyval = new FunctionBody(((Body)(yystack.valueAt (3-(2))))); };
  break;
    

  case 82:
  if (yyn == 82)
    /* "parser.y":276  */ /* lalr1.java:489  */
    { yyval = new FunctionBody(((Expression)(yystack.valueAt (2-(2))))); };
  break;
    

  case 83:
  if (yyn == 83)
    /* "parser.y":280  */ /* lalr1.java:489  */
    { yyval = new Reference(((Token)(yystack.valueAt (1-(1))))); };
  break;
    

  case 84:
  if (yyn == 84)
    /* "parser.y":281  */ /* lalr1.java:489  */
    { yyval = new ArrayReference(((Reference)(yystack.valueAt (4-(1)))), ((Expression)(yystack.valueAt (4-(3))))); };
  break;
    

  case 85:
  if (yyn == 85)
    /* "parser.y":282  */ /* lalr1.java:489  */
    {yyval = new FunctionReference(((Reference)(yystack.valueAt (4-(1)))), ((Expression)(yystack.valueAt (4-(3))))); };
  break;
    

  case 86:
  if (yyn == 86)
    /* "parser.y":283  */ /* lalr1.java:489  */
    { yyval = new TupleReference(((Reference)(yystack.valueAt (3-(1)))), ((Token)(yystack.valueAt (3-(3))))); };
  break;
    

  case 87:
  if (yyn == 87)
    /* "parser.y":287  */ /* lalr1.java:489  */
    { yyval = new Literal(((Token)(yystack.valueAt (1-(1))))); };
  break;
    

  case 88:
  if (yyn == 88)
    /* "parser.y":288  */ /* lalr1.java:489  */
    { yyval = new Literal(((Token)(yystack.valueAt (1-(1))))); };
  break;
    

  case 89:
  if (yyn == 89)
    /* "parser.y":289  */ /* lalr1.java:489  */
    { yyval = new Literal(((Token)(yystack.valueAt (1-(1))))); };
  break;
    

  case 90:
  if (yyn == 90)
    /* "parser.y":290  */ /* lalr1.java:489  */
    { yyval = new Literal(((Token)(yystack.valueAt (1-(1))))); };
  break;
    

  case 91:
  if (yyn == 91)
    /* "parser.y":291  */ /* lalr1.java:489  */
    { yyval = new Literal(((Tuple)(yystack.valueAt (1-(1))))); };
  break;
    

  case 92:
  if (yyn == 92)
    /* "parser.y":292  */ /* lalr1.java:489  */
    { yyval = new Literal(((Array)(yystack.valueAt (1-(1))))); };
  break;
    

  case 93:
  if (yyn == 93)
    /* "parser.y":293  */ /* lalr1.java:489  */
    { yyval = new Literal(((Token)(yystack.valueAt (1-(1))))); };
  break;
    

  case 94:
  if (yyn == 94)
    /* "parser.y":297  */ /* lalr1.java:489  */
    { yyval = ((Boolean)(yystack.valueAt (1-(1)))); };
  break;
    

  case 95:
  if (yyn == 95)
    /* "parser.y":298  */ /* lalr1.java:489  */
    { yyval = ((Boolean)(yystack.valueAt (1-(1)))); };
  break;
    

  case 96:
  if (yyn == 96)
    /* "parser.y":302  */ /* lalr1.java:489  */
    { yyval = new Array(((List<Expression>)(yystack.valueAt (3-(2))))); };
  break;
    

  case 97:
  if (yyn == 97)
    /* "parser.y":307  */ /* lalr1.java:489  */
    { yyval = new Tuple(((List<TupleElement>)(yystack.valueAt (3-(2))))); };
  break;
    

  case 98:
  if (yyn == 98)
    /* "parser.y":312  */ /* lalr1.java:489  */
    {
            yyval = new ArrayList<TupleElement>();
            ((List<TupleElement>)yyval).add(((TupleElement)(yystack.valueAt (1-(1)))));
        };
  break;
    

  case 99:
  if (yyn == 99)
    /* "parser.y":316  */ /* lalr1.java:489  */
    { ((List<TupleElement>)(yystack.valueAt (3-(1)))).add(((TupleElement)(yystack.valueAt (3-(3))))); };
  break;
    

  case 100:
  if (yyn == 100)
    /* "parser.y":320  */ /* lalr1.java:489  */
    { yyval = new TupleElement(((Expression)(yystack.valueAt (1-(1))))); };
  break;
    

  case 101:
  if (yyn == 101)
    /* "parser.y":321  */ /* lalr1.java:489  */
    { yyval = new TupleElement(((Token)(yystack.valueAt (3-(1)))), ((Expression)(yystack.valueAt (3-(3))))); };
  break;
    


/* "YYParser.java":1060  */ /* lalr1.java:489  */
        default: break;
      }

    yy_symbol_print ("-> $$ =", yyr1_[yyn], yyval);

    yystack.pop (yylen);
    yylen = 0;

    /* Shift the result of the reduction.  */
    int yystate = yy_lr_goto_state_ (yystack.stateAt (0), yyr1_[yyn]);
    yystack.push (yystate, yyval);
    return YYNEWSTATE;
  }



  /*--------------------------------.
  | Print this symbol on YYOUTPUT.  |
  `--------------------------------*/

  private void yy_symbol_print (String s, int yytype,
                                 Object yyvaluep                                 )
  {
    if (yydebug > 0)
    yycdebug (s + (yytype < yyntokens_ ? " token " : " nterm ")
              + yytname_[yytype] + " ("
              + (yyvaluep == null ? "(null)" : yyvaluep.toString ()) + ")");
  }


  /**
   * Parse input from the scanner that was specified at object construction
   * time.  Return whether the end of the input was reached successfully.
   *
   * @return <tt>true</tt> if the parsing succeeds.  Note that this does not
   *          imply that there were no syntax errors.
   */
   public boolean parse () throws java.io.IOException

  {
    


    /* Lookahead and lookahead in internal form.  */
    int yychar = yyempty_;
    int yytoken = 0;

    /* State.  */
    int yyn = 0;
    int yylen = 0;
    int yystate = 0;
    YYStack yystack = new YYStack ();
    int label = YYNEWSTATE;

    /* Error handling.  */
    int yynerrs_ = 0;
    

    /* Semantic value of the lookahead.  */
    Object yylval = null;

    yycdebug ("Starting parse\n");
    yyerrstatus_ = 0;

    /* Initialize the stack.  */
    yystack.push (yystate, yylval );



    for (;;)
      switch (label)
      {
        /* New state.  Unlike in the C/C++ skeletons, the state is already
           pushed when we come here.  */
      case YYNEWSTATE:
        yycdebug ("Entering state " + yystate + "\n");
        if (yydebug > 0)
          yystack.print (yyDebugStream);

        /* Accept?  */
        if (yystate == yyfinal_)
          return true;

        /* Take a decision.  First try without lookahead.  */
        yyn = yypact_[yystate];
        if (yy_pact_value_is_default_ (yyn))
          {
            label = YYDEFAULT;
            break;
          }

        /* Read a lookahead token.  */
        if (yychar == yyempty_)
          {


            yycdebug ("Reading a token: ");
            yychar = yylexer.yylex ();
            yylval = yylexer.getLVal ();

          }

        /* Convert token to internal form.  */
        if (yychar <= Lexer.EOF)
          {
            yychar = yytoken = Lexer.EOF;
            yycdebug ("Now at end of input.\n");
          }
        else
          {
            yytoken = yytranslate_ (yychar);
            yy_symbol_print ("Next token is", yytoken,
                             yylval);
          }

        /* If the proper action on seeing token YYTOKEN is to reduce or to
           detect an error, take that action.  */
        yyn += yytoken;
        if (yyn < 0 || yylast_ < yyn || yycheck_[yyn] != yytoken)
          label = YYDEFAULT;

        /* <= 0 means reduce or error.  */
        else if ((yyn = yytable_[yyn]) <= 0)
          {
            if (yy_table_value_is_error_ (yyn))
              label = YYERRLAB;
            else
              {
                yyn = -yyn;
                label = YYREDUCE;
              }
          }

        else
          {
            /* Shift the lookahead token.  */
            yy_symbol_print ("Shifting", yytoken,
                             yylval);

            /* Discard the token being shifted.  */
            yychar = yyempty_;

            /* Count tokens shifted since error; after three, turn off error
               status.  */
            if (yyerrstatus_ > 0)
              --yyerrstatus_;

            yystate = yyn;
            yystack.push (yystate, yylval);
            label = YYNEWSTATE;
          }
        break;

      /*-----------------------------------------------------------.
      | yydefault -- do the default action for the current state.  |
      `-----------------------------------------------------------*/
      case YYDEFAULT:
        yyn = yydefact_[yystate];
        if (yyn == 0)
          label = YYERRLAB;
        else
          label = YYREDUCE;
        break;

      /*-----------------------------.
      | yyreduce -- Do a reduction.  |
      `-----------------------------*/
      case YYREDUCE:
        yylen = yyr2_[yyn];
        label = yyaction (yyn, yystack, yylen);
        yystate = yystack.stateAt (0);
        break;

      /*------------------------------------.
      | yyerrlab -- here on detecting error |
      `------------------------------------*/
      case YYERRLAB:
        /* If not already recovering from an error, report this error.  */
        if (yyerrstatus_ == 0)
          {
            ++yynerrs_;
            if (yychar == yyempty_)
              yytoken = yyempty_;
            yyerror (yysyntax_error (yystate, yytoken));
          }

        
        if (yyerrstatus_ == 3)
          {
        /* If just tried and failed to reuse lookahead token after an
         error, discard it.  */

        if (yychar <= Lexer.EOF)
          {
          /* Return failure if at end of input.  */
          if (yychar == Lexer.EOF)
            return false;
          }
        else
            yychar = yyempty_;
          }

        /* Else will try to reuse lookahead token after shifting the error
           token.  */
        label = YYERRLAB1;
        break;

      /*-------------------------------------------------.
      | errorlab -- error raised explicitly by YYERROR.  |
      `-------------------------------------------------*/
      case YYERROR:

        
        /* Do not reclaim the symbols of the rule which action triggered
           this YYERROR.  */
        yystack.pop (yylen);
        yylen = 0;
        yystate = yystack.stateAt (0);
        label = YYERRLAB1;
        break;

      /*-------------------------------------------------------------.
      | yyerrlab1 -- common code for both syntax error and YYERROR.  |
      `-------------------------------------------------------------*/
      case YYERRLAB1:
        yyerrstatus_ = 3;       /* Each real token shifted decrements this.  */

        for (;;)
          {
            yyn = yypact_[yystate];
            if (!yy_pact_value_is_default_ (yyn))
              {
                yyn += yyterror_;
                if (0 <= yyn && yyn <= yylast_ && yycheck_[yyn] == yyterror_)
                  {
                    yyn = yytable_[yyn];
                    if (0 < yyn)
                      break;
                  }
              }

            /* Pop the current state because it cannot handle the
             * error token.  */
            if (yystack.height == 0)
              return false;

            
            yystack.pop ();
            yystate = yystack.stateAt (0);
            if (yydebug > 0)
              yystack.print (yyDebugStream);
          }

        if (label == YYABORT)
            /* Leave the switch.  */
            break;



        /* Shift the error token.  */
        yy_symbol_print ("Shifting", yystos_[yyn],
                         yylval);

        yystate = yyn;
        yystack.push (yyn, yylval);
        label = YYNEWSTATE;
        break;

        /* Accept.  */
      case YYACCEPT:
        return true;

        /* Abort.  */
      case YYABORT:
        return false;
      }
}




  // Generate an error message.
  private String yysyntax_error (int yystate, int tok)
  {
    return "syntax error";
  }

  /**
   * Whether the given <code>yypact_</code> value indicates a defaulted state.
   * @param yyvalue   the value to check
   */
  private static boolean yy_pact_value_is_default_ (int yyvalue)
  {
    return yyvalue == yypact_ninf_;
  }

  /**
   * Whether the given <code>yytable_</code>
   * value indicates a syntax error.
   * @param yyvalue the value to check
   */
  private static boolean yy_table_value_is_error_ (int yyvalue)
  {
    return yyvalue == yytable_ninf_;
  }

  private static final byte yypact_ninf_ = -90;
  private static final short yytable_ninf_ = -1;

  /* YYPACT[STATE-NUM] -- Index in YYTABLE of the portion describing
   STATE-NUM.  */
  private static final byte yypact_[] = yypact_init();
  private static final byte[] yypact_init()
  {
    return new byte[]
    {
      72,   -90,    67,    67,    67,    67,     5,    10,    44,    42,
     -90,   -90,   -90,   -90,   -90,   -90,   -90,    99,   -90,   -90,
     -90,   -90,    11,   -90,   -90,   -90,   -90,   -90,   -90,   -90,
     -90,    67,   120,    67,    37,    60,    64,   -21,   -15,   -90,
     -90,    -3,   -90,   -90,    76,   -90,   -90,   -90,   -90,    60,
      82,    25,    74,    70,    53,   -90,   -90,    72,    67,    67,
      67,   115,   117,     4,    78,    60,    85,   -90,    13,    67,
     -90,   -90,   -90,    67,   -90,   -90,   -90,   -90,   -90,   -90,
      67,   -90,   -90,    67,   -90,   -90,    67,   -90,     6,    72,
      72,    67,    67,   -90,    10,   -90,    60,    19,    12,   -90,
     -90,    73,    75,   -90,    67,   -90,   120,   -90,    60,    64,
     -21,   -15,   -90,   -90,   -90,   -90,   -90,   -90,   -90,    79,
      87,   -90,    42,    15,   102,   113,    22,    60,   -90,   -90,
     -90,    29,   117,    60,   -90,   -90,   -90,    72,   -90,   -90,
     -90,    72,    67,    72,    67,   -90,    75,   119,   121,    60,
     122,    60,   -90,   -90,   -90
    };
  }

/* YYDEFACT[STATE-NUM] -- Default reduction number in state STATE-NUM.
   Performed when YYTABLE does not specify something else to do.  Zero
   means the default is an error.  */
  private static final byte yydefact_[] = yydefact_init();
  private static final byte[] yydefact_init()
  {
    return new byte[]
    {
       3,    83,    29,    27,     0,     0,     0,     0,     0,     2,
       4,     7,     8,     9,    10,    11,    12,     0,    87,    88,
      89,    93,     0,    94,    95,    61,    71,    72,    73,    59,
      60,     0,     0,     0,    30,    31,    33,    38,    46,    50,
      55,     0,    56,    74,    54,    70,    90,    92,    91,    28,
       0,     0,     0,    16,    13,    14,     1,     5,     0,     0,
       0,     0,    77,     0,    83,   100,     0,    98,     0,     0,
      35,    36,    37,     0,    40,    41,    42,    43,    44,    45,
       0,    48,    49,     0,    52,    53,     0,    57,     0,     3,
       3,     0,     0,    17,     0,     6,    19,     0,     0,    86,
      79,     0,    78,    75,     0,    97,     0,    96,    32,    34,
      39,    47,    51,    62,    63,    64,    65,    66,    69,     0,
       0,    58,    26,     0,     0,     0,     0,    18,    15,    85,
      84,     0,     0,   101,    99,    68,    67,     3,    21,    20,
      23,     3,     0,     3,     0,    76,    80,     0,     0,    25,
       0,    82,    22,    24,    81
    };
  }

/* YYPGOTO[NTERM-NUM].  */
  private static final short yypgoto_[] = yypgoto_init();
  private static final short[] yypgoto_init()
  {
    return new short[]
    {
     -90,   -90,   153,   103,   -90,   -90,    62,   -90,   -90,   -90,
     -90,   -90,   -90,   -89,   -90,   -90,   126,     2,   -90,    88,
     -90,    83,   -90,    84,   -90,    80,   -90,   -90,   -90,   128,
     -90,   -90,    30,   -90,     0,   -90,   -90,   -90,   -90,   -90,
      65
    };
  }

/* YYDEFGOTO[NTERM-NUM].  */
  private static final short yydefgoto_[] = yydefgoto_init();
  private static final short[] yydefgoto_init()
  {
    return new short[]
    {
      -1,     8,   122,    10,    11,    54,    55,    93,    12,    13,
     139,    14,   125,   123,    15,    16,    34,    35,    73,    36,
      80,    37,    83,    38,    86,    39,    40,    41,   121,    42,
      43,   101,   102,   145,    44,    45,    46,    47,    48,    66,
      67
    };
  }

/* YYTABLE[YYPACT[STATE-NUM]] -- What to do in state STATE-NUM.  If
   positive, shift that token.  If negative, reduce the rule whose
   number is the opposite.  If YYTABLE_NINF, syntax error.  */
  private static final short yytable_[] = yytable_init();
  private static final short[] yytable_init()
  {
    return new short[]
    {
      17,   124,    18,    19,    20,    49,    50,    51,    52,    21,
      22,    23,    24,    53,   113,   114,   115,   116,   117,   118,
      70,    71,    72,    81,    82,    26,    27,    28,    70,    71,
      72,    84,    85,    63,    65,    70,    71,    72,    70,    71,
      72,    70,    71,    72,    56,    31,    57,    32,   147,    33,
     137,   138,   148,   103,   150,   143,   119,    17,   120,    62,
      96,    97,    98,   142,    90,   130,   107,    69,   129,   144,
       1,   108,    18,    19,    20,     1,    70,    71,    72,    21,
      22,    23,    24,    74,    75,    76,    77,    78,    79,    17,
      17,    69,    25,   126,   127,    26,    27,    28,    70,    71,
      72,    91,    88,     2,     3,     4,   133,    94,    65,     5,
       6,    29,    30,    92,     7,    31,    89,    32,    99,    33,
     100,   104,   131,    64,    59,    18,    19,    20,    60,   132,
     135,    61,    21,    22,    23,    24,   105,    17,   140,   106,
     136,    17,    58,    17,   149,    25,   151,    59,    26,    27,
      28,    60,   141,     9,    61,   152,   128,   153,   154,    68,
      95,   109,   146,   110,    29,    30,   112,   111,    31,    87,
      32,   134,    33
    };
  }

private static final short yycheck_[] = yycheck_init();
  private static final short[] yycheck_init()
  {
    return new short[]
    {
       0,    90,     5,     6,     7,     3,     4,     5,     3,    12,
      13,    14,    15,     3,     8,     9,    10,    11,    12,    13,
      16,    17,    18,    44,    45,    28,    29,    30,    16,    17,
      18,    46,    47,    31,    32,    16,    17,    18,    16,    17,
      18,    16,    17,    18,     0,    48,     4,    50,   137,    52,
      35,    36,   141,    49,   143,    26,    50,    57,    52,    48,
      58,    59,    60,    41,    39,    53,    53,    54,    49,    40,
       3,    69,     5,     6,     7,     3,    16,    17,    18,    12,
      13,    14,    15,    19,    20,    21,    22,    23,    24,    89,
      90,    54,    25,    91,    92,    28,    29,    30,    16,    17,
      18,    27,    26,    31,    32,    33,   104,    54,   106,    37,
      38,    44,    45,    43,    42,    48,    34,    50,     3,    52,
       3,    43,    49,     3,    48,     5,     6,     7,    52,    54,
      51,    55,    12,    13,    14,    15,    51,   137,    36,    54,
      53,   141,    43,   143,   142,    25,   144,    48,    28,    29,
      30,    52,    39,     0,    55,    36,    94,    36,    36,    33,
      57,    73,   132,    80,    44,    45,    86,    83,    48,    41,
      50,   106,    52
    };
  }

/* YYSTOS[STATE-NUM] -- The (internal number of the) accessing
   symbol of state STATE-NUM.  */
  private static final byte yystos_[] = yystos_init();
  private static final byte[] yystos_init()
  {
    return new byte[]
    {
       0,     3,    31,    32,    33,    37,    38,    42,    57,    58,
      59,    60,    64,    65,    67,    70,    71,    90,     5,     6,
       7,    12,    13,    14,    15,    25,    28,    29,    30,    44,
      45,    48,    50,    52,    72,    73,    75,    77,    79,    81,
      82,    83,    85,    86,    90,    91,    92,    93,    94,    73,
      73,    73,     3,     3,    61,    62,     0,     4,    43,    48,
      52,    55,    48,    73,     3,    73,    95,    96,    72,    54,
      16,    17,    18,    74,    19,    20,    21,    22,    23,    24,
      76,    44,    45,    78,    46,    47,    80,    85,    26,    34,
      39,    27,    43,    63,    54,    59,    73,    73,    73,     3,
       3,    87,    88,    49,    43,    51,    54,    53,    73,    75,
      77,    79,    81,     8,     9,    10,    11,    12,    13,    50,
      52,    84,    58,    69,    69,    68,    73,    73,    62,    49,
      53,    49,    54,    73,    96,    51,    53,    35,    36,    66,
      36,    39,    41,    26,    40,    89,    88,    69,    69,    73,
      69,    73,    36,    36,    36
    };
  }

/* YYR1[YYN] -- Symbol number of symbol that rule YYN derives.  */
  private static final byte yyr1_[] = yyr1_init();
  private static final byte[] yyr1_init()
  {
    return new byte[]
    {
       0,    56,    57,    58,    58,    58,    58,    59,    59,    59,
      59,    59,    59,    60,    61,    61,    62,    62,    63,    64,
      65,    66,    66,    67,    67,    68,    69,    70,    70,    71,
      71,    72,    72,    73,    73,    74,    74,    74,    75,    75,
      76,    76,    76,    76,    76,    76,    77,    77,    78,    78,
      79,    79,    80,    80,    81,    81,    81,    81,    82,    83,
      83,    83,    84,    84,    84,    84,    84,    84,    84,    84,
      85,    85,    85,    85,    85,    85,    86,    87,    87,    88,
      88,    89,    89,    90,    90,    90,    90,    91,    91,    91,
      91,    91,    91,    91,    92,    92,    93,    94,    95,    95,
      96,    96
    };
  }

/* YYR2[YYN] -- Number of symbols on the right hand side of rule YYN.  */
  private static final byte yyr2_[] = yyr2_init();
  private static final byte[] yyr2_init()
  {
    return new byte[]
    {
       0,     2,     1,     0,     1,     2,     3,     1,     1,     1,
       1,     1,     1,     2,     1,     3,     1,     2,     2,     3,
       5,     1,     3,     5,     7,     3,     1,     1,     2,     1,
       2,     1,     3,     1,     3,     1,     1,     1,     1,     3,
       1,     1,     1,     1,     1,     1,     1,     3,     1,     1,
       1,     3,     1,     1,     1,     1,     1,     2,     3,     1,
       1,     1,     1,     1,     1,     1,     1,     2,     2,     1,
       1,     1,     1,     1,     1,     3,     5,     0,     1,     1,
       3,     3,     2,     1,     4,     4,     3,     1,     1,     1,
       1,     1,     1,     1,     1,     1,     3,     3,     1,     3,
       1,     3
    };
  }

  /* YYTOKEN_NUMBER[YYLEX-NUM] -- Internal symbol number corresponding
      to YYLEX-NUM.  */
  private static final short yytoken_number_[] = yytoken_number_init();
  private static final short[] yytoken_number_init()
  {
    return new short[]
    {
       0,   256,   257,   258,   259,   260,   261,   262,   263,   264,
     265,   266,   267,   268,   269,   270,   271,   272,   273,   274,
     275,   276,   277,   278,   279,   280,   281,   282,   283,   284,
     285,   286,   287,   288,   289,   290,   291,   292,   293,   294,
     295,   296,   297,   298,   299,   300,   301,   302,   303,   304,
     305,   306,   307,   308,   309,   310
    };
  }

  /* YYTNAME[SYMBOL-NUM] -- String name of the symbol SYMBOL-NUM.
     First, the terminals, then, starting at \a yyntokens_, nonterminals.  */
  private static final String yytname_[] = yytname_init();
  private static final String[] yytname_init()
  {
    return new String[]
    {
  "$end", "error", "$undefined", "IDENTIFIER", "SEPARATOR", "INT_LITERAL",
  "REAL_LITERAL", "STR_LITERAL", "INT_TYPE", "REAL_TYPE", "BOOL_TYPE",
  "STR_TYPE", "EMPTY_TYPE", "FUNC_TYPE", "TRUE", "FALSE", "OR", "AND",
  "XOR", "LT", "LE", "GT", "GE", "EQ", "NE", "NOT", "IS", "IN", "READ_INT",
  "READ_REAL", "READ_STR", "PRINT", "RETURN", "IF", "THEN", "ELSE", "END",
  "WHILE", "FOR", "LOOP", "LAMBDA", "TWO_DOTS", "VAR", "ASSIGN", "PLUS",
  "MINUS", "MULT", "DIV", "LPAREN", "RPAREN", "LBRACE", "RBRACE",
  "LBRACKET", "RBRACKET", "COMMA", "DOT", "$accept", "Program",
  "Statements", "Statement", "Declaration", "VariableDefinitions",
  "VariableDefinition", "VariableDefinitionTail", "Assignment", "If",
  "IfTail", "Loop", "Range", "Body", "Return", "Print", "Expressions",
  "Expression", "ExpressionOperator", "Relation", "RelationOperator",
  "Factor", "FactorOperator", "Term", "TermOperator", "Unary", "Is",
  "UnaryOperator", "TypeIndicator", "Primary", "FunctionLiteral",
  "Parameters", "Identifiers", "FunBody", "Reference", "Literal",
  "Boolean", "Array", "Tuple", "TupleElements", "TupleElement", null
    };
  }

  /* YYRLINE[YYN] -- Source line where rule number YYN was defined.  */
  private static final short yyrline_[] = yyrline_init();
  private static final short[] yyrline_init()
  {
    return new short[]
    {
       0,    69,    69,    74,    75,    80,    81,    85,    86,    87,
      88,    89,    90,    94,    98,    99,   103,   104,   108,   112,
     116,   127,   128,   132,   133,   140,   144,   148,   149,   153,
     154,   158,   163,   167,   168,   172,   173,   174,   178,   179,
     183,   184,   185,   186,   187,   188,   192,   193,   197,   198,
     202,   203,   207,   208,   212,   213,   214,   215,   219,   224,
     225,   226,   230,   231,   232,   233,   234,   235,   236,   237,
     241,   242,   243,   244,   245,   246,   250,   257,   258,   262,
     267,   275,   276,   280,   281,   282,   283,   287,   288,   289,
     290,   291,   292,   293,   297,   298,   302,   307,   311,   316,
     320,   321
    };
  }


  // Report on the debug stream that the rule yyrule is going to be reduced.
  private void yy_reduce_print (int yyrule, YYStack yystack)
  {
    if (yydebug == 0)
      return;

    int yylno = yyrline_[yyrule];
    int yynrhs = yyr2_[yyrule];
    /* Print the symbols being reduced, and their result.  */
    yycdebug ("Reducing stack by rule " + (yyrule - 1)
              + " (line " + yylno + "), ");

    /* The symbols being reduced.  */
    for (int yyi = 0; yyi < yynrhs; yyi++)
      yy_symbol_print ("   $" + (yyi + 1) + " =",
                       yystos_[yystack.stateAt(yynrhs - (yyi + 1))],
                       ((yystack.valueAt (yynrhs-(yyi + 1)))));
  }

  /* YYTRANSLATE(YYLEX) -- Bison symbol number corresponding to YYLEX.  */
  private static final byte yytranslate_table_[] = yytranslate_table_init();
  private static final byte[] yytranslate_table_init()
  {
    return new byte[]
    {
       0,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     1,     2,     3,     4,
       5,     6,     7,     8,     9,    10,    11,    12,    13,    14,
      15,    16,    17,    18,    19,    20,    21,    22,    23,    24,
      25,    26,    27,    28,    29,    30,    31,    32,    33,    34,
      35,    36,    37,    38,    39,    40,    41,    42,    43,    44,
      45,    46,    47,    48,    49,    50,    51,    52,    53,    54,
      55
    };
  }

  private static final byte yytranslate_ (int t)
  {
    if (t >= 0 && t <= yyuser_token_number_max_)
      return yytranslate_table_[t];
    else
      return yyundef_token_;
  }

  private static final int yylast_ = 172;
  private static final int yynnts_ = 41;
  private static final int yyempty_ = -2;
  private static final int yyfinal_ = 56;
  private static final int yyterror_ = 1;
  private static final int yyerrcode_ = 256;
  private static final int yyntokens_ = 56;

  private static final int yyuser_token_number_max_ = 310;
  private static final int yyundef_token_ = 2;

/* User implementation code.  */

}

