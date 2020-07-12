import java.util.Arrays;

public class Task2 {
    public static void main(String[] args)
    {
        printJava();
        subtraction(45, 12);
        subtraction(23, 55);
        addition(128, 787);
        addition(528, 387);
        multiplication(124, 87);
        multiplication(1528, 3);
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
}

