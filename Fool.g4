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

let       : LET (dec SEMIC)+ IN ;

vardec  : type ID ;

varasm     : vardec ASM exp ;

fun    : type ID LPAR ( vardec ( COMMA vardec)* )? RPAR (let)? exp ;

dec   : varasm           #varAssignment
      | fun              #funDeclaration
      ;
         
   
type   : INT  
        | BOOL 
      ;  
    
exp     : left=term (PLUS right=exp)?
	| left=term (MINUS right=exp)?
	| left=value (AND right = value)?
	| left=value (OR right = value)?
        | NOT left=value 
	| left=value (EQ right = value)?
	| left=value (GT right = value)?
	| left=value (LT right = value)?
	| left=value (GTEQ right = value)?
	| left=value (LTEQ right = value)?
	;
   
term   : left=factor (TIMES right=term)?
        | left=factor (FRACT right=term)?
      ;

stms :  ( stm )+;

stm : 	varasm 
	| IF exp THEN CLPAR stms CRPAR ELSE CLPAR stms CRPAR
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



//Numbers
fragment DIGIT : '0'..'9';    
INTEGER       : ('-')?DIGIT+;

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

