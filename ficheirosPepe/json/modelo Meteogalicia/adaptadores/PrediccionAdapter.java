package com.pepinho.ad.gson.meteogalicia.model.adapters;

import com.google.gson.*;
import com.pepinho.ad.gson.meteogalicia.model.Concello;
import com.pepinho.ad.gson.meteogalicia.model.Prediccion;
import com.pepinho.ad.gson.meteogalicia.model.PrediccionDia;

import java.lang.reflect.Type;

public class PrediccionAdapter implements JsonDeserializer<Prediccion> {

    @Override
    public Prediccion deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext contexto) throws JsonParseException {

        JsonObject pc = jsonElement.getAsJsonObject();

        JsonObject jsonPredicion = pc.getAsJsonObject("predConcello");
        Concello concello = new Concello(jsonPredicion.getAsJsonPrimitive("nome").getAsString(),
                jsonPredicion.getAsJsonPrimitive("idConcello").getAsInt());


        Prediccion pr = new Prediccion(concello);

        jsonPredicion.getAsJsonArray("listaPredDiaConcello").forEach(e -> {
            pr.addPredDiaConcello(contexto.deserialize(e, PrediccionDia.class));
        });





        return pr;
    }
}
