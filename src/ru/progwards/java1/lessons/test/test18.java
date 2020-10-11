package ru.progwards.java1.lessons.test;

import ru.progwards.java1.lessons.files.OrderProcessor;

import java.time.LocalDate;
import java.util.function.Predicate;

public class test18 {

    static String reverseChars(String str){
        if(str.length() <= 1) return str;
        System.out.print(str.charAt(str.length() - 1));
        return reverseChars(str.substring(0, str.length() - 1));
    }

    

    public static void main(String[] args) {
        Predicate<Integer> isEven = x -> x % 2 == 0;

        System.out.println(isEven.test(5));
        System.out.println(isEven.test(10));

        System.out.println(isEven.negate().test(5));
        System.out.println(isEven.negate().test(10));


        String str = "12345";

        System.out.println("============================================");

        reverseChars(str);

//        System.out.println(str);
//        System.out.println(str.charAt(str.length() - 1));
//
//        str = str.substring(0, str.length() - 1);
//
//
//        System.out.println(str);
//        System.out.println(str.charAt(str.length() - 1));




//        String startPath = "/home/aleksey/leson17/z3/";
//
//        LocalDate start = LocalDate.parse("2020-08-23");
//        LocalDate finish = LocalDate.parse("2020-08-24");
//        String shopId = "S02";
//
//        OrderProcessor orderProcessor = new OrderProcessor(startPath);
//
//        System.out.println(orderProcessor.loadOrders(start, finish, shopId));
//
//        System.out.println(orderProcessor.process(shopId));
//
//        System.out.println(orderProcessor.statisticsByShop());
//
//        System.out.println(orderProcessor.statisticsByGoods());
//
//        System.out.println(orderProcessor.statisticsByDay());
    }
}
