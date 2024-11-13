package com.company.StreamsFilesDirectories;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class WordCount {
    public static void main(String[] args) throws IOException {
        Path inPathWords = Paths.get("D:\\Coding projects\\Java\\JavaAdvanced\\src\\FilesAndStreams\\words.txt");
        Path inPathText = Paths.get("D:\\Coding projects\\Java\\JavaAdvanced\\src\\FilesAndStreams\\text.txt");
        Path outPath = Paths.get("D:\\Coding projects\\Java\\JavaAdvanced\\src\\FilesAndStreams\\WordCountOutput.txt");
        BufferedWriter writer = Files.newBufferedWriter(outPath);

        //read words
        Map<String, Integer> countWords = new LinkedHashMap<>();
        List<String> words = Files.readAllLines(inPathWords);
        for (String word : words) {
            Arrays.stream(word.split("\\s+")).forEach(w -> countWords.put(w, 0));
        }
        //read text
        List<String> text = Files.readAllLines(inPathText);
        for (String s : text) {
            Arrays.stream(s.split("\\s+")).forEach(word -> {
                if (countWords.containsKey(word)) {
                    int currentCount = countWords.get(word);
                    countWords.put(word, currentCount + 1);
                }
            });
        }
        countWords.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())).forEach(entry -> {
            try {
                writer.write(entry.getKey() + " - " + entry.getValue() + System.lineSeparator());
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }
}
