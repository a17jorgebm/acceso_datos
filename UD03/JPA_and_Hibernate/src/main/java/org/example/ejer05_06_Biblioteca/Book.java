package org.example.ejer05_06_Biblioteca;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

@Entity
public class Book {
    @Id
    @TableGenerator(
            name = "Book_Gen",
            table = "ID_GEN", //en que tabla se vai gardar
            pkColumnName = "idBook", //nome da PK da tabla Book
            valueColumnName = "genValue", // nome da columna dos ids
            pkColumnValue = "bookId", //nome da FILA das claves de cada grupo de ids, neste caso os books terán a sua propia clave, polo que terán unha fila propia na tabla
            allocationSize = 50 //chunks de ids que se gardarán en cache da base de datos para ser mais eficiente, unha vez se chegue a 50 pasará a 100 e así continuamente
    )
    @GeneratedValue(strategy = GenerationType.TABLE,generator = "Book_Gen")
    private Integer idBook;
    @Column(
            unique = true,
            length = 13,
            nullable = false
    )
    private String isbn;
    @Transient
    private String isbnTenDigitsVersion;
    private String title;
    private String author;
    private Integer ano;
    private Boolean available;
    private byte[] portada;
    @Convert(converter = CategoriaConverter.class)
    private Categoria categoria;
    @Temporal(TemporalType.DATE)
    private Calendar fechaPublicacion;
    @Transient
    private Long diasDesdePublicacion;

    public Book() {
    }

    // na da fallo pero simplemente crear un metodo que ejecute aos dous estes
    @PrePersist
    @PostLoad
    private void updateDiasDesdePubliacion(){
        LocalDate fechaPublicacionLD= this.fechaPublicacion
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        diasDesdePublicacion = ChronoUnit.DAYS.between(fechaPublicacionLD,LocalDate.now());
    }

    @PrePersist
    @PostLoad
    private void updateIsbTenDigitsVersion(){
        String isbn9=isbn.substring(3,12);
        System.out.println(isbn9);

        BigInteger sum = BigInteger.ZERO;
        int z=10;
        for (int i=0;i<isbn9.length();i++){
            int num = Character.getNumericValue(isbn9.charAt(i));
            sum = sum.add(BigInteger.valueOf(num*z));
            --z;
        }

        BigInteger resto = sum.remainder(BigInteger.valueOf(11));
        BigInteger controlDigit = BigInteger.valueOf(11).subtract(resto);

        if (controlDigit.intValue() == 10){
            isbnTenDigitsVersion = isbn9+"X";
        }else {
            isbnTenDigitsVersion = isbn9+controlDigit;
        }
    }

    public Integer getIdBook() {
        return idBook;
    }

    public void setIdBook(Integer idBook) {
        this.idBook = idBook;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
        updateIsbTenDigitsVersion();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public byte[] getPortada() {
        return portada;
    }

    public void setPortada(byte[] portada) {
        this.portada = portada;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Calendar getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Calendar fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
        updateDiasDesdePubliacion();
    }

    public String getIsbnTenDigitsVersion() {
        return isbnTenDigitsVersion;
    }

    public Long getDiasDesdePublicacion() {
        return diasDesdePublicacion;
    }
}
