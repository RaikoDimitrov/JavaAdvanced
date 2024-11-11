package com.company.StreamsFilesDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class WriteFile {
    public static void main(String[] args) {
        String input = "D:\\Coding projects\\Java\\JavaAdvanced\\src\\FilesAndStreams\\input.txt";
        String output = "D:\\Coding projects\\Java\\JavaAdvanced\\src\\FilesAndStreams\\02.WriteToFileOutput.txt";
        Set<Character> forbiddenSymbols = new HashSet<>();
        Collections.addAll(forbiddenSymbols, '!', '?', ',', '.');
        try (FileInputStream inputStream = new FileInputStream(input); FileOutputStream outputStream = new FileOutputStream(output)) {
            int oneByte = inputStream.read();
            while (oneByte >= 0) {
                char byteAsChar = (char) oneByte;
                if (!forbiddenSymbols.contains(byteAsChar)) {
                    outputStream.write(byteAsChar);
                    System.out.printf("%s", byteAsChar);
                }
                oneByte = inputStream.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
