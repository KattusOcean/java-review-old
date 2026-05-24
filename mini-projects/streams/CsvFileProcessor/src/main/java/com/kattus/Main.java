package com.kattus;

import com.kattus.Examples.StreamExamples;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    static void main() throws IOException {

        /* ===== EXERCISE ===== */
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/kattus/sample.csv"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/java/com/kattus/streamResult.txt"))) {

            List<String> lines = new ArrayList<>();

            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }

             List<Integer> csvStreamList = lines.stream()
                .filter( (s) -> s.contains(".net"))
                .distinct()
                .limit(8)
                .map(String::length)
                .toList();

            for (Integer i : csvStreamList) {
                bw.write(i.toString());
                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("File or path not found: " + e.getMessage());
        }

        /* ===== EXAMPLES ===== */
//        IOExamples ioExamples = new IOExamples();
//        ioExamples.fileOutputStream();
//        ioExamples.bufferedOutputStream();
//        ioExamples.bufferedWriter();
//
//        StreamExamples streamExamples = new StreamExamples();
//        streamExamples.firstStream();
//        streamExamples.secondStream();
    }
}
