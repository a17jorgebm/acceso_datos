package com.pepinho.ad.codigopostal.view;

import com.pepinho.ad.codigopostal.control.ICodigoPostalController;

import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import java.awt.*;

/**
 * Created by Pepinho on 20/10/2016.
 * Ventana principal de la aplicación que muestra los datos de un código postal bajo petición del usuario.
 * Dispone de un campo de texto para introducir el código postal y un botón para realizar la petición.
 * Una vez ejecutada la petición, se mostrarán los datos del código postal en un panel con un formato de texto HTML,
 * de tipo JEditorPane.
 */
public class VentaCodigoPostal extends JFrame implements IVistaCodigoPostal {

    // Controlador de la vista
    private ICodigoPostalController codigoPostalController;
    // Panel principal de la ventana en la que se muestran los datos.
    private JEditorPane panelDatos;
    // Panel principal de la ventana
    private JPanel panelPrincipal;

    public VentaCodigoPostal(ICodigoPostalController codigoPostalController) {
        super("Código Postal");
        this.codigoPostalController = codigoPostalController;

        // Creamos los componentes de la ventana
        initComponents();

        // Eventos: Cerrar la ventana al pulsar la X
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        // preguntamos por medio de una expresión lambda del método windowClosing
        // si se quiere cerrar la ventana
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                if (JOptionPane.showConfirmDialog(null, "¿Desea cerrar el buscador de códigos?",
                        "Salir de la aplicación", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        // Centramos la ventana en la pantalla
        this.setLocationRelativeTo(null);
    }

    // Crea los componentes de la ventana principal con sus propiedades.

    private void initComponents() {
        panelPrincipal = new JPanel();
        JLabel etiquetaTitulo = new JLabel("Buscador de códigos postales");
        etiquetaTitulo.setFont(new Font("Tahoma", 1, 18)); // NOI18N
        // Poner color a la etiqueta
//        etiquetaTitulo.setForeground(new java.awt.Color(167, 171, 136));

        JLabel etiquetaAutor = new JLabel("Pepinho");
        etiquetaAutor.setFont(new Font("Tahoma", 0, 12)); // NOI18N
//        etiquetaAutor.setForeground(new java.awt.Color(167, 171, 136));

        JLabel etiquetaVersion = new JLabel("0.1");
        etiquetaVersion.setFont(new Font("Tahoma", 0, 12)); // NOI18N
//        etiquetaVersion.setForeground(new java.awt.Color(167, 171, 136));

        JLabel etiquetaCodigoPostal = new JLabel("Código Postal:");
        etiquetaCodigoPostal.setFont(new Font("Tahoma", 0, 12)); // NOI18N
//        etiquetaAutor.setForeground(new java.awt.Color(167, 171, 136));

        JTextField cajaCodigoPostal = new JTextField();
        cajaCodigoPostal.setFont(new Font("Tahoma", 0, 12)); // NOI18N
//        cajaCodigoPostal.setForeground(new java.awt.Color(167, 171, 136));

        cajaCodigoPostal.setToolTipText("Introduzca el código postal");

        JButton botonBuscar = new JButton("Buscar");
        botonBuscar.setFont(new Font("Tahoma", 0, 12)); // NOI18N
//        botonBuscar.setForeground(new java.awt.Color(167, 171, 136));

        JLabel etiquetaDatos = new JLabel("Lugares");
        etiquetaDatos.setFont(new Font("Tahoma", 0, 12)); // NOI18N
//        etiquetaDatos.setForeground(new java.awt.Color(167, 171, 136));

        JScrollPane scrollPanelDatos = new JScrollPane();
        // panel para mostrar los datos del código postal

//        panelPrincipal.setBackground(new java.awt.Color(43, 43, 43));

        panelDatos = new JEditorPane();
        panelDatos.setEditable(false);
//        panelDatos.setBackground(new java.awt.Color(43, 43, 43));
        panelDatos.setContentType("text/html"); // NOI18N
        // Decoración del panel, no editable, pero que se pueda seleccionar el texto
        // ASigno al panel datos el color Dark de fondo y de texto, al estilo IntelliJ IDEA
//        panelDatos.setBackground(new java.awt.Color(60, 63, 65));
//        panelDatos.setForeground(new java.awt.Color(124, 126, 127));
        panelDatos.setDragEnabled(true);
        // Asignamos el tipo de fuente al panel de datos
        panelDatos.setFont(new Font("Tahoma", 0, 12)); // NOI18N

        // Creo un HTMLDocument para aplicar estilos al panel de datos
        // https://docs.oracle.com/javase/tutorial/uiswing/components/editorpane.html
        // https://docs.oracle.com/javase/tutorial/uiswing/components/text.html

        HTMLDocument doc = (HTMLDocument) panelDatos.getDocument();
        // Asigno al panel datos el color Dark de fondo y de texto, al estilo Dark Nimbus
        doc.getStyleSheet().addRule("body {color: #7C7E7F; background-color: #3C3F41; font-family: Tahoma; font-size: 12pt; }");
        doc.getStyleSheet().addRule("h1 {color: #7C7E7F; background-color: #3C3F41; font-family: Tahoma; font-size: 12pt; }");
        doc.getStyleSheet().addRule("h2 {color: #7C7E7F; background-color: #3C3F41; font-family: Tahoma; font-size: 12pt; }");
        doc.getStyleSheet().addRule("h3 {color: #7C7E7F; background-color: #3C3F41; font-family: Tahoma; font-size: 12pt; }");
        doc.getStyleSheet().addRule("h4 {color: #7C7E7F; background-color: #3C3F41; font-family: Tahoma; font-size: 12pt; }");
        doc.getStyleSheet().addRule("h5 {color: #7C7E7F; background-color: #3C3F41; font-family: Tahoma; font-size: 12pt; }");
        doc.getStyleSheet().addRule("h6 {color: #7C7E7F; background-color: #3C3F41; font-family: Tahoma; font-size: 12pt; }");
        doc.getStyleSheet().addRule("p {color: #7C7E7F; background-color: #3C3F41; font-family: Tahoma; font-size: 12pt; }");
        doc.getStyleSheet().addRule("pre {color: #7C7E7F; background-color: #3C3F41; font-family: Tahoma; font-size: 10pt; }");
        doc.getStyleSheet().addRule("span {color: #7C7E7F; background-color: #3C3F41; font-family: Tahoma; font-size: 10pt; }");
        doc.getStyleSheet().addRule("table {color: #7C7E7F; background-color: #3C3F41; font-family: Tahoma; font-size: 10pt; }");
        doc.getStyleSheet().addRule("td {color: #7C7E7F; background-color: #3C3F41; font-family: Tahoma; font-size: 10pt; }");
        doc.getStyleSheet().addRule("th {color: #7C7E7F; background-color: #3C3F41; font-family: Tahoma; font-size: 10pt; }");
        doc.getStyleSheet().addRule("tr {color: #7C7E7F; background-color: #3C3F41; font-family: Tahoma; font-size: 10pt; }");
        doc.getStyleSheet().addRule("ul {color: #7C7E7F; background-color: #3C3F41; font-family: Tahoma; font-size: 11pt; }");
        doc.getStyleSheet().addRule("ol {color: #7C7E7F; background-color: #3C3F41; font-family: Tahoma; font-size: 11pt; }");
        doc.getStyleSheet().addRule("li {color: #7C7E7F; background-color: #3C3F41; font-family: Tahoma; font-size: 11pt; }");
        doc.getStyleSheet().addRule("a {color: #7C7E7F; background-color: #3C3F41; font-family: Tahoma; font-size: 11pt; }");
        doc.getStyleSheet().addRule("b {color: #7C7E7F; background-color: #3C3F41; font-family: Tahoma; font-size: 11pt; font-weight: bold; }");
        doc.getStyleSheet().addRule("i {color: #7C7E7F; background-color: #3C3F41; font-family: Tahoma; font-size: 11pt; font-style: italic; }");
        doc.getStyleSheet().addRule("u {color: #7C7E7F; background-color: #3C3F41; font-family: Tahoma; font-size: 11pt; text-decoration: underline; }");
        doc.getStyleSheet().addRule("strike {color: #7C7E7F; background-color: #3C3F41; font-family: Tahoma; font-size: 11pt;text-decoration: line-through; }");
        doc.getStyleSheet().addRule("sup {color: #7C7E7F; background-color: #3C3F41; font-family: Tahoma; font-size: 8pt; vertical-align: super; }");
        doc.getStyleSheet().addRule("sub {color: #7C7E7F; background-color: #3C3F41; font-family: Tahoma; font-size: 8pt; vertical-align: sub; }");
        doc.getStyleSheet().addRule("em {color: #7C7E7F; background-color: #3C3F41; font-family: Tahoma; font-size: 11pt;font-style: italic; }");
        doc.getStyleSheet().addRule("strong {color: #7C7E7F; background-color: #3C3F41; font-family: Tahoma; font-size: 11pt;font-weight: bold; }");
        doc.getStyleSheet().addRule("blockquote {color: #7C7E7F; background-color: #3C3F41; font-family: Tahoma; font-size: 9pt; }");
        doc.getStyleSheet().addRule("code {color: #7C7E7F; background-color: #3C3F41; font-family: Tahoma; font-size: 9pt; }");
        doc.getStyleSheet().addRule("del {color: #7C7E7F; background-color: #3C3F41; font-family: Tahoma; font-size: 9pt; }");
        doc.getStyleSheet().addRule("hr {color: #7C7E7F; background-color: #3C3F41; font-family: Tahoma; font-size: 9pt; }");
        doc.getStyleSheet().addRule("br {color: #7C7E7F; background-color: #3C3F41; font-family: Tahoma; font-size: 9pt; }");
        doc.getStyleSheet().addRule("background-color: #3C3F41;");


        // Añado el panel de datos al scrollPanelDatos:
        scrollPanelDatos.setViewportView(panelDatos);

        // Layout de la ventana (con asistente ;-)
        GroupLayout panelPrincipalLayout = new GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
                panelPrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelPrincipalLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelPrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(scrollPanelDatos)
                                        .addGroup(panelPrincipalLayout.createSequentialGroup()
                                                .addComponent(etiquetaTitulo)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(etiquetaAutor)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(etiquetaVersion))
                                        .addGroup(panelPrincipalLayout.createSequentialGroup()
                                                .addComponent(etiquetaCodigoPostal)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cajaCodigoPostal, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(botonBuscar)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(panelPrincipalLayout.createSequentialGroup()
                                                .addComponent(etiquetaDatos)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())

        );
        panelPrincipalLayout.setVerticalGroup(
                panelPrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelPrincipalLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelPrincipalLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(etiquetaTitulo)
                                        .addComponent(etiquetaAutor)
                                        .addComponent(etiquetaVersion))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelPrincipalLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(etiquetaCodigoPostal)
                                        .addComponent(cajaCodigoPostal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(botonBuscar))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(etiquetaDatos)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(scrollPanelDatos, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                .addContainerGap())
        );

        //  añadimos el listener al botón
        botonBuscar.addActionListener(evt -> {
            //  asignamos los datos al panel
            panelDatos.setText(codigoPostalController.getLugares(cajaCodigoPostal.getText(), true));
        });

        //  añadimos el listener a la caja de texto si pulsamos enter
        cajaCodigoPostal.addActionListener(evt -> {
            //  asignamos los datos al panel
            panelDatos.setText(codigoPostalController.getLugares(cajaCodigoPostal.getText(), true));
        });

        // Decoración de la ventana
//        this.getRootPane().setWindowDecorationStyle(JRootPane.INFORMATION_DIALOG);

        // añadimos el panel principal a la ventana
        add(panelPrincipal, BorderLayout.CENTER);

        // ajustamos el tamaño de la ventana a los componentes que contiene
//        setDark();
        // Estilo Dark Nimbus del JFrame VEntanaCodigoPostal
        // Con UIManager se cambia el aspecto de los componentes de Swing
        // https://docs.oracle.com/javase/tutorial/uiswing/lookandfeel/_nimbusDefaults.html
        // https://docs.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
        // https://docs.oracle.com/javase/tutorial/uiswing/lookandfeel/defaults.html
        // https://docs.oracle.com/javase/tutorial/uiswing/lookandfeel/color.html
        // https://docs.oracle.com/javase/tutorial/uiswing/lookandfeel/properties.html
        // https://docs.oracle.com/javase/tutorial/uiswing/lookandfeel/optionpane.html


        try {

            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {

        }

        pack();

    }

    /**
     * Método privado que asigna a los componentes un aspecto Dark con los colores típicos
     * del estilo Dark Nimbus.
     *
     * @param panel panel al que se le asignará el aspecto Dark.
     */
    private void setDark(JComponent panel) {
        panel.setBackground(new Color(43, 43, 43));
        panel.setForeground(new Color(167, 171, 136));
    }

    /**
     * Método privado que asigna a todos los componentes de la ventana, de menera recursiva también
     * los elementos internos de los paneles, botones, etiquetas y cajas de texto
     * un aspecto Dark con los colores típicos del estilo Dark Nimbus.
     */
    private void setDarkAll() {
        // recorro todos los componentes del JFrame y les asigno el aspecto Dark
        for (int i = 0; i < panelPrincipal.getComponentCount(); i++) {
            if (panelPrincipal.getComponent(i) instanceof JScrollPane)
                setDark((JComponent) ((JScrollPane) panelPrincipal.getComponent(i)).getViewport().getView());
            else
                setDark((JComponent) panelPrincipal.getComponent(i));
        }
    }

    private void setDark() {
        // recorro todos los componentes del JFrame y les asigno el aspecto Dark
        for (int i = 0; i < panelPrincipal.getComponentCount(); i++) {
            setDark((JComponent) panelPrincipal.getComponent(i));
        }
    }

    /**
     * Devuelve el panel principal de la ventana.
     *
     * @return panel principal de la ventana.
     */
    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    @Override
    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void addLugar(String lugar) {
        panelDatos.setText(panelDatos.getText() + System.lineSeparator() + lugar);

    }

    @Override
    public void deleteLugares() {
        panelDatos.setText("");

    }

    @Override
    public void setLugares(String lugares) {
        //  asignamos los datos al panel
        panelDatos.setText(lugares);

    }

    public void setController(ICodigoPostalController controller) {
        this.codigoPostalController = controller;
    }

    @Override
    public void mostrar() {
        this.setVisible(true);
    }

}


