package ru.progwards.java1.lessons.bigints;

public class ShortInteger extends AbsInteger {
    private short num;

    public ShortInteger(short num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return String.valueOf(num);
    }
}
