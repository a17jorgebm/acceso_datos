package org.example.boletin03_json.ejer2;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonWriter;

import java.io.StringWriter;

public class JsonPExemplo {
    public static void main(String[] args) {
        // Crear un objeto JSON usando JSON-P
        JsonObject objetoJson = Json.createObjectBuilder()
                .add("nombre", "Otto")
                .add("edad", 4)
                .add("ciudad", "Santiado de Compostela")
                .build();

        // Convertir el objeto JSON a una cadena
        StringWriter stringWriter = new StringWriter();
        try (JsonWriter jsonWriter = Json.createWriter(stringWriter)) {
            jsonWriter.writeObject(objetoJson);
        }

        // Imprimir la cadena JSON
        String strJson = stringWriter.toString();
        System.out.println("JSON Resultante (JSON-P):");
        System.out.println(strJson);
    }
}