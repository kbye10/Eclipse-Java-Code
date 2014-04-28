/*
   Lab 2 Program 1: 

   File: Lab2Program1.java 
*/

import javax.swing.*;
import java.awt.*;

public class Lab2Program1 {

    public static void main (String [] args) {
    
	JFrame window;

        window = new JFrame ();

        window.setSize(500,400);
        window.setTitle("My First Java Program in Lab");

        Point position;

	position = new Point(600,200);

        window.setLocation(position);
	 window.setVisible(true); 
	 JOptionPane.showMessageDialog(window, "Click OK to close me");
    }
}
