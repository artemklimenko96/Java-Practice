package com.javarush.test.level17.lesson10.bonus02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static
    {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException
    {
        if (args.length == 0)
        {
            return;
        } else
        {
            if (args[0].equals("-c"))
            {
                create(args);
            }
            if (args[0].equals("-u"))
            {
                update(args);
            }
            if (args[0].equals("-d"))
            {
                delete(args);
            }
            if (args[0].equals("-i"))
            {
                info(args);
            }
        }
    }

    public static void create(String[] args) throws ParseException
    {
        synchronized (Solution.class)
        {
            if ((args.length - 1) % 3 != 0)
            {
                return;
            } else
            {
                for (int i = 1; i < args.length; i = i + 3)
                {
                    Person person = null;
                    if (args[i + 1].equals("м"))
                    {
                        person = Person.createMale(args[i], getDate(args[i + 2]));
                    } else if (args[i + 1].equals("ж"))
                    {
                        person = Person.createFemale(args[i], getDate(args[i + 2]));
                    }
                    allPeople.add(person);
                    System.out.println(allPeople.indexOf(person));
                }
            }
        }


    }

    public static void update(String[] args) throws ParseException
    {
        synchronized (Solution.class)
        {
            if ((args.length - 1) % 4 != 0)
            {
                return;
            } else
            {
                for (int i = 1; i < args.length; i = i + 4)
                {
                    int id = Integer.parseInt(args[i]);
                    Person person = allPeople.get(id);
                    if (args[i + 2].equals("м"))
                    {
                        person.setSex(Sex.MALE);
                    } else if (args[i + 2].equals("ж"))
                    {
                        person.setSex(Sex.FEMALE);
                    }
                    person.setName(args[i + 1]);
                    person.setBirthDay(getDate(args[i + 3]));
                }
            }
        }

    }

    public static void delete(String[] args)
    {
        synchronized (Solution.class)
        {
            for (int i = 1; i < args.length; i++)
            {
                int id = Integer.parseInt(args[i]);
                Person person = allPeople.get(id);
                person.setName(null);
                person.setSex(null);
                person.setBirthDay(null);
            }
        }

    }

    public static void info(String[] args)
    {
        for (int i = 1; i < args.length; i++)
        {
            Person p = allPeople.get(Integer.parseInt(args[i]));
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            String s;
            if (p.getSex() == Sex.MALE)
            {
                s = "м";
            } else
            {
                s = "ж";
            }
            System.out.println(p.getName() + " " + s + " " + simpleDateFormat.format(p.getBirthDay()));
        }

    }

    public static Date getDate(String s) throws ParseException
    {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = simpleDateFormat.parse(s);
        return date;
    }


}