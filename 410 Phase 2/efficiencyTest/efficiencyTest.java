package efficiencyTest;
import java.io.*;

public class efficiencyTest {
	
	public static void StackAnalysis(String filePath) throws IOException {
		
		BufferedReader reader1 = new BufferedReader(new FileReader(filePath));
		String lineStack = null;
		int stackV = 0;
		int stackP = 0;
		int stackLOC = 0;
		while ((lineStack = reader1.readLine()) != null) {
		// Checks for comments and counts lines that are NOT comments	
			if (! lineStack.startsWith("/") && ! lineStack.startsWith("*")){
				stackLOC++;				 
			}
			// Checks for "for" loops	
				if (lineStack.startsWith("for")){
					stackP++;
				}	
			// Checks for "while" loops	
				if (lineStack.startsWith("while")){
					stackP++;
				}
			// Checks for "if" statements			
				if (lineStack.startsWith("if")){
					// If statement contains "and" statement	
					if (lineStack.contains("&&")){
						String[] split = lineStack.split("&&");
						int length = split.length;
						stackP = stackP + length;
					}
					// If statement contains "or" statement
					else if (lineStack.contains("||")){
						String[] split = lineStack.split("\\|\\|");
						int length = split.length;
						stackP = stackP + length;
					}
					else {
						stackP++;
					}
				}
		}
		stackV = stackP + 1;
		System.out.println("Output of Stack analysis");
		System.out.println("LOC: "+stackLOC);
		System.out.println("Predicates: "+stackP);
		System.out.println("Cyclomatic Number "+stackV +"\n");
	}

	public static void LinkedListAnalysis(String filePath) throws IOException{
		BufferedReader reader2 = new BufferedReader(new FileReader(filePath));
		String lineList = null;
		int listV = 0;
		int listP = 0;
		int listLOC = 0; 
		while ((lineList = reader2.readLine()) != null) {
			// Checks for comments and counts lines that are NOT comments	
					if (! lineList.startsWith("/") && ! lineList.startsWith("*")){
						listLOC++;				 
					}
					// Checks for "for" loops	
						if (lineList.startsWith("for")){
							listP++;
						}
					// Checks for "while" loops
						if (lineList.startsWith("while")){
							listP++;
						}
					// Checks for "if" statements			
						if (lineList.startsWith("if")){
							// If statement contains "and" statement	
							if (lineList.contains("&&")){
								String[] split = lineList.split("&&");
								int length = split.length;
								listP = listP + length;
							}
							// If statement contains "or" statement
							else if (lineList.contains("||")){
								String[] split = lineList.split("\\|\\|");
								int length = split.length;
								listP = listP + length;
							}
							else {
								listP++;
							}
						}
		}
		listV = listP + 1;
		System.out.println("Output of Linked List analysis");
		System.out.println("LOC: "+listLOC);
		System.out.println("Predicates: "+listP);
		System.out.println("Cyclomatic Number "+listV);
	}
	public static void main(String[] args) throws IOException {
	
		StackAnalysis("/Users/kbye10/Desktop/Stack.txt");
		LinkedListAnalysis("/Users/kbye10/Desktop/LinkedList.txt");
	
}
	}



