package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {

        if (args[0].equals("-e")) {
            encrypt(args[1], args[2]);
        }
        if (args[0].equals("-d")) {
            decrypt(args[1],args[2]);
        }

    }

    public static void encrypt(String fileName, String fileOutputName) throws IOException {
        FileInputStream inStream = new FileInputStream(fileName);
        FileOutputStream outStream = new FileOutputStream(fileOutputName);
        byte[] buffer = new byte[1];
        while (inStream.available() > 0) {
            int count = inStream.read(buffer);
            buffer[0] = (byte) (buffer[0]+1);
            outStream.write(buffer,0, count);
        }
        inStream.close();
        outStream.close();
    }

    public static void decrypt (String fileName, String FileOutputName) throws IOException {
        FileInputStream inStream = new FileInputStream(fileName);
        FileOutputStream outStream = new FileOutputStream(FileOutputName);
        byte[] buffer = new byte[1];
        while (inStream.available() > 0) {
            int count = inStream.read(buffer);
            buffer[0] = (byte) (buffer[0]-1);
            outStream.write(buffer,0, count);
        }
        inStream.close();
        outStream.close();
    }
}
