package org.example.ejer05_06_Biblioteca;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class CategoriaConverter implements AttributeConverter<Categoria,String> {
    @Override
    public String convertToDatabaseColumn(Categoria categoria) {
        return categoria.getTextoCategoria();
    }

    @Override
    public Categoria convertToEntityAttribute(String s) {
        return Categoria.of(s);
    }
}
