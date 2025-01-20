package org.example.ejer2Examen;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ExamenDeserializer implements JsonDeserializer<Examen> {
    @Override
    public Examen deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObjectExamen = jsonElement.getAsJsonObject();

        String nombre = jsonObjectExamen.get("materia").getAsString();
        LocalDateTime data = jsonDeserializationContext.deserialize(jsonObjectExamen.get("data"),LocalDateTime.class);
        List<String> alumnos = new ArrayList<>();
        JsonArray alumnosJsonArray =  jsonObjectExamen.get("alumnos").getAsJsonArray();
        alumnosJsonArray.forEach(alumno -> {
            alumnos.add(alumno.getAsString());
        });

        return new Examen(nombre,data,alumnos);
    }
}
