package ru.progwards.java1.lessons.register2;

public class Summator {
    public static void add(Register value1, Register value2) {
        Register vR1 = null;
        Register vR2 = null;

        int iR1;
        int iR2;

        if (value1 instanceof ByteRegister) {
            vR1 = (ByteRegister) value1;
        }
        else if (value1 instanceof IntRegister) {
            vR1 = (IntRegister) value1;
        }

        if (value2 instanceof ByteRegister) {
            vR2 = (ByteRegister) value2;
        }
        else if (value2 instanceof IntRegister) {
            vR2 = (IntRegister) value2;
        }

        if(null != vR1 && null != vR2) {
            iR1 = Integer.parseInt(vR1.toDecString(), 10);
            iR2 = Integer.parseInt(vR2.toDecString(), 10);

            vR1.init(iR1 + iR2);
        }
    }

    public static void sub(Register value1, Register value2) {
        add(value1, toTwosComplement(value2));
    }

    private static Register toTwosComplement(Register value) {
        Register vR = null;
        int v;

        if (value instanceof ByteRegister) {
            vR = (ByteRegister) value;
        }
        else if (value instanceof IntRegister) {
            vR = (IntRegister) value;
        }

        assert vR != null;
        v = Integer.parseInt(vR.toDecString(), 10);
        vR.init(~v);
        Counter.inc(vR);

        return vR;
    }
}
