package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        BufferedReader fileReader = new BufferedReader(new FileReader("c:\\" + filename));
        ArrayList<Integer> array = new ArrayList<>();
        ArrayList<Integer> sorted = new ArrayList<>();
        String s;
        while ((s = fileReader.readLine()) != null) {
            array.add(Integer.parseInt(s));
        }
        reader.close();
        fileReader.close();
        for (Integer i: array) {
            if (i%2==0) {
                sorted.add(i);
            }
        }
        Collections.sort(sorted);
        for (Integer i : sorted) {
            System.out.println(i);
        }
    }
}
