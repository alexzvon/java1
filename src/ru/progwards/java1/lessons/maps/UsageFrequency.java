package ru.progwards.java1.lessons.maps;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UsageFrequency {
    private StringBuffer fileText = new StringBuffer();

    public void processFile(String fileName) throws IOException {
        FileReader reader = new FileReader(fileName);
        Scanner scanner = new Scanner(reader);

        try {
            while (scanner.hasNextLine()) {
                fileText.append(scanner.nextLine());
            }
        }
        finally {
            reader.close();
        }
    }

    Map<Character, Integer> getLetters() {
        Map<Character, Integer> hm = new HashMap<>();
        char c;
        int v;

        for (int i = 0; i < fileText.length(); i++) {
            c = fileText.charAt(i);
            if(Character.isAlphabetic(c)) {
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
            if(Character.isAlphabetic(c)) {
                s += String.valueOf(c);
            }
            else {
                if (!s.equals("")) {
                    v = hm.getOrDefault(s, 0);
                    hm.put(s, ++v);
                    s = "";
                }
            }
        }

        return hm;
    }

    public static void main(String[] args) {

    }
}
