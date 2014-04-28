/*
    Introduction to OOP with Java 4th Ed, McGraw-Hill

    Wu/Otani

    Chapter 2 Sample Program: Simple String Processing

    File: Ch2StringProcessing.java

*/

import javax.swing.*;

class Ch2StringProcessing {

    public static void main( String[] args ) {

        String fullName, firstName, lastName, space;

        fullName = new String("Decafe Latte");
        space    = new String(" ");

        firstName = fullName.substring(0, fullName.indexOf(space));
        lastName  = fullName.substring(fullName.indexOf(space) + 1,
                                       fullName.length());

        JOptionPane.showMessageDialog(null, "Full Name: " + fullName);

        JOptionPane.showMessageDialog(null, "First: " + firstName);

        JOptionPane.showMessageDialog(null, "Last: " + lastName);

        JOptionPane.showMessageDialog(null, "You last name has " +
                                            lastName.length( )   +
                                            " characters.");
    }
}