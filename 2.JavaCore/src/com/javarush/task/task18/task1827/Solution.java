package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;

public class Solution {
    //метод для поиска последней строки
    private static String readLastLine(File file) throws FileNotFoundException, IOException {
        String result = null;
        try (RandomAccessFile raf = new RandomAccessFile(file, "r")) {
            long startIdx = file.length();
            while (startIdx >= 0 && (result == null || result.length() == 0)) {
                raf.seek(startIdx);
                if (startIdx > 0)
                    raf.readLine();
                result = raf.readLine();
                startIdx--;
            }
            raf.close();
        }
        return result;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        File file = new File(fileName);
        if (args[0].equals("-c")) {
            //найти последнюю строку
            String laststring = readLastLine(file);
            //выделить id
            int idMax = Integer.parseInt(laststring.substring(0, laststring.indexOf(' ')));
            //System.out.println(laststring);
            //System.out.println(idMax);
            //увеличить id на 1
            int id = idMax + 1;
            //System.out.println(id);
            String productName = args[1];
            String price = args[2];
            String quantity = args[3];
            //String item = (id + " " + productName + " " + price + " " + quantity);
            String item = String.format("%-8.8s%-30.30s%-8.8s%-4.4s", Integer.toString(id), productName, price, quantity);
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName, true));
            fileWriter.newLine();
            fileWriter.write(item);
            fileWriter.close();
            //System.out.println(readLastLine(file));
        }
    }
    }

