package org.example.boletin03_json.ejer1;

import java.io.File;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;

public class EjecutarJs {
    public static void main(String[] args) {
        File arquivoJs=new File("src/main/java/org/example/boletin03/codigoJs.js");

        ScriptEngineManager manager = new ScriptEngineManager();// Inicio el API de Scripting

        for (ScriptEngineFactory f: manager.getEngineFactories()){
            System.out.println(f.getNames());
        }

        //ScriptEngine engine = manager.getEngineByName("ECMAScript");

        return;
        /*
        try {
            engine.eval(new FileReader(arquivoJs)); // Sí, los flujos con importantes
        } catch (ScriptException se) {
            err.println(se.getMessage());
        } catch (IOException ioe) {
            err.println(ioe.getMessage());
        }*/
    }
}
