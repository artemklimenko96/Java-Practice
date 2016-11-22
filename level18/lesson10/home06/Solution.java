package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileInputStream in = new FileInputStream(args[0]);
        long[] ascii = new long[256];

        while (in.available()>0)
            ascii[in.read()]++;

        for (int i = 0; i < 256; i++)
        {
            if (ascii[i] != 0)
                System.out.println((char)i + " " + ascii[i]);
        }

        in.close();
    }

    public static void print(SortedMap<Character, Integer> map){

        for(Map.Entry<Character, Integer> pair : map.entrySet() )
        {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }
}