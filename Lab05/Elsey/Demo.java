import javax.swing.*;

public class Demo {

    public static void main (String [] args) {

        double score;
        String letterScore;

        score = Double.parseDouble(
                      JOptionPane.showInputDialog(null,"Enter score"));

        if (score >= 60)
	    letterScore = "D";
        else if (score >=70)
	    letterScore = "C";
        else if (score >= 80)
	    letterScore = "B";
        else
	    letterScore = "A";

        JOptionPane.showMessageDialog(null, "Your letter grade is " + letterScore);
         
     }
}
