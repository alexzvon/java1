import java.util.Arrays;

public class Task2 {
    enum Grade { VERYBAD, BAD, SATISFACTORILY, GOOD, EXCELLENT, NOTDEFINED };

    public static void main(String[] args)
    {
        printJava();
        subtraction(45, 12);
        subtraction(23, 55);
        addition(128, 787);
        addition(528, 387);
        multiplication(124, 87);
        multiplication(1528, 3);

        System.out.println(addAsStrings(1,2));
        System.out.println(addAsStrings(2,1));


        byte b = 1;
        b <<= 1;
        System.out.println(b);


    }

    static Grade intToGrade(int grade) {
        switch(grade) {
            case 1:
                return Grade.VERYBAD;
            case 2:
                return Grade.BAD;
            case 3:
                return Grade.SATISFACTORILY;
            case 4:
                return Grade.GOOD;
            case 5:
                return Grade.EXCELLENT;
            default:
                return Grade.NOTDEFINED;
        }
    }





    static int addAsStrings(int n1, int n2) {
        String s1 = String.valueOf(n1);
        String s2 = String.valueOf(n2);

        String s = s1 + s2;
        Integer n = Integer.valueOf(s);

        return n.intValue();
    }

    static long factorial(long n) {
        long factorial = 1L;

        for (int i = 0; i < n + 1; i++) {
            if(0 == i) continue;
            factorial *= i;
        }

        return factorial;
    }

    public static void printJava()
    {
        String value1 = "Хорошо идут дела";
        String value2 = "Изучаю Java я!";
        String value3 = " ";

        System.out.println(value1);

        System.out.println(value2);

        System.out.print(value1);
        System.out.print(value3);
        System.out.println(value2);

        System.out.print(value2);
        System.out.print(value3);
        System.out.println(value1);
    }

    public static String textGrade(int grade) {
        final String ZERO = "не оценено";
        final String D1_20 = "очень плохо";
        final String D21_40 = "плохо";
        final String D41_60 = "удовлетворительно";
        final String D61_80 = "хорошо";
        final String D81_100 = "отлично";
        final String INFINITY = "не определено";

        String result = "";

        if (0 == grade) result = ZERO;
        else if (1 <= grade && 20 >= grade) result = D1_20;
        else if (21 <= grade && 40 >= grade) result = D21_40;
        else if (41 <= grade && 60 >= grade) result = D41_60;
        else if (61 <= grade && 80 >= grade) result = D61_80;
        else if (81 <= grade && 100 >= grade) result = D81_100;
        else result = INFINITY;

        return result;

    }

    public static int subtraction(int x, int y)
    {
        System.out.println("Вызвана функция subtraction() с параметрами x = " + x + ", y = " + y);
        return x - y;
    }

    public static int addition(int x, int y)
    {
        System.out.println("Вызвана функция addition() с параметрами x = " + x + ", y = " + y);
        return x + y;
    }

    public static int multiplication(int x, int y)
    {
        System.out.println("Вызвана функция multiplication() с параметрами x = " + x + ", y = " + y);
        return x * y;
    }

    public static void calculation()
    {
        int a = 34;
        int b = 55;
        int c;

        System.out.println("a = " + a);
        System.out.println("b = " + b);

        c = addition(a, b);

        System.out.println("a + b = " + c);

        c = subtraction(a, b);

        System.out.println("a - b = " + c);

        c = multiplication(a, b);

        System.out.println("a * b = " + c);
    }
}
