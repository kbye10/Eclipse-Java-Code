import javax.swing.*;

public class Demo {

    public static void main (String [] args) {

	double x, y;
	int darts;
	int inside = 0;
	double pi;

	darts = Integer.parseInt(
	           JOptionPane.showInputDialog(null, "How many darts?"));
	for (int i = 0 ; i < darts ; i++) {
	    x = Math.random();
	    y = Math.random();
	    if ( (x*x)+(y*y) <= 1
	    		)
		inside++;
	}

	pi = 4*((double)inside/(double)darts);

        JOptionPane.showMessageDialog(null, "pi is approximately "+pi);
        System.exit(0);
    }
}
