/* The Customer Class */

//import javabook.*;

public class Customer
{
	// instance variables
    String name;


	/**
	 * Constructor for objects of class Customer
	 */
	public Customer(String n)
	{
		// initialize instance variables
        name = n;
		
	}

	// methods
    /**
     * Update customer name
     */
    public void changeName( String n)
    {
       name = n;
    }


    /**
     * Get customer name
     */
     public String getName()
     {
         return name;
     }

}
