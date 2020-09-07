package ru.progwards.java1.lessons.abstractnum;

class IntNumber extends Number {
    private int num;

    public IntNumber(int num) {

        this.num = num;
    }

    public Number mul(Number num) {
        IntNumber inum = (IntNumber) num;

        return newNumber(String.valueOf(this.num * inum.num));
    }

    public Number div(Number num) {
        IntNumber inum = (IntNumber) num;

        return newNumber(String.valueOf(this.num / inum.num));
    }

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

    public String toString() {

        return String.valueOf(num);
    }
}
