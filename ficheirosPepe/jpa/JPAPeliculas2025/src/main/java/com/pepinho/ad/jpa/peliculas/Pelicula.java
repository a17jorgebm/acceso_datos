package com.pepinho.ad.jpa.peliculas;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Pelicula {
    @Id
    private Long idPelicula;
    @Column(length = 50)
    private String musica;
    @Column(length = 125)
    private String orixinal;
    @Column(length = 125)
    private String ingles;
    @Column(length = 125)
    private String castelan;
    @Column(length = 50)
    @Convert(converter = XeneroConverter.class)
    private Xenero xenero;
    private Short anoInicio;
    private Short anoFin;
    @ManyToOne
    @JoinColumn(name = "pais")
    private Pais pais;
    private Short duracion;
    @Column(length = 25)
    private String outrasDuracions;
    @Convert(converter = CorConverter.class)
    @Column(length = 12)
    private Cor cor;
    private String son;
    private String video;
    @Lob
    private String texto;
    @Lob
    private byte[] poster;
    private String revisado;

    @OneToMany(mappedBy = "pelicula")
    @Basic(fetch = jakarta.persistence.FetchType.LAZY)
    @OrderBy("ocupacion DESC")
    private List<PeliculaPersonaxe> personaxes;

    public Pelicula() {
    }

    public Pelicula(Long idPelicula, String musica, String orixinal, String ingles, String castelan, String xenero, Short anoInicio, Short anoFin, Short duracion, String outrasDuracions, String son, String video, String texto, byte[] poster, String revisado) {
        this.idPelicula = idPelicula;
        this.musica = musica;
        this.orixinal = orixinal;
        this.ingles = ingles;
        this.castelan = castelan;
        this.xenero = Xenero.of(xenero);
        this.anoInicio = anoInicio;
        this.anoFin = anoFin;
        this.duracion = duracion;
        this.outrasDuracions = outrasDuracions;
        this.son = son;
        this.video = video;
        this.texto = texto;
        this.poster = poster;
        this.revisado = revisado;
    }

    public Long getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(Long idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getMusica() {
        return musica;
    }

    public void setMusica(String musica) {
        this.musica = musica;
    }

    public String getOrixinal() {
        return orixinal;
    }

    public void setOrixinal(String orixinal) {
        this.orixinal = orixinal;
    }

    public String getIngles() {
        return ingles;
    }

    public void setIngles(String ingles) {
        this.ingles = ingles;
    }

    public String getCastelan() {
        return castelan;
    }

    public void setCastelan(String castelan) {
        this.castelan = castelan;
    }

    public String getXenero() {
        return xenero.getXenero();
    }

    public void setXenero(String xenero) {
        this.xenero = Xenero.of(xenero);
    }

    public Short getAnoInicio() {
        return anoInicio;
    }

    public void setAnoInicio(Short anoInicio) {
        this.anoInicio = anoInicio;
    }

    public Short getAnoFin() {
        return anoFin;
    }

    public void setAnoFin(Short anoFin) {
        this.anoFin = anoFin;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Short getDuracion() {
        return duracion;
    }

    public void setDuracion(Short duracion) {
        this.duracion = duracion;
    }

    public String getOutrasDuracions() {
        return outrasDuracions;
    }

    public void setOutrasDuracions(String outrasDuracions) {
        this.outrasDuracions = outrasDuracions;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public String getSon() {
        return son;
    }

    public void setSon(String son) {
        this.son = son;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public byte[] getPoster() {
        return poster;
    }

    public void setPoster(byte[] poster) {
        this.poster = poster;
    }

    public String getRevisado() {
        return revisado;
    }

    public void setRevisado(String revisado) {
        this.revisado = revisado;
    }

    public void setXenero(Xenero xenero) {
        this.xenero = xenero;
    }

    public List<PeliculaPersonaxe> getPersonaxes() {
        return personaxes;
    }

    public void setPersonaxes(List<PeliculaPersonaxe> personaxes) {
        this.personaxes = personaxes;
    }

    @Override
    public String toString() {
        return  "[" + idPelicula +
                "] " + castelan +
                ", ('" + orixinal + ')' +
                " (" + xenero +
                " de " + anoFin + "), '" + pais + '\'' +
                " " + duracion +
                " minutos. " + System.lineSeparator();
    }
}
