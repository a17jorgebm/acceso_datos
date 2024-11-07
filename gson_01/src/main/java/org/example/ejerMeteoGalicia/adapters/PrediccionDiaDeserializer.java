package org.example.ejerMeteoGalicia.adapters;

import com.google.gson.*;
import org.example.ejerMeteoGalicia.PrediccionDia;
import org.example.ejerMeteoGalicia.VariableFranxa;
import org.example.ejerMeteoGalicia.VariableMeteo;

import java.lang.reflect.Type;
import java.time.LocalDate;

public class PrediccionDiaDeserializer implements JsonDeserializer<PrediccionDia> {
    @Override
    public PrediccionDia deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject objeto=jsonElement.getAsJsonObject();

        LocalDate dataPrevision = jsonDeserializationContext.deserialize(objeto.get("dataPredicion"),LocalDate.class);
        int nivelAviso = getValorCheckingExistanceAndNulls(objeto , "nivelAviso");
        int tMax= getValorCheckingExistanceAndNulls(objeto, "tMax");
        int tMin= getValorCheckingExistanceAndNulls(objeto, "tMin");
        int uvMax= getValorCheckingExistanceAndNulls(objeto, "uvMax");

        VariableFranxa ceo, pchoiva, tmaxFranxa, tminFranxa, vento;

        //o switch non fai falta, porque repite o uso do enum. CORREGIR
        for (String nome: objeto.keySet()){
            if (objeto.get(nome).isJsonObject()){
                VariableMeteo v = VariableMeteo.getVariableMeteo(nome);
                switch (VariableMeteo.getVariableMeteo(nome)){
                    case CIELO -> ceo=crearVariableFranxa(VariableMeteo.CIELO, objeto.get(nome).getAsJsonObject());
                    case LLUVIA -> pchoiva=crearVariableFranxa(VariableMeteo.LLUVIA, objeto.get(nome).getAsJsonObject());
                    case TEMPERATURA_MAXIMA -> tmaxFranxa=crearVariableFranxa(VariableMeteo.TEMPERATURA_MAXIMA, objeto.get(nome).getAsJsonObject());
                    case TEMPERATURA_MINIMA -> tminFranxa=crearVariableFranxa(VariableMeteo.TEMPERATURA_MINIMA, objeto.get(nome).getAsJsonObject());
                    case VIENTO -> vento=crearVariableFranxa(VariableMeteo.VIENTO, objeto.get(nome).getAsJsonObject());
                }
            }
        }

        return new PrediccionDia();

    }

    private VariableFranxa crearVariableFranxa(VariableMeteo tipo, JsonObject objetoJson){
        int manha=objetoJson.get("manha").getAsInt();
        int noite=objetoJson.get("noite").getAsInt();
        int tarde=objetoJson.get("tarde").getAsInt();
        return new VariableFranxa(tipo,manha,noite,tarde);
    }

    private int getValorCheckingExistanceAndNulls(JsonObject o, String nomePropiedade){
        if (o.has(nomePropiedade) && !o.get(nomePropiedade).isJsonNull()){
            try{
                int num= o.get(nomePropiedade).getAsInt();
                return num;
            }catch (Exception e){}
        }
        return -9999;
    }
}
