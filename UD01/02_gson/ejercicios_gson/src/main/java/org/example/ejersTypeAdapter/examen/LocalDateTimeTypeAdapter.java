package org.example.ejersTypeAdapter.examen;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class LocalDateTimeTypeAdapter
    implements JsonSerializer<LocalDateTime>, JsonDeserializer<LocalDateTime>
{
    private static final DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    @Override
    public JsonElement serialize(LocalDateTime localDateTime, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(formato.format(localDateTime));
    }

    @Override
    public LocalDateTime deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        try{
            return LocalDateTime.parse(jsonElement.toString().substring(1,jsonElement.toString().length()-1),formato);
        }catch (DateTimeParseException e){
            throw new JsonParseException("Error ao convertir a fecha do exame",e);
        }
    }
}
