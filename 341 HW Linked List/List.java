/*
 * Kevin Bye
 * 341 Linked List Implementation
 * 
 * Takes an input array and can print the original order or sort it into a new list
 * and print the sorted list.
 */

import java.util.LinkedList;
public class List {

private String results;             
private int counter, counter2 = 0;      
private LinkedList<Integer> list = new LinkedList<Integer>();
// Initialize variables needed, i.e. a linked list, string for results, and counters

public void add(int [] A)
{
	// This methods adds items to the list at the back
         while (A[counter] != -1) 
         {	// Adds items until -1 is entered
               list.add(A[counter]);
               counter = counter + 1;	// Increments counter to continue through input array

         }
}

public void emptyAdd(int A[]) 
{ 
	// Checks if list is empty, and initializes counters
          if (list.isEmpty() == true) 
          { 
        	  // If the list is empty
               list.add(A[counter]);
               counter = counter + 1; 	// Counter incremented by 1
               counter2 = counter;  	// Makes a copy of counter

          }
}

public boolean isGreaterEqual(int A[]) 
{
	// This method compares two items in the list
          if (A[counter] >= list.get(counter2 - 1)) {
        	  // If item at index counter is larger or equal, return true
               return true;
          } 
          else       
               return false;
          // Otherwise return false

}

public void sortList (int A[]) 
{ 
          emptyAdd(A);
          while (A[counter] != -1) // Continues until -1 is read
          {
               if (isGreaterEqual(A)) // If item at index "counter" >= item at index "counter2"
                     list.add(A[counter]); // Adds value 
               else 
               { // Otherwise
            	   while (!isGreaterEqual(A)) // As long as item at index "counter2" > item at index "counter"
            	   {
            		   counter2--; // Decrements counter2 to go backwards through list
            		   if (counter2 == 0) 
            		   { 
            			   break;  // Stop when counter2 reaches 0
                       }
                   }
                     list.add(counter2, A[counter]);  // Adds item at index "counter" at index "counter2"
               }
               counter++; // Increments the counter to continue through list
               counter2 = counter; // Assigns counter to counter2 to repeat loop from new index
          }
}

     public String returnList() {        
    	 // Returns list as a string so it can be easily examined
    	  results = list.toString(); // Converts list to a string
          return results; 			 // Returns string of list values
     }
     
     public static void main(String[] args) {
          int[] inputArray = {4,1,3,3,5,6,7,12,11,-1 };	// Create input array
          List list1 = new List();					// Initializes lists to use
          List list2 = new List();
          list1.add(inputArray); 					// Adds integers from input array      
          System.out.println("Unsorted List: ");	
          System.out.println(list1.returnList()+"\n");	// Return and print unsorted list
          list2.sortList(inputArray);               // Sorts list in ascending order                               
          System.out.println("Sorted List:"); 
          System.out.println(list2.returnList());	// Return and print sorted list               
     }
}

 
