grammar SimpleCalculator;

@header {
import java.util.Stack;
import java.util.EmptyStackException;
}

@members {
Stack<Integer> s = new Stack<Integer>();
Stack<Boolean> b = new Stack<Boolean>();
int n = 0;
boolean errorFlag = false;
}

DIGIT	:	'0'..'9';
AND		: '&&';
OR 		: '||';
INVERT	: '!';
LESS	: '<';
LESSEQ	: '<=';
EQUALS	: '==';
NOTEQ	: '!=';
GREAT	: '>';
GREATEQ	: '>=';
ENDRPN	: ';';
TRUE	: 'true';
FALSE	: 'false';
PLUS 	: '+';
MINUS 	: '-';
MULT 	: '*';
DIV 	: '/';
MOD : '%';

start: (WS* (rpn) (WS | WS* ENDRPN {
						
						if(s.empty() && !b.empty())
						{
							Boolean y = b.pop();
							if(b.empty())
								System.out.print(y+$ENDRPN.text);
							else 
								System.out.print("Error. Check the number of boolean statements"+$ENDRPN.text);
						}
						else if(!s.empty() && b.empty())
						{
							int x = s.pop();
							if(s.empty())
								System.out.print(x+$ENDRPN.text);
							else 
								System.out.print("Error. Check the number of math statements"+$ENDRPN.text);
						}
						else 
							System.out.print("Error. Check your syntax"+$ENDRPN.text);
					}))*;
rpn	: 
	((' ' | '\t')? (bool|num|numop|boolop) ' '?)+
	;	
// Let's handle the numbers here
num	:	nm {
			if(!errorFlag)
				{
				// Let's check if it is an int. If it is a double, error time
				try { 
					Integer.parseInt($nm.text);
					}
				catch(NumberFormatException e) { 
       			 	errorFlag = true; 
   					}
				if(!errorFlag) s.push(Integer.parseInt($nm.text));
				}
			};
nm 	: 	'-'? DIGIT+ ('.' DIGIT+)?;

// Lots of copying and pasting here... Need to learn easier ways for error checking
numop	
	: MINUS {
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
	| DIV {
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
	| MULT {
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
	| PLUS {
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
	| MOD {
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
	;

// Boolean time!
bool : booltext { b.push(Boolean.valueOf($booltext.text)); };
booltext : (TRUE | FALSE);

boolop	: INVERT {Boolean x = b.pop(); b.push(!x); }
	| LESS {int x = s.pop(); int y = s.pop(); b.push(Boolean.valueOf(y < x)); }
	| LESSEQ {int x = s.pop(); int y = s.pop(); b.push(Boolean.valueOf(y <= x)); }
	| EQUALS {int x = s.pop(); int y = s.pop(); b.push(Boolean.valueOf(y == x)); }
	| NOTEQ {int x = s.pop(); int y = s.pop(); b.push(Boolean.valueOf(y != x)); }
	| GREAT {int x = s.pop(); int y = s.pop(); b.push(Boolean.valueOf(y > x)); }
	| GREATEQ {int x = s.pop(); int y = s.pop(); b.push(Boolean.valueOf(y >= x)); }
	| AND {Boolean x = b.pop(); Boolean y = b.pop(); b.push(Boolean.valueOf(y && x)); }
	| OR {Boolean x = b.pop(); Boolean y = b.pop(); b.push(Boolean.valueOf(y || x)); };



WS	:	(' ' | '\t' | '\r' | '\n'){skip();};
