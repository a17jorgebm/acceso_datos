package com.pepinho.ad.joke;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class ChisteSerializer implements JsonSerializer<Chiste> {
    @Override
    public JsonElement serialize(Chiste chiste, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonChiste = new JsonObject();
        jsonChiste.addProperty("category", chiste.getCategoriaString());
        jsonChiste.addProperty("type", chiste.getTipoString());
        if(chiste.getTipo() == TipoChiste.SINGLE) {
            jsonChiste.addProperty("joke", chiste.getChiste());
        } else {
            jsonChiste.addProperty("setup", chiste.getChiste());
            jsonChiste.addProperty("delivery", chiste.getRespuesta());
        }
        JsonObject jsonFlags = new JsonObject();
        jsonFlags.addProperty("nsfw", chiste.containsFlag(Flag.NSFW));
        jsonFlags.addProperty("religious", chiste.containsFlag(Flag.RELIGION));
        jsonFlags.addProperty("political", chiste.containsFlag(Flag.POLITICAL));
        jsonFlags.addProperty("racist", chiste.containsFlag(Flag.RACIST));
        jsonFlags.addProperty("sexist", chiste.containsFlag(Flag.SEXIST));
        jsonFlags.addProperty("explicit", chiste.containsFlag(Flag.EXPLICIT));
        jsonChiste.add("flags", jsonFlags);
        jsonChiste.addProperty("lang", chiste.getLenguajeString());
        jsonChiste.addProperty("id", chiste.getId());
        return jsonChiste;
    }
}
