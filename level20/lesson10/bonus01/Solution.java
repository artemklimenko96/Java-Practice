package com.javarush.test.level20.lesson10.bonus01;

import java.util.ArrayList;
import java.util.Collections;

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
    public static int[] getNumbers(int N) {
        ArrayList<Integer> unsortedData = new ArrayList<>();
        for (int i = N-1; i > 0 ; i--)
        {
            int number = i;
            ArrayList<Integer> digits = new ArrayList<>();
            for(int a=number; a>0; a/=10){
                digits.add(a%10);
            }
            int m = digits.size();
            int comparable = 0;
            for (int j = 0; j <digits.size() ; j++)
            {
                int powered =  (int)Math.pow(digits.get(j),m);
                comparable +=powered;
            }
            if(comparable == number){
                unsortedData.add(number);
            }


        }
        Collections.sort(unsortedData);
        int[] result = new int[unsortedData.size()];

        for (int i = 0; i < unsortedData.size(); i++) {
            result[i] = unsortedData.get(i);
        }

        return result;
    }
}