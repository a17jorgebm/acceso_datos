package com.pepinho.programacion.biblioteca.model;

import java.sql.Connection;
import java.util.Objects;

/**
 * @autor pepecalo
 * CREATE TABLE PUBLIC.Contido (
 * 	idContido INTEGER NOT NULL AUTO_INCREMENT,
 * 	idBook INTEGER NOT NULL,
 * 	contido CHARACTER LARGE OBJECT,
 * 	CONSTRAINT Contido_PK PRIMARY KEY (idContido),
 * 	CONSTRAINT FK_ID_BOOK FOREIGN KEY (idBook) REFERENCES PUBLIC.Book(idBook) ON DELETE CASCADE ON UPDATE CASCADE
 * );
 * CREATE UNIQUE INDEX PRIMARY_KEY_9 ON PUBLIC.Contido (idContido);
 */
public class Contido {

    private Long idContido;
    private Long idBook;
    private String contido;

    public Contido() {
    }

    public Contido(Long idBook, String contido) {
        this.idBook = idBook;
        this.contido = contido;
    }

    public Contido(Long idContido, Long idBook) {
        this.idContido = idContido;
        this.idBook = idBook;
    }

    public Contido(Long idContido, Long idBook, String contido) {
        this.idContido = idContido;
        this.idBook = idBook;
        this.contido = contido;
    }

    public Long getIdContido() {
        return idContido;
    }

    public void setIdContido(Long idContido) {
        this.idContido = idContido;
    }


    public Long getIdBook() {
        return idBook;
    }

    public void setIdBook(Long idBook) {
        this.idBook = idBook;
    }

    public String getContido() {
        return contido;
    }

    public void setContido(String contido) {
        this.contido = contido;
    }

    @Override
    public int hashCode() {
        return 97 * 7 + Objects.hashCode(this.idContido);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Contido other)) return false;
        return Objects.equals(this.idContido, other.idContido);
    }

    @Override
    public String toString() {
        return idContido + " (" + idBook + "): " + contido;
    }
}
