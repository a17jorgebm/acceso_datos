package org.example.boletin.gestionBaloncesto;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Timer;
import java.util.function.Consumer;
import java.util.function.Function;

import com.sun.source.tree.Tree;
import org.example.boletin.gestionBaloncesto.Funcions.*;
import org.example.boletin.gestionBaloncesto.dao_implementations.ImpDaoClasificacion;
import org.example.boletin.gestionBaloncesto.dao_implementations.ImpDaoEquipo;
import org.example.boletin.gestionBaloncesto.dao_implementations.ImpDaoEquipoClasificacion;
import org.example.boletin.gestionBaloncesto.dao_implementations.ImpDaoPartido;

import static org.example.boletin.gestionBaloncesto.Funcions.cambiarValoresGBC;
import static org.example.boletin.gestionBaloncesto.Funcions.crearTexto;

public class InterfazGrafica {
    private static final Color COLOR_CLASIFICACIONS=Color.decode("#e97d34");
    private static final Color COLOR_EQUIPOS=Color.decode("#ec8b4a");
    private static final Color COLOR_PARTIDOS=Color.decode("#ee9a61");


    private JFrame ventana;
    private JLayeredPane layeredPaneVentana;
    private GridBagConstraints gbc;
    private Insets insets;

    public InterfazGrafica(){
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = env.getDefaultScreenDevice();

        // Configuración de pantalla completa
        //configurar ventana
        this.ventana=new JFrame();
        this.ventana.setMinimumSize(new Dimension(1000,800));
        this.ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.ventana.setTitle("Gestion de equipos de baloncesto");
        this.ventana.setLayout(new GridBagLayout());
        ventana.setLocationRelativeTo(null); // Centrar la ventana
        ventana.setVisible(true);

        ventana.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                recolocarMensajeInformativo();
            }
        });

        this.layeredPaneVentana=ventana.getLayeredPane();

        //crear gridBagLayoutConstraints
        this.gbc=new GridBagConstraints();
        cambiarValoresGBC(gbc,0,0,1,1,1,1,GridBagConstraints.BOTH);

        //inicializar insets
        this.insets=new Insets(0,0,0,0);
    }

    public static void main(String[] args) {
        // Crear los equipos
        Equipo equipo1 = new Equipo("Equipo A");
        Equipo equipo2 = new Equipo("Equipo B");
        Equipo equipo3 = new Equipo("Equipo C");
        Equipo equipo4 = new Equipo("Equipo D");
        Equipo equipo5 = new Equipo("Equipo E");

        ImpDaoEquipo daoE = new ImpDaoEquipo();
        try {
            daoE.save(equipo1);
            daoE.save(equipo2);
            daoE.save(equipo3);
            daoE.save(equipo4);
            daoE.save(equipo5);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

// Crear una clasificación
        Clasificacion clasificacion = new Clasificacion("Clasificación 1");
        ImpDaoClasificacion daoC = new ImpDaoClasificacion();
        try {
            daoC.save(clasificacion);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

// Asociar los equipos a la clasificación
        Equipo_clasificacion equipoClasificacion1 = new Equipo_clasificacion(equipo1.getNombre(), clasificacion.getCompeticion());
        Equipo_clasificacion equipoClasificacion2 = new Equipo_clasificacion(equipo2.getNombre(), clasificacion.getCompeticion());
        Equipo_clasificacion equipoClasificacion3 = new Equipo_clasificacion(equipo3.getNombre(), clasificacion.getCompeticion());
        Equipo_clasificacion equipoClasificacion4 = new Equipo_clasificacion(equipo4.getNombre(), clasificacion.getCompeticion());
        Equipo_clasificacion equipoClasificacion5 = new Equipo_clasificacion(equipo5.getNombre(), clasificacion.getCompeticion());

        ImpDaoEquipoClasificacion daoEC = new ImpDaoEquipoClasificacion();
        try {
            daoEC.save(equipoClasificacion1);
            daoEC.save(equipoClasificacion2);
            daoEC.save(equipoClasificacion3);
            daoEC.save(equipoClasificacion4);
            daoEC.save(equipoClasificacion5);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

// Crear varios partidos entre los equipos

// Partido 1: Equipo A vs Equipo B
        HashMap<String, Integer> marcador1 = new HashMap<>();
        marcador1.put(equipo1.getNombre(), 90); // Puntuación del equipo local
        marcador1.put(equipo2.getNombre(), 85); // Puntuación del equipo visitante

        Partido partido1 = new Partido(new Date(), equipo1.getNombre(), equipo2.getNombre(), clasificacion.getCompeticion(), marcador1);

// Partido 2: Equipo C vs Equipo D
        HashMap<String, Integer> marcador2 = new HashMap<>();
        marcador2.put(equipo3.getNombre(), 78); // Puntuación del equipo local
        marcador2.put(equipo4.getNombre(), 80); // Puntuación del equipo visitante

        Partido partido2 = new Partido(new Date(), equipo3.getNombre(), equipo4.getNombre(), clasificacion.getCompeticion(), marcador2);

// Partido 3: Equipo B vs Equipo E
        HashMap<String, Integer> marcador3 = new HashMap<>();
        marcador3.put(equipo2.getNombre(), 65); // Puntuación del equipo local
        marcador3.put(equipo5.getNombre(), 70); // Puntuación del equipo visitante

        Partido partido3 = new Partido(new Date(), equipo2.getNombre(), equipo5.getNombre(), clasificacion.getCompeticion(), marcador3);

// Partido 4: Equipo A vs Equipo D
        HashMap<String, Integer> marcador4 = new HashMap<>();
        marcador4.put(equipo1.getNombre(), 88); // Puntuación del equipo local
        marcador4.put(equipo4.getNombre(), 76); // Puntuación del equipo visitante

        Partido partido4 = new Partido(new Date(), equipo1.getNombre(), equipo4.getNombre(), clasificacion.getCompeticion(), marcador4);

// Guardar los partidos
        ImpDaoPartido daoP = new ImpDaoPartido();
        try {
            daoP.save(partido1);
            daoP.save(partido2);
            daoP.save(partido3);
            daoP.save(partido4);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
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
            clasificacions=new LinkedHashSet<>(daoClasi.getAll());
        }catch (Exception e){
            System.out.println(e.getMessage());
            return;
        }

        JPanel panelBase=getPanelBaseConHeader("Clasificacions",COLOR_CLASIFICACIONS);
        JPanel panelContido=getPanelParaEngadirContidoAoPanelBase(panelBase);
        panelContido.setBorder(new EmptyBorder(10,10,10,10));

        //FORMULARIO DE CREACIÓN/////////////////////
        JPanel esquerda=new JPanel();
        esquerda.setLayout(new GridBagLayout());
        cambiarValoresGBC(gbc,0,0,0.4,1,1,1,GridBagConstraints.BOTH);
        panelContido.add(esquerda,gbc);

        JPanel formularioCrear=new JPanel();
        formularioCrear.setLayout(new GridBagLayout());
        formularioCrear.setBorder(new EmptyBorder(20,20,20,20));
        cambiarValoresGBC(gbc,0,0,1,0.7,1,1,GridBagConstraints.BOTH);
        esquerda.add(formularioCrear,gbc);

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
            }
        });
        cambiarValoresGBC(gbc,0,2,1,1,1,1,GridBagConstraints.NONE);
        formularioCrear.add(btnCrearClasi,gbc);

        JPanel panelBotonBorrarTodo=new JPanel();
        panelBotonBorrarTodo.setLayout(new GridBagLayout());
        panelBotonBorrarTodo.setBorder(new EmptyBorder(20,20,20,20));
        cambiarValoresGBC(gbc,0,1,1,0.3,1,1,GridBagConstraints.BOTH);
        esquerda.add(panelBotonBorrarTodo,gbc);

        JButton botonBorrarTodo=new JButton();
        botonBorrarTodo.setText("Borrar todas las clasificaciones");
        botonBorrarTodo.setBackground(new Color(178, 37, 37));
        botonBorrarTodo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                borrarTodasClasificaciones();
            }
        });
        cambiarValoresGBC(gbc,0,0,1,1,1,1,GridBagConstraints.BOTH);
        panelBotonBorrarTodo.add(botonBorrarTodo,gbc);

        //LISTADO DE CLASIFICACIONES//////////////////
        JPanel dereita=new JPanel();
        dereita.setLayout(new GridBagLayout());
        cambiarValoresGBC(gbc,1,0,0.6,1,1,1,GridBagConstraints.BOTH);
        panelContido.add(dereita,gbc);

        JPanel panelTextoCantidadClasificacions=new JPanel();
        panelTextoCantidadClasificacions.setLayout(new GridBagLayout());
        cambiarValoresGBC(gbc,0,0,1,0.1,1,1,GridBagConstraints.BOTH);
        panelTextoCantidadClasificacions.add(crearTexto(clasificacions.size()+" clasificaciones",15,Color.BLACK));
        dereita.add(panelTextoCantidadClasificacions,gbc);

        JPanel listaClasificacions=new JPanel();
        listaClasificacions.setLayout(new GridBagLayout());
        //engadese mais abaixo na dereita en forma de Scroll

        //engado as clasificacions ao subpanel
        int i=0;
        for (Clasificacion clasificacion:clasificacions){
            boolean colorear=i%2==0;
            //item
            JPanel itemPanel = new JPanel();
            cambiarValoresGBC(gbc,0,i++,1,1,1,1,GridBagConstraints.BOTH);
            itemPanel.setLayout(new GridBagLayout());
            itemPanel.setPreferredSize(new Dimension(200, 50)); // Tamaño de cada subpanel
            itemPanel.setMinimumSize(new Dimension(200,50));
            listaClasificacions.add(itemPanel,gbc);

            JPanel esquerdaClasi=new JPanel();
            esquerdaClasi.setLayout(new GridBagLayout());
            if (colorear) esquerdaClasi.setBackground(COLOR_PARTIDOS);
            cambiarValoresGBC(gbc,0,0,1,1,1,1,GridBagConstraints.BOTH);
            esquerdaClasi.add(new JLabel(clasificacion.getCompeticion()));
            itemPanel.add(esquerdaClasi,gbc);

            JPanel dereitaClasi=new JPanel();
            dereitaClasi.setLayout(new GridBagLayout());
            dereitaClasi.setBorder(new EmptyBorder(10,20,10,20));
            if (colorear) dereitaClasi.setBackground(COLOR_PARTIDOS);
            cambiarValoresGBC(gbc,1,0,1,1,1,1,GridBagConstraints.BOTH);
            itemPanel.add(dereitaClasi,gbc);

            JButton botonVer=new JButton();
            botonVer.setText("Ver");
            botonVer.setBackground(new Color(115, 171, 115, 210));
            botonVer.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    verPanelClasificacionConcreta(clasificacion);
                }
            });
            insets.set(0,0,0,10);
            cambiarValoresGBC(gbc,0,0,1,1,1,1,GridBagConstraints.HORIZONTAL,insets);
            dereitaClasi.add(botonVer,gbc);

            JButton botonBorrar=new JButton();
            botonBorrar.setText("Borrar");
            botonBorrar.setBackground(new Color(178, 37, 37));
            botonBorrar.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    borrarClasificacion(clasificacion);
                }
            });
            cambiarValoresGBC(gbc,1,0,1,1,1,1,GridBagConstraints.HORIZONTAL);
            dereitaClasi.add(botonBorrar,gbc);
        }
        JScrollPane scrollPane=new JScrollPane(listaClasificacions);
        scrollPane.setBackground(Color.ORANGE);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        cambiarValoresGBC(gbc,0,1,1,0.9,1,1,GridBagConstraints.BOTH);
        dereita.add(scrollPane,gbc);

        cambiarPanelPrincipal(panelBase);
    }

    public void verPanelClasificacionConcreta(Clasificacion clasificacionSeleccionada){
        TreeSet<Equipo> equiposClasificacion=null;
        TreeSet<Equipo> todosEquipos=null;
        HashSet<Equipo> equiposQueNonEstanNaClasificacion=null;
        HashSet<Partido> partidosClasificacion=null;
        try{
            ImpDaoEquipoClasificacion daoEquipoClasificacion=new ImpDaoEquipoClasificacion();
            ImpDaoEquipo daoEquipo=new ImpDaoEquipo();
            ImpDaoPartido daoPartido=new ImpDaoPartido();
            equiposClasificacion=new TreeSet<>(daoEquipoClasificacion.getAllEquiposFromClasificacion(clasificacionSeleccionada));
            todosEquipos=new TreeSet<>(daoEquipo.getAll());
            equiposQueNonEstanNaClasificacion=new HashSet<>(todosEquipos);
            equiposQueNonEstanNaClasificacion.removeAll(equiposClasificacion);
            partidosClasificacion=daoPartido.getAllPartidosFromClasificacion(clasificacionSeleccionada);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return;
        }

        JPanel panelBase=getPanelBaseConHeader(clasificacionSeleccionada.getCompeticion(),COLOR_CLASIFICACIONS, this::verPanelClasificaciones);
        JPanel panelContido=getPanelParaEngadirContidoAoPanelBase(panelBase);
        panelContido.setBorder(new EmptyBorder(10,10,10,10));

        //LISTA DE EQUIPOS DA CLASIFICACION/////////////////////
        JPanel esquerda=new JPanel();
        esquerda.setLayout(new GridBagLayout());
        cambiarValoresGBC(gbc,0,0,0.4,1,1,1,GridBagConstraints.BOTH);
        panelContido.add(esquerda,gbc);

        JPanel panelTextoCantidadEquipos=new JPanel();
        panelTextoCantidadEquipos.setLayout(new GridBagLayout());
        cambiarValoresGBC(gbc,0,0,1,0.1,1,1,GridBagConstraints.BOTH);
        panelTextoCantidadEquipos.add(crearTexto(equiposClasificacion.size()+" equipos",15,Color.BLACK));
        esquerda.add(panelTextoCantidadEquipos,gbc);

        JPanel listaClasificacions=new JPanel();
        listaClasificacions.setLayout(new GridBagLayout());
        //engadese mais abaixo na dereita en forma de Scroll

        //engado as clasificacions ao subpanel
        int i=0;
        for (Equipo equipo:equiposClasificacion){
            boolean colorear=i%2==0;
            //item
            JPanel itemPanel = new JPanel();
            cambiarValoresGBC(gbc,0,i++,1,1,1,1,GridBagConstraints.BOTH);
            itemPanel.setLayout(new GridBagLayout());
            itemPanel.setPreferredSize(new Dimension(200, 50)); // Tamaño de cada subpanel
            itemPanel.setMinimumSize(new Dimension(200,50));
            listaClasificacions.add(itemPanel,gbc);

            JPanel esquerdaClasi=new JPanel();
            esquerdaClasi.setLayout(new GridBagLayout());
            if (colorear) esquerdaClasi.setBackground(COLOR_PARTIDOS);
            cambiarValoresGBC(gbc,0,0,1,1,1,1,GridBagConstraints.BOTH);
            esquerdaClasi.add(new JLabel(equipo.toString()));
            itemPanel.add(esquerdaClasi,gbc);

            JPanel dereitaClasi=new JPanel();
            dereitaClasi.setLayout(new GridBagLayout());
            dereitaClasi.setBorder(new EmptyBorder(10,20,10,20));
            if (colorear) dereitaClasi.setBackground(COLOR_PARTIDOS);
            cambiarValoresGBC(gbc,1,0,1,1,1,1,GridBagConstraints.BOTH);
            itemPanel.add(dereitaClasi,gbc);


            JButton botonBorrar=new JButton();
            botonBorrar.setText("Borrar");
            botonBorrar.setBackground(new Color(178, 37, 37));
            botonBorrar.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    borrarEquipoDeClasificacion(new Equipo_clasificacion(equipo.getNombre(),clasificacionSeleccionada.getCompeticion()));
                }
            });
            cambiarValoresGBC(gbc,0,0,1,1,1,1,GridBagConstraints.HORIZONTAL);
            dereitaClasi.add(botonBorrar,gbc);
        }
        JScrollPane scrollPane=new JScrollPane(listaClasificacions);
        scrollPane.setBackground(Color.ORANGE);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        cambiarValoresGBC(gbc,0,1,1,0.9,1,1,GridBagConstraints.BOTH);
        esquerda.add(scrollPane,gbc);

        //LISTADO DE PARTIDOS//////////////////
        JPanel dereita=new JPanel();
        dereita.setLayout(new GridBagLayout());
        cambiarValoresGBC(gbc,1,0,0.6,1,1,1,GridBagConstraints.BOTH);
        panelContido.add(dereita,gbc);

        JPanel panelTextoCantidadPartidos=new JPanel();
        panelTextoCantidadPartidos.setLayout(new GridBagLayout());
        cambiarValoresGBC(gbc,0,0,1,0.1,1,1,GridBagConstraints.BOTH);
        panelTextoCantidadPartidos.add(crearTexto(partidosClasificacion.size()+" partidos",15,Color.BLACK));
        dereita.add(panelTextoCantidadPartidos,gbc);

        JPanel listaPartidos=new JPanel();
        listaPartidos.setLayout(new GridBagLayout());
        //engadese mais abaixo na dereita en forma de Scroll

        //engado as clasificacions ao subpanel
        int z=0;
        for (Partido partido:partidosClasificacion){
            boolean colorear=z%2==0;
            //item
            JPanel itemPanel = new JPanel();
            cambiarValoresGBC(gbc,0,z++,1,1,1,1,GridBagConstraints.BOTH);
            itemPanel.setLayout(new GridBagLayout());
            itemPanel.setPreferredSize(new Dimension(200, 50)); // Tamaño de cada subpanel
            itemPanel.setMinimumSize(new Dimension(200,50));
            listaPartidos.add(itemPanel,gbc);

            JPanel esquerdaClasi=new JPanel();
            esquerdaClasi.setLayout(new GridBagLayout());
            if (colorear) esquerdaClasi.setBackground(COLOR_PARTIDOS);
            cambiarValoresGBC(gbc,0,0,1,1,1,1,GridBagConstraints.BOTH);
            esquerdaClasi.add(new JLabel(partido.getEquipoLocal() + " - "+partido.getEquipoVisitante()));
            itemPanel.add(esquerdaClasi,gbc);

            JPanel dereitaClasi=new JPanel();
            dereitaClasi.setLayout(new GridBagLayout());
            dereitaClasi.setBorder(new EmptyBorder(10,20,10,20));
            if (colorear) dereitaClasi.setBackground(COLOR_PARTIDOS);
            cambiarValoresGBC(gbc,1,0,1,1,1,1,GridBagConstraints.BOTH);
            itemPanel.add(dereitaClasi,gbc);

            JButton botonVer=new JButton();
            botonVer.setText("Ver");
            botonVer.setBackground(new Color(115, 171, 115, 210));
            botonVer.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    //borrarEquipo(equipo);
                }
            });
            insets.set(0,0,0,10);
            cambiarValoresGBC(gbc,0,0,1,1,1,1,GridBagConstraints.HORIZONTAL,insets);
            dereitaClasi.add(botonVer,gbc);

            JButton botonBorrar=new JButton();
            botonBorrar.setText("Borrar");
            botonBorrar.setBackground(new Color(178, 37, 37));
            botonBorrar.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    //borrarClasificacion(clasificacion);
                }
            });
            cambiarValoresGBC(gbc,1,0,1,1,1,1,GridBagConstraints.HORIZONTAL);
            dereitaClasi.add(botonBorrar,gbc);
        }
        JScrollPane scrollPanePartidos=new JScrollPane(listaPartidos);
        scrollPanePartidos.setBackground(Color.ORANGE);
        scrollPanePartidos.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        cambiarValoresGBC(gbc,0,1,1,0.9,1,1,GridBagConstraints.BOTH);
        dereita.add(scrollPanePartidos,gbc);

        cambiarPanelPrincipal(panelBase);
    }

    public void verPanelEquipos(){
        /*
        LinkedHashSet<Clasificacion> clasificacions=null;
        try{
            ImpDaoClasificacion daoClasi=new ImpDaoClasificacion();
            clasificacions=(LinkedHashSet<Clasificacion>) daoClasi.getAll();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return;
        }*/
        TreeSet<Equipo> equipos=null;
        try{
            ImpDaoEquipo daoEquipos=new ImpDaoEquipo();
            equipos=new TreeSet<> (daoEquipos.getAll()) ;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return;
        }

        JPanel panelBase=getPanelBaseConHeader("Equipos",COLOR_EQUIPOS);
        JPanel panelContido=getPanelParaEngadirContidoAoPanelBase(panelBase);
        panelContido.setBorder(new EmptyBorder(10,10,10,10));

        //FORMULARIO DE CREACIÓN/////////////////////
        JPanel esquerda=new JPanel();
        esquerda.setLayout(new GridBagLayout());
        cambiarValoresGBC(gbc,0,0,0.4,1,1,1,GridBagConstraints.BOTH);
        panelContido.add(esquerda,gbc);

        JPanel formularioCrear=new JPanel();
        formularioCrear.setLayout(new GridBagLayout());
        formularioCrear.setBorder(new EmptyBorder(20,20,20,20));
        cambiarValoresGBC(gbc,0,0,1,0.7,1,1,GridBagConstraints.BOTH);
        esquerda.add(formularioCrear,gbc);

        cambiarValoresGBC(gbc,0,0,1,1,1,1,GridBagConstraints.NONE);
        formularioCrear.add(crearTexto("Nombre nuevo equipo:",15,Color.BLACK),gbc);
        JTextField txtNombreClasificacion=new JTextField();
        cambiarValoresGBC(gbc,0,1,1,1,1,1,GridBagConstraints.HORIZONTAL);
        formularioCrear.add(txtNombreClasificacion,gbc);
        JButton btnCrearClasi=new JButton();
        btnCrearClasi.setText("Crear");
        btnCrearClasi.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                crearEquipo(txtNombreClasificacion.getText()); //creacion de clasificacion
            }
        });
        cambiarValoresGBC(gbc,0,2,1,1,1,1,GridBagConstraints.NONE);
        formularioCrear.add(btnCrearClasi,gbc);

        JPanel panelBotonBorrarTodo=new JPanel();
        panelBotonBorrarTodo.setLayout(new GridBagLayout());
        panelBotonBorrarTodo.setBorder(new EmptyBorder(20,20,20,20));
        cambiarValoresGBC(gbc,0,1,1,0.3,1,1,GridBagConstraints.BOTH);
        esquerda.add(panelBotonBorrarTodo,gbc);

        JButton botonBorrarTodo=new JButton();
        botonBorrarTodo.setText("Borrar todos los equipos");
        botonBorrarTodo.setBackground(new Color(178, 37, 37));
        botonBorrarTodo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                borrarTodosEquipos();
            }
        });
        cambiarValoresGBC(gbc,0,0,1,1,1,1,GridBagConstraints.BOTH);
        panelBotonBorrarTodo.add(botonBorrarTodo,gbc);

        //LISTADO DE CLASIFICACIONES//////////////////
        JPanel dereita=new JPanel();
        dereita.setLayout(new GridBagLayout());
        cambiarValoresGBC(gbc,1,0,0.6,1,1,1,GridBagConstraints.BOTH);
        panelContido.add(dereita,gbc);

        JPanel panelTextoCantidadClasificacions=new JPanel();
        panelTextoCantidadClasificacions.setLayout(new GridBagLayout());
        cambiarValoresGBC(gbc,0,0,1,0.1,1,1,GridBagConstraints.BOTH);
        panelTextoCantidadClasificacions.add(crearTexto(equipos.size()+" equipos",15,Color.BLACK));
        dereita.add(panelTextoCantidadClasificacions,gbc);

        JPanel listaClasificacions=new JPanel();
        listaClasificacions.setLayout(new GridBagLayout());
        //engadese mais abaixo na dereita en forma de Scroll

        //engado as clasificacions ao subpanel
        int i=0;
        for (Equipo equipo:equipos){
            boolean colorear=i%2==0;
            //item
            JPanel itemPanel = new JPanel();
            cambiarValoresGBC(gbc,0,i++,1,1,1,1,GridBagConstraints.BOTH);
            itemPanel.setLayout(new GridBagLayout());
            itemPanel.setPreferredSize(new Dimension(200, 50)); // Tamaño de cada subpanel
            itemPanel.setMinimumSize(new Dimension(200,50));
            listaClasificacions.add(itemPanel,gbc);

            JPanel esquerdaClasi=new JPanel();
            esquerdaClasi.setLayout(new GridBagLayout());
            if (colorear) esquerdaClasi.setBackground(COLOR_PARTIDOS);
            cambiarValoresGBC(gbc,0,0,1,1,1,1,GridBagConstraints.BOTH);
            esquerdaClasi.add(new JLabel(equipo.getNombre()));
            itemPanel.add(esquerdaClasi,gbc);

            JPanel dereitaClasi=new JPanel();
            dereitaClasi.setLayout(new GridBagLayout());
            dereitaClasi.setBorder(new EmptyBorder(10,20,10,20));
            if (colorear) dereitaClasi.setBackground(COLOR_PARTIDOS);
            cambiarValoresGBC(gbc,1,0,1,1,1,1,GridBagConstraints.BOTH);
            itemPanel.add(dereitaClasi,gbc);

            JButton botonVer=new JButton();
            botonVer.setText("Ver");
            botonVer.setBackground(new Color(115, 171, 115, 210));
            botonVer.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    //borrarEquipo(equipo);
                }
            });
            insets.set(0,0,0,10);
            cambiarValoresGBC(gbc,0,0,1,1,1,1,GridBagConstraints.HORIZONTAL,insets);
            dereitaClasi.add(botonVer,gbc);

            JButton botonBorrar=new JButton();
            botonBorrar.setText("Borrar");
            botonBorrar.setBackground(new Color(178, 37, 37));
            botonBorrar.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    borrarEquipo(equipo);
                }
            });
            cambiarValoresGBC(gbc,1,0,1,1,1,1,GridBagConstraints.HORIZONTAL);
            dereitaClasi.add(botonBorrar,gbc);
        }
        JScrollPane scrollPane=new JScrollPane(listaClasificacions);
        scrollPane.setBackground(Color.ORANGE);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        cambiarValoresGBC(gbc,0,1,1,0.9,1,1,GridBagConstraints.BOTH);
        dereita.add(scrollPane,gbc);

        cambiarPanelPrincipal(panelBase);
    }

    public void verPanelPartidos(){
        JPanel panelBase=getPanelBaseConHeader("Clasificacions",COLOR_PARTIDOS);
        JPanel panelContido=getPanelParaEngadirContidoAoPanelBase(panelBase);
        cambiarPanelPrincipal(panelBase);
    }

    public void crearClasificacion(String nombreClasificacion){
        if (nombreClasificacion.isBlank()) return;
        try{
            ImpDaoClasificacion daoClasificacion=new ImpDaoClasificacion();
            if(daoClasificacion.save(new Clasificacion(nombreClasificacion))){
                verPanelClasificaciones();
                mostrarMensajeInformativo("Clasificacion creada correctamente",false);
            }else {
                mostrarMensajeInformativo("A clasificación xa existe",true);
            }
        }catch (Exception e){
            mostrarMensajeInformativo("Error ao crear a clasificacion",true);
        }
    }

    public void borrarClasificacion(Clasificacion clasificacion){
        try{
            ImpDaoClasificacion daoClasificacion=new ImpDaoClasificacion();
            daoClasificacion.delete(clasificacion);
            mostrarMensajeInformativo("Clasificacion borrada",false);
            verPanelClasificaciones();
        }catch (Exception e){
            mostrarMensajeInformativo("Error ao borrar a clasificacion",true);
        }
    }

    public void borrarTodasClasificaciones(){
        if ((JOptionPane.showConfirmDialog(ventana,"Se borrarán todas las clasificaciones, seguro?"))!=JOptionPane.OK_OPTION){
            return;
        }
        try{
            ImpDaoClasificacion daoClasificacion=new ImpDaoClasificacion();
            daoClasificacion.deleteAll();
            mostrarMensajeInformativo("Clasificaciones borradas",false);
            verPanelClasificaciones();
        }catch (Exception e){
            mostrarMensajeInformativo("Error ao borrar as clasificacions",true);
        }
    }

    public void crearEquipo(String nombreEquipo){
        try{
            ImpDaoEquipo daoEquipo=new ImpDaoEquipo();
            if(daoEquipo.save(new Equipo(nombreEquipo))){
                verPanelEquipos();
                mostrarMensajeInformativo("Equipo creado correctamente",false);
            }else {
                mostrarMensajeInformativo("O equipo xa existe",true);
            }
        }catch (Exception e){
            mostrarMensajeInformativo("Error ao borrar o equipo",true);
        }
    }

    public void borrarEquipo(Equipo equipo){
        try{
            ImpDaoEquipo daoEquipo=new ImpDaoEquipo();
            daoEquipo.delete(equipo);
            mostrarMensajeInformativo("Equipo borrado",false);
            verPanelEquipos();
        }catch (Exception e){
            mostrarMensajeInformativo("Error ao borrar o equipo",true);
        }
    }

    public void borrarTodosEquipos(){
        if ((JOptionPane.showConfirmDialog(ventana,"Se borrarán todos los equipos, seguro?"))!=JOptionPane.OK_OPTION){
            return;
        }
        try{
            ImpDaoEquipo daoEquipo=new ImpDaoEquipo();
            daoEquipo.deleteAll();
            mostrarMensajeInformativo("Equipos borrados",false);
            verPanelEquipos();
        }catch (Exception e){
            mostrarMensajeInformativo("Error ao borrar os equipos",true);
        }
    }

    public void borrarEquipoDeClasificacion(Equipo_clasificacion ec){
        try{
            ImpDaoEquipoClasificacion daoEC=new ImpDaoEquipoClasificacion();
            daoEC.delete(ec);
            mostrarMensajeInformativo("Equipo borrado da clasificación",false);
            verPanelClasificacionConcreta(new Clasificacion(ec.getIdClasificacion()));
        }catch (Exception e){
            mostrarMensajeInformativo("Error ao borrar o equipo da clasificación",true);
        }
    }


    ////FUNCIONS DE INTERFAZ
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

    public JPanel getPanelBaseConHeader(String tituloHeader,Color colorHeader, Runnable funcionVentanaAtras){
        JPanel panel=new JPanel();
        panel.setLayout(new GridBagLayout());

        JPanel header=new JPanel();
        header.setLayout(new GridBagLayout());
        header.setBorder(new EmptyBorder(10,10,10,10));
        header.setBackground(colorHeader);
        cambiarValoresGBC(gbc,0,0,1,0.1,1,1,GridBagConstraints.BOTH);
        panel.add(header,gbc);

        JPanel botonAtras=new JPanel();
        botonAtras.setLayout(new GridBagLayout());
        botonAtras.setBackground(Color.decode("#e76e1d"));
        botonAtras.setBorder(new EmptyBorder(10,10,10,10));
        botonAtras.add(crearTexto("<-"));
        insets.set(0,0,0,10);
        cambiarValoresGBC(gbc,0,0,0.1,1,1,1,GridBagConstraints.BOTH,insets);
        botonAtras.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                funcionVentanaAtras.run();
            }
            @Override
            public void mouseEntered(MouseEvent e){
                botonAtras.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e){
                botonAtras.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        header.add(botonAtras,gbc);

        JPanel botonHome=new JPanel();
        botonHome.setLayout(new GridBagLayout());
        botonHome.setBackground(Color.decode("#e76e1d"));
        botonHome.setBorder(new EmptyBorder(10,10,10,10));
        botonHome.add(crearTexto("Home"));
        cambiarValoresGBC(gbc,1,0,0.1,1,1,1,GridBagConstraints.BOTH);
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
        cambiarValoresGBC(gbc,2,0,0.9,1,1,1,GridBagConstraints.BOTH);
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

    public void mostrarMensajeInformativo(String mensajeTxt,boolean error){
        JLabel mensaje = new JLabel(mensajeTxt, SwingConstants.CENTER);
        mensaje.setOpaque(true);
        if (error){
            mensaje.setBackground(new Color(178, 37, 37, 186)); // Verde semitransparente
        }else {
            mensaje.setBackground(new Color(16, 218, 16, 210)); // Verde semitransparente
        }
        mensaje.setForeground(Color.WHITE);
        mensaje.setFont(new Font("Arial", Font.BOLD, 18));

        int x = (ventana.getWidth() - 600) / 2; // Centrar horizontalmente
        int y=ventana.getContentPane().getHeight()-50-30;
        mensaje.setBounds(x,y, 600, 50); // Posición y tamaño del mensaje

        //se xa o ten metido borroo antes de meter o novo
        if(layeredPaneVentana.getComponentsInLayer(JLayeredPane.POPUP_LAYER).length>0) layeredPaneVentana.remove(layeredPaneVentana.getComponentsInLayer(JLayeredPane.POPUP_LAYER)[0]);
        layeredPaneVentana.add(mensaje, JLayeredPane.POPUP_LAYER);
        layeredPaneVentana.revalidate();
        layeredPaneVentana.repaint();

        Timer timer=new Timer();
        timer.schedule(new TimerTask() { //borra o aviso aos 4 segundos
            @Override
            public void run() {
                SwingUtilities.invokeLater(() -> {
                    if(layeredPaneVentana.getComponentsInLayer(JLayeredPane.POPUP_LAYER).length>0){
                        layeredPaneVentana.remove(layeredPaneVentana.getComponentsInLayer(JLayeredPane.POPUP_LAYER)[0]);
                        layeredPaneVentana.revalidate();
                        layeredPaneVentana.repaint();
                    }
                });
            }
        },3000);
    }

    public void recolocarMensajeInformativo(){
        if (layeredPaneVentana.getComponentsInLayer(JLayeredPane.POPUP_LAYER).length>0){
            JLabel label=(JLabel) layeredPaneVentana.getComponentsInLayer(JLayeredPane.POPUP_LAYER)[0];
            int x = (ventana.getWidth() - 600) / 2; // Centrar horizontalmente
            int y=ventana.getContentPane().getHeight()-50-30;
            label.setBounds(x,y, 600, 50);
        }
    }
}
