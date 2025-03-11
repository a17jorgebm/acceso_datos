package com.pepinho.ad.jpa.model.converters;

import com.pepinho.ad.jpa.model.Division;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class DivisionConverter implements AttributeConverter<Division, String> {
    @Override
    public String convertToDatabaseColumn(Division division) {
        return (division!=null) ? division.getValor() : null;
    }

    @Override
    public Division convertToEntityAttribute(String s) {
        return Division.of(s);
    }
}
