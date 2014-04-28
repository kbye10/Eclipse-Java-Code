/*
    Introduction to OOP with Java 4th Ed, McGraw-Hill

    Wu/Otani

    Chapter 15 Sample Program: Collection of recursive algorithms
                               discussed in Chapter 15

    File: Ch15Algorithms.java
*/

import java.io.*;

/**
 * Service Class for collecting all sample algorithms
 * in Chapter 15.
 *
 * @author Dr. Caffeine
 */

class Ch15Algorithms {


//----------------------------------
//    Constructors
//----------------------------------

    /**
     * Default constructor
     */
    public Ch15Algorithms( ) {

    }

//-------------------------------------------------
//      Public Methods:
//
//
//            void   anagram            ( String, String     )
//            void   directoryListing   ( File               )
//            int    factiorial         ( int                )
//            void   quickSort          ( int[], int, int    )
//            void   TowersOfHanoi      ( int, int, int, int )
//
//------------------------------------------------


    /**
     * Recursively list the anagrams of a given text
     *
     * @param prefix the prefix part of the anagram
     * @param suffix the suffix part of the anagram
     */
    public void anagram( String prefix, String suffix )
    {
        String newPrefix, newSuffix;

        int numOfChars = suffix.length();

        if (numOfChars == 1) {
            //End case: print out one anagram
            System.out.println( prefix + suffix );
        } else {
            for (int i = 1; i <= numOfChars; i++ ) {

                newSuffix = suffix.substring(1, numOfChars);

                newPrefix = prefix + suffix.charAt(0);

                anagram( newPrefix, newSuffix ); //recursive call

                //rotate left to create a rearranged suffix
                suffix = newSuffix  + suffix.charAt(0);
            }
        }
    }


    /**
     * Recursively list the contents of a directory
     *
     * @param file a directory or a file
     *
     */
    public void directoryListing( File file )
    {
        //'file' may be a directory or a file

        String[] fileList;

        String   pathname = file.getAbsolutePath();

        if ( file.isFile() ) {
                                                  //it’s a file so
            System.out.println( file.getName() ); //print it out

        }
        else { //it’s a directory, so recurse

            fileList = file.list();

            for (int i = 0; i < fileList.length; i++) {

                File nextFile = new File(pathname + File.separator + fileList[i]);

                directoryListing( nextFile ); //recursive call
            }
        }
    }


    /**
     * Recursive factorial method.
     *
     * @param N the factorial of positive N is computed;
     *          if N is too big an overflow will occur
     *
     * @return the factorial of N
     */
    public int factorial( int N )
    {
        if ( N == 1 ) {

            return 1;
        }
        else {

            return N * factorial( N-1 );
        }


    }


    /**
     * Recursively sort the number array using the
     * quicksort algorithm.
     *
     * @param number integer array to sort
     * @param low    the low bound index
     * @param high   the high bound index
     */
    public void quickSort( int[] number, int low, int high )
    {
        if ( low < high ) {

            int mid = partition( number, low, high );

            quickSort( number,   low, mid-1 );
            quickSort( number, mid+1, high  );
        }
    }


    /**
     * Recursively computes the movement for solving the
     * Tower of Hanoi problem.
     *
     * @param N     the number of disks to move
     * @param from  the origin peg number
     * @param to    the destination peg number
     * @param spare the temporary-use peg number
     */
    public void towersOfHanoi(  int N,       //number of disks
                                int from,    //origin peg
                                int to,      //destination peg
                                int spare )  //"middle" peg
    {
        if ( N == 1 ) {

            moveOne( from, to );
        } else {

            towersOfHanoi( N-1, from, spare, to );

            moveOne( from, to );

            towersOfHanoi( N-1, spare, to, from );
        }
    }


//-------------------------------------------------
//      Private Methods:
//
//          void    moveOne     (   int, int          )
//          int     partition   (   int[], int, int   )
//
//------------------------------------------------

    /**
     * Moves a single disk from one peg to another peg.
     *
     * @param from the origing peg number
     * @param to   the destination peg number
     */
    private void moveOne( int from, int to ) {
        System.out.println( from + " ---> " + to );
    }


    /**
     * Divides the portion of the number array into two halves. The
     * first half contains elements less than pivot, and
     * the second half contians elements greater than
     * pivot.
     *
     * @param start the low end of the array to partition
     * @param end   the high end of the array to partition.
     *
     * @return the location of the position where the pivot rests
     */
    private int partition( int[] number, int start, int end ) {
        //set the pivot
        int pivot = number[start];

        do {
            //look for a number smaller than pivot from the end
            while ( start < end && number[end] >= pivot) {
                end--;
            }

            if ( start < end ) { //found a smaller number
                number[start] = number[end];

                //now find a number larger than pivot
                //from the start
                while ( start < end && number[start] <= pivot) {
                    start++;
                }

                if (start < end) { //found a larger number
                    number[end] = number[start];
                }
            }

        } while ( start < end );

        //done, move the pivot back to the array
        number[start] = pivot;

        return start;
    }
}