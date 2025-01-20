package org.example.ejerBLOBsAndEnums;

import jakarta.persistence.*;

@Entity
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic(fetch = FetchType.LAZY)
    @Lob
    private String contenido;
    @Lob
    @Basic(fetch = FetchType.LAZY) //solo se cargan cando se acceden a eles
    private byte[] imagen;

    @Enumerated(EnumType.ORDINAL) // gardarao como id, por orden na que aparezan no enum
    //Enumtype.STRING - garda o string do enum
    private Dia dia;

    public Document() {}

    public Document(String contenido, byte[] imagen) {
        this.contenido = contenido;
        this.imagen = imagen;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public Dia getDia() {
        return dia;
    }

    public void setDia(Dia dia) {
        this.dia = dia;
    }
}
