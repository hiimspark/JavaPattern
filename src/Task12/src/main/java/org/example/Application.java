package org.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application{

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java -jar yourJarFile.jar <inputFileName> <outputFileName>");
            return;
        }
        SpringApplication.run(Application.class, args);
    }

}