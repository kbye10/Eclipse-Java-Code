
/*
  Introduction to OOP with Java 4th Ed, McGraw-Hill
 
  Wu/Otani
 
  Chapter 4 Sample Development: Loan Calculation (Step 3)
 
  File: Step3/LoanCalculator.java
 
  This class controls the input, computation, and output of loan
*/

import javax.swing.*;

class LoanCalculator {

//----------------------------------
//    Data Members
//----------------------------------

     // This object does the actual loan computation
    private Loan loan;

//----------------------------------
//
//  Main Method
//
//----------------------------------

    public static void main(String[] arg) {
        
        LoanCalculator calculator = new LoanCalculator();
        calculator.start();
    }

//----------------------------------
//    Constructors
//----------------------------------

    public LoanCalculator() {
        
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
        displayOutput();     //diaply the results
    }


//-------------------------------------------------
//      Private Methods:
//
//      void    describeProgram   (        )
//      void    displayOutput     (        )
//      void    getInputs         (        )
//
//------------------------------------------------


    // Provides a brief explaination of the program to the user.
    private void describeProgram() {
        System.out.println("inside describeProgram");   //TEMP
    }


    //Displays the input values and monthly and total payments.
    private void displayOutput() {
        
        System.out.println("Loan Amount: $" + loan.getAmount());
        System.out.println("Annual Interest Rate:"
                            + loan.getRate() + "%");
        System.out.println("Loan Period (years): " + loan.getPeriod());

        System.out.println("Monthly payment is $ " + loan.getMonthlyPayment());
        System.out.println("  TOTAL payment is $ " + loan.getTotalPayment());
    }


    // Gets three input values--loan amount, interest rate, and
    // loan period
    private void getInput() {
        double  loanAmount, annualInterestRate;

        int     loanPeriod;

        String  inputStr;

        inputStr           = JOptionPane.showInputDialog(null,
                                    "Loan Amount (Dollars+Cents):");
        loanAmount         = Double.parseDouble(inputStr);

        inputStr           = JOptionPane.showInputDialog(null,
                                    "Annual Interest Rate (e.g., 9.5):");
        annualInterestRate = Double.parseDouble(inputStr);

        inputStr           = JOptionPane.showInputDialog(null,
                                    "Loan Period - # of years:");
        loanPeriod         = Integer.parseInt(inputStr);

        //create a new loan with the input values
        loan = new Loan(loanAmount, annualInterestRate,loanPeriod);

    }

}