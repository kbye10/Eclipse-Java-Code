/*
    Introduction to OOP with Java 4th Ed, McGraw-Hill

    Wu/Otani

    Chapter 2 Sample Program: Shows a Message Dialog

    File: Ch2ShowMessageDialog.java

*/

import javax.swing.*;

class Ch2ShowMessageDialog {

    public static void main( String[] args ) {

        JFrame jFrame;

        jFrame = new JFrame( );
        jFrame.setSize(400,300);
        jFrame.setVisible(true);

        JOptionPane.showMessageDialog(jFrame, "How are you?");

        JOptionPane.showMessageDialog(null, "Good Bye");

    }
}