package org.example.ejer05_3_Persona;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class SexoConverter implements AttributeConverter<Sexo,Character> {
    @Override
    public Character convertToDatabaseColumn(Sexo sexo) {
        return sexo.getCharacter();
    }

    @Override
    public Sexo convertToEntityAttribute(Character s) {
        return Sexo.getSexoFromCharacter(s);
    }
}
