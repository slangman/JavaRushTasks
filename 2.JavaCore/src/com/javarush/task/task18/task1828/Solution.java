package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        int id = Integer.parseInt(args[1]);
        String productName = args[2];
        String price = args[3];
        String quantity = args[4];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        if (args[0].equals("-u")) {
            updateId (fileName, id, productName, price, quantity);
        }

        if (args[0].equals("-d")) {
            deleteId (fileName, id);
        }

    }

    public static void updateId (String fileName, int id, String productName, String price, String quantity)
            throws FileNotFoundException, IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        ArrayList<String> list = new ArrayList<>();
        String line;
        while ((line = fileReader.readLine())!=null) {
            list.add(line);
        }
        for (String s : list) {
            int i = Integer.parseInt(s.substring(0, s.indexOf(' ')));
            if (i==id) {
                s = String.format("%-8.8s%-30.30s%-8.8s%-4.4s", Integer.toString(id), productName, price, quantity);
            }
        }
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName, true));
        for (String s : list) {
            fileWriter.write(s);
            fileWriter.newLine();
        }
    }

    public static void deleteId (String fileName, int id) throws FileNotFoundException, IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        ArrayList<String> list = new ArrayList<>();
        String line;
        while ((line = fileReader.readLine())!=null) {
            list.add(line);
        }
        for (String s : list) {
            int i = Integer.parseInt(s.substring(0, s.indexOf(' ')));
            if (i==id) {
                list.remove(s);
            }
        }
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName, true));
        for (String s : list) {
            fileWriter.write(s);
            fileWriter.newLine();
        }
    }
}
