package org.example.ejer05_3_Persona;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Access(AccessType.FIELD)
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersona;

    @Transient
    private String nombre;
    @Transient
    private String apellidos;
    @Transient
    private LocalDate fechaNacimiento;
    @Column(name = "fechaNacimiento")
    private Integer fechaNacimientoEnteiro;
    private Sexo sexo;
    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] foto;

    public Persona() {
    }

    @PrePersist
    void completarFechaNacimientoEntero(){
        fechaNacimientoEnteiro = LocalDate.now().compareTo(fechaNacimiento);
    }

    @PostLoad
    void completarFechaNacimiento(){
        fechaNacimiento = LocalDate.of(
                LocalDate.now().getYear()-fechaNacimientoEnteiro,
                01,
                01);
    }

    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    @Access(AccessType.PROPERTY)
    @Column(name = "nomeCompleto")
    public String getNombreEApellidos(){
        return apellidos.split(" ")[0]+", "+nombre;
    }

    public void setNombreEApellidos(String nombreEApellidos){
        String[] separados=nombreEApellidos.split(",");
        nombre=separados[1].trim();
        apellidos=separados[0].trim();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
}
