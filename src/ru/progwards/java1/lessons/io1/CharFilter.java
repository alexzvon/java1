package ru.progwards.java1.lessons.io1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CharFilter {
    public static void filterFile(String inFileName, String outFileName, String filter) throws IOException {
        char symbol;
        FileReader reader = new FileReader(inFileName);
        FileWriter writer = new FileWriter(outFileName);
        Scanner scanner = new Scanner(reader);

        try {
            while (scanner.hasNextShort()) {
                symbol = (char)scanner.nextShort();
                for (int i = 0; i < filter.length(); i++) {
                    if (symbol == filter.charAt(i)) break;
                    writer.write(symbol);
                }
            }
        }
        finally {
            reader.close();
            writer.close();
        }
    }
}
