/* A class to demonstrate variables */
import javax.swing.*;

public class Variables {

    public static void main (String [] args) {
 
          Customer c1 = new Customer("Sam");
          Customer c2 = new Customer("Karen");

          c1.changeName("Karen");
          JOptionPane.showMessageDialog(null,
                       "Customer c1's name is " + c1.getName() +"\n");
          JOptionPane.showMessageDialog(null,
                       "Customer c2's name is " + c2.getName() + "\n");
          
    }
}
