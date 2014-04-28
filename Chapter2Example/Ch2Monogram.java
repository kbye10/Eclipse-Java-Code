/*
    Introduction to OOP with Java 4th Ed, McGraw-Hill

    Wu/Otani

    Chapter 2 Sample Program: Displays the Monogram

    File: Step2/Ch2Monogram.java

*/

import javax.swing.*;

class Ch2Monogram {

    public static void main( String[] args ) {

        //Define Strings
    	String  name, first, middle, last,
                space, monogram;

        space = " ";

        //Input the full name
        name = JOptionPane.showInputDialog(null,
                            "Enter your full name (first, middle, last):");


        //Extract first, middle, and last names
        first  = name.substring(0, name.indexOf(space));
        name   = name.substring(name.indexOf(space)+1, name.length());
        
        middle = name.substring(0, name.indexOf(space));
        last   = name.substring(name.indexOf(space)+1, name.length());

        //Verify the substring operations
        // JOptionPane.showMessageDialog(null, "First:"  + first);
        // JOptionPane.showMessageDialog(null, "Middle:" + middle);
        // JOptionPane.showMessageDialog(null, "Last:"   + last);

        //Compute the monogram
        monogram = first.substring(0, 1)
                    + middle.substring(0, 1)
                        + last.substring(0, 1);

        //Output the result
         JOptionPane.showMessageDialog(null, "Your monogram is " + monogram);
    }
}