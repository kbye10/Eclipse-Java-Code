import java.io.*;
import javax.swing.*;

class TextInAndOut {

    public static void main (String [] args) throws IOException {
        
        // open file output stream
        File outFile = new File("data");
        FileOutputStream outStream = new FileOutputStream(outFile);
        PrintWriter pWriter = new PrintWriter(outStream);

        // write an int, boolean, double
        pWriter.println("44");
        pWriter.println("true");
        pWriter.println("7.2");
 
        pWriter.close();

        // open file input stream
        File inFile = new File("data");
        FileReader fileReader = new FileReader(inFile);
        BufferedReader buffReader= new BufferedReader(fileReader);

        // read an int, boolean, double
        String in = buffReader.readLine();  
        int n = Integer.parseInt(in);
        String bool = buffReader.readLine(); 
        boolean b = Boolean.parseBoolean(bool);
        String doub = buffReader.readLine();
        double d = Double.parseDouble(doub);

        buffReader.close();

        // what did we get?
        System.out.println("n = " + n);
        System.out.println("b = " + b);
        System.out.println("d = " + d);

        //can we add n to d?
        System.out.println("n + d = " + (n+d));

    }

}
