package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

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

        System.setOut(standardStream);

        String[] splitted = result.trim().split(" ");
        int a = 0;
        boolean aFound = false;
        int b = 0;
        boolean plus = false;
        boolean minus = false;
        boolean multiply = false;

        for (String str: splitted) {

            if (isDigit(str)) {
                if(!aFound){
                    a = Integer.parseInt(str);
                    aFound = true;
                }
                else{
                    b = Integer.parseInt(str);
                }
            }
            else if(str.equals("+")){
                plus = true;
            }
            else if (str.equals("-")){
                minus = true;
            }
            else if (str.equals("*")) {multiply = true;}
        }
        if (plus){
            System.out.println(a + " " + "+" + " " + b + " " + "=" + " " + (a+b) );
        }
        else if(minus){
            System.out.println(a + " " + "-" + " " + b + " " + "=" + " " + (a-b) );
        }
        else if(multiply){
            System.out.println(a + " " + "*" + " " + b + " " + "=" + " " + (a*b) );
        }



    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 * 6 = c");
        }
    }
    private static boolean isDigit(String s) {
        try {
            Integer.parseInt(s);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
        catch(NullPointerException e) {
            return false;
        }
    }
}
