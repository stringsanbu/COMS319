lexer grammar Tokenizer;

//authors Group 6: Ryan Tigges and Mason Berhenke
@lexer::members {
  boolean searchEmail=false;
  boolean searchDate=false;
  boolean searchPhone=false;
  boolean searchCard=false;
  boolean foundEmail=false;
  boolean foundDate=false;
  boolean foundPhone=false;
  boolean foundCard=false;
}

fragment EMAIL: '<email>'|'</email>';
fragment DATE: '<date>'|'</date>';
fragment PHONE: '<phone>'|'</phone>';
fragment CREDITCARD: '<creditcard>'|'</creditcard>';

EMAILTAG: EMAIL 
	{	
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
	};
DATETAG: DATE
	{	
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
	};
PHONETAG: PHONE
	{	
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
	};
CREDITCARDTAG: CREDITCARD
	{
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
	};

NAME: '<'[a-zA-Z]*'>'|'<''/'[a-zA-Z]*'>'
	{
		//if(getText()=="XML"||getText()=="Xml"|| getText()=="xml"||getText()==" ")
			System.out.println("Found an element that is not email, date, phone, or credit card.  Skipping...");	
	};

fragment DIGIT: [0-9];

Phone1: DIGIT DIGIT DIGIT '.'DIGIT DIGIT DIGIT'.'DIGIT DIGIT DIGIT DIGIT
	{
		System.out.println("Found phone number: "+getText());
		foundPhone=true;
	};
Phone2: DIGIT DIGIT DIGIT ' 'DIGIT DIGIT DIGIT' 'DIGIT DIGIT DIGIT DIGIT
	{
		System.out.println("Found phone number: "+getText());
		foundPhone=true;
	};
Phone3: DIGIT DIGIT DIGIT '-'DIGIT DIGIT DIGIT'-'DIGIT DIGIT DIGIT DIGIT
	{
		System.out.println("Found phone number: "+getText());
		foundPhone=true;
	};
Phone4: '('DIGIT DIGIT DIGIT')'' 'DIGIT DIGIT DIGIT'-'DIGIT DIGIT DIGIT DIGIT
	{
		System.out.println("Found phone number: "+getText());
		foundPhone=true;
	};
	
VISACARD: ('4'DIGIT DIGIT DIGIT'-'DIGIT DIGIT DIGIT DIGIT'-'DIGIT DIGIT DIGIT DIGIT'-'DIGIT DIGIT DIGIT DIGIT | 
	'4'DIGIT DIGIT DIGIT'-'DIGIT DIGIT DIGIT DIGIT'-'DIGIT DIGIT DIGIT DIGIT'-'DIGIT)
	{
		System.out.println("Found Visa card, the number is: "+getText());
		foundCard=true;
	};
	
MASTERCARD: '5'[1-5] DIGIT DIGIT'-'DIGIT DIGIT DIGIT DIGIT'-'DIGIT DIGIT DIGIT DIGIT'-'DIGIT DIGIT DIGIT DIGIT 
	{
		System.out.println("Found Mastercard card, the number is: "+getText());
		foundCard=true;
	};
	
AMERICANEXPRESS: ('34'DIGIT DIGIT'-'DIGIT DIGIT DIGIT DIGIT'-'DIGIT DIGIT DIGIT DIGIT'-'DIGIT DIGIT DIGIT | '37'DIGIT DIGIT'-'DIGIT DIGIT DIGIT DIGIT'-'DIGIT DIGIT DIGIT DIGIT'-'DIGIT DIGIT DIGIT DIGIT  )
	{
		System.out.println("Found American Express card, the number is: "+getText());
		foundCard=true;
	};

DINERSCLUB: ('30'[0-5]  DIGIT'-'DIGIT DIGIT DIGIT DIGIT'-'DIGIT DIGIT DIGIT DIGIT'-'DIGIT DIGIT   | '336'  DIGIT'-'DIGIT DIGIT DIGIT DIGIT'-'DIGIT DIGIT DIGIT DIGIT'-'DIGIT DIGIT  | '338'  DIGIT'-'DIGIT DIGIT DIGIT DIGIT'-'DIGIT DIGIT DIGIT DIGIT'-'DIGIT DIGIT  )
	{
		System.out.println("Found Diners Club card, the number is: "+getText());
		foundCard=true;
	};
	
DISCOVER: ('6011-'DIGIT DIGIT DIGIT DIGIT'-'DIGIT DIGIT DIGIT DIGIT'-'DIGIT DIGIT DIGIT DIGIT | '65' DIGIT DIGIT'-'DIGIT DIGIT DIGIT DIGIT'-'DIGIT DIGIT DIGIT DIGIT'-'DIGIT DIGIT DIGIT DIGIT)
	{
		System.out.println("Found Discover card, the number is: "+getText());
		foundCard=true;
	};
	
JCB: ('35' DIGIT DIGIT'-'DIGIT DIGIT DIGIT DIGIT'-'DIGIT DIGIT DIGIT DIGIT'-'DIGIT DIGIT DIGIT DIGIT | '2131-' DIGIT DIGIT DIGIT DIGIT'-'DIGIT DIGIT DIGIT DIGIT'-'DIGIT DIGIT DIGIT  | '1800-' DIGIT DIGIT DIGIT DIGIT'-'DIGIT DIGIT DIGIT DIGIT'-'DIGIT DIGIT DIGIT  )
	{
		System.out.println("Found JCB card, the number is: "+getText());
		foundCard=true;
	};	

EMAILOUT:  LOCALPART*'@'DOMAIN*
	{
		System.out.println("Email is: "+getText());
		foundEmail=true;
	};
	
fragment DOMAIN: [a-zA-Z0-9.-];
fragment LOCALPART: [a-zA-Z0-9_~!$')(*+,;=:];

fragment DAY: [0-2][0-9] | '30' | '31' ;
fragment MONTH: [0][1-9] | '1'[0-2];
fragment YEAR: '2'[0-1][0-9][0-9];

CURRENTDATE: DAY'/'MONTH'/'YEAR
	{
		System.out.println("Date is: "+getText());
		foundDate=true;
	};
	
	
 WS: [ \r\t\n]+ {System.out.println("Moving to next line...");skip();};   


