package ru.progwards.java1.lessons.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

        String normalize = Files.getLastModifiedTime(file).toString().replaceFirst("^(\\d+-\\d+-\\d+T\\d+:\\d+:\\d+).*+", "$1");
        datetime = LocalDateTime.parse(normalize);

        List<String> lines = Files.readAllLines(file);

        items = new ArrayList<>();

        for (String line: lines) {
            String[] sl = line.split(",");

            if (sl.length != 3) continue;
            if (sl[0].trim().length() == 0) continue;
            if (!checkInt(sl[1])) continue;
            if (!checkDouble(sl[2])) continue;

            OrderItem orderItem = new OrderItem();

            orderItem.googsName = sl[0];
            orderItem.count = Integer.parseInt(sl[1].trim());
            orderItem.price = Double.parseDouble(sl[2]);

            items.add(orderItem);

            sum += (double)orderItem.count * orderItem.price;
        }
    }

    private boolean checkInt(String s) {
        if (s.trim().length() == 0) return false;
        for (char c: s.trim().toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        return  true;
    }

    private boolean checkDouble(String s) {
        if (s.trim().length() == 0) return false;
        for (char d : s.trim().toCharArray()) {
            if(!(Character.isDigit(d) || '.' == d)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
    }
}
