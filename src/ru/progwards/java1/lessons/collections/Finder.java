package ru.progwards.java1.lessons.collections;

import java.util.*;

public class Finder {
    public static void main(String[] args) {
    }

    public static Collection<Integer> findMinSumPair(Collection<Integer> numbers) {
        Collection<Integer> col = new ArrayList<>();
        LinkedList<Integer> ll = new LinkedList<>(numbers);

        int sum = Integer.MAX_VALUE;
        int pos1 = 0;
        int pos2;

        int min1 = Integer.MIN_VALUE;
        int min2;

        int minPos1 = 0;
        int minPos2 = 0;

        for (ListIterator<Integer> it = ll.listIterator(0) ; it.hasNext();) {
            pos2 = it.nextIndex();
            min2 = it.next();

            if (sum > min1 + min2 && pos2 != 0) {
                sum = min1 + min2;

                minPos1 = pos1;
                minPos2 = pos2;
            }
                pos1 = pos2;
                min1 = min2;
        }

        col.add(minPos1);
        col.add(minPos2);

        return col;
    }

    public static Collection<Integer> findLocalMax(Collection<Integer> numbers) {
        Collection<Integer> col = new ArrayList<>();
        LinkedList<Integer> ll = new LinkedList<>(numbers);

        int i1 = Integer.MAX_VALUE;
        int i2 = Integer.MAX_VALUE;
        int i3;

        int pos;

        for (ListIterator<Integer> it = ll.listIterator(0); it.hasNext();) {
            pos = it.nextIndex();
            i3 = it.next();

            if(i2 > i1 && i2 > i3 && pos > 1) {
                col.add(i2);
            }

            i1 = i2;
            i2 = i3;
        }

        return col;
    }

    public static boolean findSequence(Collection<Integer> numbers) {
        LinkedList<Integer> ll = new LinkedList<>(numbers);
        int nm;
        boolean result = true;
        boolean find = true;

        for (ListIterator<Integer> it = ll.listIterator(0); it.hasNext();) {
            nm = it.next();
            find = true;
            for (int i = 1; i <= numbers.size(); i++) {
                if(i == nm) {
                    find = false;
                    break;
                }
            }
            if(find) {
                result = false;
                break;
            }
        }

        return result;
    }

    public static String findSimilar(Collection<String> names) {
        LinkedList<String> ll = new LinkedList<>(names);
        LinkedList<FindSimilar> fs = new LinkedList<>();
        String nextLL;
        long nextPos;

        boolean addCol = false;

        for (ListIterator<String> it_ll = ll.listIterator(0); it_ll.hasNext();) {
            addCol = false;
            nextLL = it_ll.next();
            nextPos = it_ll.nextIndex();
            for (ListIterator<FindSimilar> it_fs = fs.listIterator(0); it_fs.hasNext();) {
                if(it_fs.next().addCol(nextLL)) {
                    addCol = true;
                    break;
                }
            }
            if(!addCol) {
                fs.add(new FindSimilar(nextLL, nextPos));
            }
        }

        fs.sort(FindSimilar::compareTo);

        return fs.getLast().toString();
    }

    static class FindSimilar implements Comparable<FindSimilar> {
        private String name;
        private int col = 1;
        private long index;

        public FindSimilar(String name, long index) {
            this.name = name;
            this.index = index;
        }

        public boolean addCol(String name) {
            boolean result = false;
            if(this.name.equals(name)) {
                this.col++;
                result = true;
            }

            return result;
        }

        @Override
        public int compareTo(FindSimilar o) {
            int result = 0;
            if (Integer.compare(this.col, o.col) == 0) {
                result = Long.compare(o.index, this.index);
            }
            else {
                result = Integer.compare(this.col, o.col);
            }

            return result;
        }

        public String toString() {
            return name + ":" + col;
        }
    }

}
