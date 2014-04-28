
public class recurse {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{

		System.out.println(Fib(48));

	}
	
	public static int Fib(int n)
	{
		if ((n == 1)||(n==2))
		{
			return 1;
		}
		int oneback = 1;
		int twoback = 1;
		int temp = 0;
		for (int i = 3; i <= n; i++)
		{
			temp = oneback + twoback;
			oneback = twoback;
			twoback = temp;
		}
	    return temp;
	}
}
