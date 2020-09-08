package ru.progwards.java1.lessons.interfaces2;

public class IntNumber extends Number {
    private int num;

    public IntNumber(int num) {
        this.num = num;
    }

    @Override
    public Number mul(Number num) {
        IntNumber inum = (IntNumber) num;

        return newNumber(String.valueOf(this.num * inum.num));
    }

    @Override
    public Number div(Number num) {
        IntNumber inum = (IntNumber) num;

        return newNumber(String.valueOf(this.num / inum.num));
    }

    @Override
    public Number newNumber(String strNum) {
        if (strNum == null) return null;
        strNum = strNum.trim();
        for (Character c: strNum.toCharArray()) {
            if (-1 == Character.digit(c, 10 )) {
                return null;
            }
        }

        return new IntNumber(Integer.parseInt(strNum));
    }

    @Override
    public String toString() {

        return String.valueOf(num);
    }

    @Override
    public int compareTo(Number o) {
        IntNumber num_o = (IntNumber) o;
        return Integer.compare(num, num_o.num);
    }
}
