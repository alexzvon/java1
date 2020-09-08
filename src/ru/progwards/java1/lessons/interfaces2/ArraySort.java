package ru.progwards.java1.lessons.interfaces2;

public class ArraySort {
    public static void sort(Comparable<Number>[] a) {
        Number n;

        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if(0 > a[i].compareTo((Number) a[j])) {
                    n = (Number)a[i];
                    a[i] = a[j];
                    a[j] = n;
                }
            }
        }
    }
}

