package com.pepinho.ad.jpa.peliculas;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = false)
public class CorConverter implements AttributeConverter<Cor,String> {
    @Override
    public String convertToDatabaseColumn(Cor cor) {
        return (cor!=null) ? cor.getCor() : null;
    }

    @Override
    public Cor convertToEntityAttribute(String s) {
        return Cor.of(s);
    }
}
