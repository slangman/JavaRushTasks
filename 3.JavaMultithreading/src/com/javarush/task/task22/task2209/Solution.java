package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        BufferedReader fileReader = new BufferedReader(new FileReader(file));
        StringBuilder sb = new StringBuilder();
        String s;
        while ((s = fileReader.readLine()) != null) {
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(s);
        }
        String[] source = sb.toString().split("\\s+");
        StringBuilder result = getLine(source);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {

        StringBuilder sb = new StringBuilder("");

        if (words == null || words.length == 0) {
            return sb;
        }

        sb.append(words[0]);
        words[0] = "";

        if (words.length == 1) {
            return sb;
        }

        while (true) {
            int addedCount = 0;
            for (int i = 0; i < words.length; i++) {
                if (words[i].length() > 0) {
                    if ((Character.toUpperCase(words[i].charAt(0))) ==
                            (Character.toUpperCase(sb.toString().charAt(sb.toString().length() - 1)))) {
                        sb.append(" " + words[i]);
                        words[i] = "";
                        addedCount++;
                    }
                    else if ((Character.toUpperCase(words[i].charAt(words[i].length() - 1))) ==
                            (Character.toUpperCase(sb.toString().charAt(0)))) {
                        sb.insert(0, words[i] + " ");
                        words[i] = "";
                        addedCount++;
                    }
                }
            }
            if (addedCount == 0) {
                break;
            }
        }

        for (String word : words) {
            if (word.length() > 0) {
                sb.append(" " + word);
            }
        }

        return sb;

        //Много кода, жалко удалять
        /*
        HashMap<Character, Integer> map = new HashMap<>();
         for (String word : words) {
             char firstLetter = word.toLowerCase().charAt(0);
             char lastLetter = word.toLowerCase().charAt(word.length()-1);
             if (map.containsKey(firstLetter)) {
                 map.put(firstLetter, map.get(firstLetter)+1);
             } else {
                 map.put(firstLetter, 1);
             }
             if (map.containsKey(lastLetter)) {
                 map.put(lastLetter, map.get(lastLetter)+1);
             } else {
                 map.put(lastLetter, 1);
             }
         }
        ArrayList<Character> unpairedChars = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();
            if (value%2 != 0) {
                unpairedChars.add(key);
            }
        }
        if (unpairedChars.size() == 2) {
            String firstWord = "";
            String lastWord = "";
            for (char c : unpairedChars) {
                for (String word : words) {
                    if (c == word.charAt(0)) {
                        firstWord = word;
                    }
                    if (c == word.charAt(word.length()-1)) {
                        lastWord = word;
                    }

                }
            }
            System.out.println(firstWord);
            System.out.println(lastWord);
        }
        return null;
        */
    }
}
