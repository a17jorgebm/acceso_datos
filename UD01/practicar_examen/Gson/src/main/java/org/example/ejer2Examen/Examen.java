package org.example.ejer2Examen;

import java.time.LocalDateTime;
import java.util.List;

public class Examen {
    private String materia;
    private LocalDateTime dataExame;
    private List<String> alumnosApuntados;

    public Examen() {}

    public Examen(String materia, LocalDateTime dataExame, List<String> alumnosApuntados) {
        this.materia = materia;
        this.dataExame = dataExame;
        this.alumnosApuntados = alumnosApuntados;
    }

    @Override
    public String toString() {
        return "Examen{" +
                "materia='" + materia + '\'' +
                ", dataExame=" + dataExame +
                ", alumnosApuntados=" + alumnosApuntados +
                '}';
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public LocalDateTime getDataExame() {
        return dataExame;
    }

    public void setDataExame(LocalDateTime dataExame) {
        this.dataExame = dataExame;
    }

    public List<String> getAlumnosApuntados() {
        return alumnosApuntados;
    }

    public void setAlumnosApuntados(List<String> alumnosApuntados) {
        this.alumnosApuntados = alumnosApuntados;
    }
}
