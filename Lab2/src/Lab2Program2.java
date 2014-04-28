/*
   Lab 2 Program 2: 

   File: Lab2Program2.java 
*/

import javax.swing.*;
//import java.awt.*;

public class Lab2Program2 {

    public static void main (String [] args) {
          
    String space,fullName,firstName,lastName;
	
	space = new String(" ");
	fullName = JOptionPane.showInputDialog(null, "What is your full name?");
	firstName = fullName.substring(0, fullName.indexOf(space));
	lastName = fullName.substring(fullName.indexOf(space)+1);

	JOptionPane.showMessageDialog(null, "Your first name is " + 
			firstName);
	JOptionPane.showMessageDialog(null, "Your last name is " + 
				            lastName);
    }
}
