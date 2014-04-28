
public class classArray {

	public static void LoadArray(int A[][]){
		for (int Row=0;Row<A.length;Row++){
			for (int Col=0;Col<A.length;Col++){
				A[Row][Col] = (int)(Math.random()*5)-2;
			}
		}
	}

	public static void PrintArray(int A[][], int n){
		
		for (int Row = 1; Row <= n; Row++){
			for (int Col = 1; Col <= n; Col++){
				System.out.print(Format.rightAlign(5,A[Row][Col]));
			}
			System.out.println();
		}
	System.out.println();
	}
	
	public static void AddArray(int A[][],int B[][],int C[][], int n){
		for (int Row = 1; Row <= n; Row++)
			{
			for (int Col = 1; Col <= n; Col++){
				C[Row][Col] = A[Row][Col]+B[Row][Col];
			}
		}
	}
	public static void MultiplyArray(int A[][],int B[][],int C[][],int n){
		for (int Row = 1; Row <= n; Row++){
			for (int Col = 1; Col <= n; Col++){
				C[Row][Col] = 0;
				for (int i = 1; i <= n; i++){
					C[Row][Col] = A[Row][i]*B[i][Col]+C[Row][Col];
				}
			}
		}
	}
	
	public static void main(String[] args){	
		System.out.println("Kevin Bye"+"\n"
	);
			int A[][] = new int [10][10];
			int B[][] = new int [10][10];
			int C[][] = new int [10][10];
			int D[][] = new int [10][10];
	LoadArray(A);
	LoadArray(B);
	for (int n = 2;n <=9; n++){
	System.out.println("Array A");
	PrintArray(A,n);
	System.out.println("Array B");
	PrintArray(B,n);
	AddArray(A,B,C,n);
	System.out.println("Add Array");
	PrintArray(C,n);
	MultiplyArray(A,B,D,n);
	System.out.println("Multiply Array");
	PrintArray(D,n);
	
	
		}
}
}
