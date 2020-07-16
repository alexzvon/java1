package ru.progwards.java1.lessons.queues;

public class Order implements Comparable<Order> {
    private static int last_num = 0;

    private final double sum;
    private final int num;
    private final int classOrder;

    public Order(double sum) {
        this.sum = sum;
        this.num = ++last_num;

        classOrder = getClassOrder();
    }

    public double getSum() {
        return sum;
    }

    public int getNum() {
        return num;
    }

    private int getClassOrder() {
        int result;
        if (sum <= 10000) result = 3;
        else if (sum <= 20000) result = 2;
        else result = 1;

        return result;
    }

    @Override
    public int compareTo(Order o) {
        int result = Integer.compare(classOrder, o.classOrder);
        return result == 0 ? Integer.compare(num, o.num) : result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "sum=" + sum +
                ", num=" + num +
                ", classOrder=" + classOrder +
                '}';
    }
}