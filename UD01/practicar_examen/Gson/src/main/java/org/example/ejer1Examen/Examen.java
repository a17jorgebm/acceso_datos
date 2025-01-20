package org.example.ejer1Examen;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.Since;
import com.google.gson.annotations.Until;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Examen {
    @Expose(serialize = false,deserialize = false)
    private String materia;
    @Expose
    @Since(1.0)
    private Date fechaExamen;
    @Expose(serialize = true,deserialize = true)
    @Until(2.0)
    private List<String> participantes;

    public Examen() {}

    public Examen(String materia, Date fechaExamen, List<String> participantes) {
        this.materia = materia;
        this.fechaExamen = fechaExamen;
        this.participantes = participantes;
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder=new StringBuilder();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(
                "EEEE, d 'de' MMMM 'de' yyyy, 'a las' HH:mm:ss",
                new Locale("es","ES")); //se a quixera formatear
        stringBuilder.append("Materia: ").append(materia).append("\n");
        stringBuilder.append("Fecha: ").append(fechaExamen).append("\n");
        stringBuilder.append("Participantes: ").append(participantes).append("\n");
        return stringBuilder.toString();
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public Date getFechaExamen() {
        return fechaExamen;
    }

    public void setFechaExamen(Date fechaExamen) {
        this.fechaExamen = fechaExamen;
    }

    public List<String> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<String> participantes) {
        this.participantes = participantes;
    }
}
