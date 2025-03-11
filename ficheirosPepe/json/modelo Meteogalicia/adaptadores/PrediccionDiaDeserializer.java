package com.pepinho.ad.gson.meteogalicia.model.adapters;

import com.google.gson.*;
import com.pepinho.ad.gson.meteogalicia.model.PrediccionDia;
import com.pepinho.ad.gson.meteogalicia.model.VariableFranxa;
import com.pepinho.ad.gson.meteogalicia.model.VariableMeteo;

import java.lang.reflect.Type;

public class PrediccionDiaDeserializer implements JsonDeserializer<PrediccionDia> {
    @Override
    public PrediccionDia deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject predDiaJObject = jsonElement.getAsJsonObject();

        PrediccionDia predDia = new PrediccionDia(predDiaJObject.getAsJsonPrimitive("dataPredicion")
                .getAsString());
        if (!predDiaJObject.get("nivelAviso").isJsonNull())
            predDia.setNivelAviso(predDiaJObject.getAsJsonPrimitive("nivelAviso").getAsInt());
        predDia.setTemperaturaMaxima(predDiaJObject.getAsJsonPrimitive("tMax").getAsInt());
        predDia.setTemperaturaMinima(predDiaJObject.getAsJsonPrimitive("tMin").getAsInt());
        predDia.setUvMaximo(predDiaJObject.getAsJsonPrimitive("uvMax").getAsInt());

//        predDiaJObject.entrySet().forEach(e -> {
//            if (e.getValue().isJsonObject())
////                System.out.println(e.getKey() + " -> " + e.getValue().getAsJsonObject());
//            predDia.addVariableFranxa(getVariableFranxa(VariableMeteo.getVariableMeteo(e.getKey()), e.getValue().getAsJsonObject()));
//        });

        for (VariableMeteo v : VariableMeteo.values()) {
//            if (!predDiaJObject.get(v.getNome()).isJsonNull()) {
            if (predDiaJObject.has(v.getNome())) {
                JsonObject varFranxaJsonObject = predDiaJObject.get(v.getNome()).getAsJsonObject();
                predDia.addVariableFranxa(getVariableFranxa(v, varFranxaJsonObject));
            }
        }

        return predDia;
    }

    private VariableFranxa getVariableFranxa(VariableMeteo v, JsonObject varFranxaJsonObject){
        VariableFranxa vf = new VariableFranxa(v);
        vf.setManha(varFranxaJsonObject.get("manha").getAsInt());
        vf.setNoite(varFranxaJsonObject.get("noite").getAsInt());
        vf.setTarde(varFranxaJsonObject.get("tarde").getAsInt());
        return vf;
    }

}
