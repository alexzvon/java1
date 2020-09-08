package ru.progwards.java1.lessons.register2;

public class ShiftRegister {
    public static void left(Register value) {
        if (value instanceof ByteRegister) {
            ByteRegister byteValue = (ByteRegister) value;
            int i = Integer.parseInt(byteValue.toDecString());
            byteValue.init((byte)(i << 1));
        }
        else if (value instanceof IntRegister) {
            IntRegister intValue = (IntRegister) value;
            int i = Integer.parseInt(intValue.toDecString());
            intValue.init(i << 1);
        }
    }

    public static void right(Register value) {
        if (value instanceof ByteRegister) {
            ByteRegister byteValue = (ByteRegister) value;
            int i = Integer.parseInt(byteValue.toDecString());
            byteValue.init((byte)(i >> 1));
        }
        else if (value instanceof IntRegister) {
            IntRegister intValue = (IntRegister) value;
            int i = Integer.parseInt(intValue.toDecString());
            intValue.init(i >> 1);
        }
    }
}
