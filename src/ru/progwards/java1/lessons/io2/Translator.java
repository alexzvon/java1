package ru.progwards.java1.lessons.io2;

import java.util.Scanner;

public class Translator {
    private String[] inLang;
    private String[] outLang;

    Translator(String[] inLang, String[] outLang) {
        this.inLang = inLang;
        this.outLang = outLang;
    }

    public String translate(String sentence) {
        String origin;

        try (Scanner scanner = new Scanner(StringToAlphabetic(sentence)).useDelimiter("\\s+")) {
            while (scanner.hasNext()) {
                origin = scanner.next();
                sentence = sentence.replaceAll(origin, Transfer(origin));
            }
        }

        return sentence;
    }

    //Подготовить
    private String StringToAlphabetic(String inSen) {
        StringBuilder sb = new StringBuilder();

        for (char c : inSen.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                sb.append(c);
            }
            else {
                sb.append(" ");
            }
        }

        return sb.toString().trim();
    }

    //Перевод
    private String Transfer(String origin) {
        String result = origin;

        for (int i = 0; i < inLang.length; i++) {
            if (inLang[i].equals(origin.toLowerCase())) {
                if (Character.isUpperCase(origin.charAt(0))) {
                    result = Character.toUpperCase(outLang[i].charAt(0)) + outLang[i].substring(1);
                }
                else {
                    result = outLang[i];
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        //
    }
}
