package com.javarush.test.level18.lesson03.task01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* Максимальный байт
Ввести с консоли имя файла
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream fileStream = new FileInputStream(fileName);
        ArrayList<Integer> rawBytes = new ArrayList<>();
        while (fileStream.available() > 0)
        {
            int saver = fileStream.read();
            rawBytes.add(saver);
        }
        for (int i = 0; i < rawBytes.size(); i++)
        {
            int a = rawBytes.get(i);


            for (int j = 0; j < rawBytes.size(); j++)
            {


                if (rawBytes.get(j) == a && j != i)
                {

                    rawBytes.remove(j);

                }


            }


        }
        Collections.sort(rawBytes);
        for (int x:
                rawBytes) {


            System.out.println(x);
        }}
}