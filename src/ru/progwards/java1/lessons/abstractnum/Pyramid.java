package ru.progwards.java1.lessons.abstractnum;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class Pyramid extends Figure3D {

    public Pyramid(Number segment) {
        super(segment);
    }

    @Override
    public Number volume() {
        Number num = null;

        if (segment instanceof DoubleNumber) {
            num = new DoubleNumber(3);
        }
        else if (segment instanceof IntNumber) {
            num = new IntNumber(3);
        }


        return segment.mul(segment.mul(segment)).div(num);
    }
}
