package ru.progwards.java1.lessons.files;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FilesSelect {
    public void selectFiles(String inFolder, String outFolder, List<String> keys) {
        try {
            for (Map.Entry<String, List<Path>> entry: selectInFolder(inFolder, keys).entrySet()) {
                List<Path> lpath = entry.getValue();
                String key = entry.getKey();
                copyFiles(key, outFolder, lpath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private HashMap<String, List<Path>> selectInFolder(String inFolder, List<String> keys) throws IOException {
        Path inPath = Paths.get(inFolder);
        HashMap<String, List<Path>> inHM = new HashMap<>();

        PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:**/*.txt");

        Files.walkFileTree(inPath, new SimpleFileVisitor<>(){
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (pathMatcher.matches(file)) {
                    for (String key : keys) {
                        if (Files.readString(file).lastIndexOf(key) > -1) {
                            List<Path> lpath;
                            if (inHM.containsKey(key)) {
                                lpath = inHM.get(key);
                            } else {
                                lpath = new ArrayList<>();
                            }

                            lpath.add(file);
                            inHM.put(key, lpath);
                        }
                    }
                }

                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                return FileVisitResult.CONTINUE;
            }
        });

        return inHM;
    }

    private void copyFiles(String key, String outFolder, List<Path> files) throws IOException {
        Path outFile = Paths.get(outFolder, key);

         if (!Files.isDirectory(outFile)) {
             Files.createDirectory(outFile);
         }

        for (Path path: files) {
            Files.copy(path, outFile.resolve(path.getFileName()), StandardCopyOption.REPLACE_EXISTING);
        }
    }

    public static void main(String[] args) {
        String inFolder = "/home/aleksey/leson17/z2/in";
        String outFolder = "/home/aleksey/leson17/z2/out";
        List<String> keys = new ArrayList<>();

        keys.add("find1");
        keys.add("find2");
        keys.add("find3");

        FilesSelect fs = new FilesSelect();

        fs.selectFiles(inFolder, outFolder, keys);
    }
}
