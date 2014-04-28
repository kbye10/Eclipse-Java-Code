import java.io.*;
public class LinkedListMetrics {
		
	public static void LinkedListMetrics (String fileName) throws IOException{
			BufferedReader reader1 = new BufferedReader(new FileReader(fileName));
			String lineList = null;
			int beginCount=0, endCount=0, assignCount=0, leftParentheseCount=0, rightParentheseCount=0;
			int notEqualCount=0, minusCount=0, decrementCount=0, semiColonCount=0, printCount=0, listCount=0;
			int starCount=0, symbolCount=0, symbol1Count=0, symbol2Count=0;
			String operators = "Unique Operators";
			String operatorFreq = "Frequency";
			String operands = "Unique Operands";
			String operandFreq = "Frequency";
			// Scan through lines in program
			while ((lineList = reader1.readLine()) != null) {
				// Ignore comment lines
				if (!lineList.startsWith("/") && !lineList.startsWith("*") && 
						!lineList.startsWith("*/")){
					
					// Check for prints
					if (lineList.contains("print")){
						printCount++;
					}
					
					// Checks for "List" variable 
					if (lineList.contains("list")){
						listCount++;
					}
					
					// Checks for "star" variable
					if (lineList.contains("star")){
						starCount++;
					}
					
					// Checks for "symbol1" variable
					if (lineList.contains("symbol1")){
						symbol1Count++;
					}
					
					// Checks for "symbol2" variable
					if (lineList.contains("symbol2")){
						symbol2Count++;
					}
					
					// Checks for "symbol" variable
					if (lineList.contains("symbol")){
						symbolCount++;
					}
					// Loops through string to check for individual operators
					for (int i=0;i<lineList.length();i++){
						// Check for "{"
						if (lineList.charAt(i) == '{'){
							beginCount++;
						}
						
						// Check for "}"
						if (lineList.charAt(i) == '}'){
							endCount++;
						}
						
						// Check for "-"
						if (lineList.charAt(i) == '-'){
							if (!(lineList.charAt(i+1) == '-') && !(lineList.charAt(i-1) == '-')){
								minusCount++;
							}
						}
						
						// Check for "="
						if (lineList.charAt(i) == '='){
							if (!(lineList.charAt(i-1) == '>') && !(lineList.charAt(i-1) == '<')
									&& !(lineList.charAt(i-1) == '!')){
								assignCount++;
				
							}
						}
						
						// Check for "("
						if (lineList.charAt(i) == '('){
							leftParentheseCount++;
						}
						
						// Check for ")"
						if (lineList.charAt(i) == ')'){
							rightParentheseCount++;
						}
						
						// Check for "!="
						if (lineList.charAt(i) == '=' && lineList.charAt(i-1) == '!'){
							notEqualCount++;
						}
						
						// Check for "--"
						if (lineList.charAt(i) == '-'){
							if (lineList.charAt(i-1) == '-' || lineList.charAt(i+1) == '-'){
							decrementCount++;
							}
						}
						
						// Check for ";"
						if (lineList.charAt(i) == ';'){
							semiColonCount++;
						}
						
					}
				}		
			}
			System.out.println("List Implementation");
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
			System.out.println(String.format("%-30s %s", "list", listCount));
			System.out.println(String.format("%-30s %s", "star", starCount));
			System.out.println(String.format("%-30s %s", "symbol", symbolCount - symbol1Count - symbol2Count));
			System.out.println(String.format("%-30s %s", "symbol1", symbol1Count));
			System.out.println(String.format("%-30s %s", "symbol2", symbol2Count));
		}
		public static void main(String[] args) throws IOException {
			// TODO Auto-generated method stub
			LinkedListMetrics("LinkedList.txt");
		}
}
