package com.javarush.test.level19.lesson10.home06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Замена чисел
1. В статическом блоке инициализировать словарь map парами [число-слово] от 0 до 12 включительно
Например, 0 - "ноль", 1 - "один", 2 - "два"
2. Считать с консоли имя файла
3. Заменить все числа на слова используя словарь map
4. Результат вывести на экран
5. Закрыть потоки. Не использовать try-with-resources

Пример данных:
Это стоит 1 бакс, а вот это - 12 .
Переменная имеет имя file1.
110 - это число.

Пример вывода:
Это стоит один бакс, а вот это - двенадцать .
Переменная имеет имя file1.
110 - это число.
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");


    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        String a = "";
        String input = "";
        ArrayList<String> incomingStrings = new ArrayList<>();
        while ((input = fileReader.readLine()) != null){
            incomingStrings.add(input);
        }
        for (int i = 0; i < incomingStrings.size() ; i++) {


            String[] line = incomingStrings.get(i).split(" ");
            for (int j = 0; j < line.length; j++) {
                if (isDigit(line[j])) {
                    if(line[j].equals("0") || line[j].equals("1") || line[j].equals("2")|| line[j].equals("3")|| line[j].equals("4")|| line[j].equals("5")
                            || line[j].equals("6")|| line[j].equals("7")|| line[j].equals("8")|| line[j].equals("9")|| line[j].equals("10")|| line[j].equals("11") || line[j].equals("12")){
                        String buffer = map.get(Integer.parseInt(line[j]));
                        line[j] = buffer;
                    }
                }

            }

            a = "";
            for (int n = 0; n < line.length; n++) {
                a += line[n] + " ";


            }

            System.out.println(a);
        }

        reader.close();
        fileReader.close();
    }

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
