
/*
  Kevin Bye
  
  Introduction to OOP with Java 4th Ed, McGraw-Hill
 
  Wu/Otani
 
  Chapter 4 Sample Development: Skeleton (Step 1)
 
  File: Step1/MyProgram.java
 
  This class controls the input, computation, and output a program
  
*/
class MyProgram {

//----------------------------------
//    Data Members
//----------------------------------

     // declare objects here that you will need
    //private  ClassName objectName;

//----------------------------------
//
//  Main Method
//
//----------------------------------

    public static void main(String[] arg) {
        MyProgram myProgram = new MyProgram();
        myProgram.start();
    }

//----------------------------------
//    Constructors
//----------------------------------

    public MyProgram() {
        
    }

//-------------------------------------------------
//      Public Methods:
//
//          void start (        )
//
//------------------------------------------------

    //Top-level method that calls other private methods
    public void start() {

        describeProgram();   //tell what the program does
        getInput();          //get three input values
        computePayment();    //compute the monthly payment and total
        displayOutput();     //display the results
    }


//-------------------------------------------------
//      Private Methods:
//
//      void    computePayment    (        )
//      void    describeProgram   (        )
//      void    displayOutput     (        )
//      void    getInputs         (        )
//
//------------------------------------------------

   
    // Provides a brief explanation of the program to the user.
    private void describeProgram() {
        System.out.println("inside describeProgram");   //TEMP
    }    
    
    // Gets three input values--loan amount, interest rate, and
    //  loan period--using an InputBox object
    private void getInput() {
        System.out.println("inside getInput");   //TEMP
    }
    
    // Computes the monthly and total loan payments.
    private void computePayment() {
        System.out.println("inside computePayment");   //TEMP
    }


    //Display the input values and monthly and total payments.
    private void displayOutput() {
        System.out.println("inside displayOutput");   //TEMP
    }


}