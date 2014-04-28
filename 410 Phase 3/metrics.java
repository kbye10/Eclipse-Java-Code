import java.io.*;


public class metrics {

	public static void StackMetrics (String fileName) throws IOException{
		BufferedReader reader1 = new BufferedReader(new FileReader(fileName));
		String lineStack = null;
		int beginCount=0, endCount=0, assignCount=0, leftParentheseCount=0, rightParentheseCount=0;
		int notEqualCount=0, minusCount=0, decrementCount=0, semiColonCount=0, printCount=0, stackCount=0;
		int starCount=0, symbolCount=0, symbol1Count=0, symbol2Count=0;
		String operators = "Unique Operators";
		String operatorFreq = "Frequency";
		String operands = "Unique Operands";
		String operandFreq = "Frequency";
		// Scan through lines in program
		while ((lineStack = reader1.readLine()) != null) {
			// Ignore comment lines
			if (!lineStack.startsWith("/") && !lineStack.startsWith("*") && 
					!lineStack.startsWith("*/")){
				
				// Check for prints
				if (lineStack.contains("print")){
					printCount++;
				}
				
				// Checks for "stack" variable 
				if (lineStack.contains("stack")){
					stackCount++;
				}
				
				// Checks for "star" variable
				if (lineStack.contains("star")){
					starCount++;
				}
				
				// Checks for "symbol1" variable
				if (lineStack.contains("symbol1")){
					symbol1Count++;
				}
				
				// Checks for "symbol2" variable
				if (lineStack.contains("symbol2")){
					symbol2Count++;
				}
				
				// Checks for "symbol" variable
				if (lineStack.contains("symbol")){
					symbolCount++;
				}
				// Loops through string to check for individual operators
				for (int i=0;i<lineStack.length();i++){
					// Check for "{"
					if (lineStack.charAt(i) == '{'){
						beginCount++;
					}
					
					// Check for "}"
					if (lineStack.charAt(i) == '}'){
						endCount++;
					}
					
					// Check for "-"
					if (lineStack.charAt(i) == '-'){
						if (!(lineStack.charAt(i+1) == '-') && !(lineStack.charAt(i-1) == '-')){
							minusCount++;
						}
					}
					
					// Check for "="
					if (lineStack.charAt(i) == '='){
						if (!(lineStack.charAt(i-1) == '>') && !(lineStack.charAt(i-1) == '<')
								&& !(lineStack.charAt(i-1) == '!')){
							assignCount++;
			
						}
					}
					
					// Check for "("
					if (lineStack.charAt(i) == '('){
						leftParentheseCount++;
					}
					
					// Check for ")"
					if (lineStack.charAt(i) == ')'){
						rightParentheseCount++;
					}
					
					// Check for "!="
					if (lineStack.charAt(i) == '=' && lineStack.charAt(i-1) == '!'){
						notEqualCount++;
					}
					
					// Check for "--"
					if (lineStack.charAt(i) == '-'){
						if (lineStack.charAt(i-1) == '-' || lineStack.charAt(i+1) == '-'){
						decrementCount++;
						}
					}
					
					// Check for ";"
					if (lineStack.charAt(i) == ';'){
						semiColonCount++;
					}
					
				}
			}		
		}
		System.out.println("Stack Implementation");
		System.out.println(String.format("%-30s %s", operators, operatorFreq));
		System.out.println(String.format("%-30s %s", "Begin", beginCount));
		System.out.println(String.format("%-30s %s", "End", endCount));
		System.out.println(String.format("%-30s %s", "-", minusCount));
		System.out.println(String.format("%-30s %s", "=", assignCount));
		System.out.println(String.format("%-30s %s", "(", leftParentheseCount));
		System.out.println(String.format("%-30s %s", ")", rightParentheseCount));
		System.out.println(String.format("%-30s %s", "!=", notEqualCount));
		System.out.println(String.format("%-30s %s", "--", decrementCount));
		System.out.println(String.format("%-30s %s", ";", semiColonCount));
		System.out.println(String.format("%-30s %s", "Prints", printCount));
		System.out.println();
		System.out.println(String.format("%-30s %s", operands, operandFreq));
		System.out.println(String.format("%-30s %s", "stack", stackCount));
		System.out.println(String.format("%-30s %s", "star", starCount));
		System.out.println(String.format("%-30s %s", "symbol", symbolCount - symbol1Count - symbol2Count));
		System.out.println(String.format("%-30s %s", "symbol1", symbol1Count));
		System.out.println(String.format("%-30s %s", "symbol2", symbol2Count));
	}
			
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		StackMetrics("Stack.txt");
	}

}
