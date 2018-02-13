package com.javarush.task.task15.task1522;

/**
 * Created by Админ on 15.01.2018.
 */
public class Moon implements Planet {
    private static Moon moon;
    private Moon() {}
    public static Moon getPlanet() {
        if (moon == null) {
            moon = new Moon();
        }
        return moon;
    }
}
