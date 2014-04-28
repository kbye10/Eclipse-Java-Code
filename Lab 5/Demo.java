public class Demo {
    public static void main (String [] args) {

	int x, y;
        x = 7;
        y = 7;

        if (x == y)
	    System.out.println("The ints are equal");
        else
	    System.out.println("The ints are NOT equal");

        OurPoint p, q;
        p = new OurPoint (2,3);
        q = new OurPoint (2,3);

        if (p.equals(q))
	    System.out.println("(1)The points are equal");
        else
	    System.out.println("(1)The points are NOT equal");

        OurPoint a, b;
        a = p;
        b = p;

        if (a == b)
	    System.out.println("(2)The points are equal");
        else
	    System.out.println("(2)The points are NOT equal");
    }
}
