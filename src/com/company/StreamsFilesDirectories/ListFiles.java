package com.company.StreamsFilesDirectories;

import java.io.File;

public class ListFiles {
    public static void main(String[] args) {
        File file = new File("D:\\Coding projects\\Java\\JavaAdvanced\\src\\FilesAndStreams");

        if (file.exists()) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                assert files != null;
                for (File f : files) {
                    if (!f.isDirectory()) {
                        System.out.printf("%s: [%s]%n", f.getName(), f.length());
                    }
                }
            }
        }
    }
}
