package com.company.StreamsFilesDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
    public static void main(String[] args) {
        String path = "D:\\Coding projects\\Java\\JavaAdvanced\\src\\FilesAndStreams\\input.txt";
        String output = "D:\\Coding projects\\Java\\JavaAdvanced\\src\\FilesAndStreams\\03.CopyBytesOutput.txt";
        try (FileInputStream inputStream = new FileInputStream(path);
             FileOutputStream outputStream = new FileOutputStream(output)) {
            int oneByte = inputStream.read();

            while (oneByte >= 0) {
                if (oneByte == 10 || oneByte == 32) {
                    outputStream.write(oneByte);
                } else {
                    String text = String.valueOf(oneByte);
                    for (int i = 0; i < text.length(); i++) {
                        outputStream.write(text.charAt(i));
                    }
                }
                oneByte = inputStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
