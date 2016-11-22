package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, включая символы новой строки. Результат вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileReader inFile = new FileReader(reader.readLine());
        FileWriter fileWrite = new FileWriter(reader.readLine());
        String temp = "";
        while(inFile.ready()){
            char symbol = (char)inFile.read();
            temp += String.valueOf(symbol);
        }
        Pattern p = Pattern.compile("[(\\p{Punct})|\\r\\n]");
        Matcher m = p.matcher(temp);
        String temp1 = m.replaceAll("");
        String str = temp1;
        fileWrite.write(str);
        System.out.println(str);
        reader.close();
        inFile.close();
        fileWrite.close();
    }
}
