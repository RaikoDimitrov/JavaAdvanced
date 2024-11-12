package com.company.StreamsFilesDirectories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) throws FileNotFoundException {
        String input = "D:\\Coding projects\\Java\\JavaAdvanced\\src\\FilesAndStreams\\input.txt";
        String output = "D:\\Coding projects\\Java\\JavaAdvanced\\src\\FilesAndStreams\\04.ExtractIntegersOutput.txt";
        Scanner read = new Scanner(new FileInputStream(input));
        try (PrintWriter writer = new PrintWriter(output)) {
            while (read.hasNext()) {
                read.next();
                if (read.hasNextInt()) {
                    writer.println(read.nextInt());
                }
            }
        }
    }
}
