package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        String line;
        while ((line = fileReader.readLine()) != null) {
            String name = line.replaceAll("\\ \\d+", "");
            String num = line.replaceAll("\\D+\\ ", "");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH);
            Date date = null;
            date = simpleDateFormat.parse(num);
            PEOPLE.add(new Person(name, date));
        }
        fileReader.close();
        for(Person p : PEOPLE) {
            System.out.println(p.getName());
            System.out.println(p.getBirthday());
        }
    }
}
