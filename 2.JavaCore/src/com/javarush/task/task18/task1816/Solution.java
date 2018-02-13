package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[0]);
        int counter = 0;
        while (inputStream.available() > 0) {
            int buffer = inputStream.read();
            if ((65<=buffer && buffer<=92)||(97<=buffer && buffer<=122)) counter++;
        }
        System.out.println(counter);
        inputStream.close();
    }
}
