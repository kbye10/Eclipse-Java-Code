/*
    Introduction to OOP with Java 4th Ed, McGraw-Hill

    Wu/Otani

    Chapter 12 Sample Program: Illustrate the use of DataOutputStream

    File: Ch12TestDataInputStream.java
*/

import java.io.*;

class Ch12TestDataInputStream {
   public static void main (String[] args) throws IOException {

      //setup file and stream
      File            inFile       = new File("/Users/kbye10/Documents/CS 250 test files/sample2.data");
      FileInputStream inFileStream = new FileInputStream(inFile);
      DataInputStream inDataStream = new DataInputStream(inFileStream);

      //read values back from the stream and display them
      System.out.println(inDataStream.readInt());
      System.out.println(inDataStream.readLong());
      System.out.println(inDataStream.readFloat());
      System.out.println(inDataStream.readDouble());
      System.out.println(inDataStream.readChar());
      System.out.println(inDataStream.readBoolean());

      //input done, so close the stream
      inDataStream.close();
   }
}