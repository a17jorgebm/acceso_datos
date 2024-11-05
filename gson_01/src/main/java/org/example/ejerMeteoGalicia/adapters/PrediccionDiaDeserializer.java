package org.example.ejerMeteoGalicia.adapters;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import org.example.ejerMeteoGalicia.PrediccionDia;

import java.lang.reflect.Type;

public class PrediccionDiaDeserializer implements JsonDeserializer<PrediccionDia> {
    @Override
    public PrediccionDia deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return null;
    }
}
