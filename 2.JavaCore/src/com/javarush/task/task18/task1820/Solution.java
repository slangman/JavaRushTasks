package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(file1));
        FileWriter writer = new FileWriter(file2);
        String s = fileReader.readLine();
        String values[] = s.split(" ");
        ArrayList<Double> doubleValues = new ArrayList<>();
        for (String value : values) {
            double d = Double.parseDouble(value);
            doubleValues.add(d);
        }
        for (double d : doubleValues) {
            Integer result = (int) Math.round(d);
            String str = result.toString();
            writer.write(str);
            writer.write(" ");
        }
        fileReader.close();
        writer.close();
    }
}