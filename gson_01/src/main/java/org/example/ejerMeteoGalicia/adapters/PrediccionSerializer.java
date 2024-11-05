package org.example.ejerMeteoGalicia.adapters;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import org.example.ejerMeteoGalicia.Prediccion;

import java.lang.reflect.Type;

public class PrediccionSerializer implements JsonSerializer<Prediccion> {
    @Override
    public JsonElement serialize(Prediccion prediccion, Type type, JsonSerializationContext jsonSerializationContext) {
        return null;
    }
}
