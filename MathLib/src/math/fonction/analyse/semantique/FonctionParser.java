// Generated from Fonction.g4 by ANTLR 4.4

	package math.fonction.analyse.semantique;
	import math.entities.mathobject.BinaryOperation;
import math.entities.mathobject.Fonction;
import math.entities.mathobject.Inconnue;
import math.entities.mathobject.MathObject;
import math.entities.mathobject.Polynome;
import math.entities.mathobject.Reel;
import math.entities.mathobject.fonction.Exponentiel;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FonctionParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SIN=1, COS=2, TAN=3, CH=4, SH=5, TH=6, EXP=7, LOG=8, LN=9, LBR=10, RBR=11, 
		ADD=12, SUS=13, MUL=14, DIV=15, POW=16, VALUE=17, INCONNUE=18, WS=19;
	public static final String[] tokenNames = {
		"<INVALID>", "'sin'", "'cos'", "'tan'", "'ch'", "'sh'", "'th'", "'exp'", 
		"'log'", "'ln'", "'('", "')'", "'+'", "'-'", "'*'", "'/'", "'^'", "VALUE", 
		"INCONNUE", "WS"
	};
	public static final int
		RULE_fonction_statement = 0, RULE_tokken = 1, RULE_complexe_tokken = 2, 
		RULE_tokken_simple = 3, RULE_fonction = 4, RULE_fonction_name = 5, RULE_value = 6, 
		RULE_reel_op = 7, RULE_polynome_op = 8, RULE_inconnue = 9, RULE_operateur = 10, 
		RULE_operateur_first = 11, RULE_operateur_second = 12;
	public static final String[] ruleNames = {
		"fonction_statement", "tokken", "complexe_tokken", "tokken_simple", "fonction", 
		"fonction_name", "value", "reel_op", "polynome_op", "inconnue", "operateur", 
		"operateur_first", "operateur_second"
	};

	@Override
	public String getGrammarFileName() { return "Fonction.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public FonctionParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class Fonction_statementContext extends ParserRuleContext {
		public MathObject op;
		public TokkenContext tok;
		public TokkenContext tokken() {
			return getRuleContext(TokkenContext.class,0);
		}
		public Fonction_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fonction_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FonctionListener ) ((FonctionListener)listener).enterFonction_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FonctionListener ) ((FonctionListener)listener).exitFonction_statement(this);
		}
	}

	public final Fonction_statementContext fonction_statement() throws RecognitionException {
		Fonction_statementContext _localctx = new Fonction_statementContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_fonction_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26); ((Fonction_statementContext)_localctx).tok = tokken();
			((Fonction_statementContext)_localctx).op =  ((Fonction_statementContext)_localctx).tok.result;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TokkenContext extends ParserRuleContext {
		public MathObject result;
		public Complexe_tokkenContext rslt1;
		public Complexe_tokkenContext complexe_tokken() {
			return getRuleContext(Complexe_tokkenContext.class,0);
		}
		public TokkenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tokken; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FonctionListener ) ((FonctionListener)listener).enterTokken(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FonctionListener ) ((FonctionListener)listener).exitTokken(this);
		}
	}

	public final TokkenContext tokken() throws RecognitionException {
		TokkenContext _localctx = new TokkenContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_tokken);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29); ((TokkenContext)_localctx).rslt1 = complexe_tokken(0);
			((TokkenContext)_localctx).result =  ((TokkenContext)_localctx).rslt1.complexe_tok;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Complexe_tokkenContext extends ParserRuleContext {
		public MathObject complexe_tok;
		public Complexe_tokkenContext val7;
		public Complexe_tokkenContext val9;
		public Tokken_simpleContext val1;
		public OperateurContext op;
		public Tokken_simpleContext val2;
		public Tokken_simpleContext val3;
		public Operateur_firstContext op2;
		public Tokken_simpleContext val4;
		public Complexe_tokkenContext val5;
		public OperateurContext op3;
		public Complexe_tokkenContext val6;
		public Tokken_simpleContext simple_tok;
		public Tokken_simpleContext simple_tok2;
		public Operateur_firstContext op4;
		public Complexe_tokkenContext val8;
		public Operateur_secondContext op5;
		public Complexe_tokkenContext val10;
		public TerminalNode RBR() { return getToken(FonctionParser.RBR, 0); }
		public Complexe_tokkenContext complexe_tokken(int i) {
			return getRuleContext(Complexe_tokkenContext.class,i);
		}
		public OperateurContext operateur() {
			return getRuleContext(OperateurContext.class,0);
		}
		public List<Complexe_tokkenContext> complexe_tokken() {
			return getRuleContexts(Complexe_tokkenContext.class);
		}
		public TerminalNode LBR() { return getToken(FonctionParser.LBR, 0); }
		public List<Tokken_simpleContext> tokken_simple() {
			return getRuleContexts(Tokken_simpleContext.class);
		}
		public Tokken_simpleContext tokken_simple(int i) {
			return getRuleContext(Tokken_simpleContext.class,i);
		}
		public Operateur_firstContext operateur_first() {
			return getRuleContext(Operateur_firstContext.class,0);
		}
		public Operateur_secondContext operateur_second() {
			return getRuleContext(Operateur_secondContext.class,0);
		}
		public Complexe_tokkenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_complexe_tokken; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FonctionListener ) ((FonctionListener)listener).enterComplexe_tokken(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FonctionListener ) ((FonctionListener)listener).exitComplexe_tokken(this);
		}
	}

	public final Complexe_tokkenContext complexe_tokken() throws RecognitionException {
		return complexe_tokken(0);
	}

	private Complexe_tokkenContext complexe_tokken(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Complexe_tokkenContext _localctx = new Complexe_tokkenContext(_ctx, _parentState);
		Complexe_tokkenContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_complexe_tokken, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(33); match(LBR);
				setState(34); ((Complexe_tokkenContext)_localctx).val1 = tokken_simple();
				setState(35); ((Complexe_tokkenContext)_localctx).op = operateur();
				setState(36); ((Complexe_tokkenContext)_localctx).val2 = tokken_simple();
				setState(37); match(RBR);
				((Complexe_tokkenContext)_localctx).complexe_tok =  new BinaryOperation(((Complexe_tokkenContext)_localctx).op.operater, ((Complexe_tokkenContext)_localctx).val1.valueOperation, ((Complexe_tokkenContext)_localctx).val2.valueOperation);
				}
				break;
			case 2:
				{
				setState(40); ((Complexe_tokkenContext)_localctx).val3 = tokken_simple();
				setState(41); ((Complexe_tokkenContext)_localctx).op2 = operateur_first();
				setState(42); ((Complexe_tokkenContext)_localctx).val4 = tokken_simple();
				((Complexe_tokkenContext)_localctx).complexe_tok =  new BinaryOperation(((Complexe_tokkenContext)_localctx).op2.operater_first, ((Complexe_tokkenContext)_localctx).val3.valueOperation, ((Complexe_tokkenContext)_localctx).val4.valueOperation);
				}
				break;
			case 3:
				{
				setState(45); match(LBR);
				setState(46); ((Complexe_tokkenContext)_localctx).val5 = complexe_tokken(0);
				setState(47); ((Complexe_tokkenContext)_localctx).op3 = operateur();
				setState(48); ((Complexe_tokkenContext)_localctx).val6 = complexe_tokken(0);
				setState(49); match(RBR);
				((Complexe_tokkenContext)_localctx).complexe_tok =  new BinaryOperation(((Complexe_tokkenContext)_localctx).op3.operater, ((Complexe_tokkenContext)_localctx).val5.complexe_tok, ((Complexe_tokkenContext)_localctx).val6.complexe_tok);
				}
				break;
			case 4:
				{
				setState(52); ((Complexe_tokkenContext)_localctx).simple_tok = tokken_simple();
				((Complexe_tokkenContext)_localctx).complexe_tok =  ((Complexe_tokkenContext)_localctx).simple_tok.valueOperation;
				}
				break;
			case 5:
				{
				setState(55); match(LBR);
				setState(56); ((Complexe_tokkenContext)_localctx).simple_tok2 = tokken_simple();
				setState(57); match(RBR);
				((Complexe_tokkenContext)_localctx).complexe_tok =  ((Complexe_tokkenContext)_localctx).simple_tok2.valueOperation;
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(74);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(72);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new Complexe_tokkenContext(_parentctx, _parentState);
						_localctx.val7 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_complexe_tokken);
						setState(62);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(63); ((Complexe_tokkenContext)_localctx).op4 = operateur_first();
						setState(64); ((Complexe_tokkenContext)_localctx).val8 = complexe_tokken(5);
						((Complexe_tokkenContext)_localctx).complexe_tok =  new BinaryOperation(((Complexe_tokkenContext)_localctx).op4.operater_first, ((Complexe_tokkenContext)_localctx).val7.complexe_tok, ((Complexe_tokkenContext)_localctx).val8.complexe_tok);
						}
						break;
					case 2:
						{
						_localctx = new Complexe_tokkenContext(_parentctx, _parentState);
						_localctx.val9 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_complexe_tokken);
						setState(67);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(68); ((Complexe_tokkenContext)_localctx).op5 = operateur_second();
						setState(69); ((Complexe_tokkenContext)_localctx).val10 = complexe_tokken(2);
						((Complexe_tokkenContext)_localctx).complexe_tok =  new BinaryOperation(((Complexe_tokkenContext)_localctx).op5.operater_second, ((Complexe_tokkenContext)_localctx).val9.complexe_tok, ((Complexe_tokkenContext)_localctx).val10.complexe_tok);
						}
						break;
					}
					} 
				}
				setState(76);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Tokken_simpleContext extends ParserRuleContext {
		public MathObject valueOperation;
		public FonctionContext fonct;
		public ValueContext val;
		public InconnueContext inc;
		public FonctionContext fonction() {
			return getRuleContext(FonctionContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public InconnueContext inconnue() {
			return getRuleContext(InconnueContext.class,0);
		}
		public Tokken_simpleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tokken_simple; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FonctionListener ) ((FonctionListener)listener).enterTokken_simple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FonctionListener ) ((FonctionListener)listener).exitTokken_simple(this);
		}
	}

	public final Tokken_simpleContext tokken_simple() throws RecognitionException {
		Tokken_simpleContext _localctx = new Tokken_simpleContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_tokken_simple);
		try {
			setState(86);
			switch (_input.LA(1)) {
			case SIN:
			case COS:
			case TAN:
			case CH:
			case SH:
			case TH:
			case EXP:
			case LOG:
			case LN:
				enterOuterAlt(_localctx, 1);
				{
				setState(77); ((Tokken_simpleContext)_localctx).fonct = fonction();
				((Tokken_simpleContext)_localctx).valueOperation =  ((Tokken_simpleContext)_localctx).fonct.mathObject; 
				}
				break;
			case LBR:
			case SUS:
			case VALUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(80); ((Tokken_simpleContext)_localctx).val = value();
				((Tokken_simpleContext)_localctx).valueOperation =  ((Tokken_simpleContext)_localctx).val.mathObject; 
				}
				break;
			case INCONNUE:
				enterOuterAlt(_localctx, 3);
				{
				setState(83); ((Tokken_simpleContext)_localctx).inc = inconnue();
				((Tokken_simpleContext)_localctx).valueOperation =  ((Tokken_simpleContext)_localctx).inc.mathObject; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FonctionContext extends ParserRuleContext {
		public MathObject mathObject;
		public Fonction_nameContext fonct;
		public TokkenContext tok;
		public TerminalNode RBR() { return getToken(FonctionParser.RBR, 0); }
		public TerminalNode LBR() { return getToken(FonctionParser.LBR, 0); }
		public Fonction_nameContext fonction_name() {
			return getRuleContext(Fonction_nameContext.class,0);
		}
		public TokkenContext tokken() {
			return getRuleContext(TokkenContext.class,0);
		}
		public FonctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fonction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FonctionListener ) ((FonctionListener)listener).enterFonction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FonctionListener ) ((FonctionListener)listener).exitFonction(this);
		}
	}

	public final FonctionContext fonction() throws RecognitionException {
		FonctionContext _localctx = new FonctionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_fonction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(88); ((FonctionContext)_localctx).fonct = fonction_name();
			}
			{
			setState(89); match(LBR);
			setState(90); ((FonctionContext)_localctx).tok = tokken();
			setState(91); match(RBR);
			}

					if(((FonctionContext)_localctx).tok.result.equals("exp")){
						((FonctionContext)_localctx).mathObject =  new Exponentiel( ((FonctionContext)_localctx).fonct.name, ((FonctionContext)_localctx).tok.result);
					}else{
						((FonctionContext)_localctx).mathObject =  new Fonction( ((FonctionContext)_localctx).fonct.name, ((FonctionContext)_localctx).tok.result);
					}
				
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Fonction_nameContext extends ParserRuleContext {
		public String name;
		public Token sin;
		public Token cos;
		public Token tan;
		public Token ch;
		public Token sh;
		public Token th;
		public Token exp;
		public Token log;
		public Token ln;
		public TerminalNode LOG() { return getToken(FonctionParser.LOG, 0); }
		public TerminalNode TH() { return getToken(FonctionParser.TH, 0); }
		public TerminalNode SIN() { return getToken(FonctionParser.SIN, 0); }
		public TerminalNode EXP() { return getToken(FonctionParser.EXP, 0); }
		public TerminalNode TAN() { return getToken(FonctionParser.TAN, 0); }
		public TerminalNode LN() { return getToken(FonctionParser.LN, 0); }
		public TerminalNode CH() { return getToken(FonctionParser.CH, 0); }
		public TerminalNode SH() { return getToken(FonctionParser.SH, 0); }
		public TerminalNode COS() { return getToken(FonctionParser.COS, 0); }
		public Fonction_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fonction_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FonctionListener ) ((FonctionListener)listener).enterFonction_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FonctionListener ) ((FonctionListener)listener).exitFonction_name(this);
		}
	}

	public final Fonction_nameContext fonction_name() throws RecognitionException {
		Fonction_nameContext _localctx = new Fonction_nameContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_fonction_name);
		try {
			setState(113);
			switch (_input.LA(1)) {
			case SIN:
				enterOuterAlt(_localctx, 1);
				{
				setState(95); ((Fonction_nameContext)_localctx).sin = match(SIN);
				((Fonction_nameContext)_localctx).name =  (((Fonction_nameContext)_localctx).sin != null)? ((Fonction_nameContext)_localctx).sin.getText() : null; 
				}
				break;
			case COS:
				enterOuterAlt(_localctx, 2);
				{
				setState(97); ((Fonction_nameContext)_localctx).cos = match(COS);
				((Fonction_nameContext)_localctx).name =  (((Fonction_nameContext)_localctx).cos != null)? ((Fonction_nameContext)_localctx).cos.getText() : null; 
				}
				break;
			case TAN:
				enterOuterAlt(_localctx, 3);
				{
				setState(99); ((Fonction_nameContext)_localctx).tan = match(TAN);
				((Fonction_nameContext)_localctx).name =  (((Fonction_nameContext)_localctx).tan != null)? ((Fonction_nameContext)_localctx).tan.getText() : null; 
				}
				break;
			case CH:
				enterOuterAlt(_localctx, 4);
				{
				setState(101); ((Fonction_nameContext)_localctx).ch = match(CH);
				((Fonction_nameContext)_localctx).name =  (((Fonction_nameContext)_localctx).ch != null)? ((Fonction_nameContext)_localctx).ch.getText() : null; 
				}
				break;
			case SH:
				enterOuterAlt(_localctx, 5);
				{
				setState(103); ((Fonction_nameContext)_localctx).sh = match(SH);
				((Fonction_nameContext)_localctx).name =  (((Fonction_nameContext)_localctx).sh != null)? ((Fonction_nameContext)_localctx).sh.getText() : null; 
				}
				break;
			case TH:
				enterOuterAlt(_localctx, 6);
				{
				setState(105); ((Fonction_nameContext)_localctx).th = match(TH);
				((Fonction_nameContext)_localctx).name =  (((Fonction_nameContext)_localctx).th != null)? ((Fonction_nameContext)_localctx).th.getText() : null; 
				}
				break;
			case EXP:
				enterOuterAlt(_localctx, 7);
				{
				setState(107); ((Fonction_nameContext)_localctx).exp = match(EXP);
				((Fonction_nameContext)_localctx).name =  (((Fonction_nameContext)_localctx).exp != null)? ((Fonction_nameContext)_localctx).exp.getText() : null; 
				}
				break;
			case LOG:
				enterOuterAlt(_localctx, 8);
				{
				setState(109); ((Fonction_nameContext)_localctx).log = match(LOG);
				((Fonction_nameContext)_localctx).name =  (((Fonction_nameContext)_localctx).log != null)? ((Fonction_nameContext)_localctx).log.getText() : null; 
				}
				break;
			case LN:
				enterOuterAlt(_localctx, 9);
				{
				setState(111); ((Fonction_nameContext)_localctx).ln = match(LN);
				((Fonction_nameContext)_localctx).name =  (((Fonction_nameContext)_localctx).ln != null)? ((Fonction_nameContext)_localctx).ln.getText() : null; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueContext extends ParserRuleContext {
		public MathObject mathObject;
		public Polynome_opContext polynome;
		public Reel_opContext reel;
		public Polynome_opContext polynome_op() {
			return getRuleContext(Polynome_opContext.class,0);
		}
		public Reel_opContext reel_op() {
			return getRuleContext(Reel_opContext.class,0);
		}
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FonctionListener ) ((FonctionListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FonctionListener ) ((FonctionListener)listener).exitValue(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_value);
		try {
			setState(121);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(115); ((ValueContext)_localctx).polynome = polynome_op();
				((ValueContext)_localctx).mathObject =  ((ValueContext)_localctx).polynome.polynome;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(118); ((ValueContext)_localctx).reel = reel_op();
				((ValueContext)_localctx).mathObject =  ((ValueContext)_localctx).reel.reel;
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Reel_opContext extends ParserRuleContext {
		public Reel reel;
		public Token sus;
		public Token val;
		public TerminalNode RBR() { return getToken(FonctionParser.RBR, 0); }
		public TerminalNode LBR() { return getToken(FonctionParser.LBR, 0); }
		public TerminalNode VALUE() { return getToken(FonctionParser.VALUE, 0); }
		public TerminalNode SUS() { return getToken(FonctionParser.SUS, 0); }
		public Reel_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reel_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FonctionListener ) ((FonctionListener)listener).enterReel_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FonctionListener ) ((FonctionListener)listener).exitReel_op(this);
		}
	}

	public final Reel_opContext reel_op() throws RecognitionException {
		Reel_opContext _localctx = new Reel_opContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_reel_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			switch (_input.LA(1)) {
			case LBR:
				{
				setState(123); match(LBR);
				setState(124); ((Reel_opContext)_localctx).sus = match(SUS);
				setState(125); ((Reel_opContext)_localctx).val = match(VALUE);
				setState(126); match(RBR);
				}
				break;
			case SUS:
			case VALUE:
				{
				setState(128);
				_la = _input.LA(1);
				if (_la==SUS) {
					{
					setState(127); ((Reel_opContext)_localctx).sus = match(SUS);
					}
				}

				setState(130); ((Reel_opContext)_localctx).val = match(VALUE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			((Reel_opContext)_localctx).reel =  new Reel(
						((((Reel_opContext)_localctx).sus != null)? ((Reel_opContext)_localctx).sus.getText() : "") +
						((((Reel_opContext)_localctx).val != null)? ((Reel_opContext)_localctx).val.getText() : null)
					); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Polynome_opContext extends ParserRuleContext {
		public Polynome polynome;
		public Reel_opContext reel_op;
		public List<Reel_opContext> valMath = new ArrayList<Reel_opContext>();
		public Token VALUE;
		public List<Token> val = new ArrayList<Token>();
		public TerminalNode POW(int i) {
			return getToken(FonctionParser.POW, i);
		}
		public TerminalNode MUL(int i) {
			return getToken(FonctionParser.MUL, i);
		}
		public TerminalNode ADD(int i) {
			return getToken(FonctionParser.ADD, i);
		}
		public List<TerminalNode> SUS() { return getTokens(FonctionParser.SUS); }
		public List<TerminalNode> MUL() { return getTokens(FonctionParser.MUL); }
		public List<Reel_opContext> reel_op() {
			return getRuleContexts(Reel_opContext.class);
		}
		public List<InconnueContext> inconnue() {
			return getRuleContexts(InconnueContext.class);
		}
		public Reel_opContext reel_op(int i) {
			return getRuleContext(Reel_opContext.class,i);
		}
		public InconnueContext inconnue(int i) {
			return getRuleContext(InconnueContext.class,i);
		}
		public List<TerminalNode> ADD() { return getTokens(FonctionParser.ADD); }
		public List<TerminalNode> VALUE() { return getTokens(FonctionParser.VALUE); }
		public List<TerminalNode> POW() { return getTokens(FonctionParser.POW); }
		public TerminalNode VALUE(int i) {
			return getToken(FonctionParser.VALUE, i);
		}
		public TerminalNode SUS(int i) {
			return getToken(FonctionParser.SUS, i);
		}
		public Polynome_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_polynome_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FonctionListener ) ((FonctionListener)listener).enterPolynome_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FonctionListener ) ((FonctionListener)listener).exitPolynome_op(this);
		}
	}

	public final Polynome_opContext polynome_op() throws RecognitionException {
		Polynome_opContext _localctx = new Polynome_opContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_polynome_op);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(135); ((Polynome_opContext)_localctx).reel_op = reel_op();
			((Polynome_opContext)_localctx).valMath.add(((Polynome_opContext)_localctx).reel_op);
			setState(136); match(MUL);
			setState(137); inconnue();
			setState(138); match(POW);
			setState(139); ((Polynome_opContext)_localctx).VALUE = match(VALUE);
			((Polynome_opContext)_localctx).val.add(((Polynome_opContext)_localctx).VALUE);
			}
			setState(150);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(141);
					_la = _input.LA(1);
					if ( !(_la==ADD || _la==SUS) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(142); ((Polynome_opContext)_localctx).reel_op = reel_op();
					((Polynome_opContext)_localctx).valMath.add(((Polynome_opContext)_localctx).reel_op);
					setState(143); match(MUL);
					setState(144); inconnue();
					setState(145); match(POW);
					setState(146); ((Polynome_opContext)_localctx).VALUE = match(VALUE);
					((Polynome_opContext)_localctx).val.add(((Polynome_opContext)_localctx).VALUE);
					}
					} 
				}
				setState(152);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			((Polynome_opContext)_localctx).polynome =  new Polynome(
						((Polynome_opContext)_localctx).valMath, ((Polynome_opContext)_localctx).val, true);		
				
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InconnueContext extends ParserRuleContext {
		public MathObject mathObject;
		public Token inc;
		public TerminalNode INCONNUE() { return getToken(FonctionParser.INCONNUE, 0); }
		public InconnueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inconnue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FonctionListener ) ((FonctionListener)listener).enterInconnue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FonctionListener ) ((FonctionListener)listener).exitInconnue(this);
		}
	}

	public final InconnueContext inconnue() throws RecognitionException {
		InconnueContext _localctx = new InconnueContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_inconnue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155); ((InconnueContext)_localctx).inc = match(INCONNUE);
			((InconnueContext)_localctx).mathObject =  new Inconnue((((InconnueContext)_localctx).inc != null)? ((InconnueContext)_localctx).inc.getText() : null); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperateurContext extends ParserRuleContext {
		public String operater;
		public Operateur_firstContext op1;
		public Operateur_secondContext op2;
		public Operateur_firstContext operateur_first() {
			return getRuleContext(Operateur_firstContext.class,0);
		}
		public Operateur_secondContext operateur_second() {
			return getRuleContext(Operateur_secondContext.class,0);
		}
		public OperateurContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operateur; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FonctionListener ) ((FonctionListener)listener).enterOperateur(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FonctionListener ) ((FonctionListener)listener).exitOperateur(this);
		}
	}

	public final OperateurContext operateur() throws RecognitionException {
		OperateurContext _localctx = new OperateurContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_operateur);
		try {
			setState(164);
			switch (_input.LA(1)) {
			case MUL:
			case DIV:
				enterOuterAlt(_localctx, 1);
				{
				setState(158); ((OperateurContext)_localctx).op1 = operateur_first();
				((OperateurContext)_localctx).operater =  ((OperateurContext)_localctx).op1.operater_first;
				}
				break;
			case ADD:
			case SUS:
				enterOuterAlt(_localctx, 2);
				{
				setState(161); ((OperateurContext)_localctx).op2 = operateur_second();
				((OperateurContext)_localctx).operater =  ((OperateurContext)_localctx).op2.operater_second;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Operateur_firstContext extends ParserRuleContext {
		public String operater_first;
		public Token mul;
		public Token div;
		public TerminalNode DIV() { return getToken(FonctionParser.DIV, 0); }
		public TerminalNode MUL() { return getToken(FonctionParser.MUL, 0); }
		public Operateur_firstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operateur_first; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FonctionListener ) ((FonctionListener)listener).enterOperateur_first(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FonctionListener ) ((FonctionListener)listener).exitOperateur_first(this);
		}
	}

	public final Operateur_firstContext operateur_first() throws RecognitionException {
		Operateur_firstContext _localctx = new Operateur_firstContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_operateur_first);
		try {
			setState(170);
			switch (_input.LA(1)) {
			case MUL:
				enterOuterAlt(_localctx, 1);
				{
				setState(166); ((Operateur_firstContext)_localctx).mul = match(MUL);
				((Operateur_firstContext)_localctx).operater_first =  (((Operateur_firstContext)_localctx).mul != null)? ((Operateur_firstContext)_localctx).mul.getText() : null; 
				}
				break;
			case DIV:
				enterOuterAlt(_localctx, 2);
				{
				setState(168); ((Operateur_firstContext)_localctx).div = match(DIV);
				((Operateur_firstContext)_localctx).operater_first =  (((Operateur_firstContext)_localctx).div != null)? ((Operateur_firstContext)_localctx).div.getText() : null; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Operateur_secondContext extends ParserRuleContext {
		public String operater_second;
		public Token add;
		public Token sus;
		public TerminalNode ADD() { return getToken(FonctionParser.ADD, 0); }
		public TerminalNode SUS() { return getToken(FonctionParser.SUS, 0); }
		public Operateur_secondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operateur_second; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FonctionListener ) ((FonctionListener)listener).enterOperateur_second(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FonctionListener ) ((FonctionListener)listener).exitOperateur_second(this);
		}
	}

	public final Operateur_secondContext operateur_second() throws RecognitionException {
		Operateur_secondContext _localctx = new Operateur_secondContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_operateur_second);
		try {
			setState(176);
			switch (_input.LA(1)) {
			case ADD:
				enterOuterAlt(_localctx, 1);
				{
				setState(172); ((Operateur_secondContext)_localctx).add = match(ADD);
				((Operateur_secondContext)_localctx).operater_second =  (((Operateur_secondContext)_localctx).add != null)? ((Operateur_secondContext)_localctx).add.getText() : null; 
				}
				break;
			case SUS:
				enterOuterAlt(_localctx, 2);
				{
				setState(174); ((Operateur_secondContext)_localctx).sus = match(SUS);
				((Operateur_secondContext)_localctx).operater_second =  (((Operateur_secondContext)_localctx).sus != null)? ((Operateur_secondContext)_localctx).sus.getText() : null; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 2: return complexe_tokken_sempred((Complexe_tokkenContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean complexe_tokken_sempred(Complexe_tokkenContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 4);
		case 1: return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\25\u00b5\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4?\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\7\4K\n\4\f\4\16\4N\13\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5"+
		"\5Y\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7t\n\7\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\5\b|\n\b\3\t\3\t\3\t\3\t\3\t\5\t\u0083\n\t\3\t\5\t\u0086\n\t\3\t\3"+
		"\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u0097\n\n\f"+
		"\n\16\n\u009a\13\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\5\f"+
		"\u00a7\n\f\3\r\3\r\3\r\3\r\5\r\u00ad\n\r\3\16\3\16\3\16\3\16\5\16\u00b3"+
		"\n\16\3\16\2\3\6\17\2\4\6\b\n\f\16\20\22\24\26\30\32\2\3\3\2\16\17\u00be"+
		"\2\34\3\2\2\2\4\37\3\2\2\2\6>\3\2\2\2\bX\3\2\2\2\nZ\3\2\2\2\fs\3\2\2\2"+
		"\16{\3\2\2\2\20\u0085\3\2\2\2\22\u0089\3\2\2\2\24\u009d\3\2\2\2\26\u00a6"+
		"\3\2\2\2\30\u00ac\3\2\2\2\32\u00b2\3\2\2\2\34\35\5\4\3\2\35\36\b\2\1\2"+
		"\36\3\3\2\2\2\37 \5\6\4\2 !\b\3\1\2!\5\3\2\2\2\"#\b\4\1\2#$\7\f\2\2$%"+
		"\5\b\5\2%&\5\26\f\2&\'\5\b\5\2\'(\7\r\2\2()\b\4\1\2)?\3\2\2\2*+\5\b\5"+
		"\2+,\5\30\r\2,-\5\b\5\2-.\b\4\1\2.?\3\2\2\2/\60\7\f\2\2\60\61\5\6\4\2"+
		"\61\62\5\26\f\2\62\63\5\6\4\2\63\64\7\r\2\2\64\65\b\4\1\2\65?\3\2\2\2"+
		"\66\67\5\b\5\2\678\b\4\1\28?\3\2\2\29:\7\f\2\2:;\5\b\5\2;<\7\r\2\2<=\b"+
		"\4\1\2=?\3\2\2\2>\"\3\2\2\2>*\3\2\2\2>/\3\2\2\2>\66\3\2\2\2>9\3\2\2\2"+
		"?L\3\2\2\2@A\f\6\2\2AB\5\30\r\2BC\5\6\4\7CD\b\4\1\2DK\3\2\2\2EF\f\3\2"+
		"\2FG\5\32\16\2GH\5\6\4\4HI\b\4\1\2IK\3\2\2\2J@\3\2\2\2JE\3\2\2\2KN\3\2"+
		"\2\2LJ\3\2\2\2LM\3\2\2\2M\7\3\2\2\2NL\3\2\2\2OP\5\n\6\2PQ\b\5\1\2QY\3"+
		"\2\2\2RS\5\16\b\2ST\b\5\1\2TY\3\2\2\2UV\5\24\13\2VW\b\5\1\2WY\3\2\2\2"+
		"XO\3\2\2\2XR\3\2\2\2XU\3\2\2\2Y\t\3\2\2\2Z[\5\f\7\2[\\\7\f\2\2\\]\5\4"+
		"\3\2]^\7\r\2\2^_\3\2\2\2_`\b\6\1\2`\13\3\2\2\2ab\7\3\2\2bt\b\7\1\2cd\7"+
		"\4\2\2dt\b\7\1\2ef\7\5\2\2ft\b\7\1\2gh\7\6\2\2ht\b\7\1\2ij\7\7\2\2jt\b"+
		"\7\1\2kl\7\b\2\2lt\b\7\1\2mn\7\t\2\2nt\b\7\1\2op\7\n\2\2pt\b\7\1\2qr\7"+
		"\13\2\2rt\b\7\1\2sa\3\2\2\2sc\3\2\2\2se\3\2\2\2sg\3\2\2\2si\3\2\2\2sk"+
		"\3\2\2\2sm\3\2\2\2so\3\2\2\2sq\3\2\2\2t\r\3\2\2\2uv\5\22\n\2vw\b\b\1\2"+
		"w|\3\2\2\2xy\5\20\t\2yz\b\b\1\2z|\3\2\2\2{u\3\2\2\2{x\3\2\2\2|\17\3\2"+
		"\2\2}~\7\f\2\2~\177\7\17\2\2\177\u0080\7\23\2\2\u0080\u0086\7\r\2\2\u0081"+
		"\u0083\7\17\2\2\u0082\u0081\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0084\3"+
		"\2\2\2\u0084\u0086\7\23\2\2\u0085}\3\2\2\2\u0085\u0082\3\2\2\2\u0086\u0087"+
		"\3\2\2\2\u0087\u0088\b\t\1\2\u0088\21\3\2\2\2\u0089\u008a\5\20\t\2\u008a"+
		"\u008b\7\20\2\2\u008b\u008c\5\24\13\2\u008c\u008d\7\22\2\2\u008d\u008e"+
		"\7\23\2\2\u008e\u0098\3\2\2\2\u008f\u0090\t\2\2\2\u0090\u0091\5\20\t\2"+
		"\u0091\u0092\7\20\2\2\u0092\u0093\5\24\13\2\u0093\u0094\7\22\2\2\u0094"+
		"\u0095\7\23\2\2\u0095\u0097\3\2\2\2\u0096\u008f\3\2\2\2\u0097\u009a\3"+
		"\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009b\3\2\2\2\u009a"+
		"\u0098\3\2\2\2\u009b\u009c\b\n\1\2\u009c\23\3\2\2\2\u009d\u009e\7\24\2"+
		"\2\u009e\u009f\b\13\1\2\u009f\25\3\2\2\2\u00a0\u00a1\5\30\r\2\u00a1\u00a2"+
		"\b\f\1\2\u00a2\u00a7\3\2\2\2\u00a3\u00a4\5\32\16\2\u00a4\u00a5\b\f\1\2"+
		"\u00a5\u00a7\3\2\2\2\u00a6\u00a0\3\2\2\2\u00a6\u00a3\3\2\2\2\u00a7\27"+
		"\3\2\2\2\u00a8\u00a9\7\20\2\2\u00a9\u00ad\b\r\1\2\u00aa\u00ab\7\21\2\2"+
		"\u00ab\u00ad\b\r\1\2\u00ac\u00a8\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ad\31"+
		"\3\2\2\2\u00ae\u00af\7\16\2\2\u00af\u00b3\b\16\1\2\u00b0\u00b1\7\17\2"+
		"\2\u00b1\u00b3\b\16\1\2\u00b2\u00ae\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b3"+
		"\33\3\2\2\2\16>JLXs{\u0082\u0085\u0098\u00a6\u00ac\u00b2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}