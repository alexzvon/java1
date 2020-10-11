package ru.progwards.java1.lessons.abstractnum;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
//        IntNumber inum = new IntNumber(3);
//
//        Cube cube = new Cube(inum);
//
//        System.out.println(cube.volume());
//
//        Pyramid pyramid = new Pyramid(inum);
//
//        System.out.println(pyramid.volume());
//
//        DoubleNumber dnum = new DoubleNumber(3d);
//
//        Cube dcube = new Cube(dnum);
//
//        System.out.println(dcube.volume());
//
//        Pyramid dpyramid = new Pyramid(dnum);
//
//        System.out.println(dpyramid.volume());
//
//
//
//        double d = 943567253453456.2837465d;
//        float f = (float)d;
//
//        System.out.println(f);

        System.out.println("===================================");

        int []a = new int[10];

        String s = "";
        String s1 = "";

    }

    public int sumArrayItems(int[] a) {
        int s = 0;
        for (int i = 0; i < a.length; i++) {
            s += a[i];
        }


        return s;
    }

    enum Grade { VERYBAD, BAD, SATISFACTORILY, GOOD, EXCELLENT, NOTDEFINED };


    static Grade intToGrade(int grade) {
        switch(grade) {
            case 1:
                return Grade.VERYBAD;
            case 2:
                return Grade.BAD;
            case 3:
                return Grade.SATISFACTORILY;
            case 4:
                return Grade.GOOD;
            case 5:
                return Grade.EXCELLENT;
            default:
                return Grade.NOTDEFINED;
        }
    }


}
