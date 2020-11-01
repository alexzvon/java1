package ru.progwards.java2.lessons.basetypes;

import java.util.Iterator;

public class BiDirList<T> implements Iterable<T>{

    class ListItem<T> {
        private T item;

        private ListItem<T> prev;
        private ListItem<T> next;

        public ListItem (T item) {
            this.item = item;
        }

        T getItem(){
            return item;
        }

        void setItem(T item ) {
            this.item = item;
        }

        ListItem<T> getPrev() {
            return prev;
        }

        ListItem<T> getNext() {
            return next;
        }

        void setPrev(ListItem<T> prev) {
            this.prev = prev;
        }

        void setNext(ListItem<T> next) {
            this.next = next;
        }
    }

    private class Itr implements Iterator<T> {
        private ListItem<T> current;

        @Override
        public boolean hasNext() {
            boolean result = false;

            if ( current == null ) {
                if (start != null) {
                    result = start.getNext() != null;
                }
            }
            else {
                result = current.getNext() != null;
            }

            return result;
        }

        @Override
        public T next() {
            if ( current == null ) {
                if ( start != null ) {
                    current = start;
                }
            }
            else {
                current = current.getNext();
            }

            return current != null ? current.getItem() : null;
        }

        @Override
        public void remove() {
            if (current != null ) {
                BiDirList.this.remove(current.getItem());
            }
        }
    }

    private ListItem<T> start;
    private ListItem<T> end;

    private int size = 0;

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    //конструктор из массива
    public static<T> BiDirList<T> from(T[] array) {
        BiDirList<T> bdl = new BiDirList<>();

        if ( array.length > 0 ) {
            for ( T item: array ) {
                bdl.addLast(item);
            }
        }

        return bdl;
    }

    //конструктор из массива
    public static<T> BiDirList<T> of(T...array) {
        BiDirList<T> bdl = new BiDirList<>();

        if ( array.length > 0 ) {
            for ( T item: array ) {
                bdl.addLast(item);
            }
        }

        return bdl;
    }

    //скопировать в массив
    public void toArray(T[] array) {
        ListItem<T> current = start;
        int i = 0;

        while ( current != null ) {
            array[ i++ ] = current.getItem();
            current = current.getNext();
        }
    }

    public ListItem<T> getStart() {
        return start;
    }

    public ListItem<T> getEnd() {
        return end;
    }

    //добавить в конец списка
    public void addLast(T item) {
        ListItem<T> li = new ListItem<>(item);

        if ( start == null ) {
            start = li;
            end = li;
        }
        else {
            li.setPrev(end);
            end.setNext(li);
            end = li;
        }

        size++;
    }

    //добавить в начало списка
    public void addFirst(T item) {
        ListItem<T> li = new ListItem<>(item);

        if ( end == null ) {
            start = li;
            end = li;
        }
        else {
            li.setNext(start);
            start.setPrev(li);
            start = li;
        }

        size++;
    }

    //удалить
    public void remove(T item) {
        ListItem<T> current = start;

        while ( current != null ) {
            if ( item.equals(current.getItem() ) ) {
                if ( current.getPrev() != null ) {
                    current.getPrev().setNext(current.getNext());
                }
                else {
                    start = current.getNext();
                    start.setPrev(null);
                }

                if ( current.getNext() != null ) {
                    current.getNext().setPrev(current.getPrev());
                }
                else {
                    end = current.getPrev();
                    end.setNext(null);
                }
            }
            current = current.getNext();
        }

        size--;
    }

    //получить элемент по индексу
    public T at(int i) {
        T result = null;

        if ( start != null && i >= 0 ) {
            ListItem<T> current = start;
            while ( current != null ) {
                if ( 0 == i-- ) {
                    result = current.getItem();
                    break;
                }
                current = current.getNext();
            }
        }

        return result;
    }

    //получить количество элементов
    public int size() {
        return size;
    }
}
