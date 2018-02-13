package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Iterator;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception{
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        InputStream fileInputStream = new FileInputStream(fileName);
        load(fileInputStream);

    }

    public void save(OutputStream outputStream) throws Exception {
        Properties prop = new Properties();
        prop.putAll(properties);
        prop.store(outputStream, "mystream");
    }

    public void load(InputStream inputStream) throws Exception {
        Properties prop = new Properties();
        prop.load(inputStream);
        properties.putAll((Map)prop);
    }

    public static void main(String[] args) {

    }
}
