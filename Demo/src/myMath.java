
public class myMath {

	/**
	 * @param args
	 */
	
	public static double power(double b, int p){
		double ans = 1;
		for (int i = 1; i <= p; i++)
		{
			ans = ans * b;
		}
		return ans;
	}
	
	public static double factorial(int n){
	double ans = 1;
	for (int i =1; i <= n; i++)
		{
			ans = ans*i;
		}
		return ans;
		}
	
	
	public static void main(String[] args) {
		System.out.println(factorial(5));
	}

}
