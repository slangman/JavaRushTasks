package com.javarush.task.task06.task0606;

import java.io.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        char[] array = string.toCharArray();
        for (int i = 0; i < array.length; i++) {
            int num = Character.getNumericValue(array[i]);
            if (num%2==0) {
                even++;
            }
            else {
                odd++;
            }
        }
        System.out.println("Even: " + even + " Odd: " + odd);


    }
}
