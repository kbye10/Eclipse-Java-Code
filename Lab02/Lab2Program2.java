/*
   Lab 2 Program 2: 

   File: Lab2Program2.java 
*/

import javax.swing.*;
//import java.awt.*;

public class Lab2Program2 {

    public static void main (String [] args) {
          
	String firstName;
	String lastName;

	firstName = JOptionPane.showInputDialog(null, "What is your first name?");
	lastName = JOptionPane.showInputDialog(null, "What is your last name?");

	JOptionPane.showMessageDialog(null, "Your full name is " + 
				            firstName + lastName);
    }
}
