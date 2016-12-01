package com.javarush.test.level21.lesson16.big01;

/**
 * Created by Artem Klimenko on 23 Nov 2016.
 */
public class Horse
{
    String name;
    double speed;
    double distance;

    public Horse(String name, double speed, double distance)
    {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public String getName()
    {
        return name;
    }

    public double getSpeed()
    {
        return speed;
    }

    public double getDistance()
    {
        return distance;
    }

    public void setSpeed(double speed)
    {
        this.speed = speed;
    }

    public void setDistance(double distance)
    {
        this.distance = distance;
    }

    public void setName(String name)
    {

        this.name = name;
    }
    public void move(){
        distance += speed*Math.random();
    }
    public void print(){
        int rounded =(int) Math.round(distance);
        for (int i = 0; i <rounded ; i++)
        {
            System.out.print(".");
        }
        System.out.println(name);
    }
}
