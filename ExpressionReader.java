package assignmentOne;

import java.util.ArrayList;
import java.util.Scanner;

public class ExpressionReader 
{
	private static Scanner s;
	private static String regular;
	
	// Reads all the expressions in this arrayList
	private static ArrayList<String> expressions = new ArrayList<String>();
	
	// stores the NFA
	private static NFA nfa;
	
	// stores the DFA
	private static DFA dfa;

	public static void main(String[] args) 
	{
		// Create a Scanner object
		s = new Scanner (System.in);

		//Obtain the Regular Expression from user input:
		System.out.print("Enter the Regular Expression (Exclude spaces between characters, use the | symbol for OR expressions): ");
		
		// Read the regular expression
		regular = s.next();
		
		System.out.println("You have entered the Regular Expression: " + regular);

		// Read all the expressions to apply the regular expression
		System.out.println("Enter an input string, x to terminate: ");
		while(!s.hasNext("x")) 
		{	
			System.out.println("Enter an input string, x to terminate: ");
			expressions.add (s.next());		
		}
		
		// Generate NFA using thompson algorithms with the Regular Expression
		setNfa (RegularExpression.generateNFA (regular));		
		
		// Generate DFA using the previous NFA and the Subset Construction Algorithm
		setDfa (RegularExpression.generateDFA (getNfa()));
		
		// Validate all the string with the DFA
		// yes = valid string
		// no = invalid string
		for (String str : expressions) 
		{
			if (ValidateExpression.validate(getDfa(), str)) 
			{	
				System.out.println ("The String is valid.");	
			}
			else 											
			{	
				System.out.println ("The String is invalid.");	
			}
		}
	}

	// Getters and Setters
	public static NFA getNfa() 
	{
		return nfa;
	}

	public static void setNfa(NFA nfa) 
	{
		ExpressionReader.nfa = nfa;
	}

	public static DFA getDfa() 
	{
		return dfa;
	}

	public static void setDfa(DFA dfa) 
	{
		ExpressionReader.dfa = dfa;
	}
}