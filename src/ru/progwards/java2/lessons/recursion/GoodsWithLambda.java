package ru.progwards.java2.lessons.recursion;

import java.time.Instant;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GoodsWithLambda {
    Optional<List<Goods>> goodsList;

    public void setGoods(List<Goods> list) {
        goodsList = Optional.ofNullable(list);
    }

    public List<Goods> sortByName(){
        return NotNullFilter().sorted(Comparator.comparing(x->x.name)).collect(Collectors.toList());
    }

    public List<Goods> sortByNumber(){
        return NotNullFilter().sorted(Comparator.comparing(x->x.number.toUpperCase())).collect(Collectors.toList());
    }

    public List<Goods> sortByPartNumber() {
        return NotNullFilter().sorted(Comparator.comparing(x->x.number.substring(0, 3).toUpperCase())).collect(Collectors.toList());
    }

    public List<Goods> sortByAvailabilityAndNumber() {
        Comparator<Goods> goodsComparator = ((o1, o2) -> {
            if (o1.available == o2.available) {
                return o1.number.toUpperCase().compareTo(o2.number.toUpperCase());
            }
            else {
                return Integer.compare(o1.available, o2.available);
            }
        });

        return NotNullFilter().sorted(goodsComparator).collect(Collectors.toList());
    }

    public List<Goods> expiredAfter(Instant date) {
        return NotNullFilter().filter(x -> date.isAfter(x.expired)).collect(Collectors.toList());
    }

    public List<Goods> сountLess(int count) {
        return NotNullFilter().filter(x -> x.available < count).sorted(Comparator.comparing(x -> x.available)).collect(Collectors.toList());
    }

    public List<Goods> сountBetween(int count1, int count2) {
        Predicate<Goods> pr1 = x -> x.available < count2;
        Predicate<Goods> pr2 = x -> x.available > count1;
        return NotNullFilter().filter(pr1.and(pr2)).sorted(Comparator.comparing(x -> x.available)).collect(Collectors.toList());
    }

    private Stream<Goods> NotNullFilter() {
        return goodsList.orElse(new ArrayList<>()).stream().filter(Objects::nonNull);
    }
}
