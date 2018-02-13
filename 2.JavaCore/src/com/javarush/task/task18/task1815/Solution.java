package com.javarush.task.task18.task1815;

import java.util.*;

/* 
Таблица
*/

public class Solution {
    public class TableInterfaceWrapper implements ATableInterface {

        private ATableInterface aTableInterface;

        public TableInterfaceWrapper (ATableInterface aTableInterface) {
            this.aTableInterface = aTableInterface;
        }

        public void setModel (List rows) {
            System.out.println(rows.size());
            aTableInterface.setModel(rows);
        }

        public String getHeaderText() {

            return aTableInterface.getHeaderText().toUpperCase();
        }

        public void setHeaderText(String newHeaderText) {
            aTableInterface.setHeaderText(newHeaderText);
        }

    }

    public interface ATableInterface {
        void setModel(List rows);

        String getHeaderText();

        void setHeaderText(String newHeaderText);
    }

    public static void main(String[] args) {
    }
}