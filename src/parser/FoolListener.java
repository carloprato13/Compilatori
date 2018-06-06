package parser;
// Generated from Fool.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FoolParser}.
 */
public interface FoolListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code singleExp}
	 * labeled alternative in {@link FoolParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterSingleExp(FoolParser.SingleExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code singleExp}
	 * labeled alternative in {@link FoolParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitSingleExp(FoolParser.SingleExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code letInExp}
	 * labeled alternative in {@link FoolParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterLetInExp(FoolParser.LetInExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code letInExp}
	 * labeled alternative in {@link FoolParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitLetInExp(FoolParser.LetInExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link FoolParser#let}.
	 * @param ctx the parse tree
	 */
	void enterLet(FoolParser.LetContext ctx);
	/**
	 * Exit a parse tree produced by {@link FoolParser#let}.
	 * @param ctx the parse tree
	 */
	void exitLet(FoolParser.LetContext ctx);
	/**
	 * Enter a parse tree produced by {@link FoolParser#vardec}.
	 * @param ctx the parse tree
	 */
	void enterVardec(FoolParser.VardecContext ctx);
	/**
	 * Exit a parse tree produced by {@link FoolParser#vardec}.
	 * @param ctx the parse tree
	 */
	void exitVardec(FoolParser.VardecContext ctx);
	/**
	 * Enter a parse tree produced by the {@code decAsm}
	 * labeled alternative in {@link FoolParser#varasm}.
	 * @param ctx the parse tree
	 */
	void enterDecAsm(FoolParser.DecAsmContext ctx);
	/**
	 * Exit a parse tree produced by the {@code decAsm}
	 * labeled alternative in {@link FoolParser#varasm}.
	 * @param ctx the parse tree
	 */
	void exitDecAsm(FoolParser.DecAsmContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Asm}
	 * labeled alternative in {@link FoolParser#varasm}.
	 * @param ctx the parse tree
	 */
	void enterAsm(FoolParser.AsmContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Asm}
	 * labeled alternative in {@link FoolParser#varasm}.
	 * @param ctx the parse tree
	 */
	void exitAsm(FoolParser.AsmContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fieldAsm}
	 * labeled alternative in {@link FoolParser#varasm}.
	 * @param ctx the parse tree
	 */
	void enterFieldAsm(FoolParser.FieldAsmContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fieldAsm}
	 * labeled alternative in {@link FoolParser#varasm}.
	 * @param ctx the parse tree
	 */
	void exitFieldAsm(FoolParser.FieldAsmContext ctx);
	/**
	 * Enter a parse tree produced by {@link FoolParser#fun}.
	 * @param ctx the parse tree
	 */
	void enterFun(FoolParser.FunContext ctx);
	/**
	 * Exit a parse tree produced by {@link FoolParser#fun}.
	 * @param ctx the parse tree
	 */
	void exitFun(FoolParser.FunContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varAssignment}
	 * labeled alternative in {@link FoolParser#dec}.
	 * @param ctx the parse tree
	 */
	void enterVarAssignment(FoolParser.VarAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varAssignment}
	 * labeled alternative in {@link FoolParser#dec}.
	 * @param ctx the parse tree
	 */
	void exitVarAssignment(FoolParser.VarAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funDeclaration}
	 * labeled alternative in {@link FoolParser#dec}.
	 * @param ctx the parse tree
	 */
	void enterFunDeclaration(FoolParser.FunDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funDeclaration}
	 * labeled alternative in {@link FoolParser#dec}.
	 * @param ctx the parse tree
	 */
	void exitFunDeclaration(FoolParser.FunDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code classDeclaration}
	 * labeled alternative in {@link FoolParser#dec}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(FoolParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code classDeclaration}
	 * labeled alternative in {@link FoolParser#dec}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(FoolParser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link FoolParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(FoolParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link FoolParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(FoolParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intExp}
	 * labeled alternative in {@link FoolParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterIntExp(FoolParser.IntExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intExp}
	 * labeled alternative in {@link FoolParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitIntExp(FoolParser.IntExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolExp}
	 * labeled alternative in {@link FoolParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterBoolExp(FoolParser.BoolExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolExp}
	 * labeled alternative in {@link FoolParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitBoolExp(FoolParser.BoolExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code classInstantiation}
	 * labeled alternative in {@link FoolParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterClassInstantiation(FoolParser.ClassInstantiationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code classInstantiation}
	 * labeled alternative in {@link FoolParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitClassInstantiation(FoolParser.ClassInstantiationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statement}
	 * labeled alternative in {@link FoolParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterStatement(FoolParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statement}
	 * labeled alternative in {@link FoolParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitStatement(FoolParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifThenElse}
	 * labeled alternative in {@link FoolParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterIfThenElse(FoolParser.IfThenElseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifThenElse}
	 * labeled alternative in {@link FoolParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitIfThenElse(FoolParser.IfThenElseContext ctx);
	/**
	 * Enter a parse tree produced by {@link FoolParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(FoolParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link FoolParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(FoolParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link FoolParser#stms}.
	 * @param ctx the parse tree
	 */
	void enterStms(FoolParser.StmsContext ctx);
	/**
	 * Exit a parse tree produced by {@link FoolParser#stms}.
	 * @param ctx the parse tree
	 */
	void exitStms(FoolParser.StmsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stmAsm}
	 * labeled alternative in {@link FoolParser#stm}.
	 * @param ctx the parse tree
	 */
	void enterStmAsm(FoolParser.StmAsmContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stmAsm}
	 * labeled alternative in {@link FoolParser#stm}.
	 * @param ctx the parse tree
	 */
	void exitStmAsm(FoolParser.StmAsmContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BranchStm}
	 * labeled alternative in {@link FoolParser#stm}.
	 * @param ctx the parse tree
	 */
	void enterBranchStm(FoolParser.BranchStmContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BranchStm}
	 * labeled alternative in {@link FoolParser#stm}.
	 * @param ctx the parse tree
	 */
	void exitBranchStm(FoolParser.BranchStmContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolFactor}
	 * labeled alternative in {@link FoolParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterBoolFactor(FoolParser.BoolFactorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolFactor}
	 * labeled alternative in {@link FoolParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitBoolFactor(FoolParser.BoolFactorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intBoolFactor}
	 * labeled alternative in {@link FoolParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterIntBoolFactor(FoolParser.IntBoolFactorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intBoolFactor}
	 * labeled alternative in {@link FoolParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitIntBoolFactor(FoolParser.IntBoolFactorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valFactor}
	 * labeled alternative in {@link FoolParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterValFactor(FoolParser.ValFactorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valFactor}
	 * labeled alternative in {@link FoolParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitValFactor(FoolParser.ValFactorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intVal}
	 * labeled alternative in {@link FoolParser#value}.
	 * @param ctx the parse tree
	 */
	void enterIntVal(FoolParser.IntValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intVal}
	 * labeled alternative in {@link FoolParser#value}.
	 * @param ctx the parse tree
	 */
	void exitIntVal(FoolParser.IntValContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolVal}
	 * labeled alternative in {@link FoolParser#value}.
	 * @param ctx the parse tree
	 */
	void enterBoolVal(FoolParser.BoolValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolVal}
	 * labeled alternative in {@link FoolParser#value}.
	 * @param ctx the parse tree
	 */
	void exitBoolVal(FoolParser.BoolValContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varVal}
	 * labeled alternative in {@link FoolParser#value}.
	 * @param ctx the parse tree
	 */
	void enterVarVal(FoolParser.VarValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varVal}
	 * labeled alternative in {@link FoolParser#value}.
	 * @param ctx the parse tree
	 */
	void exitVarVal(FoolParser.VarValContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcall}
	 * labeled alternative in {@link FoolParser#value}.
	 * @param ctx the parse tree
	 */
	void enterFuncall(FoolParser.FuncallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcall}
	 * labeled alternative in {@link FoolParser#value}.
	 * @param ctx the parse tree
	 */
	void exitFuncall(FoolParser.FuncallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nullVal}
	 * labeled alternative in {@link FoolParser#value}.
	 * @param ctx the parse tree
	 */
	void enterNullVal(FoolParser.NullValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nullVal}
	 * labeled alternative in {@link FoolParser#value}.
	 * @param ctx the parse tree
	 */
	void exitNullVal(FoolParser.NullValContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fieldVal}
	 * labeled alternative in {@link FoolParser#value}.
	 * @param ctx the parse tree
	 */
	void enterFieldVal(FoolParser.FieldValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fieldVal}
	 * labeled alternative in {@link FoolParser#value}.
	 * @param ctx the parse tree
	 */
	void exitFieldVal(FoolParser.FieldValContext ctx);
	/**
	 * Enter a parse tree produced by the {@code methodCall}
	 * labeled alternative in {@link FoolParser#value}.
	 * @param ctx the parse tree
	 */
	void enterMethodCall(FoolParser.MethodCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code methodCall}
	 * labeled alternative in {@link FoolParser#value}.
	 * @param ctx the parse tree
	 */
	void exitMethodCall(FoolParser.MethodCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code baseVal}
	 * labeled alternative in {@link FoolParser#value}.
	 * @param ctx the parse tree
	 */
	void enterBaseVal(FoolParser.BaseValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code baseVal}
	 * labeled alternative in {@link FoolParser#value}.
	 * @param ctx the parse tree
	 */
	void exitBaseVal(FoolParser.BaseValContext ctx);
}