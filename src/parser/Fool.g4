grammar Fool;


@header {
    import java.util.ArrayList;
}

@lexer::members {
   public ArrayList<String> errors = new ArrayList<>();
}

/*------------------------------------------------------------------
 * PARSER RULES
 *------------------------------------------------------------------*/
  
prog   : exp SEMIC                 #singleExp
       | let exp SEMIC             #letInExp
       | (classd)+ SEMIC (let)? exp SEMIC  #classExp       
       ;

classd : CLASS ID (EXTS ID)? (LPAR ( vardec (COMMA vardec)* )? RPAR)? (CLPAR (fun SEMIC)* CRPAR)? ;

let    : LET (dec SEMIC)+ IN ;

vardec : t=type name=ID ;

varasm : t=vardec ASM e=exp     #decAsm 
       | t=ID ASM e=exp       #Asm
       | t=ID DOT f=ID ASM e=exp  #fieldAsm
       ;

fun    : type ID LPAR ( vardec ( COMMA vardec)* )? RPAR (let)? exp ;

dec    : varasm           #varAssignment
       | fun              #funDeclaration
       ;         
   
type   : INT  
       | BOOL 
       | VOID
       | ID
       ;  
    
exp    : left=term (op =PLUS right=exp)?  #intExp
       | left=term (op = MINUS right=exp)? #intExp
       | left=term (op = AND right=exp)? #boolExp
       | left=term (op = OR right=exp)?  #boolExp
       | op=NOT exp #boolExp
       | stms #statement
       | IF cond=exp THEN CLPAR thenBranch=exp CRPAR ELSE CLPAR elseBranch=exp CRPAR  #ifThenElse
;
   
term   : left=factor (op=TIMES right=term)?
       | left=factor (op=FRACT right=term)?
       ;

stms   : ( stm )+;

stm    : varasm #stmAsm
       | IF e=exp THEN CLPAR b1=stms CRPAR ELSE CLPAR b2=stms CRPAR #BranchStm
       ;

factor : left=value EQ right=value #boolFactor
       | left=value op=GT right=value #intBoolFactor
       | left=value op=LT right=value #intBoolFactor
       | left=value op=GTEQ right=value #intBoolFactor
       | left=value op=LTEQ right=value #intBoolFactor
       | left=value #valFactor
       ;     
   
value  : INTEGER          #intVal
       | ( TRUE | FALSE ) #boolVal
       | ID               #varVal
       | name=ID ( LPAR (elem+=exp (COMMA elem+=exp)* )? RPAR )? #funcall
       | NULL #nullVal 
       | ID DOT ID #fieldVal
       | ID DOT ID LPAR ( elem+=exp (COMMA elem+=exp)* )? RPAR #methodCall
       | LPAR exp RPAR                      #baseVal
       | NEW ID LPAR ( elem+=stm (COMMA elem+=stm)* )? RPAR #classInstantiation
       | PRINT ( exp )        #print       
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
MINUS  : '-';
TIMES  : '*' ;
FRACT  : '/' ;
TRUE   : 'true' ;
FALSE  : 'false' ;
LPAR   : '(' ;
RPAR   : ')' ;
CLPAR  : '{' ;
CRPAR  : '}' ;
IF     : 'if' ;
THEN   : 'then' ;
ELSE   : 'else' ;
AND    : '&&' ;
OR     : '||' ;
NOT    : 'not' ;
PRINT  : 'print' ; 
LET    : 'let' ;
IN     :'in' ;
VAR    : 'var' ;
FUN    : 'fun' ;
INT    : 'int' ;
BOOL   : 'bool' ;
CLASS  : 'class' ;
EXTS   : 'extends' ;
NEW    : 'new';
NULL   : 'null';
VOID   : 'void';

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

