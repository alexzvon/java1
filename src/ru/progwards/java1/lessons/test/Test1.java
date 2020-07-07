package ru.progwards.java1.lessons.test;

import ru.progwards.java1.lessons.bigints.ArrayInteger;
import ru.progwards.java1.lessons.collections.Creator;
import ru.progwards.java1.lessons.collections.Finder;
import ru.progwards.java1.lessons.collections.MatrixIterator;

import java.lang.reflect.Array;
import java.util.*;

public class Test1 {
    public static void main(String[] args) {

        int[] index1;

        Integer[] arr1 = { 1, 2, 3, 4, 5 };
        Integer[] arr2 = { 1, 2, 3, 4, 5, 6, 7 };
        Integer[] arr3 = { 1, 2, 3, 4 };
        Integer[] arr4 = { 1, 2, 3, 4, 5, 6, 7, 8 };
        Integer[] arr5 = { 1, 2, 3, 4, 5, 6 };
        Integer[] arr6 = { 1, 2 };


        Integer[][] arr = { arr1, arr2, arr3, arr4, arr5, arr6 };


        System.out.println(arr.length);


        System.out.println("=================================================================");

        index1 = new int[arr.length];

        for(int i = 0; i < arr.length; i++) {
             index1[i] = arr[i].length;
        }

        System.out.println(Arrays.toString(index1));


        MatrixIterator<Integer> mi = new MatrixIterator<>(arr);

        System.out.println("-------------------------------------------------------------------");

        while (mi.hasNext()) {
            System.out.print(mi.next() + ", ");
        }

        System.out.println("");
        System.out.println("-------------------------------------------------------------------");

        System.out.println(Creator.fillOdd(9));


        System.out.println("-------------------------------------------------------------------");

        System.out.println(Creator.fill3(3));

        System.out.println("-------------------------------------------------------------------");


        Collection<Integer> numbers = new ArrayList<>();

        numbers.add(5);
        numbers.add(3);
        numbers.add(7);
        numbers.add(6);
        numbers.add(2);
        numbers.add(8);
        numbers.add(10);
        numbers.add(18);
        numbers.add(4);
        numbers.add(9);
        numbers.add(13);
        numbers.add(11);
        numbers.add(12);
        numbers.add(15);
        numbers.add(14);
        numbers.add(16);
        numbers.add(17);
        numbers.add(1);

//        5,3,7,6,12,11,11,1,4,15,5,11,12,1,14,6,10,1.

        System.out.println(Finder.findSequence(numbers));

        System.out.println("-------------------------------------------------------------------");


    List<Integer> list = new ArrayList<>();

    for (int i = 0; i < 50; i++) {
        list.add(i);
    }

    ListIterator<Integer> iter3 = list.listIterator();

    iterator3(iter3);

        System.out.println(list);



//        System.out.println(listAction(list));

//        System.out.println(list);
//        System.out.println(filter(list));




    }

    public static List<Integer> listAction(List<Integer> list) {
        list.remove(Collections.min(list));
        list.add(0, list.size());
        list.add(2, Collections.max(list));
        return list;
    }

    static List<Integer> filter(List<Integer> list) {
        int sum = 0;
        List<Integer> rem = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }

        System.out.println(sum);

        for (int i = 0; i < list.size(); i++) {
            if((sum / 100) <= list.get(i)) {
                rem.add(list.get(i));
            }
        }

        System.out.println(rem);

        list.removeAll(rem);

        return list;

    }

    public static  void iterator3(ListIterator<Integer> iterator) {
        while (iterator.hasNext()) {
            Integer index = iterator.nextIndex();
            Integer i = iterator.next();
            if((i % 3) == 0) {
                iterator.set(index);
            }
        }
    }

}

//    Напишите метод с сигнатурой public void iterator3(ListIterator<Integer> iterator) который
//    заменяет значение каждого элемента, которое кратно 3 на значение его индекса.


//    удаляет минимальный элемент коллекции
//    по индексу 0 добавляет число равное количеству элементов
//        по индексу 2 добавляет максимальный элемент из list
//        возвращает list как результат метода


//    Напишите метод, с сигнатурой public List<Integer> filter(List<Integer> list) который работает
//        по следующему алгоритму
//
//        суммирует значения всех элементов списка
//        удаляет из списка элементы, значение которых меньше суммы, деленной на 100
//        (целочисленное деление)
//        возвращает результирующий список