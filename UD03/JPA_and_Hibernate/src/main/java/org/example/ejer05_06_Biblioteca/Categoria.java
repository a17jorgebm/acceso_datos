package org.example.ejer05_06_Biblioteca;

public enum Categoria {
    NOVELA("Novela"),
    POESIA("Poesía"),
    ENSAYO("Ensayo"),
    TEATRO("Teatro"),
    OTROS("Otros");

    private String textoCategoria;

    Categoria(String textoCategoria){
        this.textoCategoria=textoCategoria;
    }

    public String getTextoCategoria() {
        return textoCategoria;
    }

    public static Categoria of(String texto){
        for (int i=0;i<Categoria.values().length;i++){
            Categoria actual = Categoria.values()[i];
            if (actual.getTextoCategoria().equals(texto)){
                return actual;
            }
        }
        return null;
    }
}
