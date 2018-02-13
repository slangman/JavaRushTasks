package com.javarush.task.task06.task0605;


import java.io.*;

/* 
Контролируем массу тела
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
        double weight = Double.parseDouble(bis.readLine());
        double height = Double.parseDouble(bis.readLine());

        Body.massIndex(weight, height);
    }

    public static class Body {
        public static void massIndex(double weight, double height) {
            double index = weight/(height*height);
            String result;
            if (index < 18.5) {
                result = "Недовес: меньше чем 18.5";
            }
            else if ((18.5 <= index) && (index <= 24.9)) {
                result = "Нормальный: между 18.5 и 24.9";
            }
            else if ((25.0 <= index) && (index <= 29.9)) {
                result = "Избыточный вес: между 25 и 29.9";
            }
            else {
                result = "Ожирение: 30 или больше";
            }
            System.out.println(result);
        }
    }
}
