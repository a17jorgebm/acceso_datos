package org.example.ejer2Estudiante;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Estudiante implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstudiante;
    private String nombre;
    private String apellidos;
    private LocalDate fechaNacimiento;
    private String direccion;

    @Transient
    private String parte1_descripcion;
    @Transient
    private String parte2_descripcion;

    @Access(AccessType.PROPERTY)
    @Column(name = "descripcion_completa")
    public String getDescripcionCompleta(){
        return parte1_descripcion + ";;" + parte2_descripcion;
    }

    @Access(AccessType.PROPERTY)
    @Column(name = "descripcion_completa")
    public void setDescripcionCompleta(String descripcionCompleta){
        String[] descripcions = descripcionCompleta.split(";;");
        parte1_descripcion = descripcions[0];
        parte2_descripcion = descripcions[1];
    }

    public Estudiante() {}

    public Estudiante(String apellidos, String nombre) {
        this.apellidos = apellidos;
        this.nombre = nombre;
    }

    public Estudiante(String nombre, String apellidos, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Estudiante(String direccion, String apellidos, LocalDate fechaNacimiento, String nombre) {
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.apellidos = apellidos;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "idEstudiante=" + idEstudiante +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }

    public Long getIdEstudiante() {
        return idEstudiante;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
