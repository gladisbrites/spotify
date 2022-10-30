package vistas;
import java.awt.*;
import javax.swing.*;
import modelo.*;

public class Principal extends javax.swing.JFrame {

    private FormularioArtistas artForm = null;
    private FormularioAlbumes albForm = null;
    private FormularioDiscograficas disForm = null;
    private Spotify s;

    public Principal(Spotify s) {
        this.s = s;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane(){
            ImageIcon icon = new ImageIcon("src\\imagenes\\logo.png");
            Image image = icon.getImage();

            Image newimage = image.getScaledInstance(495, 168, Image.SCALE_SMOOTH);

            @Override
            protected void paintComponent(Graphics g)
            {
                super.paintComponent(g);
                g.drawImage(newimage, 2, 141, this);
            }
        };
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        omiArtistas = new javax.swing.JMenuItem();
        omiAlbumes = new javax.swing.JMenuItem();
        omiDiscograficas = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(515, 500));
        setResizable(false);

        fileMenu.setMnemonic('f');
        fileMenu.setText("Datos");

        omiArtistas.setMnemonic('o');
        omiArtistas.setText("Artistas");
        omiArtistas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formularioArtistas(evt);
            }
        });
        fileMenu.add(omiArtistas);

        omiAlbumes.setMnemonic('o');
        omiAlbumes.setText("Álbumes");
        omiAlbumes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formularioAlbumes(evt);
            }
        });
        fileMenu.add(omiAlbumes);

        omiDiscograficas.setMnemonic('o');
        omiDiscograficas.setText("Discograficas");
        omiDiscograficas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formularioDiscograficas(evt);
            }
        });
        fileMenu.add(omiDiscograficas);

        menuBar.add(fileMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formularioAlbumes(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formularioAlbumes
        if (albForm == null || albForm.isClosed()) {
            albForm = new FormularioAlbumes(s);
            this.desktopPane.add(albForm);
        }
        
        albForm.setVisible(true);
    }//GEN-LAST:event_formularioAlbumes

    private void formularioArtistas(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formularioArtistas
        if (artForm == null || artForm.isClosed()) {
            artForm = new FormularioArtistas(s);
            this.desktopPane.add(artForm);
        }
        
        artForm.setVisible(true);
    }//GEN-LAST:event_formularioArtistas

    private void formularioDiscograficas(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formularioDiscograficas
        if (disForm == null || disForm.isClosed()) {
            disForm = new FormularioDiscograficas(s);
            this.desktopPane.add(disForm);
        }
        
        disForm.setVisible(true);
    }//GEN-LAST:event_formularioDiscograficas

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem omiAlbumes;
    private javax.swing.JMenuItem omiArtistas;
    private javax.swing.JMenuItem omiDiscograficas;
    // End of variables declaration//GEN-END:variables

}