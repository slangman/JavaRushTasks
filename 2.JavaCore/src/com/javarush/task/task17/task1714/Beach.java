package com.javarush.task.task17.task1714;

/* 
Comparable
*/

import java.util.TreeSet;

public class Beach implements Comparable<Beach> {
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    public synchronized int compareTo (Beach beach) {

        int distIndex = (int) (distance - beach.getDistance());
        int qualIndex = quality - beach.getQuality();
        return 10000 * name.compareTo(beach.getName()) + 100 * distIndex + qualIndex;
    }


    public static void main(String[] args) {
        Beach beach1 = new Beach ("Arambol", 300f, 8);
        Beach beach2 = new Beach ("Anjuna", 500f, 7);
        Beach beach3 = new Beach ("Vagator", 100f, 10);

        System.out.println(beach1.compareTo(beach2));
        System.out.println(beach1.compareTo(beach3));
        System.out.println(beach2.compareTo(beach3));

    }
}
