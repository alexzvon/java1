package ru.progwards.java2.lessons.generics;

import java.util.ArrayList;
import java.util.List;

public class FruitBox<E extends Fruit> extends ArrayList<E> implements Comparable<List<E>> {

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
    public int compareTo(List<E> box) {
        if ( !box.isEmpty() ) {
            return Float.compare(get(0).getWeight() * size(), box.get(0).getWeight() * box.size() );
        }

        return 0;
    }
}
