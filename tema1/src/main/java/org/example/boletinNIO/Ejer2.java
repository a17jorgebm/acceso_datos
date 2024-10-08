package org.example.boletinNIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Ejer2 {
    public static void main(String[] args) throws IOException {
        Path file= Path.of("data","kk");
        if (!Files.exists(file)){ Files.createDirectories(file); }
        Path arquivo=file.resolve("arquivo.txt");
        if (!Files.exists(arquivo)){ Files.createFile(arquivo); }
    }
}
