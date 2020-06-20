package ru.progwards.java1.lessons.interfaces;

public class ArraySort {
    public static void main(String[] args) {
        //
    }

    public static void sort(CompareWeight[] a) {
        CompareWeight p;

        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (CompareWeight.CompareResult.LESS == a[i].compareWeight(a[j])) {
                    p = a[i];
                    a[i] = a[j];
                    a[j] = p;
                }
            }
        }
    }
}
