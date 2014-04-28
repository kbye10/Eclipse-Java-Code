/*
    Introduction to OOP with Java 4th Ed, McGraw-Hill

    Wu/Otani

    Chapter 12 Sample Program: Illustrate the use of FileInputStream.

    File: Ch12TestFileInputStream.java
*/

import java.io.*;

class Ch12TestFileInputStream {
   public static void main (String[] args) throws IOException {

      //setup file and stream
      File inFile = new File("/Users/kbye10/Documents/CS 250 test files/sample1.data");
      FileInputStream inStream = new FileInputStream(inFile);

      //set up an array to read data in
      int    fileSize  = (int)inFile.length();
      byte[] byteArray = new byte[fileSize];

      //read data in and display them
      inStream.read(byteArray);
      for (int i = 0; i < fileSize; i++) {
         System.out.println(byteArray[i]);
      }

      inStream.close();
   }
}