package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        char tempChar;
        char spaceChar = ' ';
        int counter = 0;
        int a = 0;
        while (fileInputStream.available()>0) {
            tempChar = (char)fileInputStream.read();
            a++;
            if ((tempChar == spaceChar)){
                counter++;
            }
        }
        int d = (counter/a)*100;
        String s = Integer.toString(d);

        double res = (double)counter / a * 100;
        String o = String.format("%.2f", res);
        System.out.println(o);
        fileInputStream.close();
    fileInputStream.close();
    }
}


