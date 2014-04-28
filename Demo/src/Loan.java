// Loan Class (Step 3)

/*
   Introduction to OOP with Java 4th Ed, McGraw-Hill
  
   Wu/Otani
  
   Chapter 4 Sample Development: Loan Calculation (Step 3)
  
   File: Step3/Loan.java
  
   This class handles the loan computation.
 
*/

class Loan {

//----------------------------------
//    Data Members
//----------------------------------

    // Constant for the number of months in a year
    private final int MONTHS_IN_YEAR = 12;

    // The amount of the loan
    private double    loanAmount;

    //The monthly interest rate
    private double    monthlyInterestRate;

    // The number of monthly payments
    private int       numberOfPayments;



//----------------------------------
//    Constructor
//----------------------------------

    //Creates a new Loan object with passed values.
    public Loan(double amount, double rate, int period) {
        setAmount(amount);
        setRate  (rate  );
        setPeriod(period);
    }

//-------------------------------------------------
//      Public Methods:
//
//          double  getAmount   (           )
//          double  getPeriod   (           )
//          int     getRate     (           )
//
//          double  getMontlyPayment(       )
//          double  getTotalPayment (       )
//
//          void    setAmount   ( double    )
//          void    setPeriod   ( int       )
//          void    setRate     ( double    )
//
//------------------------------------------------

    //Returns the loan amount.
    public double getAmount( ) {
        return loanAmount;
    }

    //Returns the loan period in the number of years.
    public int getPeriod( ) {
        return numberOfPayments / MONTHS_IN_YEAR;
    }

    //Returns the annual interest rate.
    public double getRate( ) {
        return monthlyInterestRate * 100.0 * MONTHS_IN_YEAR;
    }
    
    //Returns the monthly payment
    public double getMonthlyPayment( ) {
        return 132.15; //TEMP
    }
    
    //Returns the total payment
    public double getTotalPayment( ) {
        return 15858.10; //TEMP
    }

    //Sets the loan amount of this loan.
    public void setAmount(double amount) {
        loanAmount = amount;
    }

    //Sets the interest rate of this loan.
    public void setRate(double annualRate) {
        monthlyInterestRate = annualRate / 100.0 / MONTHS_IN_YEAR;
    }

    //Sets the loan period of this loan.
    public void setPeriod(int periodInYears) {
        numberOfPayments = periodInYears * MONTHS_IN_YEAR;
    }
}