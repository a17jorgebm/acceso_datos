package com.pepinho.ad.biblioteca.view;

import com.pepinho.ad.biblioteca.controller.IBookController;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Vista de libros. Muestra los datos de un libro.
 * Interfaz gráfica hecha en Java Swing.
 * Tiene una referencia a un objeto IBookController.
 * Una portada, un titulo, un autor, un ISBN, un año de publicacion y el id.
 * Además, dos botones para avanzar, retorceder y actualizar los datos
 *
 * @version 1.1.0
 * @see BookView
 * @since 1.1.0
 */
public class BookView extends JFrame implements IBookView {

    private IBookController bookControler;

    private JLabel portada = new JLabel();

    private JLabel lbTituloGrande = new JLabel("Título");

    private JTextField tfTitle = new JTextField();
    private JTextField tfAuthor = new JTextField();

    private JTextField tfYear = new JTextField();

    private JTextField tfISBN = new JTextField();

    private JCheckBox jcbAvailable = new JCheckBox("Disponible");
    JLabel lblID = new JLabel("0");

    private JButton bntPrevious = new JButton("< Anterior");
    private JButton bntNext = new JButton("Siguiente >");

    JFileChooser fc = new JFileChooser("E:\\98 - Bases de datos\\biblioteca\\bookscovers");


    /**
     * Creates new form BookView
     */
    public BookView(IBookController bookControler) {
        this.bookControler = bookControler;
        this.bookControler.setView(this);
        initComponents();
        this.bookControler.getBook(bookControler.getFirstId());
        enableButtons();
    }

    private void initComponents() {

        portada.setPreferredSize(new Dimension(329, 499));

        JPanel panelInferior = new JPanel();


        JPanel panelCentral = new JPanel();

        JLabel lblTitle = new JLabel("Título:");
        JLabel lblAuthor = new JLabel("Autor:");


        JLabel lblYear = new JLabel("Año:");
        JLabel lblISBN = new JLabel("ISBN:");


        JButton bntUpdate = new JButton("Actualizar");
        bntUpdate.addActionListener(e -> {

            if (JOptionPane.showConfirmDialog(this, "Estás seguro que quieres actualizar el libro",
                    "Actualización", JOptionPane.OK_CANCEL_OPTION)
                    == JOptionPane.OK_OPTION)
                bookControler.updateBook(Long.parseLong(lblID.getText()), tfTitle.getText(),
                        tfAuthor.getText(), tfISBN.getText(),
                        Short.parseShort(tfYear.getText()),
                        jcbAvailable.isSelected(), getCoverBytes());
        });
        JButton bntDelete = new JButton("Eliminar");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Biblioteca");

        jcbAvailable.setActionCommand("jcbDisponible");
        panelInferior.add(jcbAvailable);
        panelInferior.add(bntPrevious);

        bntPrevious.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookControler.getBook(bookControler.getPreviousId(Integer.parseInt(lblID.getText())));
                enableButtons();
            }
        });

        panelInferior.add(bntNext);
        bntNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookControler.getBook(bookControler.getNextId(Integer.parseInt(lblID.getText())));
                enableButtons();
            }
        });

        panelInferior.add(lblID);

        getContentPane().add(panelInferior, BorderLayout.PAGE_END);


        tfTitle.addActionListener(evt -> {
        });


        tfAuthor.addActionListener(evt -> {
        });

        tfYear.addActionListener(evt -> {
//                tfYearActionPerformed(evt);
        });


        tfISBN.addActionListener(evt -> {
//                tfISBNActionPerformed(evt);
        });

        lbTituloGrande.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
        lbTituloGrande.setHorizontalAlignment(SwingConstants.CENTER);

        portada.addMouseListener(new MouseAdapter() {
                                     @Override
                                     public void mouseClicked(MouseEvent e) {
                                         super.mouseClicked(e);
                                         if (e.getClickCount() == 2) {
                                             File f = selectPortada();
                                             try {
                                                 byte[] cover = Files.readAllBytes(f.toPath());
                                                 setCover(cover);
                                                 bookControler.updateBook(Long.parseLong(lblID.getText()), tfTitle.getText(),
                                                         tfAuthor.getText(), tfISBN.getText(),
                                                         Short.parseShort(tfYear.getText()),
                                                         jcbAvailable.isSelected(), cover);
                                             } catch (IOException ex) {
                                                 System.out.println("Erro ó ler o arquivo");
                                             }
                                         }
                                     }
                                 }
        );


        GroupLayout panelCentralLayout = new GroupLayout(panelCentral);
        panelCentral.setLayout(panelCentralLayout);
        panelCentralLayout.setHorizontalGroup(
                panelCentralLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelCentralLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(portada, GroupLayout.PREFERRED_SIZE, 329, GroupLayout.PREFERRED_SIZE)
                                .addGroup(panelCentralLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(panelCentralLayout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addGroup(panelCentralLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(panelCentralLayout.createSequentialGroup()
                                                                .addGroup(panelCentralLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(lblAuthor, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(lblYear, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(panelCentralLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(tfAuthor, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                                                                        .addGroup(panelCentralLayout.createSequentialGroup()
                                                                                .addComponent(tfYear, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(0, 0, Short.MAX_VALUE))))
                                                        .addGroup(panelCentralLayout.createSequentialGroup()
                                                                .addComponent(lblISBN, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(tfISBN))
                                                        .addGroup(panelCentralLayout.createSequentialGroup()
                                                                .addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(tfTitle))
                                                        .addGroup(panelCentralLayout.createSequentialGroup()
                                                                .addGap(15, 15, 15)
                                                                .addComponent(bntUpdate)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(bntDelete)
                                                                .addGap(0, 0, Short.MAX_VALUE))))
                                        .addGroup(panelCentralLayout.createSequentialGroup()
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lbTituloGrande, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        panelCentralLayout.setVerticalGroup(
                panelCentralLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelCentralLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(panelCentralLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(portada, GroupLayout.PREFERRED_SIZE, 499, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(panelCentralLayout.createSequentialGroup()
                                                .addComponent(lbTituloGrande, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addGroup(panelCentralLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lblTitle)
                                                        .addComponent(tfTitle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(panelCentralLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lblAuthor)
                                                        .addComponent(tfAuthor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(panelCentralLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(tfYear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblYear))
                                                .addGap(18, 18, 18)
                                                .addGroup(panelCentralLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lblISBN)
                                                        .addComponent(tfISBN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(panelCentralLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(bntUpdate)
                                                        .addComponent(bntDelete))))
                                .addContainerGap(17, Short.MAX_VALUE))
        );

        getContentPane().add(panelCentral, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }


    @Override
    public void setBookTitle(String title) {
        tfTitle.setText(title);
        lbTituloGrande.setText(title);
    }

    @Override
    public void setAuthor(String author) {
        tfAuthor.setText(author);
    }

    @Override
    public void setISBN(String isbn) {
        tfISBN.setText(isbn);
    }

    @Override
    public void setYear(int year) {
        tfYear.setText(String.valueOf(year));
    }

    @Override
    public void setAvailable(boolean available) {
        jcbAvailable.setSelected(available);
    }

    @Override
    public void setCover(byte[] cover) {
        if (cover == null)
            return;
        Image image = (new ImageIcon(cover)).getImage();
        Image newimg = image.getScaledInstance(329, 499, Image.SCALE_SMOOTH);
        portada.setIcon(new ImageIcon(newimg));
//        portada.setIcon(new ImageIcon(cover));
    }

    public byte[] getCoverBytes() {
        // Obtener la imagen del JLabel
        ImageIcon icon = (ImageIcon) portada.getIcon();
        BufferedImage bufferedImage = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(),
                BufferedImage.TYPE_INT_ARGB);
        // Pintar la imagen en el BufferedImage
        icon.paintIcon(this, bufferedImage.getGraphics(), 0, 0);
        // Convertir el BufferedImage a un array de bytes
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(bufferedImage, "png", baos);
        } catch (IOException e) {
            return null;
        }
        return baos.toByteArray();
    }

    @Override
    public void setID(long id) {
        lblID.setText(String.valueOf(id));
    }

    private void enableButtons() {
        if (bookControler.isFirstBook(Integer.parseInt(lblID.getText())))
            bntPrevious.setEnabled(false);
        else
            bntPrevious.setEnabled(true);
        if (bookControler.isLastBook(Integer.parseInt(lblID.getText())))
            bntNext.setEnabled(false);
        else
            bntNext.setEnabled(true);
    }

    private File selectPortada() {
        fc.setFileFilter(new FileNameExtensionFilter(
                "Imágenes JPG y GIF", "jpg", "gif"));
        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            return fc.getSelectedFile();
        }
        return null;
    }
}
