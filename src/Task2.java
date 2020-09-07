import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;

public class Task2 {

    static String swapWords(String sentance) {
        StringTokenizer tokenizer = new StringTokenizer(sentance, " .,-!\n");
        String result = "";

        while (tokenizer.hasMoreTokens()) {
            if (1 < tokenizer.countTokens()) {
                String s2 = tokenizer.nextToken();
                String s1 = tokenizer.nextToken();

                result += s1 + " ";
                result += s2 + " ";
            }
            else if (0 < tokenizer.countTokens()) {
                result += tokenizer.nextToken();
            }
        }

        return result.trim();
    }


//    swapWords("Убитых словом, добивают молчанием. (c) Уильям Шекспир.")
//    словом Убитых молчанием добивают Уильям (c) Шекспир




//Создайте метод с сигнатурой String swapWords(String sentance),
// который возвращает слова фразы из sentence через одно,
// начиная с первого, через пробел в виде строки. Разделители " .,-!\n"
//
//Например, слова фразы "Слово - серебро, молчание - золото!"
// должны быть преобразованы в  "серебро Слово золото молчание"

    public static void main(String[] args)
    {

        Locale dLocale = new Locale.Builder().setLanguage("ru").setScript("Cyrl").build();

        System.out.format(dLocale, "|%,10.2f|",200000.001);




        String sentance = "Слово - серебро, молчание - золото!";

        System.out.println(swapWords("Убитых словом, добивают молчанием. (c) Уильям Шекспир."));
        System.out.println(swapWords(sentance));


//        String txt =
//                "StringTokenizer - этот класс, " +
//                        "нам строку разобьёт на раз.";
//        StringTokenizer tokenizer = new StringTokenizer(txt, " .,");
//        while (tokenizer.hasMoreTokens())
//            System.out.print(tokenizer.nextToken());




//        printJava();
//        subtraction(45, 12);
//        subtraction(23, 55);
//        addition(128, 787);
//        addition(528, 387);
//        multiplication(124, 87);
//        multiplication(1528, 3);
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

