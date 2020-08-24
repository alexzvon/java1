package ru.progwards.java1.lessons.files;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDate;
import java.util.*;

public class OrderProcessor {
    final private Path startPath;
    final PathMatcher pathMatcher;
    int count = 0;
    List<Order> listOrder = new ArrayList<>();

    public OrderProcessor(String startPath) {
        this.startPath = Paths.get(startPath);
        pathMatcher = FileSystems.getDefault().getPathMatcher("glob:**/???-??????-????.csv");
    }

    public int loadOrders(LocalDate start, LocalDate finish, String shopId) {
        try {
            Files.walkFileTree(startPath, new SimpleFileVisitor<>(){
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (pathMatcher.matches(file)) {
                        if (checkLDS(start, finish, shopId, file)) {
                            listOrder.add(new Order(file));
                        }
                    }

                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) {
                    count++;
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return count;
    }

    private boolean checkLDS(LocalDate start, LocalDate finish, String shopId, Path file) throws IOException {
        LocalDate date = LocalDate.parse(Files.getLastModifiedTime(file).toString().split("T")[0]);

        if (start != null && start.isAfter(date)) {
            return false;
        }

        if (start != null && finish.isBefore(date)) {
            return false;
        }

        return shopId == null || shopId.equals(file.getFileName().toString().split("\\.")[0].split("-")[0]);
    }

    public List<Order> process(String shopId) {
        List<Order> result = null;

        if (shopId == null) {
            result = new ArrayList<>(listOrder);
        }
        else {
            result = new ArrayList<>();
            for (Order order: listOrder) {
                if (shopId.equals(order.shopId())) {
                    result.add(order);
                }
            }
        }

        result.sort(new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return o1.datetime().compareTo(o2.datetime());
            }
        });

        return result;
    }

    public Map<String, Double> statisticsByShop() {
        double sum;
        Map<String, Double> result = new TreeMap<>();

        for (Order order: listOrder) {
            if (result.containsKey(order.shopId())) {
                sum = result.get(order.shopId());
                sum += order.sum();
                result.put(order.shopId(), sum);
            }
            else {
                result.put(order.shopId(), order.sum());
            }
        }

        return result;
    }

    public Map<String, Double> statisticsByGoods() {
        double sum;
        Map<String, Double> result = new TreeMap<>();

        for (Order order: listOrder) {
            for (OrderItem orderItem: order.items()) {
                if (result.containsKey(orderItem.googsName())) {
                    sum = result.get(orderItem.googsName());
                    sum += (double)orderItem.count() * orderItem.price();
                    result.put(orderItem.googsName(), sum);
                }
                else {
                    sum = (double)orderItem.count() * orderItem.price();
                    result.put(orderItem.googsName(), sum);
                }
            }
        }

        return result;
    }

    public Map<LocalDate, Double> statisticsByDay() {
        double sum;
        LocalDate key;
        Map<LocalDate, Double> result = new TreeMap<>();

        for (Order order: listOrder) {
            key = order.datetime().toLocalDate();
            sum = 0d;
            for (OrderItem orderItem: order.items()) {
                sum += (double)orderItem.count() * orderItem.price();
            }
            if (result.containsKey(key)) {
                sum += result.get(key);
            }
            result.put(key, sum);
        }

        return result;
    }

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
