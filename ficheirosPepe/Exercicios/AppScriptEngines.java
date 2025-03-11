/*
 * Autor: Pepe Calo
 * Realizado con fines educativos.s
 * Puede modificarlo siempre que no lo haga con fines comerciales.
 */

package com.pepinho.programacion.json.docencia;

import java.util.List;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;

/**
 *
 * @author pepe
 */


public class AppScriptEngines {
//  public static void main(String[] args) {
//    ScriptEngineManager manager = new ScriptEngineManager();
//    List<ScriptEngineFactory> factories = manager.getEngineFactories();
//
//    for (ScriptEngineFactory factory : factories) {
//        System.out.println("\nName : " + factory.getEngineName());
//        System.out.println("Version : " + factory.getEngineVersion());
//        System.out.println("Language name : " + factory.getLanguageName());
//        System.out.println("Language version : " + factory.getLanguageVersion());
//        System.out.println("Extensions : " + factory.getExtensions());
//        System.out.println("Mime types : " + factory.getMimeTypes());
//        System.out.println("Names : " + factory.getNames());
//        ScriptEngine engine = manager.getEngineByName(factory.getNames().get(0));
//        if (engine == null) {
//            System.out.println("Impossible to find the engine with name " + factory.getEngineName()+"\n");
//        }
//
//    }
//   }
      public static void main(String[] args) {
        // Crear un gestor de motores de script
        ScriptEngineManager manager = new ScriptEngineManager();

        // Obtener la lista de motores de script instalados
        List<ScriptEngineFactory> engineFactories = manager.getEngineFactories();

        if (engineFactories.isEmpty()) {
            System.out.println("No se encontraron motores de script instalados.");
        } else {
            System.out.println("Motores de script instalados:");

            // Iterar sobre la lista de fábricas de motores de script
            for (ScriptEngineFactory factory : engineFactories) {
                System.out.println("Nombre: " + factory.getEngineName());
                System.out.println("Versión: " + factory.getEngineVersion());
                System.out.println("Lenguaje: " + factory.getLanguageName());
                System.out.println("Versión del lenguaje: " + factory.getLanguageVersion());

                // Verificar si es el motor de JavaScript
                if ("ECMAScript".equals(factory.getLanguageName())) {
                    System.out.println("Este es el motor de JavaScript.");
                    // Puedes agregar información específica para el motor de JavaScript aquí.
                }

                // Lista de extensiones de archivo asociadas con el motor de script
                List<String> extensions = factory.getExtensions();
                System.out.println("Extensiones de archivo: " + extensions);

                // Lista de nombres de mimetypes asociados con el motor de script
                List<String> mimeTypes = factory.getMimeTypes();
                System.out.println("MimeTypes: " + mimeTypes);

                System.out.println("-----");
            }
        }
    }
 }

