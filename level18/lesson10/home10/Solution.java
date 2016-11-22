package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws Exception
    {
        BufferedReader readerOfFilesNames = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String, byte[]> mapOfFileParts = new TreeMap<String, byte[]>();
        FileInputStream inputStreamOfFilesParts = null;
        String nameOFFilesParts = "";

        while (true)
        {
            String inputString = readerOfFilesNames.readLine();
            if (inputString.equals("end"))
                break;
            nameOFFilesParts = inputString;
            inputStreamOfFilesParts = new FileInputStream(nameOFFilesParts);
            int currentLengthOfArray = inputStreamOfFilesParts.available();
            byte bufferOfFileParts [] = new byte[currentLengthOfArray];
            inputStreamOfFilesParts.read(bufferOfFileParts);
            mapOfFileParts.put (nameOFFilesParts, bufferOfFileParts);
        }

        readerOfFilesNames.close();
        inputStreamOfFilesParts.close();

        int indexOfLastDot = nameOFFilesParts.lastIndexOf(".");
        String nameOfOutputFile = nameOFFilesParts.substring(0, indexOfLastDot);
        FileOutputStream outputStream = new FileOutputStream(nameOfOutputFile);
        for (Map.Entry < String, byte[]> pair: mapOfFileParts.entrySet())
        {
            byte [] currentArrayForWrite = pair.getValue();
            outputStream.write(currentArrayForWrite);
        }
        outputStream.close();

    }
}
