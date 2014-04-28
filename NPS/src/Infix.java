import java.util.Scanner;

import edu.nps.util.NPSArrayStack;
import edu.nps.util.NPSListStack;
import edu.nps.util.NPSStack;

public class Infix {

	public static String Infix(String input){
		if (input == null){
			return "";
			}
		char[] in = input.toCharArray();
		NPSListStack<Character> stack = new NPSListStack<Character>();
		StringBuilder out = new StringBuilder();
		
		for (int i = 0;i<in.length;i++)
			switch (in[i]) {
	        case '+':
	        case '-':
	            while (!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/')) {
	                out.append(' ');
	                out.append(stack.pop());
	            }
	            out.append(' ');
	            stack.push(in[i]);
	            break;
	        case '*':
	        case '/':
	            out.append(' ');
	            stack.push(in[i]);
	            break;
	        case '(':
	            stack.push(in[i]);
	            break;
	        case ')':
	            while (!stack.isEmpty() && stack.peek() != '(') {
	                out.append(' ');
	                out.append(stack.pop());
	            }
	            stack.pop();
	            break;
	        default:
	            out.append(in[i]);
	            break;
			}

	    while (!stack.isEmpty())
	    	out.append(' ').append(stack.pop());
		
	    return out.toString();
		
		}
	  
//	public static int calculate(String s)  
	   {
		
		
	   }
	  
		  
	
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		String input,output;
		System.out.print("Enter an equation: ");
		input = scan.next();
		output = Infix(input);
		System.out.println(output); 
//		System.out.print(calculate(output));
	       

	   }
	}
	  
	


