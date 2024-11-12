package com.company.StreamsFilesDirectories;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadFile {
    public static void main(String[] args) throws IOException {
        String path = "D:\\Coding projects\\Java\\JavaAdvanced\\src\\FilesAndStreams\\input.txt";
        try (InputStream file = new FileInputStream(path)) {
            int oneByte = file.read();
            while (oneByte >= 0) {
                System.out.printf("%s ", Integer.toBinaryString(oneByte));
                oneByte = file.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
