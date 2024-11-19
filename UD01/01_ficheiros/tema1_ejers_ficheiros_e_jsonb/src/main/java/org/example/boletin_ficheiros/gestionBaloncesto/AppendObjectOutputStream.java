package org.example.boletin_ficheiros.gestionBaloncesto;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class AppendObjectOutputStream extends ObjectOutputStream{

    public AppendObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    @Override
    public void writeStreamHeader(){
        //non fai nada
    }
}
