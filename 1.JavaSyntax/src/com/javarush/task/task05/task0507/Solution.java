package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        String string;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int i;
        ArrayList<Integer> list = new ArrayList<>();
        while ((i = Integer.parseInt(reader.readLine())) != -1) {
            list.add(i);
        }
        float sum = 0;
        for (Integer j : list) {
            sum = sum + j;
        }
        float result = sum/list.size();
        System.out.println(result);



    }
}

