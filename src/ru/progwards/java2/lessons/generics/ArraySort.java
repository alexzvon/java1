package ru.progwards.java2.lessons.generics;

import java.math.BigInteger;
import java.util.Arrays;

public class ArraySort {

    public static<T extends Comparable> void sort(T[] a) {
        T p;
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if(0 > a[i].compareTo(a[j])) {
                    p = a[i];
                    a[i] = a[j];
                    a[j] = p;
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] i = { 5, 6, 7, 4, 3, 2, 1 };
        sort(i);
        System.out.println(Arrays.toString(i));

        Double[] d = { 5.0, 6.0, 7.0, 4.0, 3.0, 2.0, 1.0 };
        sort(d);
        System.out.println(Arrays.toString(d));

        BigInteger[] bi = {
                new BigInteger("5"),
                new BigInteger("6"),
                new BigInteger("7"),
                new BigInteger("4"),
                new BigInteger("3"),
                new BigInteger("2"),
                new BigInteger("1")
        };
        sort(bi);
        System.out.println(Arrays.toString(bi));

    }
}
