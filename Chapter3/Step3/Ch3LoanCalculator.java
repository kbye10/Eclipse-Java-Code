/*
    Introduction to OOP with Java 4th Ed, McGraw-Hill

    Wu/Otani

    Chapter 3 Sample Development: Loan Calculator  (Step 3)

    File: Step3/Ch3LoanCalculator.java

    Step 3: Compute the monthly and total payments

*/

import javax.swing.*;

class Ch3LoanCalculator {

    public static void main (String[] args) {
        final int MONTHS_IN_YEAR = 12;

        double  loanAmount,
                annualInterestRate;

        double  monthlyPayment,
                totalPayment;

        double  monthlyInterestRate;

        int     loanPeriod;

        int     numberOfPayments;

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
        monthlyInterestRate = annualInterestRate / MONTHS_IN_YEAR / 100;
        numberOfPayments    = loanPeriod * MONTHS_IN_YEAR;

        monthlyPayment = (loanAmount * monthlyInterestRate) /
                                      (1 - Math.pow(1/(1 + monthlyInterestRate),
                                                    numberOfPayments ) );

        totalPayment  =  monthlyPayment * numberOfPayments;


        //display the result
        System.out.println("Loan Amount:          $" + loanAmount);
        System.out.println("Annual Interest Rate:  " + annualInterestRate + "%");
        System.out.println("Loan Period (years):   " + loanPeriod);

        System.out.println("\n"); //skip two lines
        System.out.println("Monthly payment is    $ " + monthlyPayment);
        System.out.println("  TOTAL payment is    $ " + totalPayment);
   }

}
