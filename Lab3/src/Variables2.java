/* Another class to test variables */

import javax.swing.*;

public class Variables2 {
    public static void main (String [] args)
    {

          Customer c1 = new Customer("Sam");
          Customer c2 = c1;

          c1.changeName("Karen");

          JOptionPane.showMessageDialog(null, 
                                        "Customer c1's name is " +
                                                          c1.getName());
          JOptionPane.showMessageDialog(null,
                                        "Customer c2's name is " +
                                                          c2.getName());
    }
}
