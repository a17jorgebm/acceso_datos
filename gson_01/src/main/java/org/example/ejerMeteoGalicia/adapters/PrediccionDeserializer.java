package org.example.ejerMeteoGalicia.adapters;

import com.google.gson.*;
import org.example.ejerMeteoGalicia.Concello;
import org.example.ejerMeteoGalicia.Prediccion;
import org.example.ejerMeteoGalicia.PrediccionDia;

import java.lang.reflect.Type;
import java.util.LinkedList;

public class PrediccionDeserializer implements JsonDeserializer<Prediccion> {
    @Override
    public Prediccion deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject objetoEnteiro=jsonElement.getAsJsonObject().get("predConcello").getAsJsonObject();

        Concello concello=jsonDeserializationContext.deserialize(objetoEnteiro,Concello.class);

        LinkedList<PrediccionDia> prediccionDias=new LinkedList<>();
        JsonArray prediccionsJson=objetoEnteiro.getAsJsonArray("listaPredDiaConcello");
        prediccionsJson.forEach((pred) -> {
            PrediccionDia prediccionDia=jsonDeserializationContext.deserialize(pred,PrediccionDia.class);
            prediccionDias.add(prediccionDia);
        });

        Prediccion prediccion=new Prediccion(concello);
        prediccion.setListaPredDiaConcello(prediccionDias);

        return prediccion;
    }
}
