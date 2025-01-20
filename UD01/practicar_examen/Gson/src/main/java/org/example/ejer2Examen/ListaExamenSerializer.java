package org.example.ejer2Examen;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.List;

public class ListaExamenSerializer implements JsonSerializer<List<Examen>> {
    @Override
    public JsonElement serialize(List<Examen> examenes, Type type, JsonSerializationContext jsonSerializationContext) {
        if (examenes==null || examenes.isEmpty()) return JsonNull.INSTANCE;
        JsonArray array = new JsonArray();
        for (Examen e: examenes){
            array.add(jsonSerializationContext.serialize(e, Examen.class));
        }
        return array;
    }
}
