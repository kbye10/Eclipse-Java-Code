
public class Fibonacci {

	public static int FibRepetition(int n){
		int a = 1;
		int b = 1;
		int c, temp;
		for (int i=1;i<n;i++){
			c = a+b;
// swap a and b			
			temp = b;
			b=a;
			a = temp;
// swap new a and c
			temp = c;
			c = a;
			a = temp;
		}
		return b;
	}

	public static int FibRecursion(int n){
			if (n==1 || n==2){
				return 1;
			}
			int a,b;
			System.out.println("Going left with "+(n-2));
			a = FibRecursion(n-2);
			System.out.println("Going right with "+(n-1));
			b = FibRecursion(n-1);
			return (a+b);
}
	
	
	public static void main(String[] args) {
		int n=7; 		
		System.out.println("n = "+n);
		System.out.println("Recursion: "+FibRecursion(n));
		System.out.println("Repetition: "+FibRepetition(n));

	}

}
