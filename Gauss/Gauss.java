
public class Gauss {

	/**
	 * @param args
	 */
	
	public static int Gauss(int n){
		if (n == 0){
			return 0;
		}
		if (n == 1){
			return 1;
		}
		return (Gauss(n-1)+n);
	}
	public static int Gauss2(int n){
		int total = 0;
		for (int i = 0;i <= n; i++){
			total = total + i;
		}
		return total;
	}
	
	public static int Gauss3(int n){
		return (n*(n+1))/2;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10000;
		System.out.println("Gauss recursion method: "+Gauss(n)+"\n");
		System.out.println("Gauss for loop method: "+Gauss2(n)+"\n");
		System.out.println("Gauss formula method: "+Gauss3(n));
	}

}
