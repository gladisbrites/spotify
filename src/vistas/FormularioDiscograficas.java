package vistas;

import modelo.*;

public class FormularioDiscograficas extends javax.swing.JInternalFrame {

    Spotify s;

    public FormularioDiscograficas(Spotify s) {
        this.s = s;
        initComponents();
        this.lstDiscograficas.setListData(this.s.getDiscograficas().toArray());
        
        for (Artista a : this.s.getArtistas())
            this.cmbArtistas.addItem(a);
        
        this.cmbArtistas.setSelectedItem(null);
        this.btnAgregarArtista.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstDiscograficas = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblArtistas = new javax.swing.JLabel();
        cmbArtistas = new javax.swing.JComboBox<>();
        btnAgregarArtista = new javax.swing.JButton();

        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setClosable(true);
        setTitle("Gesti�n de discogr�ficas");

        lstDiscograficas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstDiscograficas.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                discograficaSeleccionada(evt);
            }
        });
        jScrollPane1.setViewportView(lstDiscograficas);

        jLabel1.setText("Nombre");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarDiscografica(evt);
            }
        });

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevaDiscografica(evt);
            }
        });

        btnEliminar.setText("Eliminar");

        jLabel2.setText("Artistas");

        lblArtistas.setBackground(new java.awt.Color(0, 0, 0));
        lblArtistas.setForeground(new java.awt.Color(255, 255, 255));
        lblArtistas.setOpaque(true);

        btnAgregarArtista.setText("Agregar");
        btnAgregarArtista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarArtista(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnGuardar)
                                .addGap(12, 12, 12)
                                .addComponent(btnEliminar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(lblArtistas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmbArtistas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAgregarArtista)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnNuevo)
                    .addComponent(btnEliminar))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblArtistas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbArtistas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarArtista))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void guardarDiscografica(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarDiscografica
        // si la lista est� vac�a
        if (this.lstDiscograficas.isSelectionEmpty()) {
            this.s.crearDiscografica(this.txtNombre.getText());
        } else {
            Discografica d = (Discografica) this.lstDiscograficas.getSelectedValue();                
            this.s.modificarDiscografica(d, this.txtNombre.getText());
        }

        limpiar();
    }//GEN-LAST:event_guardarDiscografica

    private void nuevaDiscografica(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevaDiscografica
        limpiar();
    }//GEN-LAST:event_nuevaDiscografica

    private void discograficaSeleccionada(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_discograficaSeleccionada
        // verificamos que la lista tenga un item seleccionado
        if (! this.lstDiscograficas.isSelectionEmpty()) {
            // obtengo el item seleccionado
            Discografica d = (Discografica) this.lstDiscograficas.getSelectedValue();
            // asigno los valores de los atributos a las caja de texto
            this.txtNombre.setText( d.getNombre() );
            this.lblArtistas.setText( d.getArtistas().toString() );
            this.btnAgregarArtista.setEnabled(true);
        } else {
            this.btnAgregarArtista.setEnabled(false);
        }
        
    }//GEN-LAST:event_discograficaSeleccionada

    private void agregarArtista(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarArtista
        Artista a = (Artista) this.cmbArtistas.getSelectedItem();
        Discografica d = (Discografica) this.lstDiscograficas.getSelectedValue();
        this.s.relacionar(a, d);
        
        Spotify.getPersistencia().refrescar(this.s);
        this.lblArtistas.setText( d.getArtistas().toString() );
    }//GEN-LAST:event_agregarArtista

    private void limpiar() {
        // limpio las cajas de texto
        this.txtNombre.setText("");
        this.lblArtistas.setText("");
        this.cmbArtistas.setSelectedItem(null);
        System.out.println("Refrescar...");
        Spotify.getPersistencia().refrescar(this.s);
        System.out.println("Refrescado");
        // pueblo la lista
        this.lstDiscograficas.setListData(this.s.getDiscograficas().toArray());        
        // deselecciono la lista
        this.lstDiscograficas.clearSelection();          
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarArtista;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<Artista> cmbArtistas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblArtistas;
    private javax.swing.JList lstDiscograficas;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
