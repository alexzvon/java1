package ru;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Testj2c2 {

    void sortAndPrint(List<Person> list) {
        list.sort(Comparator.comparing(x->x.age));
        list.forEach(System.out::println);
    }



    String reverseChars(String str) {
        if (str.length() == 1) {
            return str;
        }
        if (str.length() < 1) {
            return "";
        }

        String r = reverseChars(str.substring(1, str.length()));
        r += str.substring(0, 1);

        return r;
    }


    public static void main(String[] args) {
        List<Person> pL = new ArrayList<>();
        Testj2c2 tt = new Testj2c2();

        pL.add(new Person("Vasa", 30));
        pL.add(new Person("Misha", 43));
        pL.add(new Person("Vita", 23));

        tt.sortAndPrint(pL);



        String str = "12345";

        System.out.println(tt.reverseChars(str));

    }

    static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String toString() {
            return name + " " + age;
        }
    }

}

//    Syntax Error(s)
//  /var/www/html/jobe/application/libraries/../../runguard/runguard: warning: timelimit exceeded (wall time): aborting command
//  /var/www/html/jobe/application/libraries/../../runguard/runguard: warning: command terminated with signal 9




