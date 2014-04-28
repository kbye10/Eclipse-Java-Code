
public class HW1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
			
		float N = 150000000;
		float total = 0;
		float total2 = 0;
		for(int i=1;i<=N;i++){
			total+=(1.0/i);
		}
		System.out.println(total);
		
		for(int i=(int) N;i>=1;i--){
			total2 +=(1.0/i);
		}
		System.out.println(total2);
	}

}
