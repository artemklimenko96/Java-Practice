package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        Map<Double, String> people = new TreeMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        String[] buffer = {" ", " "};
        ArrayList<String> names = new ArrayList<String>();
        ArrayList<Double> numbers = new ArrayList<Double>();
        while (reader.ready())
        {
            buffer = reader.readLine().split(" ");
            for (String s : buffer)
            {
                s.trim();

            }
            names.add(buffer[0]);
            numbers.add(Double.parseDouble(buffer[1]));
        }
        String buff = "";

        for (int i = 0; i < names.size(); i++)
        {
            buff = names.get(i);

            for (int j = 0; j < names.size(); j++)
            {
                if (buff.equals(names.get(j)) && names.get(j) != buff)
                {
                    Double cache = numbers.get(i) + numbers.get(j);
                    numbers.set(i, cache);
                    numbers.remove(j);
                    names.remove(j);
                }

            }

        }
        Double numbCache = numbers.get(0);
        int iMax = 0;
        for (int i = 0; i < numbers.size(); i++){
            if (numbers.get(i)>numbCache) {
                numbCache = numbers.get(i);
                iMax = i;
            }
        }
        System.out.println(names.get(iMax));


        reader.close();
    }
}