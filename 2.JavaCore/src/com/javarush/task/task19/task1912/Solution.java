package com.javarush.task.task19.task1912;

/* 
Ридер обертка 2
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        PrintStream consoleStream = System.out;

        ByteArrayOutputStream outStream = new ByteArrayOutputStream();

        PrintStream newStream = new PrintStream(outStream);

        System.setOut(newStream);

        testString.printSomething();

        String result = outStream.toString();

        System.setOut(consoleStream);

        StringBuilder sb = new StringBuilder(result);

        while (sb.toString().contains("te")) {
            sb.replace(sb.indexOf("te"), sb.indexOf("te")+2, "??");
        }

        System.out.println(sb.toString());
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
