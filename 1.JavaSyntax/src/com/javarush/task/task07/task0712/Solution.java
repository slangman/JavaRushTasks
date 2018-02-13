package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(reader.readLine());
        }
        int minIndex = 0,
            maxIndex = 0,
            minLength = Integer.MAX_VALUE,
            maxLength = 0;
        for ( int i = 0; i < list.size(); i++ ) {
            if ( list.get(i).length() < minLength ) {
                minLength = list.get(i).length();
                minIndex = i;
            }
            if (list.get(i).length() > maxLength ) {
                maxLength = list.get(i).length();
                maxIndex = i;
            }
        }
        if (minIndex < maxIndex) {
            System.out.println(list.get(minIndex));
        }
        else {
            System.out.println(list.get(maxIndex));
        }
    }
}
