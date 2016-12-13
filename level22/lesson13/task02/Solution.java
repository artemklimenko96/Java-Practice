package com.javarush.test.level22.lesson13.task02;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;

/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        InputStream fileReader = new BufferedInputStream(new FileInputStream(args[0]));
        FileOutputStream outFile = new FileOutputStream(args[1]);
        ArrayList<String> convertBuff = new ArrayList<>();
        int data = 0;
       ArrayList<Byte> bytes = new ArrayList<>();
        while ((data = fileReader.read())!=-1){
           bytes.add((byte)data);
        }
        byte[] bytes2 = new byte[bytes.size()];
        for (int i = 0; i < bytes.size() ; i++)
        {
            bytes2[i]= bytes.get(i);
        }

        Charset win = Charset.forName("Windows-1251");
        Charset utf = Charset.forName("UTF-8");
        String pureString = new String(bytes2, utf);

        byte[]utfConverted = pureString.getBytes(win);
        outFile.write(utfConverted);

    }
}
