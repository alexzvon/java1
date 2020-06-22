package ru.progwards.java1.lessons.bigints;

public abstract class AbsInteger {

    public abstract int getMax_Value();

    static AbsInteger add(AbsInteger num1, AbsInteger num2) {
        int bI1 = (int)Integer.valueOf(num1.toString());
        int bI2 = (int)Integer.valueOf(num2.toString());
        int max;

        if(num1.getMax_Value() > num2.getMax_Value()) {
            max = num1.getMax_Value();
        }
        else {
            max = num2.getMax_Value();
        }

        switch(max) {
            case 127:
                return new ByteInteger((byte)(bI1 + bI2));
            case 32767:
                return new ShortInteger((short)(bI1 + bI2));
            case 2147483647:
                return new IntInteger(bI1 + bI2);
            default:
                return null;
        }
    }
}
