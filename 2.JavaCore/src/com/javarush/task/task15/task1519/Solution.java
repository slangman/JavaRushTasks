package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while (!(s = reader.readLine()).equals("exit")) {
            if (s.contains(".")) {
                try {
                    double d = Double.parseDouble(s);
                    print(d);
                }
                catch (NumberFormatException e) {
                    print(s);
                }
            }
            else {
                try {
                    int i = Integer.parseInt(s);
                    if (0 < i && i < 128) {
                        print ((short) i);
                    }
                    if (i <= 0 || i >= 128) {
                        print(i);
                    }
                }
                catch (NumberFormatException e) {
                    print(s);
                }
            }
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
