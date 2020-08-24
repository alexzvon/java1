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

    public Order(Path file) throws IOException {
        String[] sn = file.getFileName().toString().split("\\.")[0].split("-");

        shopId = sn[0];
        orderId = sn[1];
        customerId = sn[2];
        sum = 0d;

        datetime = LocalDateTime.parse(Files.getLastModifiedTime(file).toString().split("\\.")[0]);

        List<String> lines = Files.readAllLines(file);

        items = new ArrayList<>();

        for (String line: lines) {
            String[] sl = line.split(",");
            OrderItem orderItem = new OrderItem(sl[0], Integer.parseInt(sl[1].trim()), Double.parseDouble(sl[2]));

            items.add(orderItem);

            sum += (double)orderItem.count() * orderItem.price();
        }
    }

//    public String shopId() { return shopId; }
//    public String orderId() { return orderId; }
//    public String customerId() { return customerId; }
//    public LocalDateTime datetime() { return datetime; }
//    public List<OrderItem> items() { return items; }
//    public double sum() { return sum; }

    public static void main(String[] args) {
        String n = "S02-P01X12-0012.csv";
        String[] sname = n.split("\\.")[0].split("-");

        System.out.println(Arrays.toString(sname));
    }

}
