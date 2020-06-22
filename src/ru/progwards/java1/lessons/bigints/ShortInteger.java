package ru.progwards.java1.lessons.bigints;

public class ShortInteger extends AbsInteger {
    public final short MAX_VALUE = 32767;
    private short num;

    public ShortInteger(short num) {
        this.num = num;
    }

    @Override
    public int getMax_Value() {
        return (int)MAX_VALUE;
    }

    @Override
    public String toString() {
        return String.valueOf(num);
    }
}
