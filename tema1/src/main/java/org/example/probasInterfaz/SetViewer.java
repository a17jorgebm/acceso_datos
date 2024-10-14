package org.example.probasInterfaz;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class SetViewer extends JFrame {
    public SetViewer() {
        // Configuración de la ventana
        setTitle("Visualización de un Set");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear un Set de ejemplo
        Set<String> datos = new HashSet<>();
        datos.add("Elemento 1");
        datos.add("Elemento 2");
        datos.add("Elemento 3");
        datos.add("Elemento 4");

        // Convertir el Set en un arreglo para mostrarlo en el JList
        String[] datosArray = datos.toArray(new String[0]);
        JList<String> lista = new JList<>(datosArray);

        // Añadir el JList a un JScrollPane
        JScrollPane scrollPane = new JScrollPane(lista);

        // Añadir el JScrollPane al contenido de la ventana
        add(scrollPane, BorderLayout.CENTER);
    }
}
