package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream newStream = new PrintStream(outputStream);
        System.setOut(newStream);
        testString.printSomething();
        String result = outputStream.toString();
        System.setOut(consoleStream);

        String[] s = result.split(" ");
        String operator = s[1];
        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[2]);
        int c = 0;
        if (operator.equals("+")) {
            c = a+b;
        }
        else if (operator.equals("-")) {
            c = a-b;
        }
        else if (operator.equals("*")) {
            c = a*b;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(result);
        sb.append(c);
        String result1 = sb.toString();
        System.out.print(result1.replace("\r\n", ""));
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

