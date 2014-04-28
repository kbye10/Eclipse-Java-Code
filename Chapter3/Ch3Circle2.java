/*
    Introduction to OOP with Java 4th Ed, McGraw-Hill

    Wu/Otani

    Chapter 3 Sample Program: Compute Area and Circumference
                              with formatting

    File: Ch2Circle2.java

*/

import javax.swing.*;
import java.text.*;

class Ch3Circle2 {

    public static void main( String[] args ) {

        final double PI = 3.14159;

        String radiusStr;
        double radius, area, circumference;

        DecimalFormat df = new DecimalFormat("0.000");

        radiusStr = JOptionPane.showInputDialog(null, "Enter radius:");

        radius = Double.parseDouble(radiusStr);

        //compute area and circumference
        area          = PI * radius * radius;
        circumference = 2.0 * PI * radius;

        JOptionPane.showMessageDialog(null, "Given Radius: " + radius + "\n"
                                           + "Area: " + df.format(area)+ "\n"
                                           + "Circumference: "
                                           + df.format(circumference));
    }
}