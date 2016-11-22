package com.javarush.test.level18.lesson05.task01;

import java.io.*;

/* Исправить ошибки
Исправить функциональность в соответствии с требованиями
Программа должна:
1. переписать все байты одного файла в другой одним куском.
2. закрывать потоки ввода-вывода
Подсказка: 4 ошибки
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream fileReader = new FileInputStream ("text.txt");
        char a = ',';
        int c = (int)a;
        int i = 0;

        while (fileReader.available()>0){
            char sequence = (char) fileReader.read();
            if(sequence == c){
                i ++;
            }

        }
        System.out.println(i);
        reader.close();
    }
}
