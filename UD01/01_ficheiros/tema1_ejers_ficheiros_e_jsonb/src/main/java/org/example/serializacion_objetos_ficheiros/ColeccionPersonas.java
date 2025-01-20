package org.example.serializacion_objetos_ficheiros;

import java.io.Serializable;
import java.util.LinkedList;

public class ColeccionPersonas implements Serializable {
    private LinkedList<Persona> personas;

    public ColeccionPersonas() {
        personas = new LinkedList<>();
    }
    public ColeccionPersonas(LinkedList<Persona> personas) {
        this.personas = personas;
    }

    public boolean engadirPersona(Persona persona) {
        return this.personas.add(persona);
    }

    public LinkedList<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(LinkedList<Persona> personas) {
        this.personas = personas;
    }
}
