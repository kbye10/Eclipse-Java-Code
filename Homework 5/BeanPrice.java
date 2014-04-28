import javax.swing.JOptionPane;
import java.text.*;


/*
  Kevin Bye
  
  Introduction to OOP with Java 4th Ed, McGraw-Hill
 
  Wu/Otani
 
  File: BeanPrice.java
 
  This class controls the input of bags of beans bought, calculates cost and corresponding
  discount, then calculates the total cost and displays all of the data.
  
*/
class BeanPrice {

//----------------------------------
//    Data Members
//----------------------------------

     private int bags;
     private double discount,discountAmount,cost,total;
     

//----------------------------------
//
//  Main Method
//
//----------------------------------

    public static void main(String[] arg) {
        BeanPrice program = new BeanPrice();
        program.start();
    }

//----------------------------------
//    Constructors
//----------------------------------

   // None needed

//-------------------------------------------------
//      Public Methods:
//
//          void start (        )
//
//------------------------------------------------

    //Top-level method that calls other private methods
    public void start() {

        describeProgram();   //tell what the program does
        getInput();          //get input value
        computeCost();		// Compute original cost
        computeDiscount();	// Compute discount
        computeTotal(); 	//compute the total cost of purchase
    }


//-------------------------------------------------
//      Private Methods:
//
//  	void    computeCost       (        )
//  	void    computeDiscount   (        )    
//      void    computeTotal      (        )
//      void    describeProgram   (        )
//      void    getInputs         (        )
//
//------------------------------------------------

   
    // Provides a brief explanation of the program to the user.
    private void describeProgram() {
        System.out.println("This program accepts the input of how many bags of coffee beans are bought and calculates");
        System.out.println("the corresponding cost and discount, and applies those to calculate the total cost of the order.");
        System.out.println();
    }    
    
    // Gets three input values--loan amount, interest rate, and
    //  loan period--using an InputBox object
    private void getInput() {
        bags = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of bags purchased"));
        bags = Math.abs(bags);
    }
   
    // Computes original cost
    private void computeCost() {
        cost = bags*5.50;
    }   
   
    // Computes discount associated with number of bags bought
    private void computeDiscount() {
       if (bags >= 300)
       		discount = .30;
       	else if (bags >= 200)
       		discount = .25;
       	else if (bags >= 150)
       		discount = .20;
       	else if (bags >= 100)
       		discount = .15;
       	else if (bags >= 50)
       		discount = .10;
       	else if (bags >= 25)
       		discount = .05;
       	else
       		discount = 0;
   
       
      
       discountAmount = cost*discount;
    }   
    
    // Computes the total cost of the order
    private void computeTotal() {
        DecimalFormat df = new DecimalFormat("0.00");
    	total = cost-discountAmount;
    			
    	System.out.println("Number of bags ordered: "+bags+"  - $ "+df.format(cost));
        System.out.println();
        System.out.println("             Discount: "+(int)(discount*100)+"%  - $ "+df.format(discountAmount));
        System.out.println();
        System.out.println("Your Total Charge is: $ "+df.format(total));
    
    }


}
