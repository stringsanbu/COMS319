// Generated from Tokenizer.g4 by ANTLR 4.4
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Tokenizer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		EMAILTAG=1, DATETAG=2, PHONETAG=3, CREDITCARDTAG=4, NAME=5, Phone1=6, 
		Phone2=7, Phone3=8, Phone4=9, VISACARD=10, MASTERCARD=11, AMERICANEXPRESS=12, 
		DINERSCLUB=13, DISCOVER=14, JCB=15, EMAILOUT=16, CURRENTDATE=17, WS=18;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'"
	};
	public static final String[] ruleNames = {
		"EMAIL", "DATE", "PHONE", "CREDITCARD", "EMAILTAG", "DATETAG", "PHONETAG", 
		"CREDITCARDTAG", "NAME", "DIGIT", "Phone1", "Phone2", "Phone3", "Phone4", 
		"VISACARD", "MASTERCARD", "AMERICANEXPRESS", "DINERSCLUB", "DISCOVER", 
		"JCB", "EMAILOUT", "DOMAIN", "LOCALPART", "DAY", "MONTH", "YEAR", "CURRENTDATE", 
		"WS"
	};


	  boolean searchEmail=false;
	  boolean searchDate=false;
	  boolean searchPhone=false;
	  boolean searchCard=false;
	  boolean foundEmail=false;
	  boolean foundDate=false;
	  boolean foundPhone=false;
	  boolean foundCard=false;


	public Tokenizer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Tokenizer.g4"; }

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
		case 4: EMAILTAG_action((RuleContext)_localctx, actionIndex); break;
		case 5: DATETAG_action((RuleContext)_localctx, actionIndex); break;
		case 6: PHONETAG_action((RuleContext)_localctx, actionIndex); break;
		case 7: CREDITCARDTAG_action((RuleContext)_localctx, actionIndex); break;
		case 8: NAME_action((RuleContext)_localctx, actionIndex); break;
		case 10: Phone1_action((RuleContext)_localctx, actionIndex); break;
		case 11: Phone2_action((RuleContext)_localctx, actionIndex); break;
		case 12: Phone3_action((RuleContext)_localctx, actionIndex); break;
		case 13: Phone4_action((RuleContext)_localctx, actionIndex); break;
		case 14: VISACARD_action((RuleContext)_localctx, actionIndex); break;
		case 15: MASTERCARD_action((RuleContext)_localctx, actionIndex); break;
		case 16: AMERICANEXPRESS_action((RuleContext)_localctx, actionIndex); break;
		case 17: DINERSCLUB_action((RuleContext)_localctx, actionIndex); break;
		case 18: DISCOVER_action((RuleContext)_localctx, actionIndex); break;
		case 19: JCB_action((RuleContext)_localctx, actionIndex); break;
		case 20: EMAILOUT_action((RuleContext)_localctx, actionIndex); break;
		case 26: CURRENTDATE_action((RuleContext)_localctx, actionIndex); break;
		case 27: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void AMERICANEXPRESS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 11: 
				System.out.println("Found American Express card, the number is: "+getText());
				foundCard=true;
			 break;
		}
	}
	private void DISCOVER_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 13: 
				System.out.println("Found Discover card, the number is: "+getText());
				foundCard=true;
			 break;
		}
	}
	private void JCB_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 14: 
				System.out.println("Found JCB card, the number is: "+getText());
				foundCard=true;
			 break;
		}
	}
	private void NAME_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 4: 
				//if(getText()=="XML"||getText()=="Xml"|| getText()=="xml"||getText()==" ")
					System.out.println("Found an element that is not email, date, phone, or credit card.  Skipping...");	
			 break;
		}
	}
	private void VISACARD_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 9: 
				System.out.println("Found Visa card, the number is: "+getText());
				foundCard=true;
			 break;
		}
	}
	private void Phone1_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 5: 
				System.out.println("Found phone number: "+getText());
				foundPhone=true;
			 break;
		}
	}
	private void Phone3_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 7: 
				System.out.println("Found phone number: "+getText());
				foundPhone=true;
			 break;
		}
	}
	private void PHONETAG_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2: 	
				if(!searchPhone)
				{
					System.out.println("Found phonetag: " + getText()+", looking for phone....");
					searchPhone=true;
				}
				else
				{
					if(!foundPhone)
						System.out.print("Could not find phone according to specifications.  ");
					System.out.println("Found endtag: " + getText());
					searchPhone=false;
				}
			 break;
		}
	}
	private void Phone2_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 6: 
				System.out.println("Found phone number: "+getText());
				foundPhone=true;
			 break;
		}
	}
	private void EMAILOUT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 15: 
				System.out.println("Email is: "+getText());
				foundEmail=true;
			 break;
		}
	}
	private void Phone4_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 8: 
				System.out.println("Found phone number: "+getText());
				foundPhone=true;
			 break;
		}
	}
	private void MASTERCARD_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 10: 
				System.out.println("Found Mastercard card, the number is: "+getText());
				foundCard=true;
			 break;
		}
	}
	private void CURRENTDATE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 16: 
				System.out.println("Date is: "+getText());
				foundDate=true;
			 break;
		}
	}
	private void EMAILTAG_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: 	
				if(!searchEmail)
				{
					System.out.println("Found emailtag: " + getText()+", looking for email....");
					searchEmail=true;
				}
				else
				{
					if(!foundEmail)
						System.out.print("Could not find email according to specifications.  ");
					System.out.println("Found endtag: " + getText());
					searchEmail=false;
				}
			 break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 17: System.out.println("Moving to next line...");skip(); break;
		}
	}
	private void DINERSCLUB_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 12: 
				System.out.println("Found Diners Club card, the number is: "+getText());
				foundCard=true;
			 break;
		}
	}
	private void DATETAG_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1: 	
				if(!searchDate)
				{
					System.out.println("Found datetag: " + getText()+", looking for date....");
					searchDate=true;
				}
				else
				{
					if(!foundDate)
						System.out.print("Could not find date according to specifications.  ");
					System.out.println("Found endtag: " + getText());
					searchDate=false;
				}
			 break;
		}
	}
	private void CREDITCARDTAG_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3: 
				if(!searchCard)
				{
					System.out.println("Found creditcardtag: " + getText()+", looking for creditcard....");
					searchCard=true;
				}
				else
				{
					if(!foundCard)
						System.out.print("Could not find card according to specifications.  ");
					System.out.println("Found endtag: " + getText());
					searchCard=false;
				}
			 break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\24\u0230\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2K\n\2\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3Z\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4k\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5"+
		"\5\u0086\n\5\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\7"+
		"\n\u0096\n\n\f\n\16\n\u0099\13\n\3\n\3\n\3\n\3\n\7\n\u009f\n\n\f\n\16"+
		"\n\u00a2\13\n\3\n\3\n\5\n\u00a6\n\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\5\20\u0109\n\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u014b"+
		"\n\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\5\23\u0188\n\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u01b6\n\24\3\24\3\24"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\5\25\u01f7\n\25\3\25\3\25\3\26\7\26\u01fc\n"+
		"\26\f\26\16\26\u01ff\13\26\3\26\3\26\7\26\u0203\n\26\f\26\16\26\u0206"+
		"\13\26\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\5\31\u0216\n\31\3\32\3\32\3\32\3\32\5\32\u021c\n\32\3\33\3\33\3"+
		"\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35\6\35\u022b\n\35"+
		"\r\35\16\35\u022c\3\35\3\35\2\2\36\3\2\5\2\7\2\t\2\13\3\r\4\17\5\21\6"+
		"\23\7\25\2\27\b\31\t\33\n\35\13\37\f!\r#\16%\17\'\20)\21+\22-\2/\2\61"+
		"\2\63\2\65\2\67\239\24\3\2\16\4\2C\\c|\3\2\62;\3\2\63\67\3\2\62\67\6\2"+
		"/\60\62;C\\c|\13\2##&&).\62=??C\\aac|\u0080\u0080\f\2##&&).\60\60\62="+
		"??C\\aac|\u0080\u0080\3\2\62\64\3\2\62\62\3\2\63;\3\2\62\63\5\2\13\f\17"+
		"\17\"\"\u0239\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2\67\3\2\2\2\29\3\2\2\2\3J\3\2\2\2\5Y\3\2\2\2\7j\3\2\2\2\t\u0085\3"+
		"\2\2\2\13\u0087\3\2\2\2\r\u008a\3\2\2\2\17\u008d\3\2\2\2\21\u0090\3\2"+
		"\2\2\23\u00a5\3\2\2\2\25\u00a7\3\2\2\2\27\u00a9\3\2\2\2\31\u00b7\3\2\2"+
		"\2\33\u00c5\3\2\2\2\35\u00d3\3\2\2\2\37\u0108\3\2\2\2!\u010c\3\2\2\2#"+
		"\u014a\3\2\2\2%\u0187\3\2\2\2\'\u01b5\3\2\2\2)\u01f6\3\2\2\2+\u01fd\3"+
		"\2\2\2-\u0209\3\2\2\2/\u020b\3\2\2\2\61\u0215\3\2\2\2\63\u021b\3\2\2\2"+
		"\65\u021d\3\2\2\2\67\u0222\3\2\2\29\u022a\3\2\2\2;<\7>\2\2<=\7g\2\2=>"+
		"\7o\2\2>?\7c\2\2?@\7k\2\2@A\7n\2\2AK\7@\2\2BC\7>\2\2CD\7\61\2\2DE\7g\2"+
		"\2EF\7o\2\2FG\7c\2\2GH\7k\2\2HI\7n\2\2IK\7@\2\2J;\3\2\2\2JB\3\2\2\2K\4"+
		"\3\2\2\2LM\7>\2\2MN\7f\2\2NO\7c\2\2OP\7v\2\2PQ\7g\2\2QZ\7@\2\2RS\7>\2"+
		"\2ST\7\61\2\2TU\7f\2\2UV\7c\2\2VW\7v\2\2WX\7g\2\2XZ\7@\2\2YL\3\2\2\2Y"+
		"R\3\2\2\2Z\6\3\2\2\2[\\\7>\2\2\\]\7r\2\2]^\7j\2\2^_\7q\2\2_`\7p\2\2`a"+
		"\7g\2\2ak\7@\2\2bc\7>\2\2cd\7\61\2\2de\7r\2\2ef\7j\2\2fg\7q\2\2gh\7p\2"+
		"\2hi\7g\2\2ik\7@\2\2j[\3\2\2\2jb\3\2\2\2k\b\3\2\2\2lm\7>\2\2mn\7e\2\2"+
		"no\7t\2\2op\7g\2\2pq\7f\2\2qr\7k\2\2rs\7v\2\2st\7e\2\2tu\7c\2\2uv\7t\2"+
		"\2vw\7f\2\2w\u0086\7@\2\2xy\7>\2\2yz\7\61\2\2z{\7e\2\2{|\7t\2\2|}\7g\2"+
		"\2}~\7f\2\2~\177\7k\2\2\177\u0080\7v\2\2\u0080\u0081\7e\2\2\u0081\u0082"+
		"\7c\2\2\u0082\u0083\7t\2\2\u0083\u0084\7f\2\2\u0084\u0086\7@\2\2\u0085"+
		"l\3\2\2\2\u0085x\3\2\2\2\u0086\n\3\2\2\2\u0087\u0088\5\3\2\2\u0088\u0089"+
		"\b\6\2\2\u0089\f\3\2\2\2\u008a\u008b\5\5\3\2\u008b\u008c\b\7\3\2\u008c"+
		"\16\3\2\2\2\u008d\u008e\5\7\4\2\u008e\u008f\b\b\4\2\u008f\20\3\2\2\2\u0090"+
		"\u0091\5\t\5\2\u0091\u0092\b\t\5\2\u0092\22\3\2\2\2\u0093\u0097\7>\2\2"+
		"\u0094\u0096\t\2\2\2\u0095\u0094\3\2\2\2\u0096\u0099\3\2\2\2\u0097\u0095"+
		"\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u009a\3\2\2\2\u0099\u0097\3\2\2\2\u009a"+
		"\u00a6\7@\2\2\u009b\u009c\7>\2\2\u009c\u00a0\7\61\2\2\u009d\u009f\t\2"+
		"\2\2\u009e\u009d\3\2\2\2\u009f\u00a2\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0"+
		"\u00a1\3\2\2\2\u00a1\u00a3\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a3\u00a4\7@"+
		"\2\2\u00a4\u00a6\b\n\6\2\u00a5\u0093\3\2\2\2\u00a5\u009b\3\2\2\2\u00a6"+
		"\24\3\2\2\2\u00a7\u00a8\t\3\2\2\u00a8\26\3\2\2\2\u00a9\u00aa\5\25\13\2"+
		"\u00aa\u00ab\5\25\13\2\u00ab\u00ac\5\25\13\2\u00ac\u00ad\7\60\2\2\u00ad"+
		"\u00ae\5\25\13\2\u00ae\u00af\5\25\13\2\u00af\u00b0\5\25\13\2\u00b0\u00b1"+
		"\7\60\2\2\u00b1\u00b2\5\25\13\2\u00b2\u00b3\5\25\13\2\u00b3\u00b4\5\25"+
		"\13\2\u00b4\u00b5\5\25\13\2\u00b5\u00b6\b\f\7\2\u00b6\30\3\2\2\2\u00b7"+
		"\u00b8\5\25\13\2\u00b8\u00b9\5\25\13\2\u00b9\u00ba\5\25\13\2\u00ba\u00bb"+
		"\7\"\2\2\u00bb\u00bc\5\25\13\2\u00bc\u00bd\5\25\13\2\u00bd\u00be\5\25"+
		"\13\2\u00be\u00bf\7\"\2\2\u00bf\u00c0\5\25\13\2\u00c0\u00c1\5\25\13\2"+
		"\u00c1\u00c2\5\25\13\2\u00c2\u00c3\5\25\13\2\u00c3\u00c4\b\r\b\2\u00c4"+
		"\32\3\2\2\2\u00c5\u00c6\5\25\13\2\u00c6\u00c7\5\25\13\2\u00c7\u00c8\5"+
		"\25\13\2\u00c8\u00c9\7/\2\2\u00c9\u00ca\5\25\13\2\u00ca\u00cb\5\25\13"+
		"\2\u00cb\u00cc\5\25\13\2\u00cc\u00cd\7/\2\2\u00cd\u00ce\5\25\13\2\u00ce"+
		"\u00cf\5\25\13\2\u00cf\u00d0\5\25\13\2\u00d0\u00d1\5\25\13\2\u00d1\u00d2"+
		"\b\16\t\2\u00d2\34\3\2\2\2\u00d3\u00d4\7*\2\2\u00d4\u00d5\5\25\13\2\u00d5"+
		"\u00d6\5\25\13\2\u00d6\u00d7\5\25\13\2\u00d7\u00d8\7+\2\2\u00d8\u00d9"+
		"\7\"\2\2\u00d9\u00da\5\25\13\2\u00da\u00db\5\25\13\2\u00db\u00dc\5\25"+
		"\13\2\u00dc\u00dd\7/\2\2\u00dd\u00de\5\25\13\2\u00de\u00df\5\25\13\2\u00df"+
		"\u00e0\5\25\13\2\u00e0\u00e1\5\25\13\2\u00e1\u00e2\b\17\n\2\u00e2\36\3"+
		"\2\2\2\u00e3\u00e4\7\66\2\2\u00e4\u00e5\5\25\13\2\u00e5\u00e6\5\25\13"+
		"\2\u00e6\u00e7\5\25\13\2\u00e7\u00e8\7/\2\2\u00e8\u00e9\5\25\13\2\u00e9"+
		"\u00ea\5\25\13\2\u00ea\u00eb\5\25\13\2\u00eb\u00ec\5\25\13\2\u00ec\u00ed"+
		"\7/\2\2\u00ed\u00ee\5\25\13\2\u00ee\u00ef\5\25\13\2\u00ef\u00f0\5\25\13"+
		"\2\u00f0\u00f1\5\25\13\2\u00f1\u00f2\7/\2\2\u00f2\u00f3\5\25\13\2\u00f3"+
		"\u00f4\5\25\13\2\u00f4\u00f5\5\25\13\2\u00f5\u00f6\5\25\13\2\u00f6\u0109"+
		"\3\2\2\2\u00f7\u00f8\7\66\2\2\u00f8\u00f9\5\25\13\2\u00f9\u00fa\5\25\13"+
		"\2\u00fa\u00fb\5\25\13\2\u00fb\u00fc\7/\2\2\u00fc\u00fd\5\25\13\2\u00fd"+
		"\u00fe\5\25\13\2\u00fe\u00ff\5\25\13\2\u00ff\u0100\5\25\13\2\u0100\u0101"+
		"\7/\2\2\u0101\u0102\5\25\13\2\u0102\u0103\5\25\13\2\u0103\u0104\5\25\13"+
		"\2\u0104\u0105\5\25\13\2\u0105\u0106\7/\2\2\u0106\u0107\5\25\13\2\u0107"+
		"\u0109\3\2\2\2\u0108\u00e3\3\2\2\2\u0108\u00f7\3\2\2\2\u0109\u010a\3\2"+
		"\2\2\u010a\u010b\b\20\13\2\u010b \3\2\2\2\u010c\u010d\7\67\2\2\u010d\u010e"+
		"\t\4\2\2\u010e\u010f\5\25\13\2\u010f\u0110\5\25\13\2\u0110\u0111\7/\2"+
		"\2\u0111\u0112\5\25\13\2\u0112\u0113\5\25\13\2\u0113\u0114\5\25\13\2\u0114"+
		"\u0115\5\25\13\2\u0115\u0116\7/\2\2\u0116\u0117\5\25\13\2\u0117\u0118"+
		"\5\25\13\2\u0118\u0119\5\25\13\2\u0119\u011a\5\25\13\2\u011a\u011b\7/"+
		"\2\2\u011b\u011c\5\25\13\2\u011c\u011d\5\25\13\2\u011d\u011e\5\25\13\2"+
		"\u011e\u011f\5\25\13\2\u011f\u0120\b\21\f\2\u0120\"\3\2\2\2\u0121\u0122"+
		"\7\65\2\2\u0122\u0123\7\66\2\2\u0123\u0124\3\2\2\2\u0124\u0125\5\25\13"+
		"\2\u0125\u0126\5\25\13\2\u0126\u0127\7/\2\2\u0127\u0128\5\25\13\2\u0128"+
		"\u0129\5\25\13\2\u0129\u012a\5\25\13\2\u012a\u012b\5\25\13\2\u012b\u012c"+
		"\7/\2\2\u012c\u012d\5\25\13\2\u012d\u012e\5\25\13\2\u012e\u012f\5\25\13"+
		"\2\u012f\u0130\5\25\13\2\u0130\u0131\7/\2\2\u0131\u0132\5\25\13\2\u0132"+
		"\u0133\5\25\13\2\u0133\u0134\5\25\13\2\u0134\u014b\3\2\2\2\u0135\u0136"+
		"\7\65\2\2\u0136\u0137\79\2\2\u0137\u0138\3\2\2\2\u0138\u0139\5\25\13\2"+
		"\u0139\u013a\5\25\13\2\u013a\u013b\7/\2\2\u013b\u013c\5\25\13\2\u013c"+
		"\u013d\5\25\13\2\u013d\u013e\5\25\13\2\u013e\u013f\5\25\13\2\u013f\u0140"+
		"\7/\2\2\u0140\u0141\5\25\13\2\u0141\u0142\5\25\13\2\u0142\u0143\5\25\13"+
		"\2\u0143\u0144\5\25\13\2\u0144\u0145\7/\2\2\u0145\u0146\5\25\13\2\u0146"+
		"\u0147\5\25\13\2\u0147\u0148\5\25\13\2\u0148\u0149\5\25\13\2\u0149\u014b"+
		"\3\2\2\2\u014a\u0121\3\2\2\2\u014a\u0135\3\2\2\2\u014b\u014c\3\2\2\2\u014c"+
		"\u014d\b\22\r\2\u014d$\3\2\2\2\u014e\u014f\7\65\2\2\u014f\u0150\7\62\2"+
		"\2\u0150\u0151\3\2\2\2\u0151\u0152\t\5\2\2\u0152\u0153\5\25\13\2\u0153"+
		"\u0154\7/\2\2\u0154\u0155\5\25\13\2\u0155\u0156\5\25\13\2\u0156\u0157"+
		"\5\25\13\2\u0157\u0158\5\25\13\2\u0158\u0159\7/\2\2\u0159\u015a\5\25\13"+
		"\2\u015a\u015b\5\25\13\2\u015b\u015c\5\25\13\2\u015c\u015d\5\25\13\2\u015d"+
		"\u015e\7/\2\2\u015e\u015f\5\25\13\2\u015f\u0160\5\25\13\2\u0160\u0188"+
		"\3\2\2\2\u0161\u0162\7\65\2\2\u0162\u0163\7\65\2\2\u0163\u0164\78\2\2"+
		"\u0164\u0165\3\2\2\2\u0165\u0166\5\25\13\2\u0166\u0167\7/\2\2\u0167\u0168"+
		"\5\25\13\2\u0168\u0169\5\25\13\2\u0169\u016a\5\25\13\2\u016a\u016b\5\25"+
		"\13\2\u016b\u016c\7/\2\2\u016c\u016d\5\25\13\2\u016d\u016e\5\25\13\2\u016e"+
		"\u016f\5\25\13\2\u016f\u0170\5\25\13\2\u0170\u0171\7/\2\2\u0171\u0172"+
		"\5\25\13\2\u0172\u0173\5\25\13\2\u0173\u0188\3\2\2\2\u0174\u0175\7\65"+
		"\2\2\u0175\u0176\7\65\2\2\u0176\u0177\7:\2\2\u0177\u0178\3\2\2\2\u0178"+
		"\u0179\5\25\13\2\u0179\u017a\7/\2\2\u017a\u017b\5\25\13\2\u017b\u017c"+
		"\5\25\13\2\u017c\u017d\5\25\13\2\u017d\u017e\5\25\13\2\u017e\u017f\7/"+
		"\2\2\u017f\u0180\5\25\13\2\u0180\u0181\5\25\13\2\u0181\u0182\5\25\13\2"+
		"\u0182\u0183\5\25\13\2\u0183\u0184\7/\2\2\u0184\u0185\5\25\13\2\u0185"+
		"\u0186\5\25\13\2\u0186\u0188\3\2\2\2\u0187\u014e\3\2\2\2\u0187\u0161\3"+
		"\2\2\2\u0187\u0174\3\2\2\2\u0188\u0189\3\2\2\2\u0189\u018a\b\23\16\2\u018a"+
		"&\3\2\2\2\u018b\u018c\78\2\2\u018c\u018d\7\62\2\2\u018d\u018e\7\63\2\2"+
		"\u018e\u018f\7\63\2\2\u018f\u0190\7/\2\2\u0190\u0191\3\2\2\2\u0191\u0192"+
		"\5\25\13\2\u0192\u0193\5\25\13\2\u0193\u0194\5\25\13\2\u0194\u0195\5\25"+
		"\13\2\u0195\u0196\7/\2\2\u0196\u0197\5\25\13\2\u0197\u0198\5\25\13\2\u0198"+
		"\u0199\5\25\13\2\u0199\u019a\5\25\13\2\u019a\u019b\7/\2\2\u019b\u019c"+
		"\5\25\13\2\u019c\u019d\5\25\13\2\u019d\u019e\5\25\13\2\u019e\u019f\5\25"+
		"\13\2\u019f\u01b6\3\2\2\2\u01a0\u01a1\78\2\2\u01a1\u01a2\7\67\2\2\u01a2"+
		"\u01a3\3\2\2\2\u01a3\u01a4\5\25\13\2\u01a4\u01a5\5\25\13\2\u01a5\u01a6"+
		"\7/\2\2\u01a6\u01a7\5\25\13\2\u01a7\u01a8\5\25\13\2\u01a8\u01a9\5\25\13"+
		"\2\u01a9\u01aa\5\25\13\2\u01aa\u01ab\7/\2\2\u01ab\u01ac\5\25\13\2\u01ac"+
		"\u01ad\5\25\13\2\u01ad\u01ae\5\25\13\2\u01ae\u01af\5\25\13\2\u01af\u01b0"+
		"\7/\2\2\u01b0\u01b1\5\25\13\2\u01b1\u01b2\5\25\13\2\u01b2\u01b3\5\25\13"+
		"\2\u01b3\u01b4\5\25\13\2\u01b4\u01b6\3\2\2\2\u01b5\u018b\3\2\2\2\u01b5"+
		"\u01a0\3\2\2\2\u01b6\u01b7\3\2\2\2\u01b7\u01b8\b\24\17\2\u01b8(\3\2\2"+
		"\2\u01b9\u01ba\7\65\2\2\u01ba\u01bb\7\67\2\2\u01bb\u01bc\3\2\2\2\u01bc"+
		"\u01bd\5\25\13\2\u01bd\u01be\5\25\13\2\u01be\u01bf\7/\2\2\u01bf\u01c0"+
		"\5\25\13\2\u01c0\u01c1\5\25\13\2\u01c1\u01c2\5\25\13\2\u01c2\u01c3\5\25"+
		"\13\2\u01c3\u01c4\7/\2\2\u01c4\u01c5\5\25\13\2\u01c5\u01c6\5\25\13\2\u01c6"+
		"\u01c7\5\25\13\2\u01c7\u01c8\5\25\13\2\u01c8\u01c9\7/\2\2\u01c9\u01ca"+
		"\5\25\13\2\u01ca\u01cb\5\25\13\2\u01cb\u01cc\5\25\13\2\u01cc\u01cd\5\25"+
		"\13\2\u01cd\u01f7\3\2\2\2\u01ce\u01cf\7\64\2\2\u01cf\u01d0\7\63\2\2\u01d0"+
		"\u01d1\7\65\2\2\u01d1\u01d2\7\63\2\2\u01d2\u01d3\7/\2\2\u01d3\u01d4\3"+
		"\2\2\2\u01d4\u01d5\5\25\13\2\u01d5\u01d6\5\25\13\2\u01d6\u01d7\5\25\13"+
		"\2\u01d7\u01d8\5\25\13\2\u01d8\u01d9\7/\2\2\u01d9\u01da\5\25\13\2\u01da"+
		"\u01db\5\25\13\2\u01db\u01dc\5\25\13\2\u01dc\u01dd\5\25\13\2\u01dd\u01de"+
		"\7/\2\2\u01de\u01df\5\25\13\2\u01df\u01e0\5\25\13\2\u01e0\u01e1\5\25\13"+
		"\2\u01e1\u01f7\3\2\2\2\u01e2\u01e3\7\63\2\2\u01e3\u01e4\7:\2\2\u01e4\u01e5"+
		"\7\62\2\2\u01e5\u01e6\7\62\2\2\u01e6\u01e7\7/\2\2\u01e7\u01e8\3\2\2\2"+
		"\u01e8\u01e9\5\25\13\2\u01e9\u01ea\5\25\13\2\u01ea\u01eb\5\25\13\2\u01eb"+
		"\u01ec\5\25\13\2\u01ec\u01ed\7/\2\2\u01ed\u01ee\5\25\13\2\u01ee\u01ef"+
		"\5\25\13\2\u01ef\u01f0\5\25\13\2\u01f0\u01f1\5\25\13\2\u01f1\u01f2\7/"+
		"\2\2\u01f2\u01f3\5\25\13\2\u01f3\u01f4\5\25\13\2\u01f4\u01f5\5\25\13\2"+
		"\u01f5\u01f7\3\2\2\2\u01f6\u01b9\3\2\2\2\u01f6\u01ce\3\2\2\2\u01f6\u01e2"+
		"\3\2\2\2\u01f7\u01f8\3\2\2\2\u01f8\u01f9\b\25\20\2\u01f9*\3\2\2\2\u01fa"+
		"\u01fc\5/\30\2\u01fb\u01fa\3\2\2\2\u01fc\u01ff\3\2\2\2\u01fd\u01fb\3\2"+
		"\2\2\u01fd\u01fe\3\2\2\2\u01fe\u0200\3\2\2\2\u01ff\u01fd\3\2\2\2\u0200"+
		"\u0204\7B\2\2\u0201\u0203\5-\27\2\u0202\u0201\3\2\2\2\u0203\u0206\3\2"+
		"\2\2\u0204\u0202\3\2\2\2\u0204\u0205\3\2\2\2\u0205\u0207\3\2\2\2\u0206"+
		"\u0204\3\2\2\2\u0207\u0208\b\26\21\2\u0208,\3\2\2\2\u0209\u020a\t\6\2"+
		"\2\u020a.\3\2\2\2\u020b\u020c\t\7\2\2\u020c\u020d\t\b\2\2\u020d\u020e"+
		"\t\7\2\2\u020e\60\3\2\2\2\u020f\u0210\t\t\2\2\u0210\u0216\t\3\2\2\u0211"+
		"\u0212\7\65\2\2\u0212\u0216\7\62\2\2\u0213\u0214\7\65\2\2\u0214\u0216"+
		"\7\63\2\2\u0215\u020f\3\2\2\2\u0215\u0211\3\2\2\2\u0215\u0213\3\2\2\2"+
		"\u0216\62\3\2\2\2\u0217\u0218\t\n\2\2\u0218\u021c\t\13\2\2\u0219\u021a"+
		"\7\63\2\2\u021a\u021c\t\t\2\2\u021b\u0217\3\2\2\2\u021b\u0219\3\2\2\2"+
		"\u021c\64\3\2\2\2\u021d\u021e\7\64\2\2\u021e\u021f\t\f\2\2\u021f\u0220"+
		"\t\3\2\2\u0220\u0221\t\3\2\2\u0221\66\3\2\2\2\u0222\u0223\5\61\31\2\u0223"+
		"\u0224\7\61\2\2\u0224\u0225\5\63\32\2\u0225\u0226\7\61\2\2\u0226\u0227"+
		"\5\65\33\2\u0227\u0228\b\34\22\2\u02288\3\2\2\2\u0229\u022b\t\r\2\2\u022a"+
		"\u0229\3\2\2\2\u022b\u022c\3\2\2\2\u022c\u022a\3\2\2\2\u022c\u022d\3\2"+
		"\2\2\u022d\u022e\3\2\2\2\u022e\u022f\b\35\23\2\u022f:\3\2\2\2\24\2JYj"+
		"\u0085\u0097\u00a0\u00a5\u0108\u014a\u0187\u01b5\u01f6\u01fd\u0204\u0215"+
		"\u021b\u022c\24\3\6\2\3\7\3\3\b\4\3\t\5\3\n\6\3\f\7\3\r\b\3\16\t\3\17"+
		"\n\3\20\13\3\21\f\3\22\r\3\23\16\3\24\17\3\25\20\3\26\21\3\34\22\3\35"+
		"\23";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}