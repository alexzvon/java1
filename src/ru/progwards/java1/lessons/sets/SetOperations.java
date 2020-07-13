package ru.progwards.java1.lessons.sets;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetOperations {

    public static void main(String[] args) {

    }

    public static Set<Integer> union(Set<Integer> set1, Set<Integer> set2) {
        LinkedHashSet<Integer> result = new LinkedHashSet<>(set1);
        result.addAll(set2);
        return result;
    }

    public static Set<Integer> intersection(Set<Integer> set1, Set<Integer> set2) {
        LinkedHashSet<Integer> result = new LinkedHashSet<>(set1);
        result.retainAll(set2);
        return result;
    }

    public static Set<Integer> difference(Set<Integer> set1, Set<Integer> set2) {
        LinkedHashSet<Integer> set3 = new LinkedHashSet<>(intersection(set1, set2));
        LinkedHashSet<Integer> result = new LinkedHashSet<>(set1);
        result.removeAll(set3);
        return result;
    }

    public static Set<Integer> symDifference(Set<Integer> set1, Set<Integer> set2) {
        LinkedHashSet<Integer> result = new LinkedHashSet<>(union(set1, set2));
        LinkedHashSet<Integer> set3 = new LinkedHashSet<>(intersection(set1, set2));
        result.removeAll(set3);
        return result;
    }
}
