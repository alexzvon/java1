package ru.progwards.java1.lessons.arrays;

public class ArraySort {
    public static void main(String[] args) {
        //
    }

    public static void sort(int[] a) {
        int p;
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if(a[i] < a[j]) {
                    p = a[i];
                    a[i] = a[j];
                    a[j] = p;
                }
            }
        }
    }
}
