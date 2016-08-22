package it.home.regex;

import java.util.regex.Pattern;

public class Regex {

	public static final String EXAMPLE_TEST = "foo     (bar   (    new Point(       x, graph.getY(          ))    )        );";

	public static void main(String[] args) {

		String test = "Sti cazzi auhauhau!!!";

		// returns true if the string matches exactly "true"
		System.out.println("1 " + test.matches("true"));;

		// returns true if the string matches exactly "true" or "True"
		System.out.println("2 " + test.matches("[tT]rue"));;

		// returns true if the string matches exactly "true" or "True"  or "yes" or "Yes"
		System.out.println("3 " + test.matches("[tT]rue|[yY]es"));


		// returns true if the string contains of three letters
		// simpler from for
		//			    return s.matches("[a-Z][a-Z][a-Z]");
		System.out.println("4 " + test.matches("[a-zA-Z]{3}"));


		// returns true if the string does not have a number at the beginning
		System.out.println("5 " + test.matches("\\D.*"));

		// returns true if the string contains a arbitrary number of characters except b
		System.out.println("6 " + test.matches("b+"));

		// returns true if the string contains a number less then 300

		//(xxx) xxx-xxxx and xxx-xxx-xxxx
		System.out.println("7 " + (new String("234-345-3424")).matches("\\(\\d{3}\\)\\s\\d{3}-\\d{4}|\\d{3}-\\d{3}-\\d{4}"));

		//(xxx) xxx-xxxx and xxx-xxx-xxxx
		System.out.println("8 " + (new String("ciao   ci5a  adfsa l")).matches("[ac-zAC-Z\\s*0-9]*"));

		//foo (bar ( new Point(x, graph.getY()) ));
		String printS = (new String("foo (bar   (     new    Point(x, graph.getY()) ));")).replaceAll("\\(\\s{0}", "( ").replaceAll("\\s{0}\\(", " (");
		printS = printS.replaceAll("\\s{2,}", " ");
		System.out.println("9 " + printS);
		
		System.out.println(Pattern.matches("(\\w\\d)\\1", "a2a2")); //true
		System.out.println(Pattern.matches("(\\w\\d)\\1", "a2b2")); //false
		System.out.println(Pattern.matches("(AB)(B\\d)\\2\\1", "ABB2B2AB")); //true
		System.out.println(Pattern.matches("(AB)(B\\d)\\2\\1", "ABB2B3AB")); //false
		
		System.out.println("continene la parola cazzo: " + stringSenzaC(test));
		
	}
	
	public static boolean stringSenzaC(String test){
		return test.matches("(.*)c\\w*zz\\w*(.*)");
	}

}
