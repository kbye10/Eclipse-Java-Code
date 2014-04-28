/*
 * Kevin Bye 3/12/2013
 * 
 *  Infix to Postfix conversion and evaluation methods
 */

import java.util.*;

public class Conversion {
	 Stack<Character> stack = new Stack<Character>();	// Declares and initializes stacks to be used
	 Stack<Character> postfix = new Stack<Character>();
	 Stack<Integer> intStack = new Stack<Integer>();
	 char topsymbol, symbol;							// Declare and initializes variables needed
	 int counter = 0;
	 String output;
	
	public String Convert(String in){					// Method for doing conversion

		while (!in.substring(counter, in.length()).isEmpty())	// While not end of input string
		{
			symbol = in.charAt(counter);			// Reads next symbol and assigns it to symbol variable 
			if((symbol=='0') || (symbol=='1') || (symbol=='2') ||	
				(symbol == '3') ||(symbol=='4')||(symbol=='5')||(symbol=='6')||
				(symbol=='7')||(symbol=='8')||(symbol=='9'))
				// If symbol is a number, push to stack
			{
				postfix.push(symbol);
				//System.out.println("Pushed number to postfix");		used for testing
			}
			
			else 		// the symbol is an operator
			{
				while (!(stack.isEmpty()) && precedence(stack.peek(),symbol))
				// While stack isn't empty and the item on the top of stack is higher precedence than 
				// the current operator
				{
					topsymbol = stack.pop();
					if (!(topsymbol =='('))
					{
						postfix.push(topsymbol);
					}
					// Pops top of stack and pushes it to postfix string if it's not a parentheses
				}	// End While loop
				
				if (!(symbol == ')'))
				// If operator is not parentheses, push to stack
				{
				stack.push(symbol);
				//System.out.println("Pushed operator to stack");		used for testing
				}
			}
			counter++;		// increment counter to continue through input string
		}	// End While loop
		while (!stack.isEmpty())
		// Input string is done being processed, so we need to empty the stack.  While
		// stack isn't empty, pop the top item and push it to postfix string
			
		{
			topsymbol = stack.pop();
			if (!(topsymbol =='('))
			{
				postfix.push(topsymbol);
			}
		}		// End While loop
		
		for (int i=0;i<postfix.size();i++)
		// Takes contents of postfix stack and outputs it to a string
		{
		output=output+postfix.get(i);
		}
		return output.substring(4);	// String prints out "null" at front, so cut out the first 4 chars
	}
	
	public static boolean precedence (char a, char b) {
		// Compares operators to set which has higher priority
		// ex. '*' is higher priority than '-'
		if ((a == '+' || a == '-') && (b == '+' || b == '-'))
		{
			//System.out.println("Precedence true");		used for testing
			return true;
		}
		if ((a == '+' || a == '-') && (b == '*' || b == '/'))
		{
			//System.out.println("Precedence false");		used for testing
			return false;
		}
		if ((a == '*' || a == '/') && (b == '+' || b == '-'))
		{
			//System.out.println("Precedence true");		used for testing
			return true;
		}
		if ((a == '*' || a == '/') && (b == '*' || b == '/'))
		{
			//System.out.println("Precedence true");		used for testing
			return true;
		}
		if (a == ')' && b == '(')
		{
			//System.out.println("Precedence true");		used for testing
			return true;
		}
		if (b == '(')
		{
			//System.out.println("Precedence false");		used for testing
			return false;
		}
		if (a == '(')
		{
			//System.out.println("Precedence false");		used for testing
			return false;
		}
		if (a == '(' && b == ')')
		{
			//System.out.println("Precedence false");		used for testing
			return false;
		}
		else
		{
			//System.out.println("Precedence true");		used for testing
			return true;
		}

	}
	
	public int Evaluate(String input){
		int opr1,opr2;						// Declare and initialize variables
		int result = 0;
		for (int i=0;i<input.length();i++)
		// Goes through input string to evaluate it
		{
			symbol = input.charAt(i);		// Read next symbol, assign it to symbol variable
			if(!(symbol == '+') && !(symbol == '-') && !(symbol == '*') && !(symbol == '/'))
			// If symbol is number, push it to stack 
			{
				intStack.push((int)symbol-48);// Converting char to int needs to subtract 48 to normalize number
				//System.out.println("Pushed number: "+symbol);		used for testing
			}
			else
			// Symbol is operator
			{
				//System.out.println(intStack.toString());		used for testing
				opr2 = intStack.pop();
				//System.out.println("Popped opr2: "+opr2);		used for testing
				opr1 = intStack.pop();
				//System.out.println("Popped opr1: "+opr1);		used for testing
				
				switch (symbol) 
				// Checks what operator the symbol is and performs corresponding action
				{
				case '+':
					result=opr1+opr2;
					//System.out.println("Added: "+result);		used for testing
					break;
				
				case '-':
					result=opr1-opr2;
					//System.out.println("Subtract: "+result);	used for testing
					break;
				
				case '/':
					result=opr1/opr2;
					//System.out.println("Divided: "+result);		used for testing
					break;
				
				case '*':
					result=opr1*opr2;
					//System.out.println("Multiplied: "+result);	used for testing
					break;
				}
				// Push result back onto stack for possible next operation or output
				intStack.push(result);
				//System.out.println("Pushed result");			used for testing
			}
		
		}
		// Pop last item and set result to that value
		result = intStack.pop();
		// Return answer
		return result;
	}
	}
