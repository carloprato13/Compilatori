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
		NULL=37, VOID=38, INTEGER=39, ID=40, WS=41, LINECOMENTS=42, BLOCKCOMENTS=43, 
		ERR=44;
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
			case INT:
			case BOOL:
			case NEW:
			case NULL:
			case VOID:
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
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << CLASS) | (1L << VOID) | (1L << ID))) != 0) );
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
		public TypeContext t;
		public Token name;
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
			((VardecContext)_localctx).t = type();
			setState(46);
			((VardecContext)_localctx).name = match(ID);
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
		public VarasmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varasm; }
	 
		public VarasmContext() { }
		public void copyFrom(VarasmContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FieldAsmContext extends VarasmContext {
		public Token t;
		public Token f;
		public ExpContext e;
		public TerminalNode DOT() { return getToken(FoolParser.DOT, 0); }
		public TerminalNode ASM() { return getToken(FoolParser.ASM, 0); }
		public List<TerminalNode> ID() { return getTokens(FoolParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(FoolParser.ID, i);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public FieldAsmContext(VarasmContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).enterFieldAsm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).exitFieldAsm(this);
		}
	}
	public static class DecAsmContext extends VarasmContext {
		public VardecContext t;
		public ExpContext e;
		public TerminalNode ASM() { return getToken(FoolParser.ASM, 0); }
		public VardecContext vardec() {
			return getRuleContext(VardecContext.class,0);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public DecAsmContext(VarasmContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).enterDecAsm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).exitDecAsm(this);
		}
	}
	public static class AsmContext extends VarasmContext {
		public Token t;
		public ExpContext e;
		public TerminalNode ASM() { return getToken(FoolParser.ASM, 0); }
		public TerminalNode ID() { return getToken(FoolParser.ID, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public AsmContext(VarasmContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).enterAsm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).exitAsm(this);
		}
	}

	public final VarasmContext varasm() throws RecognitionException {
		VarasmContext _localctx = new VarasmContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_varasm);
		try {
			setState(60);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new DecAsmContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(48);
				((DecAsmContext)_localctx).t = vardec();
				setState(49);
				match(ASM);
				setState(50);
				((DecAsmContext)_localctx).e = exp();
				}
				break;
			case 2:
				_localctx = new AsmContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(52);
				((AsmContext)_localctx).t = match(ID);
				setState(53);
				match(ASM);
				setState(54);
				((AsmContext)_localctx).e = exp();
				}
				break;
			case 3:
				_localctx = new FieldAsmContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(55);
				((FieldAsmContext)_localctx).t = match(ID);
				setState(56);
				match(DOT);
				setState(57);
				((FieldAsmContext)_localctx).f = match(ID);
				setState(58);
				match(ASM);
				setState(59);
				((FieldAsmContext)_localctx).e = exp();
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
			setState(62);
			type();
			setState(63);
			match(ID);
			setState(64);
			match(LPAR);
			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << VOID) | (1L << ID))) != 0)) {
				{
				setState(65);
				((FunContext)_localctx).vardec = vardec();
				((FunContext)_localctx).elem.add(((FunContext)_localctx).vardec);
				setState(70);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(66);
					match(COMMA);
					setState(67);
					((FunContext)_localctx).vardec = vardec();
					((FunContext)_localctx).elem.add(((FunContext)_localctx).vardec);
					}
					}
					setState(72);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(75);
			match(RPAR);
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LET) {
				{
				setState(76);
				let();
				}
			}

			setState(79);
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
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
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
			setState(112);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				_localctx = new VarAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(81);
				varasm();
				}
				break;
			case 2:
				_localctx = new FunDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(82);
				fun();
				}
				break;
			case 3:
				_localctx = new ClassDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(83);
				match(CLASS);
				setState(84);
				type();
				setState(87);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EXTS) {
					{
					setState(85);
					match(EXTS);
					setState(86);
					type();
					}
				}

				setState(89);
				match(LPAR);
				setState(98);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << VOID) | (1L << ID))) != 0)) {
					{
					setState(90);
					((ClassDeclarationContext)_localctx).vardec = vardec();
					((ClassDeclarationContext)_localctx).elem.add(((ClassDeclarationContext)_localctx).vardec);
					setState(95);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(91);
						match(COMMA);
						setState(92);
						((ClassDeclarationContext)_localctx).vardec = vardec();
						((ClassDeclarationContext)_localctx).elem.add(((ClassDeclarationContext)_localctx).vardec);
						}
						}
						setState(97);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(100);
				match(RPAR);
				setState(101);
				match(CLPAR);
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << VOID) | (1L << ID))) != 0)) {
					{
					{
					setState(102);
					fun();
					setState(103);
					match(SEMIC);
					}
					}
					setState(109);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(110);
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
		public TerminalNode VOID() { return getToken(FoolParser.VOID, 0); }
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
			setState(114);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << VOID) | (1L << ID))) != 0)) ) {
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
	public static class IfThenElseContext extends ExpContext {
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
		public IfThenElseContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).enterIfThenElse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).exitIfThenElse(this);
		}
	}
	public static class ClassInstantiationContext extends ExpContext {
		public StmContext stm;
		public List<StmContext> elem = new ArrayList<StmContext>();
		public TerminalNode NEW() { return getToken(FoolParser.NEW, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(FoolParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(FoolParser.RPAR, 0); }
		public List<StmContext> stm() {
			return getRuleContexts(StmContext.class);
		}
		public StmContext stm(int i) {
			return getRuleContext(StmContext.class,i);
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
	public static class StatementContext extends ExpContext {
		public StmsContext stms() {
			return getRuleContext(StmsContext.class,0);
		}
		public StatementContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).exitStatement(this);
		}
	}
	public static class BoolExpContext extends ExpContext {
		public TermContext left;
		public ExpContext right;
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode AND() { return getToken(FoolParser.AND, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode OR() { return getToken(FoolParser.OR, 0); }
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

	public final ExpContext exp() throws RecognitionException {
		ExpContext _localctx = new ExpContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_exp);
		int _la;
		try {
			setState(163);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				_localctx = new IntExpContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(116);
				((IntExpContext)_localctx).left = term();
				setState(119);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PLUS) {
					{
					setState(117);
					match(PLUS);
					setState(118);
					((IntExpContext)_localctx).right = exp();
					}
				}

				}
				break;
			case 2:
				_localctx = new IntExpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(121);
				((IntExpContext)_localctx).left = term();
				setState(124);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(122);
					match(MINUS);
					setState(123);
					((IntExpContext)_localctx).right = exp();
					}
				}

				}
				break;
			case 3:
				_localctx = new BoolExpContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(126);
				((BoolExpContext)_localctx).left = term();
				setState(129);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AND) {
					{
					setState(127);
					match(AND);
					setState(128);
					((BoolExpContext)_localctx).right = exp();
					}
				}

				}
				break;
			case 4:
				_localctx = new BoolExpContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(131);
				((BoolExpContext)_localctx).left = term();
				setState(134);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OR) {
					{
					setState(132);
					match(OR);
					setState(133);
					((BoolExpContext)_localctx).right = exp();
					}
				}

				}
				break;
			case 5:
				_localctx = new ClassInstantiationContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(136);
				match(NEW);
				setState(137);
				type();
				setState(138);
				match(LPAR);
				setState(147);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << INT) | (1L << BOOL) | (1L << VOID) | (1L << ID))) != 0)) {
					{
					setState(139);
					((ClassInstantiationContext)_localctx).stm = stm();
					((ClassInstantiationContext)_localctx).elem.add(((ClassInstantiationContext)_localctx).stm);
					setState(144);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(140);
						match(COMMA);
						setState(141);
						((ClassInstantiationContext)_localctx).stm = stm();
						((ClassInstantiationContext)_localctx).elem.add(((ClassInstantiationContext)_localctx).stm);
						}
						}
						setState(146);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(149);
				match(RPAR);
				}
				break;
			case 6:
				_localctx = new StatementContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(151);
				stms();
				}
				break;
			case 7:
				_localctx = new IfThenElseContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(152);
				match(IF);
				setState(153);
				((IfThenElseContext)_localctx).cond = exp();
				setState(154);
				match(THEN);
				setState(155);
				match(CLPAR);
				setState(156);
				((IfThenElseContext)_localctx).thenBranch = exp();
				setState(157);
				match(CRPAR);
				setState(158);
				match(ELSE);
				setState(159);
				match(CLPAR);
				setState(160);
				((IfThenElseContext)_localctx).elseBranch = exp();
				setState(161);
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

	public static class TermContext extends ParserRuleContext {
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
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).exitTerm(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_term);
		int _la;
		try {
			setState(175);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(165);
				((TermContext)_localctx).left = factor();
				setState(168);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==TIMES) {
					{
					setState(166);
					match(TIMES);
					setState(167);
					((TermContext)_localctx).right = term();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(170);
				((TermContext)_localctx).left = factor();
				setState(173);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FRACT) {
					{
					setState(171);
					match(FRACT);
					setState(172);
					((TermContext)_localctx).right = term();
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
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(178); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(177);
					stm();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(180); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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
			setState(194);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case BOOL:
			case VOID:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(182);
				varasm();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(183);
				match(IF);
				setState(184);
				exp();
				setState(185);
				match(THEN);
				setState(186);
				match(CLPAR);
				setState(187);
				stms();
				setState(188);
				match(CRPAR);
				setState(189);
				match(ELSE);
				setState(190);
				match(CLPAR);
				setState(191);
				stms();
				setState(192);
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
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
	 
		public FactorContext() { }
		public void copyFrom(FactorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IntBoolFactorContext extends FactorContext {
		public ValueContext left;
		public ValueContext right;
		public TerminalNode GT() { return getToken(FoolParser.GT, 0); }
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public TerminalNode LT() { return getToken(FoolParser.LT, 0); }
		public TerminalNode GTEQ() { return getToken(FoolParser.GTEQ, 0); }
		public TerminalNode LTEQ() { return getToken(FoolParser.LTEQ, 0); }
		public IntBoolFactorContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).enterIntBoolFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).exitIntBoolFactor(this);
		}
	}
	public static class ValFactorContext extends FactorContext {
		public ValueContext left;
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public ValFactorContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).enterValFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).exitValFactor(this);
		}
	}
	public static class BoolFactorContext extends FactorContext {
		public ValueContext left;
		public ValueContext right;
		public TerminalNode EQ() { return getToken(FoolParser.EQ, 0); }
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public BoolFactorContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).enterBoolFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).exitBoolFactor(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_factor);
		try {
			setState(217);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				_localctx = new BoolFactorContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(196);
				((BoolFactorContext)_localctx).left = value();
				setState(197);
				match(EQ);
				setState(198);
				((BoolFactorContext)_localctx).right = value();
				}
				break;
			case 2:
				_localctx = new IntBoolFactorContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(200);
				((IntBoolFactorContext)_localctx).left = value();
				setState(201);
				match(GT);
				setState(202);
				((IntBoolFactorContext)_localctx).right = value();
				}
				break;
			case 3:
				_localctx = new IntBoolFactorContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(204);
				((IntBoolFactorContext)_localctx).left = value();
				setState(205);
				match(LT);
				setState(206);
				((IntBoolFactorContext)_localctx).right = value();
				}
				break;
			case 4:
				_localctx = new IntBoolFactorContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(208);
				((IntBoolFactorContext)_localctx).left = value();
				setState(209);
				match(GTEQ);
				setState(210);
				((IntBoolFactorContext)_localctx).right = value();
				}
				break;
			case 5:
				_localctx = new IntBoolFactorContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(212);
				((IntBoolFactorContext)_localctx).left = value();
				setState(213);
				match(LTEQ);
				setState(214);
				((IntBoolFactorContext)_localctx).right = value();
				}
				break;
			case 6:
				_localctx = new ValFactorContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(216);
				((ValFactorContext)_localctx).left = value();
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
	public static class FuncallContext extends ValueContext {
		public Token name;
		public ExpContext exp;
		public List<ExpContext> elem = new ArrayList<ExpContext>();
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
		public FuncallContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).enterFuncall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).exitFuncall(this);
		}
	}
	public static class NullValContext extends ValueContext {
		public TerminalNode NULL() { return getToken(FoolParser.NULL, 0); }
		public NullValContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).enterNullVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).exitNullVal(this);
		}
	}
	public static class FieldValContext extends ValueContext {
		public List<TerminalNode> ID() { return getTokens(FoolParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(FoolParser.ID, i);
		}
		public TerminalNode DOT() { return getToken(FoolParser.DOT, 0); }
		public FieldValContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).enterFieldVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).exitFieldVal(this);
		}
	}
	public static class BoolValContext extends ValueContext {
		public TerminalNode TRUE() { return getToken(FoolParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(FoolParser.FALSE, 0); }
		public TerminalNode NOT() { return getToken(FoolParser.NOT, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
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
	public static class BaseValContext extends ValueContext {
		public TerminalNode LPAR() { return getToken(FoolParser.LPAR, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(FoolParser.RPAR, 0); }
		public BaseValContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).enterBaseVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).exitBaseVal(this);
		}
	}
	public static class VarValContext extends ValueContext {
		public TerminalNode ID() { return getToken(FoolParser.ID, 0); }
		public VarValContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).enterVarVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).exitVarVal(this);
		}
	}
	public static class MethodCallContext extends ValueContext {
		public ExpContext exp;
		public List<ExpContext> elem = new ArrayList<ExpContext>();
		public List<TerminalNode> ID() { return getTokens(FoolParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(FoolParser.ID, i);
		}
		public TerminalNode DOT() { return getToken(FoolParser.DOT, 0); }
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
		public MethodCallContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).enterMethodCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FoolListener ) ((FoolListener)listener).exitMethodCall(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_value);
		int _la;
		try {
			setState(262);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				_localctx = new IntValContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(219);
				match(INTEGER);
				}
				break;
			case 2:
				_localctx = new BoolValContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(220);
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
				_localctx = new VarValContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(221);
				match(ID);
				}
				break;
			case 4:
				_localctx = new FuncallContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(222);
				((FuncallContext)_localctx).name = match(ID);
				setState(235);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LPAR) {
					{
					setState(223);
					match(LPAR);
					setState(232);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << LPAR) | (1L << IF) | (1L << NOT) | (1L << INT) | (1L << BOOL) | (1L << NEW) | (1L << NULL) | (1L << VOID) | (1L << INTEGER) | (1L << ID))) != 0)) {
						{
						setState(224);
						((FuncallContext)_localctx).exp = exp();
						((FuncallContext)_localctx).elem.add(((FuncallContext)_localctx).exp);
						setState(229);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(225);
							match(COMMA);
							setState(226);
							((FuncallContext)_localctx).exp = exp();
							((FuncallContext)_localctx).elem.add(((FuncallContext)_localctx).exp);
							}
							}
							setState(231);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(234);
					match(RPAR);
					}
				}

				}
				break;
			case 5:
				_localctx = new NullValContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(237);
				match(NULL);
				}
				break;
			case 6:
				_localctx = new BoolValContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(238);
				match(NOT);
				setState(239);
				value();
				}
				break;
			case 7:
				_localctx = new FieldValContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(240);
				match(ID);
				setState(241);
				match(DOT);
				setState(242);
				match(ID);
				}
				break;
			case 8:
				_localctx = new MethodCallContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(243);
				match(ID);
				setState(244);
				match(DOT);
				setState(245);
				match(ID);
				setState(246);
				match(LPAR);
				setState(255);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << LPAR) | (1L << IF) | (1L << NOT) | (1L << INT) | (1L << BOOL) | (1L << NEW) | (1L << NULL) | (1L << VOID) | (1L << INTEGER) | (1L << ID))) != 0)) {
					{
					setState(247);
					((MethodCallContext)_localctx).exp = exp();
					((MethodCallContext)_localctx).elem.add(((MethodCallContext)_localctx).exp);
					setState(252);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(248);
						match(COMMA);
						setState(249);
						((MethodCallContext)_localctx).exp = exp();
						((MethodCallContext)_localctx).elem.add(((MethodCallContext)_localctx).exp);
						}
						}
						setState(254);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(257);
				match(RPAR);
				}
				break;
			case 9:
				_localctx = new BaseValContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(258);
				match(LPAR);
				setState(259);
				exp();
				setState(260);
				match(RPAR);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3.\u010b\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2$\n\2\3\3"+
		"\3\3\3\3\3\3\6\3*\n\3\r\3\16\3+\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5?\n\5\3\6\3\6\3\6\3\6\3\6\3\6\7\6G\n"+
		"\6\f\6\16\6J\13\6\5\6L\n\6\3\6\3\6\5\6P\n\6\3\6\3\6\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\5\7Z\n\7\3\7\3\7\3\7\3\7\7\7`\n\7\f\7\16\7c\13\7\5\7e\n\7\3\7\3"+
		"\7\3\7\3\7\3\7\7\7l\n\7\f\7\16\7o\13\7\3\7\3\7\5\7s\n\7\3\b\3\b\3\t\3"+
		"\t\3\t\5\tz\n\t\3\t\3\t\3\t\5\t\177\n\t\3\t\3\t\3\t\5\t\u0084\n\t\3\t"+
		"\3\t\3\t\5\t\u0089\n\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u0091\n\t\f\t\16\t"+
		"\u0094\13\t\5\t\u0096\n\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\5\t\u00a6\n\t\3\n\3\n\3\n\5\n\u00ab\n\n\3\n\3\n\3\n\5\n\u00b0"+
		"\n\n\5\n\u00b2\n\n\3\13\6\13\u00b5\n\13\r\13\16\13\u00b6\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00c5\n\f\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00dc"+
		"\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u00e6\n\16\f\16\16\16"+
		"\u00e9\13\16\5\16\u00eb\n\16\3\16\5\16\u00ee\n\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u00fd\n\16\f\16\16"+
		"\16\u0100\13\16\5\16\u0102\n\16\3\16\3\16\3\16\3\16\3\16\5\16\u0109\n"+
		"\16\3\16\2\2\17\2\4\6\b\n\f\16\20\22\24\26\30\32\2\4\5\2\"#((**\3\2\21"+
		"\22\2\u012d\2#\3\2\2\2\4%\3\2\2\2\6/\3\2\2\2\b>\3\2\2\2\n@\3\2\2\2\fr"+
		"\3\2\2\2\16t\3\2\2\2\20\u00a5\3\2\2\2\22\u00b1\3\2\2\2\24\u00b4\3\2\2"+
		"\2\26\u00c4\3\2\2\2\30\u00db\3\2\2\2\32\u0108\3\2\2\2\34\35\5\20\t\2\35"+
		"\36\7\3\2\2\36$\3\2\2\2\37 \5\4\3\2 !\5\20\t\2!\"\7\3\2\2\"$\3\2\2\2#"+
		"\34\3\2\2\2#\37\3\2\2\2$\3\3\2\2\2%)\7\36\2\2&\'\5\f\7\2\'(\7\3\2\2(*"+
		"\3\2\2\2)&\3\2\2\2*+\3\2\2\2+)\3\2\2\2+,\3\2\2\2,-\3\2\2\2-.\7\37\2\2"+
		".\5\3\2\2\2/\60\5\16\b\2\60\61\7*\2\2\61\7\3\2\2\2\62\63\5\6\4\2\63\64"+
		"\7\b\2\2\64\65\5\20\t\2\65?\3\2\2\2\66\67\7*\2\2\678\7\b\2\28?\5\20\t"+
		"\29:\7*\2\2:;\7\6\2\2;<\7*\2\2<=\7\b\2\2=?\5\20\t\2>\62\3\2\2\2>\66\3"+
		"\2\2\2>9\3\2\2\2?\t\3\2\2\2@A\5\16\b\2AB\7*\2\2BK\7\23\2\2CH\5\6\4\2D"+
		"E\7\5\2\2EG\5\6\4\2FD\3\2\2\2GJ\3\2\2\2HF\3\2\2\2HI\3\2\2\2IL\3\2\2\2"+
		"JH\3\2\2\2KC\3\2\2\2KL\3\2\2\2LM\3\2\2\2MO\7\24\2\2NP\5\4\3\2ON\3\2\2"+
		"\2OP\3\2\2\2PQ\3\2\2\2QR\5\20\t\2R\13\3\2\2\2Ss\5\b\5\2Ts\5\n\6\2UV\7"+
		"$\2\2VY\5\16\b\2WX\7%\2\2XZ\5\16\b\2YW\3\2\2\2YZ\3\2\2\2Z[\3\2\2\2[d\7"+
		"\23\2\2\\a\5\6\4\2]^\7\5\2\2^`\5\6\4\2_]\3\2\2\2`c\3\2\2\2a_\3\2\2\2a"+
		"b\3\2\2\2be\3\2\2\2ca\3\2\2\2d\\\3\2\2\2de\3\2\2\2ef\3\2\2\2fg\7\24\2"+
		"\2gm\7\25\2\2hi\5\n\6\2ij\7\3\2\2jl\3\2\2\2kh\3\2\2\2lo\3\2\2\2mk\3\2"+
		"\2\2mn\3\2\2\2np\3\2\2\2om\3\2\2\2pq\7\26\2\2qs\3\2\2\2rS\3\2\2\2rT\3"+
		"\2\2\2rU\3\2\2\2s\r\3\2\2\2tu\t\2\2\2u\17\3\2\2\2vy\5\22\n\2wx\7\r\2\2"+
		"xz\5\20\t\2yw\3\2\2\2yz\3\2\2\2z\u00a6\3\2\2\2{~\5\22\n\2|}\7\16\2\2}"+
		"\177\5\20\t\2~|\3\2\2\2~\177\3\2\2\2\177\u00a6\3\2\2\2\u0080\u0083\5\22"+
		"\n\2\u0081\u0082\7\32\2\2\u0082\u0084\5\20\t\2\u0083\u0081\3\2\2\2\u0083"+
		"\u0084\3\2\2\2\u0084\u00a6\3\2\2\2\u0085\u0088\5\22\n\2\u0086\u0087\7"+
		"\33\2\2\u0087\u0089\5\20\t\2\u0088\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089"+
		"\u00a6\3\2\2\2\u008a\u008b\7&\2\2\u008b\u008c\5\16\b\2\u008c\u0095\7\23"+
		"\2\2\u008d\u0092\5\26\f\2\u008e\u008f\7\5\2\2\u008f\u0091\5\26\f\2\u0090"+
		"\u008e\3\2\2\2\u0091\u0094\3\2\2\2\u0092\u0090\3\2\2\2\u0092\u0093\3\2"+
		"\2\2\u0093\u0096\3\2\2\2\u0094\u0092\3\2\2\2\u0095\u008d\3\2\2\2\u0095"+
		"\u0096\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0098\7\24\2\2\u0098\u00a6\3"+
		"\2\2\2\u0099\u00a6\5\24\13\2\u009a\u009b\7\27\2\2\u009b\u009c\5\20\t\2"+
		"\u009c\u009d\7\30\2\2\u009d\u009e\7\25\2\2\u009e\u009f\5\20\t\2\u009f"+
		"\u00a0\7\26\2\2\u00a0\u00a1\7\31\2\2\u00a1\u00a2\7\25\2\2\u00a2\u00a3"+
		"\5\20\t\2\u00a3\u00a4\7\26\2\2\u00a4\u00a6\3\2\2\2\u00a5v\3\2\2\2\u00a5"+
		"{\3\2\2\2\u00a5\u0080\3\2\2\2\u00a5\u0085\3\2\2\2\u00a5\u008a\3\2\2\2"+
		"\u00a5\u0099\3\2\2\2\u00a5\u009a\3\2\2\2\u00a6\21\3\2\2\2\u00a7\u00aa"+
		"\5\30\r\2\u00a8\u00a9\7\17\2\2\u00a9\u00ab\5\22\n\2\u00aa\u00a8\3\2\2"+
		"\2\u00aa\u00ab\3\2\2\2\u00ab\u00b2\3\2\2\2\u00ac\u00af\5\30\r\2\u00ad"+
		"\u00ae\7\20\2\2\u00ae\u00b0\5\22\n\2\u00af\u00ad\3\2\2\2\u00af\u00b0\3"+
		"\2\2\2\u00b0\u00b2\3\2\2\2\u00b1\u00a7\3\2\2\2\u00b1\u00ac\3\2\2\2\u00b2"+
		"\23\3\2\2\2\u00b3\u00b5\5\26\f\2\u00b4\u00b3\3\2\2\2\u00b5\u00b6\3\2\2"+
		"\2\u00b6\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\25\3\2\2\2\u00b8\u00c5"+
		"\5\b\5\2\u00b9\u00ba\7\27\2\2\u00ba\u00bb\5\20\t\2\u00bb\u00bc\7\30\2"+
		"\2\u00bc\u00bd\7\25\2\2\u00bd\u00be\5\24\13\2\u00be\u00bf\7\26\2\2\u00bf"+
		"\u00c0\7\31\2\2\u00c0\u00c1\7\25\2\2\u00c1\u00c2\5\24\13\2\u00c2\u00c3"+
		"\7\26\2\2\u00c3\u00c5\3\2\2\2\u00c4\u00b8\3\2\2\2\u00c4\u00b9\3\2\2\2"+
		"\u00c5\27\3\2\2\2\u00c6\u00c7\5\32\16\2\u00c7\u00c8\7\7\2\2\u00c8\u00c9"+
		"\5\32\16\2\u00c9\u00dc\3\2\2\2\u00ca\u00cb\5\32\16\2\u00cb\u00cc\7\n\2"+
		"\2\u00cc\u00cd\5\32\16\2\u00cd\u00dc\3\2\2\2\u00ce\u00cf\5\32\16\2\u00cf"+
		"\u00d0\7\t\2\2\u00d0\u00d1\5\32\16\2\u00d1\u00dc\3\2\2\2\u00d2\u00d3\5"+
		"\32\16\2\u00d3\u00d4\7\f\2\2\u00d4\u00d5\5\32\16\2\u00d5\u00dc\3\2\2\2"+
		"\u00d6\u00d7\5\32\16\2\u00d7\u00d8\7\13\2\2\u00d8\u00d9\5\32\16\2\u00d9"+
		"\u00dc\3\2\2\2\u00da\u00dc\5\32\16\2\u00db\u00c6\3\2\2\2\u00db\u00ca\3"+
		"\2\2\2\u00db\u00ce\3\2\2\2\u00db\u00d2\3\2\2\2\u00db\u00d6\3\2\2\2\u00db"+
		"\u00da\3\2\2\2\u00dc\31\3\2\2\2\u00dd\u0109\7)\2\2\u00de\u0109\t\3\2\2"+
		"\u00df\u0109\7*\2\2\u00e0\u00ed\7*\2\2\u00e1\u00ea\7\23\2\2\u00e2\u00e7"+
		"\5\20\t\2\u00e3\u00e4\7\5\2\2\u00e4\u00e6\5\20\t\2\u00e5\u00e3\3\2\2\2"+
		"\u00e6\u00e9\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00eb"+
		"\3\2\2\2\u00e9\u00e7\3\2\2\2\u00ea\u00e2\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb"+
		"\u00ec\3\2\2\2\u00ec\u00ee\7\24\2\2\u00ed\u00e1\3\2\2\2\u00ed\u00ee\3"+
		"\2\2\2\u00ee\u0109\3\2\2\2\u00ef\u0109\7\'\2\2\u00f0\u00f1\7\34\2\2\u00f1"+
		"\u0109\5\32\16\2\u00f2\u00f3\7*\2\2\u00f3\u00f4\7\6\2\2\u00f4\u0109\7"+
		"*\2\2\u00f5\u00f6\7*\2\2\u00f6\u00f7\7\6\2\2\u00f7\u00f8\7*\2\2\u00f8"+
		"\u0101\7\23\2\2\u00f9\u00fe\5\20\t\2\u00fa\u00fb\7\5\2\2\u00fb\u00fd\5"+
		"\20\t\2\u00fc\u00fa\3\2\2\2\u00fd\u0100\3\2\2\2\u00fe\u00fc\3\2\2\2\u00fe"+
		"\u00ff\3\2\2\2\u00ff\u0102\3\2\2\2\u0100\u00fe\3\2\2\2\u0101\u00f9\3\2"+
		"\2\2\u0101\u0102\3\2\2\2\u0102\u0103\3\2\2\2\u0103\u0109\7\24\2\2\u0104"+
		"\u0105\7\23\2\2\u0105\u0106\5\20\t\2\u0106\u0107\7\24\2\2\u0107\u0109"+
		"\3\2\2\2\u0108\u00dd\3\2\2\2\u0108\u00de\3\2\2\2\u0108\u00df\3\2\2\2\u0108"+
		"\u00e0\3\2\2\2\u0108\u00ef\3\2\2\2\u0108\u00f0\3\2\2\2\u0108\u00f2\3\2"+
		"\2\2\u0108\u00f5\3\2\2\2\u0108\u0104\3\2\2\2\u0109\33\3\2\2\2 #+>HKOY"+
		"admry~\u0083\u0088\u0092\u0095\u00a5\u00aa\u00af\u00b1\u00b6\u00c4\u00db"+
		"\u00e7\u00ea\u00ed\u00fe\u0101\u0108";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}