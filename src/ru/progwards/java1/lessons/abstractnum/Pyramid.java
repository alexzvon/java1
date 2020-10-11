package ru.progwards.java1.lessons.abstractnum;

class Pyramid extends Figure3D {

    public Pyramid(Number segment) {
        super(segment);
    }

    @Override
    public Number volume() {
//        Number num = null;
//
//        if (segment instanceof DoubleNumber) {
//            num = new DoubleNumber(3);
//        }
//        else if (segment instanceof IntNumber) {
//            num = new IntNumber(3);
//        }


//        return segment.mul(segment.mul(segment)).div(num);
        return segment.mul(segment).mul(segment).div(segment.newNumber("3"));
    }
}
