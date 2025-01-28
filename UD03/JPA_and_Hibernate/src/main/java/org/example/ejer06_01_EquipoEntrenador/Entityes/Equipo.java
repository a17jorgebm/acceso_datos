package org.example.ejer06_01_EquipoEntrenador.Entityes;

import jakarta.persistence.*;
import org.example.ejer06_01_EquipoEntrenador.Enums.Conferencia;
import org.example.ejer06_01_EquipoEntrenador.Converters.ConferenciaConverter;
import org.example.ejer06_01_EquipoEntrenador.Enums.Division;
import org.example.ejer06_01_EquipoEntrenador.Converters.DivisionConverter;

@Entity
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEquipo;
    private String nombre;
    private String ciudad;
    @Enumerated
    @Convert(converter = ConferenciaConverter.class)
    private Conferencia conferencia;
    @Enumerated
    @Convert(converter = DivisionConverter.class)
    private Division division;
    private String nombreCompleto;
    @Column(unique = true)
    private String abreviatura;

    @OneToOne
    @JoinColumn(name = "entrenador_id")
    private Entrenador entrenador;

    public Equipo() {
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "idEquipo=" + idEquipo +
                ", nombre='" + nombre + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", conferencia=" + conferencia +
                ", division=" + division +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", abreviatura='" + abreviatura + '\'' +
                ", entrenador=" + entrenador +
                '}';
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public Conferencia getConferencia() {
        return conferencia;
    }

    public void setConferencia(Conferencia conferencia) {
        this.conferencia = conferencia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
