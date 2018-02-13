package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();
        FileInputStream fileStream = new FileInputStream(file1);
        FileOutputStream fileStream2 = new FileOutputStream(file2);
        FileOutputStream fileStream3 = new FileOutputStream(file3);
        long bytes = 0;
        while (fileStream.available() > 0) {
            int data = fileStream.read();
            bytes++;
        }

        while (fileStream.available() > 0) {
            while (fileStream.available() > bytes/2) {
                int data = fileStream.read();
                fileStream2.write(data);
            }
            int data = fileStream.read();
            fileStream3.write(data);
        }
        reader.close();
        fileStream.close();
        fileStream2.close();
        fileStream3.close();


    }
}
