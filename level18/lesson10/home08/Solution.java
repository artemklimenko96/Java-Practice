package com.javarush.test.level18.lesson10.home08;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Не забудьте закрыть все потоки
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws Exception {
        ArrayList<String> files = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while (!((s = reader.readLine()).equals("exit")))
        {
            files.add(s);
        }
        for (String f : files)
        {
            new ReadThread(f).start();
        }
        /*Thread.sleep(3000);
        System.out.println(resultMap);*/
    }

    public static class ReadThread extends Thread {
        String fileName;
        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут


        @Override
        public void run()
        {
            try
            {
                FileInputStream stream = new FileInputStream(fileName);
                HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
                while (stream.available() > 0)
                {
                    Integer c = stream.read();
                    Integer count = map.get(c);
                    map.put(c, (count == null ? 0 : count + 1));
                }
                Map.Entry<Integer, Integer> entry = map.entrySet().iterator().next();
                for (Map.Entry<Integer, Integer> e : map.entrySet())
                {
                    if (e.getValue() > entry.getValue())
                    {
                        entry = e;
                    }
                }
                synchronized (Solution.class)
                {
                    resultMap.put(fileName, entry.getKey());
                }
            }
            catch (IOException e)
            {

            }
            finally
            {
                try
                {
                    stream.close();
                }
                catch (Exception e) {}
            }
        }

        private FileInputStream stream;
    }
}