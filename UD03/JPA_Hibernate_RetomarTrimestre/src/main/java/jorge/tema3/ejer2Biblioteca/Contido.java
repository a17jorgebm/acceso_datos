package jorge.tema3.ejer2Biblioteca;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Contido implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContido;
    @Lob
    private String contido;
    @ManyToOne //tou aqui!!!!!!!!!!!!!!!!!!!!!!!!!!!
    private Book book;
}
