// Generated from Fonction.g4 by ANTLR 4.4

	package math.fonction.analyse.semantique;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FonctionLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SIN=1, COS=2, TAN=3, CH=4, SH=5, TH=6, EXP=7, LOG=8, LN=9, LBR=10, RBR=11, 
		ADD=12, SUS=13, MUL=14, DIV=15, POW=16, VALUE=17, INCONNUE=18, WS=19;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'"
	};
	public static final String[] ruleNames = {
		"SIN", "COS", "TAN", "CH", "SH", "TH", "EXP", "LOG", "LN", "LBR", "RBR", 
		"ADD", "SUS", "MUL", "DIV", "POW", "VALUE", "INCONNUE", "NameStartChar", 
		"WS"
	};


	public FonctionLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Fonction.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\25u\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4"+
		"\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3"+
		"\t\3\t\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20"+
		"\3\20\3\21\3\21\3\22\6\22[\n\22\r\22\16\22\\\3\22\3\22\7\22a\n\22\f\22"+
		"\16\22d\13\22\5\22f\n\22\3\23\6\23i\n\23\r\23\16\23j\3\24\3\24\3\25\6"+
		"\25p\n\25\r\25\16\25q\3\25\3\25\2\2\26\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\2)\25\3\2\5\3"+
		"\2\62;\4\2C\\c|\5\2\13\f\17\17\"\"x\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2"+
		"\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23"+
		"\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2"+
		"\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2)\3\2\2\2\3+\3\2\2"+
		"\2\5/\3\2\2\2\7\63\3\2\2\2\t\67\3\2\2\2\13:\3\2\2\2\r=\3\2\2\2\17@\3\2"+
		"\2\2\21D\3\2\2\2\23H\3\2\2\2\25K\3\2\2\2\27M\3\2\2\2\31O\3\2\2\2\33Q\3"+
		"\2\2\2\35S\3\2\2\2\37U\3\2\2\2!W\3\2\2\2#Z\3\2\2\2%h\3\2\2\2\'l\3\2\2"+
		"\2)o\3\2\2\2+,\7u\2\2,-\7k\2\2-.\7p\2\2.\4\3\2\2\2/\60\7e\2\2\60\61\7"+
		"q\2\2\61\62\7u\2\2\62\6\3\2\2\2\63\64\7v\2\2\64\65\7c\2\2\65\66\7p\2\2"+
		"\66\b\3\2\2\2\678\7e\2\289\7j\2\29\n\3\2\2\2:;\7u\2\2;<\7j\2\2<\f\3\2"+
		"\2\2=>\7v\2\2>?\7j\2\2?\16\3\2\2\2@A\7g\2\2AB\7z\2\2BC\7r\2\2C\20\3\2"+
		"\2\2DE\7n\2\2EF\7q\2\2FG\7i\2\2G\22\3\2\2\2HI\7n\2\2IJ\7p\2\2J\24\3\2"+
		"\2\2KL\7*\2\2L\26\3\2\2\2MN\7+\2\2N\30\3\2\2\2OP\7-\2\2P\32\3\2\2\2QR"+
		"\7/\2\2R\34\3\2\2\2ST\7,\2\2T\36\3\2\2\2UV\7\61\2\2V \3\2\2\2WX\7`\2\2"+
		"X\"\3\2\2\2Y[\t\2\2\2ZY\3\2\2\2[\\\3\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]e\3\2"+
		"\2\2^b\7\60\2\2_a\t\2\2\2`_\3\2\2\2ad\3\2\2\2b`\3\2\2\2bc\3\2\2\2cf\3"+
		"\2\2\2db\3\2\2\2e^\3\2\2\2ef\3\2\2\2f$\3\2\2\2gi\5\'\24\2hg\3\2\2\2ij"+
		"\3\2\2\2jh\3\2\2\2jk\3\2\2\2k&\3\2\2\2lm\t\3\2\2m(\3\2\2\2np\t\4\2\2o"+
		"n\3\2\2\2pq\3\2\2\2qo\3\2\2\2qr\3\2\2\2rs\3\2\2\2st\b\25\2\2t*\3\2\2\2"+
		"\b\2\\bejq\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}