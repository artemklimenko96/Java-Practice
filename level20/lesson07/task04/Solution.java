package com.javarush.test.level20.lesson07.task04;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* Serializable Solutionution
Сериализуйте класс Solutionution.
Подумайте, какие поля не нужно сериализовать, пометить ненужные поля — transient.
Объект всегда должен содержать актуальные итоговые данные.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать файл, открыть поток на чтение (input stream) и на запись(output stream)
2) создать экземпляр класса Solutionution - savedObject
3) записать в поток на запись savedObject (убедитесь, что они там действительно есть)
4) создать другой экземпляр класса Solutionution с другим параметром
5) загрузить из потока на чтение объект - loadedObject
6) проверить, что savedObject.string равна loadedObject.string
7) обработать исключения
*/
public class Solution implements Serializable
{
    public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException, IOException{
        //System.out.println(new Solution(4));
        Solution savedObject = new Solution(32);
        FileOutputStream fileOutput = new FileOutputStream("Solution.ser");
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("Solution.ser"));
        outputStream.writeObject(savedObject);
        outputStream.close();

        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("Solution.ser"));

        Solution a = (Solution) inputStream.readObject();
        if(savedObject.string.equals(a.string)){
            System.out.println("Works!!");

        };
    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;
    public Solution(){}
    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
