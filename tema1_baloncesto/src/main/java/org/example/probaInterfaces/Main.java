package org.example.probaInterfaces;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Crear la interfaz en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> {
            SetViewer viewer = new SetViewer();
            viewer.setVisible(true);
        });
    }
}
