// Generated from Fool.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FoolParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SEMIC=1, COLON=2, COMMA=3, DOT=4, EQ=5, ASM=6, LT=7, GT=8, LTEQ=9, GTEQ=10, 
		PLUS=11, MINUS=12, TIMES=13, FRACT=14, TRUE=15, FALSE=16, LPAR=17, RPAR=18, 
		CLPAR=19, CRPAR=20, IF=21, THEN=22, ELSE=23, AND=24, OR=25, NOT=26, PRINT=27, 
		LET=28, IN=29, VAR=30, FUN=31, INT=32, BOOL=33, CLASS=34, EXTS=35, NEW=36, 
		NULL=37, INTEGER=38, ID=39, WS=40, LINECOMENTS=41, BLOCKCOMENTS=42, ERR=43;
	public static final int
		RULE_prog = 0, RULE_let = 1, RULE_vardec = 2, RULE_varasm = 3, RULE_fun = 4, 
		RULE_dec = 5, RULE_type = 6, RULE_exp = 7, RULE_term = 8, RULE_stms = 9, 
		RULE_stm = 10, RULE_factor = 11, RULE_value = 12;
	public static final String[] ruleNames = {
		"prog", "let", "vardec", "varasm", "fun", "dec", "type", "exp", "term", 
		"stms", "stm", "factor", "value"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "':'", "','", "'.'", "'=='", "'='", "'<'", "'>'", "'<='", 
		"'>='", "'+'", "'-'", "'*'", "'/'", "'true'", "'false'", "'('", "')'", 
		"'{'", "'}'", "'if'", "'then'", "'else'", "'&&'", "'||'", "'not'", "'print'", 
		"'let'", "'in'", "'var'", "'fun'", "'int'", "'bool'", "'class'", "'extends'", 
		"'new'", "'null'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "SEMIC", "COLON", "COMMA", "DOT", "EQ", "ASM", "LT", "GT", "LTEQ", 
		"GTEQ", "PLUS", "MINUS", "TIMES", "FRACT", "TRUE", "FALSE", "LPAR", "RPAR", 
		"CLPAR", "CRPAR", "IF", "THEN", "ELSE", "AND", "OR", "NOT", "PRINT", "LET", 
		"IN", "VAR", "FUN", "INT", "BOOL", "CLASS", "EXTS", "NEW", "NULL", "INTEGER", 
		"ID", "WS", "LINECOMENTS", "BLOCKCOMENTS", "ERR"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

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

	@Override
	public String getGrammarFileName() { return "Fool.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public FoolParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
	 
		public ProgContext() { }
		public void copyFrom(ProgContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LetInExpContext extends ProgContext {
		public LetContext let() {
			return getRuleContext(LetContext.class,0);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode SEMIC() { return getToken(FoolParser.SEMIC, 0); }
		public LetInExpContext(ProgContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).enterLetInExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).exitLetInExp(this);
		}
	}
	public static class SingleExpContext extends ProgContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode SEMIC() { return getToken(FoolParser.SEMIC, 0); }
		public SingleExpContext(ProgContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).enterSingleExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).exitSingleExp(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			setState(33);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
			case FALSE:
			case LPAR:
			case IF:
			case NOT:
			case NEW:
			case NULL:
			case INTEGER:
			case ID:
				_localctx = new SingleExpContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(26);
				exp();
				setState(27);
				match(SEMIC);
				}
				break;
			case LET:
				_localctx = new LetInExpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(29);
				let();
				setState(30);
				exp();
				setState(31);
				match(SEMIC);
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

	public static class LetContext extends ParserRuleContext {
		public TerminalNode LET() { return getToken(FoolParser.LET, 0); }
		public TerminalNode IN() { return getToken(FoolParser.IN, 0); }
		public List<DecContext> dec() {
			return getRuleContexts(DecContext.class);
		}
		public DecContext dec(int i) {
			return getRuleContext(DecContext.class,i);
		}
		public List<TerminalNode> SEMIC() { return getTokens(FoolParser.SEMIC); }
		public TerminalNode SEMIC(int i) {
			return getToken(FoolParser.SEMIC, i);
		}
		public LetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_let; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).enterLet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).exitLet(this);
		}
	}

	public final LetContext let() throws RecognitionException {
		LetContext _localctx = new LetContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_let);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			match(LET);
			setState(39); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(36);
				dec();
				setState(37);
				match(SEMIC);
				}
				}
				setState(41); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << CLASS) | (1L << ID))) != 0) );
			setState(43);
			match(IN);
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

	public static class VardecContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(FoolParser.ID, 0); }
		public VardecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vardec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).enterVardec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).exitVardec(this);
		}
	}

	public final VardecContext vardec() throws RecognitionException {
		VardecContext _localctx = new VardecContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_vardec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			type();
			setState(46);
			match(ID);
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

	public static class VarasmContext extends ParserRuleContext {
		public VardecContext vardec() {
			return getRuleContext(VardecContext.class,0);
		}
		public TerminalNode ASM() { return getToken(FoolParser.ASM, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public VarasmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varasm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).enterVarasm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).exitVarasm(this);
		}
	}

	public final VarasmContext varasm() throws RecognitionException {
		VarasmContext _localctx = new VarasmContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_varasm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			vardec();
			setState(49);
			match(ASM);
			setState(50);
			exp();
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

	public static class FunContext extends ParserRuleContext {
		public VardecContext vardec;
		public List<VardecContext> elem = new ArrayList<VardecContext>();
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(FoolParser.ID, 0); }
		public TerminalNode LPAR() { return getToken(FoolParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(FoolParser.RPAR, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public LetContext let() {
			return getRuleContext(LetContext.class,0);
		}
		public List<VardecContext> vardec() {
			return getRuleContexts(VardecContext.class);
		}
		public VardecContext vardec(int i) {
			return getRuleContext(VardecContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(FoolParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FoolParser.COMMA, i);
		}
		public FunContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fun; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).enterFun(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).exitFun(this);
		}
	}

	public final FunContext fun() throws RecognitionException {
		FunContext _localctx = new FunContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_fun);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			type();
			setState(53);
			match(ID);
			setState(54);
			match(LPAR);
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << ID))) != 0)) {
				{
				setState(55);
				((FunContext)_localctx).vardec = vardec();
				((FunContext)_localctx).elem.add(((FunContext)_localctx).vardec);
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(56);
					match(COMMA);
					setState(57);
					((FunContext)_localctx).vardec = vardec();
					((FunContext)_localctx).elem.add(((FunContext)_localctx).vardec);
					}
					}
					setState(62);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(65);
			match(RPAR);
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LET) {
				{
				setState(66);
				let();
				}
			}

			setState(69);
			exp();
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

	public static class DecContext extends ParserRuleContext {
		public DecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dec; }
	 
		public DecContext() { }
		public void copyFrom(DecContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VarAssignmentContext extends DecContext {
		public VarasmContext varasm() {
			return getRuleContext(VarasmContext.class,0);
		}
		public VarAssignmentContext(DecContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).enterVarAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).exitVarAssignment(this);
		}
	}
	public static class FunDeclarationContext extends DecContext {
		public FunContext fun() {
			return getRuleContext(FunContext.class,0);
		}
		public FunDeclarationContext(DecContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).enterFunDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).exitFunDeclaration(this);
		}
	}
	public static class ClassDeclarationContext extends DecContext {
		public VardecContext vardec;
		public List<VardecContext> elem = new ArrayList<VardecContext>();
		public TerminalNode CLASS() { return getToken(FoolParser.CLASS, 0); }
		public List<TerminalNode> ID() { return getTokens(FoolParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(FoolParser.ID, i);
		}
		public TerminalNode LPAR() { return getToken(FoolParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(FoolParser.RPAR, 0); }
		public TerminalNode CLPAR() { return getToken(FoolParser.CLPAR, 0); }
		public TerminalNode CRPAR() { return getToken(FoolParser.CRPAR, 0); }
		public TerminalNode EXTS() { return getToken(FoolParser.EXTS, 0); }
		public List<FunContext> fun() {
			return getRuleContexts(FunContext.class);
		}
		public FunContext fun(int i) {
			return getRuleContext(FunContext.class,i);
		}
		public List<TerminalNode> SEMIC() { return getTokens(FoolParser.SEMIC); }
		public TerminalNode SEMIC(int i) {
			return getToken(FoolParser.SEMIC, i);
		}
		public List<VardecContext> vardec() {
			return getRuleContexts(VardecContext.class);
		}
		public VardecContext vardec(int i) {
			return getRuleContext(VardecContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(FoolParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FoolParser.COMMA, i);
		}
		public ClassDeclarationContext(DecContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).enterClassDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).exitClassDeclaration(this);
		}
	}

	public final DecContext dec() throws RecognitionException {
		DecContext _localctx = new DecContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_dec);
		int _la;
		try {
			setState(101);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				_localctx = new VarAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(71);
				varasm();
				}
				break;
			case 2:
				_localctx = new FunDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(72);
				fun();
				}
				break;
			case 3:
				_localctx = new ClassDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(73);
				match(CLASS);
				setState(74);
				match(ID);
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EXTS) {
					{
					setState(75);
					match(EXTS);
					setState(76);
					match(ID);
					}
				}

				setState(79);
				match(LPAR);
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << ID))) != 0)) {
					{
					setState(80);
					((ClassDeclarationContext)_localctx).vardec = vardec();
					((ClassDeclarationContext)_localctx).elem.add(((ClassDeclarationContext)_localctx).vardec);
					setState(85);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(81);
						match(COMMA);
						setState(82);
						((ClassDeclarationContext)_localctx).vardec = vardec();
						((ClassDeclarationContext)_localctx).elem.add(((ClassDeclarationContext)_localctx).vardec);
						}
						}
						setState(87);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(90);
				match(RPAR);
				setState(91);
				match(CLPAR);
				setState(97);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << ID))) != 0)) {
					{
					{
					setState(92);
					fun();
					setState(93);
					match(SEMIC);
					}
					}
					setState(99);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(100);
				match(CRPAR);
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

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(FoolParser.INT, 0); }
		public TerminalNode BOOL() { return getToken(FoolParser.BOOL, 0); }
		public TerminalNode ID() { return getToken(FoolParser.ID, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << ID))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class ExpContext extends ParserRuleContext {
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
	 
		public ExpContext() { }
		public void copyFrom(ExpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BracketedExpContext extends ExpContext {
		public TerminalNode LPAR() { return getToken(FoolParser.LPAR, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(FoolParser.RPAR, 0); }
		public BracketedExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).enterBracketedExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).exitBracketedExp(this);
		}
	}
	public static class ClassInstantiationContext extends ExpContext {
		public VarasmContext varasm;
		public List<VarasmContext> elem = new ArrayList<VarasmContext>();
		public TerminalNode NEW() { return getToken(FoolParser.NEW, 0); }
		public TerminalNode ID() { return getToken(FoolParser.ID, 0); }
		public TerminalNode LPAR() { return getToken(FoolParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(FoolParser.RPAR, 0); }
		public List<VarasmContext> varasm() {
			return getRuleContexts(VarasmContext.class);
		}
		public VarasmContext varasm(int i) {
			return getRuleContext(VarasmContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(FoolParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FoolParser.COMMA, i);
		}
		public ClassInstantiationContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).enterClassInstantiation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).exitClassInstantiation(this);
		}
	}
	public static class BoolExpContext extends ExpContext {
		public ValueContext left;
		public ValueContext right;
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public TerminalNode AND() { return getToken(FoolParser.AND, 0); }
		public TerminalNode OR() { return getToken(FoolParser.OR, 0); }
		public TerminalNode NOT() { return getToken(FoolParser.NOT, 0); }
		public TerminalNode EQ() { return getToken(FoolParser.EQ, 0); }
		public TerminalNode GT() { return getToken(FoolParser.GT, 0); }
		public TerminalNode LT() { return getToken(FoolParser.LT, 0); }
		public TerminalNode GTEQ() { return getToken(FoolParser.GTEQ, 0); }
		public TerminalNode LTEQ() { return getToken(FoolParser.LTEQ, 0); }
		public BoolExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).enterBoolExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).exitBoolExp(this);
		}
	}
	public static class FieldReferenceContext extends ExpContext {
		public List<TerminalNode> ID() { return getTokens(FoolParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(FoolParser.ID, i);
		}
		public TerminalNode DOT() { return getToken(FoolParser.DOT, 0); }
		public FieldReferenceContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).enterFieldReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).exitFieldReference(this);
		}
	}
	public static class NullValueContext extends ExpContext {
		public TerminalNode NULL() { return getToken(FoolParser.NULL, 0); }
		public NullValueContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).enterNullValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).exitNullValue(this);
		}
	}
	public static class IntExpContext extends ExpContext {
		public TermContext left;
		public ExpContext right;
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(FoolParser.PLUS, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(FoolParser.MINUS, 0); }
		public IntExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).enterIntExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).exitIntExp(this);
		}
	}
	public static class MethodCallContext extends ExpContext {
		public VarasmContext varasm;
		public List<VarasmContext> elem = new ArrayList<VarasmContext>();
		public List<TerminalNode> ID() { return getTokens(FoolParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(FoolParser.ID, i);
		}
		public TerminalNode DOT() { return getToken(FoolParser.DOT, 0); }
		public TerminalNode LPAR() { return getToken(FoolParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(FoolParser.RPAR, 0); }
		public List<VarasmContext> varasm() {
			return getRuleContexts(VarasmContext.class);
		}
		public VarasmContext varasm(int i) {
			return getRuleContext(VarasmContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(FoolParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FoolParser.COMMA, i);
		}
		public MethodCallContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).enterMethodCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).exitMethodCall(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		ExpContext _localctx = new ExpContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_exp);
		int _la;
		try {
			setState(184);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				_localctx = new BracketedExpContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(105);
				match(LPAR);
				setState(106);
				exp();
				setState(107);
				match(RPAR);
				}
				break;
			case 2:
				_localctx = new IntExpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(109);
				((IntExpContext)_localctx).left = term();
				setState(112);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PLUS) {
					{
					setState(110);
					match(PLUS);
					setState(111);
					((IntExpContext)_localctx).right = exp();
					}
				}

				}
				break;
			case 3:
				_localctx = new IntExpContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(114);
				((IntExpContext)_localctx).left = term();
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(115);
					match(MINUS);
					setState(116);
					((IntExpContext)_localctx).right = exp();
					}
				}

				}
				break;
			case 4:
				_localctx = new BoolExpContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(119);
				((BoolExpContext)_localctx).left = value();
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AND) {
					{
					setState(120);
					match(AND);
					setState(121);
					((BoolExpContext)_localctx).right = value();
					}
				}

				}
				break;
			case 5:
				_localctx = new BoolExpContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(124);
				((BoolExpContext)_localctx).left = value();
				setState(127);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OR) {
					{
					setState(125);
					match(OR);
					setState(126);
					((BoolExpContext)_localctx).right = value();
					}
				}

				}
				break;
			case 6:
				_localctx = new BoolExpContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(129);
				match(NOT);
				setState(130);
				((BoolExpContext)_localctx).left = value();
				}
				break;
			case 7:
				_localctx = new BoolExpContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(131);
				((BoolExpContext)_localctx).left = value();
				setState(132);
				match(EQ);
				setState(133);
				((BoolExpContext)_localctx).right = value();
				}
				break;
			case 8:
				_localctx = new BoolExpContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(135);
				((BoolExpContext)_localctx).left = value();
				setState(136);
				match(GT);
				setState(137);
				((BoolExpContext)_localctx).right = value();
				}
				break;
			case 9:
				_localctx = new BoolExpContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(139);
				((BoolExpContext)_localctx).left = value();
				setState(140);
				match(LT);
				setState(141);
				((BoolExpContext)_localctx).right = value();
				}
				break;
			case 10:
				_localctx = new BoolExpContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(143);
				((BoolExpContext)_localctx).left = value();
				setState(144);
				match(GTEQ);
				setState(145);
				((BoolExpContext)_localctx).right = value();
				}
				break;
			case 11:
				_localctx = new BoolExpContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(147);
				((BoolExpContext)_localctx).left = value();
				setState(148);
				match(LTEQ);
				setState(149);
				((BoolExpContext)_localctx).right = value();
				}
				break;
			case 12:
				_localctx = new MethodCallContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(151);
				match(ID);
				setState(152);
				match(DOT);
				setState(153);
				match(ID);
				setState(154);
				match(LPAR);
				setState(163);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << ID))) != 0)) {
					{
					setState(155);
					((MethodCallContext)_localctx).varasm = varasm();
					((MethodCallContext)_localctx).elem.add(((MethodCallContext)_localctx).varasm);
					setState(160);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(156);
						match(COMMA);
						setState(157);
						((MethodCallContext)_localctx).varasm = varasm();
						((MethodCallContext)_localctx).elem.add(((MethodCallContext)_localctx).varasm);
						}
						}
						setState(162);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(165);
				match(RPAR);
				}
				break;
			case 13:
				_localctx = new FieldReferenceContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(166);
				match(ID);
				setState(167);
				match(DOT);
				setState(168);
				match(ID);
				}
				break;
			case 14:
				_localctx = new ClassInstantiationContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(169);
				match(NEW);
				setState(170);
				match(ID);
				setState(171);
				match(LPAR);
				setState(180);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << ID))) != 0)) {
					{
					setState(172);
					((ClassInstantiationContext)_localctx).varasm = varasm();
					((ClassInstantiationContext)_localctx).elem.add(((ClassInstantiationContext)_localctx).varasm);
					setState(177);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(173);
						match(COMMA);
						setState(174);
						((ClassInstantiationContext)_localctx).varasm = varasm();
						((ClassInstantiationContext)_localctx).elem.add(((ClassInstantiationContext)_localctx).varasm);
						}
						}
						setState(179);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(182);
				match(RPAR);
				}
				break;
			case 15:
				_localctx = new NullValueContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(183);
				match(NULL);
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

	public static class TermContext extends ParserRuleContext {
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
	 
		public TermContext() { }
		public void copyFrom(TermContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IntTermContext extends TermContext {
		public FactorContext left;
		public TermContext right;
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public TerminalNode TIMES() { return getToken(FoolParser.TIMES, 0); }
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode FRACT() { return getToken(FoolParser.FRACT, 0); }
		public IntTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).enterIntTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).exitIntTerm(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_term);
		int _la;
		try {
			setState(196);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				_localctx = new IntTermContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(186);
				((IntTermContext)_localctx).left = factor();
				setState(189);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==TIMES) {
					{
					setState(187);
					match(TIMES);
					setState(188);
					((IntTermContext)_localctx).right = term();
					}
				}

				}
				break;
			case 2:
				_localctx = new IntTermContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(191);
				((IntTermContext)_localctx).left = factor();
				setState(194);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FRACT) {
					{
					setState(192);
					match(FRACT);
					setState(193);
					((IntTermContext)_localctx).right = term();
					}
				}

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

	public static class StmsContext extends ParserRuleContext {
		public List<StmContext> stm() {
			return getRuleContexts(StmContext.class);
		}
		public StmContext stm(int i) {
			return getRuleContext(StmContext.class,i);
		}
		public StmsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stms; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).enterStms(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).exitStms(this);
		}
	}

	public final StmsContext stms() throws RecognitionException {
		StmsContext _localctx = new StmsContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_stms);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(198);
				stm();
				}
				}
				setState(201); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << INT) | (1L << BOOL) | (1L << ID))) != 0) );
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

	public static class StmContext extends ParserRuleContext {
		public VarasmContext varasm() {
			return getRuleContext(VarasmContext.class,0);
		}
		public TerminalNode IF() { return getToken(FoolParser.IF, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode THEN() { return getToken(FoolParser.THEN, 0); }
		public List<TerminalNode> CLPAR() { return getTokens(FoolParser.CLPAR); }
		public TerminalNode CLPAR(int i) {
			return getToken(FoolParser.CLPAR, i);
		}
		public List<StmsContext> stms() {
			return getRuleContexts(StmsContext.class);
		}
		public StmsContext stms(int i) {
			return getRuleContext(StmsContext.class,i);
		}
		public List<TerminalNode> CRPAR() { return getTokens(FoolParser.CRPAR); }
		public TerminalNode CRPAR(int i) {
			return getToken(FoolParser.CRPAR, i);
		}
		public TerminalNode ELSE() { return getToken(FoolParser.ELSE, 0); }
		public StmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).enterStm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).exitStm(this);
		}
	}

	public final StmContext stm() throws RecognitionException {
		StmContext _localctx = new StmContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_stm);
		try {
			setState(215);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case BOOL:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(203);
				varasm();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(204);
				match(IF);
				setState(205);
				exp();
				setState(206);
				match(THEN);
				setState(207);
				match(CLPAR);
				setState(208);
				stms();
				setState(209);
				match(CRPAR);
				setState(210);
				match(ELSE);
				setState(211);
				match(CLPAR);
				setState(212);
				stms();
				setState(213);
				match(CRPAR);
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

	public static class FactorContext extends ParserRuleContext {
		public ValueContext left;
		public ValueContext right;
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public TerminalNode EQ() { return getToken(FoolParser.EQ, 0); }
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).exitFactor(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_factor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			((FactorContext)_localctx).left = value();
			setState(220);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQ) {
				{
				setState(218);
				match(EQ);
				setState(219);
				((FactorContext)_localctx).right = value();
				}
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

	public static class ValueContext extends ParserRuleContext {
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
	 
		public ValueContext() { }
		public void copyFrom(ValueContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BaseExpContext extends ValueContext {
		public TerminalNode LPAR() { return getToken(FoolParser.LPAR, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(FoolParser.RPAR, 0); }
		public BaseExpContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).enterBaseExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).exitBaseExp(this);
		}
	}
	public static class VarExpContext extends ValueContext {
		public TerminalNode ID() { return getToken(FoolParser.ID, 0); }
		public VarExpContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).enterVarExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).exitVarExp(this);
		}
	}
	public static class IntValContext extends ValueContext {
		public TerminalNode INTEGER() { return getToken(FoolParser.INTEGER, 0); }
		public IntValContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).enterIntVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).exitIntVal(this);
		}
	}
	public static class IfExpContext extends ValueContext {
		public ExpContext cond;
		public ExpContext thenBranch;
		public ExpContext elseBranch;
		public TerminalNode IF() { return getToken(FoolParser.IF, 0); }
		public TerminalNode THEN() { return getToken(FoolParser.THEN, 0); }
		public List<TerminalNode> CLPAR() { return getTokens(FoolParser.CLPAR); }
		public TerminalNode CLPAR(int i) {
			return getToken(FoolParser.CLPAR, i);
		}
		public List<TerminalNode> CRPAR() { return getTokens(FoolParser.CRPAR); }
		public TerminalNode CRPAR(int i) {
			return getToken(FoolParser.CRPAR, i);
		}
		public TerminalNode ELSE() { return getToken(FoolParser.ELSE, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public IfExpContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).enterIfExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).exitIfExp(this);
		}
	}
	public static class BoolValContext extends ValueContext {
		public TerminalNode TRUE() { return getToken(FoolParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(FoolParser.FALSE, 0); }
		public BoolValContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).enterBoolVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).exitBoolVal(this);
		}
	}
	public static class FunExpContext extends ValueContext {
		public TerminalNode ID() { return getToken(FoolParser.ID, 0); }
		public TerminalNode LPAR() { return getToken(FoolParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(FoolParser.RPAR, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(FoolParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FoolParser.COMMA, i);
		}
		public FunExpContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).enterFunExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).exitFunExp(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_value);
		int _la;
		try {
			setState(255);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				_localctx = new IntValContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(222);
				match(INTEGER);
				}
				break;
			case 2:
				_localctx = new BoolValContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(223);
				_la = _input.LA(1);
				if ( !(_la==TRUE || _la==FALSE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 3:
				_localctx = new BaseExpContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(224);
				match(LPAR);
				setState(225);
				exp();
				setState(226);
				match(RPAR);
				}
				break;
			case 4:
				_localctx = new IfExpContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(228);
				match(IF);
				setState(229);
				((IfExpContext)_localctx).cond = exp();
				setState(230);
				match(THEN);
				setState(231);
				match(CLPAR);
				setState(232);
				((IfExpContext)_localctx).thenBranch = exp();
				setState(233);
				match(CRPAR);
				setState(234);
				match(ELSE);
				setState(235);
				match(CLPAR);
				setState(236);
				((IfExpContext)_localctx).elseBranch = exp();
				setState(237);
				match(CRPAR);
				}
				break;
			case 5:
				_localctx = new VarExpContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(239);
				match(ID);
				}
				break;
			case 6:
				_localctx = new FunExpContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(240);
				match(ID);
				setState(253);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LPAR) {
					{
					setState(241);
					match(LPAR);
					setState(250);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << LPAR) | (1L << IF) | (1L << NOT) | (1L << NEW) | (1L << NULL) | (1L << INTEGER) | (1L << ID))) != 0)) {
						{
						setState(242);
						exp();
						setState(247);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(243);
							match(COMMA);
							setState(244);
							exp();
							}
							}
							setState(249);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(252);
					match(RPAR);
					}
				}

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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3-\u0104\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2$\n\2\3\3"+
		"\3\3\3\3\3\3\6\3*\n\3\r\3\16\3+\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\7\6=\n\6\f\6\16\6@\13\6\5\6B\n\6\3\6\3\6\5\6F\n"+
		"\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\5\7P\n\7\3\7\3\7\3\7\3\7\7\7V\n\7\f"+
		"\7\16\7Y\13\7\5\7[\n\7\3\7\3\7\3\7\3\7\3\7\7\7b\n\7\f\7\16\7e\13\7\3\7"+
		"\5\7h\n\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\ts\n\t\3\t\3\t\3\t\5\t"+
		"x\n\t\3\t\3\t\3\t\5\t}\n\t\3\t\3\t\3\t\5\t\u0082\n\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u00a1\n\t\f\t\16\t\u00a4\13\t\5\t\u00a6"+
		"\n\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u00b2\n\t\f\t\16\t\u00b5"+
		"\13\t\5\t\u00b7\n\t\3\t\3\t\5\t\u00bb\n\t\3\n\3\n\3\n\5\n\u00c0\n\n\3"+
		"\n\3\n\3\n\5\n\u00c5\n\n\5\n\u00c7\n\n\3\13\6\13\u00ca\n\13\r\13\16\13"+
		"\u00cb\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00da\n\f\3"+
		"\r\3\r\3\r\5\r\u00df\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\7\16\u00f8\n\16\f\16\16\16\u00fb\13\16\5\16\u00fd\n\16\3\16\5\16\u0100"+
		"\n\16\5\16\u0102\n\16\3\16\2\2\17\2\4\6\b\n\f\16\20\22\24\26\30\32\2\4"+
		"\4\2\"#))\3\2\21\22\2\u0125\2#\3\2\2\2\4%\3\2\2\2\6/\3\2\2\2\b\62\3\2"+
		"\2\2\n\66\3\2\2\2\fg\3\2\2\2\16i\3\2\2\2\20\u00ba\3\2\2\2\22\u00c6\3\2"+
		"\2\2\24\u00c9\3\2\2\2\26\u00d9\3\2\2\2\30\u00db\3\2\2\2\32\u0101\3\2\2"+
		"\2\34\35\5\20\t\2\35\36\7\3\2\2\36$\3\2\2\2\37 \5\4\3\2 !\5\20\t\2!\""+
		"\7\3\2\2\"$\3\2\2\2#\34\3\2\2\2#\37\3\2\2\2$\3\3\2\2\2%)\7\36\2\2&\'\5"+
		"\f\7\2\'(\7\3\2\2(*\3\2\2\2)&\3\2\2\2*+\3\2\2\2+)\3\2\2\2+,\3\2\2\2,-"+
		"\3\2\2\2-.\7\37\2\2.\5\3\2\2\2/\60\5\16\b\2\60\61\7)\2\2\61\7\3\2\2\2"+
		"\62\63\5\6\4\2\63\64\7\b\2\2\64\65\5\20\t\2\65\t\3\2\2\2\66\67\5\16\b"+
		"\2\678\7)\2\28A\7\23\2\29>\5\6\4\2:;\7\5\2\2;=\5\6\4\2<:\3\2\2\2=@\3\2"+
		"\2\2><\3\2\2\2>?\3\2\2\2?B\3\2\2\2@>\3\2\2\2A9\3\2\2\2AB\3\2\2\2BC\3\2"+
		"\2\2CE\7\24\2\2DF\5\4\3\2ED\3\2\2\2EF\3\2\2\2FG\3\2\2\2GH\5\20\t\2H\13"+
		"\3\2\2\2Ih\5\b\5\2Jh\5\n\6\2KL\7$\2\2LO\7)\2\2MN\7%\2\2NP\7)\2\2OM\3\2"+
		"\2\2OP\3\2\2\2PQ\3\2\2\2QZ\7\23\2\2RW\5\6\4\2ST\7\5\2\2TV\5\6\4\2US\3"+
		"\2\2\2VY\3\2\2\2WU\3\2\2\2WX\3\2\2\2X[\3\2\2\2YW\3\2\2\2ZR\3\2\2\2Z[\3"+
		"\2\2\2[\\\3\2\2\2\\]\7\24\2\2]c\7\25\2\2^_\5\n\6\2_`\7\3\2\2`b\3\2\2\2"+
		"a^\3\2\2\2be\3\2\2\2ca\3\2\2\2cd\3\2\2\2df\3\2\2\2ec\3\2\2\2fh\7\26\2"+
		"\2gI\3\2\2\2gJ\3\2\2\2gK\3\2\2\2h\r\3\2\2\2ij\t\2\2\2j\17\3\2\2\2kl\7"+
		"\23\2\2lm\5\20\t\2mn\7\24\2\2n\u00bb\3\2\2\2or\5\22\n\2pq\7\r\2\2qs\5"+
		"\20\t\2rp\3\2\2\2rs\3\2\2\2s\u00bb\3\2\2\2tw\5\22\n\2uv\7\16\2\2vx\5\20"+
		"\t\2wu\3\2\2\2wx\3\2\2\2x\u00bb\3\2\2\2y|\5\32\16\2z{\7\32\2\2{}\5\32"+
		"\16\2|z\3\2\2\2|}\3\2\2\2}\u00bb\3\2\2\2~\u0081\5\32\16\2\177\u0080\7"+
		"\33\2\2\u0080\u0082\5\32\16\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082"+
		"\u00bb\3\2\2\2\u0083\u0084\7\34\2\2\u0084\u00bb\5\32\16\2\u0085\u0086"+
		"\5\32\16\2\u0086\u0087\7\7\2\2\u0087\u0088\5\32\16\2\u0088\u00bb\3\2\2"+
		"\2\u0089\u008a\5\32\16\2\u008a\u008b\7\n\2\2\u008b\u008c\5\32\16\2\u008c"+
		"\u00bb\3\2\2\2\u008d\u008e\5\32\16\2\u008e\u008f\7\t\2\2\u008f\u0090\5"+
		"\32\16\2\u0090\u00bb\3\2\2\2\u0091\u0092\5\32\16\2\u0092\u0093\7\f\2\2"+
		"\u0093\u0094\5\32\16\2\u0094\u00bb\3\2\2\2\u0095\u0096\5\32\16\2\u0096"+
		"\u0097\7\13\2\2\u0097\u0098\5\32\16\2\u0098\u00bb\3\2\2\2\u0099\u009a"+
		"\7)\2\2\u009a\u009b\7\6\2\2\u009b\u009c\7)\2\2\u009c\u00a5\7\23\2\2\u009d"+
		"\u00a2\5\b\5\2\u009e\u009f\7\5\2\2\u009f\u00a1\5\b\5\2\u00a0\u009e\3\2"+
		"\2\2\u00a1\u00a4\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3"+
		"\u00a6\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a5\u009d\3\2\2\2\u00a5\u00a6\3\2"+
		"\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00bb\7\24\2\2\u00a8\u00a9\7)\2\2\u00a9"+
		"\u00aa\7\6\2\2\u00aa\u00bb\7)\2\2\u00ab\u00ac\7&\2\2\u00ac\u00ad\7)\2"+
		"\2\u00ad\u00b6\7\23\2\2\u00ae\u00b3\5\b\5\2\u00af\u00b0\7\5\2\2\u00b0"+
		"\u00b2\5\b\5\2\u00b1\u00af\3\2\2\2\u00b2\u00b5\3\2\2\2\u00b3\u00b1\3\2"+
		"\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b7\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b6"+
		"\u00ae\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00bb\7\24"+
		"\2\2\u00b9\u00bb\7\'\2\2\u00bak\3\2\2\2\u00bao\3\2\2\2\u00bat\3\2\2\2"+
		"\u00bay\3\2\2\2\u00ba~\3\2\2\2\u00ba\u0083\3\2\2\2\u00ba\u0085\3\2\2\2"+
		"\u00ba\u0089\3\2\2\2\u00ba\u008d\3\2\2\2\u00ba\u0091\3\2\2\2\u00ba\u0095"+
		"\3\2\2\2\u00ba\u0099\3\2\2\2\u00ba\u00a8\3\2\2\2\u00ba\u00ab\3\2\2\2\u00ba"+
		"\u00b9\3\2\2\2\u00bb\21\3\2\2\2\u00bc\u00bf\5\30\r\2\u00bd\u00be\7\17"+
		"\2\2\u00be\u00c0\5\22\n\2\u00bf\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0"+
		"\u00c7\3\2\2\2\u00c1\u00c4\5\30\r\2\u00c2\u00c3\7\20\2\2\u00c3\u00c5\5"+
		"\22\n\2\u00c4\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c7\3\2\2\2\u00c6"+
		"\u00bc\3\2\2\2\u00c6\u00c1\3\2\2\2\u00c7\23\3\2\2\2\u00c8\u00ca\5\26\f"+
		"\2\u00c9\u00c8\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cb\u00cc"+
		"\3\2\2\2\u00cc\25\3\2\2\2\u00cd\u00da\5\b\5\2\u00ce\u00cf\7\27\2\2\u00cf"+
		"\u00d0\5\20\t\2\u00d0\u00d1\7\30\2\2\u00d1\u00d2\7\25\2\2\u00d2\u00d3"+
		"\5\24\13\2\u00d3\u00d4\7\26\2\2\u00d4\u00d5\7\31\2\2\u00d5\u00d6\7\25"+
		"\2\2\u00d6\u00d7\5\24\13\2\u00d7\u00d8\7\26\2\2\u00d8\u00da\3\2\2\2\u00d9"+
		"\u00cd\3\2\2\2\u00d9\u00ce\3\2\2\2\u00da\27\3\2\2\2\u00db\u00de\5\32\16"+
		"\2\u00dc\u00dd\7\7\2\2\u00dd\u00df\5\32\16\2\u00de\u00dc\3\2\2\2\u00de"+
		"\u00df\3\2\2\2\u00df\31\3\2\2\2\u00e0\u0102\7(\2\2\u00e1\u0102\t\3\2\2"+
		"\u00e2\u00e3\7\23\2\2\u00e3\u00e4\5\20\t\2\u00e4\u00e5\7\24\2\2\u00e5"+
		"\u0102\3\2\2\2\u00e6\u00e7\7\27\2\2\u00e7\u00e8\5\20\t\2\u00e8\u00e9\7"+
		"\30\2\2\u00e9\u00ea\7\25\2\2\u00ea\u00eb\5\20\t\2\u00eb\u00ec\7\26\2\2"+
		"\u00ec\u00ed\7\31\2\2\u00ed\u00ee\7\25\2\2\u00ee\u00ef\5\20\t\2\u00ef"+
		"\u00f0\7\26\2\2\u00f0\u0102\3\2\2\2\u00f1\u0102\7)\2\2\u00f2\u00ff\7)"+
		"\2\2\u00f3\u00fc\7\23\2\2\u00f4\u00f9\5\20\t\2\u00f5\u00f6\7\5\2\2\u00f6"+
		"\u00f8\5\20\t\2\u00f7\u00f5\3\2\2\2\u00f8\u00fb\3\2\2\2\u00f9\u00f7\3"+
		"\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00fd\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fc"+
		"\u00f4\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\u0100\7\24"+
		"\2\2\u00ff\u00f3\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\u0102\3\2\2\2\u0101"+
		"\u00e0\3\2\2\2\u0101\u00e1\3\2\2\2\u0101\u00e2\3\2\2\2\u0101\u00e6\3\2"+
		"\2\2\u0101\u00f1\3\2\2\2\u0101\u00f2\3\2\2\2\u0102\33\3\2\2\2\37#+>AE"+
		"OWZcgrw|\u0081\u00a2\u00a5\u00b3\u00b6\u00ba\u00bf\u00c4\u00c6\u00cb\u00d9"+
		"\u00de\u00f9\u00fc\u00ff\u0101";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}