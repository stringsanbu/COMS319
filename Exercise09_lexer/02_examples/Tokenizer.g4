lexer grammar Tokenizer;

@lexer::members {
  boolean searchEmail=false;
  boolean searchDate=false;
  boolean searchPhone=false;
  boolean searchCard=false;
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
			System.out.println("Found endtag: " + getText());
			searchCard=false;
		}
	};

NAME: '<'[a-zA-Z]*'>'|'<''/'[a-zA-Z]*'>'
	{
		//[^'EMAIL''DATE''PHONE''CREDITCARD''XML''Xml''xml'' ']
		System.out.println("Found an element that is not email, date, phone, or credit card.  Skipping to next line.");	
	};
	
fragment DOMAIN: [a-zA-Z0-9.-];
fragment LOCALPART: [a-zA-Z0-9_~!$')(*+,;=:]*'@';

EmailOut: LOCALPART*DOMAIN*
	{
		System.out.println("Email is: "+getText());
	};
	
fragment DIGIT: [0123456789];

Phone1: 'DIGIT{3}''.''DIGIT{3}''.''DIGIT{4}'
	{
		System.out.println("Found phone number: "+getText());
	};
Phone2: '('.'DIGIT{3}'')'.' ''DIGIT{3}''-''DIGIT{4}'
	{
		System.out.println("Found phone number: "+getText());
	};
Phone3: 'DIGIT{3}'' ''DIGIT{3}'' ''DIGIT{4}'
	{
		System.out.println("Found phone number: "+getText());
	};
Phone4: 'DIGIT{3}''-''DIGIT{3}''-''DIGIT{4}'
	{
		System.out.println("Found phone number: "+getText());
	};


//NUMBER: DIGIT { System.out.println("found number: " + getText()); };

//WORD: ALPHA ( ALPHA | DIGIT )*
//       {
//         System.out.println("found word: " + getText()); 
//       };
//fragment ALPHA: [a-zA-Z] ;
 WS: [ \r\t\n]+ {System.out.println("Moving to next line...");skip();};   


