package org.example.boletin_ficheiros.ejer2;

import java.io.File;

public class EstatisticaFile {
    private File arquivo;
    private int linhas;
    private int letras;
    private int espazos;

    public EstatisticaFile(File arquivo){
        this.arquivo=arquivo;
    }

    public boolean existe(){
        return this.arquivo.isFile();
    }

    public long ultimaModificacion(){
        return this.arquivo.lastModified();
    }

    public String getRuta(){
        return this.arquivo.getAbsolutePath();
    }
}
