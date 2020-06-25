package ru.progwards.java1.lessons.test;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        System.out.print("Сделаю коммит, запушу в репо: робот, проверяй теперь всё это...");

        BigDecimal a = new BigDecimal("10");
        BigDecimal b = new BigDecimal("20");

        a.multiply(b);

        //=============================================
        String filename = "filename";




    }

    public Integer sqr(Integer n) {
        Integer sqr = 0;
        try {
            sqr = n * n;
        }
        catch (NullPointerException e) {
            sqr = -1;
        }

        return sqr;
    }

    private int lineCount(String filename) throws IOException{
        int count = 0;
        String strFromFile;
        try {
            FileReader reader = new FileReader(filename);
            Scanner scanner = new Scanner(reader);
            try {
                while (scanner.hasNextLine()) {
                    strFromFile = scanner.nextLine();
                    count++;
                }
            }
            finally {
                reader.close();
            }
        }
        catch (IOException e) {
            throw new IOException("файл не найден");
        }

        return count;
    }




    public String test(String filename) throws IOException {
        if (filename == null) {
            throw new IOException("File not found");
        }
        else {
            return "File processing";
        }
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
