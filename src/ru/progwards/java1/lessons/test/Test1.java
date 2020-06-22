package ru.progwards.java1.lessons.test;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Test1 {
    public static void main(String[] args) {
        System.out.print("Сделаю коммит, запушу в репо: робот, проверяй теперь всё это...");

        BigDecimal a = new BigDecimal("10");
        BigDecimal b = new BigDecimal("20");

        a.multiply(b);












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
