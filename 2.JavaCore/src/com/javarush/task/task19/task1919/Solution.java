package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        String line;
        ArrayList<String> list= new ArrayList<>();
        Map<String, Double> map = new HashMap<>();
        while ((line = fileReader.readLine()) != null) {
            list.add(line);
        }
        fileReader.close();
        for (String s : list) {
            String[] splitted = s.split(" ");
            String name = splitted[0];
            double num = Double.parseDouble(splitted[1]);
            if (map.containsKey(name)) {
                map.put(name, map.get(name)+num);
            }
            else map.put(name, num);
        }

        Map <String, Double> sortedMap = new TreeMap<String, Double>(String.CASE_INSENSITIVE_ORDER);
        sortedMap.putAll(map);

        for (Map.Entry <String, Double> entry : sortedMap.entrySet()) {
            String key = entry.getKey();
            Double value = entry.getValue();
            System.out.println(key + " " + value);
        }

    }
}
