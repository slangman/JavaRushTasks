package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));

        while (true) {
            String string = reader.readLine();
            if (!string.equals("exit")) {
                writer.write(string);
                writer.newLine();
            }
            else {
                writer.write(string);
                break;
            }
        }
        reader.close();
        writer.close();

    }
}
