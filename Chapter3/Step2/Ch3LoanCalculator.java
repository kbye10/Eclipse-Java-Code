/*
    Introduction to OOP with Java 4th Ed, McGraw-Hill

    Wu/Otani

    Chapter 3 Sample Development: Loan Calculator  (Step 2)

    File: Step2/Ch3LoanCalculator.java

    Step 2: Display the Result

*/

import javax.swing.*;

class Ch3LoanCalculator {

    public static void main (String[] args) {
        double  loanAmount,
                annualInterestRate;

        double  monthlyPayment,
                totalPayment;

        int     loanPeriod;

        String  inputStr;

        //get input values
        inputStr           = JOptionPane.showInputDialog(null,
                                    "Loan Amount (Dollars+Cents):");
        loanAmount         = Double.parseDouble(inputStr);

        inputStr           = JOptionPane.showInputDialog(null,
                                    "Annual Interest Rate (e.g., 9.5):");
        annualInterestRate = Double.parseDouble(inputStr);

        inputStr           = JOptionPane.showInputDialog(null,
                                    "Loan Period - # of years:");
        loanPeriod         = Integer.parseInt(inputStr);


        //compute the monthly and total payments
        monthlyPayment = 132.15;
        totalPayment  =  15858.10;


        //display the result
        System.out.println("Loan Amount:          $" + loanAmount);
        System.out.println("Annual Interest Rate:  " + annualInterestRate + "%");
        System.out.println("Loan Period (years):   " + loanPeriod);

        System.out.println("\n"); //skip two lines
        System.out.println("Monthly payment is    $ " + monthlyPayment);
        System.out.println("  TOTAL payment is    $ " + totalPayment);
   }

}
