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
	 * Enter a parse tree produced by {@link FoolParser#varasm}.
	 * @param ctx the parse tree
	 */
	void enterVarasm(FoolParser.VarasmContext ctx);
	/**
	 * Exit a parse tree produced by {@link FoolParser#varasm}.
	 * @param ctx the parse tree
	 */
	void exitVarasm(FoolParser.VarasmContext ctx);
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
	 * Enter a parse tree produced by the {@code methodCall}
	 * labeled alternative in {@link FoolParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterMethodCall(FoolParser.MethodCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code methodCall}
	 * labeled alternative in {@link FoolParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitMethodCall(FoolParser.MethodCallContext ctx);
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
	 * Enter a parse tree produced by the {@code nullValue}
	 * labeled alternative in {@link FoolParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterNullValue(FoolParser.NullValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nullValue}
	 * labeled alternative in {@link FoolParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitNullValue(FoolParser.NullValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intTerm}
	 * labeled alternative in {@link FoolParser#term}.
	 * @param ctx the parse tree
	 */
	void enterIntTerm(FoolParser.IntTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intTerm}
	 * labeled alternative in {@link FoolParser#term}.
	 * @param ctx the parse tree
	 */
	void exitIntTerm(FoolParser.IntTermContext ctx);
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
	 * Enter a parse tree produced by {@link FoolParser#stm}.
	 * @param ctx the parse tree
	 */
	void enterStm(FoolParser.StmContext ctx);
	/**
	 * Exit a parse tree produced by {@link FoolParser#stm}.
	 * @param ctx the parse tree
	 */
	void exitStm(FoolParser.StmContext ctx);
	/**
	 * Enter a parse tree produced by {@link FoolParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(FoolParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link FoolParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(FoolParser.FactorContext ctx);
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
	 * Enter a parse tree produced by the {@code baseExp}
	 * labeled alternative in {@link FoolParser#value}.
	 * @param ctx the parse tree
	 */
	void enterBaseExp(FoolParser.BaseExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code baseExp}
	 * labeled alternative in {@link FoolParser#value}.
	 * @param ctx the parse tree
	 */
	void exitBaseExp(FoolParser.BaseExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifExp}
	 * labeled alternative in {@link FoolParser#value}.
	 * @param ctx the parse tree
	 */
	void enterIfExp(FoolParser.IfExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifExp}
	 * labeled alternative in {@link FoolParser#value}.
	 * @param ctx the parse tree
	 */
	void exitIfExp(FoolParser.IfExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varExp}
	 * labeled alternative in {@link FoolParser#value}.
	 * @param ctx the parse tree
	 */
	void enterVarExp(FoolParser.VarExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varExp}
	 * labeled alternative in {@link FoolParser#value}.
	 * @param ctx the parse tree
	 */
	void exitVarExp(FoolParser.VarExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funExp}
	 * labeled alternative in {@link FoolParser#value}.
	 * @param ctx the parse tree
	 */
	void enterFunExp(FoolParser.FunExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funExp}
	 * labeled alternative in {@link FoolParser#value}.
	 * @param ctx the parse tree
	 */
	void exitFunExp(FoolParser.FunExpContext ctx);
}