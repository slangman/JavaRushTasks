package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[0]);
        int spaceCounter = 0;
        int symbolsCounter = inputStream.available();
        try {
            while (inputStream.available() > 0) {
                int buffer = inputStream.read();
                if (buffer == 32) spaceCounter++;
            }
        }
        catch (Exception e){};
        inputStream.close();
        double result = (double) spaceCounter/symbolsCounter*100;
        String formattedDouble = new DecimalFormat("#0.00").format(result);
        System.out.print(formattedDouble);
    }
}
