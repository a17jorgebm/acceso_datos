package com.pepinho.ad.jpa.peliculas;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = false)
public class XeneroConverter implements AttributeConverter<Xenero,String> {
    @Override
    public String convertToDatabaseColumn(Xenero xenero) {
        return (xenero!=null) ? xenero.getXenero() : null;
    }

    @Override
    public Xenero convertToEntityAttribute(String s) {
        return Xenero.of(s);
    }
}
