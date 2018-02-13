package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Solution {
    private static boolean isDigit(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        FileReader fileReader = new FileReader(file1);
        FileWriter fileWriter = new FileWriter(file2);
        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();
        reader.close();
        sb.append("");
        result.append("");

        while (fileReader.ready()) {
            sb.append((char) fileReader.read());
        }
        String s = sb.toString();
        String[] elements = s.split(" ");
        for (String e : elements) {
            if (isDigit(e)) {
                result.append(e);
            }
        }
       fileWriter.write((sb.toString().trim()).toCharArray());

    }
}
