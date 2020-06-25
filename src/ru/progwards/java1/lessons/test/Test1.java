package ru.progwards.java1.lessons.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {

        Test1 tt = new Test1();
//        tt.scanLines();

        String str = "Буря мглою небо кроет";
        System.out.println(tt.invertWords(str));

        String file = "starts.txt";

        try {
            System.out.println(tt.setStars(file));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public void scanLines() {
        String stop = "/stop";
        String inkl = "";

        try (Scanner scaner = new Scanner(System.in)) {
            while (true) {
                inkl = scaner.nextLine();
                if(inkl.contains(stop)) break;
                if(inkl.contains("Привет")) System.out.println("Здравствуйте!");
                else if(inkl.contains("как дела")) System.out.println("Хорошо");
                else System.out.println(inkl);
            }
        }
    }

    public String invertWords(String sentence) {
        String[] insen;
        insen = sentence.split(" ");
        String[] outsen = new String[insen.length];
        String result;

        int j = 0;
        for (int i = insen.length - 1; i >= 0; i--) {
            outsen[j++] = insen[i];
        }

        result = String.join(".", outsen);

        return result;
    }

    public String setStars(String filename) throws IOException {
        char symbol;
        long pos;
        String result = "";

        try (RandomAccessFile raf = new RandomAccessFile(filename, "rw")){
            for (int i = 1; i < raf.length() + 1; i++) {
                symbol = (char)raf.read();
                System.out.println(i +" (" + (i % 10) + ") -- " + symbol );
                if ((i % 10) == 0) {
                    result += String.valueOf(symbol);
                    pos = raf.getFilePointer() - 1;
                    raf.seek(pos);
                    raf.writeBytes("*");
                }
            }
        } catch (FileNotFoundException e) {
            throw new IOException(String.valueOf(e.getClass()));
        }
        finally {
            return result;
        }
    }
}

//    Реализовать метод с сигнатурой public String setStars(String filename) который читает файл filename
//    и меняет в нем каждый 10-йбайт на символ *, при этом конкатенируя оригинальный символ в строку ответа.
//        В случае ошибки выбросить исключение IOException со строкой сообщения:
//        равной имени класса оригинального сообщения
//
//        Например,при содержимом файла:
//
//        0123456789012345678A012345678B01
//
//        новое содержимое должно быть
//
//        012345678*012345678*012345678*01
//
//        и метод должен вернуть "9AB"








//
//
//    Создайте метод с сигнатурой public void scanLines(), который реализует следующий алгоритм:
//        - вводить с клавиатуры строки, до тех пор, пока во входной строке не встретится "/stop"
//        - если во входной строке содержится "Привет" вывести на консоль "Здравствуйте!"
//        - если во входной строке содержится "как дела" вывести на консоль "Хорошо"
//        - если во входной строке содержится "/stop" - закончить выполнение метода
//        - во всех остальных случая вывести введенную строку на консоль
//
//        Примечание: для проверки, содержит ли строка, содержимое другой строки используйте
//        метод класса String boolean contains(String str)


//    Реализуйте метод с сигнатурой public String invertWords(String sentence),
//    который переставляет слова, в полученной фразе.
//        В качестве исходного разделителя использовать пробел.
//        В качестве соединительного точку.
//
//        Например,
//        invertWords("Буря мглою небо кроет") должен вернуть
//        "кроет.небо.мглою.Буря"