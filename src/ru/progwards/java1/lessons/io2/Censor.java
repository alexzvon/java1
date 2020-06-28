package ru.progwards.java1.lessons.io2;

import java.io.RandomAccessFile;

public class Censor {

    public static void main(String[] args) {
        //
    }

    public static void censorFile(String inoutFileName, String[] obscene) throws Throwable {
        StringBuilder sb = new StringBuilder();
        long pos;

        try {
            RandomAccessFile raf = new RandomAccessFile(inoutFileName, "rw");
            try {
                for (long l = 0; l < raf.length(); l++) {
                    int c = raf.read();
                    if (!Character.isAlphabetic(c)) {

                        for (int i = 0; i < obscene.length; i++) {
                            if(obscene[i].equals(sb.toString())) {
                                pos = raf.getFilePointer();
                                pos -= (long)obscene[i].length() + 1;
                                raf.seek(pos);
                                for (int j = 0; j < obscene[i].length(); j++) {
                                    raf.write(42);
                                }
                                pos = raf.getFilePointer();
                                raf.seek(pos + 1);
                                break;
                            }
                        }

                        sb.delete(0, sb.length());
                    }
                    else {
                        sb.append((char)c);
                    }
                }
            }
            catch (Throwable exception) {
                throw new CensorException(exception.getMessage(), inoutFileName);
            }
            finally {
                raf.close();
            }
        }
        catch (Throwable exception) {
            throw new CensorException(exception.getMessage(), inoutFileName);
        }
    }

    public static class CensorException extends Throwable {
        String mesExc;
        String fileName;

        public CensorException(String mesExc, String fileName) {
            this.mesExc = mesExc;
            this.fileName = fileName;
        }

        @Override
        public String toString() {
            return fileName + ":" + mesExc;
        }
    }
}

