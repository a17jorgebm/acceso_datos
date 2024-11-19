package org.example.ejerMeteoGalicia.adapters;

import com.google.gson.*;
import org.example.ejerMeteoGalicia.PrediccionDia;
import org.example.ejerMeteoGalicia.VariableFranxa;
import org.example.ejerMeteoGalicia.VariableMeteo;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PrediccionDiaDeserializer implements JsonDeserializer<PrediccionDia> {
    @Override
    public PrediccionDia deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject objeto=jsonElement.getAsJsonObject();

        LocalDate dataPrevision = jsonDeserializationContext.deserialize(objeto.get("dataPredicion"),LocalDate.class);
        int nivelAviso = getValorCheckingExistanceAndNulls(objeto , "nivelAviso");
        int tMax= getValorCheckingExistanceAndNulls(objeto, "tMax");
        int tMin= getValorCheckingExistanceAndNulls(objeto, "tMin");
        int uvMax= getValorCheckingExistanceAndNulls(objeto, "uvMax");

        List<VariableFranxa> franxas=new ArrayList<>();

        for (VariableMeteo varMeteo: VariableMeteo.values()){
            if (objeto.has(varMeteo.getNome())){
                JsonObject jsonVarFranxa=objeto.get(varMeteo.getNome()).getAsJsonObject();
                VariableFranxa variableFranxa=new VariableFranxa(
                        varMeteo,
                        jsonVarFranxa.get("manha").getAsInt(),
                        jsonVarFranxa.get("noite").getAsInt(),
                        jsonVarFranxa.get("tarde").getAsInt()
                );
                franxas.add(variableFranxa);
            }
        }

        PrediccionDia prediccionDia = new PrediccionDia(dataPrevision,nivelAviso,tMax,tMin,uvMax);
        prediccionDia.setListaVariableFranxa(franxas);
        return prediccionDia;
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
