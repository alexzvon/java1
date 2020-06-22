package ru.progwards.java1.lessons.bigints;

import java.math.BigInteger;
import java.util.Arrays;

public class ArrayInteger {
    byte[] digits;

    public ArrayInteger(int n) {
        this.digits = new byte[n];
    }

    public static class DByteArray {
        private byte[] a;

        public int length() {
            return a.length;
        }

        public void add(byte num) {
            if(null == a) {
                a = new byte[1];
                a[0] = num;
            }
            else {
                byte[] a_copy = new byte[a.length];
                System.arraycopy(a, 0, a_copy, 0, a.length);
                a = new byte[a_copy.length + 1];
                System.arraycopy(a_copy, 0, a, 0, a_copy.length);
                a[a.length - 1] = num;
            }
        }

        public void atDelete(int pos) {
            if(null == a || pos > a.length) {
                return;
            }
            else {
                byte[] a_copy = new byte[a.length];
                System.arraycopy(a, 0, a_copy, 0, a.length);
                if(0 < a_copy.length - 1) {
                    a = new byte[a_copy.length - 1];
                    System.arraycopy(a_copy, 0, a, 0, pos);
                    System.arraycopy(a_copy, pos + 1, a, pos, a_copy.length - pos - 1);
                }
                else {
                    a= null;
                }
            }
        }

        public byte at(int pos) {
            return a[pos];
        }
    }

    void fromInt(BigInteger value) {
        String s = value.toString();
        int start = 0;

        if (s.length() > digits.length) {
            start = digits.length;
        }
        else {
            start = s.length();
        }

        for (int i = 0; i < s.length() && i < digits.length; i++) {
            digits[i] = Byte.valueOf(String.valueOf(s.charAt(start - i - 1)));
        }
    }

    BigInteger toInt() {
        String s = "";
        for (byte b: digits) {
            s = String.valueOf(b) + s;
        }

        return new BigInteger(s);
    }

    boolean add(ArrayInteger num) {
        byte[] bA;
        byte[] mA;
        byte ten = 0;
        byte tenPrev = 0;
        byte one = 0;
        int length;
        DByteArray arrByteObj = new DByteArray();
        boolean result = true;

        //Большую длинну
        if (num.digits.length > digits.length) {
            bA = num.digits;
            mA = digits;
        }
        else {
            bA = digits;
            mA = num.digits;
        }

        //Сумма
        for (int i = 0; i < bA.length; i++) {
            if(i < mA.length) {
                ten = (byte)((bA[i] + mA[i] + tenPrev) / 10);
                one = (byte)((bA[i] + mA[i] + tenPrev) - (ten * 10));
                arrByteObj.add(one);
                tenPrev = ten;
                ten = 0;
                one = 0;
            }
            else {
                ten = (byte)((bA[i] + tenPrev) / 10);
                one = (byte)((bA[i] + tenPrev) - (ten * 10));
                arrByteObj.add(one);
                tenPrev = ten;
                ten = 0;
                one = 0;
            }
        }
        if (0 < tenPrev) arrByteObj.add(tenPrev);

        //Убрать нули
        length = arrByteObj.length();
        for (int i = length - 1; i > 0; i--) {
            if (0 == arrByteObj.at(i)) {
                arrByteObj.atDelete(i);
            }
            else {
                break;
            }
        }

        //результат
        length = arrByteObj.length();
        if (length > digits.length) {
            result = false;
            for (int i = 0; i < digits.length; i++) {
                digits[i] = 0;
            }
        }
        else {
            for (int i = 0; i < length; i++) {
                digits[i] = arrByteObj.at(i);
            }
        }

        return result;
    }

    @Override
    public String toString() {
        return Arrays.toString(digits);
    }
}
