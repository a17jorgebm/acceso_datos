//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.example.filosofos.dao;

import java.awt.Component;
import java.awt.Container;
import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Spring;
import javax.swing.SpringLayout;

public class FilosofosViewDAO extends JFrame {
    public static final String URL = "jdbc:h2:./db/filosofosv2.3;DATABASE_TO_UPPER=FALSE;DB_CLOSE_ON_EXIT=TRUE;FILE_LOCK=NO";
    public static final String DRIVER = "org.h2.Driver";
    public static final String[] ETIQUETAS = new String[]{"Nome: ", "Apelidos: ", "Idade: ", "Data Nacemento: "};
    private ResultSet rs;
    private JButton btSeguinte;
    private JButton btAnterior;
    private final JTextField[] campos = new JTextField[4];
    private JLabel etiquetaMensaxes;

    public FilosofosViewDAO(String var1) throws HeadlessException {
        super(var1);
        this.createGUI();
        this.pack();
        this.setDefaultCloseOperation(0);
        this.setLocationRelativeTo((Component)null);
        this.setConnection();
        this.setVisible(true);
    }

    private void createGUI() {
        this.add(new JPanel(), "After");
        this.add(new JPanel(), "Before");
        JPanel var1 = new JPanel(new SpringLayout());

        for(int var2 = 0; var2 < this.campos.length; ++var2) {
            JLabel var3 = new JLabel(ETIQUETAS[var2], 4);
            var1.add(var3);
            this.campos[var2] = new JTextField(16);
            var1.add(this.campos[var2]);
        }

        setGridCompacto(var1, ETIQUETAS.length, 2, 6, 6, 6, 6);
        this.add(var1);
        this.btAnterior = new JButton(" < ");
        this.btSeguinte = new JButton(" > ");
        this.btAnterior.addActionListener((var1x) -> {
            System.out.println("Atrás");

            try {
                if (this.rs.previous()) {
                    this.setValores();
                }
            } catch (SQLException var3) {
            }

        });
        this.btSeguinte.addActionListener((var1x) -> {
            System.out.println("Seguinte");

            try {
                if (this.rs.next()) {
                    this.setValores();
                }
            } catch (SQLException var3) {
            }

        });
        JPanel var4 = new JPanel();
        var4.add(this.btAnterior);
        var4.add(this.btSeguinte);
        this.etiquetaMensaxes = new JLabel("    ");
        var4.add(this.etiquetaMensaxes);
        this.add(var4, "Last");
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent var1) {
                super.windowClosing(var1);
                FilosofosViewDAO.this.sair();
            }
        });
    }

    private void setConnection() {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException var4) {
            System.out.println("Erro Drivers: " + var4.getMessage());
        }

        try {
            Connection connection = DriverManager.getConnection(URL);
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 1007);
            this.rs = stmt.executeQuery("SELECT idFilosofo, nome, apelidos, idade, dataNacemento FROM Filosofo");
            if (this.rs.next()) {
                this.setValores();
            }
        } catch (SQLException var3) {
            System.out.println("Erro na base de datos: " + var3.getMessage());
        }

    }

    private void sair() {
        if (JOptionPane.showConfirmDialog(this, "Queres saír?", "Cerrar programa", 0, 3) == 0) {
            try {
                this.rs.getStatement().getConnection().close();
            } catch (SQLException var2) {
            }

            System.exit(0);
        }

    }

    private void setValores() throws SQLException {
        if (this.rs != null && !this.rs.isClosed() && !this.rs.isBeforeFirst() && !this.rs.isAfterLast()) {
            this.campos[0].setText(this.rs.getString("nome"));
            this.campos[1].setText(this.rs.getString("apelidos"));
            this.campos[2].setText(this.rs.getString("idade"));
            this.campos[3].setText(String.valueOf(this.rs.getDate("dataNacemento")));
            this.etiquetaMensaxes.setText(String.valueOf(this.rs.getInt("idFilosofo")));
            this.btSeguinte.setEnabled(!this.rs.isLast());
            this.btAnterior.setEnabled(!this.rs.isFirst());
        }

    }

    public static void main(String[] var0) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JDialog.setDefaultLookAndFeelDecorated(true);
        new FilosofosViewDAO("Filósofos");
    }

    public static void setGridCompacto(Container var0, int var1, int var2, int var3, int var4, int var5, int var6) {
        SpringLayout var7;
        try {
            var7 = (SpringLayout)var0.getLayout();
        } catch (ClassCastException var14) {
            System.err.println("El componente debe tener SpringLayout.");
            return;
        }

        Spring var8 = Spring.constant(var3);

        for(int var9 = 0; var9 < var2; ++var9) {
            Spring var10 = Spring.constant(0);

            int var11;
            for(var11 = 0; var11 < var1; ++var11) {
                var10 = Spring.max(var10, getRestriccionesParaCelda(var11, var9, var0, var2).getWidth());
            }

            for(var11 = 0; var11 < var1; ++var11) {
                SpringLayout.Constraints var12 = getRestriccionesParaCelda(var11, var9, var0, var2);
                var12.setX(var8);
                var12.setWidth(var10);
            }

            var8 = Spring.sum(var8, Spring.sum(var10, Spring.constant(var5)));
        }

        Spring var15 = Spring.constant(var4);

        for(int var16 = 0; var16 < var1; ++var16) {
            Spring var18 = Spring.constant(0);

            int var19;
            for(var19 = 0; var19 < var2; ++var19) {
                var18 = Spring.max(var18, getRestriccionesParaCelda(var16, var19, var0, var2).getHeight());
            }

            for(var19 = 0; var19 < var2; ++var19) {
                SpringLayout.Constraints var13 = getRestriccionesParaCelda(var16, var19, var0, var2);
                var13.setY(var15);
                var13.setHeight(var18);
            }

            var15 = Spring.sum(var15, Spring.sum(var18, Spring.constant(var6)));
        }

        SpringLayout.Constraints var17 = var7.getConstraints(var0);
        var17.setConstraint("South", var15);
        var17.setConstraint("East", var8);
    }

    private static SpringLayout.Constraints getRestriccionesParaCelda(int var0, int var1, Container var2, int var3) {
        SpringLayout var4 = (SpringLayout)var2.getLayout();
        Component var5 = var2.getComponent(var0 * var3 + var1);
        return var4.getConstraints(var5);
    }
}