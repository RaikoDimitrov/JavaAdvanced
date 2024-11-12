package com.company.StreamsFilesDirectories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class SortLines {
    public static void main(String[] args) throws IOException {
        Path input = Paths.get("D:\\Coding projects\\Java\\JavaAdvanced\\src\\FilesAndStreams\\input.txt");
        Path output = Paths.get("D:\\Coding projects\\Java\\JavaAdvanced\\src\\FilesAndStreams\\06.SortLinesOutput.txt");

        List<String> text = Files.readAllLines(input);
        Collections.sort(text);
        Files.write(output, text);

    }
}
