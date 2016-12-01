package com.javarush.test.level21.lesson16.big01;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Artem Klimenko on 23 Nov 2016.
 */
public class Hippodrome
{
    public static Hippodrome game;
    ArrayList<Horse> horses = new ArrayList<>();

    public ArrayList<Horse> getHorses()
    {
        return horses;
    }

    public static void main(String[] args)
    {
        game = new Hippodrome();
        Horse horse1 = new Horse("Matta", 3, 0);
        Horse horse2 = new Horse("Seryoga", 3,0);
        Horse horse3 = new Horse("Sobchak", 3,0);
        game.getHorses().add(horse1);
        game.getHorses().add(horse2);
        game.getHorses().add(horse3);
        game.run();
    }

    public void run(){

        for (int i = 0; i <100 ; i++)
        {

            move();
            print();
            try
            {
                Thread.sleep(500);
            }
            catch (InterruptedException e)
            {
                System.out.println("triggered");
            }

        }


     }


    public void print(){
        for (Horse h:horses)
        {
            h.print();
            System.out.println();
            System.out.println();
        }
    }
    public void move(){
        for (Horse h:horses)
        {
            h.move();
        }
    }
}
