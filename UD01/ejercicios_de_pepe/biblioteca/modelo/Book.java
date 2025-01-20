/*
 * Autor: Pepe Calo
 * Realizado con fines educativos.
 * Puede modificarlo siempre que no lo haga con fines comerciales.
 */
package com.pepinho.programacion.biblioteca.model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

/**
 * @author pepecalo
 */
public class Book implements Serializable {

    //    private static final long serialVersionUID = 1L;
    private Integer idBook;
    private String isbn;
    private String title;
    private String author;
    private Integer ano;
    private Boolean available;
    private byte[] portada;

    private String[] contido;

    private static final long serialVersionUID = 1L;

    public Book() {
    }

    public Book(String title, String author, Integer year, Boolean available) {
        this.title = title;
        this.author = author;
        this.ano = year;
        this.available = available;
    }

    public Book(String isbn, String title, String author, Integer year,
                Boolean available) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.ano = year;
        this.available = available;
    }

    public Book(String isbn, String title, String author, Integer year,
                Boolean available, byte[] portada) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.ano = year;
        this.available = available;
        this.portada = portada;
    }

    public Book(Integer idBook, String isbn, String title, String author,
                Integer year, Boolean available, byte[] portada) {
        this.idBook = idBook;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.ano = year;
        this.available = available;
        this.portada = portada;
    }

    public Integer getIdBook() {
        return idBook;
    }

    public Book setIdBook(Integer idBook) {
        this.idBook = idBook;
        return this;
    }

    public String getIsbn() {
        return isbn;
    }

    public Book setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Book setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public Book setAuthor(String author) {
        this.author = author;
        return this;
    }

    public Integer getYear() {
        return ano;
    }

    public Book setAno(Integer ano) {
        this.ano = ano;
        return this;
    }

    public Boolean isAvailable() {
        return available;
    }

    public Book setAvailable(Boolean available) {
        this.available = available;
        return this;
    }

    public byte[] getCover() {
        return portada;
    }

    public Book setCover(byte[] portada) {
        this.portada = portada;
        return this;
    }

    /**
     * Asigna la portada con flujos, leyendo los bytes.
     *
     * @param f
     */
    public Book setPortada(File f) {
        if (f == null || !f.exists())
            return this;
        Path p = Paths.get(f.getAbsolutePath());
        try (BufferedInputStream bi = new BufferedInputStream(Files.newInputStream(p));
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[4096];
            int bytesLidos;
            while ((bytesLidos = bi.read(buffer)) > 0) {
                outputStream.write(buffer, 0, bytesLidos);
            }

            portada = outputStream.toByteArray();
        } catch (FileNotFoundException ex) {
            System.err.println("Archivo no encontrado: " + ex.getMessage());
        } catch (IOException ex) {
            System.err.println("Erro de E/S: " + ex.getMessage());
        }
        return this;
    }

    /**
     * Asigna la portada con Java NIO, leyendo los bytes.
     *
     * @param file
     */
    public Book setPortada(String file) {
        try {
            Path ruta = Paths.get(file);
            portada = Files.readAllBytes(ruta);
        } catch (IOException ex) {
            System.err.println("Error de E/S: " + ex.getMessage());
        }
        return this;
    }

    public Image getImage() {
        if (portada != null) {
            try (ByteArrayInputStream bis = new ByteArrayInputStream(portada)) {
                return ImageIO.read(bis);
            } catch (IOException e) {
            }
        }
        return null;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.isbn);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Book other = (Book) obj;
        return Objects.equals(this.isbn, other.isbn);
    }

    @Override
    public String toString() {
        return idBook + "] [isbn: " + isbn + "] " + title + ". "
                + author + " (" + ano + ") [" + ((available) ? '*' : ' ') + ']';
    }

}
