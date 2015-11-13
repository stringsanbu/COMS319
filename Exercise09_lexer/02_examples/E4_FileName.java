// Generated from E4_FileName.g4 by ANTLR 4.4
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class E4_FileName extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PATH=1, WS=2;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'"
	};
	public static final String[] ruleNames = {
		"OKCHAR", "NAME", "START", "PATH", "WS"
	};


	public E4_FileName(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "E4_FileName.g4"; }

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
		case 3: PATH_action((RuleContext)_localctx, actionIndex); break;
		case 4: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void PATH_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:  System.out.println("File name: " + getText());  break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1: skip(); break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\4*\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\3\6\3\21\n\3\r\3\16\3\22\3\4"+
		"\3\4\3\4\5\4\30\n\4\3\5\3\5\3\5\7\5\35\n\5\f\5\16\5 \13\5\3\5\3\5\3\6"+
		"\6\6%\n\6\r\6\16\6&\3\6\3\6\2\2\7\3\2\5\2\7\2\t\3\13\4\3\2\4\6\2/\60\62"+
		";C\\c|\5\2\13\f\17\17\"\"*\2\t\3\2\2\2\2\13\3\2\2\2\3\r\3\2\2\2\5\20\3"+
		"\2\2\2\7\27\3\2\2\2\t\31\3\2\2\2\13$\3\2\2\2\r\16\t\2\2\2\16\4\3\2\2\2"+
		"\17\21\5\3\2\2\20\17\3\2\2\2\21\22\3\2\2\2\22\20\3\2\2\2\22\23\3\2\2\2"+
		"\23\6\3\2\2\2\24\25\7\61\2\2\25\30\5\5\3\2\26\30\5\5\3\2\27\24\3\2\2\2"+
		"\27\26\3\2\2\2\30\b\3\2\2\2\31\36\5\7\4\2\32\33\7\61\2\2\33\35\5\5\3\2"+
		"\34\32\3\2\2\2\35 \3\2\2\2\36\34\3\2\2\2\36\37\3\2\2\2\37!\3\2\2\2 \36"+
		"\3\2\2\2!\"\b\5\2\2\"\n\3\2\2\2#%\t\3\2\2$#\3\2\2\2%&\3\2\2\2&$\3\2\2"+
		"\2&\'\3\2\2\2\'(\3\2\2\2()\b\6\3\2)\f\3\2\2\2\7\2\22\27\36&\4\3\5\2\3"+
		"\6\3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}