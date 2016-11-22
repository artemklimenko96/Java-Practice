package com.javarush.test.level19.lesson08.task03;

/* Выводим только цифры
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить только цифры
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток
Вывести модифицированную строку в консоль.

Пример вывода:
12345678
*/

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();




    public static void main(String[] args) {
        PrintStream standardStream = System.out;
        ByteArrayOutputStream output1 = new ByteArrayOutputStream();
        PrintStream newStream = new PrintStream(output1);
        System.setOut(newStream);
        testString.printSomething();
        String result = output1.toString();
        String finalResult = result.replaceAll("[^0-9]","");
        System.setOut(standardStream);
        System.out.println(finalResult);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }

}
