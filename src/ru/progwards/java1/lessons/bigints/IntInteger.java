package ru.progwards.java1.lessons.bigints;

public class IntInteger extends AbsInteger {
    private int num;

    public IntInteger(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return String.valueOf(num);
    }

}
