package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        PrintStream newStream = new PrintStream(outStream);
        System.setOut(newStream);
        testString.printSomething();
        String result = outStream.toString();
        System.setOut(consoleStream);
        FileOutputStream fileStream = new FileOutputStream(file);
        byte[] buffer = result.getBytes();
        fileStream.write(buffer);
        System.out.println(result);
        fileStream.close();

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

