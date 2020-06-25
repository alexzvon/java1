package ru.progwards.java1.lessons.io1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Coder {
    public static void codeFile(String inFileName, String outFileName, char[] code, String logName) {
        String inline;
        String outline = "";
        char symbol;

        try {
            FileReader reader = new FileReader(inFileName);
            FileWriter writer = new FileWriter(outFileName);
            Scanner scanner = new Scanner(reader);

            try {
                while (scanner.hasNextLine()) {
                    inline = scanner.nextLine();
                    if(!inline.equals("")) {
                        for (int i = 0; i < inline.length(); i++) {
                            symbol = inline.charAt(i);
                            outline += String.valueOf(code[(int)symbol]);
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
        catch (IOException e) {
            try {
                FileWriter logFile = new FileWriter(logName);
                try {
                    logFile.write(e.getMessage());
                }
                finally {
                    logFile.close();
                }
            } catch (IOException ioException) {
                System.out.println(ioException.getMessage());
            }
        }
    }
}
