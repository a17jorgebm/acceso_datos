package org.example.ejersTypeAdapter.JsonDeserializerAndSerializer.ejer2.adaptadores;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import org.example.ejersTypeAdapter.JsonDeserializerAndSerializer.ejer2.Direccion;
import org.example.ejersTypeAdapter.JsonDeserializerAndSerializer.ejer2.Persona;

import java.lang.reflect.Type;

public class PersonaJsonSerializer implements JsonSerializer<Persona> {
    @Override
    public JsonElement serialize(Persona persona, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject object=new JsonObject();
        object.addProperty("name",persona.getNombre());
        object.addProperty("age",persona.getEdad());
        object.addProperty("address",jsonSerializationContext.serialize(persona.getDireccion(), Direccion.class).toString());
        return object;
    }
}
