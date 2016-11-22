package com.javarush.test.level19.lesson10.bonus01;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
оригинальный   редактированный    общий
file1:         file2:             результат:(lines)

строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка4                           REMOVED строка4
строка5        строка5            SAME строка5
строка0                           ADDED строка0
строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка5                           ADDED строка5
строка4        строка4            SAME строка4
строка5                           REMOVED строка5
*/

public class Solution {


    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner1 = new Scanner(new FileReader(reader.readLine()));
        Scanner scanner2 = new Scanner(new FileReader(reader.readLine()));

        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();


        while (scanner1.hasNextLine()) {
            list1.add(scanner1.nextLine());
        }



        while (scanner2.hasNextLine()) {
            list2.add(scanner2.nextLine());
        }


        reader.close();
        scanner1.close();
        scanner2.close();

        int imax = 0, jmax = 0;
        for (int i = 0, j = 0; i < list1.size() && j < list2.size(); ) {
            if (list1.get(i).equals(list2.get(j))) {
                lines.add(new LineItem(Type.SAME, list1.get(i)));
                i++;
                j++;
            }
            else if (list1.contains(list2.get(j))) {
                lines.add(new LineItem(Type.REMOVED, list1.get(i)));
                i++;
            }
            else if (!list1.contains(list2.get(j))) {
                lines.add(new LineItem(Type.ADDED, list2.get(j)));
                j++;
            }
            imax = i;
            jmax = j;
        }

        if (imax < list1.size()) {
            for (int i = imax; i < list1.size(); i++) {
                if (list2.contains(list1.get(i))) {
                    lines.add(new LineItem(Type.SAME, list1.get(i)));
                }
                else {
                    lines.add(new LineItem(Type.REMOVED, list1.get(i)));
                }
            }
        }

        if (jmax < list2.size()) {
            for (int i = jmax; i < list2.size(); i++) {
                if (list1.contains(list2.get(i))) {
                    lines.add(new LineItem(Type.SAME, list2.get(i)));
                }
                else {
                    lines.add(new LineItem(Type.ADDED, list2.get(i)));
                }
            }
        }

        for (LineItem l : lines) {
            System.out.println(l.type + " " + l.line);
        }



    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }

}