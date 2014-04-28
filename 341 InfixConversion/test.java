
public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String postfix;
		int result = 0;
		Conversion conversion1 = new Conversion();
		Conversion conversion2 = new Conversion();
		Conversion conversion3 = new Conversion();
		Conversion conversion4 = new Conversion();
		Conversion conversion5 = new Conversion();
		Conversion conversion6 = new Conversion();
		System.out.println("Test: 2+3*4");
		postfix = conversion1.Convert("2+3*4");
		System.out.println(postfix);
		result = conversion1.Evaluate(postfix);
		System.out.println(result+"\n");
		
		System.out.println("Test: (2+3)*4");
		postfix = conversion2.Convert("(2+3)*4");
		System.out.println(postfix);
		result = conversion2.Evaluate(postfix);
		System.out.println(result+"\n");
		
		System.out.println("Test: 4*5/2-5");
		postfix = conversion3.Convert("4*5/2-5");
		System.out.println(postfix);
		result = conversion3.Evaluate(postfix);
		System.out.println(result+"\n");
		
		System.out.println("Test: 2+3-4+5*6/3");
		postfix = conversion4.Convert("2+3-4+5*6/3");
		System.out.println(postfix);
		result = conversion4.Evaluate(postfix);
		System.out.println(result+"\n");
		
		System.out.println("Test: 2+3-(2+5*6)/4/2");
		postfix = conversion5.Convert("2+3-(2+5*6)/4/2");
		System.out.println(postfix);
		result = conversion5.Evaluate(postfix);
		System.out.println(result+"\n");
		
		System.out.println("Test: (2+8)-((2+5)*6)/3/2");
		postfix = conversion6.Convert("(2+8)-((2+5)*6)/3/2");
		System.out.println(postfix);
		result = conversion6.Evaluate(postfix);
		System.out.println(result+"\n");
	}
}