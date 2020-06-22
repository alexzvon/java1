package ru.progwards.java1.lessons.bigints;

public class ByteInteger extends AbsInteger {
    public final byte MAX_VALUE = 127;
    private byte num;

    public ByteInteger(byte num) {
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
