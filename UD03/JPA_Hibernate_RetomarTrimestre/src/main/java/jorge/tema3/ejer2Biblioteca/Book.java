package jorge.tema3.ejer2Biblioteca;

import jakarta.persistence.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Entity
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBook;
    @Column(length = 13)
    private String isbn;
    @Column(length = 100)
    private String titulo;
    @Column(length = 100)
    private String autor;
    @Column(length = 100)
    private Integer ano;
    private Boolean disponible;
    @Lob
    private byte[] portada;
    private LocalDate dataPublicacion;
    @Transient
    List<Contido> contidos;

    public Book() {}

    public Book(String isbn, String titulo, String autor, Integer ano, Boolean disponible, byte[] portada) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.disponible = disponible;
        this.portada = portada;
    }

    public Book(Long idBook, LocalDate dataPublicacion, byte[] portada, Boolean disponible, Integer ano, String autor, String titulo, String isbn) {
        this.idBook = idBook;
        this.dataPublicacion = dataPublicacion;
        this.portada = portada;
        this.disponible = disponible;
        this.ano = ano;
        this.autor = autor;
        this.titulo = titulo;
        this.isbn = isbn;
    }

    public Long getIdBook() {
        return idBook;
    }

    public void setIdBook(Long idBook) {
        this.idBook = idBook;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public byte[] getPortada() {
        return portada;
    }

    public Image getImage() throws IOException{
        if (portada!=null){
            try(ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(portada)){
                return ImageIO.read(byteArrayInputStream);
            }
        }
        return null;
    }

    public void setPortada(byte[] portada) {
        this.portada = portada;
    }

    public void setPortada(File portada) throws IOException {
        Path path = Path.of(portada.getPath());
        this.portada = Files.readAllBytes(path);
    }

    public LocalDate getDataPublicacion() {
        return dataPublicacion;
    }

    public void setDataPublicacion(LocalDate dataPublicacion) {
        this.dataPublicacion = dataPublicacion;
    }

    public List<Contido> getContidos() {
        return contidos;
    }

    public void setContidos(List<Contido> contidos) {
        this.contidos = contidos;
    }

    @Override
    public String toString() {
        return "Book{" +
                "idBook=" + idBook +
                ", isbn='" + isbn + '\'' +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", ano=" + ano +
                ", disponible=" + disponible +
                ", portada=" + Arrays.toString(portada) +
                ", dataPublicacion=" + dataPublicacion +
                ", contidos=" + contidos +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Book book = (Book) object;
        return Objects.equals(getIsbn(), book.getIsbn());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getIsbn());
    }
}
