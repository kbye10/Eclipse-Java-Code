/*
    Introduction to OOP with Java 4th Ed, McGraw-Hill

    Wu/Otani

    Chapter 3 Sample Development: Loan Calculator  (Step 1)

    File: Step1/Ch3LoanCalculator.java

    Step 1: Input Data Values

*/

import javax.swing.*;

class Ch3LoanCalculator {

    public static void main (String[] args) {
        double  loanAmount,
                annualInterestRate;

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

        //echo print the input values
        System.out.println("Loan Amount:          $" + loanAmount);
        System.out.println("Annual Interest Rate:  " + annualInterestRate + "%");
        System.out.println("Loan Period (years):   " + loanPeriod);
   }

}
