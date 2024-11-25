package org.example.ejer1;

import java.awt.*;
import java.io.File;
import java.io.Serializable;
import java.util.Objects;

public class Book implements Serializable {
    private Long idBook;
    private String isbn;
    private String titulo;
    private String autor;
    private Integer anho;
    private Boolean disponible;
    private Byte[] portada;

    public Book() {
    }

    public Book(String isbn, String titulo, String autor, Integer anho, Boolean disponible) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.anho = anho;
        this.disponible = disponible;
    }

    public Book(Long idBook, Byte[] portada, Boolean disponible, Integer anho, String autor, String titulo, String isbn) {
        this.idBook = idBook;
        this.portada = portada;
        this.disponible = disponible;
        this.anho = anho;
        this.autor = autor;
        this.titulo = titulo;
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Book{" +
                "titulo='" + (titulo!=null ? titulo : "*") + '\'' +
                ", autor='" + (autor!=null ? autor : "*") + '\'' +
                ", anho=" + (anho!=null ? anho : "*") +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(isbn, book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(isbn);
    }

    public Long getIdBook() {
        return idBook;
    }

    public Book setIdBook(Long idBook) {
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

    public String getTitulo() {
        return titulo;
    }

    public Book setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public String getAutor() {
        return autor;
    }

    public Book setAutor(String autor) {
        this.autor = autor;
        return this;
    }

    public Integer getAnho() {
        return anho;
    }

    public Book setAnho(Integer anho) {
        this.anho = anho;
        return this;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public Book setDisponible(Boolean disponible) {
        this.disponible = disponible;
        return this;
    }

    public Byte[] getPortada() {
        return portada;
    }

    public Book setPortada(Byte[] portada) {
        this.portada = portada;
        return this;
    }

    public Book setPortada(File f) {
        this.portada = portada;
        return this;
    }

    public Book setPortada(String f) {
        this.portada = portada;
        return this;
    }

    public Image getImage(){

    }
}
