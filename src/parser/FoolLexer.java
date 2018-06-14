// Generated from Fool.g4 by ANTLR 4.7.1
package parser;
    import java.util.ArrayList;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FoolLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SEMIC=1, COLON=2, COMMA=3, DOT=4, EQ=5, ASM=6, LT=7, GT=8, LTEQ=9, GTEQ=10, 
		PLUS=11, MINUS=12, TIMES=13, FRACT=14, TRUE=15, FALSE=16, LPAR=17, RPAR=18, 
		CLPAR=19, CRPAR=20, IF=21, THEN=22, ELSE=23, AND=24, OR=25, NOT=26, PRINT=27, 
		LET=28, IN=29, VAR=30, FUN=31, INT=32, BOOL=33, CLASS=34, EXTS=35, NEW=36, 
		NULL=37, VOID=38, INTEGER=39, ID=40, WS=41, LINECOMENTS=42, BLOCKCOMENTS=43, 
		ERR=44;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"SEMIC", "COLON", "COMMA", "DOT", "EQ", "ASM", "LT", "GT", "LTEQ", "GTEQ", 
		"PLUS", "MINUS", "TIMES", "FRACT", "TRUE", "FALSE", "LPAR", "RPAR", "CLPAR", 
		"CRPAR", "IF", "THEN", "ELSE", "AND", "OR", "NOT", "PRINT", "LET", "IN", 
		"VAR", "FUN", "INT", "BOOL", "CLASS", "EXTS", "NEW", "NULL", "VOID", "DIGIT", 
		"INTEGER", "CHAR", "ID", "WS", "LINECOMENTS", "BLOCKCOMENTS", "ERR"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "':'", "','", "'.'", "'=='", "'='", "'<'", "'>'", "'<='", 
		"'>='", "'+'", "'-'", "'*'", "'/'", "'true'", "'false'", "'('", "')'", 
		"'{'", "'}'", "'if'", "'then'", "'else'", "'&&'", "'||'", "'not'", "'print'", 
		"'let'", "'in'", "'var'", "'fun'", "'int'", "'bool'", "'class'", "'extends'", 
		"'new'", "'null'", "'void'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "SEMIC", "COLON", "COMMA", "DOT", "EQ", "ASM", "LT", "GT", "LTEQ", 
		"GTEQ", "PLUS", "MINUS", "TIMES", "FRACT", "TRUE", "FALSE", "LPAR", "RPAR", 
		"CLPAR", "CRPAR", "IF", "THEN", "ELSE", "AND", "OR", "NOT", "PRINT", "LET", 
		"IN", "VAR", "FUN", "INT", "BOOL", "CLASS", "EXTS", "NEW", "NULL", "VOID", 
		"INTEGER", "ID", "WS", "LINECOMENTS", "BLOCKCOMENTS", "ERR"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);
	private int lexicalErrors=0;

  	public int getLexicalErrors(){return lexicalErrors;}
	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	   public ArrayList<String> errors = new ArrayList<>();


	public FoolLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Fool.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 45:
			ERR_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void ERR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			 System.out.println("Invalid char: "+ getText()); lexicalErrors++; 
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2.\u011a\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\7"+
		"\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3"+
		"\16\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3"+
		"\27\3\27\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3"+
		"\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\36\3"+
		"\36\3\36\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3!\3!\3!\3!\3\"\3\"\3\"\3\"\3"+
		"\"\3#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3&\3&\3&\3&\3"+
		"&\3\'\3\'\3\'\3\'\3\'\3(\3(\3)\6)\u00e6\n)\r)\16)\u00e7\3*\3*\3+\3+\3"+
		"+\7+\u00ef\n+\f+\16+\u00f2\13+\3,\3,\3,\3,\3-\3-\3-\3-\7-\u00fc\n-\f-"+
		"\16-\u00ff\13-\3-\3-\3.\3.\3.\3.\3.\3.\3.\3.\3.\7.\u010c\n.\f.\16.\u010f"+
		"\13.\3.\3.\3.\3.\3.\3/\3/\3/\3/\3/\2\2\60\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+"+
		"\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O\2Q)S"+
		"\2U*W+Y,[-].\3\2\b\4\2C\\c|\5\2\13\f\17\17\"\"\4\2\f\f\17\17\4\2,,\61"+
		"\61\3\2,,\3\2\61\61\2\u011f\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3"+
		"\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2"+
		"\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37"+
		"\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3"+
		"\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2"+
		"\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C"+
		"\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2Q\3\2"+
		"\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\3_\3\2\2\2"+
		"\5a\3\2\2\2\7c\3\2\2\2\te\3\2\2\2\13g\3\2\2\2\rj\3\2\2\2\17l\3\2\2\2\21"+
		"n\3\2\2\2\23p\3\2\2\2\25s\3\2\2\2\27v\3\2\2\2\31x\3\2\2\2\33z\3\2\2\2"+
		"\35|\3\2\2\2\37~\3\2\2\2!\u0083\3\2\2\2#\u0089\3\2\2\2%\u008b\3\2\2\2"+
		"\'\u008d\3\2\2\2)\u008f\3\2\2\2+\u0091\3\2\2\2-\u0094\3\2\2\2/\u0099\3"+
		"\2\2\2\61\u009e\3\2\2\2\63\u00a1\3\2\2\2\65\u00a4\3\2\2\2\67\u00a8\3\2"+
		"\2\29\u00ae\3\2\2\2;\u00b2\3\2\2\2=\u00b5\3\2\2\2?\u00b9\3\2\2\2A\u00bd"+
		"\3\2\2\2C\u00c1\3\2\2\2E\u00c6\3\2\2\2G\u00cc\3\2\2\2I\u00d4\3\2\2\2K"+
		"\u00d8\3\2\2\2M\u00dd\3\2\2\2O\u00e2\3\2\2\2Q\u00e5\3\2\2\2S\u00e9\3\2"+
		"\2\2U\u00eb\3\2\2\2W\u00f3\3\2\2\2Y\u00f7\3\2\2\2[\u0102\3\2\2\2]\u0115"+
		"\3\2\2\2_`\7=\2\2`\4\3\2\2\2ab\7<\2\2b\6\3\2\2\2cd\7.\2\2d\b\3\2\2\2e"+
		"f\7\60\2\2f\n\3\2\2\2gh\7?\2\2hi\7?\2\2i\f\3\2\2\2jk\7?\2\2k\16\3\2\2"+
		"\2lm\7>\2\2m\20\3\2\2\2no\7@\2\2o\22\3\2\2\2pq\7>\2\2qr\7?\2\2r\24\3\2"+
		"\2\2st\7@\2\2tu\7?\2\2u\26\3\2\2\2vw\7-\2\2w\30\3\2\2\2xy\7/\2\2y\32\3"+
		"\2\2\2z{\7,\2\2{\34\3\2\2\2|}\7\61\2\2}\36\3\2\2\2~\177\7v\2\2\177\u0080"+
		"\7t\2\2\u0080\u0081\7w\2\2\u0081\u0082\7g\2\2\u0082 \3\2\2\2\u0083\u0084"+
		"\7h\2\2\u0084\u0085\7c\2\2\u0085\u0086\7n\2\2\u0086\u0087\7u\2\2\u0087"+
		"\u0088\7g\2\2\u0088\"\3\2\2\2\u0089\u008a\7*\2\2\u008a$\3\2\2\2\u008b"+
		"\u008c\7+\2\2\u008c&\3\2\2\2\u008d\u008e\7}\2\2\u008e(\3\2\2\2\u008f\u0090"+
		"\7\177\2\2\u0090*\3\2\2\2\u0091\u0092\7k\2\2\u0092\u0093\7h\2\2\u0093"+
		",\3\2\2\2\u0094\u0095\7v\2\2\u0095\u0096\7j\2\2\u0096\u0097\7g\2\2\u0097"+
		"\u0098\7p\2\2\u0098.\3\2\2\2\u0099\u009a\7g\2\2\u009a\u009b\7n\2\2\u009b"+
		"\u009c\7u\2\2\u009c\u009d\7g\2\2\u009d\60\3\2\2\2\u009e\u009f\7(\2\2\u009f"+
		"\u00a0\7(\2\2\u00a0\62\3\2\2\2\u00a1\u00a2\7~\2\2\u00a2\u00a3\7~\2\2\u00a3"+
		"\64\3\2\2\2\u00a4\u00a5\7p\2\2\u00a5\u00a6\7q\2\2\u00a6\u00a7\7v\2\2\u00a7"+
		"\66\3\2\2\2\u00a8\u00a9\7r\2\2\u00a9\u00aa\7t\2\2\u00aa\u00ab\7k\2\2\u00ab"+
		"\u00ac\7p\2\2\u00ac\u00ad\7v\2\2\u00ad8\3\2\2\2\u00ae\u00af\7n\2\2\u00af"+
		"\u00b0\7g\2\2\u00b0\u00b1\7v\2\2\u00b1:\3\2\2\2\u00b2\u00b3\7k\2\2\u00b3"+
		"\u00b4\7p\2\2\u00b4<\3\2\2\2\u00b5\u00b6\7x\2\2\u00b6\u00b7\7c\2\2\u00b7"+
		"\u00b8\7t\2\2\u00b8>\3\2\2\2\u00b9\u00ba\7h\2\2\u00ba\u00bb\7w\2\2\u00bb"+
		"\u00bc\7p\2\2\u00bc@\3\2\2\2\u00bd\u00be\7k\2\2\u00be\u00bf\7p\2\2\u00bf"+
		"\u00c0\7v\2\2\u00c0B\3\2\2\2\u00c1\u00c2\7d\2\2\u00c2\u00c3\7q\2\2\u00c3"+
		"\u00c4\7q\2\2\u00c4\u00c5\7n\2\2\u00c5D\3\2\2\2\u00c6\u00c7\7e\2\2\u00c7"+
		"\u00c8\7n\2\2\u00c8\u00c9\7c\2\2\u00c9\u00ca\7u\2\2\u00ca\u00cb\7u\2\2"+
		"\u00cbF\3\2\2\2\u00cc\u00cd\7g\2\2\u00cd\u00ce\7z\2\2\u00ce\u00cf\7v\2"+
		"\2\u00cf\u00d0\7g\2\2\u00d0\u00d1\7p\2\2\u00d1\u00d2\7f\2\2\u00d2\u00d3"+
		"\7u\2\2\u00d3H\3\2\2\2\u00d4\u00d5\7p\2\2\u00d5\u00d6\7g\2\2\u00d6\u00d7"+
		"\7y\2\2\u00d7J\3\2\2\2\u00d8\u00d9\7p\2\2\u00d9\u00da\7w\2\2\u00da\u00db"+
		"\7n\2\2\u00db\u00dc\7n\2\2\u00dcL\3\2\2\2\u00dd\u00de\7x\2\2\u00de\u00df"+
		"\7q\2\2\u00df\u00e0\7k\2\2\u00e0\u00e1\7f\2\2\u00e1N\3\2\2\2\u00e2\u00e3"+
		"\4\62;\2\u00e3P\3\2\2\2\u00e4\u00e6\5O(\2\u00e5\u00e4\3\2\2\2\u00e6\u00e7"+
		"\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8R\3\2\2\2\u00e9"+
		"\u00ea\t\2\2\2\u00eaT\3\2\2\2\u00eb\u00f0\5S*\2\u00ec\u00ef\5S*\2\u00ed"+
		"\u00ef\5O(\2\u00ee\u00ec\3\2\2\2\u00ee\u00ed\3\2\2\2\u00ef\u00f2\3\2\2"+
		"\2\u00f0\u00ee\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1V\3\2\2\2\u00f2\u00f0"+
		"\3\2\2\2\u00f3\u00f4\t\3\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00f6\b,\2\2\u00f6"+
		"X\3\2\2\2\u00f7\u00f8\7\61\2\2\u00f8\u00f9\7\61\2\2\u00f9\u00fd\3\2\2"+
		"\2\u00fa\u00fc\n\4\2\2\u00fb\u00fa\3\2\2\2\u00fc\u00ff\3\2\2\2\u00fd\u00fb"+
		"\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\u0100\3\2\2\2\u00ff\u00fd\3\2\2\2\u0100"+
		"\u0101\b-\2\2\u0101Z\3\2\2\2\u0102\u0103\7\61\2\2\u0103\u0104\7,\2\2\u0104"+
		"\u010d\3\2\2\2\u0105\u010c\n\5\2\2\u0106\u0107\7\61\2\2\u0107\u010c\n"+
		"\6\2\2\u0108\u0109\7,\2\2\u0109\u010c\n\7\2\2\u010a\u010c\5[.\2\u010b"+
		"\u0105\3\2\2\2\u010b\u0106\3\2\2\2\u010b\u0108\3\2\2\2\u010b\u010a\3\2"+
		"\2\2\u010c\u010f\3\2\2\2\u010d\u010b\3\2\2\2\u010d\u010e\3\2\2\2\u010e"+
		"\u0110\3\2\2\2\u010f\u010d\3\2\2\2\u0110\u0111\7,\2\2\u0111\u0112\7\61"+
		"\2\2\u0112\u0113\3\2\2\2\u0113\u0114\b.\2\2\u0114\\\3\2\2\2\u0115\u0116"+
		"\13\2\2\2\u0116\u0117\b/\3\2\u0117\u0118\3\2\2\2\u0118\u0119\b/\4\2\u0119"+
		"^\3\2\2\2\t\2\u00e7\u00ee\u00f0\u00fd\u010b\u010d\5\b\2\2\3/\2\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}