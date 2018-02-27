// Generated from Fonction.g4 by ANTLR 4.4

	package math.fonction.analyse.semantique;
	import math.entities.mathobject.BinaryOperation;
import math.entities.mathobject.Fonction;
import math.entities.mathobject.Inconnue;
import math.entities.mathobject.MathObject;
import math.entities.mathobject.Polynome;
import math.entities.mathobject.Reel;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FonctionParser}.
 */
public interface FonctionListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link FonctionParser#polynome_op}.
	 * @param ctx the parse tree
	 */
	void enterPolynome_op(@NotNull FonctionParser.Polynome_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link FonctionParser#polynome_op}.
	 * @param ctx the parse tree
	 */
	void exitPolynome_op(@NotNull FonctionParser.Polynome_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link FonctionParser#fonction_name}.
	 * @param ctx the parse tree
	 */
	void enterFonction_name(@NotNull FonctionParser.Fonction_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link FonctionParser#fonction_name}.
	 * @param ctx the parse tree
	 */
	void exitFonction_name(@NotNull FonctionParser.Fonction_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link FonctionParser#tokken}.
	 * @param ctx the parse tree
	 */
	void enterTokken(@NotNull FonctionParser.TokkenContext ctx);
	/**
	 * Exit a parse tree produced by {@link FonctionParser#tokken}.
	 * @param ctx the parse tree
	 */
	void exitTokken(@NotNull FonctionParser.TokkenContext ctx);
	/**
	 * Enter a parse tree produced by {@link FonctionParser#reel_op}.
	 * @param ctx the parse tree
	 */
	void enterReel_op(@NotNull FonctionParser.Reel_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link FonctionParser#reel_op}.
	 * @param ctx the parse tree
	 */
	void exitReel_op(@NotNull FonctionParser.Reel_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link FonctionParser#inconnue}.
	 * @param ctx the parse tree
	 */
	void enterInconnue(@NotNull FonctionParser.InconnueContext ctx);
	/**
	 * Exit a parse tree produced by {@link FonctionParser#inconnue}.
	 * @param ctx the parse tree
	 */
	void exitInconnue(@NotNull FonctionParser.InconnueContext ctx);
	/**
	 * Enter a parse tree produced by {@link FonctionParser#operateur_second}.
	 * @param ctx the parse tree
	 */
	void enterOperateur_second(@NotNull FonctionParser.Operateur_secondContext ctx);
	/**
	 * Exit a parse tree produced by {@link FonctionParser#operateur_second}.
	 * @param ctx the parse tree
	 */
	void exitOperateur_second(@NotNull FonctionParser.Operateur_secondContext ctx);
	/**
	 * Enter a parse tree produced by {@link FonctionParser#fonction_statement}.
	 * @param ctx the parse tree
	 */
	void enterFonction_statement(@NotNull FonctionParser.Fonction_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link FonctionParser#fonction_statement}.
	 * @param ctx the parse tree
	 */
	void exitFonction_statement(@NotNull FonctionParser.Fonction_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link FonctionParser#operateur_first}.
	 * @param ctx the parse tree
	 */
	void enterOperateur_first(@NotNull FonctionParser.Operateur_firstContext ctx);
	/**
	 * Exit a parse tree produced by {@link FonctionParser#operateur_first}.
	 * @param ctx the parse tree
	 */
	void exitOperateur_first(@NotNull FonctionParser.Operateur_firstContext ctx);
	/**
	 * Enter a parse tree produced by {@link FonctionParser#fonction}.
	 * @param ctx the parse tree
	 */
	void enterFonction(@NotNull FonctionParser.FonctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FonctionParser#fonction}.
	 * @param ctx the parse tree
	 */
	void exitFonction(@NotNull FonctionParser.FonctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FonctionParser#complexe_tokken}.
	 * @param ctx the parse tree
	 */
	void enterComplexe_tokken(@NotNull FonctionParser.Complexe_tokkenContext ctx);
	/**
	 * Exit a parse tree produced by {@link FonctionParser#complexe_tokken}.
	 * @param ctx the parse tree
	 */
	void exitComplexe_tokken(@NotNull FonctionParser.Complexe_tokkenContext ctx);
	/**
	 * Enter a parse tree produced by {@link FonctionParser#tokken_simple}.
	 * @param ctx the parse tree
	 */
	void enterTokken_simple(@NotNull FonctionParser.Tokken_simpleContext ctx);
	/**
	 * Exit a parse tree produced by {@link FonctionParser#tokken_simple}.
	 * @param ctx the parse tree
	 */
	void exitTokken_simple(@NotNull FonctionParser.Tokken_simpleContext ctx);
	/**
	 * Enter a parse tree produced by {@link FonctionParser#operateur}.
	 * @param ctx the parse tree
	 */
	void enterOperateur(@NotNull FonctionParser.OperateurContext ctx);
	/**
	 * Exit a parse tree produced by {@link FonctionParser#operateur}.
	 * @param ctx the parse tree
	 */
	void exitOperateur(@NotNull FonctionParser.OperateurContext ctx);
	/**
	 * Enter a parse tree produced by {@link FonctionParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(@NotNull FonctionParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link FonctionParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(@NotNull FonctionParser.ValueContext ctx);
}