package com.javarush.task.task14.task1408;

/**
 * Created by Админ on 03.01.2018.
 */
public class RussianHen extends Hen {
    public int getCountOfEggsPerMonth() {
        return 14;
    }
    String getDescription() {
        return (super.getDescription() + " Моя страна " + Country.RUSSIA + ". " +
                "Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.");
    }
}
