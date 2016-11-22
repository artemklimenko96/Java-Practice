package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        Map<String, Double> people = new TreeMap<>();
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
        for (int i = 0; i < names.size(); i++){
            people.put(names.get(i), numbers.get(i));
        }

        for (Map.Entry<String, Double> entry : people.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        reader.close();
    }
}