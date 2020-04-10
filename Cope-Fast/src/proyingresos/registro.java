/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyingresos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author matgr
 */
public class registro extends javax.swing.JFrame {

    /**
     * Creates new form registro
     */
    DefaultTableModel modelo = new DefaultTableModel();

    public registro() {
        initComponents();
        txtId.setVisible(false);
        try {
            tablausuarios.setModel(modelo);
            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion conn = new Conexion();
            java.sql.Connection con = conn.getConexion();

            String sql = "SELECT cedula, nombre, telefono, tipo_socio,fecha_nacimiento,disco,estado FROM tabla_registro";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("Cedula");
            modelo.addColumn("Nombre");
            modelo.addColumn("Telefono");
            modelo.addColumn("Tipo chofer");
            modelo.addColumn("Fecha de nacimiento");
            modelo.addColumn("Disco");
            modelo.addColumn("Estado");

            int[] anchos = {70, 100, 70, 100, 50, 25, 50};
            for (int i = 0; i < tablausuarios.getColumnCount(); i++) {
                tablausuarios.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
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
        JTPusuarios = new javax.swing.JTabbedPane();
        JPNregistrar = new javax.swing.JPanel();
        lblCedula = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        LBLltipoChofer = new javax.swing.JLabel();
        lblDisco = new javax.swing.JLabel();
        lblFechaNac = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        txtnac = new javax.swing.JTextField();
        txtdisco = new javax.swing.JTextField();
        txtcedula = new javax.swing.JTextField();
        cbochofer = new javax.swing.JComboBox<>();
        JBTguardar = new javax.swing.JButton();
        lblFechaNac1 = new javax.swing.JLabel();
        txttelefono = new javax.swing.JTextField();
        LBLltipoChofer1 = new javax.swing.JLabel();
        cboestado = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txtClave = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();
        Modificar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        JPNbuscar = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablausuarios = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        LBLusuarios = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        JPNregistrar.setBackground(new java.awt.Color(255, 255, 255));

        lblCedula.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        lblCedula.setText("#Cédula:");

        jLabel3.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jLabel3.setText("Nombre:");

        LBLltipoChofer.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        LBLltipoChofer.setText("Tipo chofer:");

        lblDisco.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        lblDisco.setText("#Disco:");

        lblFechaNac.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        lblFechaNac.setText("Fecha Nacimiento:");

        txtnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreActionPerformed(evt);
            }
        });

        txtnac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnacActionPerformed(evt);
            }
        });

        txtdisco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdiscoActionPerformed(evt);
            }
        });

        txtcedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcedulaActionPerformed(evt);
            }
        });

        cbochofer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona", "socio", "chofer" }));

        JBTguardar.setText("Registrar");
        JBTguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTguardarActionPerformed(evt);
            }
        });

        lblFechaNac1.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        lblFechaNac1.setText("Telefono:");

        txttelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttelefonoActionPerformed(evt);
            }
        });

        LBLltipoChofer1.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        LBLltipoChofer1.setText("Estado:");

        cboestado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona", "Activo", "Suspendido", "Jubilado" }));

        jLabel1.setText("Ingrese el numero de cedula del usuario:");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        txtId.setBackground(java.awt.SystemColor.control);
        txtId.setForeground(new java.awt.Color(255, 255, 255));
        txtId.setCaretColor(new java.awt.Color(255, 255, 255));
        txtId.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtId.setEnabled(false);

        Modificar.setText("Modificar");
        Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarActionPerformed(evt);
            }
        });

        eliminar.setText("Dar de baja");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JPNregistrarLayout = new javax.swing.GroupLayout(JPNregistrar);
        JPNregistrar.setLayout(JPNregistrarLayout);
        JPNregistrarLayout.setHorizontalGroup(
            JPNregistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPNregistrarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBuscar)
                .addGap(87, 87, 87))
            .addGroup(JPNregistrarLayout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(JBTguardar)
                .addGap(59, 59, 59)
                .addComponent(Modificar)
                .addGap(76, 76, 76)
                .addComponent(eliminar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(JPNregistrarLayout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addGroup(JPNregistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFechaNac)
                    .addComponent(lblFechaNac1)
                    .addComponent(lblCedula)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LBLltipoChofer)
                    .addComponent(lblDisco)
                    .addComponent(LBLltipoChofer1))
                .addGap(93, 93, 93)
                .addGroup(JPNregistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcedula, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnac, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbochofer, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdisco, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboestado, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );
        JPNregistrarLayout.setVerticalGroup(
            JPNregistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPNregistrarLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(JPNregistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76)
                .addGroup(JPNregistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(JPNregistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(JPNregistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPNregistrarLayout.createSequentialGroup()
                        .addGroup(JPNregistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFechaNac1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(JPNregistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(JPNregistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbochofer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LBLltipoChofer, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(59, 59, 59))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPNregistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblDisco, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtdisco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36)
                .addGroup(JPNregistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LBLltipoChofer1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(79, 79, 79)
                .addGroup(JPNregistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBTguardar)
                    .addComponent(Modificar)
                    .addComponent(eliminar))
                .addContainerGap(78, Short.MAX_VALUE))
        );

        JTPusuarios.addTab("Registrar", JPNregistrar);

        JPNbuscar.setBackground(new java.awt.Color(255, 255, 255));

        tablausuarios.setModel(new javax.swing.table.DefaultTableModel(
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
        tablausuarios.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(tablausuarios);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Registro Usuarios");

        javax.swing.GroupLayout JPNbuscarLayout = new javax.swing.GroupLayout(JPNbuscar);
        JPNbuscar.setLayout(JPNbuscarLayout);
        JPNbuscarLayout.setHorizontalGroup(
            JPNbuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPNbuscarLayout.createSequentialGroup()
                .addGroup(JPNbuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPNbuscarLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JPNbuscarLayout.createSequentialGroup()
                        .addGap(269, 269, 269)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        JPNbuscarLayout.setVerticalGroup(
            JPNbuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPNbuscarLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        JTPusuarios.addTab("Tabla Registro", JPNbuscar);

        LBLusuarios.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        LBLusuarios.setText("Usuarios");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(258, 258, 258)
                        .addComponent(LBLusuarios))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(JTPusuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 689, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LBLusuarios)
                .addGap(18, 18, 18)
                .addComponent(JTPusuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 704, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(121, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 765, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreActionPerformed

    private void txtnacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnacActionPerformed

    private void txtdiscoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdiscoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdiscoActionPerformed

    private void txtcedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcedulaActionPerformed
        
    }//GEN-LAST:event_txtcedulaActionPerformed

    private void JBTguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTguardarActionPerformed
        
        PreparedStatement ps = null;
        String comp = txtId.getText();
        //int Fila = tablausuarios.getSelectedRow();
        System.out.println(comp);
        if ("".equals(comp)) {
            comp = ".";
        }
        if ((comp.equals(txtcedula.getText()))) {
            JOptionPane.showMessageDialog(null, "El usuario ya se encuentra registrado");
        } else {

            try {
                Conexion objCon = new Conexion();
                Connection conn = objCon.getConexion();
                ps = conn.prepareStatement("INSERT INTO registro (cedula, nombre, telefono, tipo_socio,fecha_nacimiento,disco,estado) VALUES (?,?,?,?,?,?,?)");
                ps.setString(1, txtcedula.getText());
                ps.setString(2, txtnombre.getText());

                ps.setString(3, txttelefono.getText());
                ps.setString(4, cbochofer.getSelectedItem().toString());
                ps.setString(5, txtnac.getText());
                ps.setString(6, txtdisco.getText());
                ps.setString(7, cboestado.getSelectedItem().toString());

                ps.execute();
              Object[] fila = new Object[7];
                 fila[0] = txtcedula.getText();
            fila[1] = txtnombre.getText();
            fila[2] = txttelefono.getText();
            fila[3] = cbochofer.getSelectedItem().toString();
            fila[4] = txtnac.getText();
            fila[5] = txtdisco.getText();
            fila[6] = cboestado.getSelectedItem().toString();
                modelo.addRow(fila);
                JOptionPane.showMessageDialog(null, "Usuario Registrado");
                // limpiar();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al registrar usuario");
                System.out.println(ex);
            }
            try {
                Conexion objCon = new Conexion();
                Connection conn = objCon.getConexion();
                ps = conn.prepareStatement("INSERT INTO tabla_registro (cedula, nombre, telefono, tipo_socio,fecha_nacimiento,disco,estado) VALUES (?,?,?,?,?,?,?)");
                ps.setString(1, txtcedula.getText());
                ps.setString(2, txtnombre.getText());

                ps.setString(3, txttelefono.getText());
                ps.setString(4, cbochofer.getSelectedItem().toString());
                ps.setString(5, txtnac.getText());
                ps.setString(6, txtdisco.getText());
                ps.setString(7, cboestado.getSelectedItem().toString());
                
                ps.execute();

                //JOptionPane.showMessageDialog(null, "Usuario Registrado");
               
               
            limpiar();
            } catch (SQLException ex) {
                //JOptionPane.showMessageDialog(null, "Error al registrar usuario");
                System.out.println(ex);
            }
            

        }

    }//GEN-LAST:event_JBTguardarActionPerformed

    private void txttelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttelefonoActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion conn = new Conexion();

        try {

            java.sql.Connection con = conn.getConexion();
            ps = con.prepareStatement("SELECT * FROM registro WHERE cedula = ?");
            ps.setString(1, txtClave.getText());

            rs = ps.executeQuery();

            if (rs.next()) {
                txtcedula.setText(rs.getString("cedula"));
                txtnombre.setText(rs.getString("nombre"));
                txttelefono.setText(rs.getString("telefono"));
                cboestado.setSelectedItem(rs.getString("estado"));
                cbochofer.setSelectedItem(rs.getString("tipo_socio"));
                txtnac.setText(rs.getString("fecha_nacimiento"));
                txtdisco.setText(rs.getString("disco"));
                txtId.setText(txtClave.getText());

            } else {
                JOptionPane.showMessageDialog(null, "Usuario no encontrado");
            }

        } catch (Exception e) {
            System.err.println(e);
        }

        txtClave.setText("");

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarActionPerformed
        // Conexion conn = new Conexion();
        PreparedStatement ps = null;
        int Fila = tablausuarios.getSelectedRow();
        try {
            Conexion objCon = new Conexion();
            com.mysql.jdbc.Connection conn = objCon.getConexion();

            ps = conn.prepareStatement("UPDATE registro SET nombre=?, telefono=?,tipo_socio =?,fecha_nacimiento=?, disco=?, estado=? WHERE cedula=?");
            ps.setString(1, txtnombre.getText());
            ps.setString(2, txttelefono.getText());
            ps.setString(3, cbochofer.getSelectedItem().toString());
            ps.setString(4, txtnac.getText());
            ps.setString(5, txtdisco.getText());
            ps.setString(6, cboestado.getSelectedItem().toString());
            ps.setString(7, txtcedula.getText());
            int res = ps.executeUpdate();

            if (res > 0) {
                tablausuarios.setValueAt(txtcedula.getText(), Fila, 0);
                tablausuarios.setValueAt(txtnombre.getText(), Fila, 1);
                tablausuarios.setValueAt(txttelefono.getText(), Fila, 2);
                tablausuarios.setValueAt(cbochofer.getSelectedItem().toString(), Fila, 3);
                tablausuarios.setValueAt(txtnac.getText(), Fila, 4);
                tablausuarios.setValueAt(txtdisco.getText(), Fila, 5);
                tablausuarios.setValueAt(cboestado.getSelectedItem().toString(), Fila, 6);
                JOptionPane.showMessageDialog(null, "Usuario Modificado");
                // limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Modificar usuario");
                //   limpiar();
            }

            conn.close();

        } catch (Exception e) {
            System.err.println(e);
        }
        try {
            Conexion objCon = new Conexion();
            com.mysql.jdbc.Connection conn = objCon.getConexion();

            ps = conn.prepareStatement("UPDATE tabla_registro SET nombre=?,telefono=?,tipo_socio =?,fecha_nacimiento=?, disco=?, estado=? WHERE cedula=?");
            ps.setString(1, txtnombre.getText());
            ps.setString(2, txttelefono.getText());
            ps.setString(3, cbochofer.getSelectedItem().toString());
            ps.setString(4, txtnac.getText());
            ps.setString(5, txtdisco.getText());
            ps.setString(6, cboestado.getSelectedItem().toString());
            ps.setString(7, txtcedula.getText());
            int res = ps.executeUpdate();

            if (res > 0) {
                //JOptionPane.showMessageDialog(null, "Usuario Modificado");
                limpiar();
            } else {
                // JOptionPane.showMessageDialog(null, "Error al Modificar usuario");
                limpiar();
            }

            conn.close();

        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_ModificarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        PreparedStatement ps = null;
        // txtId.setText("");
        int Fila = tablausuarios.getSelectedRow();
        String comp = txtId.getText();
        try {

            Conexion objCon = new Conexion();
            com.mysql.jdbc.Connection conn = objCon.getConexion();
            ps = conn.prepareStatement("DELETE FROM registro WHERE cedula=?");
            ps.setString(1, txtcedula.getText());
            ps.execute();
            if ("".equals(comp)) {
                JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun usuario");
            } else {
                JOptionPane.showMessageDialog(null, "Usuario Dado de baja");
                 tablausuarios.setValueAt(txtcedula.getText(), Fila, 0);
            tablausuarios.setValueAt(txtnombre.getText(), Fila, 1);
            tablausuarios.setValueAt(txttelefono.getText(), Fila, 2);
            tablausuarios.setValueAt(cbochofer.getSelectedItem().toString(), Fila, 3);
            tablausuarios.setValueAt(txtnac.getText(), Fila, 4);
            tablausuarios.setValueAt(txtdisco.getText(), Fila, 5);
            tablausuarios.setValueAt("Dado de baja", Fila, 6);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al dar de baja");
            System.out.println(ex.toString());
        }
        ps = null;
        try {
            Conexion objCon = new Conexion();
            com.mysql.jdbc.Connection conn = objCon.getConexion();

            ps = conn.prepareStatement("UPDATE tabla_registro SET nombre=?,telefono=?,tipo_socio =?,fecha_nacimiento=?, disco=?, estado=? WHERE cedula=?");
            ps.setString(1, txtnombre.getText());
            ps.setString(2, txttelefono.getText());
            ps.setString(3, cbochofer.getSelectedItem().toString());
            ps.setString(4, txtnac.getText());
            ps.setString(5, txtdisco.getText());
            ps.setString(6, "Dado de baja");
            ps.setString(7, txtcedula.getText());
            int res = ps.executeUpdate();
           
             
            if (res > 0) {
               limpiar();
            } else {
                // JOptionPane.showMessageDialog(null, "Error al Modificar usuario");
                limpiar();
            }

            conn.close();

        } catch (Exception e) {
            System.err.println(e);
        }
        limpiar();

    }//GEN-LAST:event_eliminarActionPerformed
    private void limpiar() {
        txtcedula.setText("");
        txtnombre.setText("");
        txttelefono.setText("");
        cboestado.setSelectedIndex(0);
        cbochofer.setSelectedIndex(0);
        txtnac.setText("");
        txtdisco.setText("");
        txtId.setText("");

    }

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
            java.util.logging.Logger.getLogger(registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBTguardar;
    private javax.swing.JPanel JPNbuscar;
    private javax.swing.JPanel JPNregistrar;
    private javax.swing.JTabbedPane JTPusuarios;
    private javax.swing.JLabel LBLltipoChofer;
    private javax.swing.JLabel LBLltipoChofer1;
    private javax.swing.JLabel LBLusuarios;
    private javax.swing.JButton Modificar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JComboBox<String> cbochofer;
    private javax.swing.JComboBox<String> cboestado;
    private javax.swing.JButton eliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblDisco;
    private javax.swing.JLabel lblFechaNac;
    private javax.swing.JLabel lblFechaNac1;
    private javax.swing.JTable tablausuarios;
    private javax.swing.JTextField txtClave;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtcedula;
    private javax.swing.JTextField txtdisco;
    private javax.swing.JTextField txtnac;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables
}
