package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();
        FileReader fileReader = new FileReader(file);
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        sb.append("");
        while(fileReader.ready()) {
            sb.append((char) fileReader.read());
        }
        String[] words = sb.toString().split("\\W");
        for (String word : words) {
            if (word.equals("words")) {
                counter++;
            }
        }
        System.out.println(counter);
        fileReader.close();
    }
}
