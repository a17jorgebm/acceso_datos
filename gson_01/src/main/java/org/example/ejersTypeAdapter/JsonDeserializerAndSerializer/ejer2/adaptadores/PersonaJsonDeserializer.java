package org.example.ejersTypeAdapter.JsonDeserializerAndSerializer.ejer2.adaptadores;

import com.google.gson.*;
import org.example.ejersTypeAdapter.JsonDeserializerAndSerializer.ejer2.Direccion;
import org.example.ejersTypeAdapter.JsonDeserializerAndSerializer.ejer2.Persona;

import java.lang.reflect.Type;

public class PersonaJsonDeserializer implements JsonDeserializer<Persona> {
    @Override
    public Persona deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonPerson=jsonElement.getAsJsonObject();
        String nombre=jsonPerson.get("name").toString();
        int age=jsonPerson.get("age").getAsInt();
        Direccion direccion=jsonDeserializationContext.deserialize(jsonPerson.get("address"),Direccion.class);
        return new Persona(nombre,age,direccion);
    }
}
