package ru.progwards.java1.lessons.sets;

public class Product implements Comparable<Product> {
    private String code;

    public Product(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    @Override
    public int compareTo(Product o) {
        return code.compareTo(o.getCode());
    }

    @Override
    public String toString() {
        return code;
    }
}
