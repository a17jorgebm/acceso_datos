package org.example.boletinNIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
a) Escribid un programa en Java que, empleando las clases de Java NIO 2, liste los
archivos de un directorio por medio del método list(). Debe mostrar sólo los
archivos fuente Java, no los directorios que contiene. Recuerda el uso de filtros en
Stream y de forEach.
 */
public class Ejer3 {
    public static void main(String[] args) throws IOException {
        Path directorio= Paths.get("src","main","java","org","example");
        Files.list(directorio)
                .filter(d -> Files.isRegularFile(d))
                .filter(d -> {
                    String[] partes=d.getFileName().toString().split("\\.");
                    String extension=partes[partes.length-1];
                    return extension.equals("java");
                }).forEach(d->System.out.println(d.getFileName()));
    }
}
