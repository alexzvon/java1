package ru.progwards.java1.lessons.sets;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
import java.util.TreeSet;

public class LettersInFile {

    public static String process(String fileName) throws IOException {
        TreeSet<String> fStr = new TreeSet<>();
        String result = "";
        String inline;
        char symbol;

        FileReader reader = new FileReader(fileName);
        Scanner scanner = new Scanner(reader);

        try {
            while (scanner.hasNextLine()) {
                inline = scanner.nextLine();
                for (int i = 0; i < inline.length(); i++) {
                    symbol = inline.charAt(i);
                    if (Character.isAlphabetic(symbol)) {
                        fStr.add(String.valueOf(symbol));
                    }
                }
            }
        }
        finally {
            reader.close();
        }

        for (String str: fStr) {
            result += str;
        }

        return result;
    }

    public static void main(String[] args){
//        String fileName = "proba.txt";
//
//        try {
//            System.out.println(process(fileName));
//        }
//        catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
    }
}

