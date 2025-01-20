package org.example.ejer2Examen;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ListaExamenDeserializer implements JsonDeserializer<List<Examen>> {
    @Override
    public List<Examen> deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        ArrayList<Examen> examenes = new ArrayList<>();
        JsonArray arrayCompleto = jsonElement.getAsJsonArray();
        for (JsonElement element : arrayCompleto) {
            examenes.add(jsonDeserializationContext.deserialize(element,Examen.class));
        }
        return examenes;
    }
}
