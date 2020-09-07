package ru.progwards.java1.lessons.abstractnum;

public class Test {
    public static void main(String[] args) {
        IntNumber inum = new IntNumber(3);

        Cube cube = new Cube(inum);

        System.out.println(cube.volume());

        Pyramid pyramid = new Pyramid(inum);

        System.out.println(pyramid.volume());

        DoubleNumber dnum = new DoubleNumber(3d);

        Cube dcube = new Cube(dnum);

        System.out.println(dcube.volume());

        Pyramid dpyramid = new Pyramid(dnum);

        System.out.println(dpyramid.volume());

    }
}
