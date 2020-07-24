package ru.progwards.java1.lessons.maps;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UsageFrequency {
    private StringBuffer fileText;

    public void processFile(String fileName) {
        FileReader reader = null;
        Scanner scanner;

        fileText = new StringBuffer();

        try {
            reader = new FileReader(fileName);
            scanner = new Scanner(reader);

            while (scanner.hasNextLine()) {
                fileText.append(scanner.nextLine());
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        finally {
            try {
                reader.close();
            }
            catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    Map<Character, Integer> getLetters() {
        Map<Character, Integer> hm = new HashMap<>();
        char c;
        int v;

        for (int i = 0; i < fileText.length(); i++) {
            c = fileText.charAt(i);
            if(Character.isAlphabetic(c) || Character.isDigit(c)) {
                v = hm.getOrDefault(c, 0);
                hm.put(c, ++v);
            }
        }

        return hm;
    }

    Map<String, Integer> getWords() {
        Map<String, Integer> hm = new HashMap<>();
        String s = "";
        char c;
        int v;

        for (int i = 0; i < fileText.length(); i++) {
            c = fileText.charAt(i);
            if(Character.isAlphabetic(c) || Character.isDigit(c)) {
                s += String.valueOf(c);
            }
            else {
                s = s.trim();
                if (!s.equals("")) {
                    v = hm.getOrDefault(s, 0);
                    hm.put(s, ++v);
                }
                s = "";
            }
        }

        return hm;
    }

    public static void main(String[] args) {
        String fileName = "wiki.test.tokens";

        UsageFrequency uf = new UsageFrequency();
        uf.processFile(fileName);

        System.out.println(uf.getLetters());
        System.out.println(uf.getWords());

    }
}
