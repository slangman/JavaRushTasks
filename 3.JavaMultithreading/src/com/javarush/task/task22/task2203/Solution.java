package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null) {
            throw new TooShortStringException();
        }
        int tabCount = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == 9) {
                tabCount++;
            }
        }
        if (tabCount < 2) {
            throw new TooShortStringException();
        }
        String[] splitted = string.split("\\t");
        return splitted[1];
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
