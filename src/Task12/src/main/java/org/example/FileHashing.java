package org.example;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Controller
@AllArgsConstructor
public class FileHashing {
    private String inputFile;
    private String outputFile;

    @PostConstruct
    public void hashFile() {
        try {
            File input = new File(inputFile);
            if (!input.exists()) {
                File output = new File(outputFile);
                try (FileOutputStream fos = new FileOutputStream(output)) {
                    fos.write("null".getBytes());
                }
                return;
            }

            MessageDigest md = MessageDigest.getInstance("SHA-256");
            try (FileInputStream fis = new FileInputStream(input)) {
                byte[] buffer = new byte[8192];
                int length;
                while ((length = fis.read(buffer)) != -1) {
                    md.update(buffer, 0, length);
                }
            }

            byte[] hashBytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }

            File output = new File(outputFile);
            try (FileOutputStream fos = new FileOutputStream(output)) {
                fos.write(sb.toString().getBytes());
            }

            input.delete();
        } catch (NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
        }
    }

    @PreDestroy
    public void cleanUpInput() {
        File input = new File(inputFile);
        if (input.exists()) {
            input.delete();
        }
    }
}
