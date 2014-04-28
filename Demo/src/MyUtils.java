
/*
 * Created on Aug, 28,  2012
 *
 */


/**
 * @author pschumacher
 * edited by Kyle Lafky
 * 
 */
public class MyUtils 
{
	public static void LoadArray(int [] A)
	{
		int arrayLength = A.length;
		for (int i = 0; i < arrayLength; i++)
		{
	
			A[i] = (int)(Math.random()* 100 + 1);
		}
	}
	
	public static void PrintArray(int [] A)
	{
		int arrayLength = A.length;
		for (int i = 0; i < arrayLength; i++)
		{
			System.out.print(Format.rightAlign(6,A[i]));
			if ((i+1)% 10 == 0)
			{
				System.out.println("");
			}
		}
	}
	
	public static int FindSmallest(int A[])
	{
		int smallest = A[0];
		int pos = 0;
		for (int i=0; i<A.length; i++)
		{
			if (A[i] <= smallest)
			{
				smallest = A[i];
				pos = i; 
			}
		}
		return pos;
	}	
	
	public static int FindLargest(int A[])
	{
		int largest = A[0];
		int pos = 0;
		for (int i=0; i<A.length; i++)
		{
			if (A[i] >= largest)
			{
				largest = A[i];
				pos = i;
			}
		}
		return pos;
	}	
	
	public static double FindAverage(int A[])
	{
		int total = 0;
		for (int i =0; i<A.length; i++)
		{
			total = total + A[i];
		}
		return ((double) total/ A.length);
	}
	public static int Search(int []A, int Key)
	{
		for(int i=0; i<A.length; i++)
		{
			if (A[i]==Key)
			{
				return i;
			}
		}
		return -1;
	}
	
	public static int BinSearch(int[]A,int Key, int low, int high)
	{
		int mid=(low+high)/2;
		if(low>high)
		{
			return -1;
		}
			if (A[mid]==Key)
			{
			return mid;
			}
			if (A[mid]>Key)	
			{
			return BinSearch(A,Key,low,mid -1);
			}
			else
			{
			return BinSearch(A,Key,mid +1,high);
			}
	}
	public static void ResetArrays(int A[],int B[]){
		for (int i=0; i < A.length;i++){
			B[i]=A[i];
		}
	}
	public static void SimpleSort(int A[], int n)
	{
		int Temp;
		for (int i=0; i<A.length-1; i++)
		{
			for (int j=i+1; j<A.length; j++)
			{
				if(A[i]>A[j])
				{
					Temp = A[i];
					A[i] = A[j];
					A[j] = Temp;
				}
			}
		}
	}
	public static void BubbleSort(int A[],int n)
	{
		int temp;
		for (int i=0;i < n-1;i++)
		{
			for (int j=i+1;j < n;j++)
			{
				if (A[i] > A[j])
				{
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
public static void SelectionSort(int A[], int n)
{
		
		int min;
		int temp; 
		for (int i = 0; i < n-1; i++) 
			{
		    	min = i;
		    	for (int j = i+1; j < n; j++) 
		    	{
		    		if (A[j] < A[min]) 
		    		{
		           temp = A[i];
		           A[i] = A[j];
		           A[j] = temp;
		           
		    		}
		    	}

			}
		}
	public static void ShellSort(int[] A, int n){
        
	      int h = 1;
	      while ((h * 3 + 1) < n) {
	           h = 3 * h + 1;
	       }
	       while( h > 0 ) {
	             for (int i = h - 1; i < n; i++) {
	                 int C = A[i];
	                 int j = i;
	                 for( j = i; (j >= h) && (A[j-h] > C); j -= h) {
	                     A[j] = A[j-h];
	                 }
	                A[j] = C;  
	             }
	             h = h / 3;
	         }

	  }
	
	public static void MergeSort(int[] A,int lo0,int hi0)
	{
        int lo = lo0;
             int hi = hi0;
             if (lo >= hi) {
                 return;
             }
             int mid = (lo + hi) / 2;
             MergeSort(A, lo, mid);
             MergeSort(A, mid + 1, hi);  
             int end_lo = mid;
           int start_hi = mid + 1;  
             while ((lo <= end_lo) && (start_hi <= hi)) {
                   if (A[lo] < A[start_hi]) {
                       lo++;
                   }
                   else {
                   int T = A[start_hi];
                       for (int k = start_hi - 1; k >= lo; k--) {
                           A[k+1] = A[k];
                       }
                       A[lo] = T;
                       lo++;
                       end_lo++;
                       start_hi++;
                   }
               }
  }
	public static void main(String[]Args){
	    int []A = new int [20];
		int []B = new int [20];
		Heap heap = new Heap();
		int n = 20;
		
		LoadArray(A);
		ResetArrays(A,B);
		System.out.println("Original Array: ");
		PrintArray(A);		
		BubbleSort(A,n);
		System.out.println("\n"+"Bubble sort test:");
		PrintArray(A);
		ResetArrays(A,B);
		System.out.println("\n"+"Selection Sort Test;");
		SelectionSort(A,n);
		PrintArray(A);
		ResetArrays(A,B);
		System.out.println("\n"+"Insertion Sort Test:");
		InsertionSort(A,n);
		PrintArray(A);
		ResetArrays(A,B);
		System.out.println("\n"+"Shell Sort Test:");
		ShellSort(A,n);
		PrintArray(A);
		ResetArrays(A,B);
		System.out.println("\n"+"Heap Sort Test:");
		heap.setData(A,A.length);
		B = heap.sort();
		PrintArray(A);
		ResetArrays(A,B);
		System.out.println("\n"+"Merge Sort Test");
		MergeSort(A,0,n-1);
		PrintArray(A);
		
	}

}
