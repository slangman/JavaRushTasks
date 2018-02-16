package com.javarush.task.task21.task2107;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* 
Глубокое клонирование карты
*/
public class Solution implements Cloneable {

    public Object clone() {
        Solution solution = new Solution();
        solution.users = new LinkedHashMap<>();
        for (Map.Entry<String, User> entry : users.entrySet() ) {
            solution.users.put(entry.getKey(), entry.getValue());
        }
        return solution;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
            clone = (Solution) solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);
    }

    protected Map<String, User> users = new LinkedHashMap();

    public static class User implements Cloneable {
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public Object clone() {
            User user = new User(age, name);
            user.age = this.age;
            user.name = this.name;
            return user;
        }

        public boolean equals(Object o) {
            if (o == this) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user1 = (User) o;
            return Objects.equals(age, user1.age) &&
                    Objects.equals(name, user1.name);

        }

        public int hashCode() {
            return Objects.hash(age, name);
        }
    }
}
