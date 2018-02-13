package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(args[1]));
        ArrayList<String> words = new ArrayList<>();
        ArrayList<String> resultWords = new ArrayList<>();
        String line;
        while ((line=fileReader.readLine())!=null) {
            String[] array = line.split(" ");
            for (String s : array) {
                words.add(s);
            }
        }
        fileReader.close();
        for (String s : words) {
            if (s.length()>6) {
                resultWords.add(s);
            }
        }
        String result = "";
        for (String s: resultWords) {
            result = result + s + ",";
        }
        result = result.substring(0, result.length()-1);
        fileWriter.write(result);
        fileWriter.close();
    }
}
