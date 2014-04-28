import javax.swing.*;

public class Demo {

    public static void main (String [] args) {

       int score;

       // get a score
       score = Integer.parseInt(
			JOptionPane.showInputDialog(null, "Enter a score"));

       if ( // put  score test here )
          JOptionPane.showMessageDialog(null, "The score is out of normal range");
       
       System.out.println("Done processing");
       
    }
}
