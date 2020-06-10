package ru.progwards.java1.lessons.bitsworld;

public class Binary {
    byte num;

    public static void main(String[] args) {
        //
    }

    public Binary(byte num) {
        this.num = num;
    }

    public String toString() {
        byte t = num;
        String result = "";
        for (int i = 0; i < 8; i++) {
            if (1 == (t & 0b0000_0001)) {
                result = "1" + result;
            }
            else {
                result = "0" + result;
            }
            t >>= 1;
        }
        return result;
    }
}
