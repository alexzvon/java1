package ru.progwards.java1.lessons.interfaces2;

public class DoubleNumber extends Number {
    private double num;

    public DoubleNumber(double num){
        this.num = num;
    }

    @Override
    public Number mul(Number num) {
        DoubleNumber dnum = (DoubleNumber) num;

        return newNumber(String.valueOf(this.num * dnum.num));
    }

    @Override
    public Number div(Number num) {
        DoubleNumber dnum = (DoubleNumber) num;

        return newNumber(String.valueOf(this.num / dnum.num));
    }

    @Override
    public Number newNumber(String strNum) {
        Double dnum = null;
        if (strNum == null) return null;

        try {
            dnum = Double.parseDouble(strNum);
        }
        catch (Exception e) {
            return null;
        }

        return new DoubleNumber(dnum);
    }

    @Override
    public String toString() {
        return String.valueOf(num);
    }

    @Override
    public int compareTo(Number o) {
        DoubleNumber dn = (DoubleNumber) o;

        return Double.compare(num, dn.num);
    }
}
