package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {

    private List<Horse> horses;

    static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void move(){
        for (Horse horse : horses) {
            horse.move();
        }
    }

    public void print(){
        for (Horse horse : horses) {
            horse.print();
        }
        int i = 0;
        while (i < 10) {
            System.out.println();
            i++;
        }
    }

    public void run() throws InterruptedException{
        int i = 0;
        while (i < 100){
            move();
            print();
            Thread.sleep(200);
            i++;
        }
    }

    public Horse getWinner() {
        double maxDistance = 0;
        Horse winner = null;
        for (Horse horse : horses) {
            if (horse.getDistance() > maxDistance) {
                maxDistance = horse.getDistance();
                winner = horse;
            }
        }
        return winner;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public static void main(String[] args) throws InterruptedException {
        List<Horse> horses = new ArrayList<>();
        horses.add(new Horse("Guf", 3.0, 0.0));
        horses.add(new Horse("Slim", 3.0, 0.0));
        horses.add(new Horse("Ptakha", 3.0, 0.0));
        game = new Hippodrome(horses);
        game.run();
        game.printWinner();
    }
}
