package ru.progwards.java2.lessons.generics;

import java.util.ArrayList;
import java.util.List;

public class FruitBox<E extends Fruit> extends ArrayList<E> implements Comparable<FruitBox> {

    /**
     *
     * @param o
     * @return
     */
    @Override
    public boolean add(E o) {
        if ( !isEmpty() ) {
            if ( get(0).getClass().equals( o.getClass() ) ) {
                return super.add(o);
            }
            else {
                return false;
            }
        }

        return super.add(o);
    }

    /**
     * высчитывает вес коробки
     * @return
     */
    public float getWeight() {
        float result = 0.0f;

        if ( !isEmpty() ) {
            result = get(0).getWeight() * size();
        }

        return result;
    }

    /**
     * позволяет пересыпать фрукты из текущей коробки в другую
     * @param box
     * @throws UnsupportedOperationException
     */
    public void moveTo(List<E> box) throws UnsupportedOperationException {
        if ( !isEmpty() ) {
            if ( null == box) box = new FruitBox<>();

            if ( !box.isEmpty() ) {
                if ( box.get(0).getClass().equals( get(0).getClass() ) ) {
                    box.addAll(this);
                    clear();
                }
            }
            else {
                box.addAll(this);
                clear();
            }
        }
    }

    /**
     * сравнить текущую коробку с переданной
     * @param box
     * @return
     */
    @Override
    public int compareTo(FruitBox box) {
        if ( !box.isEmpty() ) {
            return Float.compare( getWeight(), box.getWeight() );
        }

        return 0;
    }

    public static void main(String[] args) {
        FruitBox<Apple> af = new FruitBox<>();
        FruitBox<Orange> of = new FruitBox<>();

//        FruitBox<Fruit> af = new FruitBox<>();
//        FruitBox<Fruit> of = new FruitBox<>();

        Apple apple = new Apple();
        Orange orange = new Orange();

        af.add(apple);
        af.add(apple);
        af.add(apple);
        af.add(apple);
        af.add(apple);
        af.add(apple);
        af.add(apple);
        af.add(apple);

        of.add(orange);
        of.add(orange);
        of.add(orange);
        of.add(orange);
        of.add(orange);
        of.add(orange);
        of.add(orange);
        of.add(orange);
        of.add(orange);

        System.out.println(af.compareTo(of));
    }
}
