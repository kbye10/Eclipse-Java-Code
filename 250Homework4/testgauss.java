
public class testgauss {

	
	public static void main(String[] args)
	{
		System.out.println(gauss(1200));
		System.out.println(gauss2(1200));
		System.out.println(gauss3(1200));
	}
	
	public static int gauss(int n) // recursion
	{
		if (n == 0)
		{
			return 0;
		}
		
		if (n == 1)
		{
			return 1;
		}
		
		return ((gauss(n-1) + n));
	}
		
		public static int gauss2(int n)  //repetition
		{
			int sum = 0;
			for (int i = 1; i <= n; i++)
			{
				sum = sum + i;
			}
			return sum;
		}
		
		public static int gauss3(int n) // formula
		{
			return ( n * (n + 1)/2);
		}
	}

