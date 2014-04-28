/*
    Introduction to OOP with Java 4th Ed, McGraw-Hill

    Wu/Otani

    Chapter 3 Sample Program: Compute Area and Circumference
                              with formatting using standard
                              output

    File: Ch2Circle3.java

*/

import javax.swing.*;
import java.text.*;

class Ch3Circle3 {

    public static void main( String[] args )  {

        final double PI = 3.14159;

        String radiusStr;
        double radius, area, circumference;

        DecimalFormat df = new DecimalFormat("0.000");

        //Get input
        radiusStr = JOptionPane.showInputDialog(null, "Enter radius:");
        radius    = Double.parseDouble(radiusStr);

        //Compute area and circumference
        area          = PI * radius * radius;
        circumference = 2.0 * PI * radius;

        //Display the results
        System.out.println("");
        System.out.println("Given Radius: " + radius);
        System.out.println("Area: " + df.format(area));
        System.out.println("Circumference: " + df.format(circumference));

        /*
        System.out. println("\nGiven Radius: " + radius + "\n"
                                 + "Area: " + df.format(area)+ "\n"
                                 + "Circumference: "
                                 + df.format(circumference));
        */
    }
}