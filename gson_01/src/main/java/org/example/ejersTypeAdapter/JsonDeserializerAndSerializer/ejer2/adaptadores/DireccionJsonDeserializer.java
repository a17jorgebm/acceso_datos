package org.example.ejersTypeAdapter.JsonDeserializerAndSerializer.ejer2.adaptadores;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import org.example.ejersTypeAdapter.JsonDeserializerAndSerializer.ejer2.Direccion;

import java.lang.reflect.Type;

public class DireccionJsonDeserializer implements JsonDeserializer<Direccion> {
    @Override
    public Direccion deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return null;
    }
}
