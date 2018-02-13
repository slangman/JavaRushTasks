package com.javarush.task.task17.task1711;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat returnDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        switch (args[0]) {
            case "-c" :
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; ) {
                        String name = args[i];
                        String sex = args[i + 1];
                        Date bd = dateFormat.parse(args[i + 2]);
                        if (sex.equals("м")) allPeople.add(Person.createMale(name, bd));
                        else if (sex.equals("ж")) allPeople.add(Person.createFemale(name, bd));
                        System.out.println(allPeople.size() - 1);
                        i = i + 3;
                    }
                }
                break;
            case "-u":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; ) {
                        int id = Integer.parseInt(args[i]);
                        String name = args[i + 1];
                        String sex = args[i + 2];
                        Date bd = dateFormat.parse(args[i + 3]);
                        allPeople.get(id).setName(name);
                        if (sex.equals("м")) allPeople.get(id).setSex(Sex.MALE);
                        if (sex.equals("ж")) allPeople.get(id).setSex(Sex.FEMALE);
                        allPeople.get(id).setBirthDay(bd);
                        i = i + 4;
                    }
                }
                break;
            case "-d":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        int id = Integer.parseInt(args[i]);
                        allPeople.get(id).setName(null);
                        allPeople.get(id).setSex(null);
                        allPeople.get(id).setBirthDay(null);
                    }
                }
                break;
            case "-i":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        int id = Integer.parseInt(args[i]);
                        String name = allPeople.get(id).getName();
                        String sex;
                        if (allPeople.get(id).getSex().toString().equals("MALE")) sex = "м";
                        else sex = "ж";
                        String bd = returnDateFormat.format(allPeople.get(id).getBirthDay());
                        System.out.println(name + " " + sex + " " + bd);
                    }
                }
                break;
        }

    }
}
