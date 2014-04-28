
	/*
	  Kevin Bye
	  2/15/12
	  Accepts input of "n" numbers into the Fibonacci Sequence and calculates
	   F(n)- or the number of pairs of rabbits after "n" months
	   Fibonacci.java
	 */
// Import Statements
import java.util.*;
import java.lang.Math;
	
public class Fibonacci 
{
		
	public static void main(String[] args) 
	{
	//Declare objects
		int input,answer;
		double root,fraction,expAdd,expSub;
		Scanner scan = new Scanner(System.in);	
	// Get input
	System.out.print("Enter the time passed (in months): ");	
	input = scan.nextInt();
	
	//Computation
	root = Math.sqrt(5);
	fraction = (1/root);
	expAdd = Math.pow(((1+root)/2),input);
	expSub = Math.pow(((1-root)/2),input);
	answer = (int)(fraction*(expAdd-expSub));
	
	//Display outputs
	System.out.println("\n"+"The number of pairs of rabbits");
	System.out.println("after "+input+" months is:    "+answer);
	}

}
