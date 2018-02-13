package com.javarush.task.task19.task1901;

/* 
TableAdapter
*/

public class Solution {
    public static void main(String[] args) {
        //это пример вывода
        ATable aTable = new ATable() {
            @Override
            public String getCurrentUserName() {
                return "Amigo";
            }

            @Override
            public String getTableName() {
                return "DashboardTable";
            }
        };

        BTable table = new TableAdapter(aTable);
        System.out.println(table.getHeaderText());
    }

    public static class TableAdapter implements ATable, BTable {

        private ATable atable;

        public TableAdapter(ATable atable) {
            this.atable = atable;
        }

        @Override
        public String getCurrentUserName() {
            return atable.getCurrentUserName();
        }

        @Override
        public String getTableName() {
            return atable.getTableName();
        }

        @Override
        public String getHeaderText() {
            return "[" + getCurrentUserName() + "]" + " : " + getTableName();
        }
    }

    public interface ATable {
        String getCurrentUserName();
        String getTableName();
    }

    public interface BTable {
        String getHeaderText();
    }
}