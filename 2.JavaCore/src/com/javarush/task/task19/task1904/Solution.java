package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner scanner;

        public PersonScannerAdapter (Scanner scanner) {
            this.scanner = scanner;
        }

        @Override
        public Person read() throws IOException {
            String[] s = scanner.nextLine().split(" ");
            DateFormat df = new SimpleDateFormat("ddmmyyyy");
            Date bd = null;
            try {
                bd = df.parse("" + s[3] + s[4] + s[5]);
            }
            catch (ParseException e) {}
            return new Person(s[1], s[2], s[0], bd);
        }

        @Override
        public void close() throws IOException {
            scanner.close();
        }
    }
}
