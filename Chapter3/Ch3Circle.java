/*
    Introduction to OOP with Java 4th Ed, McGraw-Hill

    Wu/Otani

    Chapter 3 Sample Program: Compute Area and Circumference

    File: Ch2Circle.java

*/

import javax.swing.*;

class Ch3Circle {

    public static void main( String[] args ) {

        final double PI = 3.14159;

        String radiusStr;
        double radius, area, circumference;

        radiusStr = JOptionPane.showInputDialog(null, "Enter radius:");

        radius = Double.parseDouble(radiusStr);

        //compute area and circumference
        area          = PI * radius * radius;
        circumference = 2.0 * PI * radius;

        JOptionPane.showMessageDialog(null, "Given Radius: " + radius + "\n"
                                           + "Area: " + area+ "\n"
                                           + "Circumference: " + circumference);
    }
}