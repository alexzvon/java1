package ru.progwards.java1.lessons.basics;

public class Astronomy {
    final static double PI = 3.14;

    public static void main(String[] args) {
        //
    }

    public static Double sphereSquare(Double r) {
        final double k = 4.0;
        Double s = k * PI * r * r;
        return s;
    }

    public static Double earthSquare() {
        Double r = 6371.2;
        Double s = sphereSquare(r);
        return s;
    }

    public static Double mercurySquare() {
        Double r = 2439.7;
        Double s = sphereSquare(r);
        return s;
    }

    public static Double jupiterSquare() {
        Double r = 71492.0;
        Double s = sphereSquare(r);
        return s;
    }

    public static Double earthVsMercury() {
        Double earth = earthSquare();
        Double mercury = mercurySquare();
        Double result = earth / mercury;
        return result;
    }

    public static Double earthVsJupiter() {
        Double earth = earthSquare();
        Double jupiter = jupiterSquare();
        Double result = earth / jupiter;
        return result;
    }
}
