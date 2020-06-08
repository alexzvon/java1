package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;

public class Eratosthenes {
    private boolean[] sieve;

    public static void main(String[] args) {
        //
    }

    public Eratosthenes(int N) {
        sieve = new boolean[N];
        Arrays.fill(sieve, true);
        sift();
    }

    private void sift() {
        for (int i = 2; i < sieve.length; i++) {
            for (int j = 2; j * i < sieve.length;  j++) {
                    sieve[j * i] = false;
            }
        }
    }

    public boolean isSimple(int n) {
        if(n >= sieve.length) return false;
        return sieve[n];
    }
}
