package ru.progwards.java1.lessons.test;

import java.util.Map;
import java.util.TreeMap;

public class test2 {

    int fillHoles(Map<Integer, String> map, int size) {
        int s = map.size();
        for (int i = 1; i <= size; i++) {
            map.putIfAbsent(i, "Число " + i);
        }
        return map.size() - s;
    }

    void checkAndAdd(TreeMap<Integer, String> map, Integer key, String value) {
        if (map.size() > 1 && !map.containsKey(key) && map.firstKey() < key && map.lastKey() > key) {
            map.put(key, value);
        }
    }

}

//    Реализуйте метод с сигнатурой void checkAndAdd(TreeMap<Integer, String> map, Integer key, String value),
//    который добавляет пару key-value в map при выполнении следующих условий:
//
//        значение с таким key должно отсутствовать
//        значение key долно быть больше головы TreeMap
//        значение key долно быть меньше хвоста TreeMap




//    Создайте метод с сигнатурой int fillHoles(Map<Integer, String> map, int size),
//    который вставляет в HashMap пару <n> "Число n", если она там отсутствует,
//    Проверить от 1 до максимального числа size включительно.
//    Метод возвращает количество добавленных элементов. Пример пары: 1 "Число 1"

