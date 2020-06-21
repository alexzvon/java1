package ru.progwards.java1.lessons.bigints;

public class test {

    public static void main(String[] args) {

        byte b = 1;
        short s = 2;
        int i = 3;


        ByteInteger bbb = new ByteInteger(b);
        ShortInteger sss = new ShortInteger(s);
        IntInteger iii = new IntInteger(i);


        System.out.println(iii.add(bbb, sss));
        System.out.println(bbb.add(iii, sss));
        System.out.println(sss.add(bbb, iii));


    }



}
