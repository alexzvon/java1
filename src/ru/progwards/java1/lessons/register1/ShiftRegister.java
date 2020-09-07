package ru.progwards.java1.lessons.register1;

public class ShiftRegister {
    public static void left(ByteRegister value) {
        int i = Integer.parseInt(value.toDecString(), 10);
        value.init((byte)(i << 1));
    }

    public static void right(ByteRegister value) {
        int i = Integer.parseInt(value.toDecString(), 10);
        value.init((byte)(i >> 1));
    }

}
