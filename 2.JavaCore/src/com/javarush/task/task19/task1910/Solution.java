package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        BufferedReader fileReader = new BufferedReader(new FileReader(file1));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file2));
        reader.close();
        String source;
        while ((source = fileReader.readLine())!=null) {
            System.out.println(source);
            String result = source.replaceAll("\\p{Punct}|\\n", "");
            System.out.println(result);
            fileWriter.write(result);
            fileWriter.newLine();
        }
        fileReader.close();
        fileWriter.close();
    }
}
