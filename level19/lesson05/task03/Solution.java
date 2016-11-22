package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            BufferedReader bufferedReader1 = new BufferedReader(new FileReader(bufferedReader.readLine()));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(bufferedReader.readLine(), true));
            StringBuilder strBuilder = new StringBuilder();

            while (bufferedReader1.ready()) {
                String[] splitted = bufferedReader1.readLine().trim().split(" ");
                boolean isFirstFlag = true; // записываем первое число в файл или он уже содержит результаты
                for (String str: splitted) {
                    if (isDigit(str)) {
                        if (!isFirstFlag) {
                            bufferedWriter.write(" ");
                            bufferedWriter.write(str); // не первое
                        }
                        else {
                            bufferedWriter.write(str); // первое
                            isFirstFlag = false;
                        }
                    }
                }
            }
            bufferedReader.close();
            bufferedReader1.close();
            bufferedWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    // метод пытается распарсить String в Integer.
    // соответственно return true если действительно ЦЕЛОЕ число
    private static boolean isDigit(String s) {
        try {
            Integer.parseInt(s);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
        catch(NullPointerException e) {
            return false;
        }
    }
}