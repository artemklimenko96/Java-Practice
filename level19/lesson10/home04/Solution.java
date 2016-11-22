package com.javarush.test.level19.lesson10.home04;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words
Закрыть потоки. Не использовать try-with-resources

Пример: words содержит слова А, Б, В
Строки:
В Б А Д  //3 слова из words, не подходит
Д А Д    //1 слово из words, не подходит
Д А Б Д  //2 слова - подходит, выводим
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) {
        BufferedReader readName = null;
        try {
            readName = new BufferedReader(new InputStreamReader(System.in));
            String fileName = readName.readLine();
            readName.close();
            BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
            String fileLine="";
            while ((fileLine=fileReader.readLine())!=null) {
                try
                {
                    int counter = 0;
                    for (String fromWord : words) {
                        counter=counter+countWord(fileLine,fromWord);
                    }
                    if (counter==2) {
                        System.out.println(fileLine);
                    }
                }
                catch (Exception e) {}
            }
            fileReader.close();

        } catch (Exception e) {}
    }

    public static int countWord(String line, String word) {
        int counter = 0;
        try
        {
            String tmp = "";
            tmp=line.toLowerCase();
            String[]strings = tmp.split(" ");
            for (String s : strings) {
                if (s.equals(word.toLowerCase())) {
                    counter++;
                }
            }
        }
        catch (Exception e)
        {}
        return counter;
    }
}