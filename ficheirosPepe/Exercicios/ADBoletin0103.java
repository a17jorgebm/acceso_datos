/*
 * Autor: Pepe Calo
 * Realizado con fines educativos.s
 * Puede modificarlo siempre que no lo haga con fines comerciales.
 */
package com.pepinho.programacion.json.adboletin0103;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static java.lang.System.err;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 *
 * @author pepe
 */
public class ADBoletin0103 {

    public static void main(String[] args) {
        ScriptEngineManager manager = new ScriptEngineManager(); // Inicio el API de Scripting

        // Ver la lista de motores disponibles:
        List<ScriptEngineFactory> lista = manager.getEngineFactories();

        for(ScriptEngineFactory f: lista) {
            System.out.println("Nombre: " + f.getEngineName());
            System.out.println("Versión: " + f.getEngineVersion());
            System.out.println("Engine short names: " + f.getNames());
        }
        //


        ScriptEngine engine = manager.getEngineByName("JS");
        try {
            engine.eval(new FileReader("e:\\poeta.js")); // Sí, los flujos con importantes
        } catch (ScriptException se) {
            err.println(se.getMessage());
        } catch (IOException ioe) {
            err.println(ioe.getMessage());
        }
    }
}
