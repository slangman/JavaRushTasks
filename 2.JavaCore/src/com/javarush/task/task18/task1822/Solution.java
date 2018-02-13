package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        BufferedReader fileReader = new BufferedReader(new FileReader(file));
        String id = args[0];
        String s;
        while((s = fileReader.readLine())!=null) {
            String[] array = s.split(" ");
            if (array[0].equals(id)) {
                System.out.println(s);
            }
        }
        reader.close();
        fileReader.close();

    }
}
