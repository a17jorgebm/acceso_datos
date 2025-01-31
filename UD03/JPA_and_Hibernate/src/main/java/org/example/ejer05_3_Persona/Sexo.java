package org.example.ejer05_3_Persona;

public enum Sexo {
    HOMBRE('H'),MUJER('M');

    private Character character;

    Sexo(Character character){
        this.character=character;
    }

    public Character getCharacter(){
        return character;
    }

    public static Sexo getSexoFromCharacter(Character character){
        for (int i=0;i<Sexo.values().length;i++){
            if (Sexo.values()[i].getCharacter().equals(character)){
                return Sexo.values()[i];
            }
        }
        return null;
    }
}
