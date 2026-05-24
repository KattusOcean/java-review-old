package com.kattus.Examples;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamExamples {
    public void firstStream() {
        List<String> countries = new ArrayList<>();
        countries.add("Spain");
        countries.add("United States");
        countries.add("United States");
        countries.add("Colombia");
        countries.add("Portugal");
        countries.add("United States");
        countries.add("Japan");
        countries.add("Russia");
        countries.add("Brazil");

        System.out.println("=== STREAM 1 ===");
        // Acts like a conveyor, for each '.' or filter, test, ... The element gets discarded or continues
        // through the conveyor to the next filter
        countries.stream()
                .filter((country) -> country.length() > 6)
                .distinct()
                .filter((country) -> country.startsWith("U"))
                .map( (country) -> country.toUpperCase())
                .forEach(System.out::println);


        System.out.println("\n===STREAM 2 ===");
        countries.stream()
                .filter((country) -> country.length() > 6)
                .distinct()
                .map( (country) -> country.length())
                .forEach(System.out::println);
    }

    public void secondStream() throws IOException {
        try (Stream<Path> fs = Files.list(Paths.get("."))) {
            long total = fs
                    .peek(p -> System.out.println(p.getFileName()))
                    .map(Path::toFile).mapToLong(File::length)
                    .sum();
            System.out.println(total);
        }
    }
}
