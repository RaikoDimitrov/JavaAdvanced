package com.company.StreamsFilesDirectories;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class CountCharTypes {
    public static void main(String[] args) throws IOException {
        Path input = Paths.get("D:\\Coding projects\\Java\\JavaAdvanced\\src\\FilesAndStreams\\input.txt");
        Path output = Paths.get("D:\\Coding projects\\Java\\JavaAdvanced\\src\\FilesAndStreams\\CountCharTypeOutput.txt");
        Map<String, Integer> counts = new LinkedHashMap<>();
        counts.put("Vowels", 0);
        counts.put("Consonants", 0);
        counts.put("Punctuation", 0);
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'o', 'u', 'i'));
        Set<Character> punctuation = new HashSet<>(Arrays.asList('!', '?', '.', ','));

        BufferedWriter writer = new BufferedWriter(new FileWriter(String.valueOf(output)));
        try {
            List<String> lines = Files.readAllLines(input);
            for (String text : lines) {
                for (int i = 0; i < text.length(); i++) {
                    if (vowels.contains(text.charAt(i))) {
                        counts.put("Vowels", counts.get("Vowels") + 1);
                    } else if (punctuation.contains(text.charAt(i))) {
                        counts.put("Punctuation", counts.get("Punctuation") + 1);
                    } else if (text.charAt(i) != ' '){
                        counts.put("Consonants", counts.get("Consonants") + 1);
                    }
                }
            }
            writer.write("Vowels: " + counts.get("Vowels") + System.lineSeparator()
                    + "Consonants: " + counts.get("Consonants") + System.lineSeparator()
                    + "Punctuation: " + counts.get("Punctuation") + System.lineSeparator());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
