package com.javarush.task.task14.task1408;

/**
 * Created by Админ on 03.01.2018.
 */
public class UkrainianHen extends Hen {
    public int getCountOfEggsPerMonth() {
        return 88;
    }
    String getDescription() {
        return (super.getDescription() + " Моя страна " + Country.UKRAINE + ". " +
                "Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.");
    }
}
