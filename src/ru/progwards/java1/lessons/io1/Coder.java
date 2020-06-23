package ru.progwards.java1.lessons.io1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Coder {
    public static void codeFile(String inFileName, String outFileName, char[] code, String logName) {
        short symbol;

        try {
            FileReader reader = new FileReader(inFileName);
            FileWriter writer = new FileWriter(outFileName);
            Scanner scanner = new Scanner(reader);

            try {
                while (scanner.hasNextShort()) {
                    symbol = scanner.nextShort();
                    writer.write(code[(int)symbol]);
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
