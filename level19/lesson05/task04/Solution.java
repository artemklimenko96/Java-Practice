package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;


public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileReader inFile = new FileReader(reader.readLine());
        FileWriter outFile = new FileWriter(reader.readLine());
        String str = "";

        while (inFile.ready())
        {
            char symbol = (char) inFile.read();
            str += String.valueOf(symbol);
        }
        String str1 = str.replace(".", "!");

        outFile.write(str1);

        reader.close();
        inFile.close();
        outFile.close();
    }
}

