package ru.progwards.java1.lessons.collections;

import java.util.Iterator;

public class MatrixIterator<T> implements Iterator<T> {
    private int nextIndex = 0;
    private int[] size;
    private int sum_size = 0;

    private T[][] array;

    public MatrixIterator(T[][] array) {
        this.array = array;
        size = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            size[i] = array[i].length;
            sum_size += array[i].length;
        }
    }

    @Override
    public boolean hasNext() {
        return nextIndex < sum_size;
    }

    @Override
    public T next() {
        if(!hasNext()) {
            nextIndex = 0;
        }

        return ArrayIndex(nextIndex++);
    }

    private T ArrayIndex(int index) {
        int ss = 0;
        int mi = 0;
        int ni = 0;
        for (int i = 0; i < size.length; i++) {
            ss += size[i];
            if(index < ss) {
                mi = i;
                ni = index - ss + size[i];
                break;
            }
        }

        return array[mi][ni];
    }
}
