package com.javarush.task.task22.task2212;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {

        if (telNumber == null || telNumber.length() < 1) return false;

        //condition 6
        if (telNumber.matches("\\w")) return false;

        //check number of digits
        int numbers = 0;
        Pattern p = Pattern.compile("\\d");
        Matcher m = p.matcher(telNumber);
        while (m.find()) {
            numbers++;
        }

        //condition
        if (telNumber.matches("(^[\\(\\+\\d]).*(\\d)")) {
            if ((numbers == 12 && (telNumber.charAt(0)=='+')) || numbers == 10) {
                if (telNumber.matches(".*(\\(?\\d{3}\\)?)([\\d*]+-?[\\d*]+-?[\\d*]-?[\\d*])")) return true;
                else return false;
            }
            else return false;
        }
        else return false;
    }

    public static void main(String[] args) {
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader("c:\\1.txt"));
            String s;
            while ((s = fileReader.readLine()) != null) {
                System.out.println(s + " - " + checkTelNumber(s));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        catch (IOException e) {
            System.out.println("Input-output error!");
        }
    }
}
