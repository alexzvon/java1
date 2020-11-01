package ru;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestC3 {
    //Создайте статический метод с именем from, который принимает параметром массив, обобщающего типа,
// создает новый ArrayList, копирует в него содержимое массива и возвращает ArrayList в качестве
// результата метода.
    public static <T> List<T> from(T[] p) {
//        List<T> list = new ArrayList<>();
//        list = Arrays.asList(p);
        return Arrays.asList(p);
//        return list;
    }




    public static void main(String[] args) {
        Integer[] i = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        from(i).forEach(System.out::println);

    }
}

class TTT<T> {
    enum CompareResult {LESS, EQUAL, GREATER};

    public static <T extends Comparable<T>> CompareResult compare(T a, T b) {

        int result = a.compareTo(b);

        if ( 0 < result ) {
            return CompareResult.GREATER;
        }
        else if ( 0 == result ) {
            return CompareResult.EQUAL;
        }
        else {
            return CompareResult.LESS;
        }
    }

//    public static <T extends Comparable<T>> CompareResult compare(T a, T b) {
//        return switch (a.compareTo(b)) {
//            case 1 -> CompareResult.GREATER;
//            case 0 -> CompareResult.EQUAL;
//            case -1 -> CompareResult.LESS;
//            default -> null;
//        };
//
//    }


//Определен enum CompareResult {LESS, EQUAL, GREATER};
//
//Создайте статический метод с именем compare, который содержит 2 параметра обобщающего типа,
// и сравнивает их через метод compareTo. Метод compare должен возвращать CompareResult, причем
//
//CompareResult.LESS если первый параметр меньше второго
//CompareResult.GREATER если первый параметр больше второго
//CompareResult.EQUAL если первый параметр равен второму


    public static void main(String[] args) {
        System.out.println(compare("Петя", "Вася"));
    }
}


class TT<T> {
    public static <T> void swap(List<T> list, int i1, int i2) {
        T o1 = list.get(i1);
        T o2 = list.get(i2);

        list.set(i1, o2);
        list.set(i2, o1);
    }
}

//Создайте статический метод с именем swap типа  void, который принимает параметром List,
// обобщающего типа, и два int как индексы в списке. Реализовать метод, который меняет
// элементы с указанными индексами местами.




//public class GTest {
//    public  static <T extends Comparable> T getItem(List<? extends Comparable> list, int index) {
//        return list.get(index);
//    }
//}

//public class GTest {
//    public  static <T extends Throwable> T getItem(List<T> list, int index) {
//        try {
//            return list.get(index);
//        } catch (T e) {
//            return null;
//        }
//    }
//}

//public class GTest<T> {
//    public void addAll(List<T> list, T... items) {
//        for (T item: items) {
//            list.add(item);
//        }
//    }
//}

//class GTest<T> {
//    public static T get(List<T> list, int index) {
//        return list.get(index);
//    }
//}

//class GTest<T> {
//    public static <T extends Comparable<T>> GTest<T> from(List<T> list) {
//        GTest<T> result = new GTest<>();
//        //.. do something
//        return result;
//    }
//}

//class GTest<T>{
//    public int myCompare(T a, T b) {
//        return a.compareTo(b);
//    }
//}