package com.javarush.task.task15.task1518;

/* 
Статики и котики
*/

public class Solution {

    static {
        Cat cat = new Cat();
        cat.name = "alex";
        System.out.println(cat.name);
    }

    public static class Cat {
        public String name;
    }

    public static void main(String[] args) {

    }
}
