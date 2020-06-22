package ru.progwards.java1.lessons.bigints;

import java.math.BigInteger;

public class test {
    public static void main(String[] args) {
        ArrayInteger ai1 = new ArrayInteger(8);
        ai1.fromInt(new BigInteger("11996967"));

        ArrayInteger ai2 = new ArrayInteger(5);
        ai2.fromInt(new BigInteger("32882"));

        ai1.add(ai2);

        System.out.println(ai1);
        System.out.println(ai1.toInt());

        System.out.println("==================================================================");

//        ERROR: Тест "Метод AbsInteger add(AbsInteger num1, AbsInteger num2)" не пройден.
//        Метод возвращает неверное значение.
//        Переданы параметры: new ByteInteger(-60), new ShortInteger(1667).
//                Возвращено значение: 71, тип: ByteInteger. Ожидалось: 1607, тип ShortInteger.

    }
}
