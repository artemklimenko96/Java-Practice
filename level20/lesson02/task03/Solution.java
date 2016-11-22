package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {

    public static Map<String, String> properties = new HashMap<>();

    public static void main(String[] args)
    {
        new Solution().fillInPropertiesMap();
    }

    public void fillInPropertiesMap()
    {
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            load(new FileInputStream(reader.readLine()));
        }
        catch (Exception E){E.printStackTrace();}

    }

    public void save(OutputStream outputStream) throws Exception
    {
        Properties prop = new Properties();
        try
        {
            for (Map.Entry<String,String> map : properties.entrySet())
            {
                prop.put(map.getKey(),map.getValue());
            }
            prop.store(outputStream, null);
            outputStream.close();
        }catch (IOException io)
        {
            io.printStackTrace();
        }

    }

    public void load(InputStream inputStream) throws Exception
    {
        Properties prop = new Properties();
        try
        {
            prop.load(inputStream);
            for (String s : prop.stringPropertyNames())
                properties.put(s, prop.getProperty(s));
        }catch (Exception e){e.printStackTrace();}
    }
}
