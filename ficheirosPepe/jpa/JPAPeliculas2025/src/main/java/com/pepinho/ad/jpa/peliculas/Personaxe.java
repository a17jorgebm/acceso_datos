package com.pepinho.ad.jpa.peliculas;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;


@Entity
public class Personaxe {
    @Id
    private Long idPersonaxe;
    private String importancia;
    private String nome;
    private String nomeOrdenado;
    private String nomeOrixinal;
    private String sexo;
    private LocalDateTime dataNacemento;
    private String paisNacemento;
    private String cidadeNacemento;
    private LocalDateTime dataDefuncion;
    private String paisDefuncion;
    private String cidadeDefuncion;
    private String estudio;
    private String bio;
    @Lob
    private String texto;
    @Lob
    private String textoFilmografia;
    private String revisado;

    @OneToMany(mappedBy = "personaxe")
    @Basic(fetch = FetchType.LAZY)
    private List<PeliculaPersonaxe> peliculas;

    public Personaxe() {
    }

    public Personaxe(Long idPersonaxe, String importancia, String nome, String nomeOrdenado, String nomeOrixinal, String sexo, LocalDateTime dataNacemento, String paisNacemento, String cidadeNacemento, LocalDateTime dataDefuncion, String paisDefuncion, String cidadeDefuncion, String estudio, String bio, String texto, String textoFilmografia, String revisado) {
        this.idPersonaxe = idPersonaxe;
        this.importancia = importancia;
        this.nome = nome;
        this.nomeOrdenado = nomeOrdenado;
        this.nomeOrixinal = nomeOrixinal;
        this.sexo = sexo;
        this.dataNacemento = dataNacemento;
        this.paisNacemento = paisNacemento;
        this.cidadeNacemento = cidadeNacemento;
        this.dataDefuncion = dataDefuncion;
        this.paisDefuncion = paisDefuncion;
        this.cidadeDefuncion = cidadeDefuncion;
        this.estudio = estudio;
        this.bio = bio;
        this.texto = texto;
        this.textoFilmografia = textoFilmografia;
        this.revisado = revisado;
    }

    public Long getIdPersonaxe() {
        return idPersonaxe;
    }

    public void setIdPersonaxe(Long idPersonaxe) {
        this.idPersonaxe = idPersonaxe;
    }

    public String getImportancia() {
        return importancia;
    }

    public void setImportancia(String importancia) {
        this.importancia = importancia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeOrdenado() {
        return nomeOrdenado;
    }

    public void setNomeOrdenado(String nomeOrdenado) {
        this.nomeOrdenado = nomeOrdenado;
    }

    public String getNomeOrixinal() {
        return nomeOrixinal;
    }

    public void setNomeOrixinal(String nomeOrixinal) {
        this.nomeOrixinal = nomeOrixinal;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public LocalDateTime getDataNacemento() {
        return dataNacemento;
    }

    public void setDataNacemento(LocalDateTime dataNacemento) {
        this.dataNacemento = dataNacemento;
    }

    public String getPaisNacemento() {
        return paisNacemento;
    }

    public void setPaisNacemento(String paisNacemento) {
        this.paisNacemento = paisNacemento;
    }

    public String getCidadeNacemento() {
        return cidadeNacemento;
    }

    public void setCidadeNacemento(String cidadeNacemento) {
        this.cidadeNacemento = cidadeNacemento;
    }

    public LocalDateTime getDataDefuncion() {
        return dataDefuncion;
    }

    public void setDataDefuncion(LocalDateTime dataDefuncion) {
        this.dataDefuncion = dataDefuncion;
    }

    public String getPaisDefuncion() {
        return paisDefuncion;
    }

    public void setPaisDefuncion(String paisDefuncion) {
        this.paisDefuncion = paisDefuncion;
    }

    public String getCidadeDefuncion() {
        return cidadeDefuncion;
    }

    public void setCidadeDefuncion(String cidadeDefuncion) {
        this.cidadeDefuncion = cidadeDefuncion;
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getTextoFilmografia() {
        return textoFilmografia;
    }

    public void setTextoFilmografia(String textoFilmografia) {
        this.textoFilmografia = textoFilmografia;
    }

    public String getRevisado() {
        return revisado;
    }

    public void setRevisado(String revisado) {
        this.revisado = revisado;
    }

    public List<PeliculaPersonaxe> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(List<PeliculaPersonaxe> peliculas) {
        this.peliculas = peliculas;
    }

    @Override
    public String toString() {
        return '[' + idPersonaxe +
                ", " + nome + ", " + nomeOrdenado +
                ", " + nomeOrixinal + '\'' +
                ", " + dataNacemento;
    }
}
