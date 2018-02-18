package com.javarush.task.task22.task2201;

/* 
Строки нитей или строковые нити? Вот в чем вопрос
*/
public class Solution {
    public static void main(String[] args) {
        new Solution();
    }

    public static final String FIRST_THREAD_NAME = "1#";
    public static final String SECOND_THREAD_NAME = "2#";

    private Thread thread1;
    private Thread thread2;
    private Thread thread3;

    public Solution() {
        initThreads();
    }

    protected void initThreads() {
        this.thread1 = new Thread(new Task(this, "A\tB\tC\tD\tE\tF\tG\tH\tI"), FIRST_THREAD_NAME);
        this.thread2 = new Thread(new Task(this, "J\tK\tL\tM\tN\tO\tP\tQ\tR\tS\tT\tU\tV\tW\tX\tY\tZ"), SECOND_THREAD_NAME);
        this.thread3 = new Thread(new Task(this, "\t\t"), "3#");

        Thread.setDefaultUncaughtExceptionHandler(new ThisUncaughtExceptionHandler());

        this.thread1.start();
        this.thread2.start();
        this.thread3.start();
    }

    public synchronized String getPartOfString(String string, String threadName) {
        int tabCounter = 0;
        int firstTabIndex = -1;
        int lastTabIndex = -1;
        for (int i=0; i < string.length(); i++) {
            if (string.charAt(i) == 9) {
                tabCounter++;
                if (firstTabIndex == -1) {
                    firstTabIndex = i;
                }
                lastTabIndex = i;
            }
        }
        if (string == null || tabCounter < 2) {
            if (threadName == FIRST_THREAD_NAME) {
                throw new TooShortStringFirstThreadException();
            } else if (threadName == SECOND_THREAD_NAME) {
                throw new TooShortStringSecondThreadException();
            } else {
                throw new RuntimeException();
            }
        }
        return string.substring(firstTabIndex+1, lastTabIndex);
    }
}
