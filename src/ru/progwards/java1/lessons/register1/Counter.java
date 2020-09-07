package ru.progwards.java1.lessons.register1;

public class Counter {
    public static void inc(ByteRegister value) {
        int i = Integer.parseInt(value.toDecString());
        value.init((byte)++i);
    }

    public static void dec(ByteRegister value) {
        int i = Integer.parseInt(value.toDecString());
        value.init((byte)--i);
    }
}
