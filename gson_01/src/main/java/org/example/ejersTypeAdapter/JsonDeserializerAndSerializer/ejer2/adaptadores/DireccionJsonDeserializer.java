package org.example.ejersTypeAdapter.JsonDeserializerAndSerializer.ejer2.adaptadores;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import org.example.ejersTypeAdapter.JsonDeserializerAndSerializer.ejer2.Direccion;

import java.lang.reflect.Type;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DireccionJsonDeserializer implements JsonDeserializer<Direccion> {
    @Override
    public Direccion deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        String direccionCompleta=jsonElement.getAsString();
        Matcher regex= Pattern.compile("^(.*),\\s*([^,]+)$").matcher(direccionCompleta);
        String calle=null;
        String ciudad=null;
        if (regex.find()){
            calle=regex.group(1).trim();
            ciudad=regex.group(2).trim();
        }else {
            throw new JsonParseException("Dirección con formato incorrecto");
        }

        return new Direccion(calle,ciudad);
    }
}
