package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException{
        if(args[0].equals("-u")){
            addProduct(args[1], args[2], args[3], args[4]);
        }
        else if(args[0].equals("-d")){
            deleteProduct(args[1]);
        }



    }
    static void deleteProduct(String id1)throws IOException{
        String id = id1;
        String cache = id.replaceAll(" ", "");
        id = cache;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();



        BufferedReader fileReader = new BufferedReader(new FileReader(filename));

        ArrayList<String> lines = new ArrayList<>();
        String line =fileReader.readLine();
        System.out.println(line);
        while (line  != null) {
            if (line.substring(0, id.length()).equals(id)) {
                System.out.println("Huraaaay");
            }
            else {
                lines.add(line);
            }
            line = fileReader.readLine();
        }
        Boolean firstFlag = true;
        fileReader.close();
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        for (String ln:lines
                )
        {
            if(firstFlag)
            {
                writer.write(ln);
                firstFlag = false;
            }
            else {
                writer.write("\n" + ln );
            }
        }
        writer.close();
        reader.close();

    }
    static void addProduct(String idOriginal, String productName, String price, String quantity)throws IOException
    {
        ArrayList<Character> chars = new ArrayList<>();
        char[] chars1 = productName.toCharArray();
        for (int i = 0; i <chars1.length ; i++)
        {
            chars.add(chars1[i]);
        }
        while(chars.size()<30){
            chars.add(' ');
        }
        while(chars.size()>30){
            chars.remove(chars.size() - 1);
        }
        String price1 = price;
        while(price1.length()<8){
            String priceCache = price1;
            price1 = priceCache + " ";
        }
        if(price1.length()>8){
            String cache = price1;
            price1 = cache.substring(0,8);
        }

        String quantity1 = quantity;
        while(quantity1.length()<4){
            String quantityCache = quantity1;
            quantity1 = quantityCache + " ";
        }
        if(quantity1.length()>4){
            String cache = quantity1;
            quantity1 = cache.substring(0,4);
        }

        String chars2 = "";
        StringBuilder builder = new StringBuilder(chars.size());
        for(Character ch: chars)
        {
            builder.append(ch);
        }
        chars2 = builder.toString();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        String id = idOriginal;
        ArrayList<String> lines = new ArrayList<>();
        String line = fileReader.readLine();
        while(line != null){
            if(line.substring(0, id.length()).equals(id)){
                String editedLine = line.substring(0, 8) + chars2 + price1 + quantity1;
                lines.add(editedLine);
            }
            else{
                lines.add(line);
            }
            line = fileReader.readLine();
        }
        Boolean firstFlag = true;
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        for (String ln:lines
                )
        {
            if(firstFlag)
            {
                writer.write(ln);
                firstFlag = false;
            }
            else {
                writer.write("\n" + ln );
            }
        }
        writer.close();
        reader.close();
        fileReader.close();







    }
}
