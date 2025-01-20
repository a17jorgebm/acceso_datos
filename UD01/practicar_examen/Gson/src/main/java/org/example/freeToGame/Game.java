package org.example.freeToGame;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Game {
    private Long id;
    private String title;
    private Image miniatura;
    private String descripcion;
    private String url;
    private String genero;
    private Plataforma plataforma;
    private LocalDate fecha_realizacion;
    private List<Image> capturas_pantallas;

    public Game() {}

    public Game(Long id, String title, String descripcion, String url, String genero, Plataforma plataforma, LocalDate fecha_realizacion) {
        this.id = id;
        this.title = title;
        this.descripcion = descripcion;
        this.url = url;
        this.genero = genero;
        this.plataforma = plataforma;
        this.fecha_realizacion = fecha_realizacion;
    }

    public Game(Long id, List<Image> capturas_pantallas, LocalDate fecha_realizacion, Plataforma plataforma, String genero, String url, String descripcion, Image miniatura, String title) {
        this.id = id;
        this.capturas_pantallas = capturas_pantallas;
        this.fecha_realizacion = fecha_realizacion;
        this.plataforma = plataforma;
        this.genero = genero;
        this.url = url;
        this.descripcion = descripcion;
        this.miniatura = miniatura;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Game{" +
                "\nid=" + id +
                "\n, title='" + title + '\'' +
                "\n, miniatura=" + miniatura +
                "\n, descripcion='" + descripcion + '\'' +
                "\n, url='" + url + '\'' +
                "\n, genero='" + genero + '\'' +
                "\n, plataforma=" + plataforma +
                "\n, fecha_realizacion=" + fecha_realizacion +
                "\n, capturas_pantallas=" + capturas_pantallas +
                '}';
    }

    public void saveInFile() throws IOException {
        Set<Character> invalidChars = new HashSet<>(Arrays.asList('\\', '/', ':', '*', '?', '"', '<', '>', '|'));
        String nombreFicheiro = this.title.chars()
                .mapToObj(c -> (char) c) // Convertir cada int a un char
                .map(c -> (invalidChars.contains(c) || c.equals(' ')) ? '_' : c)// Reemplazar si es inválido
                .map(String::valueOf) // Convertir a String
                .collect(Collectors.joining(""));
        File archivoGardado = new File("src/main/java/org/example/freeToGame/"+nombreFicheiro+".txt");
        try(
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(archivoGardado));
                ){
            bufferedWriter.write(this.toString());
        }
        System.out.println(archivoGardado);
    }

    public Long getId() {
        return id;
    }

    public Game setId(Long id) {
        this.id = id;
        return this;
    }

    public List<Image> getCapturas_pantallas() {
        return capturas_pantallas;
    }

    public Game setCapturas_pantallas(List<Image> capturas_pantallas) {
        this.capturas_pantallas = capturas_pantallas;
        return this;
    }

    public LocalDate getFecha_realizacion() {
        return fecha_realizacion;
    }

    public Game setFecha_realizacion(LocalDate fecha_realizacion) {
        this.fecha_realizacion = fecha_realizacion;
        return this;
    }

    public Plataforma getPlataforma() {
        return plataforma;
    }

    public Game setPlataforma(Plataforma plataforma) {
        this.plataforma = plataforma;
        return this;
    }

    public String getGenero() {
        return genero;
    }

    public Game setGenero(String genero) {
        this.genero = genero;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Game setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Game setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public Image getMiniatura() {
        return miniatura;
    }

    public Game setMiniatura(Image miniatura) {
        this.miniatura = miniatura;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Game setTitle(String title) {
        this.title = title;
        return this;
    }
}
