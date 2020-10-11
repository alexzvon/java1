package ru.progwards.java2.lessons.recursion;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class AsNumbersSum implements Comparator<List<Integer>>{
    private List<List<Integer>> ssL = new ArrayList<>();

    public void pS( int num, int[] a, int len, int s )
    {
        if(num <= 0)
        {
            AtomicInteger i = new AtomicInteger();
            i.set(0);

            List<Integer> iL = Arrays.stream(a)
                    .boxed()
                    .takeWhile(x -> i.getAndIncrement() < len)
                    .sorted((i1, i2) -> Integer.compare(i2, i1))
                    .collect(Collectors.toList());

            ssL.add(iL);

            return;
        }

        pP(num, a, len, s);
    }

    public void pP (int num, int[] a, int len, int s) {
        if(num < s) {
            return;
        }
        a[ len ] = s;

        pS( num - s , a , len + 1, s );

        s++;

        pP(num, a, len, s);
    }

    @Override
    public int compare(List<Integer> io1, List<Integer> io2) {
        List<Integer> o1 = new ArrayList<>(List.copyOf(io1));
        List<Integer> o2 = new ArrayList<>(List.copyOf(io2));

        int os1 = o1.size();
        int os2 = o2.size();

        if(os1 == 0 && os2 == 0) return 0;

        if ( os1 == 0 ) return -1;
        if ( os2 == 0 ) return 1;

        int r = Integer.compare(o1.get(0), o2.get(0));
        if ( r != 0 ) {
            return r;
        }
        else {
            o1.remove(0);
            o2.remove(0);

            r = compare(o1, o2);
        }

        return r;
    }

    public static String asNumbersSum(int number) {
        int[] a = new int[number];

        if (number == 1) return "1=1";

        AsNumbersSum ans = new AsNumbersSum();

        ans.pS(number, a, 0, 1);
        ans.ssL.sort((o1, o2) -> ans.compare(o2, o1));

        return ans.ssL.stream()
                .map(o -> o.stream()
                        .map(String::valueOf)
                        .reduce((s1, s2) -> s1 + "+" + s2)
                        .orElse(""))
                .reduce((s1, s2) -> s1 + " = " + s2)
                .orElse("");
    }

    public static void main(String[] args) {
        int number = 7;

        System.out.println(asNumbersSum(number));
    }
}
