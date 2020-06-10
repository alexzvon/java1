package ru.progwards.java1.lessons.bitsworld;

public class SumBits {

    public static void main(String[] args) {
        //
    }

    public static int sumBits(byte value) {
        int sum = 0;
        for (int i = 0; i < 8; i++) {
            sum += (value & 0b0000_0001);
            value >>= 1;
        }
        return sum;
    }
}
