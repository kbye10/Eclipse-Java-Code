
public class Speedometer {

	/**
	 * Data Items
	 */
	
		private double speedM;
		
	//-------------------------------------------------
	// Methods
	//
	//	public void setM (int m)
	//	public void setK (int k)
	//	public int getM ()
	//	public int getK ()
	//------------------------------------------------- 
	
		//Sets miles per hour
		public void setM (double m){
		speedM = m;
		}
		
		//Sets km/hr by converting to mi/hr
		public void setK (double k){
		speedM = (k/1.609);
		}
		//Gets mi/hr
		public double getM (){
			return speedM;
		}
		//Gets km/hr by converting mi/hr back to km/hr
		public double getK (){
			return (speedM*1.609);
		}
		
	//------------------------------------------------- 
	//	Constructors
	//------------------------------------------------- 
		
		// Zero parameters
		public Speedometer(){
			speedM = 0;
		}
		
		// One parameter
		public Speedometer(double m){
			speedM = m;
		}
		
	
	  public static void main(String[] args) {
		  
		  Speedometer speed0 = new Speedometer();
		  System.out.println("Speed in mi/hr (0): "+speed0.getM());
		  System.out.println("Speed in km/hr (0): "+speed0.getK()+"\n");
		  
		  Speedometer speed1 = new Speedometer(25);
		  System.out.println("Speed in mi/hr (25): "+speed1.getM());
		  System.out.println("Speed in km/hr (40.225): "+speed1.getK()+"\n");
		  
		  speed1.setM(50);
		  System.out.println("Speed in mi/hr (50): "+speed1.getM());
		  System.out.println("Speed in km/hr (80.45): "+speed1.getK()+"\n");
		  
		  speed1.setK(50);
		  System.out.println("Speed in mi/hr (31.075): "+speed1.getM());
		  System.out.println("Speed in km/hr (50): "+speed1.getK());
		  
	  }
	 
		
	
		  
	
	 
}
