package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            list.add(Integer.parseInt(reader.readLine()));
        }
        int max = 1; //Здесь храним максимальную длину последовательности
        int j = 1; //Счётчик последовательности.
        for (int i = 0; i < list.size()-1; i++) {
            if (list.get(i) == list.get(i+1)) {
               j++;
               if (j > max) {
                   max = j;
               }
            }
            else {
                j = 1; //Если последовательность заканчивается, возвращаем счетчику значение 1.
            }
        }
        System.out.println(max);

    }
}