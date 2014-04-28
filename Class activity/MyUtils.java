/*
 * Created on Aug, 28,  2012
 *
 */

/**
 * @author pschumacher
 * Edited by Kevin Bye
 */
import java.util.*;
public class MyUtils 
{
	
	public static int FindSmallest(int A[])
	{
		int min = A[0];
		int pos = 0;
		for (int i=0; i<A.length;i++){
			if (A[i] < min){
				pos = i;
				min = A[i];
			}
		}
	return pos;
	}
	
	public static int FindLargest(int A[])
	{
		int max = A[0];
		int pos = 0;
		for (int i=0; i<A.length;i++){
			if (A[i] > max){
				max = A[i];
				pos = i;
			}
		}
	return pos;
	}	
	
	public static double FindAverage(int A[])
	{
		double total = 0;
		
		for (int i = 0; i < A.length; i++)
		{
			total = total+A[i];
		}
		double avg = total/100;
		return avg;
	}

	public static int SearchInt(int A[], int key){
		
		for(int i=0; i<A.length; i++)
		{
			if (A[i]==key){
				System.out.println(" Number of probes: "+i);
				return i;
			}
		}
		return -1;
	}
	
	public static int binSearch(int A[],int key,int low,int high)
	{
		int mid=(low+high)/2;
		if (low>=high)
		{
			return -1;
		}
		
		if (A[mid]==key)
		{
			return mid;
		}
		
		if (A[mid]>key)
		{
			return binSearch(A,key,low,(mid-1));
		}
		
		else
		{
			return binSearch(A,key,(mid+1),high);
		} 
	}
	
	public static int SelectSearch(int A[], int key){
		
		for(int i=0; i<A.length; i++)
		{
			if (A[i]==key){
				System.out.println(" Number of probes: "+i);
				return i;
			}
		}
		return -1;
	}
	
	public static void LoadArray(int A[])
	{
		int arrayLength = A.length;
		for (int i = 0; i < arrayLength; i++)
		{
	
			A[i] = (int)(Math.random()* 100000 + 1);
		}
	}
	
	public static void PrintArray(int A[],int n)
	{
		for (int i = 0; i < n; i++)
		{
			System.out.print(Format.rightAlign(6,A[i]));
			if ((i+1)% 10 == 0)
			{
				System.out.println("");
			}
		}
	}
	
	public static void ResetArrays(int A[],int B[]){
		for (int i=0; i < A.length;i++){
			A[i]=B[i];
		}
	}
	
	public static void BubbleSort(int A[],int n)
	{
		int temp;
		for (int i=0;i < n-1;i++)
		{
			for (int j=i+1;j < n;j++)
			{
				// Compare
				if (A[i] > A[j])
				{
					//swap
					temp = A[i];
					A[i] = A[j];
					A[j] = temp;
				}
			}
		}
	}
	
	
	public static void SelectionSort(int A[], int n){
		
	int min;
	int temp; 
	// advance the position through the entire array
	for (int i = 0; i < n-1; i++) 
		{
	    	//assume the min is the first element
	    	min = i;
	    	// test against elements after j to find the smallest 
	    	for (int j = i+1; j < n; j++) 
	    	{
	    		// if this element is less, then it is the new minimum  
	    		if (A[j] < A[min]) 
	    		{
	            //found new minimum; remember its index
	           temp = A[i];
	           A[i] = A[j];
	           A[j] = temp;
	           
	    		}
	    	}

		}
	}
	
	public static void InsertionSort(int[] A, int n)
	{
	      int i, j, newValue;
	      for (i = 1; i < n; i++)
	      {
	            newValue = A[i];
	            j = i;
	            while (j > 0 && A[j - 1] > newValue)
	            {
	                  A[j] = A[j - 1];
	                  j--;
	            }
	            A[j] = newValue;
	      }
	}
	
	public static void ShellSort(int[] B, int n){
              
      int h = 1;
      while ((h * 3 + 1) < n) {
           h = 3 * h + 1;
       }
       while( h > 0 ) {
             for (int i = h - 1; i < n; i++) {
                 int C = B[i];
                 int j = i;
                 for( j = i; (j >= h) && (B[j-h] > C); j -= h) {
                     B[j] = B[j-h];
                 }
                 B[j] = C;  
             }
             h = h / 3;
         }

  }

	public static void MergeSort(int[] B,int lo0,int hi0){
        int lo = lo0;
             int hi = hi0;
             if (lo >= hi) {
                 return;
             }
             int mid = (lo + hi) / 2;
             MergeSort(B, lo, mid);
             MergeSort(B, mid + 1, hi);  
             int end_lo = mid;
           int start_hi = mid + 1;  
             while ((lo <= end_lo) && (start_hi <= hi)) {
                   if (B[lo] < B[start_hi]) {
                       lo++;
                   }
                   else {
                   int T = B[start_hi];
                       for (int k = start_hi - 1; k >= lo; k--) {
                           B[k+1] = B[k];
                       }
                       B[lo] = T;
                       lo++;
                       end_lo++;
                       start_hi++;
                   }
               }
  }

	/*
	public static void main(String[]Args){
	    int []A = new int [10];
		int []B = new int [10];
		Heap heap = new Heap();
		int n = 10;
		long elapsedtime;
		Date starttime, endtime;
		
		LoadArray(A);
		ResetArrays(A,B);
		System.out.println("Original Array: ");
		PrintArray(B,n);		
		
		starttime = new Date();
		System.out.println("\n"+"Testing Bubble Sort: ");
		for (int i=0; i<100000;i++){
		BubbleSort(B,n);
		ResetArrays(A,B);
		}
		endtime = new Date();
		elapsedtime = endtime.getTime()-starttime.getTime();
		System.out.println("Time for 100,000 sorts: "+elapsedtime);
		ResetArrays(A,B);
		System.out.println("\n"+"Testing Selection Sort: ");
		SelectionSort(B,n);
		PrintArray(B,n);
		ResetArrays(A,B);
		System.out.println("\n"+"Testing Insertion Sort: ");
		InsertionSort(B,n);
		PrintArray(B,n);
		ResetArrays(A,B);
		System.out.println("\n"+"Testing Shell Sort: ");
		ShellSort(B,n);
		PrintArray(B,n);
		ResetArrays(A,B);
		
		System.out.println("\n"+"Testing Heap Sort: ");
		heap.setData(B,B.length);
		B= heap.sort();
		PrintArray(B,n);
		ResetArrays(A,B);
		System.out.println("\n"+"Testing Merge Sort: ");
		MergeSort(B,0,n-1);
		PrintArray(B,n);
		
	}*/

}
