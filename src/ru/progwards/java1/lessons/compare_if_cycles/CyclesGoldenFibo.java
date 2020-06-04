package ru.progwards.java1.lessons.compare_if_cycles;

public class CyclesGoldenFibo {
    public static void main(String[] args) {

        for (int i = 1; i <= 15; i++) {
            System.out.println(fiboNumber(i));
        }

        for (int a = 1; a <= 100; a++) {
            for (int b = 1; b <= 100; b++) {
                for (int c = 1; c <= 100; c++) {
                    if(isGoldenTriangle(a, b, c)) {
                        System.out.println(a + " " + b + " " + c);
                    }
                }
            }
        }
    }

    public static boolean containsDigit(int number, int digit) {
        String str = String.valueOf(number);
        boolean result = false;

        int k = 10;
        for (int i = 0; i < str.length(); i++) {
            if(digit == (number % k) / (k / 10)) {
                result = true;
                break;
            }
            k *= 10;
        }

        return result;
    }

    public static int fiboNumber(int n) {
        if (n <= 2) return 1;

        int n_2 = 1;
        int n_1 = 1;
        int n_s = 0;
        for (int i = 2; i < n; i++)
        {
            n_s = n_1 + n_2;
            n_1 = n_2;
            n_2 = n_s;
        }

        return n_s;
    }

    public static boolean isGoldenTriangle(int a, int b, int c) {
        final double MIN_VALUE = 1.61703;
        final double MAX_VALUE = 1.61903;

        double ratio = 0;
        if(a == b) ratio = (double)a / c;
        else if (a == c) ratio = (double)a / b;
        else if (b == c) ratio = (double)b / a;

        return ratio >= MIN_VALUE && ratio <= MAX_VALUE;
    }
}
