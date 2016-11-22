package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream inputStreamOne = new FileOutputStream(reader.readLine());
        FileInputStream inputStreamTwo = new FileInputStream(reader.readLine());
        FileInputStream inputStreamThree = new FileInputStream(reader.readLine());
        while(inputStreamTwo.available()>0){
            inputStreamOne.write(inputStreamTwo.read());
        }
        while(inputStreamThree.available()>0){
            inputStreamOne.write(inputStreamThree.read());
        }
        reader.close();
        inputStreamOne.close();
        inputStreamTwo.close();
        inputStreamThree.close();
    }
}
