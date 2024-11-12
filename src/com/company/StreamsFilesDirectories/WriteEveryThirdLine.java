package com.company.StreamsFilesDirectories;

import java.io.*;

public class WriteEveryThirdLine {
    public static void main(String[] args) {
        String path = "D:\\Coding projects\\Java\\JavaAdvanced\\src\\FilesAndStreams\\input.txt";
        String output = "D:\\Coding projects\\Java\\JavaAdvanced\\src\\FilesAndStreams\\05.WriteEveryThirdLineOutput.txt";

        try (BufferedReader read = new BufferedReader(new FileReader(path));
             BufferedWriter writer = new BufferedWriter(new FileWriter(output))) {
            int counter = 1;
            String line = read.readLine();
            while (line != null) {
                if (counter % 3 == 0) {
                    writer.write(line);
                    writer.newLine();
                }
                counter++;
                line = read.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
