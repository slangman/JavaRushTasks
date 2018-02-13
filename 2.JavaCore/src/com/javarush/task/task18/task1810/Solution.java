package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String fileName = reader.readLine();
            FileInputStream fileStream = new FileInputStream(fileName);
            if (fileStream.available() < 1000) {
                fileStream.close();
                reader.close();
                throw new DownloadException();
            }
            fileStream.close();
        }
    }

    public static class DownloadException extends Exception {

    }
}
