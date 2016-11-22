package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file1 = new FileInputStream(reader.readLine());
        FileOutputStream file2 = new FileOutputStream(reader.readLine());
        FileOutputStream file3 = new FileOutputStream(reader.readLine());

        while (file1.available()>0)
        {
            if (file1.available() % 2 == 0)
            {
                byte[] nach = new byte[file1.available()/2];
                byte[] kon = new byte[file1.available()/2];
                int count1 = file1.read(nach);
                int count2 = file1.read(kon);
                file2.write(nach, 0, count1);
                file3.write(kon, 0, count2);
            }
            else
            {
                byte[] nach = new byte[file1.available()/2+1];
                byte[] kon = new byte[file1.available()/2];
                int count1 = file1.read(nach);
                int count2 = file1.read(kon);
                file2.write(nach, 0, count1);
                file3.write(kon, 0, count2);
            }
        }

        file1.close();
        file2.close();
        file3.close();
        reader.close();
    }
}