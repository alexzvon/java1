package ru.progwards.java1.lessons.register1;

public class Summator {
    public static boolean add(ByteRegister value1, ByteRegister value2) {
        int i1 = Integer.parseInt(value1.toDecString());
        int i2 = Integer.parseInt(value2.toDecString());

        value1.init((byte)(i1 + i2));

        return 255 >= (i1 + i2);
    }
}
