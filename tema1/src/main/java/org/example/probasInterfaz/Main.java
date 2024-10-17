import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal {

    public static void main(String[] args) {
        // Crear la ventana principal
        JFrame ventanaPadre = new JFrame("Ventana Principal");
        ventanaPadre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaPadre.setSize(300, 200);
        ventanaPadre.setLocationRelativeTo(null); // Centrar en la pantalla

        // Botón para abrir la ventana secundaria
        JButton botonAbrir = new JButton("Abrir Ventana Secundaria");
        botonAbrir.addActionListener(e -> abrirVentanaSecundaria(ventanaPadre));

        ventanaPadre.add(botonAbrir, BorderLayout.CENTER);
        ventanaPadre.setVisible(true);
    }

    // Método para abrir una ventana secundaria
    private static void abrirVentanaSecundaria(JFrame ventanaPadre) {
        // Crear la ventana secundaria como un JDialog
        JDialog ventanaSecundaria = new JDialog(ventanaPadre, "Ventana Secundaria", true); // true para que sea modal
        ventanaSecundaria.setSize(250, 150);
        ventanaSecundaria.setLocationRelativeTo(ventanaPadre); // Centrar respecto a la ventana padre

        // Un mensaje en la ventana secundaria
        JLabel mensaje = new JLabel("Esta es la ventana secundaria.", SwingConstants.CENTER);
        ventanaSecundaria.add(mensaje, BorderLayout.CENTER);

        // Botón para cerrar la ventana secundaria
        JButton botonCerrar = new JButton("Cerrar");
        botonCerrar.addActionListener(e -> ventanaSecundaria.dispose()); // Cerrar la ventana
        ventanaSecundaria.add(botonCerrar, BorderLayout.SOUTH);

        ventanaSecundaria.setVisible(true); // Mostrar la ventana secundaria
    }
}