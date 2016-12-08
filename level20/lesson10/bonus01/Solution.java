package com.javarush.test.level20.lesson10.bonus01;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;


/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution {
    private static List<Integer> replica = new ArrayList<>();

    public static void main(String[]args) {
        long start = System.currentTimeMillis();
        int[] array = getNumbers(99999999);
        long end = System.currentTimeMillis() - start;
        long memore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        SimpleDateFormat sdf = new SimpleDateFormat("ss.SSS");
        System.out.println("Time = " + sdf.format(new Date(end)));
        System.out.println("Memory = " + memore / 1048576);

        Set<Integer> armstrongNumbers = new TreeSet<Integer>(Arrays.stream(array).boxed().collect(Collectors.toSet()));
        for (int a : armstrongNumbers) {
            if (a != 0)
                System.out.print(a + " ");
        }
    }

    public static int[] getNumbers(int N) {
        for (int i = 0; i <= N; i++)
        {
            if (isNumberUnique(i)) {
                int sumOfPowers = sum(i);
                if (isArmstrongNumber(sumOfPowers)) {
                    replica.add(sumOfPowers);
                }
            }
        }

        int[] result = new int[replica.size()];
        for (int i = 0; i < replica.size(); i++) {
            result[i] = replica.get(i);
        }

        return result;
    }

    private static boolean isArmstrongNumber(int number) {
        if (sum(number) == number) {
            return true;
        }

        return false;
    }

    private static boolean isNumberUnique(int number) {
        int lastDigit = 0;
        int currentDigit;

        while (number > 0) {
            currentDigit = number % 10;
            if (lastDigit > currentDigit) {
                return false;
            }
            lastDigit = currentDigit;
            number /= 10;
        }

        return true;
    }

    public static int sum(int a) {
        int addition = 0;
        int d = ("" + a).length();
        int b = a % 10;
        while (a >= 1) {
            addition += Math.pow(b, d);
            a /= 10;
            b = a % 10;
        }

        return addition;
    }
}

