
public class sequentialSort2 {

	/**
	 * @param args
	 */
	public static boolean SeqSearch2 (int []A, int N, int Key){
	
		int i;
		boolean found;
		found = false;
		i =1;
		while (!found && i<=N) {
			if (A[i]==Key)
				found=true;
			else
				if (A[i]>Key)
					i=N+1;
				else
					i=i+1;
		}
		return found;
	
	}
	public static void main(String[] args) {
		int []A = new int[10];
		for(int i=0;i<10;i++){
			A[i]=2*i+1; 
		}
		System.out.println(SeqSearch2(A,10,7));
		System.out.println(SeqSearch2(A,10,8));
	}
}


