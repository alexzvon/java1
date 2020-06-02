package ru.progwards.java1.lessons.basics;

public class ReverseDigits {
    public static void main(String[] args) {
    //
    }

    public static int reverseDigits(int number) {
        double d1 = number % 10;
        double d2 = (number - d1) / 10 % 10;
        double d3 = (number - d1 - d2 * 10) / 100 % 10;

        Double d = d3 + d2 * 10 + d1 * 100;

        int result = d.intValue();

        return result;
    }
}
