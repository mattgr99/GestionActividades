/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyingresos;
import proyingresos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Kevin
 */
public class Multas extends javax.swing.JFrame {

    /**
     * Creates new form Multas
     */
     DefaultTableModel modelo = new DefaultTableModel();
    public Multas() {
        initComponents();
        try {
            jtmultas.setModel(modelo);
            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion conn = new Conexion();
            java.sql.Connection con = conn.getConexion();

            String sql = "SELECT cedula, nombre, motivo_multas, Valor_multas FROM multas";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("Cedula");
            modelo.addColumn("Nombre");
            modelo.addColumn("Motivo multa");
            modelo.addColumn("Valor multa");


            int[] anchos = {50, 100, 50, 150};
            for (int i = 0; i < jtmultas.getColumnCount(); i++) {
                jtmultas.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }

            while (rs.next()) {
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);
            }

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtmultas = new javax.swing.JTable();
        txtCampo = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        txtnombre = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtcedula1 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cbxmotiva = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtcostos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(765, 631));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("                 Multas");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 13, 192, 53));

        jLabel2.setText("Usuarios que se les ha registrado multas");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 134, 227, 26));

        jLabel3.setText("Ingrese la cedula del usuario ha registrar:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 250, 26));

        jtmultas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtmultas.setToolTipText("");
        jtmultas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtmultasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtmultas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 178, 395, 440));

        txtCampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCampoActionPerformed(evt);
            }
        });
        txtCampo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCampoKeyTyped(evt);
            }
        });
        jPanel1.add(txtCampo, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, 200, 30));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 80, -1, 30));

        txtnombre.setText("...");
        jPanel1.add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(535, 225, 218, 25));

        jLabel5.setText("Motivo:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 270, 90, 25));

        jLabel6.setText("Nombre:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(425, 225, 56, 25));

        jLabel8.setText("Cédula:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(425, 187, 56, 25));

        txtcedula1.setText("...");
        jPanel1.add(txtcedula1, new org.netbeans.lib.awtextra.AbsoluteConstraints(535, 187, 156, 25));

        btnGuardar.setText("Registrar Multa");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 410, 130, 40));

        jLabel4.setText("Datos usuario:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, 110, -1));

        cbxmotiva.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Uniforme", "No Respeta el orden de llegada", "Comportamiento" }));
        cbxmotiva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxmotivaActionPerformed(evt);
            }
        });
        jPanel1.add(cbxmotiva, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 270, 190, -1));

        jLabel7.setText("Valor de la multa:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 320, -1, -1));

        txtcostos.setText("...");
        jPanel1.add(txtcostos, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 320, 130, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtmultasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtmultasMouseClicked

    }//GEN-LAST:event_jtmultasMouseClicked

    private void txtCampoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCampoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCampoActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion conn = new Conexion();
        try{

            java.sql.Connection con = conn.getConexion();
            ps = con.prepareStatement("SELECT * FROM registro WHERE cedula = ?");
            ps.setString(1, txtCampo.getText());

            rs = ps.executeQuery();

            if(rs.next()){
                txtcedula1.setText(rs.getString("cedula"));
                txtnombre.setText(rs.getString("nombre"));

            } else {
                JOptionPane.showMessageDialog(null, "El usuario no se encuentra en el registro");
            }

        } catch(Exception e){
            System.err.println(e);
        }
        txtCampo.setText("");
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        PreparedStatement ps = null;
        try {
            Conexion objCon = new Conexion();
            Connection conn = objCon.getConexion();
            ps = conn.prepareStatement("INSERT INTO Multas (cedula, nombre, motivo_multas, Valor_multas) VALUES (?,?,?,?)");
            ps.setString(1, txtcedula1.getText());
            ps.setString(2, txtnombre.getText());
            ps.setString(3, cbxmotiva.getSelectedItem().toString());
           ps.setString(4, txtcostos.getText());
String l=txtcostos.getText();
            System.out.println(l);
            

            ps.execute();

            JOptionPane.showMessageDialog(null, "Multa registrada");
            Object[] fila = new Object[4];
            fila[0] = txtcedula1.getText();
            fila[1] = txtnombre.getText();
            
            fila[2] = cbxmotiva.getSelectedItem().toString();
            fila[3] = txtcostos.getText();
            modelo.addRow(fila);

            limpiar();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al Registrar multa");
            System.out.println(ex);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void cbxmotivaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxmotivaActionPerformed
 String comparar=cbxmotiva.getSelectedItem().toString();
            System.out.println(comparar);
            
            if ("Seleccione".equals(comparar)) {
                JOptionPane.showMessageDialog(null, "Seleccione un motivo");
            }
            if ("Uniforme".equals(comparar)) {
                txtcostos.setText("20.00");
                
            }
            if ("No Respeta el orden de llegada".equals(comparar)) {
                txtcostos.setText("25.00");
                
            }
            if ("Comportamiento".equals(comparar)) {
                txtcostos.setText("30.00");
                            }        
    }//GEN-LAST:event_cbxmotivaActionPerformed

    private void txtCampoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCampoKeyTyped

        
    }//GEN-LAST:event_txtCampoKeyTyped

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
            java.util.logging.Logger.getLogger(Multas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Multas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Multas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Multas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Multas().setVisible(true);
            }
        });
    }
public void contar(){
    int filas=jtmultas.getRowCount();
    
}
    private void limpiar(){
        txtcedula1.setText("");
        txtnombre.setText("");
        txtcostos.setText("");
        cbxmotiva.setSelectedIndex(0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cbxmotiva;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtmultas;
    private javax.swing.JTextField txtCampo;
    private javax.swing.JLabel txtcedula1;
    private javax.swing.JLabel txtcostos;
    private javax.swing.JLabel txtnombre;
    // End of variables declaration//GEN-END:variables
}
