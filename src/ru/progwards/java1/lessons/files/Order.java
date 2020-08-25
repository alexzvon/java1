package ru.progwards.java1.lessons.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Order {
    public String shopId;
    public String orderId;
    public String customerId;
    public LocalDateTime datetime;
    public List<OrderItem> items;
    public double sum;

    public Order() {}

    public Order(Path file) throws IOException {
        String[] sn = file.getFileName().toString().split("\\.")[0].split("-");

        shopId = sn[0];
        orderId = sn[1];
        customerId = sn[2];
        sum = 0d;

        datetime = LocalDateTime.parse(Files.getLastModifiedTime(file).toString().split("\\.")[0].replace("Z", ""));

        List<String> lines = Files.readAllLines(file);

        items = new ArrayList<>();

        for (String line: lines) {
            String[] sl = line.split(",");

            OrderItem orderItem = new OrderItem();
            orderItem.googsName = sl[0];
            orderItem.count = Integer.parseInt(sl[1].trim());
            orderItem.price = Double.parseDouble(sl[2]);

            items.add(orderItem);

            sum += (double)orderItem.count * orderItem.price;
        }
    }

    public static void main(String[] args) {
        String n = "S02-P01X12-0012.csv";
        String[] sname = n.split("\\.")[0].split("-");

        System.out.println(Arrays.toString(sname));

        String text = "2020-01-16T14:16:16Z";

        System.out.println(text.replace("Z", ""));

    }

}
