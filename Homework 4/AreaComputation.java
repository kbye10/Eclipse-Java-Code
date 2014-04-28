
/** Kevin Bye
 *  
 *  This program uses the custom instantiable class "Circle" to calculate the area of a 
 *  washer-shaped object.
 *  
 *  3/22/12
 */

	//Import statements

import javax.swing.*;
import java.text.*;

public class AreaComputation 
{

	//----------------------------------
	//		Data Members
	//----------------------------------
	
			// Declare data
		private Circle circle1, circle2;

	//----------------------------------
	//		Main Method
	//----------------------------------

		public static void main(String[] arg) 
		{
			AreaComputation area = new AreaComputation();
			area.start();
		}
	//----------------------------------
	//	    Constructors
	//----------------------------------

	    public AreaComputation() 
	    {
	       circle1 = new Circle();
	       circle2 = new Circle();
	    }

	//-------------------------------------------------
	//	      Public Methods:
	//
	//	          void start (        )
	//
	//-------------------------------------------------

	    //Top-level method that calls other private methods
	    public void start() 
	    {

	        describeProgram();  // Tell what the program does
	        getInputs();        // Get two input values
	        displayOutput();    // Compute and display the results
	    }


	//-------------------------------------------------
	//	      Private Methods:
	//
	//	      void    describeProgram   (        )
	//	      void    getInputs         (        ) 
	//	      void    displayOutput     (        )
	//
	//------------------------------------------------

	    // Provides a brief explanation of the program to the user.
	    private void describeProgram() 
	    {
	    	System.out.println("This program computes the area of a washer-shaped object given two radii for the circles that make ");
	    	System.out.println("up the washer shape. It also takes the absolute value of the area to always get a positive value.");
	    	System.out.println();
	    }
	    
	    // Gets two input values-- radius of circle 1, and radius of circle 2
	    // using a JOptionPane.  Sets inputs to radii of circle objects
	    private void getInputs()
	    {
	    	
	    	String stringRad1,stringRad2;
	    	double radius1,radius2;
	    	
	    	stringRad1 = JOptionPane.showInputDialog(null,"Enter radius of first circle");
	    	radius1 = Double.parseDouble(stringRad1);
	    	
	    	stringRad2 = JOptionPane.showInputDialog(null,"Enter radius of second circle");
	    	radius2 = Double.parseDouble(stringRad2);
	    	
	    	circle1.setRadius(radius1);
	    	circle2.setRadius(radius2);
	    	
	    }
/*	    
	    // Computes area of the washer shape
	    private void computeSolution()
	    {
	    	double area1,area2,areaT;
	    	
	    	area1 = circle1.getArea();
	    	area2 = circle2.getArea();
	    	areaT = Math.abs(area2-area1);
	    	System.out.println("The area of the washer is: "+areaT);
	    }	
*/	   
	    // Displays area in the console with a short description
	    private void displayOutput()
	    {
	    	DecimalFormat df = new DecimalFormat("0.000");
	    	double area1,area2,areaT;
	    	
	    	area1 = circle1.getArea();
	    	area2 = circle2.getArea();
	    	areaT = Math.abs(area2-area1);
	    	System.out.println("The first radius is: "+circle1.getRadius());
	    	System.out.println("The second radius is: "+circle2.getRadius()+"\n");
	    	System.out.println("The area of the washer is: "+df.format(areaT));
	    }
}

