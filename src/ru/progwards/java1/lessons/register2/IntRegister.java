package ru.progwards.java1.lessons.register2;

import ru.progwards.java1.lessons.register1.Bit;

public class IntRegister extends Register {
    public Bit[] value;

    public IntRegister() {
        value = new Bit[32];
        for (int i = 0; i < value.length; i++) {
            value[i] = new Bit();
        }
    }

    public IntRegister(int value) {
        this.value = new Bit[32];
        init(value);
    }

    public void init(int value) {
        for (int i = 0; i < 32; i++) {
            if (1 == (value & 1)) {
                this.value[ 31 - i ] = new Bit(true);
            }
            else {
                this.value[ 31 - i ] = new Bit();
            }

            value >>= 1;
        }
    }

    @Override
    public String toString() {
        String is = "";
        for (int i = 0; i < 32; i++) {
            is += value[i];
        }

        return is;
    }

    @Override
    public String toDecString() {
        String znak = "";
        String not_value = "0";
        String result = "";

        if (value[0].toString().equals("1")) {
            znak = "-";

            for (int i = 1; i < 32; i++) {
                not_value += value[i].toString().equals("1") ? "0" : "1";
            }

            result = znak + String.valueOf(Integer.parseInt(not_value, 2) + 1);
        }
        else {
            result = znak + String.valueOf(Integer.parseInt(toString(), 2));
        }

        return result;
    }

    public static void main(String[] args) {
        int i1 = 1253;
        int i2 = -1253;

        IntRegister ir1 = new IntRegister(i1);
        IntRegister ir2 = new IntRegister(i2);

        System.out.println(ir1);
        System.out.println(ir2);

        System.out.println(ir1.toDecString());
        System.out.println(ir2.toDecString());

    }
}

