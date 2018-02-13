package com.javarush.task.task09.task0926;

import java.util.ArrayList;
import java.util.Random;

/* 
Список из массивов чисел
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        ArrayList<int[]> list = new ArrayList<>();
        int[] numbers = {5, 2, 4, 7, 0};
        for (int i = 0; i < numbers.length; i++) {
            int[] array = new int[numbers[i]];
            for (int j = 0; j < array.length; j++) {
                array[j] = new Random().nextInt(1488);
            }
            list.add(array);
        }
        return list;
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}
