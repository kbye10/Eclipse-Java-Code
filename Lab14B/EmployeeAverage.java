import javax.swing.*;
import javax.swing.event.*;
import java.text.*;
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

class EmployeeAverage extends JFrame
    implements ListSelectionListener, ItemListener, ActionListener {

    private JList list;
    private JTextArea avg;
    private JRadioButton [] averageBy;
    private JRadioButton averageSelection;

    public static void main(String [] args) {
	EmployeeAverage frame = new EmployeeAverage();
    }

    public EmployeeAverage() {
	Container contentPane;

	File file;
	FileReader fileReader = null;
	BufferedReader buffReader;
	ButtonGroup averageType;

	file = new File("employees");
	try {
	    fileReader = new FileReader(file);
	} catch (FileNotFoundException e) {
	    System.out.println("Cannot open employees file");
	    System.exit(1);
	}
	buffReader = new BufferedReader(fileReader);

	ArrayList employees = new ArrayList();
	String line = "";
	String first;
	String last;
	String SSN;
	int age;
	double salary;
	int lineCount = 0;

	while (true) {
	    try {
		line = buffReader.readLine();
		if (line == null)
		    break;
		lineCount++;
		first = line;
		line = buffReader.readLine(); lineCount++;
		last = line;
		line = buffReader.readLine(); lineCount++;
		SSN = line;
		line = buffReader.readLine(); lineCount++;
		age = Integer.parseInt(line);
		line = buffReader.readLine(); lineCount++;
		salary = Double.parseDouble(line);
	    } catch (IOException e) {
		System.err.println("Data file error at line "+lineCount);
		System.err.println("Ignoring rest of file");
		break;
	    } catch (NumberFormatException e) {
		System.err.println("Illegal age or salary at line "+lineCount);
		System.err.println("Ignoring rest of file");
		break;
	    }
	    employees.add(new Employee(first, last, SSN, age, salary));
	}
	System.out.println("Number of employees: " + employees.size());

	Collections.sort(employees);

	// when we get here, employees refers to a sorted employee list

	setSize(300,500);
	setTitle("Employee Averages");
	//setLocation(150,250);

	contentPane = getContentPane();
	contentPane.setBackground(Color.white);
	contentPane.setLayout(new BorderLayout());

	// Create a panel for the buttons
	JPanel averageChoice = new JPanel();
	averageChoice.setLayout(new FlowLayout());
	averageChoice.setBorder(BorderFactory.createTitledBorder("Average by ..."));
	// Create a button group to aggregate the buttons
	ButtonGroup averageButtons = new ButtonGroup();
	// Create the buttons
	String [] averageName = {"Age", "Salary"};
	int numNames = averageName.length;
	averageBy = new JRadioButton[numNames];

	for (int i=0 ; i<numNames ; i++) {
	    averageBy[i] = new JRadioButton(averageName[i]);
	    averageBy[i].addItemListener(this);
	    averageChoice.add(averageBy[i]);
	    averageButtons.add(averageBy[i]);
	}
	averageSelection = averageBy[0];
	averageSelection.setSelected(true);
	
	// Create a panel for the employee list
	JPanel employeeList = new JPanel();
	employeeList.setLayout(new BorderLayout());
	employeeList.setBorder(BorderFactory.createTitledBorder("Employees"));

	// Create the employee list, make it into a scroll pane, and
	// add it to the employee list panel
	list = new JList(employees.toArray());
	JScrollPane employeeChooser = new JScrollPane(list);
	employeeList.add(employeeChooser, BorderLayout.CENTER);

	// Create a text area to show the average
	avg = new JTextArea("");


	// Create an EXIT button
	JButton exitButton = new JButton("EXIT");
	exitButton.addActionListener(this);
	
	// Now put both the employee list and the average
	// into the top-level pane
	contentPane.add(employeeList, BorderLayout.CENTER);
	averageChoice.add(avg);
	//contentPane.add(avg,BorderLayout.SOUTH);
	contentPane.add(averageChoice, BorderLayout.NORTH);
	contentPane.add(exitButton, BorderLayout.SOUTH);

	// Monitor changes in the employee list selection
	list.addListSelectionListener(this);

	setVisible(true);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void valueChanged(ListSelectionEvent e) {
	displayAverage();
    }

    public void displayAverage() {
	if (list == null)
	    return;  // nothing to do!

	Object [] selectedEmployees = list.getSelectedValues();
	int len = selectedEmployees.length;
	if (len == 0) {
	    avg.setText("");
	    // avg.setBorder(null);
	    return;
	}

	if (averageSelection == averageBy[0]) {
	    DecimalFormat fmt = new DecimalFormat("#0.0");

	    int sum = 0;
	    for (int i=0 ; i<len ; i++) {
		Employee emp = (Employee)selectedEmployees[i];
		sum += emp.getAge();
	    }
	    avg.setText(fmt.format((double)sum/len));
	} else {
	    DecimalFormat fmt = new DecimalFormat("$#,##0.00");

	    double sum = 0;
	    for (int i=0 ; i<len ; i++) {
		Employee emp = (Employee)selectedEmployees[i];
		sum += emp.getSalary();
	    }
	    avg.setText(fmt.format(sum/len));
	}
	// avg.setBorder(BorderFactory.createLineBorder(Color.black));
    }

    public void itemStateChanged(ItemEvent e) {

	if (e.getStateChange() != ItemEvent.SELECTED)
	    return;

	averageSelection = (JRadioButton)e.getSource();
	displayAverage();
    }

    public void actionPerformed(ActionEvent e) {
	System.exit(0);
    }
}
