package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FileConfig {
    @Bean
    public FileHashing fileHashing() {
        String inputFile = "input.txt";
        String outputFile = "output.txt";
        return new FileHashing(inputFile, outputFile);
    }
}