public class Employee implements Comparable {
    private String first;
    private String last;
    private String SSN;
    private int age;
    private double salary;

    public Employee(String f, String l, String ssn, int a, double s) {
	first = f;
	last = l;
	SSN = ssn;
	age = a;
	salary = s;
    }

    public int getAge() { return age; }
    public double getSalary() { return salary; }
    public String toString () { return last + ", " + first; }
    public String getSSN() { return SSN; }
    public int compareTo(Object obj) {
	return SSN.compareTo(((Employee)obj).SSN);
    }
    public boolean equals(Object obj) {
	return SSN.equals(((Employee)obj).SSN);
    }
}
