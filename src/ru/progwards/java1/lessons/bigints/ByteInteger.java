package ru.progwards.java1.lessons.bigints;

public class ByteInteger extends AbsInteger {
    private byte num;

    public ByteInteger(byte num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return String.valueOf(num);
    }
}
