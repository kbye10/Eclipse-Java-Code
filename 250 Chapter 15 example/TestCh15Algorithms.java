/*
    Introduction to OOP with Java 3rd Ed, McGraw-Hill

    Wu/Otani

    Chapter 15 Sample Program: Test all sample recursive methods
                               discussed in Chapter 15

    File: TestCh15Algorithms.java

*/

import javax.swing.*;
import java.awt.*;
import java.io.*;

/**
 * The main program to test the Ch 15 recursive algorithms.
 *
 * @author Dr. Caffeine
 *
 */
class TestCh15Algorithms {

//--------------------------------
//  Data Members
//--------------------------------

    /**
     * A NL (new line) constant
     */
    private static final String NL = System.getProperty("line.separator");

    /**
     * The Ch15Algorithms object for running the selected algorithm
     */
    private Ch15Algorithms algorithmRunner;

//--------------------------------
//  Constructors
//--------------------------------

    /**
     * Default constructor.
     */
    public TestCh15Algorithms() {
        algorithmRunner = new Ch15Algorithms( );
    }



    public static void main( String[] args ) {
        TestCh15Algorithms driver = new TestCh15Algorithms(  );
        driver.start( );
    }


    public void start( ) {
        int selection;

        do {

            selection = getSelection( );

            switch ( selection ) {

                case 1: runFactorial( );
                        break;

                case 2: runDirList( );
                        break;

                case 3: runAnagram( );
                        break;

                case 4: runTowersOfHanoi( );
                        break;

                case 5: runQuickSort( );
                        break;

            }
        } while ( selection != 0 );

        System.exit(0);
    }

    private void runFactorial( ) {
        int N;

        while (true) {
            N = Integer.parseInt(
                        JOptionPane.showInputDialog(null,
                                                    "Compute N! Enter N:" ));

            if (N > 0) break;

            JOptionPane.showMessageDialog(null, "N must be positive" );
        }

        int answer = algorithmRunner.factorial( N );

        System.out.println(NL + NL);
        System.out.println( "Factorial of " + N + " is " + answer );
    }

    private void runDirList( ) {
        String dirName = JOptionPane.showInputDialog(null,
                                                    "Enter the folder name");

        File file = new File( dirName );

        System.out.println(NL + NL);

        algorithmRunner.directoryListing( file );
    }

    private void runAnagram( ) {
        String word = JOptionPane.showInputDialog(null,
                                                  "Generate anagrams. Enter a word" );

        System.out.println(NL + NL);

        algorithmRunner.anagram( "", word );
    }

    private void runTowersOfHanoi( ) {
        int diskCnt = Integer.parseInt(
                        JOptionPane.showInputDialog(null,
                                                    "Towers of Hanoi. How many disks?"));

        System.out.println(NL + NL);

        algorithmRunner.towersOfHanoi( diskCnt, 1, 3, 2 );
    }

    private void runQuickSort( ) {
        int N = Integer.parseInt(
                   JOptionPane.showInputDialog(null,
                                               "Quicksort. Number of elements to sort:"));

        System.out.println(NL + NL);
        System.out.println(" Unsorted List: " );


        //generate random numbers from 1 to N
        int[] list = new int[N];

        for (int i = 1; i < N; i++) {
            list[i] = (int) Math.floor(Math.random( ) * N) + 1;
            System.out.print("  " + list[i]);
        }

        //now sort the list
        algorithmRunner.quickSort( list, 0, N-1 );

        System.out.println(NL + NL);
        System.out.println( " Sorted List: " );

        for (int i = 1; i < N; i++) {
            System.out.print("  " + list[i] );
        }
    }

    private int getSelection( ) {
        int selection;

        String menu = "Select Algorithm:"         + NL +
                        "   1) Factorial"         + NL +
                        "   2) Directory Listing" + NL +
                        "   3) Anagram"           + NL +
                        "   4) Towers of Hanoi"   + NL +
                        "   5) Quicksort"         + NL +
                        "   -------------------"  + NL +
                        "   0) Quit" ;


        selection = Integer.parseInt(
                        JOptionPane.showInputDialog(null, menu));

        return selection;
    }
}


