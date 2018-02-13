package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static Date parseDate (String argDate) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.parse(argDate);
    }

    public static void addPerson(String name, String sex, String bd1) throws ParseException {
        Date bd = parseDate(bd1);
        if (sex == "м") {
            allPeople.add(Person.createMale(name, bd));
        }
        else if (sex == "ж") {
            allPeople.add(Person.createFemale(name, bd));
        }
        System.out.println(allPeople.size()-1);
    }

    public static void updatePerson (String id1, String name, String sex, String bd1) throws ParseException {
        int id = Integer.parseInt(id1);
        Date bd = parseDate(bd1);
        allPeople.get(id).setName(name);
        if (sex == "м") {
            allPeople.get(id).setSex(Sex.MALE);
        }
        else if (sex == "ж") {
            allPeople.get(id).setSex(Sex.FEMALE);
        }
        allPeople.get(id).setBirthDay(bd);
    }

    public static void deletePerson (String id1) {
        int id = Integer.parseInt(id1);
        allPeople.get(id).setName(null);
        allPeople.get(id).setSex(null);
        allPeople.get(id).setBirthDay(null);
    }

    public static void viewPerson (String id1) {
        int id = Integer.parseInt(id1);
        String name = allPeople.get(id).getName();
        String sex = "м";
        if (allPeople.get(id).getSex() == Sex.FEMALE) {
            sex = "ж";
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        String bd = dateFormat.format(allPeople.get(id).getBirthDay());
        System.out.println(name + " " + sex + " " + bd);
    }

    public static void main(String[] args) throws ParseException {
        switch (args[0]) {
            //addPerson
            case "-c": addPerson(args[1], args[2], args[3]);
                break;
            //updatePerson
            case "-u": updatePerson(args[1], args[2], args[3], args[4]);
                break;
            //deletePerson
            case "-d": deletePerson(args[1]);
                break;
            //viewPerson
            case "-i": viewPerson(args[1]);
            default: break;
        }
    }
}
