package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileReader = new BufferedReader (new FileReader(args[0]));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(args[1]));
        ArrayList<String> allWords = new ArrayList<>();
        ArrayList<String> wordsWithNumbers = new ArrayList<>();
        String line;
        while ((line = fileReader.readLine()) != null) {
            String[] array = line.split(" ");
            for (String s : array) {
                allWords.add(s);
            }
        }
        fileReader.close();
        for (String s : allWords) {
            if ((s.matches(".*\\d+.*"))
                /*or ((\w+\d+\w+)|(\d+\w+))*/
                ) {
                wordsWithNumbers.add(s);
            }
        }
        String result = "";
        for (String s : wordsWithNumbers) {
            result = result + s + " ";
        }
        result = result.trim();
        fileWriter.write(result);
        fileWriter.close();
    }
}
