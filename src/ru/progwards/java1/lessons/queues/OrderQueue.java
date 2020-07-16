package ru.progwards.java1.lessons.queues;

import java.util.PriorityQueue;

public class OrderQueue {
    private PriorityQueue<Order> pqo = new PriorityQueue<>();

    public void add(Order order) {
        if (order != null) {
            pqo.offer(order);
        }
    }

    public Order get() {
        if (!isEmpty()) return pqo.poll();
        else return null;
    }

    public boolean isEmpty() {
        return pqo.isEmpty();
    }

    public static void main(String[] args) {

    }
}
