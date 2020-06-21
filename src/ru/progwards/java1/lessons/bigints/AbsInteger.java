package ru.progwards.java1.lessons.bigints;

public abstract class AbsInteger {
    static AbsInteger add(AbsInteger num1, AbsInteger num2) {
        int bI1 = (int)Integer.valueOf(num1.toString());
        int bI2 = (int)Integer.valueOf(num2.toString());

        ByteInteger bIResult = new ByteInteger((byte)(bI1 + bI2));

        return bIResult;
    }
}
