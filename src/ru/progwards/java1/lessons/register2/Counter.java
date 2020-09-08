package ru.progwards.java1.lessons.register2;

public class Counter {
    public static void inc(Register value) {
        if (value instanceof ByteRegister) {
            ByteRegister byteValue = (ByteRegister) value;
            int i = Integer.parseInt(byteValue.toDecString());
            byteValue.init((byte) ++i);
        }
        else if (value instanceof IntRegister) {
            IntRegister intValue = (IntRegister) value;
            int i = Integer.parseInt(intValue.toDecString());
            intValue.init(++i);
        }
    }

    public static void dec(Register value) {
        if (value instanceof ByteRegister) {
            ByteRegister byteValue = (ByteRegister) value;
            int i = Integer.parseInt(byteValue.toDecString());
            byteValue.init((byte) --i);
        }
        else if (value instanceof IntRegister) {
            IntRegister intValue = (IntRegister) value;
            int i = Integer.parseInt(intValue.toDecString());
            intValue.init(--i);
        }
    }
}
