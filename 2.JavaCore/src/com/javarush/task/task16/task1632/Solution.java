package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    public static class InfiniteThread extends Thread {
        public void run() {
            while (true) {}
        }
    }

    public static class ExceptionThread extends Thread {
        public void run() {
            try {
                throw new InterruptedException();
            }
            catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class Hurray extends Thread {
        public void run() {
            try {
                while (true) {
                    System.out.println("Ура");
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class MessageThread extends Thread implements Message {

        @Override
        public void showWarning() {
            return;
        }
    }

    public static class CountingThread extends Thread {
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                ArrayList<Integer> numbers = new ArrayList<>();
                while (true) {
                    String n = reader.readLine();
                    if (n.equals("N")) break;
                    numbers.add(Integer.parseInt(n));
                }
                Integer sum = 0;
                for (Integer num : numbers) {
                    sum = sum + num;
                }
                System.out.println(sum);
            }
            catch (IOException e) {

            }
        }
    }

    static {
        threads.add(new InfiniteThread());
        threads.add(new ExceptionThread());
        threads.add(new Hurray());
        threads.add(new MessageThread());
        threads.add(new CountingThread());
    }

    public static void main(String[] args) {
    }
}