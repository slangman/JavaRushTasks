package com.javarush.task.task15.task1522;

/**
 * Created by Админ on 15.01.2018.
 */
public class Sun implements Planet {
    private static Sun sun;
    private Sun() {}
    public static Sun getPlanet() {
        if (sun == null) {
            sun = new Sun();
        }
        return sun;
    }
}
