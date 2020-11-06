package ru.progwards.java2.lessons.basetypes;

import java.util.Iterator;

public class DoubleHashTable<K extends HashValue, V> implements Iterable<V> {

    class Its implements Iterator<V> {
        DoubleHashItem<K, V> current;

        @Override
        public boolean hasNext() {
            DoubleHashItem<K, V> result = null;
            
            if ( current == null ) {
                if ( start != null ) {
                    result = start;
                }
            }
            else {
                result = current;
            }

            return result != null && (result.getNext() != null);
        }

        @Override
        public V next() {
            V result = null;

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

        }
    }

    @Override
    public Iterator<V> iterator() {
        return new Its();
    }

    class DoubleHashItem<K extends HashValue, V> {
        private K key;
        private V item;
        private DoubleHashItem<K, V> next;
        private DoubleHashItem<K, V> prev;
        private boolean remote = false;

        public DoubleHashItem (K key, V item) {
            this.key = key;
            this.item = item;

        }

        public V getItem() {
            return item;
        }

        public K getKey() {
            return key;
        }

        public DoubleHashItem<K, V> getPrev() {
            return prev;
        }

        public void setPrev(DoubleHashItem<K, V> prev) {
            this.prev = prev;
        }

        public DoubleHashItem<K, V> getNext() {
            return next;
        }

        public void setNext(DoubleHashItem<K, V> next) {
            this.next = next;
        }

        public boolean getRemote() {
            return remote;
        }

        public void setRemote() {
            remote = true;
        }


        @Override
        public String toString() {
            return "DoubleHashItem{" +
                    "key=" + key +
                    ", item=" + item +
                    ", next=" + (next != null ? next.getItem() : "null") +
                    ", prev=" + (prev != null ? prev.getItem() : "null") +
                    ", remote=" + remote +
                    '}';
        }
    }

    private int initialCapacity = 101;
    private float loadFactor = 100f;
    private float colise = 10f;
    private int size;

    DoubleHashItem<K, V>[] table;
    DoubleHashItem<K, V> start;
    DoubleHashItem<K, V> end;

    public DoubleHashTable() {
        table = (DoubleHashItem<K,V>[])new DoubleHashItem[initialCapacity];
    }

    public int size() {
        return size;
    }

    public void add(K key, V item) {
        int index = getHashDivision(key);
        boolean add = false;
        DoubleHashItem<K, V> newDHI = new DoubleHashItem<>(key, item);

        if ( table[ index ] == null || table[ index ].getRemote() ) {
            table[ index ] = newDHI;
            add = true;
        }
        else {
            int step = getHashMultiply(key);
            step = step == 0 ? 1 : step;

            int colise = (int)(initialCapacity / 100 * this.colise);
            for (int i = 0; i <= colise; i++) {
                index = tableIndexInc(index, step);

                if ( table[ index ] == null || table[ index ].getRemote() ) {
                    table[ index ] = newDHI;
                    add = true;
                    break;
                }
            }

            if ( !add ) {
                resize();
                add(key, item);
            }
        }

        addIts(newDHI);
    }

    public void remove(K key) {
        DoubleHashItem<K, V> result = null;

        result = getIts(key);

        if ( result != null ) {
            result.setRemote();
            removeIts(result);
        }
    }

    public void change(K key1, K key2) {
        table = (DoubleHashItem<K,V>[])new DoubleHashItem[initialCapacity];
        end = null;
        size = 0;

        DoubleHashItem<K, V> current = start;
        while ( current != null ) {
            if ( current.getKey().equals(key1) ) {
                add(key2, current.getItem());
            }
            else {
                add(current.getKey(), current.getItem());
            }
            current = current.getNext();
        }
    }

    public V get(K key) {
        DoubleHashItem<K, V> result = null;

        result = getIts(key);

        return result != null ? result.getItem() : null;
    }

    private void resize() {
        initialCapacity = (int)(initialCapacity + (initialCapacity / 100 * loadFactor));

        table = (DoubleHashItem<K,V>[])new DoubleHashItem[initialCapacity];
        end = null;
        size = 0;

        DoubleHashItem<K, V> current = start;
        while ( current != null ) {
            add(current.getKey(), current.getItem());
            current = current.getNext();
        }
    }

    private DoubleHashItem<K, V> getIts(K key) {
        DoubleHashItem<K, V> result = null;
        int index = getHashDivision(key);

        if ( table[ index ] != null  ) {
            if ( table[ index ].getKey().equals(key) ) {
                if ( !table[index].getRemote() ) {
                    result = table[ index ];
                }
            } else {
                int step = getHashMultiply(key);
                step = step == 0 ? 1 : step;

                while ( table[ index ] != null ) {
                    if ( table[ index ].getKey().equals(key) ) {
                        if ( !table[ index ].getRemote() ) {
                            result = table[ index ];
                            break;
                        }
                    }

                    index = tableIndexInc(index, step);
                }
            }
        }

        return result;
    }

    private void removeIts(DoubleHashItem<K, V> newDHI) {
        newDHI.getPrev().setNext(newDHI.getNext());
        newDHI.getNext().setPrev(newDHI.getPrev());
    }

    private void addIts(DoubleHashItem<K, V> newDHI) {
        if ( size == 0 ) {
            start = newDHI;
        }
        else if ( end == null ) {
            end = newDHI;
            start.setNext(end);
            end.setPrev(start);
        }
        else {
            newDHI.setPrev(end);
            end.setNext(newDHI);
            end = newDHI;
        }

        size++;
    }

    private int getHashMultiply( K key ) {
        double d = 0.6180339887D + key.getHash();
        return (int)(table.length * (d - Math.floor(d)));
    }

    private int getHashDivision( K key ) {
        return key.getHash() % table.length;
    }

    private int tableIndexInc(int prev, int step) {
        return (prev + step) > (table.length - 1) ? (prev + step) - (table.length - 1) : prev + step;
    }
}
