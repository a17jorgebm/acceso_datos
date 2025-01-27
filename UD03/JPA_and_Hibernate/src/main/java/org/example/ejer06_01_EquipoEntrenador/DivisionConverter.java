package org.example.ejer06_01_EquipoEntrenador;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class DivisionConverter implements AttributeConverter<Division, String> {
    @Override
    public String convertToDatabaseColumn(Division division) {
        return division.getTexto();
    }

    @Override
    public Division convertToEntityAttribute(String s) {
        return Division.from(s);
    }
}
