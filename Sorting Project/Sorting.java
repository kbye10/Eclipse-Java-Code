
public class Sorting {

	
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
			System.out.print(Format.rightAlign(8,A[i]));
			if ((i+1)% 10 == 0)
			{
				System.out.println("");
			}
		}
	}
	
	public static void ResetArrays(int A[],int B[]){
		for (int i=0; i < A.length;i++){
			B[i]=A[i];
		}
	}
	
	public static void DummySort(int A[],int n){
		
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

	public static void MergeSort(int[] B,int lo0, int hi0){
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


	public static void main(String[]Args){
	    int []A = new int [100];
		int []B = new int [100];
		Heap heap = new Heap();
		int n = 50;
		
		LoadArray(A);
		ResetArrays(A,B);
		System.out.println("Original Array: ");
		PrintArray(B,n);
		System.out.println();
		BubbleSort(B,n);
		System.out.println("Testing Bubble Sort: ");
		PrintArray(B,n);
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
		heap.setData(B,100);
		B = heap.sort(B,n);
		PrintArray(B,n);
		ResetArrays(A,B);
		System.out.println("\n"+"Testing Merge Sort: ");
		MergeSort(B,0,49);
		PrintArray(B,n);
		
	}

}
