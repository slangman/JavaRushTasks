package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        FileInputStream fileStream = new FileInputStream(file);
        int max = Integer.MIN_VALUE;
        while (fileStream.available() > 0) {
            int data = fileStream.read();
            if (data > max) {
                max = data;
            }
        }
        System.out.println(max);
        reader.close();
        fileStream.close();
    }
}
