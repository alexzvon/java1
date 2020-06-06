package ru.progwards.java1.lessons.classes;

public class ComplexNum {
    int a;
    int b;

    public ComplexNum(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public String toString() {
        String sa = String.valueOf(a);
        String sb = String.valueOf(b);
        return sa.toString() + "+" + sb.toString() + "i";

    }

    public ComplexNum add(ComplexNum num) {
        int add_d = a + num.a;
        int add_m = b + num.b;

        return new ComplexNum(add_d, add_m);
    }

    public ComplexNum sub(ComplexNum num) {
        int sub_d = a - num.a;
        int sub_m = b - num.b;

        return new ComplexNum(sub_d, sub_m);
    };

    public ComplexNum mul(ComplexNum num) {
        int mul_d = a * num.a - b * num.b;
        int mul_m = b * num.a + a * num.b;

        return new ComplexNum(mul_d, mul_m);
    };

    public ComplexNum div(ComplexNum num) {
        int div_d = (a * num.a + b * num.b) / (num.a * num.a + num.b * num.b);
        int div_m = (b * num.a - a * num.b) / (num.a * num.a + num.b * num.b);

        return new ComplexNum(div_d, div_m);
    };
}
