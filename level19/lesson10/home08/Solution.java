package com.javarush.test.level19.lesson10.home08;

/* Перевертыши
1 Считать с консоли имя файла.
2 Для каждой строки в файле:
2.1 переставить все символы в обратном порядке
2.2 вывести на экран
3 Закрыть потоки. Не использовать try-with-resources

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА
*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> stringList = new ArrayList<String>();
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));

        String input = "";
        while ((input = fileReader.readLine()) != null)
        {
            String s = reverseByStringBuilder(input);
            stringList.add(s);
        }
        for (int i = 0; i < stringList.size() ; i++)
        {
            System.out.println(stringList.get(i));
        }
        reader.close();
        fileReader.close();
    }
    public static String reverseByStringBuilder(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}
