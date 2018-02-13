package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        FileInputStream inStream = new FileInputStream(file);
        HashMap<Integer, Integer> map = new HashMap<>();
        while (inStream.available() > 0) {
            int data = inStream.read();
            if (map.containsKey(data)) {
                map.put(data, map.get(data)+1);
            }
            else {
                map.put(data, 1);
            }
        }
        ArrayList<Integer> maxBytes = new ArrayList<>();
        int maxbyte = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxbyte) {
                maxbyte = entry.getValue();
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxbyte) {
                maxBytes.add(entry.getKey());
            }
        }
        String s = "";
        for (int i : maxBytes) {
            s = s + i + " ";
        }
        s.trim();
        System.out.println(s);
        reader.close();
        inStream.close();

    }
}
