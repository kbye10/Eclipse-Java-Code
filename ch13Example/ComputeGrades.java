/*
    Introduction to OOP with Java 4th Ed, McGraw-Hill

    Wu/Otani

    Chapter 13 Sample Development: Compute Grades for Undergraduate
                                    and Graduate Students

    File: ComputeGrades.java

*/

import java.io.*;

//-----------------------  STEP 1 -------------------------//

/**
 *   Class ComputeGrades
 *
 *   The top level object for managing all other objects in the program
 *
 */
class ComputeGrades extends MainWindow {

//----------------------------------
//    Data Members
//----------------------------------

    /**
     * The default size for the roster array
     */
    private static final int DEFAULT_SIZE = 25;

    /**
     * An outputbox for displaying the result
     */
    private OutputBox   outputBox;

    /**
     * An array of Student for maintaining student info
     */
    private Student[]   roster;


//----------------------------------
//    Constructors
//----------------------------------

    /**
     * Default constructor
     */
    public ComputeGrades() {
        this (DEFAULT_SIZE);
    }

    /**
     * Constructs this object with the designated size
     * for an array.
     *
     * @param arraySize the size of the roster array
     */
    public ComputeGrades(int arraySize) {
        super();   // an explicit call to the supercalss constructor

        outputBox   = new OutputBox(this);

        roster      = new Student[arraySize];
    }

//-----------------------------------
// Main
//-----------------------------------
    public static void main(String[] args) {
      ComputeGrades gradeComputer = new ComputeGrades();
      gradeComputer.processData();
    }

//-------------------------------------------------
//      Public Methods:
//
//          void    processData   (           )
//
//------------------------------------------------

    /**
     * Loads the data from a file, computes the grades,
     * and display the result.
     *
     */
    public void processData() {
         setVisible(true);
         outputBox.setVisible(true);

         boolean success = readData();

         if (success) {
            computeGrade();
            printResult();
         } else {
            outputBox.println("File Input Error");
         }
    }

//-------------------------------------------------
//      Private Methods:
//
//        void        computeGrade    (     )
//        void        printResult     (     )
//        boolean     readData        (     )
//
//------------------------------------------------

    /**
     * Scans through the roster array and computes
     * the course grades.
     *
     */
    private void computeGrade() {

        outputBox.println("Inside computeGrade");  //TEMP
    }

    /**
     * Displays the result in an outputBox.
     *
     */
    private void printResult() {

        outputBox.println("Inside printResult");  //TEMP
    }

    /**
     * Opens a textfile, read in data, and
     * construct the roster array.
     *
     * @return true if the operation is successful
     *
     */
    private boolean readData() {

        outputBox.println("Inside readData");  //TEMP
        return true;
    }
}