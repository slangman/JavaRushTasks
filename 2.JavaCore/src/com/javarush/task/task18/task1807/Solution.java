package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        FileInputStream fileStream = new FileInputStream(file);
        int counter = 0;
        while (fileStream.available() > 0) {
            char b = (char) fileStream.read();
            if (b == 44) {
                counter++;
            }
        }
        System.out.println(counter);
        reader.close();
        fileStream.close();
    }
}
