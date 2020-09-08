package ru.progwards.java1.lessons.register2;

public class ByteRegister extends Register {
    public Bit[] value = new Bit[8];

    public ByteRegister() {
        for (int i = 0; i < value.length; i++) {
            value[i] = new Bit();
        }
    }

    public ByteRegister(byte value) {
        init(value);
    }

    public void init(byte value) {
        for (int i = 0; i < 8; i++) {
            if (1 == (value & 1)) {
                this.value[ 7 - i ] = new Bit(true);
            }
            else {
                this.value[ 7 - i ] = new Bit();
            }
            value >>= 1;
        }
    }

    @Override
    public String toString() {
        String bs = "";
        for (int i = 0; i < 8; i++) {
            bs += value[i];
        }

        return bs;
    }

    public String toDecString() {
        String znak = "";
        String not_value = "0";
        String result = "";

        if (value[0].toString().equals("1")) {
            znak = "-";

            for (int i = 1; i < value.length; i++) {
                not_value += value[i].toString().equals("1") ? "0" : "1";
            }

            result = znak + String.valueOf(Integer.parseInt(not_value, 2) + 1);
        }
        else {
            result = znak + String.valueOf(Integer.parseInt(toString(), 2));
        }

        return result;
    }
}
