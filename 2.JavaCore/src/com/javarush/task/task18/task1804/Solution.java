package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> minBytes = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        String file = reader.readLine();
        FileInputStream fileStream = new FileInputStream(file);
        int min = Integer.MAX_VALUE;
        String result = "";
        while (fileStream.available() > 0) {
            int data = fileStream.read();
            if (map.containsKey(data)) {
                map.put(data, map.get(data)+1);
            }
            else {
                map.put(data, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() < min) {
                    min = entry.getValue();
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == min) {
                minBytes.add(entry.getKey());
            }
        }
        for (int i : minBytes) {
            result += (i + " ");
        }
        result.trim();
        reader.close();
        fileStream.close();
    }
}
