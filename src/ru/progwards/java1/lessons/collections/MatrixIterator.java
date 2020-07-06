package ru.progwards.java1.lessons.collections;

import java.util.Iterator;

public class MatrixIterator<T> implements Iterator<T> {
    private int nextIndexM = 0;
    private int[] nextIndexN;
    private int[] size;

    private T[][] array;

    MatrixIterator(T[][] array) {
        this.array = array;

        size = new int[array.length];
        nextIndexN = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            size[i] = array[i].length;
            sum_size += array[i].length;
            nextIndexN[i] = 0;
        }
    }

    @Override
    public boolean hasNext() {

        return SumSize(nextIndexM + );
    }

    @Override
    public T next() {

        return null;
    }

    private int SumSize(int mIndex) {
        int s = 0;

        for (int i = 0; i < mIndex; i++) {
            s += size[i];
        }

        return s;
    }
}


//Сделать итератор MatrixIterator по двумерному массиву (матрице), который разворачивает матрицу в линейную
//последовательность построчно: a[0][0], a[0][1], ...a[0][N],a[1][0], a[1][1]...a[1][N]... a[M][N]


