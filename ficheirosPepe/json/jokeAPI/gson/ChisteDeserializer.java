package com.pepinho.ad.joke.gson;

import com.google.gson.*;
import com.pepinho.ad.joke.Chiste;
import com.pepinho.ad.joke.Flag;

import java.lang.reflect.Type;

public class ChisteDeserializer implements JsonDeserializer<Chiste> {

    @Override
    public Chiste deserialize(JsonElement elemento, Type type,
                              JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

        // Comprobación si es un objeto:
        if (!elemento.isJsonObject())
            return null;
        // Recupero el objeto JSON del chiste
        JsonObject jsonChiste = elemento.getAsJsonObject();

        // Comprobación de que no hay error en la petición:
        if (jsonChiste.has("error") && jsonChiste.get("error").isJsonNull()
                && jsonChiste.get("error").getAsBoolean()) {
            return null;
        }

        // Creo un chiste vacío, al que le daré valor a sus atributos:
        Chiste chiste = new Chiste();

        // Compruebo que cada elemento del objeto existe y lo asigno al objeto Chiste:
        // La comprobación se hace con el método get() de la clase JsonObject que devuelve
        // un JsonElement. Si es null, no existe el elemento.
        if (jsonChiste.has("category") && !jsonChiste.get("category").isJsonNull()) {
            chiste.setCategoria(jsonChiste.get("category").getAsString());
        }
        if (jsonChiste.has("type") && !jsonChiste.get("type").isJsonNull()) {
            chiste.setTipo(jsonChiste.get("type").getAsString());
        }
        // En realidad, dependiendo del tipo de chiste, el setup o el delivery pueden no existir.
        // Por lo que podría hacer comprobando el valor de type, pero lo dejo así para que veáis
        // como se puede hacer con el método get() de la clase JsonObject.
        if (jsonChiste.has("setup") && !jsonChiste.get("setup").isJsonNull()) {
            chiste.setChiste(jsonChiste.get("setup").getAsString());
            if (jsonChiste.has("delivery") && !jsonChiste.get("delivery").isJsonNull()) {// if (jsonChiste.get("delivery") != null) {
                chiste.setRespuesta(jsonChiste.get("delivery").getAsString());
            }
        } else if (jsonChiste.has("joke") && !jsonChiste.get("joke").isJsonNull()) {
            chiste.setChiste(jsonChiste.get("joke").getAsString());
        }

        if (jsonChiste.has("lang") && !jsonChiste.get("lang").isJsonNull()) {
            chiste.setLenguaje(jsonChiste.get("lang").getAsString());
        }

        if (jsonChiste.has("id") && !jsonChiste.get("id").isJsonNull()){
            chiste.setId(jsonChiste.get("id").getAsInt());
        }

        if (jsonChiste.has("flags") && !jsonChiste.get("flags").isJsonNull()
                && jsonChiste.get("flags").isJsonObject()) {
            JsonObject flags = jsonChiste.get("flags").getAsJsonObject();
            if (flags.has("nsfw") && flags.get("nsfw").getAsBoolean()) {
                chiste.addFlag(Flag.NSFW);
            }
            if (flags.has("religious") && flags.get("religious").getAsBoolean()) {
                chiste.addFlag(Flag.RELIGION);
            }
            if (flags.has("political") && flags.get("political").getAsBoolean()) {
                chiste.addFlag(Flag.POLITICAL);
            }
            if (flags.has("racist") && flags.get("racist").getAsBoolean()) {
                chiste.addFlag(Flag.RACIST);
            }
            if (flags.has("sexist") && flags.get("sexist").getAsBoolean()) {
                chiste.addFlag(Flag.SEXIST);
            }
            if (flags.has("explicit") && flags.get("explicit").getAsBoolean()) {
                chiste.addFlag(Flag.EXPLICIT);
            }
        }
        return chiste;
    }

    private static boolean has(JsonObject obxecto, String campo) {
        return obxecto.has(campo) && !obxecto.get(campo).isJsonNull();
    }
}


