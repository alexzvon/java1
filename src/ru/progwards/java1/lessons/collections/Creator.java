package ru.progwards.java1.lessons.collections;

import java.util.ArrayList;
import java.util.Collection;

public class Creator {
    public static void main(String[] args) {
        //
    }

    public static Collection<Integer> fillEven(int n) {
        Collection<Integer> col = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            col.add(2 * i);
        }

        return col;
    }

    public static Collection<Integer> fillOdd(int n) {
        Collection<Integer> col = new ArrayList<>();

        for (int i = n; i > 0; i--) {
            col.add(2 * i - 1);
        }

        if(n <= 0) col.add(1);

        return col;
    }

    public static Collection<Integer> fill3(int n) {
        Collection<Integer> col = new ArrayList<>();

        for (int i = 0; i < 3 * n; i += 3) {
            col.add(i);
            col.add(i * i);
            col.add(i * i * i);
        }

        return col;
    }
}

