package org.example.ejersTypeAdapter.JsonDeserializerAndSerializer.ejer2.adaptadores;

import com.google.gson.*;
import org.example.ejersTypeAdapter.JsonDeserializerAndSerializer.ejer2.Direccion;

import java.lang.reflect.Type;

public class DireccionJsonSerializer implements JsonSerializer<Direccion> {
    @Override
    public JsonElement serialize(Direccion direccion, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(direccion.getCalle()+", "+direccion.getCiudad());
    }
}
