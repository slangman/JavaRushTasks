package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        FileInputStream fileStream = new FileInputStream(file);
        ArrayList<Integer> bytes = new ArrayList<>();
        String result = "";
        while (fileStream.available() > 0) {
            int data = fileStream.read();
            if (!bytes.contains(data)) {
                bytes.add(data);
            }
        }
        Collections.sort(bytes);
        for (int i : bytes) {
            result += (bytes + " ");
        }
        result.trim();
        System.out.println(result);
        reader.close();
        fileStream.close();
    }
}
