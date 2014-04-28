/* Still another class to test variables */

import javax.swing.*;

public class Variables3 {
    public static void main (String [] args) {

          int i1 = 5;
          int i2 = i1;
	      
          i1 = 7;

          JOptionPane.showMessageDialog(null, "integer i1's value is " + i1);
          JOptionPane.showMessageDialog(null, "integer i2's value is " + i2);
          
    }
}
