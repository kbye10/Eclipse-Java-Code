
public class ArrayOps {

	/**
	 * @param args
	 */
	public static void LoadArray(int [] A){
		for (int i=0;i<A.length;i++){
			A[i] = (int)(Math.random()*100)+1;
		}
	}
	public static void PrintArray(int [] A) {
	
		for (int i=0;i<A.length;i++){
			
			
			if ((i) % 10 == 0)
			{
				System.out.println();
			}
				System.out.print(Format.rightAlign(6,A[i]));
		
			}
		
	}
	
	public static int Search(int A[],int n){
		for (int i = 0;i<A.length;i++){
			if(A[i] == n){
				return i;
				}
		}
		return (-1);
	}
	
	public static int FindMin(int A[]){
		int min = A[0];
		int pos=0;
		for (int i=0; i<A.length;i++){
			if (A[i] < min){
				min = A[i];
				pos = i;
			}
		}
	return pos;
	}
	
	public static int FindMax(int A[]){
		int max = A[0];
		int pos=0;
		for (int i=0; i<A.length;i++){
			if (A[i] > max){
				max = A[i];
				pos = i;
			}
		}
	return pos;
	}	
	
	public static int Average(int A[]){
		int total=0;
		for (int i=0;i < A.length;i++){
			total = total+A[i];
		}
		return (total/A.length);
	}

	public static void Sort(int A[]){
		int temp;
		for (int i=0;i < A.length-1;i++)
		{
			for (int j=i+1;j < A.length;j++)
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
	
	
	public static void main(String[] args) {
		int A[]= new int[100];
		LoadArray(A);
		PrintArray(A);
		System.out.println();
		Sort(A);
		PrintArray(A);
		System.out.println("\n");
	System.out.println("The average is: "+Average(A));
	System.out.println("The position of 95 is: "+Search(A,95));	
	System.out.println("The minimum is "+A[FindMin(A)]+" and is located at position" +
			": "+FindMin(A));
	System.out.println("The maximum is "+A[FindMax(A)]+" and is located at position" +
			": "+FindMax(A));
	}

	}

