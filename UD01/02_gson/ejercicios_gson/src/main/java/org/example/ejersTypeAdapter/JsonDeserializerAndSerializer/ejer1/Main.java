package org.example.ejersTypeAdapter.JsonDeserializerAndSerializer.ejer1;

/*
Ejercicio 1: Serialización y deserialización básica Serializar y deserializar una
clase sencilla con atributos básicos.

Crea una clase Persona con atributos nombre y edad. Implementa un JsonSerializer y un
JsonDeserializer para esta clase, personalizando los nombres de los atributos en el
JSON resultante, de modo que aparezcan como name y age en formato JSON.
 */

import com.google.gson.*;

import java.io.StringReader;
import java.lang.reflect.Type;

public class Main {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(Persona.class, new JsonSerializer<Persona>() {
                    @Override
                    public JsonElement serialize(Persona persona, Type type, JsonSerializationContext jsonSerializationContext) {
                        JsonObject object=new JsonObject();
                        object.addProperty("name",persona.getNombre());
                        object.addProperty("age",persona.getEdad());
                        return object;
                    }
                })
                .registerTypeAdapter(Persona.class, new JsonDeserializer<Persona>() {
                    @Override
                    public Persona deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                        JsonObject jsonPerson=jsonElement.getAsJsonObject();
                        String nombre=jsonPerson.get("name").toString();
                        int age=jsonPerson.get("age").getAsInt();
                        return new Persona(nombre,age);
                    }
                })
                .create();

        Persona p=new Persona("Juan",45);
        String pJson=gson.toJson(p,Persona.class);
        System.out.println(pJson);

        Persona p2=gson.fromJson(new StringReader(pJson),Persona.class);
        System.out.println(p2);
    }
}
