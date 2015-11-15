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
		EMAILTAG=1, DATETAG=2, PHONETAG=3, CREDITCARDTAG=4, NAME=5, EmailOut=6, 
		Phone1=7, Phone2=8, Phone3=9, Phone4=10, WS=11;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'"
	};
	public static final String[] ruleNames = {
		"EMAIL", "DATE", "PHONE", "CREDITCARD", "EMAILTAG", "DATETAG", "PHONETAG", 
		"CREDITCARDTAG", "NAME", "DOMAIN", "LOCALPART", "EmailOut", "DIGIT", "Phone1", 
		"Phone2", "Phone3", "Phone4", "WS"
	};


	  boolean searchEmail=false;
	  boolean searchDate=false;
	  boolean searchPhone=false;
	  boolean searchCard=false;


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
		case 11: EmailOut_action((RuleContext)_localctx, actionIndex); break;
		case 13: Phone1_action((RuleContext)_localctx, actionIndex); break;
		case 14: Phone2_action((RuleContext)_localctx, actionIndex); break;
		case 15: Phone3_action((RuleContext)_localctx, actionIndex); break;
		case 16: Phone4_action((RuleContext)_localctx, actionIndex); break;
		case 17: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void Phone1_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 6: 
				System.out.println("Found phone number: "+getText());
			 break;
		}
	}
	private void Phone3_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 8: 
				System.out.println("Found phone number: "+getText());
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
					System.out.println("Found endtag: " + getText());
					searchPhone=false;
				}
			 break;
		}
	}
	private void Phone2_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 7: 
				System.out.println("Found phone number: "+getText());
			 break;
		}
	}
	private void Phone4_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 9: 
				System.out.println("Found phone number: "+getText());
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
					System.out.println("Found endtag: " + getText());
					searchEmail=false;
				}
			 break;
		}
	}
	private void EmailOut_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 5: 
				System.out.println("Email is: "+getText());
			 break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 10: System.out.println("Moving to next line...");skip(); break;
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
					System.out.println("Found endtag: " + getText());
					searchCard=false;
				}
			 break;
		}
	}
	private void NAME_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 4: 
				//[^'EMAIL''DATE''PHONE''CREDITCARD''XML''Xml''xml'' ']
				System.out.println("Found an element that is not email, date, phone, or credit card.  Skipping to next line.");	
			 break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\r\u0134\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\5\2\67\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3F\n"+
		"\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4W\n"+
		"\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5r\n\5\3\6\3\6\3\6\3\7\3\7\3\7\3\b"+
		"\3\b\3\b\3\t\3\t\3\t\3\n\3\n\7\n\u0082\n\n\f\n\16\n\u0085\13\n\3\n\3\n"+
		"\3\n\3\n\7\n\u008b\n\n\f\n\16\n\u008e\13\n\3\n\3\n\5\n\u0092\n\n\3\13"+
		"\3\13\3\f\7\f\u0097\n\f\f\f\16\f\u009a\13\f\3\f\3\f\3\r\7\r\u009f\n\r"+
		"\f\r\16\r\u00a2\13\r\3\r\7\r\u00a5\n\r\f\r\16\r\u00a8\13\r\3\r\3\r\3\16"+
		"\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\23\6\23\u012f\n\23\r\23\16\23\u0130\3\23\3\23\2\2\24"+
		"\3\2\5\2\7\2\t\2\13\3\r\4\17\5\21\6\23\7\25\2\27\2\31\b\33\2\35\t\37\n"+
		"!\13#\f%\r\3\2\7\4\2C\\c|\6\2/\60\62;C\\c|\13\2##&&).\62=??C\\aac|\u0080"+
		"\u0080\3\2\62;\5\2\13\f\17\17\"\"\u0137\2\13\3\2\2\2\2\r\3\2\2\2\2\17"+
		"\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\31\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\3\66\3\2\2\2\5E\3\2\2\2\7V\3\2\2"+
		"\2\tq\3\2\2\2\13s\3\2\2\2\rv\3\2\2\2\17y\3\2\2\2\21|\3\2\2\2\23\u0091"+
		"\3\2\2\2\25\u0093\3\2\2\2\27\u0098\3\2\2\2\31\u00a0\3\2\2\2\33\u00ab\3"+
		"\2\2\2\35\u00ad\3\2\2\2\37\u00cc\3\2\2\2!\u00ef\3\2\2\2#\u010e\3\2\2\2"+
		"%\u012e\3\2\2\2\'(\7>\2\2()\7g\2\2)*\7o\2\2*+\7c\2\2+,\7k\2\2,-\7n\2\2"+
		"-\67\7@\2\2./\7>\2\2/\60\7\61\2\2\60\61\7g\2\2\61\62\7o\2\2\62\63\7c\2"+
		"\2\63\64\7k\2\2\64\65\7n\2\2\65\67\7@\2\2\66\'\3\2\2\2\66.\3\2\2\2\67"+
		"\4\3\2\2\289\7>\2\29:\7f\2\2:;\7c\2\2;<\7v\2\2<=\7g\2\2=F\7@\2\2>?\7>"+
		"\2\2?@\7\61\2\2@A\7f\2\2AB\7c\2\2BC\7v\2\2CD\7g\2\2DF\7@\2\2E8\3\2\2\2"+
		"E>\3\2\2\2F\6\3\2\2\2GH\7>\2\2HI\7r\2\2IJ\7j\2\2JK\7q\2\2KL\7p\2\2LM\7"+
		"g\2\2MW\7@\2\2NO\7>\2\2OP\7\61\2\2PQ\7r\2\2QR\7j\2\2RS\7q\2\2ST\7p\2\2"+
		"TU\7g\2\2UW\7@\2\2VG\3\2\2\2VN\3\2\2\2W\b\3\2\2\2XY\7>\2\2YZ\7e\2\2Z["+
		"\7t\2\2[\\\7g\2\2\\]\7f\2\2]^\7k\2\2^_\7v\2\2_`\7e\2\2`a\7c\2\2ab\7t\2"+
		"\2bc\7f\2\2cr\7@\2\2de\7>\2\2ef\7\61\2\2fg\7e\2\2gh\7t\2\2hi\7g\2\2ij"+
		"\7f\2\2jk\7k\2\2kl\7v\2\2lm\7e\2\2mn\7c\2\2no\7t\2\2op\7f\2\2pr\7@\2\2"+
		"qX\3\2\2\2qd\3\2\2\2r\n\3\2\2\2st\5\3\2\2tu\b\6\2\2u\f\3\2\2\2vw\5\5\3"+
		"\2wx\b\7\3\2x\16\3\2\2\2yz\5\7\4\2z{\b\b\4\2{\20\3\2\2\2|}\5\t\5\2}~\b"+
		"\t\5\2~\22\3\2\2\2\177\u0083\7>\2\2\u0080\u0082\t\2\2\2\u0081\u0080\3"+
		"\2\2\2\u0082\u0085\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084"+
		"\u0086\3\2\2\2\u0085\u0083\3\2\2\2\u0086\u0092\7@\2\2\u0087\u0088\7>\2"+
		"\2\u0088\u008c\7\61\2\2\u0089\u008b\t\2\2\2\u008a\u0089\3\2\2\2\u008b"+
		"\u008e\3\2\2\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008f\3\2"+
		"\2\2\u008e\u008c\3\2\2\2\u008f\u0090\7@\2\2\u0090\u0092\b\n\6\2\u0091"+
		"\177\3\2\2\2\u0091\u0087\3\2\2\2\u0092\24\3\2\2\2\u0093\u0094\t\3\2\2"+
		"\u0094\26\3\2\2\2\u0095\u0097\t\4\2\2\u0096\u0095\3\2\2\2\u0097\u009a"+
		"\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009b\3\2\2\2\u009a"+
		"\u0098\3\2\2\2\u009b\u009c\7B\2\2\u009c\30\3\2\2\2\u009d\u009f\5\27\f"+
		"\2\u009e\u009d\3\2\2\2\u009f\u00a2\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1"+
		"\3\2\2\2\u00a1\u00a6\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a3\u00a5\5\25\13\2"+
		"\u00a4\u00a3\3\2\2\2\u00a5\u00a8\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a6\u00a7"+
		"\3\2\2\2\u00a7\u00a9\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a9\u00aa\b\r\7\2\u00aa"+
		"\32\3\2\2\2\u00ab\u00ac\t\5\2\2\u00ac\34\3\2\2\2\u00ad\u00ae\7F\2\2\u00ae"+
		"\u00af\7K\2\2\u00af\u00b0\7I\2\2\u00b0\u00b1\7K\2\2\u00b1\u00b2\7V\2\2"+
		"\u00b2\u00b3\7}\2\2\u00b3\u00b4\7\65\2\2\u00b4\u00b5\7\177\2\2\u00b5\u00b6"+
		"\3\2\2\2\u00b6\u00b7\7\60\2\2\u00b7\u00b8\7F\2\2\u00b8\u00b9\7K\2\2\u00b9"+
		"\u00ba\7I\2\2\u00ba\u00bb\7K\2\2\u00bb\u00bc\7V\2\2\u00bc\u00bd\7}\2\2"+
		"\u00bd\u00be\7\65\2\2\u00be\u00bf\7\177\2\2\u00bf\u00c0\3\2\2\2\u00c0"+
		"\u00c1\7\60\2\2\u00c1\u00c2\7F\2\2\u00c2\u00c3\7K\2\2\u00c3\u00c4\7I\2"+
		"\2\u00c4\u00c5\7K\2\2\u00c5\u00c6\7V\2\2\u00c6\u00c7\7}\2\2\u00c7\u00c8"+
		"\7\66\2\2\u00c8\u00c9\7\177\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cb\b\17\b"+
		"\2\u00cb\36\3\2\2\2\u00cc\u00cd\7*\2\2\u00cd\u00ce\13\2\2\2\u00ce\u00cf"+
		"\7F\2\2\u00cf\u00d0\7K\2\2\u00d0\u00d1\7I\2\2\u00d1\u00d2\7K\2\2\u00d2"+
		"\u00d3\7V\2\2\u00d3\u00d4\7}\2\2\u00d4\u00d5\7\65\2\2\u00d5\u00d6\7\177"+
		"\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d8\7+\2\2\u00d8\u00d9\13\2\2\2\u00d9"+
		"\u00da\7\"\2\2\u00da\u00db\7F\2\2\u00db\u00dc\7K\2\2\u00dc\u00dd\7I\2"+
		"\2\u00dd\u00de\7K\2\2\u00de\u00df\7V\2\2\u00df\u00e0\7}\2\2\u00e0\u00e1"+
		"\7\65\2\2\u00e1\u00e2\7\177\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e4\7/\2\2"+
		"\u00e4\u00e5\7F\2\2\u00e5\u00e6\7K\2\2\u00e6\u00e7\7I\2\2\u00e7\u00e8"+
		"\7K\2\2\u00e8\u00e9\7V\2\2\u00e9\u00ea\7}\2\2\u00ea\u00eb\7\66\2\2\u00eb"+
		"\u00ec\7\177\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00ee\b\20\t\2\u00ee \3\2\2"+
		"\2\u00ef\u00f0\7F\2\2\u00f0\u00f1\7K\2\2\u00f1\u00f2\7I\2\2\u00f2\u00f3"+
		"\7K\2\2\u00f3\u00f4\7V\2\2\u00f4\u00f5\7}\2\2\u00f5\u00f6\7\65\2\2\u00f6"+
		"\u00f7\7\177\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00f9\7\"\2\2\u00f9\u00fa\7"+
		"F\2\2\u00fa\u00fb\7K\2\2\u00fb\u00fc\7I\2\2\u00fc\u00fd\7K\2\2\u00fd\u00fe"+
		"\7V\2\2\u00fe\u00ff\7}\2\2\u00ff\u0100\7\65\2\2\u0100\u0101\7\177\2\2"+
		"\u0101\u0102\3\2\2\2\u0102\u0103\7\"\2\2\u0103\u0104\7F\2\2\u0104\u0105"+
		"\7K\2\2\u0105\u0106\7I\2\2\u0106\u0107\7K\2\2\u0107\u0108\7V\2\2\u0108"+
		"\u0109\7}\2\2\u0109\u010a\7\66\2\2\u010a\u010b\7\177\2\2\u010b\u010c\3"+
		"\2\2\2\u010c\u010d\b\21\n\2\u010d\"\3\2\2\2\u010e\u010f\7F\2\2\u010f\u0110"+
		"\7K\2\2\u0110\u0111\7I\2\2\u0111\u0112\7K\2\2\u0112\u0113\7V\2\2\u0113"+
		"\u0114\7}\2\2\u0114\u0115\7\65\2\2\u0115\u0116\7\177\2\2\u0116\u0117\3"+
		"\2\2\2\u0117\u0118\7/\2\2\u0118\u0119\7F\2\2\u0119\u011a\7K\2\2\u011a"+
		"\u011b\7I\2\2\u011b\u011c\7K\2\2\u011c\u011d\7V\2\2\u011d\u011e\7}\2\2"+
		"\u011e\u011f\7\65\2\2\u011f\u0120\7\177\2\2\u0120\u0121\3\2\2\2\u0121"+
		"\u0122\7/\2\2\u0122\u0123\7F\2\2\u0123\u0124\7K\2\2\u0124\u0125\7I\2\2"+
		"\u0125\u0126\7K\2\2\u0126\u0127\7V\2\2\u0127\u0128\7}\2\2\u0128\u0129"+
		"\7\66\2\2\u0129\u012a\7\177\2\2\u012a\u012b\3\2\2\2\u012b\u012c\b\22\13"+
		"\2\u012c$\3\2\2\2\u012d\u012f\t\6\2\2\u012e\u012d\3\2\2\2\u012f\u0130"+
		"\3\2\2\2\u0130\u012e\3\2\2\2\u0130\u0131\3\2\2\2\u0131\u0132\3\2\2\2\u0132"+
		"\u0133\b\23\f\2\u0133&\3\2\2\2\16\2\66EVq\u0083\u008c\u0091\u0098\u00a0"+
		"\u00a6\u0130\r\3\6\2\3\7\3\3\b\4\3\t\5\3\n\6\3\r\7\3\17\b\3\20\t\3\21"+
		"\n\3\22\13\3\23\f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}