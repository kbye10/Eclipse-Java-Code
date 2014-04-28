
public class Demo {

    public static void main (String [] args){
        double side1, side2, side3;

        // get the sides of a triangle
        side1 = Double.parseDouble
                  JOptionPane.showInputDialog(null, "Enter side 1 (shortest)");
        side2 = Double.parseDouble
                  JOptionPane.showInputDialog(null, "Enter side 2 (medium)");
        side3 = Double.parseDouble
                  JOptionPane.showInputDialog(null, "Enter side 3 (longest)");


        if (side1 <=0 || side2 <= 0 || side3 <=0) {
           System.out.println("Error: Sides of a triangle" +
                              " should be all positive.");
           return;
        } 
        else if (side1 + side2 <= side3) {
           System.out.println("Error: These cannot be the" +
                              " sides of a legal triangle");
           return;
        }
        else if (side1 == side3) {
           System.out.println("Equilateral triangle");
           return;
        }
        else if (side1 == side2) {
           System.out.println("Isosceles triangle");
           return;
        }
        else 
           System.out.println ("Scalene triangle");
        
     }
     
}
