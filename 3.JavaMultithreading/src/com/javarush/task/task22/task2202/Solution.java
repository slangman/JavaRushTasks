package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
            if (string == null) {
                throw new TooShortStringException();
            }
            int spaceCounter = 0;
            int beginIndex = 0;
            int endIndex = 0;
            for (int i = 0; i < string.length(); i++) {
                if (string.charAt(i) == 32) {
                    spaceCounter++;
                    if (spaceCounter == 1 && beginIndex == 0) {
                        beginIndex = i+1;
                    }
                    if (spaceCounter == 5 && endIndex == 0) {
                        endIndex = i;
                    }
                }
            }
            if (spaceCounter == 4) {
                endIndex = string.length();
            }
            if (spaceCounter < 4) {
                    throw new TooShortStringException();
            }

            return string.substring(beginIndex, endIndex);
    }

    public static class TooShortStringException extends RuntimeException {
        public TooShortStringException() {
        }
    }
}
