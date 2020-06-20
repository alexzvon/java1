package ru.progwards.java1.lessons.interfaces;

public class CalculateFibonacci {
    private static CacheInfo lastFibo;

    public static void main(String[] args) {
    //
    }

    public static int fiboNumber(int n) {

        if(lastFibo == null) { lastFibo = new CacheInfo(); }
        if (n != lastFibo.n) {

            if (n <= 2) return 1;

            int n_2 = 1;
            int n_1 = 1;
            int n_s = 0;
            for (int i = 2; i < n; i++) {
                n_s = n_1 + n_2;
                n_1 = n_2;
                n_2 = n_s;
            }

            lastFibo.n = n;
            lastFibo.fibo = n_s;
        }

        return lastFibo.fibo;
    }

    public static class CacheInfo {
        public int n = 0;
        public int fibo = 1;
    }

    public static CacheInfo getLastFibo() {
        if(lastFibo == null) { lastFibo = new CacheInfo(); }
        return lastFibo;
    }

    public static void clearLastFibo() {
        lastFibo = null;
    }

}
