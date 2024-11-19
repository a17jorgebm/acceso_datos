package org.example.serializacion_objetos_ficheiros;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class AppendObjectOutputStream extends ObjectOutputStream {
    public AppendObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    @Override
    public void writeStreamHeader() throws IOException {
        //pa que non escribe o header no arquivo, facendo que se corrompa
    }
}
