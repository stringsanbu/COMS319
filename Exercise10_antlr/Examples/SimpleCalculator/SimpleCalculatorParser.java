// Generated from SimpleCalculator.g4 by ANTLR 4.4

import java.util.Stack;
import java.util.EmptyStackException;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SimpleCalculatorParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__2=1, T__1=2, T__0=3, DIGIT=4, AND=5, OR=6, INVERT=7, LESS=8, LESSEQ=9, 
		EQUALS=10, NOTEQ=11, GREAT=12, GREATEQ=13, ENDRPN=14, TRUE=15, FALSE=16, 
		PLUS=17, MINUS=18, MULT=19, DIV=20, MOD=21, WS=22;
	public static final String[] tokenNames = {
		"<INVALID>", "' '", "'\t'", "'.'", "DIGIT", "'&&'", "'||'", "'!'", "'<'", 
		"'<='", "'=='", "'!='", "'>'", "'>='", "';'", "'true'", "'false'", "'+'", 
		"'-'", "'*'", "'/'", "'%'", "WS"
	};
	public static final int
		RULE_start = 0, RULE_rpn = 1, RULE_num = 2, RULE_nm = 3, RULE_numop = 4, 
		RULE_bool = 5, RULE_booltext = 6, RULE_boolop = 7;
	public static final String[] ruleNames = {
		"start", "rpn", "num", "nm", "numop", "bool", "booltext", "boolop"
	};

	@Override
	public String getGrammarFileName() { return "SimpleCalculator.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	Stack<Integer> s = new Stack<Integer>();
	Stack<Boolean> b = new Stack<Boolean>();
	int n = 0;
	boolean errorFlag = false;

	public SimpleCalculatorParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StartContext extends ParserRuleContext {
		public Token ENDRPN;
		public List<RpnContext> rpn() {
			return getRuleContexts(RpnContext.class);
		}
		public TerminalNode WS(int i) {
			return getToken(SimpleCalculatorParser.WS, i);
		}
		public List<TerminalNode> WS() { return getTokens(SimpleCalculatorParser.WS); }
		public List<TerminalNode> ENDRPN() { return getTokens(SimpleCalculatorParser.ENDRPN); }
		public TerminalNode ENDRPN(int i) {
			return getToken(SimpleCalculatorParser.ENDRPN, i);
		}
		public RpnContext rpn(int i) {
			return getRuleContext(RpnContext.class,i);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCalculatorListener ) ((SimpleCalculatorListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCalculatorListener ) ((SimpleCalculatorListener)listener).exitStart(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__1) | (1L << DIGIT) | (1L << AND) | (1L << OR) | (1L << INVERT) | (1L << LESS) | (1L << LESSEQ) | (1L << EQUALS) | (1L << NOTEQ) | (1L << GREAT) | (1L << GREATEQ) | (1L << TRUE) | (1L << FALSE) | (1L << PLUS) | (1L << MINUS) | (1L << MULT) | (1L << DIV) | (1L << MOD) | (1L << WS))) != 0)) {
				{
				{
				setState(19);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(16); match(WS);
					}
					}
					setState(21);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				{
				setState(22); rpn();
				}
				setState(32);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(23); match(WS);
					}
					break;
				case 2:
					{
					setState(27);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==WS) {
						{
						{
						setState(24); match(WS);
						}
						}
						setState(29);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(30); ((StartContext)_localctx).ENDRPN = match(ENDRPN);

											
											if(s.empty() && !b.empty())
											{
												Boolean y = b.pop();
												if(b.empty())
													System.out.print(y+(((StartContext)_localctx).ENDRPN!=null?((StartContext)_localctx).ENDRPN.getText():null));
												else 
													System.out.print("Error. Check the number of boolean statements"+(((StartContext)_localctx).ENDRPN!=null?((StartContext)_localctx).ENDRPN.getText():null));
											}
											else if(!s.empty() && b.empty())
											{
												int x = s.pop();
												if(s.empty())
													System.out.print(x+(((StartContext)_localctx).ENDRPN!=null?((StartContext)_localctx).ENDRPN.getText():null));
												else 
													System.out.print("Error. Check the number of math statements"+(((StartContext)_localctx).ENDRPN!=null?((StartContext)_localctx).ENDRPN.getText():null));
											}
											else 
												System.out.print("Error. Check your syntax"+(((StartContext)_localctx).ENDRPN!=null?((StartContext)_localctx).ENDRPN.getText():null));
										
					}
					break;
				}
				}
				}
				setState(38);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class RpnContext extends ParserRuleContext {
		public List<NumopContext> numop() {
			return getRuleContexts(NumopContext.class);
		}
		public BoolopContext boolop(int i) {
			return getRuleContext(BoolopContext.class,i);
		}
		public BoolContext bool(int i) {
			return getRuleContext(BoolContext.class,i);
		}
		public NumopContext numop(int i) {
			return getRuleContext(NumopContext.class,i);
		}
		public List<BoolopContext> boolop() {
			return getRuleContexts(BoolopContext.class);
		}
		public List<BoolContext> bool() {
			return getRuleContexts(BoolContext.class);
		}
		public List<NumContext> num() {
			return getRuleContexts(NumContext.class);
		}
		public NumContext num(int i) {
			return getRuleContext(NumContext.class,i);
		}
		public RpnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rpn; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCalculatorListener ) ((SimpleCalculatorListener)listener).enterRpn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCalculatorListener ) ((SimpleCalculatorListener)listener).exitRpn(this);
		}
	}

	public final RpnContext rpn() throws RecognitionException {
		RpnContext _localctx = new RpnContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_rpn);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(40);
				_la = _input.LA(1);
				if (_la==T__2 || _la==T__1) {
					{
					setState(39);
					_la = _input.LA(1);
					if ( !(_la==T__2 || _la==T__1) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(46);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(42); bool();
					}
					break;
				case 2:
					{
					setState(43); num();
					}
					break;
				case 3:
					{
					setState(44); numop();
					}
					break;
				case 4:
					{
					setState(45); boolop();
					}
					break;
				}
				setState(49);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(48); match(T__2);
					}
					break;
				}
				}
				}
				setState(53); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__1) | (1L << DIGIT) | (1L << AND) | (1L << OR) | (1L << INVERT) | (1L << LESS) | (1L << LESSEQ) | (1L << EQUALS) | (1L << NOTEQ) | (1L << GREAT) | (1L << GREATEQ) | (1L << TRUE) | (1L << FALSE) | (1L << PLUS) | (1L << MINUS) | (1L << MULT) | (1L << DIV) | (1L << MOD))) != 0) );
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

	public static class NumContext extends ParserRuleContext {
		public NmContext nm;
		public NmContext nm() {
			return getRuleContext(NmContext.class,0);
		}
		public NumContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_num; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCalculatorListener ) ((SimpleCalculatorListener)listener).enterNum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCalculatorListener ) ((SimpleCalculatorListener)listener).exitNum(this);
		}
	}

	public final NumContext num() throws RecognitionException {
		NumContext _localctx = new NumContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_num);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55); ((NumContext)_localctx).nm = nm();

						if(!errorFlag)
							{
							// Let's check if it is an int. If it is a double, error time
							try { 
								Integer.parseInt((((NumContext)_localctx).nm!=null?_input.getText(((NumContext)_localctx).nm.start,((NumContext)_localctx).nm.stop):null));
								}
							catch(NumberFormatException e) { 
			       			 	errorFlag = true; 
			   					}
							if(!errorFlag) s.push(Integer.parseInt((((NumContext)_localctx).nm!=null?_input.getText(((NumContext)_localctx).nm.start,((NumContext)_localctx).nm.stop):null)));
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

	public static class NmContext extends ParserRuleContext {
		public TerminalNode DIGIT(int i) {
			return getToken(SimpleCalculatorParser.DIGIT, i);
		}
		public List<TerminalNode> DIGIT() { return getTokens(SimpleCalculatorParser.DIGIT); }
		public NmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCalculatorListener ) ((SimpleCalculatorListener)listener).enterNm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCalculatorListener ) ((SimpleCalculatorListener)listener).exitNm(this);
		}
	}

	public final NmContext nm() throws RecognitionException {
		NmContext _localctx = new NmContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_nm);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(58); match(MINUS);
				}
			}

			setState(62); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(61); match(DIGIT);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(64); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(72);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(66); match(T__0);
				setState(68); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(67); match(DIGIT);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(70); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class NumopContext extends ParserRuleContext {
		public TerminalNode MULT() { return getToken(SimpleCalculatorParser.MULT, 0); }
		public TerminalNode MINUS() { return getToken(SimpleCalculatorParser.MINUS, 0); }
		public TerminalNode PLUS() { return getToken(SimpleCalculatorParser.PLUS, 0); }
		public TerminalNode MOD() { return getToken(SimpleCalculatorParser.MOD, 0); }
		public TerminalNode DIV() { return getToken(SimpleCalculatorParser.DIV, 0); }
		public NumopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCalculatorListener ) ((SimpleCalculatorListener)listener).enterNumop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCalculatorListener ) ((SimpleCalculatorListener)listener).exitNumop(this);
		}
	}

	public final NumopContext numop() throws RecognitionException {
		NumopContext _localctx = new NumopContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_numop);
		try {
			setState(84);
			switch (_input.LA(1)) {
			case MINUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(74); match(MINUS);

							if(!errorFlag){
								int x = 0;
								int y = 0;
								try{
									x = s.pop(); 
									y = s.pop(); 
								}
								catch (EmptyStackException e){
									errorFlag = true;
								}	
								if(!errorFlag) s.push(y - x);
							}
						
				}
				break;
			case DIV:
				enterOuterAlt(_localctx, 2);
				{
				setState(76); match(DIV);

							if(!errorFlag){
								int x = 0;
								int y = 0;
								try{
									x = s.pop(); 
									y = s.pop(); 
								}
								catch (EmptyStackException e){
									errorFlag = true;
								}	
								if(!errorFlag) s.push(y / x);
							}
						
				}
				break;
			case MULT:
				enterOuterAlt(_localctx, 3);
				{
				setState(78); match(MULT);

							if(!errorFlag){
								int x = 0;
								int y = 0;
								try{
									x = s.pop(); 
									y = s.pop(); 
								}
								catch (EmptyStackException e){
									errorFlag = true;
								}	
								if(!errorFlag) s.push(y * x);
							}
						
				}
				break;
			case PLUS:
				enterOuterAlt(_localctx, 4);
				{
				setState(80); match(PLUS);

							if(!errorFlag){
								int x = 0;
								int y = 0;
								try{
									x = s.pop(); 
									y = s.pop(); 
								}
								catch (EmptyStackException e){
									errorFlag = true;
								}	
								if(!errorFlag) s.push(y + x);
							}
						
				}
				break;
			case MOD:
				enterOuterAlt(_localctx, 5);
				{
				setState(82); match(MOD);

							if(!errorFlag){
								int x = 0;
								int y = 0;
								try{
									x = s.pop(); 
									y = s.pop(); 
								}
								catch (EmptyStackException e){
									errorFlag = true;
								}	
								if(!errorFlag) s.push(y % x);
							}
						
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

	public static class BoolContext extends ParserRuleContext {
		public BooltextContext booltext;
		public BooltextContext booltext() {
			return getRuleContext(BooltextContext.class,0);
		}
		public BoolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCalculatorListener ) ((SimpleCalculatorListener)listener).enterBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCalculatorListener ) ((SimpleCalculatorListener)listener).exitBool(this);
		}
	}

	public final BoolContext bool() throws RecognitionException {
		BoolContext _localctx = new BoolContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_bool);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86); ((BoolContext)_localctx).booltext = booltext();
			 b.push(Boolean.valueOf((((BoolContext)_localctx).booltext!=null?_input.getText(((BoolContext)_localctx).booltext.start,((BoolContext)_localctx).booltext.stop):null))); 
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

	public static class BooltextContext extends ParserRuleContext {
		public TerminalNode FALSE() { return getToken(SimpleCalculatorParser.FALSE, 0); }
		public TerminalNode TRUE() { return getToken(SimpleCalculatorParser.TRUE, 0); }
		public BooltextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booltext; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCalculatorListener ) ((SimpleCalculatorListener)listener).enterBooltext(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCalculatorListener ) ((SimpleCalculatorListener)listener).exitBooltext(this);
		}
	}

	public final BooltextContext booltext() throws RecognitionException {
		BooltextContext _localctx = new BooltextContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_booltext);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			_la = _input.LA(1);
			if ( !(_la==TRUE || _la==FALSE) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class BoolopContext extends ParserRuleContext {
		public TerminalNode LESS() { return getToken(SimpleCalculatorParser.LESS, 0); }
		public TerminalNode LESSEQ() { return getToken(SimpleCalculatorParser.LESSEQ, 0); }
		public TerminalNode EQUALS() { return getToken(SimpleCalculatorParser.EQUALS, 0); }
		public TerminalNode GREATEQ() { return getToken(SimpleCalculatorParser.GREATEQ, 0); }
		public TerminalNode INVERT() { return getToken(SimpleCalculatorParser.INVERT, 0); }
		public TerminalNode GREAT() { return getToken(SimpleCalculatorParser.GREAT, 0); }
		public TerminalNode AND() { return getToken(SimpleCalculatorParser.AND, 0); }
		public TerminalNode OR() { return getToken(SimpleCalculatorParser.OR, 0); }
		public TerminalNode NOTEQ() { return getToken(SimpleCalculatorParser.NOTEQ, 0); }
		public BoolopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCalculatorListener ) ((SimpleCalculatorListener)listener).enterBoolop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCalculatorListener ) ((SimpleCalculatorListener)listener).exitBoolop(this);
		}
	}

	public final BoolopContext boolop() throws RecognitionException {
		BoolopContext _localctx = new BoolopContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_boolop);
		try {
			setState(109);
			switch (_input.LA(1)) {
			case INVERT:
				enterOuterAlt(_localctx, 1);
				{
				setState(91); match(INVERT);
				Boolean x = b.pop(); b.push(!x); 
				}
				break;
			case LESS:
				enterOuterAlt(_localctx, 2);
				{
				setState(93); match(LESS);
				int x = s.pop(); int y = s.pop(); b.push(Boolean.valueOf(y < x)); 
				}
				break;
			case LESSEQ:
				enterOuterAlt(_localctx, 3);
				{
				setState(95); match(LESSEQ);
				int x = s.pop(); int y = s.pop(); b.push(Boolean.valueOf(y <= x)); 
				}
				break;
			case EQUALS:
				enterOuterAlt(_localctx, 4);
				{
				setState(97); match(EQUALS);
				int x = s.pop(); int y = s.pop(); b.push(Boolean.valueOf(y == x)); 
				}
				break;
			case NOTEQ:
				enterOuterAlt(_localctx, 5);
				{
				setState(99); match(NOTEQ);
				int x = s.pop(); int y = s.pop(); b.push(Boolean.valueOf(y != x)); 
				}
				break;
			case GREAT:
				enterOuterAlt(_localctx, 6);
				{
				setState(101); match(GREAT);
				int x = s.pop(); int y = s.pop(); b.push(Boolean.valueOf(y > x)); 
				}
				break;
			case GREATEQ:
				enterOuterAlt(_localctx, 7);
				{
				setState(103); match(GREATEQ);
				int x = s.pop(); int y = s.pop(); b.push(Boolean.valueOf(y >= x)); 
				}
				break;
			case AND:
				enterOuterAlt(_localctx, 8);
				{
				setState(105); match(AND);
				Boolean x = b.pop(); Boolean y = b.pop(); b.push(Boolean.valueOf(y && x)); 
				}
				break;
			case OR:
				enterOuterAlt(_localctx, 9);
				{
				setState(107); match(OR);
				Boolean x = b.pop(); Boolean y = b.pop(); b.push(Boolean.valueOf(y || x)); 
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\30r\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\7\2\24\n\2\f\2"+
		"\16\2\27\13\2\3\2\3\2\3\2\7\2\34\n\2\f\2\16\2\37\13\2\3\2\3\2\5\2#\n\2"+
		"\7\2%\n\2\f\2\16\2(\13\2\3\3\5\3+\n\3\3\3\3\3\3\3\3\3\5\3\61\n\3\3\3\5"+
		"\3\64\n\3\6\3\66\n\3\r\3\16\3\67\3\4\3\4\3\4\3\5\5\5>\n\5\3\5\6\5A\n\5"+
		"\r\5\16\5B\3\5\3\5\6\5G\n\5\r\5\16\5H\5\5K\n\5\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\5\6W\n\6\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\tp\n\t\3\t\2\2\n\2"+
		"\4\6\b\n\f\16\20\2\4\3\2\3\4\3\2\21\22\u0083\2&\3\2\2\2\4\65\3\2\2\2\6"+
		"9\3\2\2\2\b=\3\2\2\2\nV\3\2\2\2\fX\3\2\2\2\16[\3\2\2\2\20o\3\2\2\2\22"+
		"\24\7\30\2\2\23\22\3\2\2\2\24\27\3\2\2\2\25\23\3\2\2\2\25\26\3\2\2\2\26"+
		"\30\3\2\2\2\27\25\3\2\2\2\30\"\5\4\3\2\31#\7\30\2\2\32\34\7\30\2\2\33"+
		"\32\3\2\2\2\34\37\3\2\2\2\35\33\3\2\2\2\35\36\3\2\2\2\36 \3\2\2\2\37\35"+
		"\3\2\2\2 !\7\20\2\2!#\b\2\1\2\"\31\3\2\2\2\"\35\3\2\2\2#%\3\2\2\2$\25"+
		"\3\2\2\2%(\3\2\2\2&$\3\2\2\2&\'\3\2\2\2\'\3\3\2\2\2(&\3\2\2\2)+\t\2\2"+
		"\2*)\3\2\2\2*+\3\2\2\2+\60\3\2\2\2,\61\5\f\7\2-\61\5\6\4\2.\61\5\n\6\2"+
		"/\61\5\20\t\2\60,\3\2\2\2\60-\3\2\2\2\60.\3\2\2\2\60/\3\2\2\2\61\63\3"+
		"\2\2\2\62\64\7\3\2\2\63\62\3\2\2\2\63\64\3\2\2\2\64\66\3\2\2\2\65*\3\2"+
		"\2\2\66\67\3\2\2\2\67\65\3\2\2\2\678\3\2\2\28\5\3\2\2\29:\5\b\5\2:;\b"+
		"\4\1\2;\7\3\2\2\2<>\7\24\2\2=<\3\2\2\2=>\3\2\2\2>@\3\2\2\2?A\7\6\2\2@"+
		"?\3\2\2\2AB\3\2\2\2B@\3\2\2\2BC\3\2\2\2CJ\3\2\2\2DF\7\5\2\2EG\7\6\2\2"+
		"FE\3\2\2\2GH\3\2\2\2HF\3\2\2\2HI\3\2\2\2IK\3\2\2\2JD\3\2\2\2JK\3\2\2\2"+
		"K\t\3\2\2\2LM\7\24\2\2MW\b\6\1\2NO\7\26\2\2OW\b\6\1\2PQ\7\25\2\2QW\b\6"+
		"\1\2RS\7\23\2\2SW\b\6\1\2TU\7\27\2\2UW\b\6\1\2VL\3\2\2\2VN\3\2\2\2VP\3"+
		"\2\2\2VR\3\2\2\2VT\3\2\2\2W\13\3\2\2\2XY\5\16\b\2YZ\b\7\1\2Z\r\3\2\2\2"+
		"[\\\t\3\2\2\\\17\3\2\2\2]^\7\t\2\2^p\b\t\1\2_`\7\n\2\2`p\b\t\1\2ab\7\13"+
		"\2\2bp\b\t\1\2cd\7\f\2\2dp\b\t\1\2ef\7\r\2\2fp\b\t\1\2gh\7\16\2\2hp\b"+
		"\t\1\2ij\7\17\2\2jp\b\t\1\2kl\7\7\2\2lp\b\t\1\2mn\7\b\2\2np\b\t\1\2o]"+
		"\3\2\2\2o_\3\2\2\2oa\3\2\2\2oc\3\2\2\2oe\3\2\2\2og\3\2\2\2oi\3\2\2\2o"+
		"k\3\2\2\2om\3\2\2\2p\21\3\2\2\2\20\25\35\"&*\60\63\67=BHJVo";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}