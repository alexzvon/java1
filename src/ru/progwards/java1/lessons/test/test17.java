package ru.progwards.java1.lessons.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class test17 {

    public static void main(String[] args) {


        String name = "tmp865";

        System.out.println(createFolder(name));

        name = "proba.txt";

        System.out.println(replaceF(name));

    }

    public static String createFolder(String name) {
        Path path = Paths.get(Paths.get("").toAbsolutePath().toString());      //.resolve(name);
        File file = new File(path.resolve(name).toAbsolutePath().toString());

        file.mkdir();

//        Path path = Paths.get("").resolve(name);
//        return String.valueOf(path.toAbsolutePath());
        return path.getParent().toString();
    }


    public static boolean replaceF(String name) {
        Path path = Paths.get("").resolve(name);

        try {
            String context = Files.readString(path);
            String new_context = "";
            String c;
            for (int i = 0; i < context.length(); i++) {
                c = String.valueOf(context.charAt(i));
                if(c.equals("F")) {
                    new_context += "f";
                }
                else {
                    new_context += c;
                }
            }

            Files.writeString(path, new_context);

        } catch (IOException e) {
            return false;
        }

        return true;
    }



//    Реализовать метод с сигнатурой boolean replaceF(String name) который заменяет в файле все F на f,
//    в случае ошибки вернуть false. Для реализации пользоваться методами java.nio.file.Files.


}
