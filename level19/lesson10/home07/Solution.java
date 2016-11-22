package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String fileName = args[0];
        String input;
        ArrayList<String> stringList = new ArrayList<String>();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        BufferedWriter writeSecondFile = new BufferedWriter(new FileWriter(args[1]));
        while ((input = fileReader.readLine()) != null){
            String[] a = input.split(" ");
            for (int i = 0; i <a.length ; i++)
            {
                if (a[i].length() > 6)
                {
                    stringList.add(a[i]);

                }
            }
        }
        for (int i = 0; i < stringList.size(); i++) {
            if(i<= stringList.size() - 2){
                writeSecondFile.write(stringList.get(i) + ",");
            }
            else writeSecondFile.write(stringList.get(i));
        }


        writeSecondFile.close();
        fileReader.close();
    }
}