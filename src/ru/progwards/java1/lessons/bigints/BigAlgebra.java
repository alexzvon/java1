package ru.progwards.java1.lessons.bigints;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigAlgebra {

    public static void main(String[] args) {
        //
    }

    static BigDecimal fastPow(BigDecimal num, int pow) {
        int bitMask = 1;
        int powLength = Integer.toBinaryString(pow).length();
        BigDecimal result = new BigDecimal("1");

        for (int i = powLength - 1; i > 0; i--) {
            result = result.multiply(num.pow((pow >> i) & bitMask)).pow(2);
        }
        result = result.multiply(num.pow(pow & bitMask));

        return result;
    }

    static BigInteger fibonacci(int n) {
        BigInteger n_s = new BigInteger("0");
        BigInteger n_1 = new BigInteger("1");
        BigInteger n_2 = new BigInteger("1");

        if (n <= 2) return n_1;

        for (int i = 2; i < n; i++) {
            n_s = n_1.add(n_2);
            n_1 = n_2;
            n_2 = n_s;
        }

        return n_s;
    }
}
