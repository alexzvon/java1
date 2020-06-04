package ru.progwards.java1.lessons.compare_if_cycles;

public class TriangleInfo {
    public static void main(String[] args) {
    //
    }

    public static boolean isTriangle(int a, int b, int c) {
        return a < b + c && b < a + c && c < a + b;
    }

    public static boolean isRightTriangle(int a, int b, int c) {
        return (c * c) == (a * a) + (b * b) || (a * a) == (c * c) + (b * b) || (b * b) == (c * c) + (a * a);
    }

    public static boolean isIsoscelesTriangle(int a, int b, int c) {
        return a == b || b == c || a == c;
    }
}
