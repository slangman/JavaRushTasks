package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        int errorIndex = 0;
        boolean trigger = false;
        for (int i = 0; i < 10; i++) {
            list.add(reader.readLine());
        }

        int i = 1;
        while (i < 10)
         {
            if (!(list.get(i).length() > list.get(i-1).length())) {
                errorIndex = i;
                trigger = true;
                break;
            }
            else {
                i++;
            }
        }

        if (trigger) {
            System.out.println(errorIndex);
        }
    }
}

