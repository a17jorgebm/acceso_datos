package org.example.ejerMeteoGalicia.adapters;

import com.google.gson.*;
import org.example.ejerMeteoGalicia.Concello;

import java.lang.reflect.Type;

public class ConcelloDeserializer implements JsonDeserializer<Concello> {
    @Override
    public Concello deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject objetoAtributos=jsonElement.getAsJsonObject();
        int idConcello=objetoAtributos.get("idConcello").getAsInt();
        String nomeConcello=objetoAtributos.get("nome").getAsString();
        return new Concello(nomeConcello,idConcello);
    }
}
