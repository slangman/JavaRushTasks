package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        FileReader fileReader = new FileReader(file1);
        FileWriter fileWriter = new FileWriter(file2);
        int count = 1;
        while (fileReader.ready()) {
            int data = fileReader.read();
            if (count%2 == 0) {
                fileWriter.write(data);
            }
            count++;
        }
        reader.close();
        fileReader.close();
        fileWriter.close();
    }
}
