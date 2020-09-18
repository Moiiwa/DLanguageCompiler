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
    static final int RANGE = 296;
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
        
/* "YYParser.java":410  */ /* lalr1.java:489  */
        default: break;
      }

    yy_symbol_print ("-> $$ =", yyr1_[yyn], yyval);
    yystack.pop (yylen);

    yylen = 0;

    /* Shift the result of the reduction.  */
    int yystate = yy_lr_goto_state_ (yystack.stateAt (0), yyr1_[yyn]);
    yystack.push (yystate, yyval);
    System.out.println(yystack.valueAt(yystack.height));
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
            System.out.println(yylval);
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
        System.out.println(yylval);
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

  private static final short yypact_ninf_ = -84;
  private static final short yytable_ninf_ = -8;

  /* YYPACT[STATE-NUM] -- Index in YYTABLE of the portion describing
   STATE-NUM.  */
  private static final short yypact_[] = yypact_init();
  private static final short[] yypact_init()
  {
    return new short[]
    {
      74,   -84,    19,    19,    19,    19,    14,    18,    23,   -84,
      39,   -84,   -84,   -84,   -84,   -84,   -84,   -84,   120,   -84,
     -84,   -84,   -84,     6,   -84,   -84,   -84,   -84,   -84,   -84,
     -84,   -84,    19,    69,    19,    -8,   110,   157,   -17,   -11,
     -84,   117,   -84,   -84,    35,   -84,   -84,   -84,   -84,   110,
     124,    -2,    32,    25,     8,   -84,   -84,   122,    19,    19,
      19,    67,    83,     2,    48,   110,    -9,   -84,    26,    19,
     -84,   -84,   -84,    19,   -84,   -84,   -84,   -84,   -84,   -84,
      19,   -84,   -84,    19,   -84,   -84,    19,   -84,     0,    74,
      74,    19,    19,   -84,    18,   -84,   110,    22,   -12,   -84,
     -84,    51,    50,   -84,    19,   -84,    69,   -84,   110,   157,
     -17,   -11,   -84,   -84,   -84,   -84,   -84,   -84,   -84,    64,
      49,   -84,   -84,    60,    82,    92,   110,   -84,   -84,   -84,
      94,    83,   110,   -84,   -84,   -84,    74,   -84,   -84,   -84,
      19,    74,   -84,    50,   102,   118,   107,   -84,   122,   108,
     114,   148,    19,   -84,   -84,   110
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
       3,    83,    31,    29,     0,     0,     0,     0,     0,     2,
       4,     5,     8,     9,    10,    11,    12,    13,     0,    87,
      88,    89,    93,     0,    94,    95,    62,    72,    73,    74,
      60,    61,     0,     0,     0,    32,    33,    35,    40,    48,
      52,     0,    59,    75,    56,    71,    90,    92,    91,    30,
       0,     0,     0,    17,    14,    15,     1,     7,     0,     0,
       0,     0,    78,     0,    83,   100,     0,    98,     0,     0,
      37,    38,    39,     0,    42,    43,    44,    45,    46,    47,
       0,    50,    51,     0,    54,    55,     0,    58,     0,     3,
       3,     0,     0,    18,     0,     6,    20,     0,     0,    86,
      80,     0,    79,    76,     0,    97,     0,    96,    34,    36,
      41,    49,    53,    63,    64,    65,    66,    67,    70,     0,
       0,    57,    28,     0,     0,     0,    19,    16,    85,    84,
       0,     0,   101,    99,    69,    68,     3,    22,    21,    24,
       0,     3,    77,    81,     0,     0,     0,    23,     3,     0,
       0,    26,     0,    25,    27,    82
    };
  }

/* YYPGOTO[NTERM-NUM].  */
  private static final short yypgoto_[] = yypgoto_init();
  private static final short[] yypgoto_init()
  {
    return new short[]
    {
     -84,   -84,   156,   -84,   104,   -84,   -84,    68,   -84,   -84,
     -84,   -84,   -84,   -84,   -83,   -84,   -84,   132,    -3,   -84,
      95,   -84,    91,   -84,    90,   -84,    88,   -84,   -84,   141,
     -84,   -84,    52,   -84,     3,   -84,   -84,   -84,   -84,   -84,
      78
    };
  }

/* YYDEFGOTO[NTERM-NUM].  */
  private static final short yydefgoto_[] = yydefgoto_init();
  private static final short[] yydefgoto_init()
  {
    return new short[]
    {
      -1,     8,   122,    10,    11,    12,    54,    55,    93,    13,
      14,   138,    15,   150,   123,    16,    17,    35,    36,    73,
      37,    80,    38,    83,    39,    86,    40,    41,   121,    42,
      43,   101,   102,   142,    44,    45,    46,    47,    48,    66,
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
      49,    50,    51,    18,    70,    71,    72,   124,   113,   114,
     115,   116,   117,   118,    70,    71,    72,    52,    70,    71,
      72,    53,     1,    56,    19,    20,    21,    81,    82,    63,
      65,    22,    23,    24,    25,    84,    85,    90,    70,    71,
      72,   129,   105,    57,    26,   106,    69,    27,    28,    29,
     119,   103,   120,   144,    62,    96,    97,    98,   146,    91,
      18,    88,    94,    30,    31,   151,   108,    32,    92,    33,
      99,    34,    64,   128,    19,    20,    21,     1,    -7,   107,
      69,    22,    23,    24,    25,    59,   100,    60,   125,   126,
      61,   104,    18,    18,    26,   136,   137,    27,    28,    29,
     130,   132,   135,    65,   131,     2,     3,     4,    70,    71,
      72,     5,     6,    30,    31,   134,     7,    32,   139,    33,
     141,    34,    19,    20,    21,     1,    70,    71,    72,    22,
      23,    24,    25,   140,    70,    71,    72,   145,   147,    18,
      70,    71,    72,   149,    18,    27,    28,    29,   152,   155,
     153,    18,   154,     2,     3,     4,     9,   148,    89,     5,
       6,    95,   127,    58,     7,    32,    68,    33,   109,    34,
      59,   110,    60,   111,   112,    61,    74,    75,    76,    77,
      78,    79,    87,   143,   133
    };
  }

private static final short yycheck_[] = yycheck_init();
  private static final short[] yycheck_init()
  {
    return new short[]
    {
       3,     4,     5,     0,    16,    17,    18,    90,     8,     9,
      10,    11,    12,    13,    16,    17,    18,     3,    16,    17,
      18,     3,     3,     0,     5,     6,     7,    44,    45,    32,
      33,    12,    13,    14,    15,    46,    47,    39,    16,    17,
      18,    53,    51,     4,    25,    54,    54,    28,    29,    30,
      50,    49,    52,   136,    48,    58,    59,    60,   141,    27,
      57,    26,    54,    44,    45,   148,    69,    48,    43,    50,
       3,    52,     3,    51,     5,     6,     7,     3,     4,    53,
      54,    12,    13,    14,    15,    50,     3,    52,    91,    92,
      55,    43,    89,    90,    25,    35,    36,    28,    29,    30,
      49,   104,    53,   106,    54,    31,    32,    33,    16,    17,
      18,    37,    38,    44,    45,    51,    42,    48,    36,    50,
      26,    52,     5,     6,     7,     3,    16,    17,    18,    12,
      13,    14,    15,    41,    16,    17,    18,   140,    36,   136,
      16,    17,    18,    36,   141,    28,    29,    30,    40,   152,
      36,   148,     4,    31,    32,    33,     0,    39,    34,    37,
      38,    57,    94,    43,    42,    48,    34,    50,    73,    52,
      50,    80,    52,    83,    86,    55,    19,    20,    21,    22,
      23,    24,    41,   131,   106
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
      59,    60,    61,    65,    66,    68,    71,    72,    90,     5,
       6,     7,    12,    13,    14,    15,    25,    28,    29,    30,
      44,    45,    48,    50,    52,    73,    74,    76,    78,    80,
      82,    83,    85,    86,    90,    91,    92,    93,    94,    74,
      74,    74,     3,     3,    62,    63,     0,     4,    43,    50,
      52,    55,    48,    74,     3,    74,    95,    96,    73,    54,
      16,    17,    18,    75,    19,    20,    21,    22,    23,    24,
      77,    44,    45,    79,    46,    47,    81,    85,    26,    34,
      39,    27,    43,    64,    54,    60,    74,    74,    74,     3,
       3,    87,    88,    49,    43,    51,    54,    53,    74,    76,
      78,    80,    82,     8,     9,    10,    11,    12,    13,    50,
      52,    84,    58,    70,    70,    74,    74,    63,    51,    53,
      49,    54,    74,    96,    51,    53,    35,    36,    67,    36,
      41,    26,    89,    88,    70,    74,    70,    36,    39,    36,
      69,    70,    40,    36,     4,    74
    };
  }

/* YYR1[YYN] -- Symbol number of symbol that rule YYN derives.  */
  private static final byte yyr1_[] = yyr1_init();
  private static final byte[] yyr1_init()
  {
    return new byte[]
    {
       0,    56,    57,    58,    58,    59,    59,    60,    60,    60,
      60,    60,    60,    60,    61,    62,    62,    63,    63,    64,
      65,    66,    67,    67,    68,    68,    69,    69,    70,    71,
      71,    72,    72,    73,    73,    74,    74,    75,    75,    75,
      76,    76,    77,    77,    77,    77,    77,    77,    78,    78,
      79,    79,    80,    80,    81,    81,    82,    82,    82,    82,
      83,    83,    83,    84,    84,    84,    84,    84,    84,    84,
      84,    85,    85,    85,    85,    85,    85,    86,    87,    87,
      88,    88,    89,    90,    90,    90,    90,    91,    91,    91,
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
       0,     2,     1,     0,     1,     1,     3,     0,     1,     1,
       1,     1,     1,     1,     2,     1,     3,     1,     2,     2,
       3,     5,     1,     3,     5,     9,     1,     2,     1,     1,
       2,     1,     2,     1,     3,     1,     3,     1,     1,     1,
       1,     3,     1,     1,     1,     1,     1,     1,     1,     3,
       1,     1,     1,     3,     1,     1,     1,     3,     2,     1,
       1,     1,     1,     1,     1,     1,     1,     1,     2,     2,
       1,     1,     1,     1,     1,     1,     3,     5,     0,     1,
       1,     3,     5,     1,     4,     4,     3,     1,     1,     1,
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
  "WHILE", "FOR", "LOOP", "LAMBDA", "RANGE", "VAR", "ASSIGN", "PLUS",
  "MINUS", "MULT", "DIV", "LPAREN", "RPAREN", "LBRACE", "RBRACE",
  "LBRACKET", "RBRACKET", "COMMA", "DOT", "$accept", "Program",
  "Statements", "StatementList", "Statement", "Declaration",
  "VariableDefinitions", "VariableDefinition", "VariableDefinitionTail",
  "Assignment", "If", "IfTail", "Loop", "LoopBody", "Body", "Return",
  "Print", "Expressions", "Expression", "ExpressionOperator", "Relation",
  "RelationOperator", "Factor", "FactorOperator", "Term", "TermOperator",
  "Unary", "UnaryOperator", "TypeIndicator", "Primary", "FunctionLiteral",
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
       0,    18,    18,    21,    23,    27,    28,    31,    33,    34,
      35,    36,    37,    38,    42,    46,    47,    51,    52,    56,
      60,    64,    68,    69,    73,    74,    78,    79,    83,    87,
      88,    92,    93,    97,    98,   102,   103,   107,   108,   109,
     113,   114,   118,   119,   120,   121,   122,   123,   127,   128,
     132,   133,   137,   138,   142,   143,   147,   148,   149,   150,
     154,   155,   156,   160,   161,   162,   163,   164,   165,   166,
     167,   171,   172,   173,   174,   175,   176,   180,   183,   185,
     189,   190,   193,   197,   198,   199,   200,   204,   205,   206,
     207,   208,   209,   210,   214,   215,   219,   224,   228,   229,
     233,   234
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

  private static final int yylast_ = 184;
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

