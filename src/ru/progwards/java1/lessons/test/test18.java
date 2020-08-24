package ru.progwards.java1.lessons.test;

import ru.progwards.java1.lessons.files.OrderProcessor;

import java.time.LocalDate;

public class test18 {


    public static void main(String[] args) {
        String startPath = "/home/aleksey/leson17/z3/";

        LocalDate start = LocalDate.parse("2020-08-23");
        LocalDate finish = LocalDate.parse("2020-08-24");
        String shopId = "S02";

        OrderProcessor orderProcessor = new OrderProcessor(startPath);

        System.out.println(orderProcessor.loadOrders(start, finish, shopId));

        System.out.println(orderProcessor.process(shopId));

        System.out.println(orderProcessor.statisticsByShop());

        System.out.println(orderProcessor.statisticsByGoods());

        System.out.println(orderProcessor.statisticsByDay());
    }
}
