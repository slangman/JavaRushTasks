package com.javarush.task.task19.task1911;

/* 
Ридер обертка
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        PrintStream consoleSream = System.out;

        ByteArrayOutputStream outStream = new ByteArrayOutputStream();

        PrintStream newStream = new PrintStream(outStream);

        System.setOut(newStream);

       testString.printSomething();

       String result = outStream.toString();

       System.setOut(consoleSream);

        System.out.println(result.toUpperCase());

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
