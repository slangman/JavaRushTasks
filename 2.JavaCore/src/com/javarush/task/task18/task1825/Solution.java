package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        String line = reader.readLine();
        String dir = line.substring(0, line.lastIndexOf('\\')+1);
        String filename = (dir + line.substring (line.lastIndexOf('\\')+1, line.lastIndexOf('.')));
        File file = new File(filename);
        FileOutputStream outStream = new FileOutputStream(filename, true);
        while (true) {
            if (!line.equals("end")) {
                list.add(line);
                line = reader.readLine();
            }
            else break;
        }
        Collections.sort(list, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o1.toString().compareTo(o2.toString());
            }
        });

        for (String s : list) {
           FileInputStream inputStream = new FileInputStream(s);
           byte[] buf = new byte[inputStream.available()];
           while (inputStream.available() > 0) {
               int count = inputStream.read(buf);
               outStream.write(buf, 0, count);
           }
           inputStream.close();
        }
        outStream.close();

    }
}
