package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Lenin", 1000);
        map.put("Stalin", 2000);
        map.put("Hrushev", 5000);
        map.put("Brezhnev", 500);
        map.put("Andropov", 900);
        map.put("Gorbachev", 800);
        map.put("Yeltzin", 400);
        map.put("Putin", 300);
        map.put("Medvedev", 350);
        map.put("Nazarbayev", 100);

        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        for (Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator(); iterator.hasNext(); ) {
            Map.Entry<String, Integer> pair = iterator.next();
            Integer value = pair.getValue();
            if (value < 500) {
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = createMap();
        removeItemFromMap(map);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + " " + value);

        }
    }
}