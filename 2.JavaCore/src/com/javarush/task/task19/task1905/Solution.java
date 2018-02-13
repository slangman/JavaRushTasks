package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String,String> countries = new HashMap<String,String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {

    }

    public static class DataAdapter implements RowItem {
        private Customer customer;
        private Contact contact;
        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }
        public String getCountryCode() {
            String countryCode = null;
            for (Map.Entry<String, String> entry : countries.entrySet()) {
                if (entry.getValue() == customer.getCountryName()) {
                    countryCode = entry.getKey();
                }
            }
            return countryCode;
        }

        public String getCompany() {
            return customer.getCompanyName();
        }

        public String getContactFirstName() {
            return ((contact.getName().split(" "))[1]);
        }

        public String getContactLastName() {
            String s = contact.getName().split(" ")[0];
            return s.substring(0, s.length()-1);
        }

        public String getDialString() {
            String[] s = contact.getPhoneNumber().split("[()-]");
            StringBuilder sb = new StringBuilder();
            sb.append("callto://+");
            for (int i = 0; i < s.length; i++) {
                sb.append(s[i]);
            }
            return sb.toString();
        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }
}