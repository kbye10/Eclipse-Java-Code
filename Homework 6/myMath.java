import java.text.*;


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
	
	public static double toRadians(double deg){
		return Math.PI*deg/180;
	}
	
	public static double sin(double x){
		// initiate variables for loop
		double ans = 0.0;
		int termnum = 1;
		double term = x;
		while (Math.abs(term) >= 0.0000001){
		//do work
		ans = ans+term;
		//get ready
		termnum++;
		term = (power(-1.0,(termnum+1))*power(x,(2*termnum-1)))/factorial(2*termnum-1);
		
	}
		return ans;
	}
	
	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("0.000000");
		System.out.println("Degree    Radians      myMath        Math");
		for (int i=0;i<10;i++){
			System.out.println((i)+"         "+df.format(toRadians(i))+"     "+df.format(sin(toRadians(i)))+"      "+df.format(Math.sin(toRadians(i))));
		}
		for (int i=10;i<=90;i++){
			System.out.println((i)+"        "+df.format(toRadians(i))+"     "+df.format(sin(toRadians(i)))+"      "+df.format(Math.sin(toRadians(i))));
		}
		
	}

}