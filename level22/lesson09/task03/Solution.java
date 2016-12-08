package com.javarush.test.level22.lesson09.task03;

import java.io.*;
import java.util.ArrayList;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution {
    public static void main(String[] args)throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        ArrayList<String> words = new ArrayList<>();
        while((s = reader.readLine()) != null){
            String[] splitted = s.split(" ");
            for (String a:splitted)
            {
                words.add(a.trim());
            }
        }
       String[] words2 = words.toArray(new String[0]);

        StringBuilder result = getLine(words2);
        System.out.println(result.toString());
        BufferedReader fileReader = new BufferedReader(new FileReader("text"));
    }

    public static StringBuilder getLine(String... words)
    {   ArrayList<String> sortedW = new ArrayList<>();
        String first = words[0];
        words[0] = null;
        Boolean isFirst = true;
        if(isFirst){
            for (String s : words)
            {
                if(first.charAt(first.length()-1) == s.charAt(0))
                    sortedW.add(first);
                sortedW.add(s);
                words[]
                isFirst = false;
            }
            isFirst = false;
        }
        for (String s : words)
        {

        }
        return null;
    }
}
