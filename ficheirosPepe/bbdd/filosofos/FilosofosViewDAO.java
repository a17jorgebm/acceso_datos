/*
 * Autor: Pepe Calo
 * Realizado con fines educativos.
 * Puede modificarlo siempre que no lo haga con fines comerciales.
 */
package com.pepinho.programacion.filosofos.dao;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author pepecalo
 */
public class FilosofosViewDAO extends JFrame {

    public static final String URL = "jdbc:h2:E:\\98 - Bases de datos\\h2\\bd\\filosofosv2.3"
            + ";DATABASE_TO_UPPER=FALSE;DB_CLOSE_ON_EXIT=TRUE;FILE_LOCK=NO";
    public static final String DRIVER = "org.h2.Driver";

    public static final String[] ETIQUETAS = {"Nome: ", "Apelidos: ",
        "Idade: ", "Data Nacemento: "};

    private ResultSet rs;

    private JButton btSeguinte;
    private JButton btAnterior;
    private final JTextField[] campos = new JTextField[4];
    private JLabel etiquetaMensaxes;
    private JButton btActualizar;
    private JButton btLimpar;
    private JButton btNovo;

    public FilosofosViewDAO(String title) throws HeadlessException {
        super(title);
        createGUI();
        pack();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setConnection();
        setVisible(true);
    }

    private void createGUI() {
        add(new JPanel(), BorderLayout.LINE_END);
        add(new JPanel(), BorderLayout.LINE_START);
        // Panel central:
        JPanel panelCentral = new JPanel(new SpringLayout());

        for (int i = 0; i < campos.length; i++) {
            JLabel etiqueta = new JLabel(ETIQUETAS[i], JLabel.RIGHT);
            panelCentral.add(etiqueta);
            campos[i] = new JTextField(16);
            panelCentral.add(campos[i]);
        }
        setGridCompacto(panelCentral,
                ETIQUETAS.length, 2, //filas, columnas
                6, 6, //initX, initY
                6, 6);       //xPad, yPad
        add(panelCentral);

        // PANEL SUR:
        btAnterior = new JButton(" < ");
        btSeguinte = new JButton(" > ");
        btAnterior.addActionListener((ActionEvent e) -> {
            System.out.println("Atrás");
            try {
                if (rs.previous()) setValores();
            } catch (SQLException ex) {}

        });
        btSeguinte.addActionListener( e -> {
            System.out.println("Seguinte");
            try {
                if (rs.next()) setValores();
            } catch (SQLException ex) {}

        });

        JPanel panelSur = new JPanel();
        panelSur.add(btAnterior);
        panelSur.add(btSeguinte);
        etiquetaMensaxes = new JLabel("    ");
        panelSur.add(etiquetaMensaxes);
        add(panelSur, BorderLayout.PAGE_END);


        //
        JPanel panelSup = new JPanel();
        btActualizar = new JButton("Actualizar");
        btActualizar.addActionListener( e -> {

        });
        btLimpar = new JButton("Limpar");
        btActualizar.addActionListener( e -> {

        });
        btNovo = new JButton("Novo");
        btNovo.addActionListener( e -> {

        });

        panelSup.add(btActualizar);
        panelSup.add(btLimpar);
        panelSup.add(btNovo);

        add(panelSup, BorderLayout.PAGE_START);


        // Eventos
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                sair();
            }
        });

    }

    private void setConnection() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro Drivers: " + ex.getMessage());
        }
        try {
            Connection con = DriverManager.getConnection(URL);
            Statement st = con.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            rs = st.executeQuery("SELECT idFilosofo, nome, apelidos, "
                    + "idade, dataNacemento FROM Filosofo");
            if (rs.next()) {
                setValores();
            }
        } catch (SQLException ex) {
            System.out.println("Erro na base de datos: " + ex.getMessage());
        }
    }

    private void sair() {
        if (JOptionPane.showConfirmDialog(this, "Queres saír?",
                "Cerrar programa", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        ) == JOptionPane.YES_OPTION) {
            try {
                rs.getStatement().getConnection().close();
            } catch (SQLException ex) {
                
            }
            System.exit(0);
        }
    }

    private void setValores() throws SQLException {
        if (rs != null && !rs.isClosed()
                && !rs.isBeforeFirst() && !rs.isAfterLast()) {
            campos[0].setText(rs.getString("nome"));
            campos[1].setText(rs.getString("apelidos"));
            campos[2].setText(rs.getString("idade"));
            campos[3].setText(String.valueOf(rs.getDate("dataNacemento")));
            etiquetaMensaxes.setText(String.valueOf(rs.getInt("idFilosofo")));
            // 
            btSeguinte.setEnabled(!rs.isLast());
            btAnterior.setEnabled(!rs.isFirst());
        }
    }

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JDialog.setDefaultLookAndFeelDecorated(true);
        new FilosofosViewDAO("Filósofos");
    }

    /*
    Métodos para el SpringLayout
     */
    public static void setGridCompacto(Container contenedor,
            int filas, int columnas,
            int xInicial, int yInicial,
            int xPad, int yPad) {
        // Obtenermos el layout del contenedor:
        SpringLayout layout;
        try {
            layout = (SpringLayout) contenedor.getLayout();
        } catch (ClassCastException exc) {
            System.err.println("El componente debe tener SpringLayout.");
            return;
        }

        // Alineamos las celdas en cada columna y les damos el mismo tamaño:
        Spring x = Spring.constant(xInicial);
        for (int c = 0; c < columnas; c++) {
            Spring ancho = Spring.constant(0);
            for (int fila = 0; fila < filas; fila++) {
                ancho = Spring.max(ancho,
                        getRestriccionesParaCelda(fila, c, contenedor, columnas)
                                .getWidth());
            }
            for (int fila = 0; fila < filas; fila++) {
                SpringLayout.Constraints constraints
                        = getRestriccionesParaCelda(fila, c, contenedor, columnas);
                constraints.setX(x);
                constraints.setWidth(ancho);
            }
            x = Spring.sum(x, Spring.sum(ancho, Spring.constant(xPad)));
        }

        //Alinea todas las celdas de cada fila y las hace del mismo tamaño
        Spring y = Spring.constant(yInicial);
        for (int fila = 0; fila < filas; fila++) {
            Spring altura = Spring.constant(0);
            for (int c = 0; c < columnas; c++) {
                altura = Spring.max(altura,
                        getRestriccionesParaCelda(fila, c, contenedor, columnas)
                                .getHeight());
            }
            for (int c = 0; c < columnas; c++) {
                SpringLayout.Constraints constraints
                        = getRestriccionesParaCelda(fila, c, contenedor, columnas);
                constraints.setY(y);
                constraints.setHeight(altura);
            }
            y = Spring.sum(y, Spring.sum(altura, Spring.constant(yPad)));
        }

        // Asignamos el tamaño del contenedor.
        SpringLayout.Constraints pCons = layout.getConstraints(contenedor);
        pCons.setConstraint(SpringLayout.SOUTH, y);
        pCons.setConstraint(SpringLayout.EAST, x);
    }

    private static SpringLayout.Constraints getRestriccionesParaCelda(
            int fila, int columna,
            Container padre,
            int columnas) {
        SpringLayout layout = (SpringLayout) padre.getLayout();
        Component c = padre.getComponent(fila * columnas + columna);
        return layout.getConstraints(c);
    }

}
