package ru.progwards.java1.lessons.compare_if_cycles;

public class TriangleSimpleInfo {
    public static void main(String[] args) {
    //
    }

    public static int maxSide(int a, int b, int c) {
        int result = 0;

        if(a >= b && a >= c) result = a;
        else if (b >= a && b >= c) result = b;
        else result = c;

        return result;
    }

    public static int minSide(int a, int b, int c) {
        int result = 0;

        if (a <= b && a <= c) result = a;
        else if (b <= a && b <= c) result = b;
        else result = c;

        return result;
    }

    public static boolean isEquilateralTriangle(int a, int b, int c) {
        return a == b && b == c;
    }

}
