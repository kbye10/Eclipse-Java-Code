/*
    Introduction to OOP with Java 4th Ed, McGraw-Hill

    Wu/Otani

    Chapter 2 Sample Program: Reads a String Input

    File: Ch2Greetings.java

*/

import javax.swing.*;

class Ch2Greetings {

    public static void main( String[] args ) {

        String name;

        name = JOptionPane.showInputDialog(null, "What is your name?");

        JOptionPane.showMessageDialog(null, "Nice to meet you, " + name + ".");

    }
}