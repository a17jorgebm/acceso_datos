package com.pepinho.ad.jpa.model.converters;

import com.pepinho.ad.jpa.model.Conferencia;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class ConferenciaConverter implements AttributeConverter<Conferencia, String> {
    @Override
    public String convertToDatabaseColumn(Conferencia conferencia) {
        return (conferencia!=null) ? conferencia.getValor() : null;
    }

    @Override
    public Conferencia convertToEntityAttribute(String s) {
        return Conferencia.of(s);
    }
}
