package org.example.ejersTypeAdapter.JsonDeserializerAndSerializer.ejer2;

/*
Ejercicio 1: Serialización y deserialización básica Serializar y deserializar una clase
sencilla con atributos básicos.

Crea una clase Persona con atributos nombre y edad. Implementa un JsonSerializer y un
JsonDeserializer para esta clase, personalizando los nombres de los atributos en el JSON
resultante, de modo que aparezcan como name y age en formato JSON.
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.ejersTypeAdapter.JsonDeserializerAndSerializer.ejer2.adaptadores.DireccionJsonDeserializer;
import org.example.ejersTypeAdapter.JsonDeserializerAndSerializer.ejer2.adaptadores.DireccionJsonSerializer;
import org.example.ejersTypeAdapter.JsonDeserializerAndSerializer.ejer2.adaptadores.PersonaJsonDeserializer;
import org.example.ejersTypeAdapter.JsonDeserializerAndSerializer.ejer2.adaptadores.PersonaJsonSerializer;

import java.io.StringReader;

public class Main {
    public static void main(String[] args) {
        Gson gson=new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(Persona.class, new PersonaJsonDeserializer())
                .registerTypeAdapter(Persona.class, new PersonaJsonSerializer())
                .registerTypeAdapter(Direccion.class, new DireccionJsonDeserializer())
                .registerTypeAdapter(Direccion.class, new DireccionJsonSerializer())
                .create();

        Direccion direccion=new Direccion("Santiago de Chile, 3b, 9d", "Santiago de Compostela");
        Persona persona=new Persona("Marcos",32,direccion);
        String jsonDireccion=gson.toJson(persona,Persona.class);
        System.out.println(jsonDireccion);
        Persona d2=gson.fromJson(new StringReader(jsonDireccion),Persona.class);
        System.out.println(d2);
    }
}
