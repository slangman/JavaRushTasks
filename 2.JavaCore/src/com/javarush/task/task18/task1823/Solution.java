package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ReadThread readThread;
        while (true) {
            String line = reader.readLine();
            if (!line.equals("exit")) {
                readThread = new ReadThread(line);
                readThread.start();
                readThread.join();
            }
            else break;
        }
    }

    public static class ReadThread extends Thread {
        public ReadThread(String fileName) {
            this.fileName = fileName;
            //implement constructor body
        }

        String fileName;

        public void run() {
            Map<Integer, Integer> map = new HashMap<>();
            try {
                FileInputStream inStream = new FileInputStream(fileName);
                while (inStream.available() > 0) {
                    int data = inStream.read();
                    if (!map.containsKey(data)) {
                        map.put(data, 1);
                    } else {
                        map.put(data, map.get(data) + 1);
                    }
                }
                int maxValueInMap = (Collections.max(map.values()));
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    if (entry.getValue() == maxValueInMap) {
                        resultMap.put(fileName, entry.getKey());
                    }
                }
                inStream.close();
            } catch (Exception e) {
            }
        }
    }
}
   