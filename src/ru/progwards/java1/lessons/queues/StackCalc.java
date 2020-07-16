package ru.progwards.java1.lessons.queues;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackCalc {
    private Deque<Double> stackDD = new ArrayDeque<>();
    public void push(double value) {
        stackDD.push(value);
    }

    public double pop() {
        return stackDD.pop();
    }

    public void add() {
        push(pop() + pop());
    }

    public void sub() {
        double pop = pop();
        push(pop() - pop);
    }

    public void mul() {
        push(pop() * pop());
    }

    public void div() {
        double pop = pop();
        push(pop() / pop);
    }
}

//Стековый калькулятор (есть даже такой стековый язык программирования - Forth).
//Стек, это структура данных, работающая по принципу LIFO - last in first out
//(последний вошедший выходит первый), это противоположность привычной очереди
//FIFO - first in first out - первый вошедший выходит первый

//Реализовать class StackCalc, который содержит стек чисел с плавающей точкой (double).
//Выбрать наиболее удобную для этого коллекцию. Реализовать методы работы со стеком:

//3.1 public void push(double value) - положить value на вершину стека
//3.2 public double pop() - взять (убрать) значение с вершины стека
//3.3 public void add() - сложить 2 верхних значения на стеке, результат положить на стек.
// В итогу в стеке должно быть на один элемент меньше
//3.4 public void sub() - вычесть верхнее значение на стеке, из следующего по глубине,
// результат положить на стек. В итоге в стеке должно быть на один элемент меньше
//3.5 public void mul() - умножить 2 верхних значения на стеке, результат положить на стек.
// В итогу в стеке должно быть на один элемент меньше
//3.6 public void div() - поделить на верхнее значение на стеке, следующее по глубине,
// результат положить на стек. В итоге в стеке должно быть на один элемент меньше
//
//Class Calculate, который содержит методы:
//
//3.7 public static double calculation1(), возвращающую результат вычисления следующей формулы:
//2.2*(3+12.1), используя класс StackCalc
//3.8 public static double calculation2(), возвращающую результат вычисления следующей формулы:
//(737.22+24)/(55.6-12.1)+(19-3.33)*(87+2*(13.001-9.2)), используя класс StackCalc
