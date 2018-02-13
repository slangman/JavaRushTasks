package com.javarush.task.task14.task1408;

/**
 * Created by Админ on 03.01.2018.
 */
public class MoldovanHen extends Hen {
    public int getCountOfEggsPerMonth() {
        return 43;
    }
    String getDescription() {
        return (super.getDescription() + " Моя страна " + Country.MOLDOVA + ". " +
                "Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.");
    }
}
