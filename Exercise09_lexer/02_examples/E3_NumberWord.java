// Generated from E3_NumberWord.g4 by ANTLR 4.4
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class E3_NumberWord extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NUMBER=1, WORD=2;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'"
	};
	public static final String[] ruleNames = {
		"DIGIT", "NUMBER", "WORD", "ALPHA"
	};


	public E3_NumberWord(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "E3_NumberWord.g4"; }

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

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 1: NUMBER_action((RuleContext)_localctx, actionIndex); break;
		case 2: WORD_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void NUMBER_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:  System.out.println("found number: " + getText());  break;
		}
	}
	private void WORD_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1: 
		         System.out.println("found word: " + getText()); 
		        break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\4\34\b\1\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\7\4\24\n\4\f"+
		"\4\16\4\27\13\4\3\4\3\4\3\5\3\5\2\2\6\3\2\5\3\7\4\t\2\3\2\4\3\2\62;\4"+
		"\2C\\c|\33\2\5\3\2\2\2\2\7\3\2\2\2\3\13\3\2\2\2\5\r\3\2\2\2\7\20\3\2\2"+
		"\2\t\32\3\2\2\2\13\f\t\2\2\2\f\4\3\2\2\2\r\16\5\3\2\2\16\17\b\3\2\2\17"+
		"\6\3\2\2\2\20\25\5\t\5\2\21\24\5\t\5\2\22\24\5\3\2\2\23\21\3\2\2\2\23"+
		"\22\3\2\2\2\24\27\3\2\2\2\25\23\3\2\2\2\25\26\3\2\2\2\26\30\3\2\2\2\27"+
		"\25\3\2\2\2\30\31\b\4\3\2\31\b\3\2\2\2\32\33\t\3\2\2\33\n\3\2\2\2\5\2"+
		"\23\25\4\3\3\2\3\4\3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}