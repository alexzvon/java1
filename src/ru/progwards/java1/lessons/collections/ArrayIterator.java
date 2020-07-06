package ru.progwards.java1.lessons.collections;

import java.util.Iterator;

public class ArrayIterator<T> implements Iterator<T> {
    private int nextIndex = 0;
    private int size;

    private T[] array;

    ArrayIterator(T[] array) {
        this.array = array;
        size = array.length;
    }

    @Override
    public boolean hasNext() {
        return nextIndex < size;
    }

    @Override
    public T next() {
        if(!hasNext()) {
            nextIndex = 0;
        }
        return array[nextIndex++];
    }
}
