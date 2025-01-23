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
    private BigInteger isbnTenDigitsVersion;
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

    @PostLoad
    private void updateDiasDesdePubliacion(){
        LocalDate fechaPublicacionLD= this.fechaPublicacion
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        diasDesdePublicacion = ChronoUnit.DAYS.between(fechaPublicacionLD,LocalDate.now());
    }

    @PostLoad
    private void updateIsbTenDigitsVersion(){
        String isbnWithNineDigits = isbn.substring(3,12);
    }

}
