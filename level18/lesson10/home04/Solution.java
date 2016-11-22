package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = reader.readLine();
        String filename2 = reader.readLine();
        FileInputStream inputStreamOne = new FileInputStream(filename1);
        FileInputStream inputStreamTwo = new FileInputStream(filename2);
        byte[] bufferOne = new byte[inputStreamOne.available()];
        while(inputStreamOne.available()>0) {
            inputStreamOne.read(bufferOne);
        }
        byte[] bufferTwo = new byte[inputStreamTwo.available()];
        while (inputStreamTwo.available()>0) {
            inputStreamTwo.read(bufferTwo);
        }
        FileOutputStream wr = new FileOutputStream(filename1);
        wr.write(bufferTwo);
        wr.write(bufferOne);
        reader.close();
        inputStreamOne.close();
        inputStreamTwo.close();
        wr.close();



    }

}
