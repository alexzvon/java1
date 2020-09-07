package ru.progwards.java1.lessons.bitsworld;

public class CheckBit {

    public static void main(String[] args) {
        //
    }

    public static int checkBit(byte value, int bitNumber) {

        return (int)((value >> bitNumber) & 0b0000_0001);
    }
}
