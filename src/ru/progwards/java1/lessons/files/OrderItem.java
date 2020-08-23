package ru.progwards.java1.lessons.files;

public class OrderItem {
    final private String googsName;
    final private int count;
    final private double price;

    public OrderItem(String googsName, int count, double price) {
        this.googsName = googsName;
        this.count = count;
        this.price = price;
    }

    public String googsName() { return googsName; }
    public int count() { return count; }
    public double price() { return price; }
}
