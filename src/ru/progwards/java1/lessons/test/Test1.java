package ru.progwards.java1.lessons.test;

import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        int[] a = {9, 8, 7, 6, 5, 4, 3, 2, 1 };


        System.out.println(a2set(a));

        Set<Integer> iSet = new HashSet<>();
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                iSet.add(i+j);
            }
        System.out.println(iSet.size());

        String TEXT = "на дворе трава на траве дрова не руби дрова на траве двора";
        Set<String> wordSet = new HashSet<>(Arrays.asList(TEXT.split(" ")));

        Iterator<String> iter = wordSet.iterator();
        while (iter.hasNext())
            if (iter.next().contains("ра"))
                iter.remove();

        System.out.println(wordSet.size());


        Set<Integer>  fiboSet1000 =
                Set.of(0, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987);
        int sum = 0;
        for (int i = 2; i < 10; i++)
            sum += fiboSet1000.contains(i) ? 1 : 0;
        System.out.println(sum);

        System.out.println(figDetect(new Square(5.0)));


    }

    static String figDetect(Figure fig) {


//        System.out.println(fig.getClass().getPackageName());
//        System.out.println(fig.getClass());
//        System.out.println(fig.getClass().getSimpleName());
//        System.out.println(fig != null);
//        System.out.println(fig.getClass().getSimpleName().equals("Square"));
//        System.out.println(fig.getClass().getPackageName());



        if(fig != null && fig.getClass().getSimpleName().equals("Square")) {
            Square sq = (Square) fig;
            return "Сторона квадрата " + sq.getSide();
        }
        else if (fig != null && fig.getClass().getSimpleName().equals("Round")) {
            Round rd = (Round) fig;
            return "Диаметр круга " + rd.getDiameter();
        }
        else {
            return "Неизвестная фигура";
        }
    }


    static class Figure {

    }

    static class Square extends Figure {
        private double side;
        public Square(double side) {
            this.side = side;
        }
        public double getSide() {
            return side;
        }
    }

    class Round extends Figure {
        private double diameter;
        public Round(double diameter) {
            this.diameter = diameter;
        }
        public double getDiameter() {
            return diameter;
        }
    }








    public static Set<Integer> a2set(int[] a) {
        Set<Integer> si = new HashSet<>();

        for(int i: a) {
            si.add(i);
        }

        return si;
    }
}

//Правильные ответы:
// Содержит только уникальные элементы,
// Добавление элемента происходит чуть медленнее, чем в список,
// Поиск по ключу происходит значительно быстрее, чем в списке,
// Удаление элемента происходит быстрее, чем в списке



