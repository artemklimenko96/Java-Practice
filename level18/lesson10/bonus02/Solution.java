package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

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
    public static void main(String[] args) throws Exception {

        if(args[0].equals("-c")){
            addProduct(args[1], args[2], args[3]);
        }



    }
    static void addProduct(String productName, String price, String quantity)throws IOException{
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
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

        ArrayList<String> lines = new ArrayList<>();
        String line = fileReader.readLine();
        while(line != null){
            lines.add(line);
            line = fileReader.readLine();
        }
        String id = "";
        id = lines.get(lines.size()-1).substring(0,8);
        String[] arr = id.split("");
        ArrayList<String> arr1 = new ArrayList<>();
        for (int i = 0; i <arr.length ; i++) {
            arr1.add(arr[i]);
        }

        String lineId = "";
        for (int i = 0; i <arr1.size() ; i++) {
            String cache = lineId;
            lineId = cache + arr1.get(i);
        }
        String cache = lineId.replaceAll(" ", "");
        lineId = cache;


        int idInt = Integer.parseInt(lineId);

        reader.close();
        fileReader.close();
        String chars2 = "";
        StringBuilder builder = new StringBuilder(chars.size());
        for(Character ch: chars)
        {
            builder.append(ch);
        }
        chars2 = builder.toString();

        int idOut = idInt+1;
        FileWriter file = new FileWriter(fileName, true);
        file.write("\n" + idOut + chars2 + price1 + quantity1);
        System.out.println(idOut + chars2 + price1 );
        System.out.println(quantity1);
        file.close();


    }
}
