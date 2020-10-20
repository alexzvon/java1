package ru.progwards.java2.lessons.generics;

public class DynamicArray<T> {
    private T[] p;

    private int pos;
    private int size;

    /**
     * добавляет элемент в конец массива
     * @param t
     */
    public void add(T t) {
        if ( null == p ) {
            p = (T[]) new Object[ 1 ];
            p[ 0 ] = t;
            size = 1;
            pos = 0;
        }
        else if ( pos + 1 == size ) {
            size *= 2;
            T[] p_copy = (T[]) new Object[ size ];
            System.arraycopy(p, 0, p_copy, 0, p.length);
            p = (T[]) new Object[ size ];
            p_copy[ ++pos ] = t;
            System.arraycopy(p_copy, 0, p, 0, size);
        }
        else {
            p[ ++pos ] = t;
        }
    }

    /**
     * добавляет элемент в заданную позицию позицию массив
     * @param pos
     * @param t
     */
    public void insert(int pos, T t) {
        if ( null == p ) {
            size = 0;
            if ( pos >= size ) for (size = 1; pos >= size; size *= 2);
            p = (T[]) new Object[ size ];
            p[ pos ] = t;
            this.pos = pos;
        }
        else {
            if ( pos >= size ) for (; pos >= size; size *= 2);
            if ( this.pos + 1 == size ) size *= 2;

            T[] p_copy = (T[]) new Object[ size ];
            this.pos++;
            System.arraycopy(p, 0, p_copy, 0, p.length);
            p = (T[]) new Object[ size ];
            System.arraycopy(p_copy, 0, p, 0, pos);
            p[ pos ] = t;
            System.arraycopy(p_copy, pos, p, pos + 1, size - pos - 1);
        }
    }

    /**
     * даляет элемент в позиции pos массива
     * @param pos
     */
    public void remove(int pos) {
        if (null != p && pos <= this.pos) {
            if (size == 1) {
                p = null;
                size = 0;
                this.pos = -1;
            }
            else {
                T[] p_copy = (T[]) new Object[ size ];
                System.arraycopy(p, 0, p_copy, 0, size);
                if (this.pos - 1 < size / 2) size /= 2;
                p = (T[]) new Object[ size ];
                System.arraycopy(p_copy, 0, p, 0, pos);
                System.arraycopy(p_copy, pos + 1, p, pos, this.pos - pos);
                this.pos--;
            }
        }
    }

    /**
     * возвращает элемент по индексу pos
     * @param pos
     * @return
     */
    public T get(int pos) {
        T result = null;
        if (null != p && pos <= this.pos ) {
            result = p[ pos ];
        }

        return result;
    }

    /**
     * возвращает текущий реальный объем массива
     * @return
     */
    public int size() {
        return pos + 1;
    }
}