package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();

        FileInputStream fileStream1 = new FileInputStream(file1);
        FileOutputStream fileStream2 = new FileOutputStream(file2);

        byte[] buffer = new byte[fileStream1.available()];
        byte[] buffer2 = new byte[fileStream1.available()];

        int count = fileStream1.read(buffer);
        for (int i = buffer.length - 1; i > - 1; i--) {
            buffer2[(buffer2.length - 1) - i] = buffer[i];
        }
        fileStream2.write(buffer2, 0, count);

        reader.close();
        fileStream1.close();
        fileStream2.close();
    }
}
