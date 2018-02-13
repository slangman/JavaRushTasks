package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main (String[] args) throws IOException {

        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        String line;
        Map<String, Double> map = new TreeMap<>();
        while ((line = fileReader.readLine()) != null) {
            String[] splitted = line.split(" ");
            String name = splitted[0];
            Double num = Double.parseDouble(splitted[1]);
            if (map.containsKey(name)) {
                map.put(name, map.get(name) + num);
            }
            else {
                map.put(name, num);
            }
        }
        fileReader.close();
        double maxValue = 0;
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            Double value = entry.getValue();
            if (value > maxValue) {
                maxValue = value;
            }
        }
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            String key = entry.getKey();
            Double value = entry.getValue();
            if (value == maxValue) {
                System.out.println(key);
            }
        }


    }
}
