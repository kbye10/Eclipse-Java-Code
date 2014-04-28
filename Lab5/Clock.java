
public class Clock {
	
/** Data Items
 */
	private int hours, minutes,seconds;
	
/** Methods
 */
	// Sets Hours 
	public void setHours(int h){
		hours = Math.abs(h%24);
	}
	// Sets Minutes
	public void setMinutes(int m){
		minutes = Math.abs(m%60);
	}
	// Sets Seconds
	public void setSeconds(int s){
		seconds = Math.abs(s%60);
	}
	// Gets Hours
	public int getHours(){
		return hours;
	}
	// Gets Minutes
	public int getMinutes(){
		return minutes;
	}
	// Gets Seconds
	public int getSeconds(){
		return seconds;
	}
	//Tick clock
	public void tick(){
		hours = (hours+(minutes+((seconds+1)/60))/60)%24;
		minutes = (minutes+((seconds+1)/60))%60;
		seconds = (seconds+1)%60;
	}
	
	/** Constructors
	 */
	public Clock() {  // Sets hours,minutes,seconds to 0 
		setHours(0);
		setMinutes(0);
		setSeconds(0);
	}
	
	public Clock(int h) {   //Sets hours to h, minutes and seconds to 0
		setHours(h);
		setMinutes(0);
		setSeconds(0);
	}
	
	public Clock(int h,int m) {   //Sets hours to h, minutes to m, seconds to s
		setHours(h);
		setMinutes(m);
		setSeconds(0);
	}
	
	public Clock(int h,int m,int s) {
		setHours(h);
		setMinutes(m);
		setSeconds(s);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		//Test no parameter
		Clock clock0 = new Clock();
		System.out.println("The time is "+clock0.getHours()+" hours, "+clock0.getMinutes()
					+" minutes and "+clock0.getSeconds()+" seconds.");
		//Test on one parameter
		Clock clock1 = new Clock(3);
		System.out.println("The time is "+clock1.getHours()+" hours, "+clock1.getMinutes()
				+" minutes and "+clock1.getSeconds()+" seconds.");
		//Test two parameters
		Clock clock2 = new Clock(4,5);
		System.out.println("The time is "+clock2.getHours()+" hours, "+clock2.getMinutes()
				+" minutes and "+clock2.getSeconds()+" seconds.");
		//Test 3 parameters
		Clock clock3 = new Clock(5757,284,-39);
		System.out.println("The time is "+clock3.getHours()+" hours, "+clock3.getMinutes()
				+" minutes and "+clock3.getSeconds()+" seconds.");
		
		clock3.setHours(4);
		clock3.setMinutes(5);
		clock3.setSeconds(6);
		System.out.println("The time is "+clock3.getHours()+" hours, "+clock3.getMinutes()
				+" minutes and "+clock3.getSeconds()+" seconds.");
		
		//Test tick
				clock3.tick();
				System.out.println("The time is "+clock3.getHours()+" hours, "+clock3.getMinutes()
						+" minutes and "+clock3.getSeconds()+" seconds.");
				
				clock3.setHours(1);
				clock3.setMinutes(59);
				clock3.setSeconds(59);
				clock3.tick();
				System.out.println("The time is "+clock3.getHours()+" hours, "+clock3.getMinutes()
						+" minutes and "+clock3.getSeconds()+" seconds.");
				
				clock3.setHours(1);
				clock3.setMinutes(2);
				clock3.setSeconds(59);
				clock3.tick();
				System.out.println("The time is "+clock3.getHours()+" hours, "+clock3.getMinutes()
						+" minutes and "+clock3.getSeconds()+" seconds.");
				
				clock3.setHours(23);
				clock3.setMinutes(59);
				clock3.setSeconds(59);
				clock3.tick();
				System.out.println("The time is "+clock3.getHours()+" hours, "+clock3.getMinutes()
						+" minutes and "+clock3.getSeconds()+" seconds.");
			
	}
	
}


