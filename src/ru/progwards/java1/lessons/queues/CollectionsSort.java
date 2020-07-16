package ru.progwards.java1.lessons.queues;

import java.util.*;

public class CollectionsSort {
    static final int COUNT_ELEM = 1000;
    public static void main(String[] args) {
        System.out.println(compareSort());
    }

    public static void mySort(Collection<Integer> data) {
        List<Integer> li = new ArrayList<>(data);

        for (int i = 1; i < li.size(); i++) {
            for (int j = 0; j < li.size(); j++) {
                if(li.get(i) < li.get(j)) {
                    Collections.swap(li, i, j);
                }
            }
        }

        data.clear();
        data.addAll(li);
    }

    public static void minSort(Collection<Integer> data) {
        Collection<Integer> cdata = new ArrayList<>();
        Integer obj;

        while (!data.isEmpty()) {
            obj = Collections.min(data);
            cdata.add(obj);
            data.remove(obj);
        }

        data.addAll(cdata);
    }

    public static void collSort(Collection<Integer> data) {
        List<Integer> ldata = new ArrayList<>(data);
        Collections.sort(ldata);
        data.clear();
        data.addAll(ldata);
    }

    public static Collection<String> compareSort() {
        List<Integer> ld = new ArrayList<>(COUNT_ELEM);
        Collection<Integer> data = new ArrayList<>(COUNT_ELEM);
        List<TimeSort> ts = new ArrayList<>(3);
        Collection<String> result = new ArrayList<>(3);

        long start = 0;

        for (int i = 0; i < COUNT_ELEM; i++) {
            ld.add(i);
        }

        Collections.shuffle(ld);

        data.addAll(ld);
        start = System.currentTimeMillis();
        mySort(data);
        ts.add(new TimeSort("mySort", System.currentTimeMillis() - start));

        data.clear();
        data.addAll(ld);
        start = System.currentTimeMillis();
        minSort(data);
        ts.add(new TimeSort("minSort", System.currentTimeMillis() - start));

        data.clear();
        data.addAll(ld);
        start = System.currentTimeMillis();
        collSort(data);
        ts.add(new TimeSort("collSort", System.currentTimeMillis() - start));

        Collections.sort(ts);

        for (TimeSort n: ts) {
            result.add(n.getName());
        }

        return result;
    }

    public static class TimeSort implements Comparable<TimeSort> {
        private final long time;
        private final String name;

        public TimeSort(String name, long time) {
            this.name = name;
            this.time = time;
        }

        @Override
        public int compareTo(TimeSort o) {
            int result = Long.compare(time, o.time);
            return result == 0 ? name.compareTo(o.getName()) : result;
        }

        @Override
        public String toString() {
            return "'" + name + " -- " + time + "'";
        }

        public String getName() {
            return name;
        }
    }
}
