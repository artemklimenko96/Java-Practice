package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileRead = new FileReader(reader.readLine());
        FileWriter fileWrite = new FileWriter(reader.readLine());
       int i = 0;
        while(fileRead.ready())
       {
           int data = fileRead.read();
           i++;
           if((i%2) ==0){
             fileWrite.write(data);
           }
       }
        reader.close();
        fileRead.close();
        fileWrite.close();
    }
        
}
