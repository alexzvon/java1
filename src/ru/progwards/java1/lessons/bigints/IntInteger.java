package ru.progwards.java1.lessons.bigints;

public class IntInteger extends AbsInteger {
    public final int MAX_VALUE = 2147483647;
    private int num;

    public IntInteger(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return String.valueOf(num);
    }

    @Override
    public int getMax_Value() {
        return MAX_VALUE;
    }
}
