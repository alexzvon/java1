package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;

public class ArraySort {

    public static void sort(int[] a) {
        int p;
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {

                System.out.println(a[i]);
                System.out.println(a[j]);

                System.out.println(Arrays.toString(a));

                if(a[i] < a[j]) {
                    p = a[i];
                    a[i] = a[j];
                    a[j] = p;
                }
            }
        }
    }

    public static void main(String[] args) {
//        int[] arr = {89,78,67,56,45,34,23,12};
        int[] arr = {5,4,3};


        System.out.println(Arrays.toString(arr));

        sort(arr);

        System.out.println(Arrays.toString(arr));


    }











}
