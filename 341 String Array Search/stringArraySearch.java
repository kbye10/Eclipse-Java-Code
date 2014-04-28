
public class stringArraySearch {

	public static boolean stringSearch (String []A, int N, String T) {		
		// Declares stringSearch method
		
		int i=0;								
		// Declares pointer "i" and initializes to 0
		boolean found = false; 					
		// Declares and initializes found to false
		
		while (!found && i<N) {					
			// Starts loop through array while found=false or until the end of the array
			if (A[i].equals(T))					
				// If string at index i = Target, then:
				found=true;						
			// Set found to true
			else								
				// Otherwise,
				if (A[i].compareTo(T)>0){		
					// If index is further down the alphabet than Target, then:
					i=N+1;
					// Exit loop by setting i > N
				// System.out.println("Index greater than target");	Used for testing if the compareTo() method was working	
				}
				else{
				// Otherwise,	
				i = i+1;
				// Increment i to move on through the array next time through the loop
				// System.out.println("Index less than target");		Used for testing how many times this was executed
				}
			}
		return found;
		// Finally, return the boolean value of found
	}
	public static void main(String[] args) {
		String []A = new String[]{"Ada","Ben","Carol","Dave",
				"Ed","Frank","Gerri","Helen","Iggy","Joan"};
		// Declares and initializes array with the ten names given
		System.out.println(stringSearch(A,10,"Frank"));
		// Tests if "Frank" exists in the array
		System.out.println(stringSearch(A,10,"Ian"));
		// Tests if "Ian" exists in the array

	}

	}
