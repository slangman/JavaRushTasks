package com.javarush.task.task15.task1522;

/**
 * Created by Админ on 15.01.2018.
 */
public class Earth implements Planet {
    private static Earth earth;
    private Earth() {}
    public static Earth getPlanet() {
        if (earth == null) {
            earth = new Earth();
        }
        return earth;
    }
}
