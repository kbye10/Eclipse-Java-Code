/*
    Introduction to OOP with Java 4th Ed, McGraw-Hill

    Wu/Otani

    Chapter 3 Sample Program: Day of the week the Declaration of
                              Independence as adopted

    File: Ch3IndependenceDay.java

*/

import java.util.*;
import java.text.*;
import javax.swing.*;

class Ch3IndependenceDay {

    public static void main( String[] args ) {

        GregorianCalendar independenceDay
           = new GregorianCalendar(1776, Calendar.JULY, 4);

         // = new GregorianCalendar(1776, Calendar.AUGUST, 2); //date it was signed


        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");

        JOptionPane.showMessageDialog(null, "It was adopted on "
                        + sdf.format(independenceDay.getTime()));
    }
}