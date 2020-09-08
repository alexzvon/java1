package ru.progwards.java1.lessons.egts;

public class EgtsDirectionAndSpeed {
    public static int getSpeed(short speedAndDir) {
        short con = 0b01111111_11111111;
        speedAndDir &= con;

        return (int)speedAndDir;
    }

    public static int getDirection(byte dirLow, short speedAndDir) {
        int con = 0b00000000_00000000_00000000_11111111;
        int csh = 0b00000000_00000000_10000000_00000000;
        int d = (int) dirLow;
        int s = (int) speedAndDir;

        d &= con;
        s &= csh;
        s >>= 7;

        return d | s;
    }
}
