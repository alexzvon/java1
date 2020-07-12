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
        Iterator<Integer> li = numbers.iterator();
        int[] it = new int[numbers.size()];
        boolean result = true;

        while (li.hasNext()) {
            int llii = li.next();
            if(llii > numbers.size()) {
                result = false;
                break;
            }
            it[llii - 1] = 1;
        }
        if (result) {
            for (int i = 0; i < it.length; i++) {
                if (it[i] == 0) {
                    result = false;
                    break;
                }
            }
        }

        return result;
    }

    public static String findSimilar(Collection<String> names) {
        LinkedList<String> ll = new LinkedList<>(names);
        LinkedList<FindSimilar> fs = new LinkedList<>();

        FindSimilar fF = null;
        FindSimilar nF = null;



        for (ListIterator<String> it_ll = ll.listIterator(0); it_ll.hasNext();) {
            boolean findAdd = true;
            nF = new FindSimilar(it_ll.next(), it_ll.nextIndex());

            if (fF == null) {
                fs.add(nF);
            }
            else if (fF.equals(nF)) {
                for (ListIterator<FindSimilar> it_fs1 = fs.listIterator(0); it_fs1.hasNext();) {
                    if (it_fs1.next().addCol(nF)) {
                        break;
                    }
                }
            }
            else {
                for (ListIterator<FindSimilar> it_fs2 = fs.listIterator(0); it_fs2.hasNext();) {
                    if (it_fs2.next().equals(nF)) {
                        findAdd = false;
                        break;
                    }
                }
                if(findAdd) {
                    fs.add(nF);
                }
            }

            fF = nF;
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

        public boolean addCol(Object o) {
            boolean result = false;
            if (equals(o)) {
                col++;
                result = true;
            }

            return result;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            FindSimilar that = (FindSimilar) o;

            return Objects.equals(name, that.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, index);
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
