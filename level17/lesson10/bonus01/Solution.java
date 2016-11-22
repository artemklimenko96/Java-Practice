package com.javarush.test.level17.lesson10.bonus01;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

    public class Solution {
        public static List<Person> allPeople = new ArrayList<Person>();
        static {
            allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
            allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
        }

        public static void main(String[] args){
            int id;
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            SimpleDateFormat format2 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

//ДЕЙСТВИЕ -С
            if (args[0].equals("-c")){
                Person person=null;
                try
                {   if(args[2].equals("м"))
                    person = Person.createMale(args[1],format.parse(args[3]));
                else
                    person = Person.createFemale(args[1], format.parse(args[3]));
                }
                catch (ParseException e)
                {
                    e.printStackTrace();
                }
                allPeople.add(person);
                System.out.println((allPeople.size() - 1));
            }
//ДЕЙСТВИЕ -U
            else if(args[0].equals("-u")){
                id= Integer.parseInt(args[1]);
                allPeople.get(id).setName(args[2]);
                if(args[3].equals("м"))
                    allPeople.get(id).setSex(Sex.MALE);
                else
                    allPeople.get(id).setSex(Sex.FEMALE);

                try
                {
                    allPeople.get(id).setBirthDay(format.parse(args[4]));
                }
                catch (ParseException e)
                {
                    e.printStackTrace();
                }
            }
//ДЕЙСТВИЕ -D
            else if(args[0].equals("-d")){
                id=Integer.parseInt(args[1]);
                allPeople.get(id).setSex(null);
                allPeople.get(id).setBirthDay(null);
                allPeople.get(id).setName(null);
            }
//Действие -I
            else if (args[0].equals("-i")){
                id = Integer.parseInt(args[1]);
                if((allPeople.get(id)).getSex()==Sex.MALE)
                    System.out.println((allPeople.get(id)).getName()+ " м "+format2.format((allPeople.get(id)).getBirthDay()));
                else
                    System.out.println((allPeople.get(id)).getName()+ " ж "+format2.format((allPeople.get(id)).getBirthDay()));
            }

        }


    }