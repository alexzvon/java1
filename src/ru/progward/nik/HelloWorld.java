package ru.progward.nik;

public class HelloWorld {
    public static void main(String[] args) {
        println("Привет мир!");

        int z = addition(3, 4);

        byte b1 = 0b0111_1011;
        short s1 = 32023;
        int i1 = 65432;
        long l1 = 123456789012345L;
        float f1 = 1.22278F;
        double pi = 3.1415926535;
        double koe = 1.5e7;
        String message = "Запись фильма \"Матрица\" находится в файле C:\\video\\matrix.avi";

        println("3 + 4 = " + z);

        System.out.println(pi);
        System.out.println(koe);

        double y = 5.234 % 2;

        System.out.println(y);

        double num = 1.53;
        Double doub = num;
//        System.out.println(num);
        System.out.println(num - doub.intValue());
    }



    static void println(String str)
    {
        System.out.println(str);
    }

    static int addition(int x, int y)
    {
        return x + y;
    }
}
