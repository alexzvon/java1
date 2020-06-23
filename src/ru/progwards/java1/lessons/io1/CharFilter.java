package ru.progwards.java1.lessons.io1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CharFilter {
    public static void filterFile(String inFileName, String outFileName, String filter) throws IOException {
        String inline;
        String outline = "";
        char symbol;
        boolean find = false;
        FileReader reader = new FileReader(inFileName);
        FileWriter writer = new FileWriter(outFileName);
        Scanner scanner = new Scanner(reader);

        try {
            while (scanner.hasNextLine()) {
                inline = scanner.nextLine();
                if(!inline.equals("")) {
                    for (int i = 0; i < inline.length(); i++) {
                        symbol = inline.charAt(i);
                        find = false;
                        for (int j = 0; j < filter.length(); j++) {
                            if(symbol == filter.charAt(j)) {
                                find = true;
                                break;
                            }
                        }
                        if(!find) {
                            outline += String.valueOf(symbol);
                        }
                    }
                    writer.write(outline);
                    outline = "";
                }
            }
        }
        finally {
            reader.close();
            writer.close();
        }
    }
}
