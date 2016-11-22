package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Solution {

    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writeSecondFile = new BufferedWriter(new FileWriter(args[1]));
        ArrayList<String> symbols = new ArrayList<>();
        String line = reader.readLine();
        boolean isFirst = true;
        while(line != null){

            String[] rawStrings = line.split(" ");
            for (int i = 0; i <rawStrings.length ; i++)
            {
                String[] rawSymbols = rawStrings[i].split("");
                for (String a:rawSymbols) {
                    if (isDigit(a)){
                        symbols.add(rawStrings[i]);
                        break;
                    }
                }
            }

            line = reader.readLine();
        }
        for (String s:symbols) {
            if(isFirst){
                writeSecondFile.write(s);
                isFirst = false;
            }
            else {
                writeSecondFile.write(" " + s);
            }
        }




        reader.close();
        writeSecondFile.close();
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

