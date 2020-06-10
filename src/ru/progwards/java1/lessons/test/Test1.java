package ru.progwards.java1.lessons.test;

public class Test1 {
    public static void main(String[] args) {
        System.out.print("Сделаю коммит, запушу в репо: робот, проверяй теперь всё это...");
    }

    public interface Speaking {
        public String say();
    }

    public interface Eating {
        public String eat();
    }


    class Dog implements Speaking, Eating {
        @Override
        public String say() {
            return "Гав";
        }

        @Override
        public String eat() {
            return "Мясо";
        }
    }

    class Goat implements Speaking, Eating {
        @Override
        public String say() {
            return "Мее";
        }

        @Override
        public String eat() {
            return "Сено";
        }
    }
}
