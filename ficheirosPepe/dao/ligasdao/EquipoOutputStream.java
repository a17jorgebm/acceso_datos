package com.pepinho.ad.e05baloncesto.basketdao;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * Clase que extiende ObjectOutputStream para evitar que escriba la cabecera del stream.
 * Sólo la usaremos para escribir objetos de la clase Equipo en un fichero binario con ObjectOutputStream.
 * El fichero debe existir previamente.
 */
public class EquipoOutputStream extends ObjectOutputStream {
    public EquipoOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    @Override
    protected void writeStreamHeader() throws IOException {
        // No escribir la cabecera
        reset();
    }


}
