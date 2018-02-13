package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Алгоритмы-числа
*/

/*
Add a new comment
 */

/*
Add a new comment 1
 */

/*
Add a new comment 1
 */


public class Solution {
    public static long[] getNumbers(long N) {
        long[] result = null;
        List<Long> listResult;
        ArmstrongNumbersMultiSetLong.maxValue = N;
        listResult = ArmstrongNumbersMultiSetLong.generate(19);

        //Работает, но будет работать до наступления тепловой смерти вселенной
        /*
        for (long S = 0; S < N; S++) {
            //break long into digits array
            String[] nums1 = Long.toString(S).split("");
            byte[] array = new byte[nums1.length];
            for (int i = 0; i < array.length; i++) {
                array[i] = Byte.parseByte(nums1[i]);
            }

            //number of digits in long
            byte m = (byte) array.length;

            long C = 0L;
            for (byte a : array) {
                long B = (long) Math.pow((double)a, (double)m);
                C = C+B;
            }

            if (S == C) {
                System.out.println(S);
            }
        }
        */
        result = new long[listResult.size()];
        int j = 0;
        for (long l : listResult) {
            result[j] = l;
            j++;
        }
        return result;
    }

    public static void main(String[] args) {
        getNumbers(9999999999L);
        System.out.println("ololo");
    }
}

class ArmstrongNumbersMultiSetLong {
    private static long cntSearch;
    private static int N;
    private static int[] digitsMultiSet;

    private static List<Long> results;
    private static long maxPow;
    private static long minPow;

    public static long maxValue;

    private static long[][] pows;

    private static void genPows(int N) {
        if (N > 20) throw new IllegalArgumentException();
        pows = new long[10][N + 1];
        for (int i = 0; i < pows.length; i++) {
            long p = 1;
            for (int j = 0; j < pows[i].length; j++) {
                pows[i][j] = p;
                p *= i;
            }
        }
    }

    private static boolean check(long pow) {
        cntSearch++;
        if (pow >= maxValue) return false;
        if (pow >= maxPow) return false;
        if (pow < minPow) return false;

        int[] testMultiSet = new int[10];

        while (pow > 0) {
            int i = (int) (pow % 10);
            testMultiSet[i]++;
            pow = pow / 10;
        }

        for (int i = 0; i < 10; i++) {
            if (testMultiSet[i] != digitsMultiSet[i]) return false;
        }

        return true;
    }

    private static void search(int digit, int unused, long pow) {
        if (digit == 10) {
            if (check(pow)) results.add(pow);
            return;
        }

        if (digit == 9) {
            digitsMultiSet[digit] = unused;
            search(digit + 1, 0, pow + unused * pows[digit][N]);
        } else {
            for (int i = 0; i <= unused; i++) {
                digitsMultiSet[digit] = i;
                search(digit + 1, unused - i, pow + i * pows[digit][N]);
            }
        }
    }

    public static List<Long> generate(int maxN) {
        if (maxN >= 20) throw new IllegalArgumentException();

        genPows(maxN);
        results = new ArrayList<>();
        digitsMultiSet = new int[10];
        cntSearch = 0;

        for (N = 1; N <= maxN; N++) {
            minPow = (long) Math.pow(10, N - 1);
            maxPow = (long) Math.pow(10, N);

            search(0, N, 0);
        }

        // System.out.println(cntSearch); // here we print the number of cases calculated

        Collections.sort(results);

        return results;
    }
}
