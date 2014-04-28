package k_formula;

import java.util.LinkedList;

public class Linked_List_K_Formula {
	
	public static void ConvertLinkedList(char[] input){
		// Initializes variables and Linked List
		LinkedList<Character> list = new LinkedList<Character>();
		char star = '*';
		list.add(input[input.length-1]);	
		// Adds first two letters to list
		list.add(input[input.length-2]);
		for(int pointer=(input.length-3);pointer>=0;pointer--){
			// Iterates through input array from right to left
			char symbol = input[pointer];
			if (symbol != '*'){
				// Symbol is a letter, so push it onto stack
				list.add(input[pointer]);		
			}
			else {
				 
				// Symbol is a '*', as long as the stack has 2 or more items:
				// pop top 2 letters and print the output line,
				// then push first letter back onto stack
				
				if (list.size() >= 2){	
					char symbol1 = list.removeLast();	
					char symbol2 = list.removeLast();
					System.out.print(star);
					System.out.print(symbol1);
					System.out.println(symbol2);
					list.add(symbol1);
				}
				else {
					// Stack has lees than 2 letters, so Error: Invalid K-formula, exit loop
					System.out.println("Invalid K-formula");
					pointer= -1;
				}
			}
			}
		}

	public static void main(String[] args) {
		char[] formula1 = {'*','*','*','a','b','c','d'};
		char[] formula2 = {'*','*','a','b','*','c','d'};
		char[] formula3 = {'*','*','*','a','*','*','*','b','b','c','e','c','d'};
		char[] formula4 = {'*','a','*','*','d','*','b','*','*','c','d','*','e','a'};
		char[] formula5 = {'*','*','*','a','*','b','c','*','*','d','c','b'};
		char[] formula6 = {'a','*','*','b','*','c','d'};
		System.out.println("Implementation using Linked List");
		System.out.println("\n"+"Formula 1:");
		ConvertLinkedList(formula1);
		System.out.println("\n"+"Formula 2:");
		ConvertLinkedList(formula2);
		System.out.println("\n"+"Formula 3:");
		ConvertLinkedList(formula3);
		System.out.println("\n"+"Formula 4:");
		ConvertLinkedList(formula4);
		System.out.println("\n"+"Formula 5:");
		ConvertLinkedList(formula5);
		System.out.println("\n"+"Formula 6:");
		ConvertLinkedList(formula6);
}
	
}
