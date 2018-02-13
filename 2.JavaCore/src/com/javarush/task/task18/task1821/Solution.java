package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream stream = new FileInputStream(args[0]);
        TreeMap<Character, Integer> map = new TreeMap<>();
        while (stream.available() > 0) {
            int buffer = stream.read();
            char c = (char) buffer;
            if (!map.containsKey(c)) {
                map.put(c, 1);
            }
            else {
                map.put(c, map.get(c) + 1);
            }
        }
        stream.close();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char c = entry.getKey();
            int i = entry.getValue();
            System.out.println(c + " " + i);
        }
        /*
        Map<Character, Integer> sortedMap = new TreeMap<>(map);
        for (Map.Entry<Character, Integer> entry : sortedMap.entrySet()) {
            char c = entry.getKey();
            int i = entry.getValue();
            System.out.println(c + " " + i);
        }
        */
    }
}
