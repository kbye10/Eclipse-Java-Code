
public class Circle {

	/**
	  Kevin Bye
	  This class gives creates Circle objects with radius r
	  and gives the area and circumference for those objects.
	  3/22/12
	 */
	
	// Data
	
	private double radius;
	
	// Constructors
	
	public Circle()
	{
		setRadius(0.0);
	}
	
	public Circle(double r)
	{
		setRadius(r);
	}
	
	// Methods 
	
	// public double getArea()
	// public double getCircum()
	// public void setRadius(double r)
	// public double getRadius()
	
	public double getArea()
	{
		double area;
		area = Math.PI * radius *  radius;
		return area;
	}
	
	public double getCircum()
	{
		return Math.PI * radius * 2.0;
	}
	
	 public void setRadius(double r)
	 {
		 radius = r;
	 }
	
	 public double getRadius()
	 {
		 return radius;
	 }
/*	 
	public static void main(String[] args) 
	{
		//Test constructors
		Circle c1 = new Circle();		// 0 param
		Circle c2 = new Circle(1.0);	// 1 param
		
		System.out.println("Radius of first circle = "+c1.getRadius());
		System.out.println("Area of first circle = "+c1.getArea());
		System.out.println("Circumference of first circle = "+c1.getCircum()+"\n");
		System.out.println("Radius of second circle = "+c2.getRadius());
		System.out.println("Area of second circle = "+c2.getArea());
		System.out.println("Circumference of second circle = "+c2.getCircum()+"\n");
		
		c1.setRadius(5);
		System.out.println("Radius of first circle (after setRadius) = "+c1.getRadius());
		System.out.println("Area of first circle (after setRadius) = "+c1.getArea());
		System.out.println("Circumference of first circle (after setRadius) = "+c1.getCircum()+"\n");	
	
	}
*/
}
