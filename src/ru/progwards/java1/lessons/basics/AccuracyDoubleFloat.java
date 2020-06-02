package ru.progwards.java1.lessons.basics;

public class AccuracyDoubleFloat {
    final static double DOUBLE_PI = 3.14;
    final static float FLOAT_PI = 3.14F;

    public static void main(String[] args) {
        //
    }

    public static double volumeBallDouble(double radius) {
        final double NUMERATOR = 4.0;
        final double DENOMINATOR = 3.0;
        double v = NUMERATOR * DOUBLE_PI * radius * radius * radius / DENOMINATOR;
        return v;
    }

    public static float volumeBallFloat(float radius) {
        final float NUMERATOR = 4.0F;
        final float DENOMINATOR = 3.0F;
        float v = NUMERATOR * FLOAT_PI * radius * radius * radius / DENOMINATOR;
        return v;
    }

    public static double calculateAccuracy(double radius) {
        Double dR = radius;
        float fR = dR.floatValue();

        double vBD = volumeBallDouble(radius);
        Float vBF = volumeBallFloat(fR);

        double result = vBD - vBF.doubleValue();

        return result;
    }

}
