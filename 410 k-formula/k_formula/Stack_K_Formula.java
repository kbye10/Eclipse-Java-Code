package k_formula;

import java.util.Stack;

public class Stack_K_Formula {
	
	public static void ConvertStack(char[] input){
		// Initializes variables and stack
		Stack<Character> stack = new Stack<Character>();
		char star = '*';
		stack.push(input[input.length-1]);		// Push first 2 letters onto stack
		stack.push(input[input.length-2]);
		for(int pointer=(input.length-3);pointer>=0;pointer--){
			// Goes through input array from right to left
			char symbol = input[pointer];
			if (symbol != '*'){
				// Symbol is a letter, so push it onto stack
				stack.push(input[pointer]);		
			}
			else {
				/* 
				 Symbol is a '*', as long as the stack has 2 or more items:
				 pop top 2 letters and print the output line,
				 then push first letter back onto stack
				*/
				if (stack.size() >= 2){	
					char symbol1 = stack.pop();	
					char symbol2 = stack.pop();
					System.out.print(star);
					System.out.print(symbol1);
					System.out.println(symbol2);
					stack.push(symbol1);
				}
				else {
					// Stack has lees than 2 letters, so Error: Invalid K-formula, exit loop
					System.out.println("Invalid K-formula");
					pointer= -1;
				}
			}
		}
		
		// Checks at the end if the stack has anything other than 1 letter in it,
		// if so, Error: Invalid K-formula
		if (stack.size() != 1) {
			System.out.println("Invalid K-Formula");
		}
			
			
		}


public static void main(String[] args) {
	char[] formula1 = {'*','*','*','a','b','c','d'};
	char[] formula2 = {'*','*','a','b','*','c','d'};
	char[] formula3 = {'*','*','*','a','*','*','*','b','b','c','e','c','d'};
	char[] formula4 = {'*','a','*','*','d','*','b','*','*','c','d','*','e','a'};
	char[] formula5 = {'*','*','*','a','*','b','c','*','*','d','c','b'};
	char[] formula6 = {'a','*','*','b','*','c','d'};
	System.out.println("Implementation using Stack ");
	System.out.println("\n"+"Formula 1:");
	ConvertStack(formula1);
	System.out.println("\n"+"Formula 2:");
	ConvertStack(formula2);
	System.out.println("\n"+"Formula 3:");
	ConvertStack(formula3);
	System.out.println("\n"+"Formula 4:");
	ConvertStack(formula4);
	System.out.println("\n"+"Formula 5:");
	ConvertStack(formula5);
	System.out.println("\n"+"Formula 6:");
	ConvertStack(formula6);
}

}
