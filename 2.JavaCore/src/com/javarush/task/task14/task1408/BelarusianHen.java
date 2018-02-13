package com.javarush.task.task14.task1408;

/**
 * Created by Админ on 03.01.2018.
 */
public class BelarusianHen extends Hen {
    public int getCountOfEggsPerMonth() {
        return 13;
    }
    String getDescription() {
        return (super.getDescription() + " Моя страна " + Country.BELARUS + ". " +
                "Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.");
    }
}
