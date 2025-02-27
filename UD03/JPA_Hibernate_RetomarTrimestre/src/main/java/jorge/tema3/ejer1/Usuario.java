package jorge.tema3.ejer1;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apel1;
    private String apel2;
    private String email;
    private String password;

    public Usuario() {}

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apel1='" + apel1 + '\'' +
                ", apel2='" + apel2 + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Usuario usuario = (Usuario) object;
        return Objects.equals(getId(), usuario.getId()) && Objects.equals(getNombre(), usuario.getNombre()) && Objects.equals(getApel1(), usuario.getApel1()) && Objects.equals(getApel2(), usuario.getApel2()) && Objects.equals(getEmail(), usuario.getEmail()) && Objects.equals(getPassword(), usuario.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNombre(), getApel1(), getApel2(), getEmail(), getPassword());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApel1() {
        return apel1;
    }

    public void setApel1(String apel1) {
        this.apel1 = apel1;
    }

    public String getApel2() {
        return apel2;
    }

    public void setApel2(String apel2) {
        this.apel2 = apel2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
