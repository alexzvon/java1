package ru.progwards.java1.lessons.register1;

public class ByteRegister {
    public Bit[] value = new Bit[8];

    public ByteRegister() {
        for (int i = 0; i < value.length; i++) {
            value[i] = new Bit();
        }
    }

    public ByteRegister(byte value) {
        init(value);
//        for (int i = 0; i < 8; i++) {
//            if (1 == (value & 1)) {
//                this.value[ 7 - i ] = new Bit(true);
//            }
//            else {
//                this.value[ 7 - i ] = new Bit();
//            }
//
//            value >>= 1;
//        }
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
        return String.valueOf(Integer.parseInt(toString(), 2));
    }
}
