package com.javarush.task.task15.task1517;

/* 
Статики и исключения
*/

public class Solution {
    public static int A = 0;

    static {
        int i = 5/A;
    }


    public static int B = 5;

    public static void main(String[] args) throws Exception {
        System.out.println(B);
    }
}
