/*
    Introduction to OOP with Java 4th Ed, McGraw-Hill

    Wu/Otani

    Chapter 12 Sample Program: Illustrate the use FileOutpuStream.

    File: Ch12TestFileOutputStream.java
*/

import java.io.*;

class Ch12TestFileOutputStream {

   public static void main (String[] args) throws IOException {
      //setup file and stream
      File             outFile   = new File( "/Users/kbye10/Documents/CS 250 test files/sample1.data" );
      FileOutputStream outStream = new FileOutputStream( outFile );

      //data to output
      byte byteArray[] = {10, 20, 30, 40, 50, 60, 70, 80};

      //write data to the stream
      outStream.write(byteArray);

      //output done, so close the stream
      outStream.close();
   }
}