package ru.progwards.java1.lessons.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class Order {
    public boolean check = true;
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

        long ms = Files.getLastModifiedTime(file).toMillis();
        datetime = LocalDateTime.ofInstant(Instant.ofEpochMilli(ms), ZoneId.systemDefault());

        List<String> lines = Files.readAllLines(file);

        items = new ArrayList<>();

        for (String line: lines) {
            if (!checkLine(line)) {
                check = false;
                break;
            }

            String[] sl = line.split(",");

            OrderItem orderItem = new OrderItem();

            orderItem.googsName = sl[0];
            orderItem.count = Integer.parseInt(sl[1].trim());
            orderItem.price = Double.parseDouble(sl[2]);

            items.add(orderItem);

            sum += (double)orderItem.count * orderItem.price;
        }
    }

    private boolean checkLine(String line) {
        boolean result = true;

        String[] sl = line.split(",");

        if (sl.length != 3 || sl[0].trim().length() == 0 || !checkInt(sl[1]) || !checkDouble(sl[2])) {
            result = false;
        }

        return result;
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
