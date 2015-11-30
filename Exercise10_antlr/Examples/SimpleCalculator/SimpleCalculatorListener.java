// Generated from SimpleCalculator.g4 by ANTLR 4.4

import java.util.Stack;
import java.util.EmptyStackException;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SimpleCalculatorParser}.
 */
public interface SimpleCalculatorListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SimpleCalculatorParser#boolop}.
	 * @param ctx the parse tree
	 */
	void enterBoolop(@NotNull SimpleCalculatorParser.BoolopContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleCalculatorParser#boolop}.
	 * @param ctx the parse tree
	 */
	void exitBoolop(@NotNull SimpleCalculatorParser.BoolopContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleCalculatorParser#rpn}.
	 * @param ctx the parse tree
	 */
	void enterRpn(@NotNull SimpleCalculatorParser.RpnContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleCalculatorParser#rpn}.
	 * @param ctx the parse tree
	 */
	void exitRpn(@NotNull SimpleCalculatorParser.RpnContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleCalculatorParser#numop}.
	 * @param ctx the parse tree
	 */
	void enterNumop(@NotNull SimpleCalculatorParser.NumopContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleCalculatorParser#numop}.
	 * @param ctx the parse tree
	 */
	void exitNumop(@NotNull SimpleCalculatorParser.NumopContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleCalculatorParser#bool}.
	 * @param ctx the parse tree
	 */
	void enterBool(@NotNull SimpleCalculatorParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleCalculatorParser#bool}.
	 * @param ctx the parse tree
	 */
	void exitBool(@NotNull SimpleCalculatorParser.BoolContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleCalculatorParser#num}.
	 * @param ctx the parse tree
	 */
	void enterNum(@NotNull SimpleCalculatorParser.NumContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleCalculatorParser#num}.
	 * @param ctx the parse tree
	 */
	void exitNum(@NotNull SimpleCalculatorParser.NumContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleCalculatorParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(@NotNull SimpleCalculatorParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleCalculatorParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(@NotNull SimpleCalculatorParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleCalculatorParser#nm}.
	 * @param ctx the parse tree
	 */
	void enterNm(@NotNull SimpleCalculatorParser.NmContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleCalculatorParser#nm}.
	 * @param ctx the parse tree
	 */
	void exitNm(@NotNull SimpleCalculatorParser.NmContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleCalculatorParser#booltext}.
	 * @param ctx the parse tree
	 */
	void enterBooltext(@NotNull SimpleCalculatorParser.BooltextContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleCalculatorParser#booltext}.
	 * @param ctx the parse tree
	 */
	void exitBooltext(@NotNull SimpleCalculatorParser.BooltextContext ctx);
}