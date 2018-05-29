grammar Fool;

@lexer::members {
   //there is a much better way to do this, check the ANTLR guide
   //I will leave it like this for now just becasue it is quick
   //but it doesn't work well
   public int lexicalErrors=0;
}

/*------------------------------------------------------------------
 * PARSER RULES
 *------------------------------------------------------------------*/
  
prog   : exp SEMIC                 #singleExp
       | let exp SEMIC             #letInExp
       ;

let    : LET (dec SEMIC)+ IN ;

vardec : type ID ;

varasm : vardec ASM exp 
       | ID ASM exp
       | ID DOT ID ASM exp
       ;

fun    : type ID LPAR ( elem+=vardec ( COMMA elem+=vardec)* )? RPAR (let)? exp ;

dec    : varasm           #varAssignment
       | fun              #funDeclaration
       | CLASS ID (EXTS ID)? LPAR ( elem+=vardec (COMMA elem+=vardec)* )? RPAR CLPAR (fun SEMIC)* CRPAR #classDeclaration
       ;
         
   
type   : INT  
       | BOOL 
       | ID
       ;  
    
exp    : LPAR exp RPAR #bracketedExp
  	   | left=term (PLUS right=exp)? #intExp
	   | left=term (MINUS right=exp)? #intExp
	   | left=term (AND right=value)? #boolExp
	   | left=term (OR right=value)? #boolExp
  	   | NOT left=term #boolExp 
	   | left=value EQ right=value #CompExp
	   | left=value GT right=value #CompExp
	   | left=value LT right=value #CompExp
	   | left=value GTEQ right=value #CompExp
	   | left=value LTEQ right=value #CompExp
     | ID LPAR ( elem+=stm (COMMA elem+=stm)* )? RPAR #functionCall
	   | ID DOT ID LPAR ( elem+=exp (COMMA elem+=exp)* )? RPAR #methodCall
	   | ID DOT ID #fieldReference
	   | NEW ID LPAR ( elem+=stm (COMMA elem+=stm)* )? RPAR #classInstantiation
	   | NULL #nullValue
     | stms #statement
	   ;
   
term   : left=factor (TIMES right=term)? #intTerm
       | left=factor (FRACT right=term)? #intTerm
       ;

stms   : ( stm )+;

stm    : varasm 
	   | IF exp THEN CLPAR stms CRPAR ELSE CLPAR stms CRPAR
     | value
	   ;

factor : left=value (EQ right=value)?
       ;     
   
value  : INTEGER                           #intVal
       | ( TRUE | FALSE )                   #boolVal
       | LPAR exp RPAR                      #baseExp
       | IF cond=exp THEN CLPAR thenBranch=exp CRPAR ELSE CLPAR elseBranch=exp CRPAR  #ifExp
       | ID                                             #varExp
       | ID ( LPAR (exp (COMMA exp)* )? RPAR )?         #funExp
       ; 

   
/*------------------------------------------------------------------
 * LEXER RULES
 *------------------------------------------------------------------*/
SEMIC  : ';' ;
COLON  : ':' ;
COMMA  : ',' ;
DOT : '.';
EQ     : '==' ;
ASM    : '=' ;
LT     : '<' ;
GT     : '>';
LTEQ   : '<=' ;
GTEQ   : '>=' ;
PLUS   : '+' ;
MINUS	: '-';
TIMES  : '*' ;
FRACT  : '/' ;
TRUE   : 'true' ;
FALSE  : 'false' ;
LPAR   : '(' ;
RPAR   : ')' ;
CLPAR  : '{' ;
CRPAR  : '}' ;
IF        : 'if' ;
THEN   : 'then' ;
ELSE   : 'else' ;
AND    : '&&' ;
OR     : '||' ;
NOT    : 'not' ;
PRINT    : 'print' ; 
LET       : 'let' ;
IN    : 'in' ;
VAR       : 'var' ;
FUN       : 'fun' ;
INT       : 'int' ;
BOOL   : 'bool' ;
CLASS : 'class' ;
EXTS : 'extends' ;
NEW : 'new';
NULL : 'null';

//Numbers
fragment DIGIT : '0'..'9';    
INTEGER       : ('-')?DIGIT+ ;

//IDs
fragment CHAR  : 'a'..'z' |'A'..'Z' ;
ID              : CHAR (CHAR | DIGIT)* ;

//ESCAPED SEQUENCES
WS              : (' '|'\t'|'\n'|'\r')-> skip;
LINECOMENTS    : '//' (~('\n'|'\r'))* -> skip;
BLOCKCOMENTS    : '/*'( ~('/'|'*')|'/'~'*'|'*'~'/'|BLOCKCOMENTS)* '*/' -> skip;

 //VERY SIMPLISTIC ERROR CHECK FOR THE LEXING PROCESS, THE OUTPUT GOES DIRECTLY TO THE TERMINAL
 //THIS IS WRONG!!!!
ERR     : . { System.out.println("Invalid char: "+ getText()); lexicalErrors++; } -> channel(HIDDEN); 

