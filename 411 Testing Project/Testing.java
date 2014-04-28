
public class Testing {
	
//Triangle Problem
public static void Triangle(int a,int b, int c){
	boolean IsATriangle;
	boolean c1,c2,c3;
	// echo printing
//	System.out.println("Side A is "+a);
//	System.out.println("Side B is "+b);
//	System.out.println("Side C is "+c);
	// Input validation
	c1 = (5 <= a) && (a <= 205);
	c2 = (5 <= b) && (b <= 205);
	c3 = (5 <= c) && (c <= 205);
	if (!c1){
		System.out.println("Value of a is not in range of permitted values");
	}
	if (!c2){
		System.out.println("Value of b is not in range of permitted values");
	}
	if (!c3){
		System.out.println("Value of c is not in range of permitted values");
	}
	if (c1 && c2 && c2){
		// Checks if the input is a valid triangle
		if ((a < b+c) && (b < a+c) && (c < a+b)){
			IsATriangle = true;
		}
		else {
			IsATriangle = false;
		}
		// Determine triangle type
		if (IsATriangle == true){
			if ((a==b) && (b==c)){
				System.out.println("Equilateral");
			}
			else if ((a!=b) && (a!=c) && (b!=c)){
				System.out.println("Scalene");
			}
			else {
				System.out.println("Isosceles");
			}
		}
		else {
			System.out.println("Not a Triangle");
		}
	}
}

// NextDate Problem
public static void NextDate(int month,int day,int year){
	int tomorrowDay,tomorrowMonth,tomorrowYear;
	boolean c1,c2,c3,leapYear;
	c1 = (1 <=day) && (day <=31);
	c2 = (1 <=month) && (month <=12);
	c3 = (1801 <=year) && (year <=2021);
	if (!c1){
		System.out.println("Value of day not in the range 1..31");
	}
	if (!c2){
		System.out.println("Value of month not in range 1..12");
	}
	if (!c3){
		System.out.println("Value of year not in range 1801..2021");
	}
	if (c1 && c2 && c3){
		switch (month){
		// Month has 31 days		
		case 1: case 3: case 5: case 7: case 8: case 10:
			// Standard Day, add one to day
			if (day <31){
				tomorrowDay = day +1;
				tomorrowMonth = month;
				tomorrowYear = year;
			}
			// End of month
			else {
				tomorrowDay =1;
				tomorrowMonth = month+1;
				tomorrowYear = year;
			}
			// Print output
			System.out.println("Tomorrow's date is: "+tomorrowMonth+"/"+tomorrowDay+"/"+tomorrowYear);
			break;
			
			
		// Month has 30 days		
		case 4: case 6: case 9: case 11:
			// Standard Day, add one to day
			if (day< 30){
				tomorrowDay = day+1;
				tomorrowMonth = month;
				tomorrowYear = year;
				System.out.println("Tomorrow's date is: "+tomorrowMonth+"/"+tomorrowDay+"/"+tomorrowYear);
			}
			// End of month
			else {
				if (day ==30){
					tomorrowDay = 1;
					tomorrowMonth = month+1;
					tomorrowYear = year;
					System.out.println("Tomorrow's date is: "+tomorrowMonth+"/"+tomorrowDay+"/"+tomorrowYear);
				}
				// 31 is input in a 30 day month				
				else {
					System.out.println("Invalid Input Date");
				}
			}
			break;
			
	
			// Month is December			
		case 12:
			// Standard Day, add one to day
			if (day < 31){
				tomorrowDay = day +1;
				tomorrowMonth = month;
				tomorrowYear = year;
				System.out.println("Tomorrow's date is: "+tomorrowMonth+"/"+tomorrowDay+"/"+tomorrowYear);
			}
			// Year needs to go up
			else {
				tomorrowDay = 1;
				tomorrowMonth = 1;
				// Year is at max, i.e. last possible date given
				if (year == 2021){
					System.out.println("Invalid Input Date");
				}
				else {
					tomorrowYear = year +1;
					System.out.println("Tomorrow's date is: "+tomorrowMonth+"/"+tomorrowDay+"/"+tomorrowYear);
				}
			}
			break;
			
			
		// Month is February
		case 2:
			// Check for leapYear
			if (year % 4 == 0){
				leapYear = true;
			}
			else {
				leapYear = false;
			}
			
			// Double check for century year & century year logic
			if (year % 1000 == 0){
				// Only leap year if divisible by 400
				if (year % 400 == 0){
					leapYear = true;
				}
				// Otherwise it is not a leap year
				else{
					leapYear = false;
				}
			}
			
			// Continue Month logic
			if (day <28){
				tomorrowDay = day +1;
				tomorrowMonth = month;
				tomorrowYear = year;
				System.out.println("Tomorrow's date is: "+tomorrowMonth+"/"+tomorrowDay+"/"+tomorrowYear);
			}
			else if (day == 28){
				if (leapYear){ // Leap Year
					tomorrowDay = 29; // Leap Day
					tomorrowMonth = month;
					tomorrowYear = year;
					System.out.println("Tomorrow's date is: "+tomorrowMonth+"/"+tomorrowDay+"/"+tomorrowYear);
				}
				else {	// Not a Leap Year
					tomorrowDay = 1;
					tomorrowMonth = 3;
					tomorrowYear = year;
					System.out.println("Tomorrow's date is: "+tomorrowMonth+"/"+tomorrowDay+"/"+tomorrowYear);
				}
			}
			else if (day == 29){
				if (leapYear){
					tomorrowDay = 1;
					tomorrowMonth = 3;
					tomorrowYear = year;
					System.out.println("Tomorrow's date is: "+tomorrowMonth+"/"+tomorrowDay+"/"+tomorrowYear);
				}
				else { // Not a Leap Year
					System.out.println("Invalid Input Date");	
					}
			}
			else {	// Day is greater than 29
				System.out.println("Invalid Input Date");
			}
			break;
		}
	}
			
}

	
// Commission Problem


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Triangle(2,2,2);
		//NextDate(12,27,2021);
		
	}

}
