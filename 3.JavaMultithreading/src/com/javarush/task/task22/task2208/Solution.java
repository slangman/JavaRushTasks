package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        /*
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("name", "Ivanov");
        params.put("country", "Ukraine");
        params.put("city", "Kyev");
        params.put("age", null);
        System.out.println(getQuery(params));
        */
    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        boolean firstParam = true;
        for (Map.Entry<String, String> entry : params.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (value != null) {
                if (firstParam) {
                    sb.append(key + " = '");
                    sb.append(value + "' ");
                    firstParam = !firstParam;
                }
                else {
                    sb.append("and ");
                    sb.append(key + " = '");
                    sb.append(value + "' ");
                }
            }
        }
        return sb.toString().trim();
    }
}
