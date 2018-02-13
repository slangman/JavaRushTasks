package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fName1 = reader.readLine();
        String fName2 = reader.readLine();

        BufferedReader fileReader1 = new BufferedReader (new FileReader(fName1));
        String line1;
        while ((line1 = fileReader1.readLine())!=null) {
            allLines.add(line1);
        }

        BufferedReader fileReader2 = new BufferedReader (new FileReader(fName2));
        String line2;
        while ((line2 = fileReader2.readLine())!=null) {
            forRemoveLines.add(line2);
        }

        new Solution().joinData();

    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        }
        else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
