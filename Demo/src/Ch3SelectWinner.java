/*
    Introduction to OOP with Java 4th Ed, McGraw-Hill

    Wu/Otani

    Chapter 3 Sample Program: Select the Winning Number

    File: Ch3SelectWinner.java

*/

import java.util.*;

class Ch3SelectWinner {

    public static void main( String[] args ) {

        int startingNumber;  //the starting number
        int count;           //the number of party goers
        int winningNumber;   //the winner
        int min, max;        //the range of random numbers to generate

        Scanner scan = new Scanner(System.in);

        //Get two input values
        System.out.print("Enter the starting number M:     ");
        startingNumber = scan.nextInt();

        System.out.print("Enter the number of party goers: ");
        count  = scan.nextInt();

        //select the winner
        min = startingNumber + 1;
        max = startingNumber + count;

        winningNumber  = (int) (Math.floor(Math.random() * (max - min + 1))
                                                + min);


        System.out.println("\nThe Winning Number is " + winningNumber);

    }
}