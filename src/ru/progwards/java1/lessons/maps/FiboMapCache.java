package ru.progwards.java1.lessons.maps;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class FiboMapCache {
    private final boolean cacheOn;
    private final Map<Integer, BigDecimal> fiboCache;

    public String toString() {
        return fiboCache.toString();
    }

    public FiboMapCache(boolean cacheOn) {
        this.cacheOn = cacheOn;
        fiboCache = new HashMap<>();
    }

    public BigDecimal fiboNumber(int n) {
        BigDecimal valueFibo;

        if(fiboCache.containsKey(n)) {
            valueFibo = fiboCache.get(n);
        }
        else if (cacheOn) {
            valueFibo = fiboCache.put(n,  fiboN(n));
        }
        else {
            valueFibo = fiboN(n);
        }

        return valueFibo;
    }

    private BigDecimal fiboN(int n) {
        if (n <= 2) return new BigDecimal(1);

        BigDecimal n_2 = new BigDecimal(1);
        BigDecimal n_1 = new BigDecimal(1);
        BigDecimal n_s = new BigDecimal(0);
        for (int i = 2; i < n; i++)
        {
            n_s = n_1.add(n_2);
            n_1 = n_2;
            n_2 = n_s;
        }

        return n_s;
    }

    void clearCahe() {
        fiboCache.clear();
    }

    public static void test() {
        FiboMapCache fmcT = new FiboMapCache(true);
        FiboMapCache fmcF = new FiboMapCache(false);

        int ITER_FN = 1000;

        //Заполняем кеш
        for (int i = 1; i <= ITER_FN; i++ ) {
            fmcT.fiboNumber(i);
        }

        long start = System.currentTimeMillis();
        for (int i = 1; i <= ITER_FN; i++ ) {
            fmcT.fiboNumber(i);
        }
        System.out.println("fiboNumber cacheOn=true время выполнения " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        for (int i = 1; i <= ITER_FN; i++ ) {
            fmcF.fiboNumber(i);
        }
        System.out.println("fiboNumber cacheOn=false время выполнения " + (System.currentTimeMillis() - start));
    }

    public static void main(String[] args) {
        test();
    }
}
