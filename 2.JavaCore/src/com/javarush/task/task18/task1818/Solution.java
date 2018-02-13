package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine(),
                file2 = reader.readLine(),
                file3 = reader.readLine();
        FileOutputStream fStream1 = new FileOutputStream(file1);
        FileInputStream fStream2 = new FileInputStream(file2);
        FileInputStream fStream3 = new FileInputStream(file3);

        while (fStream2.available() > 0) {
            int buffer = fStream2.read();
            fStream1.write(buffer);
        }

        while (fStream3.available() > 0) {
            int buffer = fStream3.read();
            fStream1.write(buffer);
        }
        fStream1.close();
        fStream2.close();
        fStream3.close();
    }
}
