package org.example.ejer06_01_EquipoEntrenador;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class ConferenciaConverter implements AttributeConverter<Conferencia, String> {
    @Override
    public String convertToDatabaseColumn(Conferencia conferencia) {
        return conferencia.getTexto();
    }

    @Override
    public Conferencia convertToEntityAttribute(String s) {
        return Conferencia.from(s);
    }
}
