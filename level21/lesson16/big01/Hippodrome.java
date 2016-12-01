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
        game.printWinner();
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
    public Horse getWinner(){
        int max = 0;
        Horse hMax = new Horse("",0,0);
        for (Horse h:horses)
        {
            if (max < (int) Math.round(h.distance))
            {
                max = (int) Math.round(h.distance);
                hMax = h;
            }
        }
        return hMax;
    }
    public void printWinner(){
        System.out.println("Winner is " + getWinner().name + "!");
    }
}
