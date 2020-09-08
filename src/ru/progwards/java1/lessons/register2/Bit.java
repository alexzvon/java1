package ru.progwards.java1.lessons.register2;

public class Bit {
    private boolean value;

    public Bit() {
        value = false;
    }

    public Bit(boolean value) {
        this.value = value;
    }

    public String toString() {
        return value ? "1" : "0";
    }

}

