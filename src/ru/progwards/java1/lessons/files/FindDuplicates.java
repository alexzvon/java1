package ru.progwards.java1.lessons.files;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class FindDuplicates {

    public List<List<String>> findDuplicates(String startPath) {
        List<List<String>> result = new ArrayList<>();
        List<String> rfd = new LinkedList<>();
        List<FileDuplicat> lfd;

        try {
            for(Map.Entry<Integer, List<FileDuplicat>> entry : listFiles(startPath).entrySet()) {
                lfd = entry.getValue();
                if (lfd.size() > 1) {
                    for (FileDuplicat fd: lfd) {
                        rfd.add(fd.toList());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        result.add(rfd);

        return result;
    }

    public HashMap<Integer, List<FileDuplicat>> listFiles(String startPath) throws IOException {
        Path path = Paths.get(startPath);
        HashMap<Integer, List<FileDuplicat>> hfd = new HashMap<>();

        Files.walkFileTree(path, new SimpleFileVisitor<>(){
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                FileDuplicat fd = new FileDuplicat(file);
                List<FileDuplicat> lpath;
                int hC = fd.hashCode();

                if (hfd.containsKey(hC)) {
                    lpath = hfd.get(hC);
                }
                else {
                    lpath = new ArrayList<>();
                }

                lpath.add(fd);
                hfd.put(hC, lpath);

                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                return FileVisitResult.CONTINUE;
            }
        });

        return hfd;
    }

    class FileDuplicat {
        final private Path path;

        public FileDuplicat(Path path) {
            this.path = path;
        }

        private int hashContext() {
            int result = 0;

            try {
                result = Objects.hash(Files.readString(path));
            } catch (IOException e) {
                e.printStackTrace();
            }

            return result;
        }

        public String toList() {
            return path.toString();
        }

        @Override
        public String toString() {
            return path.getFileName().toString() + " | " + path.getParent().toString();
        }

        @Override
        public boolean equals(Object obj) {
            if(obj == null || getClass() != obj.getClass()) return false;
            FileDuplicat fd = (FileDuplicat) obj;

            return hashCode() == fd.hashCode();
        }

        @Override
        public int hashCode() {
            String hash = null;

            try {
                hash = path.getFileName().toString();
                hash += Files.getAttribute(path, "lastModifiedTime");
                hash += Files.getAttribute(path, "size");
                hash += hashContext();
            }
            catch (IOException e) {
                e.printStackTrace();
            }

            return Objects.hash(hash);
        }
    }

    public static void main(String[] args) {
        String path = "/home/aleksey/leson17";

        FindDuplicates fd = new FindDuplicates();

//        for (List<String> ls: fd.findDuplicates(path)) {
//            for (String str: ls) {
//                System.out.print(str);
//                System.out.print(" | ");
//            }
//            System.out.println("");
//        }
    }

}

