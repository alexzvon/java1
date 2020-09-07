package ru.progwards.java1.lessons.abstractnum;

class DoubleNumber extends Number{
    private double num;

    public DoubleNumber(double num){
        this.num = num;
    }

    public Number mul(Number num) {
        DoubleNumber dnum = (DoubleNumber) num;

        return newNumber(String.valueOf(this.num * dnum.num));
    }

    public Number div(Number num) {
        DoubleNumber dnum = (DoubleNumber) num;

        return newNumber(String.valueOf(this.num / dnum.num));
    }

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

    public String toString() {
        return String.valueOf(num);
    }
}
