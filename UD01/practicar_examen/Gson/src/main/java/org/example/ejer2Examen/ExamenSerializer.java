package org.example.ejer2Examen;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.List;

public class ExamenSerializer implements JsonSerializer<Examen> {
    @Override
    public JsonElement serialize(Examen examen, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("materia",examen.getMateria());
        jsonObject.add("data",jsonSerializationContext.serialize(examen.getDataExame(), LocalDateTime.class));

        List<String> alumnos = examen.getAlumnosApuntados();
        if (alumnos==null || alumnos.isEmpty()){
            jsonObject.add("alumnos",null);
        }else {
            JsonArray jsonArrayAlumnos = new JsonArray();
            for (String alumno : alumnos){
                jsonArrayAlumnos.add(alumno);
            }
            jsonObject.add("alumnos",jsonArrayAlumnos);
        }

        return jsonObject;
    }
}
