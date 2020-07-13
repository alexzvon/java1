package ru.progwards.java1.lessons.sets;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.TreeSet;

public class LettersInFile {

    public static String process(String fileName) throws IOException {
        TreeSet<String> fStr = new TreeSet<>();
        String result = "";
        RandomAccessFile raf = new RandomAccessFile(fileName, "r");
        try {
            for (long l = 0; l < raf.length(); l++) {
                int c = raf.read();
                if (Character.isAlphabetic(c)) {
                    fStr.add(String.valueOf((char)c));
                }
            }
        }
        finally {
            raf.close();
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

