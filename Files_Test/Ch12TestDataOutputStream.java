/*
    Introduction to OOP with Java 4th Ed, McGraw-Hill

    Wu/Otani

    Chapter 12 Sample Program: Illustrate the use of DataOutputStream

    File: Ch12TestDataOutputStream.java
*/

import java.io.*;

class Ch12TestDataOutputStream {
   public static void main (String[] args) throws IOException {

      //setup the streams
      File             outFile        = new File( "/Users/kbye10/Documents/CS 250 test files/sample2.data" );
      FileOutputStream outFileStream  = new FileOutputStream( outFile );
      DataOutputStream outDataStream  = new DataOutputStream( outFileStream );

      //write values of primitive data types to the stream
      outDataStream.writeInt(987654321);
      outDataStream.writeLong(11111111L);
      outDataStream.writeFloat(22222222F);
      outDataStream.writeDouble(3333333D);
      outDataStream.writeChar('A');
      outDataStream.writeBoolean(true);

      //output done, so close the stream
      outDataStream.close();
   }
}