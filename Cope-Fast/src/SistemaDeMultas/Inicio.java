/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaDeMultas;


import java.awt.List;
import java.text.ParseException;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Kevin
 */
public class Inicio extends javax.swing.JFrame {

    private Multas transporte;
    private DefaultTableModel modelo = new DefaultTableModel();

    
    
    private void Bus(){
        String conductor =txtConductor.getText();
        transporte.setConductor(conductor);
//        String marca = cmbMarca.getSelectedItem().toString();
       // transporte.setMarca(Tipo_Multa.valueOf(marca));
    }
    private void Guardar(){
        if(transporte.Archivar()){
            JOptionPane.showMessageDialog(this,
                    "Guardado exitosamente", 
                    "OK", 
                    JOptionPane.INFORMATION_MESSAGE);            
        }
        else{
            JOptionPane.showMessageDialog(this,
                    "Error al guardar", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);            
        }
    }
  
   private void DefinirCosto(int indice){
       switch(indice){
           case 0: //Uniforme
               snnCosto.setValue(10f);
               break;
           case 1://No respeta el orden de llegada
               snnCosto.setValue(15f);
               break;
           case 2: //Comportamiento
               snnCosto.setValue(20f);
               break;
           case 3: //Tambillo - Machahi
               snnCosto.setValue(0.50f);
               break;
           case 4: //Tambillo - Latacunga
               snnCosto.setValue(1.75f);
               break;    
           case 5: //Machahi - Latacunga
               snnCosto.setValue(1.50f);
               break;     
       }
   }
    
    private void IniciarModeloTabla(){
        modelo.addColumn("Nº");
        modelo.addColumn("Nombre");
        modelo.addColumn("Ruta");
        modelo.addColumn("Costo");
    }
   /* private void CargarMarcas(){
        Tipo_Multa[] marcas = Tipo_Multa.values();
        for(Tipo_Multa m : marcas){
            cmbMarca.addItem(m.toString());
        }
    }
    /*private boolean ValidarAsiento(){
        List<Pasajeros> list = transporte.getPasajero();
        int t = list.size();
        for (int i = 0; i < t; i++) {
            Multado pas = list.get(i);
            if(pas.getAniesto()==(int)spnCapacidad.getValue()){
                return true;
            }
        }
        return false;
    }*/
    private boolean ValidadarMultado(){
        String mensaje = "";
        if(txtNombrePasajero.getText().isEmpty()){
          mensaje += "Debe ingresar el nombre del multado\n";  
        }
        if(mensaje.isEmpty()){
            return true;
        }
        JOptionPane.showMessageDialog(this, mensaje,"Error",JOptionPane.ERROR_MESSAGE);
        return true;
    }
    private boolean ValidarRegistraMulta(){
        String mensaje = "";
        if(txtConductor.getText().isEmpty()){
          mensaje += "Debe ingresar el nombre de quien registra la multa\n";  
        }
        if(mensaje.isEmpty()){
            return true;
        }
        JOptionPane.showMessageDialog(this, mensaje,"Error",JOptionPane.ERROR_MESSAGE);
        return true;
    }
    private void AgregarPasajero(){
        if(this.ValidadarMultado()){
            Multado p = new Multado();
            p.setNombre(txtNombrePasajero.getText());
            p.setRuta(cmbRuta.getSelectedItem().toString());
            p.setAniesto((int)snnNAsiento.getValue());
            p.setCosto((float) snnCosto.getValue());
            
            transporte.getPasajero().add(p);
            Object[] fila = new Object[]{
                p.getAniesto(),
                p.getNombre(),
                p.getRuta(),
                p.getCosto(),
            };
            modelo.addRow(fila);
            tblPasajeros.setModel(modelo);
            this.VisualizarCapacidad();
            }
        
        }
    private void RegistrarUnidad(){
        transporte.setCapacidad((int)spnCapacidad.getValue());
       // transporte.setNumero((int)spnNumeroBus.getValue());
    }
    
    private void VisualizarCapacidad(){
        float valor = transporte.CalcularPorcentajeDeUso();
        this.pbCapacidad.setValue((int)valor);
    }
    private boolean validarpb(){
         if (pbCapacidad.getValue()==100) {
            JOptionPane.showMessageDialog(this, "Todas las multas registradas","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }else{
            this.AgregarPasajero();
         }
         return true;
    }
    
  
    
    /**
     * Creates new form Inicio
     */
    public Inicio() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PnlMultas = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtConductor = new javax.swing.JTextField();
        spnCapacidad = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtNombrePasajero = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        snnNAsiento = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPasajeros = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        snnCosto = new javax.swing.JSpinner();
        btnAgregarPasajero = new javax.swing.JButton();
        pbCapacidad = new javax.swing.JProgressBar();
        cmbRuta = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mniGuardar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(603, 626));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        PnlMultas.setBackground(new java.awt.Color(255, 255, 255));
        PnlMultas.setMaximumSize(new java.awt.Dimension(603, 626));
        PnlMultas.setMinimumSize(new java.awt.Dimension(603, 626));

        jLabel1.setFont(new java.awt.Font("Trajan Pro", 0, 24)); // NOI18N
        jLabel1.setText("Multas");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registro de multa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 11))); // NOI18N

        jLabel4.setText("Nombre de quien registra la multa");

        spnCapacidad.setModel(new javax.swing.SpinnerNumberModel(1, 1, 72, 1));

        jLabel9.setText("Numero de Multas a Registrar");

        btnRegistrar.setText("Guardar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtConductor, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                        .addComponent(btnRegistrar)
                        .addGap(20, 20, 20))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(23, 23, 23)
                        .addComponent(spnCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(spnCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtConductor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegistrar)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Multado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 11))); // NOI18N

        jLabel5.setText("Nombre:");

        jLabel6.setText("Unidad");

        snnNAsiento.setModel(new javax.swing.SpinnerNumberModel(1, 1, 72, 1));
        snnNAsiento.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                snnNAsientoStateChanged(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        tblPasajeros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblPasajeros);

        jLabel7.setText("Tipo de Multa");

        jLabel8.setText("Costo por la multa");

        snnCosto.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(0.5f), Float.valueOf(0.5f), Float.valueOf(27.0f), Float.valueOf(0.1f)));

        btnAgregarPasajero.setText("Add");
        btnAgregarPasajero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPasajeroActionPerformed(evt);
            }
        });

        cmbRuta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Uniforme", "No Respeta el orden de llegada", "Comportamiento" }));
        cmbRuta.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbRutaItemStateChanged(evt);
            }
        });
        cmbRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbRutaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNombrePasajero, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(cmbRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAgregarPasajero)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(snnNAsiento)
                                .addComponent(snnCosto, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
                            .addComponent(pbCapacidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNombrePasajero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(snnNAsiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(snnCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(btnAgregarPasajero)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(pbCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PnlMultasLayout = new javax.swing.GroupLayout(PnlMultas);
        PnlMultas.setLayout(PnlMultasLayout);
        PnlMultasLayout.setHorizontalGroup(
            PnlMultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 603, Short.MAX_VALUE)
            .addGroup(PnlMultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PnlMultasLayout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addGroup(PnlMultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlMultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlMultasLayout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addGap(221, 221, 221)))
                    .addGap(16, 16, 16)))
        );
        PnlMultasLayout.setVerticalGroup(
            PnlMultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 626, Short.MAX_VALUE)
            .addGroup(PnlMultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PnlMultasLayout.createSequentialGroup()
                    .addGap(32, 32, 32)
                    .addComponent(jLabel1)
                    .addGap(14, 14, 14)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(33, Short.MAX_VALUE)))
        );

        jMenu1.setText("File");

        mniGuardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        mniGuardar.setText("Guardar");
        mniGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniGuardarActionPerformed(evt);
            }
        });
        jMenu1.add(mniGuardar);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(PnlMultas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(PnlMultas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
      transporte = new Multas();
      IniciarModeloTabla();
    //  CargarMarcas();
    }//GEN-LAST:event_formWindowOpened

    private void btnAgregarPasajeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPasajeroActionPerformed
        
        this.validarpb();
       

        
    }//GEN-LAST:event_btnAgregarPasajeroActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        this.RegistrarUnidad();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void snnNAsientoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_snnNAsientoStateChanged
      
    }//GEN-LAST:event_snnNAsientoStateChanged

    private void cmbRutaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbRutaItemStateChanged
      DefinirCosto(cmbRuta.getSelectedIndex());
        
        
    }//GEN-LAST:event_cmbRutaItemStateChanged

    private void mniGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniGuardarActionPerformed
        if (this.ValidadarMultado()) {
//            this.CargarMarcas();
            this.Bus();
            this.Guardar();
        }
        
       
    }//GEN-LAST:event_mniGuardarActionPerformed

    private void cmbRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbRutaActionPerformed
        
    }//GEN-LAST:event_cmbRutaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PnlMultas;
    private javax.swing.JButton btnAgregarPasajero;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cmbRuta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem mniGuardar;
    private javax.swing.JProgressBar pbCapacidad;
    private javax.swing.JSpinner snnCosto;
    private javax.swing.JSpinner snnNAsiento;
    private javax.swing.JSpinner spnCapacidad;
    private javax.swing.JTable tblPasajeros;
    private javax.swing.JTextField txtConductor;
    private javax.swing.JTextField txtNombrePasajero;
    // End of variables declaration//GEN-END:variables
}
