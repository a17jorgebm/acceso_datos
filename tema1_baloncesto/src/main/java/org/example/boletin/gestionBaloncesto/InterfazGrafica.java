package org.example.boletin.gestionBaloncesto;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import java.util.Timer;
import java.util.function.Consumer;
import java.util.function.Function;

import org.example.boletin.gestionBaloncesto.Funcions.*;
import org.example.boletin.gestionBaloncesto.dao_implementations.ImpDaoClasificacion;

import static org.example.boletin.gestionBaloncesto.Funcions.cambiarValoresGBC;
import static org.example.boletin.gestionBaloncesto.Funcions.crearTexto;

public class InterfazGrafica {
    private static final Color COLOR_CLASIFICACIONS=Color.decode("#e97d34");
    private static final Color COLOR_EQUIPOS=Color.decode("#ec8b4a");
    private static final Color COLOR_PARTIDOS=Color.decode("#ee9a61");


    private JFrame ventana;
    private JLayeredPane panelMensajes;
    private GridBagConstraints gbc;
    private Insets insets;

    public InterfazGrafica(){
        //configurar ventana
        this.ventana=new JFrame();
        this.ventana.setMinimumSize(new Dimension(800,600));
        this.ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.ventana.setTitle("Gestion de equipos de baloncesto");
        this.ventana.setLayout(new GridBagLayout());
        ventana.setVisible(true);

        this.panelMensajes=ventana.getLayeredPane(); //panel para la gestion de mensajes

        //crear gridBagLayoutConstraints
        this.gbc=new GridBagConstraints();
        cambiarValoresGBC(gbc,0,0,1,1,1,1,GridBagConstraints.BOTH);

        //inicializar insets
        this.insets=new Insets(0,0,0,0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            InterfazGrafica interfazGrafica = new InterfazGrafica();
            interfazGrafica.verPanelInicio();
        });
    }

    public void verPanelInicio(){
        limpiarVentana();
        JPanel panel=new JPanel();
        panel.setLayout(new GridBagLayout());

        JPanel clasificaciones=new JPanel();
        clasificaciones.setLayout(new GridBagLayout());
        clasificaciones.setBackground(COLOR_CLASIFICACIONS);
        clasificaciones.add(crearTexto("Clasificaciones"));
        cambiarValoresGBC(gbc,0,0,1,1,1,1,GridBagConstraints.BOTH);
        panel.add(clasificaciones,gbc);
        clasificaciones.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                verPanelClasificaciones();
            }
            @Override
            public void mouseEntered(MouseEvent e){
                clasificaciones.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e){
                clasificaciones.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        JPanel equipos=new JPanel();
        equipos.setLayout(new GridBagLayout());
        equipos.setBackground(COLOR_EQUIPOS);
        equipos.add(crearTexto("Equipos"));
        insets.set(0,10,0,10);
        cambiarValoresGBC(gbc,1,0,1,1,1,1,GridBagConstraints.BOTH,insets);
        panel.add(equipos,gbc);
        equipos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                verPanelEquipos();
            }
            @Override
            public void mouseEntered(MouseEvent e){
                equipos.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e){
                equipos.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        JPanel partidos=new JPanel();
        partidos.setLayout(new GridBagLayout());
        partidos.setBackground(COLOR_PARTIDOS);
        partidos.add(crearTexto("Partidos"));
        cambiarValoresGBC(gbc,2,0,1,1,1,1,GridBagConstraints.BOTH);
        panel.add(partidos,gbc);
        partidos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                verPanelPartidos();
            }
            @Override
            public void mouseEntered(MouseEvent e){
                partidos.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e){
                partidos.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        cambiarPanelPrincipal(panel);
    }

    public void verPanelClasificaciones(){
        LinkedHashSet<Clasificacion> clasificacions=null;
        try{
            ImpDaoClasificacion daoClasi=new ImpDaoClasificacion();
            clasificacions=(LinkedHashSet<Clasificacion>) daoClasi.getAll();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return;
        }

        JPanel panelBase=getPanelBaseConHeader("Clasificacions",COLOR_CLASIFICACIONS);
        JPanel panelContido=getPanelParaEngadirContidoAoPanelBase(panelBase);
        panelContido.setBorder(new EmptyBorder(10,10,10,10));

        //FORMULARIO DE CREACIÓN/////////////////////
        JPanel formularioCrear=new JPanel();
        formularioCrear.setLayout(new GridBagLayout());
        formularioCrear.setBorder(new EmptyBorder(20,20,20,20));
        cambiarValoresGBC(gbc,0,0,0.4,1,1,1,GridBagConstraints.BOTH);
        panelContido.add(formularioCrear,gbc);

        cambiarValoresGBC(gbc,0,0,1,1,1,1,GridBagConstraints.NONE);
        formularioCrear.add(crearTexto("Nombre nueva clasificación:",15,Color.BLACK),gbc);
        JTextField txtNombreClasificacion=new JTextField();
        cambiarValoresGBC(gbc,0,1,1,1,1,1,GridBagConstraints.HORIZONTAL);
        formularioCrear.add(txtNombreClasificacion,gbc);
        JButton btnCrearClasi=new JButton();
        btnCrearClasi.setText("Crear");
        btnCrearClasi.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                crearClasificacion(txtNombreClasificacion.getText()); //creacion de clasificacion
                txtNombreClasificacion.setText("");
            }
        });
        cambiarValoresGBC(gbc,0,2,1,1,1,1,GridBagConstraints.NONE);
        formularioCrear.add(btnCrearClasi,gbc);


        //LISTADO DE CLASIFICACIONES//////////////////
        JPanel izquierda=new JPanel();
        izquierda.setLayout(new GridBagLayout());
        cambiarValoresGBC(gbc,1,0,0.6,1,1,1,GridBagConstraints.BOTH);
        panelContido.add(izquierda,gbc);

        JPanel panelTextoCantidadClasificacions=new JPanel();
        panelTextoCantidadClasificacions.setLayout(new GridBagLayout());
        cambiarValoresGBC(gbc,0,0,1,0.1,1,1,GridBagConstraints.BOTH);
        panelTextoCantidadClasificacions.add(crearTexto(clasificacions.size()+" clasificaciones",15,Color.BLACK));
        izquierda.add(panelTextoCantidadClasificacions,gbc);

        JPanel listaClasificacions=new JPanel();
        listaClasificacions.setLayout(new GridBagLayout());
        //engadese mais abaixo na izquierda en forma de Scroll

        //engado as clasificacions ao subpanel
        int i=0;
        for (Clasificacion clasificacion:clasificacions){
            JPanel itemPanel = new JPanel();
            cambiarValoresGBC(gbc,0,i++,1,1,1,1,GridBagConstraints.BOTH);
            itemPanel.setLayout(new GridBagLayout());
            if (i%2==0) itemPanel.setBackground(COLOR_PARTIDOS);
            itemPanel.setPreferredSize(new Dimension(200, 50)); // Tamaño de cada subpanel
            itemPanel.add(new JLabel(clasificacion.toString()));
            listaClasificacions.add(itemPanel,gbc);
        }
        JScrollPane scrollPane=new JScrollPane(listaClasificacions);
        scrollPane.setBackground(Color.ORANGE);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        cambiarValoresGBC(gbc,0,1,1,0.9,1,1,GridBagConstraints.BOTH);
        izquierda.add(scrollPane,gbc);

        cambiarPanelPrincipal(panelBase);
    }

    public void verPanelEquipos(){
        JPanel panelBase=getPanelBaseConHeader("Equipos",COLOR_EQUIPOS);
        JPanel panelContido=getPanelParaEngadirContidoAoPanelBase(panelBase);

        cambiarPanelPrincipal(panelBase);
    }

    public void verPanelPartidos(){
        JPanel panelBase=getPanelBaseConHeader("Clasificacions",COLOR_PARTIDOS);
        JPanel panelContido=getPanelParaEngadirContidoAoPanelBase(panelBase);
        cambiarPanelPrincipal(panelBase);
    }


    public void cambiarPanelPrincipal(JPanel panel){
        limpiarVentana();
        cambiarValoresGBC(gbc,0,0,1,1,1,1,GridBagConstraints.BOTH);
        ventana.add(panel,gbc);
        ventana.revalidate();
        ventana.repaint();
    }

    public JPanel getPanelBaseConHeader(String tituloHeader,Color colorHeader){
        JPanel panel=new JPanel();
        panel.setLayout(new GridBagLayout());

        JPanel header=new JPanel();
        header.setLayout(new GridBagLayout());
        header.setBorder(new EmptyBorder(10,10,10,10));
        header.setBackground(colorHeader);
        cambiarValoresGBC(gbc,0,0,1,0.1,1,1,GridBagConstraints.BOTH);
        panel.add(header,gbc);

        JPanel botonHome=new JPanel();
        botonHome.setLayout(new GridBagLayout());
        botonHome.setBackground(Color.decode("#e76e1d"));
        botonHome.setBorder(new EmptyBorder(10,10,10,10));
        botonHome.add(crearTexto("Home"));
        cambiarValoresGBC(gbc,0,0,0.1,1,1,1,GridBagConstraints.BOTH);
        botonHome.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                verPanelInicio();
            }
            @Override
            public void mouseEntered(MouseEvent e){
                botonHome.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e){
                botonHome.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        header.add(botonHome,gbc);

        JPanel panelTituloHeader=new JPanel();
        panelTituloHeader.setLayout(new GridBagLayout());
        panelTituloHeader.setBackground(colorHeader);
        panelTituloHeader.add(crearTexto(tituloHeader,25));
        cambiarValoresGBC(gbc,1,0,0.9,1,1,1,GridBagConstraints.BOTH);
        header.add(panelTituloHeader,gbc);

        return panel;
    }

    public JPanel getPanelParaEngadirContidoAoPanelBase(JPanel panelBase){
        JPanel panel=new JPanel();
        panel.setLayout(new GridBagLayout());
        cambiarValoresGBC(gbc,0,1,1,0.9,1,1,GridBagConstraints.BOTH);
        panelBase.add(panel,gbc);
        return panel;
    }

    public void limpiarVentana(){
        ventana.getContentPane().removeAll();
        ventana.revalidate();
        ventana.repaint();
    }

    public JScrollPane getScrollListaClasificacions(){
        LinkedHashSet<Clasificacion> clasificacions=null;
        try{
            ImpDaoClasificacion daoClasi=new ImpDaoClasificacion();
            clasificacions=(LinkedHashSet<Clasificacion>) daoClasi.getAll();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

        JPanel listaClasificacions=new JPanel();
        listaClasificacions.setLayout(new GridBagLayout());
        //engadese mais abaixo na izquierda en forma de Scroll

        //engado as clasificacions ao subpanel
        int i=0;
        for (Clasificacion clasificacion:clasificacions){
            JPanel itemPanel = new JPanel();
            cambiarValoresGBC(gbc,0,i++,1,1,1,1,GridBagConstraints.BOTH);
            itemPanel.setLayout(new GridBagLayout());
            if (i%2==0) itemPanel.setBackground(COLOR_PARTIDOS);
            itemPanel.setPreferredSize(new Dimension(200, 50)); // Tamaño de cada subpanel
            itemPanel.add(new JLabel(clasificacion.toString()));
            listaClasificacions.add(itemPanel,gbc);
        }
        JScrollPane scrollPane=new JScrollPane(listaClasificacions);
        scrollPane.setBackground(Color.ORANGE);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        return scrollPane;

    }

    public void crearClasificacion(String nombreClasificacion){
        if (nombreClasificacion.isBlank()) return;
        try{
            ImpDaoClasificacion daoClasificacion=new ImpDaoClasificacion();
            if(daoClasificacion.save(new Clasificacion(nombreClasificacion))){
                verPanelClasificaciones();
                mostrarMensajeInformativo("Clasificacion creada correctamente",false);
            }
        }catch (Exception e){
            return;
        }
    }

    public void borrarClasificacion(String nombreClasificacion){
        if (nombreClasificacion.isBlank()) return;
        try{
            ImpDaoClasificacion daoClasificacion=new ImpDaoClasificacion();
            if(daoClasificacion.delete(new Clasificacion(nombreClasificacion))){
                verPanelClasificaciones();
            }
        }catch (Exception e){
            return;
        }
    }

    public void mostrarMensajeInformativo(String mensajeTxt,boolean error){
        JLabel mensaje = new JLabel(mensajeTxt, SwingConstants.CENTER);
        mensaje.setOpaque(true);
        mensaje.setBackground(new Color(0, 128, 0, 200)); // Verde semitransparente
        mensaje.setForeground(Color.WHITE);
        mensaje.setFont(new Font("Arial", Font.BOLD, 18));
        System.out.println(ventana.getWidth());
        System.out.println(ventana.getHeight());
        System.out.println(ventana.getX());
        System.out.println(ventana.getY());

        /// todo arreglar esto

        int x = (ventana.getWidth() - 600) / 2; // Centrar horizontalmente

        mensaje.setBounds(x,0, 600, 50); // Posición y tamaño del mensaje
        panelMensajes.add(mensaje, JLayeredPane.POPUP_LAYER);

        panelMensajes.revalidate();
        panelMensajes.repaint();
    }
}
