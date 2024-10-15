package org.example.boletin.gestionBaloncesto;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;

import org.example.boletin.gestionBaloncesto.Funcions.*;
import org.example.boletin.gestionBaloncesto.dao_implementations.ImpDaoClasificacion;

import static org.example.boletin.gestionBaloncesto.Funcions.cambiarValoresGBC;

public class InterfazGrafica {
    public static void main(String[] args) {
        JFrame ventana=new JFrame();
        ventana.setMinimumSize(new Dimension(800,600));
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(new GridBagLayout());

        Insets insets=new Insets(0,0,0,0);

        GridBagConstraints gbc=new GridBagConstraints();

        JPanel main=new JPanel();
        main.setLayout(new GridBagLayout());

        ArrayList<Clasificacion> clasificaciones = new ArrayList<>(Arrays.asList(
                new Clasificacion("Liga ACB"),
                new Clasificacion("NBA"),
                new Clasificacion("EuroLeague"),
                new Clasificacion("Liga Endesa"),
                new Clasificacion("Copa del Rey"),
                new Clasificacion("NCAA"),
                new Clasificacion("Olympics"),
                new Clasificacion("FIBA World Cup"),
                new Clasificacion("Liga de las Américas"),
                new Clasificacion("Serie A (Italia)"),
                new Clasificacion("Basketball Bundesliga"),
                new Clasificacion("Pro A (Francia)"),
                new Clasificacion("Super Liga (Turquía)"),
                new Clasificacion("VTB United League"),
                new Clasificacion("BBL (Reino Unido)")
        ));

        ImpDaoClasificacion daoClasi=new ImpDaoClasificacion();

        // Mostrar los objetos en el ArrayList
        for (Clasificacion clasificacion : clasificaciones) {
            try{
                boolean gardou=daoClasi.save(clasificacion);
                int a=0;
            }catch (Exception e){

            }
        }
        HashSet<Clasificacion> clasisArquivo=new HashSet<>();
        try{
            clasisArquivo=(HashSet<Clasificacion>) daoClasi.getAll();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        int i=0;
        // Mostrar los objetos en el ArrayList
        for (Clasificacion clasificacion : clasisArquivo) {
            JPanel itemPanel = new JPanel();
            cambiarValoresGBC(gbc,0,i++,1,1,1,1,GridBagConstraints.BOTH);
            itemPanel.setLayout(new GridBagLayout());
            itemPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            itemPanel.setPreferredSize(new Dimension(1000, 50)); // Tamaño de cada subpanel
            itemPanel.add(new JLabel(clasificacion.toString()));
            main.add(itemPanel,gbc);
        }

        JScrollPane scroll=new JScrollPane(main);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        ventana.add(scroll,gbc);



        ventana.revalidate();
        ventana.repaint();
        ventana.setVisible(true);
    }
}
